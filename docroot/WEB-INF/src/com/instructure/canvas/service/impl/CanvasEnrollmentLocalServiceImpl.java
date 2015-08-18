/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.instructure.canvas.service.impl;

import com.cisco.utility.constants.CiscoConstants;
import com.cisco.utility.service.UtilityLocalServiceUtil;
import com.instructure.canvas.model.CanvasUser;
import com.instructure.canvas.model.Course;
import com.instructure.canvas.service.CanvasAccountLocalServiceUtil;
import com.instructure.canvas.service.CanvasUserLocalServiceUtil;
import com.instructure.canvas.service.base.CanvasEnrollmentLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasApiUtils;
import com.instructure.canvas.util.CanvasURLConnectionFactory;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.DuplicateUserScreenNameException;
import com.liferay.portal.NoSuchOrganizationException;
import com.liferay.portal.UserScreenNameException;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.salesforce.model.ITC__c;
import com.liferay.salesforce.service.ITC__cLocalServiceUtil;
import com.liferay.util.Normalizer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * The implementation of the canvas enrollment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.CanvasEnrollmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.CanvasEnrollmentLocalServiceBaseImpl
 * @see com.instructure.canvas.service.CanvasEnrollmentLocalServiceUtil
 */
public class CanvasEnrollmentLocalServiceImpl
	extends CanvasEnrollmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.CanvasEnrollmentLocalServiceUtil} to access the canvas enrollment local service.
	 */

	public static final String STUDENT_ENROLLMENT = "StudentEnrollment";
	public static final String TEACHER_ENROLLMENT = "TeacherEnrollment";
	private static final String GLOBAL_ACADEMY_CANVAS_ACCOUNT_ID ="global.academy.canvas.account.id";

	public void createEnrollment(String courseId, String userId, String role,
								 String sectionId, String status, String associatedUserId)
			throws IOException {

		long processStartTime = new Date().getTime();

		String params = URLEncoder.encode("enrollment[user_id]", "UTF-8") + "=" + URLEncoder.encode(userId, "UTF-8");

		params += "&" + URLEncoder.encode("enrollment[type]", "UTF-8") + "=" + URLEncoder.encode(role, "UTF-8");
		params += "&" + URLEncoder.encode("enrollment[enrollment_state]", "UTF-8") + "=" + URLEncoder.encode("active", "UTF-8");
		params += "&" + URLEncoder.encode("enrollment[notify]", "UTF-8") + "=0";	

        if (_log.isDebugEnabled()) {
            _log.debug(params);
        }

        String apiUrl = "/courses/" + courseId + "/enrollments";

        HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

        urlc.setDoOutput(true);
        urlc.setRequestMethod("POST");

        PrintWriter pw = UnsyncPrintWriterPool.borrow(urlc.getOutputStream());
		pw.println(params);
        pw.close();

        UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));

		long streamTime = new Date().getTime();

        String httpStatus = unsyncBufferedReader.readLine();

		if (_log.isDebugEnabled()) {
			_log.debug(httpStatus);
		}

		unsyncBufferedReader.close();

		long processEndTime = new Date().getTime();
		if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
			_log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
			_log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
			_log.info("URL: " + urlc.getURL().toString());
		}

        urlc.disconnect();
    }

	public void unenrollStudent(String userId, String courseId) 
		throws PortalException, SystemException {
		unenrollUser(STUDENT_ENROLLMENT, userId, courseId);
	}
	
	public void unenrollTeacher(String userId, String courseId) 
		throws PortalException, SystemException {
		unenrollUser(TEACHER_ENROLLMENT, userId, courseId);
	}
	
	public void unenrollUser(String type, String userId, String courseId) 
		throws PortalException, SystemException {

		try {
			JSONArray enrollments = getEnrollmentsForUser(userId, type); 
			
			if (enrollments == null || enrollments.length() == 0) {
				if (_log.isDebugEnabled()) {
					_log.debug("User " + userId + " has no enrollments");
				}
				
				return;
			}
			
			String enrollmentId = null;
			
			for (int i = 0; i < enrollments.length(); i++) {
				JSONObject enrollment = enrollments.getJSONObject(i);
				
				if (enrollment == null) {
					throw new PortalException("Error in getting enrollments " + "for user");
				}
				
				String course_id = enrollment.getString("course_id");
				
				if (courseId.equals(course_id)) {
					enrollmentId = enrollment.getString("id");
					
					break;
				}
			}
			
			if (Validator.isNull(enrollmentId)) {
				if (_log.isDebugEnabled()) {
					_log.debug("User " + userId + " not enrolled for course " + courseId);
				}
				
				return;
			}

			String apiUrl = "/courses/" + courseId + "/enrollments/" + enrollmentId;

			HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, _UNENROLL_API_ARGUMENT);
			urlc.setDoOutput(true);
			urlc.setRequestMethod("DELETE");

			PrintWriter pw = UnsyncPrintWriterPool.borrow(urlc.getOutputStream());
			pw.close();

			UnsyncBufferedReader unsyncBufferedReader = 
				new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));

			String responseBody = unsyncBufferedReader.readLine();
			
			unsyncBufferedReader.close();
			
			if (_log.isDebugEnabled()) {
				_log.debug(responseBody);
			}
						
			if (urlc.getResponseCode() != HttpURLConnection.HTTP_OK) {
				if (_log.isDebugEnabled()) {
					_log.debug("Canvas api error returned response code = " + 
						urlc.getResponseCode() + " for url = " + urlc.getURL().toString());
				}
				
				throw new PortalException(
					"Canvas api error, response code = " + urlc.getResponseCode());
			}

            urlc.disconnect();
		}
		catch (MalformedURLException e) {
			throw new SystemException(e);
		}
		catch (ProtocolException e) {			
			throw new SystemException(e);
		}
		catch (IOException e) {
			throw new SystemException(e);
		}
	}

	public List<Course> getEnrolledCoursesForStudent(String userId) 
		throws SystemException {
		List<Course> courses = new ArrayList<Course>();
		
		try {
			JSONArray enrollments = getStudentEnrollmentsForUser(userId);
			
			for (int i = 0; i < enrollments.length(); i++) {
				JSONObject jsonObject = enrollments.getJSONObject(i);

				if (jsonObject == null) {
					if (_log.isDebugEnabled()) {
						_log.debug("Enrollements returned null object");
					}

					continue;
				}

				long courseId = jsonObject.getLong("course_id");

				Course course = courseLocalService.getCourse("", courseId);
				Course localCourse = courseLocalService.getCourseById(courseId);

				if (Validator.isNull(course)) {
					_log.warn("Canvas course is null for :\n" + jsonObject);
					_log.warn("Does that course exist in CANVAS?");

					continue;
				}
				
				if (localCourse == null) {
					_log.warn("localCourse is null for :\n" + jsonObject);
					_log.warn("Does that course exist locally?");

					continue;
				}

				course.setNetacadCoreOfferingId(
					localCourse.getNetacadCoreOfferingId());
				course.setNetacadCVLId(localCourse.getNetacadCVLId());

				courses.add(course);
			}
		}
		catch (JSONException e) {
			_log.error(e);
		}
		catch (IOException e) {
			_log.error(e);
		}
		
		return courses;
	}
	
	public JSONArray getStudentEnrollmentsForUser(String userId) throws IOException, JSONException {
        return getEnrollmentsForUser(userId, STUDENT_ENROLLMENT);
	}

	public JSONArray getInstructorEnrollmentsForUser(String userId) throws IOException, JSONException {
        return getEnrollmentsForUser(userId, TEACHER_ENROLLMENT);
	}

	public JSONArray getEnrollmentsForUser(String userId, String type) throws IOException, JSONException {

        String apiUrl = "/users/" + userId + "/enrollments";
        StringBuilder params = new StringBuilder();

		if (type != null) {
			params.append("type="+type+StringPool.AMPERSAND);
		}		
		params.append("state[]=active&state[]=invited&state[]=completed");
		return CanvasApiUtils.getAllPagesOfCanvasAPI(apiUrl, params.toString());
	}

	public List<CanvasUser> getUncertifiedUsers(long companyId, long courseId)
			throws PortalException {

		List<CanvasUser> uncertifiedUsers = new ArrayList<CanvasUser>();

		try {
			Course course = courseLocalService.getCourseById(courseId);

			if (Validator.isNull(course)) {
				return new ArrayList<CanvasUser>();
			}

			String offeringId = course.getNetacadCoreOfferingId();

			List<CanvasUser> canvasUsers = canvasUserLocalService.getStudentsByCourseId(String.valueOf(courseId));

			for (CanvasUser canvasUser : canvasUsers) {
				try {
					long userId = UtilityLocalServiceUtil.getEntityId(companyId, User.class.getName(),
							CiscoConstants.EXPANDO_CANVAS_USER_ID, canvasUser.getCanvasUserId());
					User user = UserLocalServiceUtil.getUser(userId);
					String contactOID = UtilityLocalServiceUtil.getExpandoValue(companyId, User.class.getName(),
							CiscoConstants.EXPANDO_SALESFORCE_CONTACT_OID, user.getUserId());

					if (Validator.isNull(contactOID)) {
						//This user hasn't been added to salesforce, so they have to be a student

						uncertifiedUsers.add(canvasUser);
					} else {
                        if (Validator.isNotNull(contactOID)) {
                        	List<ITC__c> itcs = ITC__cLocalServiceUtil.getITCByContactAndOffering(
                        		contactOID, offeringId);
                            // This user is an instructor or an admin
                            // check to see if they are already certified to teach this course
                            if (itcs == null || itcs.isEmpty()) {
                                //This user is an instructor or admin, and isn't certified to teach this course yet
                                uncertifiedUsers.add(canvasUser);
                            }
                        }
					}
				} catch (Exception e) {}
			}

			return uncertifiedUsers;
		} catch (Exception e) {
			throw new PortalException(e);
		}
	}

	public void enrollStudent(
		long companyId, Locale locale, long creatorUserId, 
		String rootAccountId, String courseId,
		String firstName, String lastName, String emailAddress, 
		String studentId) throws PortalException, SystemException {
		String screenName = firstName + lastName;
		screenName = screenName.replaceAll("[^a-zA-Z0-9]", "");
		screenName = Normalizer.normalizeToAscii(screenName);

		User user;
		String canvasUserId = null;

		if (_log.isDebugEnabled()) {
			_log.debug(firstName + ", " + lastName + ", " + emailAddress + ", " + studentId);
		}

		long[] userGroupIds;

		UserGroup netacadStudent =  UserGroupLocalServiceUtil.getUserGroup(companyId, "NetAcad Student");
		userGroupIds = new long[]{netacadStudent.getUserGroupId()};

		user = null;

		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			
			if (_log.isDebugEnabled()) {
				_log.debug("User " +  emailAddress + " already exists...enrolling now");
			}
		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("User " +  emailAddress + " does not exist...creating now");
			}
			Organization netAcadOrg;

			try {
				netAcadOrg =  OrganizationLocalServiceUtil.getOrganization(companyId, CiscoConstants.NETWORK_ACADEMY);
			}
			catch (NoSuchOrganizationException nsoe) {
				if(_log.isDebugEnabled()) {
					_log.debug(nsoe);
				}
				netAcadOrg = OrganizationLocalServiceUtil.addOrganization(
					creatorUserId, 0, CiscoConstants.NETWORK_ACADEMY, 
					OrganizationConstants.TYPE_REGULAR_ORGANIZATION, 
					false, 0, 0, WorkflowConstants.STATUS_APPROVED, 
					StringPool.BLANK, false, new ServiceContext());
			}

			int i = 0;

			while (user == null && i < 5) {
				try {
					screenName = screenName.replace(StringPool.SPACE, StringPool.BLANK);

					user = UserLocalServiceUtil.addUser(
							creatorUserId, companyId, true, StringPool.BLANK,
							StringPool.BLANK, false, screenName, emailAddress,
							0L, StringPool.BLANK, locale, firstName,
							StringPool.BLANK, lastName, 0, 0, true, 1, 1,
							2000, StringPool.BLANK, new long[]{},
							new long[]{netAcadOrg.getOrganizationId()},
							new long[]{}, userGroupIds, true, 
							new ServiceContext());
					if (Validator.isNotNull(studentId) && Validator.isNumber(studentId)) {
						UtilityLocalServiceUtil.addExpandoValue(companyId, user.getUserId(), User.class.getName(),
							"studentId", studentId);
					}

					if (_log.isDebugEnabled()) {
						_log.debug("User " + emailAddress + " was added to Liferay");
					}
				} catch (DuplicateUserScreenNameException dusne) {
					i++;

					if (_log.isDebugEnabled()) {
						_log.debug(screenName + " is a duplicate, generating a new one");
					}

					screenName = firstName + lastName +
							CounterLocalServiceUtil.increment();
                    screenName = Normalizer.normalizeToAscii(screenName);
				} catch (UserScreenNameException usne) {
					i++;
					if (_log.isDebugEnabled()) {
						_log.debug(screenName + " is a bad, generating a new one");
						_log.debug(usne);
					}

					screenName = "netspaceuser" + CounterLocalServiceUtil.increment();
                    screenName = Normalizer.normalizeToAscii(screenName);
				}
			}

			if (user == null) {
				_log.error("User with screenname " + screenName +
						" and emailAddress " + emailAddress + " failed to add");
				
				throw new UserScreenNameException(screenName);
			}

			if (_log.isDebugEnabled()) {
				_log.debug("User " + user.toString());
			}
			String canvasUser = StringPool.BLANK;
			
			try {
				long start = System.currentTimeMillis();
				canvasUserId = CanvasUserLocalServiceUtil.isExistingUserInCanvas(rootAccountId, emailAddress);
				
				if (_log.isDebugEnabled()) {
					_log.debug("canvasUserId  " + canvasUserId);
				}

				if(canvasUserId == null){
					
					canvasUser = canvasUserLocalService.createUser(
							StringPool.BLANK, emailAddress, "123456",
							firstName, lastName, emailAddress, "active",
							rootAccountId);
					
					_log.info("Canvas user created for " + emailAddress + " in " + (System.currentTimeMillis()-start)+" ms");
					
				}
				
			}
			catch (IOException ioe) { 
				_log.error(ioe);
				throw new SystemException(ioe);
			}

			if (_log.isDebugEnabled()) {
				_log.debug("CanvasUser " + canvasUser);
			}
            
			if (Validator.isNotNull(canvasUser)) {
			canvasUserId = JSONFactoryUtil.createJSONObject(
				canvasUser).getString("id");
			}

			UtilityLocalServiceUtil.addExpandoValue(
				companyId, user.getUserId(), User.class.getName(), 
				CiscoConstants.EXPANDO_CANVAS_USER_ID, canvasUserId);
			
			if (_log.isDebugEnabled()) {
				_log.debug("Expando value Canvas_User_ID added for " + 
					emailAddress);
			}
		}
		
		if (canvasUserId == null) {
			canvasUserId = UtilityLocalServiceUtil.getExpandoValue(
				companyId, User.class.getName(), 
				CiscoConstants.EXPANDO_CANVAS_USER_ID, user.getUserId());
			
			if (_log.isDebugEnabled()) {
				_log.debug("Canvas_User_ID retrieved for " +  emailAddress);
			}
			
			try {
				long start = System.currentTimeMillis();
				String pseudonymStr = CanvasAccountLocalServiceUtil.addPseudonym(
					rootAccountId, canvasUserId, user.getEmailAddress());
				
				if (CanvasAccountLocalServiceUtil.isPseudonymTaken(pseudonymStr)) {
					_log.warn("Pseudonym " + emailAddress + " is already taken in rootAccountId " + rootAccountId);
				}
				else if (_log.isDebugEnabled()) {
					_log.debug("Pseudonym added for " +  emailAddress + "rootAccountId = " + rootAccountId + " in " + (System.currentTimeMillis()-start) + "ms");
				}
			}
			catch (FileNotFoundException e) {
				//should never happen ideally
				_log.error("User with canvas ID " + canvasUserId + 
					" found in DB but does not exist in Canvas");
				throw new SystemException(e);
			}
			catch (IOException e) {
				//throw new SystemException(e);
				/*
				 * Ignore exception while creating pseudonym here,
				 * otherwise exception thrown will abort enrollment process in Liferay,
				 * but Canvas enrollment process still takes place.
				 */
				_log.warn("Pseudonym Creation failed for " +  emailAddress + " in rootAccountId " + rootAccountId, e);
			}
		}
		

		try {
			long start = System.currentTimeMillis();
			canvasEnrollmentLocalService.createEnrollment(
				courseId, canvasUserId, "StudentEnrollment", "", 
				"active", "");
			if (_log.isDebugEnabled()) {
				_log.debug("Enrollment created for " +  emailAddress + " in "+ (System.currentTimeMillis()-start) + "ms");
			}
		}
		catch (IOException e) {
			throw new SystemException(e);
		}

		long organizationId = UtilityLocalServiceUtil.getEntityId(
			companyId, Organization.class.getName(), 
			CiscoConstants.EXPANDO_SALESFORCE_ACCOUNT_INSTITUTION_ID, 
			rootAccountId);
		
		Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);

		UserLocalServiceUtil.addOrganizationUsers(organizationId, new long[]{user.getUserId()});

		Role netacadInstructor = RoleLocalServiceUtil.getRole(companyId, "NetAcad Student");

		UserGroupRoleLocalServiceUtil.addUserGroupRoles(
			user.getUserId(), organization.getGroupId(), 
			new long[]{netacadInstructor.getRoleId()});
		
		String globalAcademyCanvasAccountId = PropsUtil.get(GLOBAL_ACADEMY_CANVAS_ACCOUNT_ID);
		
		try {
		
			if (Validator.isNotNull(globalAcademyCanvasAccountId)) {
				if (Validator.isNotNull(canvasUserId)) {

					String pseudonymStr = CanvasAccountLocalServiceUtil.addPseudonym(globalAcademyCanvasAccountId, canvasUserId, user.getEmailAddress());

					if (CanvasAccountLocalServiceUtil.isPseudonymTaken(pseudonymStr)) {
						_log.warn("Pseudonym " + emailAddress + " is already taken in Global Academy rootAccountId " + globalAcademyCanvasAccountId);
					}
					else if (_log.isDebugEnabled()) {
						_log.debug("Association with Global Acad Account ID for "+ user.getEmailAddress() + " is completed with "
								+ globalAcademyCanvasAccountId);
					}
				} else {
					_log.fatal("Not adding Global Academy Canvas account for user "
							+ user.getScreenName()
							+ " Canvas userId is not available");
				}
			} else {
				_log.fatal("Not adding Global Academy Canvas account for user "
						+ user.getScreenName()
						+ " Canvas Global Account Id is not available");
			}
		}
		catch (IOException e) {
			/*
			 * Ignore exception while creating Global Academy Pseudonym,
			 * otherwise exception thrown will abort enrollment process in Liferay,
			 * but Canvas enrollment process still takes place.
			 */
			_log.warn("Pseudonym Creation failed for " +  emailAddress + " in Global Academy rootAccountId " + globalAcademyCanvasAccountId, e);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Enrolling " + emailAddress + "...done");
		}
	}
	
	public String createPseudonymForExistingUser(long companyId, User user, String rootAccountId) 
			throws SystemException, PortalException {
		
		// Get canvas id from expando
		String canvasUserId = UtilityLocalServiceUtil.getExpandoValue(
				companyId, User.class.getName(), 
				CiscoConstants.EXPANDO_CANVAS_USER_ID, user.getUserId());
		
		String pseudonymStr = StringPool.BLANK;
		
		if (Validator.isNotNull(canvasUserId)) {
			try {
				/*
				 * We have canvas ID in expando, check if user is associated with this root account
				 */
				JSONArray pseudonym = CanvasAccountLocalServiceUtil.getPseudonym(rootAccountId, canvasUserId);

				if (Validator.isNotNull(pseudonym)) {
					if (_log.isDebugEnabled()) {
						_log.debug("Canvas User with ID " + canvasUserId + " already exists in account id " + rootAccountId + " pseudonym = " + pseudonym);
					}
				}
				else {
					/*
					 * Expando canvasID exists, but user is not associated to this root account.
					 * So create a pseudonym for the user in this account.
					 */
					String emailAddress = user.getEmailAddress();
					if (_log.isDebugEnabled()) {
						_log.debug("Creating pseudonym: CanvasUserID " + canvasUserId + " rootAccountId " + rootAccountId + " email = " + emailAddress);
					}
					pseudonymStr = CanvasAccountLocalServiceUtil.addPseudonym(rootAccountId, canvasUserId, emailAddress);
				}
			}
			catch (IOException e) {
				_log.error(e);
				throw new SystemException(e);
			}
		} // if canvasUserId not null

		
		return pseudonymStr;
		
	} // createPseudonymForExistingUser()

	//Changed from 1000 to one millisec so that all API calls are logged.
	private final long TIME_CONSTRAINT = 1;

    private static final String _UNENROLL_API_ARGUMENT = "task=delete"; 
    
    private static Log _log = LogFactoryUtil.getLog(CanvasEnrollmentLocalServiceImpl.class);

}