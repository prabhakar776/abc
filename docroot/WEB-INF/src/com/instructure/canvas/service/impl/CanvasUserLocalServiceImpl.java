package com.instructure.canvas.service.impl;

import com.cisco.utility.constants.CiscoConstants;
import com.cisco.utility.service.UtilityLocalServiceUtil;
import com.instructure.canvas.model.CanvasUser;
import com.instructure.canvas.model.impl.CanvasUserImpl;
import com.instructure.canvas.service.base.CanvasUserLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasApiUtils;
import com.instructure.canvas.util.CanvasURLConnectionFactory;
import com.instructure.canvas.util.comparator.CanvasUserFirstNameComparator;
import com.instructure.canvas.util.comparator.CanvasUserLastNameComparator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.HttpMethods;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The implementation of the canvas user local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.instructure.canvas.service.CanvasUserLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.CanvasUserLocalServiceBaseImpl
 * @see com.instructure.canvas.service.CanvasUserLocalServiceUtil
 */
public class CanvasUserLocalServiceImpl extends CanvasUserLocalServiceBaseImpl {

	public static final String PAGE_MARKER_1 = "&page=";
	public static final String PAGE_MARKER_2 = "?page=";

	public List<CanvasUser> getTeachersByCourseId(String courseId) throws PortalException {

		if (Validator.isNull(courseId)) {
			return new ArrayList<CanvasUser>();
		}

		List<CanvasUser> canvasUsers = null;

		try {
			String apiUrl = "/courses/" + courseId + "/enrollments";

			StringBuilder params = new StringBuilder();
			params.append(URLEncoder.encode("type", "UTF-8"))
					.append("=")
					.append(URLEncoder.encode("TeacherEnrollment", "UTF-8"));

			canvasUsers = getAllCanvasUsers(apiUrl, params);
		}
		catch (IOException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}

			throw new PortalException(e);
		}
		catch (JSONException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}

