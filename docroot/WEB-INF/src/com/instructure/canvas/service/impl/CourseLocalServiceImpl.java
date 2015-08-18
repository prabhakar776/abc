package com.instructure.canvas.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.cisco.utility.constants.CiscoConstants;
import com.instructure.canvas.model.Assignment;
import com.instructure.canvas.model.Award;
import com.instructure.canvas.model.Course;
import com.instructure.canvas.model.SubmissionVersion;
import com.instructure.canvas.model.impl.CourseImpl;
import com.instructure.canvas.service.AwardLocalServiceUtil;
import com.instructure.canvas.service.base.CourseLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasApiUtils;
import com.instructure.canvas.util.CanvasURLConnectionFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * The implementation of the course local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.instructure.canvas.service.CourseLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Cisco
 * @see com.instructure.canvas.service.base.CourseLocalServiceBaseImpl
 * @see com.instructure.canvas.service.CourseLocalServiceUtil
 */
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {
	
	public static final String PAGE_MARKER = "?page=";


	public String createCourse(String courseId, String shortName, String longName, String accountId,
				String termId, String status, String netacadCoreOfferingId) throws IOException, SystemException {

		Calendar startCal = Calendar.getInstance();

		int startDay = startCal.get(Calendar.DAY_OF_MONTH);
		int startMonth = startCal.get(Calendar.MONTH);
		int startYear = startCal.get(Calendar.YEAR);

		Calendar concludeCal = Calendar.getInstance();

		int concludeDay = concludeCal.get(Calendar.DAY_OF_MONTH);
		int concludeMonth = concludeCal.get(Calendar.MONTH);
		int concludeYear = concludeCal.get(Calendar.YEAR);

		return createCourse(courseId, shortName, longName, accountId, termId,
				status, netacadCoreOfferingId, startYear, startMonth, startDay,
				concludeYear, concludeMonth, concludeDay, "UTC");
	}

	public String createCourse(
			String courseId, String shortName, String longName, String accountId, String termId,
			String status, String netacadCoreOfferingId, int startYear,
			int startMonth, int startDay, int concludeYear, int concludeMonth,
			int concludeDay, String timeZoneId)
			throws IOException, SystemException {

		long processStartTime = new Date().getTime();

		DateTimeZone dtz = DateTimeZone.forTimeZone(TimeZone.getTimeZone(timeZoneId));
		DateTime start = new DateTime(startYear, startMonth+1, startDay+1, 0, 1, 0, 0, dtz);
		DateTime conclude = new DateTime(concludeYear, concludeMonth+1, concludeDay+1, 23, 59, 0, 0, dtz);

		String startDate = start.toString();
		String concludeDate = conclude.toString();

		String params = URLEncoder.encode("account_id", "UTF-8") + "=" + URLEncoder.encode(accountId, "UTF-8");

		params += "&" + URLEncoder.encode("course[name]", "UTF-8") + "=" + URLEncoder.encode(shortName, "UTF-8");
		params += "&" + URLEncoder.encode("course[course_code]", "UTF-8") + "=" + URLEncoder.encode(courseId, "UTF-8");
		params += "&" + URLEncoder.encode("course[start_at]", "UTF-8") + "=" + URLEncoder.encode(startDate, "UTF-8");
		params += "&" + URLEncoder.encode("course[end_at]", "UTF-8") + "=" + URLEncoder.encode(concludeDate, "UTF-8");

		log.info("Create course params:" + params);

        String apiUrl = "/accounts/" + accountId + "/courses";

		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

		urlc.setDoOutput(true);
		urlc.setRequestMethod("POST");

		PrintWriter pw = UnsyncPrintWriterPool.borrow(urlc.getOutputStream());

		pw.close();

		UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));

		long streamTime = new Date().getTime();

		String httpStatus = unsyncBufferedReader.readLine();

		unsyncBufferedReader.close();

		try {
			courseId = JSONFactoryUtil.createJSONObject(httpStatus).getString("id");

			long coursePk = counterLocalService.increment();

			Course course = coursePersistence.create(coursePk);

			course.setId(Long.parseLong(courseId));
			course.setName(shortName);
			course.setAccountId(Long.parseLong(accountId));

			course.setNetacadCoreOfferingId(netacadCoreOfferingId);

			long processStartTime1 = new Date().getTime();
			coursePersistence.update(course);
			long processEndTime1 = new Date().getTime();
			log.info("Time take by Liferay service to create Course is : "+(processEndTime1-processStartTime1)+ " milliseconds");
			
			//call to REST - create course in MongoDB
			int statusCode = updateCourseInMongoDB(course);
			if(statusCode != 200){
				//error from server, then throw SystemException - Dual write transaction mgmt.
				log.info("TRANSECTION FAILED to update Course ");
				throw new SystemException();
			}else{
				log.info("TRANSECTION SUCCEED to update Course ");
			}

			long companyId = PortalUtil.getDefaultCompanyId();

			try {
				Group group = GroupLocalServiceUtil.getGroup(companyId, GroupConstants.GUEST);

				assetEntryLocalService.updateEntry(0L, group.getGroupId(), Course.class.getName(),
						course.getId(), new long[]{}, new String[]{});

			} catch (PortalException e) {
				log.error("Error updating asset entry: ", e);
			}

			long processEndTime = new Date().getTime();

			if ((processEndTime - processStartTime) > TIME_CONSTRAINT) {
				log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
				log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
				log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
				log.info("URL: " + urlc.getURL().toString());
			}

            urlc.disconnect();

			return courseId;
		}catch (ConnectException e) {
			//if REST server is down, then throw SystemException - Dual write transaction mgmt.
			throw new SystemException();
		} catch (JSONException e) {
			log.error("Error creating course: ", e);
		} catch (SystemException e) {
			log.error("Error creating course: ", e);
		}

		return "";
	}

	public String createCourse(
			String courseId, String shortName, String longName, String accountId, String termId,
			String status, String netacadCoreOfferingId, int startYear,
			int startMonth, int startDay, int concludeYear, int concludeMonth,
			int concludeDay, String timeZoneId, boolean enforceDates)
			throws IOException, SystemException {
		return createCourse(courseId, shortName, longName, accountId, termId, status, netacadCoreOfferingId, startYear,
				startMonth, startDay, concludeYear, concludeMonth, concludeDay, timeZoneId, enforceDates, null);
	}

	public String createCourse(
			String courseId, String shortName, String longName, String accountId, String termId,
			String status, String netacadCoreOfferingId, int startYear,
			int startMonth, int startDay, int concludeYear, int concludeMonth,
			int concludeDay, String timeZoneId, boolean enforceDates, String netacadCVLId)
			throws IOException,  SystemException{

		long processStartTime = new Date().getTime();

		DateTimeZone dtz = DateTimeZone.forTimeZone(TimeZone.getTimeZone(timeZoneId));
		DateTime start = new DateTime(startYear, startMonth+1, startDay, 0, 1, 0, 0, dtz);
		DateTime conclude = new DateTime(concludeYear, concludeMonth+1, concludeDay, 23, 59, 0, 0, dtz);

		String startDate = start.toString();
		String concludeDate = conclude.toString();

		String params = URLEncoder.encode("account_id", "UTF-8") + "=" + URLEncoder.encode(accountId, "UTF-8");

		params += "&" + URLEncoder.encode("course[name]", "UTF-8") + "=" + URLEncoder.encode(shortName, "UTF-8");
		params += "&" + URLEncoder.encode("course[license]", "UTF-8") + "=" + URLEncoder.encode("private", "UTF-8");
		params += "&" + URLEncoder.encode("course[course_code]", "UTF-8") + "=" + URLEncoder.encode(courseId, "UTF-8");
		params += "&" + URLEncoder.encode("course[start_at]", "UTF-8") + "=" + URLEncoder.encode(startDate, "UTF-8");
		params += "&" + URLEncoder.encode("course[end_at]", "UTF-8") + "=" + URLEncoder.encode(concludeDate, "UTF-8");
		params += "&" + URLEncoder.encode("course[restrict_enrollments_to_course_dates]", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(enforceDates), "UTF-8");

		if (log.isDebugEnabled()) {
			log.debug(params);
		}

        String apiUrl = "/accounts/" + accountId + "/courses";

		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

		urlc.setDoOutput(true);
		urlc.setRequestMethod("POST");

		PrintWriter pw = UnsyncPrintWriterPool.borrow(urlc.getOutputStream());

		pw.close();

        String targetUrl = urlc.getURL().toString();

		UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));

		long streamTime = new Date().getTime();

		String httpStatus = unsyncBufferedReader.readLine();

		if (log.isDebugEnabled()) {
			log.debug(httpStatus);
		}

		unsyncBufferedReader.close();

		try {
			courseId = JSONFactoryUtil.createJSONObject(httpStatus).getString("id");

			long coursePk = counterLocalService.increment();

			Course course = coursePersistence.create(coursePk);

			course.setId(Long.parseLong(courseId));
			course.setName(shortName);
			course.setAccountId(Long.parseLong(accountId));

			course.setNetacadCoreOfferingId(netacadCoreOfferingId);
			course.setNetacadCVLId(netacadCVLId);

			long processStartTime1 = new Date().getTime();
			coursePersistence.update(course);
			long processEndTime1 = new Date().getTime();
			log.info("Time take by Liferay service to create Course is : "+(processEndTime1-processStartTime1)+ " milliseconds");
			
			//call to REST - create course in MongoDB
			int statusCode = updateCourseInMongoDB(course);
			if(statusCode != 200){
				//error from server, then throw SystemException - Dual write transaction mgmt.
				log.info("TRANSECTION FAILED to update Course ");
				throw new SystemException();
			}else{
				log.info("TRANSECTION SUCCEED to update Course ");
			}

			long processEndTime = new Date().getTime();

			if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
				log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
				log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
				log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
				log.info("URL: " + targetUrl);
			}

            urlc.disconnect();

			return courseId;
		}catch (ConnectException e) {
			//if REST server is down, then throw SystemException - Dual write transaction mgmt.
			throw new SystemException();
		} catch (JSONException e) {
			log.error("Error creating course: ", e);
		} catch (SystemException e) {
			log.error("Error creating course: ", e);
		}

		return "";
	}

	private int updateCourseInMongoDB(Course course) throws ConnectException{
		String url = REST_HOST.concat(CREATE_UPDATE_COURSE_URL);
		log.info("REST url : "+url);
		int statusCode = 0;
		try {
			statusCode = CanvasApiUtils.postDataToMongoDB(url, course);
		} catch (ClientProtocolException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return statusCode;
	}
	
	public Course getCourseByOID(String oid) throws SystemException {
		//return coursePersistence.fetchByNetacadOfferingId(oid);
		
		String url = REST_HOST.concat(COURSE_BY_OID_URL).concat(oid);
		log.info("MongoDB REST URL : "+url);
		JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
		obj = obj.getJSONObject("entity");
		Course course = null;
		
		if (obj != null) {
			course = new  CourseImpl();
			course.setId(obj.getLong("id"));
			course.setName(obj.getString("name"));
			course.setAccountId(obj.getLong("accountId"));
			course.setNetacadCoreOfferingId(obj.getString("netacadCoreOfferingId"));
			course.setNetacadCVLId(obj.getString("netacadCVLId"));
		}else{
			log.error("No course exists in MongoDB with the offer id: " + oid+"  ..Reading from PostgreSQL");
			return coursePersistence.fetchByNetacadOfferingId(oid);
		}
		
		return course;
	}

	public Course getCourseById(long id) throws SystemException {
		/*Course course = coursePersistence.fetchById(id);
		if (course == null) {
			log.error("No course exists in LR DB with the courseId: " + id);
		}
		return course;*/
		
		Course course = null;
		String restURL = REST_HOST.concat(COURSE_BY_ID_URL)+id;
		log.info("REST URL for Course  "+restURL);
		JSONObject courseObj = CanvasApiUtils.getJSONObjectFromUrl(restURL);
		
		if (courseObj != null && courseObj.has("entity")) {
			courseObj = courseObj.getJSONObject("entity");
			
			course = new CourseImpl();
			course.setId(courseObj.getLong("id"));
			course.setName(courseObj.getString("name"));
			course.setAccountId(courseObj.getLong("accountId"));
			course.setNetacadCoreOfferingId(courseObj.getString("netacadCoreOfferingId"));
			course.setNetacadCVLId(courseObj.getString("netacadCVLId"));
		}else{
			log.error("No course exists in MongoDB with the courseId: " + id+" ..Reading from PostgreSQL");
			course = coursePersistence.fetchById(id);
		}
		return course;
	}

	public List<Course> getCoursesByCVLId(List<String> cvlIds) throws SystemException {
		List<Course> courses = new ArrayList<Course>();

/*		for (String cvlId : cvlIds) {
			courses.addAll(coursePersistence.findByNetacadCVLId(cvlId));

		}
		
		*
		*this method is called from voucher-portlet
		*/
		
		//REST call
		String params = StringUtils.join(cvlIds, "&cvlId=");
		String url = REST_HOST.concat(COURSE_BY_CVL_IDS_URL).concat(StringPool.QUESTION).concat("cvlId=").concat(params.replaceAll("\"", ""));
		log.info("REST url : "+url);
		
		JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
		JSONArray jsonArray = null;
		if(obj != null && obj.has("entities")){
			jsonArray = obj.getJSONArray("entities");
		}
		if(jsonArray != null){
			courses = getCourseListFromJsonArray(jsonArray);
		}else{
			log.info("Couldn't retrieve Courses from MongoDB..Reading from PostgreSQL");
			for (String cvlId : cvlIds) {
				courses.addAll(coursePersistence.findByNetacadCVLId(cvlId));

			}
		}

		return courses;
	}

	private List<Course> getCourseListFromJsonArray(JSONArray jsonArray){
		
		List<Course> courses = new ArrayList<Course>();
   		for (int i = 0; i < jsonArray.length(); i++) {
			   JSONObject course = jsonArray.getJSONObject(i);
			   Course crs = new CourseImpl();
			   crs.setId(course.getLong("id"));
			   crs.setName(course.getString("name"));
			   crs.setAccountId(course.getLong("accountId"));
			   crs.setNetacadCoreOfferingId(course.getString("netacadCoreOfferingId"));
			   crs.setNetacadCVLId(course.getString("netacadCVLId"));
			  
			   courses.add(crs);
		}
		return courses;
	}
	
	
	public List<Course> getAllCourses(String rootAccountId) throws IOException, JSONException {

		if (Validator.isNull(rootAccountId)) {
			return new ArrayList<Course>();
		}

		List<Course> courseList = new ArrayList<Course>();

		try {
            String apiUrl = "/accounts/" + rootAccountId + "/courses";

			String params = "state[]=completed&state[]=created&state[]=claimed&state[]=available";
			
			courseList = getCourses(courseList, apiUrl, params, -1, 50);
		} catch (Exception e) {
			log.debug("Error fetching the courses: ", e);
		}

		return courseList;
	}

	protected List<Course> getCourses(List<Course> courses, String apiUrl, String params, int page, int perPage)
			throws JSONException, IOException {

		StringBuilder additionalParams = new StringBuilder();

		if (page != -1) {
			additionalParams.append("&")
					.append(URLEncoder.encode("page", "UTF-8"))
					.append(StringPool.EQUAL)
					.append(URLEncoder.encode(String.valueOf(page), "UTF-8"));
		}
		if (perPage != -1) {
			additionalParams.append("&")
					.append(URLEncoder.encode("per_page", "UTF-8"))
					.append(StringPool.EQUAL)
					.append(URLEncoder.encode(String.valueOf(perPage), "UTF-8"));
		}

   		
   		JSONArray objects = CanvasApiUtils.getAllPagesOfCanvasAPI(apiUrl, String.valueOf(params));

		List <Course> subList = new ArrayList<Course>();
   		for (int i = 0; i < objects.length(); i++) {
			   JSONObject curCourse = objects.getJSONObject(i);
			   Course course = new CourseImpl();

			   course.setName(curCourse.getString("name"));
			   course.setId(curCourse.getLong("id"));
			   course.setEnrollments(curCourse.getString("enrollments"));
			   course.setCourse_code(curCourse.getString("course_code"));
			   course.setSis_course_id(curCourse.getString("sis_course_id"));
			   course.setCalendar(curCourse.getJSONObject("calendar").getString("ics"));
			   course.setUrl(curCourse.getString("html_url"));
			   course.setEndDate(CanvasApiUtils.getDateFromCanvasString(curCourse.getString("end_at")));

			   subList.add(0, course);
		}

		courses.addAll(subList);

		return courses;
	}

	public List<Course> getCourses(String userToken) throws IOException, JSONException {
		return getCourses(userToken,null);
	}
	
	public List<Course> getCourses(String userToken, String[] state) throws IOException, JSONException {

        String apiUrl = "/courses";
        StringBuilder params = new StringBuilder();
        List<Course> courseList = new ArrayList<Course>();
		
        if (Validator.isNotNull(userToken)) {
            params.append("as_user_id")
            	.append(StringPool.EQUAL)
            	.append(URLEncoder.encode(userToken, "UTF-8"));
		}

        params.append(StringPool.AMPERSAND)
        	  .append("include[]")
        	  .append(StringPool.EQUAL)
        	  .append("html_url");

        if(state!=null){
        	for(String s : state){
        		params.append(StringPool.AMPERSAND)
        			  .append("state[]")
        			  .append(StringPool.EQUAL)
        			  .append(URLEncoder.encode(s, "UTF-8"));
        	}
        } else {
        	params.append(StringPool.AMPERSAND)
			  .append("state[]")
			  .append(StringPool.EQUAL)
			  .append("active");
        }
        
        courseList = getCourses(courseList, apiUrl, params.toString(), -1, 100);

		return sortCoursesById(courseList);
	}
	
	/**
	 * Adds the activity stream to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userToken the users Canvas ID
	 * @param isStudent true for student, false for instructor. If you want both, use getCourses(String userToken)
	 * @return the activity stream that was added
	 */
	public List<Course> getCourses(String userToken, boolean isStudent) throws JSONException {
		return getCourses(userToken,isStudent,null);
	}

	/**
	 * Adds the activity stream to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userToken the users Canvas ID
	 * @param isStudent true for student, false for instructor. If you want both, use getCourses(String userToken)
	 * @param state the states of the courses to retrieve 'unpublished', 'available', 'completed', 'deleted'
	 * @return the activity stream that was added
	 */
	public List<Course> getCourses(String userToken, boolean isStudent, String[] state) throws JSONException {
		try {
			long processStartTime = new Date().getTime();

            String apiUrl = "/courses";
            String params = "";
            
            if (Validator.isNotNull(userToken)) {
                params += URLEncoder.encode("as_user_id", "UTF-8") + "=" + URLEncoder.encode(userToken, "UTF-8") + "&";
            }

            params += URLEncoder.encode("per_page", "UTF-8") + "=" + URLEncoder.encode("999", "UTF-8");
            params += "&" + URLEncoder.encode("include[]", "UTF-8") + "=" + URLEncoder.encode("html_url", "UTF-8");
            if (state!=null) {
            	for(String s : state){
            		params += "&" + URLEncoder.encode("state[]", "UTF-8") + "=" + URLEncoder.encode(s, "UTF-8");
            	}
            }

			if (isStudent) {
                params += "&" + URLEncoder.encode("enrollment_type", "UTF-8") + "=" + URLEncoder.encode("student", "UTF-8");
			} else {
                params += "&" + URLEncoder.encode("enrollment_type", "UTF-8") + "=" + URLEncoder.encode("teacher", "UTF-8");
			}

			List<Course> courseList = new ArrayList<Course>();
            HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);
        	String nextPageURL = null;
            
        	do {
            	String linkHeader = urlc.getHeaderField("Link");
             	nextPageURL = CanvasApiUtils.getNextPageURLUsingRegEx(linkHeader);
            	
    			long streamTime = new Date().getTime();
            	
				JSONArray courses = getJSONObjects(urlc);
				for (int j = 0; j < courses.length(); j++) {
					JSONObject jsonObject = courses.getJSONObject(j);
					Course	course = getCourse(jsonObject);
					courseList.add(course);
				}
				
				long processEndTime = new Date().getTime();

				if ((processEndTime - processStartTime) > TIME_CONSTRAINT) {
					log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
					log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
					log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
					log.info("URL: " + urlc.getURL().toString());
				}
				
				if (Validator.isNotNull(nextPageURL)) {
					urlc = CanvasURLConnectionFactory.getCanvasURL(nextPageURL);
				}
				
            } while(Validator.isNotNull(nextPageURL));
            
            urlc.disconnect();

			return sortCoursesById(courseList);

		} catch (Exception e) {
			log.error("Error retrieving courses for user-token: " + userToken, e);
		}

		return new ArrayList<Course>();
	}
	
	/**
	 * Get the course object.
	 * 
	 * @param jsonObject the json object.
	 * @return the course object.
	 */
	protected Course getCourse(JSONObject jsonObject) {
		Course course = null;
		try {
			// retrieving the locally stored course for the corresponding courseID
			course = getCourseById(jsonObject.getLong("id"));
		} catch (SystemException e) {
			log.error("Error retrieving the Course for courseID: " + jsonObject.getLong("id"), e);
		}

		if (Validator.isNull(course)) {
			course = new CourseImpl();
		}
		
		course.setName(jsonObject.getString("name"));
		course.setId(jsonObject.getLong("id"));
		course.setCanvasId(jsonObject.getLong("id"));
		course.setEnrollments(jsonObject.getString("enrollments"));
		course.setCourse_code(jsonObject.getString("course_code"));
		course.setSis_course_id(jsonObject.getString("sis_course_id"));
		course.setCalendar(jsonObject.getJSONObject("calendar").getString("ics"));
		course.setUrl(jsonObject.getString("html_url"));
		course.setAccountId(jsonObject.getLong("account_id"));
		course.setStartDate(CanvasApiUtils.getDateFromCanvasString(jsonObject.getString("start_at")));
		course.setEndDate(CanvasApiUtils.getDateFromCanvasString(jsonObject.getString("end_at")));
		
		return course;
	}
	
	/**
	 * Get the JSON Objects from the url connection.
	 * 
	 * @param urlConnection the url connection.
	 * @return the JSON objects.
	 * @throws IOException the input output exception.
	 * @throws JSONException the JSON exception.
	 */
	protected JSONArray getJSONObjects(HttpURLConnection urlConnection) throws IOException, JSONException {
		BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
    	
    	if (log.isDebugEnabled()) {
            log.debug("Connecting to user course list with URL:");
            log.debug(urlConnection.getURL().toString());
        }

    	StringBuilder result = new StringBuilder();
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			result.append(inputLine);
		}

		in.close();

		JSONArray jsonObjects = JSONFactoryUtil.createJSONArray(result.toString());
		return jsonObjects;
	}
	
	/**
	 * Get the distinct enrolled courses for the instructor.
	 * 
	 * @param userId the user id.
	 * @return the list of courses.
	 */
	public List<Course> getDistinctEnrolledCoursesForInstructor(String userId) {
		List<Course> courseList = new ArrayList<Course>();
		try {
			JSONArray enrollments = canvasEnrollmentLocalService.getInstructorEnrollmentsForUser(userId);
			Set<Long> courseIdSet = new HashSet<Long>();
			for(int i=0 ; i < enrollments.length() ; i++) {
				JSONObject jsonObject = enrollments.getJSONObject(i);
				
				if (jsonObject == null) {
					if (log.isDebugEnabled()) {
						log.debug("Enrollements returned null object");
					}

					continue;
				}

				long courseId = jsonObject.getLong("course_id");
				
				// Check if the course object is already fetched for this coureId.
				// if not then fetch the course object and add into the courseList.
				if (courseIdSet.add(courseId)) {
					Course course = courseLocalService.getCourseById(courseId);

					if (course == null) {
						log.warn("Course is null for :\n" + jsonObject);
						log.warn("Does that course exist locally?");

						continue;
					}
					
					courseList.add(course);
				}								
			}
		} catch (JSONException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} catch (SystemException e) {
			log.error(e);
		}
		
		return sortCoursesById(courseList);
	}
	
	private List<Course> sortCoursesById(List<Course> courses) {
		Collections.sort(courses, new Comparator<Course>() {

			public int compare(Course o1, Course o2) {
				return new Long(o2.getId()).compareTo(new Long(o1.getId()));
			}
		});
		
		return courses;
	}

	public Course getCourse(String userToken, long courseId) throws JSONException {
		try {
			long processStartTime = new Date().getTime();

            String apiUrl = "/courses/" + courseId;
            String params = "";
            if (Validator.isNotNull(userToken)) {
                params += URLEncoder.encode("as_user_id", "UTF-8") + "=" + URLEncoder.encode(userToken, "UTF-8") + "&";
            }

            params += URLEncoder.encode("per_page", "UTF-8") + "=" + URLEncoder.encode("999", "UTF-8");
            params += "&" + URLEncoder.encode("include[]", "UTF-8") + "=" + URLEncoder.encode("html_url", "UTF-8");

            HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

            BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

            if (log.isDebugEnabled()) {
                log.debug("Connecting to user course list with URL:");
                log.debug(urlc.getURL().toString());
            }

			long streamTime = new Date().getTime();

			StringBuilder result = new StringBuilder();
			String inputLine;

			while ((inputLine = in.readLine()) != null)
				result.append(inputLine);

			in.close();

			JSONObject curCourse = JSONFactoryUtil.createJSONObject(result.toString());

			Course course = new CourseImpl();

			course.setName(curCourse.getString("name"));
			course.setId(curCourse.getLong("id"));
			course.setEnrollments(curCourse.getString("enrollments"));
			course.setCourse_code(curCourse.getString("course_code"));
			course.setSis_course_id(curCourse.getString("sis_course_id"));
			course.setCalendar(curCourse.getJSONObject("calendar").getString("ics"));
			course.setUrl(curCourse.getString("html_url"));
			course.setStartDate(CanvasApiUtils.getDateFromCanvasString(curCourse.getString("start_at")));
			course.setEndDate(CanvasApiUtils.getDateFromCanvasString(curCourse.getString("end_at")));

			long processEndTime = new Date().getTime();

			if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
				log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
				log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
				log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
				log.info("URL: " + urlc.getURL().toString());
			}

            urlc.disconnect();

			return course;

		} catch (MalformedURLException e) {
			log.error(e);
		} catch (IOException e) {
			log.error("No course exist in canvas with the courseId: " + courseId, e);
		}

		return null;
	}
	
	/*
	 * Needs only grade=complete for certificate qualification
	 */
	public boolean isQualifiedForCertificate(long courseId, long canvasUserId) {
		boolean qualified = false;
		List<SubmissionVersion> submissions;
		try {
			submissions = submissionVersionLocalService.getSubmissionHistory(
					String.valueOf(canvasUserId), String.valueOf(courseId));
			
			for (SubmissionVersion submission : submissions) {
				String assignmentName = submission.getAssignmentName();
				if ((assignmentName.equalsIgnoreCase(CiscoConstants.COURSE_COMPLETION) ||
						assignmentName.startsWith(CiscoConstants.COURSE_COMPLETION_PREFIX) || 
							assignmentName.startsWith(CiscoConstants.SELF_ENROLLED_COURSE_PREFIX)) &&
						submission.getCurrentGrade().equalsIgnoreCase("complete")) {
					qualified = true;
					
					break;
				}
			}
		} catch (JSONException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		
		return qualified;
	}
	
	/*
	 * Needs grade=complete AND score >='x' for letter qualification
	 * 
	 * 1. get all assignments for a course 
	 * 2. find assignment_id where name="Instructor Use Only Assign Student Pass Status"
	 * 3. get all submissions for assignment in #2
	 * 4. check all submissions in #3 to see if grade=complete for the given user_id
	 * 5. get assignment_id for a course where assignment name="Final Exam" from all assignments in #1
	 * 6. get submissions for assignment in #5
	 * 7. find score and attempt for given user_id
	 * 8. if score >= 'x' AND attempt = 1 AND grader_id == null (VDS-LTI graded), user is qualified
	 */
	public boolean isQualifiedForLetter(long courseId, long canvasUserId) {
		List<Assignment> assignments = assignmentLocalService.getAssignments(
			courseId);
		
		Assignment completionAssignment = null; 
		
		for (Assignment assignment : assignments) {
			String name = assignment.getName();
			
			if (name.equalsIgnoreCase(CiscoConstants.COURSE_COMPLETION) ||
				name.startsWith(CiscoConstants.COURSE_COMPLETION_PREFIX)) {
				completionAssignment = assignment;
				
				break;
			}
		}

		if (completionAssignment == null) {
			return false;
		}
		
		Assignment finalAssignment = null; 
		
		for (Assignment assignment : assignments) {
			String name = assignment.getName();
			
			if (name.equalsIgnoreCase(CiscoConstants.FINAL_EXAM) ||
				name.startsWith(CiscoConstants.FINAL_EXAM_PREFIX)) {
				finalAssignment = assignment;
				
				break;
			}
		}
		
		if (finalAssignment == null) {
			return false;
		}
		
		boolean qualified = false;
		double minScore = 0;
		
		try {
			Course course = null;
			try {
				//course = coursePersistence.fetchById(courseId);
				
				//above call replaced woth MongoDB call
				course = getCourseById(courseId);
				if(course == null){
					log.info("Reading from PostgreSQL");
					course = coursePersistence.fetchById(courseId);
				}
				 
				String cvlId = course.getNetacadCVLId();
				
				Award award = AwardLocalServiceUtil.getAwardByCVLId(cvlId);
				
				if (award == null) {
					return false;
				}
				
				minScore = award.getScore();	
			}
			catch (SystemException e) {
				log.error(e);
				
				return false;
			}
			
			List<SubmissionVersion> submissions = submissionVersionLocalService.getSubmissionHistory(
					String.valueOf(canvasUserId), String.valueOf(finalAssignment.getAssignmentId()), String.valueOf(courseId));
			
			for (SubmissionVersion submission : submissions) {
				if (submission.getScore() >= minScore &&
					submission.getAttempt() == 1 &&
					Validator.isNull(submission.getGraderId())) {
					qualified = true;
					
					break;
				}
			}
		}
		catch (JSONException e) {
			log.error(e);
		}
		catch (IOException e) {
			log.error(e);
		}
		
		return qualified;
	}
	
	public void updateCourse(
		String courseId, String shortName, String courseCode, 
		int startDay, int startMonth, int startYear,
		int concludeDay, int concludeMonth, int concludeYear, String timeZoneId) 
		throws SystemException {
		
		DateTimeZone dtz = DateTimeZone.forTimeZone(TimeZone.getTimeZone(timeZoneId));
		DateTime start = new DateTime(startYear, startMonth + 1, startDay, 0, 1, 0, 0, dtz);
		DateTime conclude = new DateTime(concludeYear, concludeMonth + 1, concludeDay, 23, 59, 0, 0, dtz);

		log.info("conclude day --- " + concludeDay);
		log.info("conclude month -----" + concludeMonth);
		log.info("conclude year --- " + concludeYear);

		String startDate = start.toString();
		String concludeDate = conclude.toString();

        String apiUrl = "/courses/" + courseId;

		try {
			StringBuilder params = new StringBuilder("&course[name]=")
				.append(URLEncoder.encode(shortName, "UTF-8"))
				.append("&course[course_code]=")
				.append(URLEncoder.encode(courseCode, "UTF-8"))
				.append("&course[start_at]=")
				.append(URLEncoder.encode(startDate, "UTF-8"))
				.append("&course[end_at]=")
				.append(URLEncoder.encode(concludeDate, "UTF-8"));
		
			HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params.toString());

            if (log.isDebugEnabled()) {
                log.debug(urlc.getURL().toString());
            }

			urlc.setDoOutput(true);
			urlc.setRequestMethod("PUT");
			urlc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded" );

			OutputStreamWriter out = new OutputStreamWriter(urlc.getOutputStream());
			out.write(params.toString());
			out.close();
						
			int responseCode = urlc.getResponseCode();

			if (log.isDebugEnabled()) {
				log.debug("Response code = " + responseCode);
			}

			if (responseCode != HttpURLConnection.HTTP_OK) {
				if (log.isDebugEnabled()) {
					log.debug(
						"Update course error: response code = " + responseCode + " for course = " + courseId);
				}
			}
			
			//update the local course
			Course course = coursePersistence.fetchById(Long.valueOf(courseId));
			course.setName(shortName);
			
			
			long processStartTime1 = new Date().getTime();
			coursePersistence.update(course);
			long processEndTime1 = new Date().getTime();
			log.info("Time take by Liferay service to create Course is : "+(processEndTime1-processStartTime1)+ " milliseconds");
			
			
			//call to REST - create course in MongoDB
			int statusCode = updateCourseInMongoDB(course);
			if(statusCode != 200){
				//error from server, then throw SystemException - Dual write transaction mgmt.
				log.info("TRANSECTION FAILED to update Course ");
				throw new SystemException();
			}else{
				log.info("TRANSECTION SUCCEED to update Course ");
			}
			
			//update course in MongoDB/PostgreSQL
			/*if(WRITE_TO_DB != null && StringUtils.isNotBlank(WRITE_TO_DB) && StringUtils.isNotEmpty(WRITE_TO_DB)){
				if(WRITE_TO_DB.equalsIgnoreCase("single")){
					if(DB_NAME != null && StringUtils.isNotBlank(DB_NAME) && StringUtils.isNotEmpty(DB_NAME)){
						if(DB_NAME.equalsIgnoreCase("mongo")){
							//write to mongo
						}else{
							//write to LR
						}
					}else{
						//write to LR
					}
				}else if(WRITE_TO_DB.equalsIgnoreCase("both")){
					//write to both
				}else{
					//write to LR only
				}
				
			}else{
				log.info("Database properties for dual/single (PostgreSQL/MongoDB) write are not defined in portal-ext.properties file.");
				//write to LR
			}*/

            urlc.disconnect();
		}catch (ConnectException e) {
			//if REST server is down, then throw SystemException - Dual write transaction mgmt.
			throw new SystemException();
		}  catch (Exception e) {
			throw new SystemException(e);
		}
	}

	//Changed from 1000 to one millisec so that all API calls are logged.
	private final long TIME_CONSTRAINT = 1;

	private static Log log = LogFactoryUtil.getLog(CourseLocalServiceImpl.class);
	
	private static final String REST_HOST = PropsUtil.get("rest.api.host");
    private static final String COURSE_BY_ID_URL = PortletProps.get("rest.api.url.get.course.by.id");
    private static final String COURSE_BY_OID_URL = PortletProps.get("rest.api.url.get.course.by.oid");
    private static final String COURSE_BY_CVL_IDS_URL = PortletProps.get("rest.api.url.get.course.by.cvl.ids");
    private static final String CREATE_UPDATE_COURSE_URL = PortletProps.get("rest.api.url.create.update.course");
    
	
	private static final String WRITE_TO_DATABASE = "write.to.database";
	private static final String DATABASE_NAME = "database.name";
	
	private static final String WRITE_TO_DB = PropsUtil.get(WRITE_TO_DATABASE);
	private static final String DB_NAME = PropsUtil.get(DATABASE_NAME);

}