			throw new PortalException(e);
		}

		canvasUsers = (canvasUsers == null) ? new ArrayList<CanvasUser>() : canvasUsers;

		return canvasUsers;
	}

	public List<CanvasUser> getStudentsByCourseId(
			String courseId, int[] total,
			int page, int perPage, String orderBy, boolean ascending)
			throws SystemException, PortalException {
		if (Validator.isNull(courseId)) {
			return new ArrayList<CanvasUser>();
		}

		List<CanvasUser> canvasUsers;

		try {
			String apiUrl = "/courses/" + courseId + "/enrollments";

			StringBuilder params = new StringBuilder();
			params.append(URLEncoder.encode("type", "UTF-8"))
					.append(StringPool.EQUAL)
					.append(URLEncoder.encode("StudentEnrollment", "UTF-8"));

			params.append("&")
					.append(URLEncoder.encode("state[]", "UTF-8"))
					.append(StringPool.EQUAL)
					.append(URLEncoder.encode("active", "UTF-8"));

			params.append("&")
					.append(URLEncoder.encode("state[]", "UTF-8"))
					.append(StringPool.EQUAL)
					.append(URLEncoder.encode("invited", "UTF-8"));

			params.append("&")
					.append(URLEncoder.encode("state[]", "UTF-8"))
					.append(StringPool.EQUAL)
					.append(URLEncoder.encode("completed", "UTF-8"));

			if (perPage != -1) {
				params.append("&")
						.append(URLEncoder.encode("per_page", "UTF-8"))
						.append(StringPool.EQUAL)
						.append(URLEncoder.encode(String.valueOf(perPage), "UTF-8"));
			}
			else {
				params.append("&")
						.append(URLEncoder.encode("per_page", "UTF-8"))
						.append(StringPool.EQUAL)
						.append(URLEncoder.encode("999", "UTF-8"));
			}

			canvasUsers = getPaginatedCanvasUsers(apiUrl, params, total, page, perPage);
			
			if (Validator.isNotNull(orderBy) && Validator.isNotNull(ascending)) {
				canvasUsers = getSortedCanvasUsers(canvasUsers, orderBy, ascending);
			}
		}
		catch (IOException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}

			throw new PortalException(e);
		}

		canvasUsers = (canvasUsers == null) ? new ArrayList<CanvasUser>() : canvasUsers;

		return canvasUsers;
	}

	public List<CanvasUser> getStudentsByCourseId(String courseId) throws SystemException, PortalException {
		if (Validator.isNull(courseId)) {
			return new ArrayList<CanvasUser>();
		}

		List<CanvasUser> canvasUsers;

		try {
			String apiUrl = "/courses/" + courseId + "/enrollments";

			StringBuilder params = new StringBuilder("type=StudentEnrollment&state[]=active&state[]=invited&state[]=completed");
			
			canvasUsers = getAllCanvasUsers(apiUrl, params);
		}
		catch (IOException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}

			throw new PortalException(e);
		}

		canvasUsers = (canvasUsers == null) ? new ArrayList<CanvasUser>() : canvasUsers;
		if (_log.isDebugEnabled()) {
			_log.debug("Returning " + canvasUsers.size() + " students");
		}
		return canvasUsers;
	}

	public List<CanvasUser> searchUsers(
			String rootAccountId, String keywords, int[] total,
			int page, int perPage, String orderBy, boolean ascending)
			throws SystemException, PortalException {

		if( Validator.isNull(rootAccountId) || Validator.isNull(keywords)) {
			if (total != null && total.length == 1) {
				total[0] = 0;
			}

			return new ArrayList<CanvasUser>();
		}
		else if(keywords.length()<3)
		{
			throw new SearchException("user-search-length-error");
			
		}
		
		List<CanvasUser> canvasUsers = null;

		try {
			String apiUrl = "/accounts/" + rootAccountId + "/users";

			StringBuilder params = new StringBuilder()
                    .append(URLEncoder.encode("search_term", "UTF-8"))
                    .append("=")
                    .append(URLEncoder.encode(keywords, "UTF-8"));
			
			canvasUsers = getSortedPaginatedCanvasUsers(apiUrl, params, total, page, perPage, orderBy, ascending, rootAccountId);
		}
		catch (UnsupportedEncodingException e) {
			throw new PortalException(e);
		}
		catch (MalformedURLException e) {
			throw new PortalException(e);
		}
		catch (ProtocolException e) {
			throw new PortalException(e);
		}
		catch (IOException e) {
			throw new PortalException(e);
		}

		return canvasUsers;
	}

	public String createUser(
			String userId, String loginId, String password, String firstName, String lastName,
			String email, String status, String rootAccountId) throws IOException {

		String params = URLEncoder.encode(
				"user[name]", "UTF-8") + "=" + URLEncoder.encode(firstName + " " + lastName, "UTF-8");
		params += "&" + URLEncoder.encode(
				"pseudonym[unique_id]", "UTF-8") + "=" + URLEncoder.encode(loginId, "UTF-8");
		params += "&" + URLEncoder.encode(
				"pseudonym[password]", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
		params += "&" + URLEncoder.encode(
				"pseudonym[send_confirmation", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8");

		if (_log.isDebugEnabled()) {
			_log.debug(params);
		}

		String apiUrl = "/accounts/" + rootAccountId + "/users";

		if (_log.isDebugEnabled()) {
			_log.debug(apiUrl + "?" + params);
		}

		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

		urlc.setDoOutput(true);
		urlc.setRequestMethod("POST");

		PrintWriter pw = UnsyncPrintWriterPool.borrow(urlc.getOutputStream());

		pw.println(params);

		pw.close();

		UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(
						new InputStreamReader(urlc.getInputStream()));

		String httpStatus = unsyncBufferedReader.readLine();

		if (_log.isDebugEnabled()) {
			_log.debug(httpStatus);
		}

		unsyncBufferedReader.close();

		urlc.disconnect();

		return httpStatus;
	}

	public String updateUser(String userId, String fullName) throws IOException {
		return updateUser(userId, fullName, null, null, null);
	}

	public String updateUser(String userId, String fullName, String language) throws IOException {
		return updateUser(userId, fullName, language, null, null);
	}

	public String updateUser(String userId, String fullName, String language, String avatarUrl) throws IOException {
		return updateUser(userId, fullName, language, avatarUrl, null);
	}

	public String updateUserTimeZone(String userId, String fullName, String timeZoneId) throws IOException {
		return updateUser(userId, fullName, null, null, timeZoneId);
	}

	public String updateUser(String userId, String fullName, String language, String avatarUrl, String timeZoneId)
			throws IOException {

		long processStartTime = System.currentTimeMillis();

		String params = URLEncoder.encode("user[name]", "UTF-8") + "=" + URLEncoder.encode(fullName, "UTF-8");
		params += "&" + URLEncoder.encode("user[short_name]", "UTF-8") + "=" + URLEncoder.encode(fullName, "UTF-8");
		if (language != null) {
			params += "&" + URLEncoder.encode("user[locale]", "UTF-8") + "=" + URLEncoder.encode(language, "UTF-8");
		}
		if (avatarUrl != null) {
			params += "&" + URLEncoder.encode("user[avatar][url]", "UTF-8") + "=" + URLEncoder.encode(avatarUrl, "UTF-8");
		}
		if (timeZoneId != null) {
			params += "&" + URLEncoder.encode("user[time_zone]", "UTF-8") + "=" + URLEncoder.encode(timeZoneId, "UTF-8");
		}

		if (_log.isDebugEnabled()) {
			_log.debug(params);
		}

		String apiUrl = "/users/" + userId;

		if (_log.isDebugEnabled()) {
			_log.debug(apiUrl + "?" + params);
		}

		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);
		String targetURL = urlc.getURL().toString();

		urlc.setDoOutput(true);
		urlc.setRequestMethod("PUT");
		urlc.setRequestProperty(
			HttpHeaders.CONTENT_TYPE, 
			ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED_UTF8);

		OutputStreamWriter out = new OutputStreamWriter(
				urlc.getOutputStream());
		out.write(params);
		out.close();

		UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));
		long streamTime = System.currentTimeMillis();

		String httpStatus = unsyncBufferedReader.readLine();

		if (_log.isDebugEnabled()) {
			_log.debug(httpStatus);
		}

		unsyncBufferedReader.close();

		long processEndTime = System.currentTimeMillis();

		if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds. "+
			"It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas. "+
			"It took: " + (processEndTime - streamTime) + " milliseconds to process stream. "+
			"URL: " + targetURL);
		}

		urlc.disconnect();

		return httpStatus;

	}

	/**
	 * Provide capability to merge Pure Student User Accounts in NetSpace
	 * @param sourceCanvasUserId
	 * @param targetCanvasUserId
	 * @return
	 * @throws IOException
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public String mergerStudentUser(String sourceCanvasUserId, String targetCanvasUserId)
			throws IOException, PortalException, SystemException {

		long processStartTime = System.currentTimeMillis();

		StringBuffer apiUrl = new StringBuffer();
		apiUrl.append("/users/").append(sourceCanvasUserId).append("/merge_into/").append(targetCanvasUserId);
		
		_log.info("Merge API URL: " + apiUrl);
		
		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl.toString(), "");
		String targetURL = urlc.getURL().toString();
		
		urlc.setDoOutput(true);
		urlc.setRequestMethod(HttpMethods.PUT);
		urlc.setRequestProperty(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED_UTF8);
		
		
		UnsyncBufferedReader unsyncBufferedReader = new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));
		long streamTime = System.currentTimeMillis();
		
		String outputStatus = unsyncBufferedReader.readLine();
		
		_log.info("Merged student from source canvasId: " + sourceCanvasUserId + " into target canvasId: " + targetCanvasUserId
				+ " with the status: " + outputStatus);
		
		unsyncBufferedReader.close();
		
		long processEndTime = System.currentTimeMillis();
		
		if ((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds. "+
					"It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas. "+
					"It took: " + (processEndTime - streamTime) + " milliseconds to process stream. "+
					"URL: " + targetURL);
		}
		
		urlc.disconnect();
		
		//users/:id/merge_into/:destination_user_id 

		return outputStatus;
	}

	public void updateEmailNotificationsPreference(String userId, String emailAddress) throws SystemException {

		try {
			long processStartTime = System.currentTimeMillis();

			String apiUrl = "/users/" + userId + "/communication_channels";

			HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, "");

			String targetUrl = urlc.getURL().toString();
			if (_log.isDebugEnabled()) {
				_log.debug(targetUrl);
			}

			UnsyncBufferedReader unsyncBufferedReader =
					new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));

			long streamTime = System.currentTimeMillis();

			StringBuilder httpResponse = new StringBuilder();
			String line;

			while ((line = unsyncBufferedReader.readLine()) != null) {
				httpResponse.append(line).append(StringPool.NEW_LINE);
			}

			unsyncBufferedReader.close();

			if (_log.isDebugEnabled()) {
				_log.debug(httpResponse);
			}

			JSONArray commChannels = JSONFactoryUtil.createJSONArray(httpResponse.toString());

			//collect all email channels to delete
			List<String> idsToDelete = new ArrayList<String>();

			for (int i = 0; i < commChannels.length(); i++) {
				JSONObject commChannel = commChannels.getJSONObject(i);

				String type = commChannel.getString("type");

				if (type != null && type.equals("email")) {
					String email = commChannel.getString("address");

					if (!emailAddress.equals(email)) {
						idsToDelete.add(commChannel.getString("id"));
					}
				}
			}

			if (_log.isDebugEnabled()) {
				_log.debug(
						"Communication channel ids to delete = " + idsToDelete);
			}

			urlc.disconnect();

			//create new channel for new email address 
			String params = "communication_channel[address]=" + URLEncoder.encode(emailAddress, "UTF-8");
			params += "&communication_channel[type]=" + URLEncoder.encode("email", "UTF-8");

			urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, "");
			urlc.setDoOutput(true);
			urlc.setRequestMethod("POST");

			PrintWriter pw = UnsyncPrintWriterPool.borrow(urlc.getOutputStream());
			pw.println(params);
			pw.close();

			int responseCode = urlc.getResponseCode();

			urlc.disconnect();

			if (_log.isDebugEnabled()) {
				_log.debug("Response code = " + responseCode);
				_log.debug("New communication channel added for userId = " +
						userId + " and email = " + emailAddress);
			}

			if (responseCode != HttpURLConnection.HTTP_OK) {
				_log.info("Failed to add new communication channel for userId = " +
						userId + " and email = " + emailAddress);
			}
			else {
				//successfully added new email, now delete all older emails
				for (String id : idsToDelete) {
					apiUrl = "/users/" + userId +
							"/communication_channels/" + id;

					urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, "");

					if (_log.isDebugEnabled()) {
						_log.debug(urlc.getURL().toString());
					}

					urlc.setDoOutput(true);
					urlc.setRequestMethod("DELETE");
					urlc.connect();

					responseCode = urlc.getResponseCode();

					if (_log.isDebugEnabled()) {
						_log.debug("Response code = " + responseCode);
						if (responseCode == HttpURLConnection.HTTP_OK) {
							_log.debug("Deleted communication channel for userId = " +
									userId + " and email = " + emailAddress);
						}
					}

					if (responseCode != HttpURLConnection.HTTP_OK) {
						_log.info("Failed to delete communication channel for userId = " +
								userId + " and email = " + emailAddress);
					}

					urlc.disconnect();
				}
			}

			long processEndTime = System.currentTimeMillis();

			if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
				_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds. "+
				"It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas. "+
				"It took: " + (processEndTime - streamTime) + " milliseconds to process stream. "+
				"URL: " + targetUrl);
			}
		}
		catch (MalformedURLException e) {
			_log.error(e);

			throw new SystemException(e);
		}
		catch (IOException e) {
			_log.error(e);

			throw new SystemException(e);
		}
		catch (JSONException e) {
			_log.error(e);

			throw new SystemException(e);
		}
	}

	public void updateCanvasEmailAddress(String userId, String emailAddress) throws IOException, JSONException {

		long processStartTime = System.currentTimeMillis();

		String apiUrl = "/users/" + userId + "/logins";

		JSONArray entities = CanvasApiUtils.getAllPagesOfCanvasAPI(apiUrl, null);
		
		_log.info("Pseudonym call for user: " + userId + " has " + entities.length() + " items.");
		_log.info("Login account list raw json data: " + entities);
		
		List<String> existinAccountIds = new ArrayList<String>();
		List<JSONObject> uniqueLogins = new ArrayList<JSONObject>();
		
		for (int i = 0; i < entities.length(); i++) {
			String canvasAccountId = entities.getJSONObject(i).getString("account_id");
			String uniqueLoginId = entities.getJSONObject(i).getString("id");
			
			// delete the duplicate pseudonym first (if any exists) before attempting update
			if (existinAccountIds.contains(canvasAccountId)) {
				_log.info("Deleting the duplicate pseudonym for account: " + canvasAccountId + " | full entity: " + entities.getJSONObject(i));
				deletePseudonym(userId, uniqueLoginId);
			} else {
				existinAccountIds.add(canvasAccountId);
				uniqueLogins.add(entities.getJSONObject(i));
			}
		}
		
		// update the email of the unique login accounts
		for (JSONObject entity : uniqueLogins) {
			String canvasAccountId = entity.getString("account_id");
			String uniqueLoginId = entity.getString("id");

			_log.info("Updating user: " + userId + ", setting login to " + emailAddress + " for accountId: " + canvasAccountId
					+ " and unique loginId: " + uniqueLoginId);

			changeEmailAddress(canvasAccountId, uniqueLoginId, emailAddress);
		}

		long processEndTime = System.currentTimeMillis();

		if ((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("It took: " + (processEndTime - processStartTime) + " milliseconds to process URL: " + apiUrl);
		}
	}

	/**
	 * This is a workarround to get rid of a canvas bug in accessing source user courses by SAML authentication
	 * and updating email address latter from profile due to duplicate pseudonyms which gets created
	 * due to merge users as stated in NEX-8273
	 */
	public void fixMergedLogins(String canvasUserId, String targetEmailId) throws IOException, JSONException {
		
		long processStartTime = System.currentTimeMillis();
		
		String apiUrl = "/users/" + canvasUserId + "/logins";
		
		JSONArray entities = CanvasApiUtils.getAllPagesOfCanvasAPI(apiUrl, null);
		
		_log.info("Login account list raw json data: " + entities);
		
		List<String> existingAccounts = new ArrayList<String>();
		
		for (int i = 0; i < entities.length(); i++) {
			String canvasAccountId = entities.getJSONObject(i).getString("account_id");
			String loginEmailId = entities.getJSONObject(i).getString("unique_id");
			
			if (loginEmailId.equals(targetEmailId)) {
				existingAccounts.add(canvasAccountId);
			}
		}
		
		for (int i = 0; i < entities.length(); i++) {
			String canvasAccountId = entities.getJSONObject(i).getString("account_id");
			String loginEmailId = entities.getJSONObject(i).getString("unique_id");
			String loginId = entities.getJSONObject(i).getString("id");
			
			if (!loginEmailId.equals(targetEmailId)) {
				if (existingAccounts.contains(canvasAccountId)) {
					// remove the duplicate account login pseudonym copied from source account
					_log.info("Deleting the duplicate pseudonym for account: " + canvasAccountId + " | full entity: " + entities.getJSONObject(i));
					deletePseudonym(canvasUserId, loginId);
				} else {
					// if the account is just copied from source account, update the email to target email
					_log.info("Updating the email for account: " + canvasAccountId + " from: " + loginEmailId + " to: " + targetEmailId);
					changeEmailAddress(canvasAccountId, loginId, targetEmailId);
				}
			}
		}
		
		long processEndTime = System.currentTimeMillis();
		
		if ((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("It took: " + (processEndTime - processStartTime) + " milliseconds to process URL: " + apiUrl);
		}
	}
	
	/**
	 * Highly inefficient method because it makes N calls to canvas to get ALL
	 * users and then sorts and paginates them, to fix NEX-369.
	 * The requirements are:
	 * 	1. display exact total
	 * 	2. display number of pages
	 * 	3. sort by first or last name
	 * 	4. paginate results
	 *
	 * Constraints:
	 * 	1. Canvas does not support sorting 
	 * 	2. Limits per page to 50
	 * 	3. There is no way to know exact number on the last page.
	 */
	protected List<CanvasUser> getSortedPaginatedCanvasUsers(String apiUrl, StringBuilder params,
															 int[] total, int page,  int perPage, String orderBy,
															 boolean ascending, String rootAccId) throws
			IOException, JSONException, SearchException {

		List<CanvasUser> canvasUsers = new ArrayList<CanvasUser>();

		long startTime = System.currentTimeMillis();

		//get max at a time to reduce the number of canvas calls
		//canvas limits to 50 for all APIs
		params.append("&per_page=50");
		String baseParams = params.toString();
		
		if (_log.isDebugEnabled()) {
			_log.debug(apiUrl + "?" + params.toString());
		}

		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params.append("&page=1").toString());

		int lastPage = -1;

		String linkHeader = urlc.getHeaderField("Link");

		//DEV  - Link: </api/v1/accounts/454/users?page=2&per_page=50>; rel="next",</api/v1/accounts/454/users?page=1&per_page=50>; rel="first",</api/v1/accounts/454/users?page=6&per_page=50>; rel="last"
		//TEST - Link: <https://canvas.cisco.instructure.com/api/v1/accounts/12544/users?user%5Bname%5D=m&page=2&per_page=50>; rel="next",<https://canvas.cisco.instructure.com/api/v1/accounts/12544/users?user%5Bname%5D=m&page=1&per_page=50>; rel="first",<https://canvas.cisco.instructure.com/api/v1/accounts/12544/users?user%5Bname%5D=m&page=5&per_page=50>; rel="last"
		int relLastIndex = -1;

		if (linkHeader != null) {
			relLastIndex = linkHeader.lastIndexOf(StringPool.COMMA);
		}

		if (relLastIndex == -1) {
			//the results do not have multiple pages (only 1 page)
			int relFirstIndex = linkHeader.lastIndexOf("rel=\"first\"");

			//make sure there is at least one page
			if (relFirstIndex != -1) {
				//since there is only 1 page, start from 0
				relLastIndex = 0;
			}
		}

		if (relLastIndex != -1) {
			int pageFromIndex = linkHeader.indexOf(PAGE_MARKER_2, relLastIndex);

			if (pageFromIndex == -1) {
				pageFromIndex = linkHeader.indexOf(PAGE_MARKER_1, relLastIndex);
			}

			int pageToIndex = linkHeader.indexOf(StringPool.AMPERSAND, pageFromIndex + 1);

			if (pageToIndex == -1) {
				pageToIndex = linkHeader.indexOf('>', pageFromIndex);
			}

			if (pageFromIndex != -1 && pageToIndex != -1) {
				String lastPageString = linkHeader.substring(
						pageFromIndex + PAGE_MARKER_1.length(), pageToIndex);

				lastPage = GetterUtil.getInteger(lastPageString);
			}
		}
		
		if(lastPage>4){
			throw new SearchException("search-results-to-large");
		}
		
		for (int i = 2; i <= lastPage + 1; i++) {
			UnsyncBufferedReader unsyncBufferedReader =
					new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));

			StringBuilder httpResponse = new StringBuilder();
			String line;

			while ((line = unsyncBufferedReader.readLine()) != null) {
				httpResponse.append(line).append(StringPool.NEW_LINE);
			}

			unsyncBufferedReader.close();

			JSONArray objects = JSONFactoryUtil.createJSONArray(
					httpResponse.toString());

			for (int j = 0; j < objects.length(); j++) {
				JSONObject object = objects.getJSONObject(j);

				//enrollments return "user" object embedded in enrollments array
				//users return array of user objects
				JSONObject userObject = object.getJSONObject("user");
				JSONObject gradesObject = object.getJSONObject("grades");
				if (userObject == null) {
					userObject = object;
				}

				try {
					CanvasUser canvasUser = getCanvasUser(userObject,
							gradesObject);
					long organizationId = UtilityLocalServiceUtil.getEntityId(PortalUtil.getDefaultCompanyId(),
									Organization.class.getName(), CiscoConstants.EXPANDO_SALESFORCE_ACCOUNT_INSTITUTION_ID, rootAccId);
					long liferayUserId = canvasUser.getUserId();
					
					if (_log.isDebugEnabled()) {
						_log.debug("Trying to find Liferay UserID: "
								+ liferayUserId + "For Org: " + organizationId
								+ ", which has Canvas AccountId: " + rootAccId);
					}

					boolean isUserAssociated = UserLocalServiceUtil
							.hasOrganizationUser(organizationId, liferayUserId);

					if (isUserAssociated) {
						if (_log.isDebugEnabled()) {
							_log.debug("User "
									+ liferayUserId
									+ " is associated with the organization so adding it to final list");
						}
						canvasUsers.add(canvasUser);
					} else {
						if (_log.isDebugEnabled()) {
							_log.debug("User " + liferayUserId
									+ " is not part of the organization"
									+ organizationId + " so skipping it");
						}
					}
				}
				catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.debug(e);
					}
				}
			}

			if (i <= lastPage) {
				params = new StringBuilder(baseParams);
				if (_log.isDebugEnabled()) {
					_log.debug(apiUrl + "?" + params + "&page=" + i);
				}

				urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params.append("&page=").append(i).toString());
			}
		}

		canvasUsers = getSortedCanvasUsers(canvasUsers, orderBy, ascending);

		if (total != null) {
			total[0] = canvasUsers.size();
		}

		int nPages = (int)Math.ceil(canvasUsers.size() / (double)perPage);

		if (page <= nPages) {
			int fromIndex = perPage * (page - 1);
			int toIndex = fromIndex + perPage;

			toIndex = Math.min(canvasUsers.size(), toIndex);

			if (fromIndex < 0 ||
					fromIndex > canvasUsers.size() ||
					toIndex < fromIndex ||
					toIndex > canvasUsers.size()) {
				canvasUsers = Collections.EMPTY_LIST;
			}
			else {
				canvasUsers = canvasUsers.subList(fromIndex, toIndex);
			}
		}
		else {
			canvasUsers = Collections.EMPTY_LIST;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Total time to get/sort/paginate ALL canvas users took " +
					(System.currentTimeMillis() - startTime) + " ms and " + lastPage + " canvas calls.");
		}

		return canvasUsers;
	}

	/**
	 * Get the sorted list of canvas users based on orderby type.
	 * 
	 * @param canvasUserList the canvas user list.
	 * @param orderBy the order by type.
	 * @param isAscending is Ascending.
	 * @return the list of canvas users.
	 */
	protected List<CanvasUser> getSortedCanvasUsers(List<CanvasUser> canvasUserList, String orderBy, boolean isAscending) {
		
		OrderByComparator comparator;
		
		if (orderBy != null && orderBy.equals("firstName")) {
			comparator = new CanvasUserFirstNameComparator(isAscending);
		}
		else {
			comparator = new CanvasUserLastNameComparator(isAscending);
		}

		canvasUserList = (canvasUserList == null) ? new ArrayList<CanvasUser>() : canvasUserList;

		Collections.sort(canvasUserList, comparator);
		
		return canvasUserList;
	}
	
	protected List<CanvasUser> getPaginatedCanvasUsers(String apiUrl, StringBuilder params,
													   int[] total, int page, int perPage)
			throws JSONException, IOException {

		List<CanvasUser> canvasUsers = new ArrayList<CanvasUser>();

		if (page != -1) {
			params.append("&")
					.append(URLEncoder.encode("page", "UTF-8"))
					.append(StringPool.EQUAL)
					.append(URLEncoder.encode(String.valueOf(page), "UTF-8"));
		}

		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params.toString());

		if (_log.isDebugEnabled()) {
			_log.debug(urlc.getURL().toString());
		}

		//read the total from Link header shown below
		//Link: </api/v1/accounts/203/users?page=2&per_page=4>; rel="next",</api/v1/accounts/203/users?page=1&per_page=4>; rel="first",</api/v1/accounts/203/users?page=15&per_page=4>; rel="last"
		//Link: </api/v1/courses/453/enrollments?page=2&per_page=10>; rel="next",</api/v1/courses/453/enrollments?page=1&per_page=10>; rel="first",</api/v1/courses/453/enrollments?page=6&per_page=10>; rel="last"
		String linkHeader = urlc.getHeaderField("Link");

		int fromIndex = linkHeader.lastIndexOf(PAGE_MARKER_1);

		if (fromIndex == -1) {
			fromIndex = linkHeader.lastIndexOf(PAGE_MARKER_2);
		}

		int toIndex = -1;

		if (fromIndex != -1) {
			toIndex = linkHeader.indexOf(StringPool.AMPERSAND, fromIndex + 1);
		}

		if (total != null && total.length == 1) {
			total[0] = 0;
		}

		int nPages = 0;

		if (fromIndex != -1 && toIndex != -1) {
			String pagesTotal =  linkHeader.substring(
					fromIndex + PAGE_MARKER_1.length(), toIndex);

			nPages = GetterUtil.getInteger(pagesTotal);

			if (total != null && total.length == 1) {
				if (nPages == 1 || page == nPages) {
					//if there is only one page then we don't yet know
					//the number of items on this page
					//also if this is the last page then we can get the exact count
					//later
					total[0] = -1;
				}
				else {
					//get the total on last page then add other pages total
					List<CanvasUser> subList = getPaginatedCanvasUsers(
							apiUrl, params, new int[0], nPages, perPage);

					total[0] = ((nPages - 1) * perPage) + subList.size();
				}
			}
		}

		UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));

		StringBuilder httpResponse = new StringBuilder();
		String line;

		while ((line = unsyncBufferedReader.readLine()) != null) {
			httpResponse.append(line).append(StringPool.NEW_LINE);
		}

		unsyncBufferedReader.close();

		if (_log.isDebugEnabled()) {
			_log.debug(httpResponse);
		}

		JSONArray objects = JSONFactoryUtil.createJSONArray(
				httpResponse.toString());

		if (total != null && total.length == 1 && total[0] == -1) {
			if (nPages == 1) {
				//if there is only 1 page of results then total is 
				//the number on of items on this page
				total[0] = objects.length();
			}
			else {
				total[0] = ((nPages - 1) * perPage) + objects.length();
			}
		}

		for (int i = 0; i < objects.length(); i++) {
			JSONObject object = objects.getJSONObject(i);

			//enrollments return "user" object embedded in enrollments array
			//users return array of user objects
			JSONObject userObject = object.getJSONObject("user");
			JSONObject gradesObject = object.getJSONObject("grades");
			if (userObject == null) {
				userObject = object;
			}
			try {
				CanvasUser canvasUser = getCanvasUser(userObject, gradesObject);

				canvasUsers.add(canvasUser);
			} catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(userObject);
					_log.debug(e);
				}
			}
		}

		return canvasUsers;
	}

	protected List<CanvasUser> getAllCanvasUsers(String apiUrl, StringBuilder params)
			throws JSONException, IOException {

		List<CanvasUser> canvasUsers = new ArrayList<CanvasUser>();
		JSONArray objects = CanvasApiUtils.getAllPagesOfCanvasAPI(apiUrl, params.toString());

		if (_log.isDebugEnabled()) {
			_log.debug("Returning " + objects.length() + " users in page 1");
		}
		for (int i = 0; i < objects.length(); i++) {
			JSONObject object = objects.getJSONObject(i);

			//enrollments return "user" object embedded in enrollments array
			//users return array of user objects
			JSONObject userObject = object.getJSONObject("user");
			JSONObject gradesObject = object.getJSONObject("grades");
			if (userObject == null) {
				userObject = object;
			}
			try {
				CanvasUser canvasUser = getCanvasUser(userObject, gradesObject);

				canvasUsers.add(canvasUser);
			} catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(userObject);
					_log.debug(e);
				}
			}
		}

		return canvasUsers;
	}

	protected String changeEmailAddress(String accountId, String id, String emailAddress) throws IOException, JSONException {

		long processStartTime = System.currentTimeMillis();

		String params = URLEncoder.encode("login[unique_id]", "UTF-8") + "=" + URLEncoder.encode(emailAddress, "UTF-8");

		if (_log.isDebugEnabled()) {
			_log.debug(params);
		}

		String apiURL = "/accounts/" + accountId + "/logins/" + id;

		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiURL, params);

		if (_log.isDebugEnabled()) {
			_log.debug(urlc.getURL().toString());
		}

		urlc.setDoOutput(true);
		urlc.setRequestMethod("PUT");
		urlc.setRequestProperty(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED_UTF8);

		OutputStreamWriter out = new OutputStreamWriter(urlc.getOutputStream());
		out.write(params);
		out.close();


		UnsyncBufferedReader unsyncBufferedReader = new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));
		long streamTime = System.currentTimeMillis();

		String status = unsyncBufferedReader.readLine();

		_log.debug("Received response status: " + status + " for " + apiURL);

		unsyncBufferedReader.close();

		long processEndTime = System.currentTimeMillis();

		if ((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds. "+
			"It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas. "+
			"It took: " + (processEndTime - streamTime) + " milliseconds to process stream. "+
			"URL: " + urlc.getURL().toString());
		}

		urlc.disconnect();

		return status;
	}

	protected String deletePseudonym(String canvasUserId, String uniqueLoginId) throws IOException {
		
		long processStartTime = System.currentTimeMillis();
		
		String apiURL = "/users/" + canvasUserId + "/logins/" + uniqueLoginId;
		
		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiURL, null);
		
		if (_log.isDebugEnabled()) {
			_log.debug("ApiURL: " + urlc.getURL().toString());
		}
		
		urlc.setDoOutput(true);
		urlc.setRequestMethod(HttpMethods.DELETE);
		urlc.setRequestProperty(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED_UTF8);
		
		UnsyncBufferedReader unsyncBufferedReader = new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));

		String status = unsyncBufferedReader.readLine();
		
		long streamTime = System.currentTimeMillis();
		
		_log.info("Received response status: " + status + " for " + apiURL);
		
		unsyncBufferedReader.close();
		
		long processEndTime = System.currentTimeMillis();
		
		if ((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds. "+
					"It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas. "+
					"It took: " + (processEndTime - streamTime) + " milliseconds to process stream. "+
					"URL: " + urlc.getURL().toString());
		}
		
		urlc.disconnect();
		
		return status;
	}
	
	protected CanvasUser getCanvasUser(JSONObject user, JSONObject grades) throws Exception {
		CanvasUser canvasUser = new CanvasUserImpl();

		String id = user.getString("id");

		long userId = UtilityLocalServiceUtil.getEntityId(PortalUtil.getDefaultCompanyId(), User.class.getName(), CiscoConstants.EXPANDO_CANVAS_USER_ID, id);

		User liferayUser = UserLocalServiceUtil.getUser(userId);

		String fullName = liferayUser.getFullName();
		String firstName = liferayUser.getFirstName();
		String lastName = liferayUser.getLastName();
		String email = liferayUser.getEmailAddress();

		canvasUser.setFullName(fullName);
		canvasUser.setFirstName(firstName);
		canvasUser.setLastName(lastName);
		canvasUser.setEmail(email);
		canvasUser.setCanvasUserId(id);
		canvasUser.setSID(user.getString("sis_user_id"));
		canvasUser.setUserId(userId);
		canvasUser.setStatus(liferayUser.isActive()? "Active":"Inactive");

		if (grades != null) {
			double score =  grades.getDouble("current_score");

			if (Double.isNaN(score) &&_log.isDebugEnabled()) {
				_log.debug("failed to add current_score " + score + " to the student: " +
						canvasUser.getEmail());
			}
			else {
				canvasUser.setCurrentScore(score);

				if (_log.isDebugEnabled()) {
					_log.debug("Successfully appended current_score to " +
							canvasUser.getEmail());
				}
			}

			score = grades.getDouble("final_score");

			if (Double.isNaN(score) && _log.isDebugEnabled()) {
				_log.debug("failed to add final_score " + score + " to the student: " +
						canvasUser.getEmail());
			}
			else {
				canvasUser.setFinalScore(score);

				if (_log.isDebugEnabled()) {
					_log.debug("Successfully appended final_score to " +
							canvasUser.getEmail());
				}
			}
		}

		return canvasUser;
	}
	
	/* This method is to verify if user exists in root cavanvas account based on root canvas account Id and user email  */
	
	public String isExistingUserInCanvas(String rootAcctID, String emailAddress)throws IOException, JSONException {
		
		String canvasUserId = null;
		 
		String searchAPIURL = "/accounts/" + rootAcctID + "/users?search_term=" + URLEncoder.encode(emailAddress, "UTF-8");
		JSONArray searchResults = CanvasApiUtils.getAllPagesOfCanvasAPI(searchAPIURL);
		
		if (_log.isDebugEnabled()) {
			_log.debug(" searchResults ="+searchResults.length());
			
		}
		
			for (int i = 0; i < searchResults.length(); i++) {
				JSONObject userObject = searchResults.getJSONObject(i);
				
				String login_id  = userObject.getString("login_id");
				
				if(login_id.equals(emailAddress)){
					
					canvasUserId  = userObject.getString("id");
				}
			}
			return canvasUserId;	
	}
	

	private final long TIME_CONSTRAINT = 1000;

	private static Log _log = LogFactoryUtil.getLog(CanvasUserLocalServiceImpl.class);

}