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
import com.instructure.canvas.model.CanvasAccount;
import com.instructure.canvas.model.impl.CanvasAccountImpl;
import com.instructure.canvas.service.CanvasAccountLocalServiceUtil;
import com.instructure.canvas.service.CanvasEnrollmentLocalServiceUtil;
import com.instructure.canvas.service.base.CanvasAccountLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasURLConnectionFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.portal.kernel.util.Validator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the canvas account local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.CanvasAccountLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.CanvasAccountLocalServiceBaseImpl
 * @see com.instructure.canvas.service.CanvasAccountLocalServiceUtil
 */
public class CanvasAccountLocalServiceImpl
		extends CanvasAccountLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.CanvasAccountLocalServiceUtil} to access the canvas account local service.
	 */

	public List<CanvasAccount> getAvailableRootAccounts(String userToken) throws JSONException {
		try {
			long processStartTime = new Date().getTime();

            String apiUrl = "/accounts";
            HttpURLConnection urlc;

			if (userToken.equals(StringPool.BLANK)) {
				urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, "");
			} else {
                urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, "", userToken);
            }

			if (_log.isDebugEnabled()) {
				_log.debug("Connecting to root account list in canvas with URL:");
				_log.debug(urlc.getURL().toString());
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

			long streamTime = new Date().getTime();

			StringBuilder result = new StringBuilder();

			String inputLine;

			while ((inputLine = in.readLine()) != null)
				result.append(inputLine);

			in.close();

			JSONArray entities = JSONFactoryUtil.createJSONArray(result.toString());

			List<CanvasAccount> entityList = new ArrayList<CanvasAccount>();

			for (int i = 0; i < entities.length(); i++) {
				JSONObject curEntity = entities.getJSONObject(i);
				CanvasAccount entity = new CanvasAccountImpl();

				entity.setName(curEntity.getString("name"));
				entity.setRootAccountId(curEntity.getString("root_account_id"));
				entity.setParentAccountId(curEntity.getString("parent_account_id"));
				entity.setId(curEntity.getString("id"));
				entity.setSISAccountId(curEntity.getString("sis_account_id"));

				entityList.add(entity);
			}

			long processEndTime = new Date().getTime();

			if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
				_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
				_log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
				_log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
				_log.info("URL: " + urlc.getURL().toString());
			}

            urlc.disconnect();

			return entityList;
		} catch (MalformedURLException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		} catch (IOException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		}

		return new ArrayList<CanvasAccount>();
	}

	public JSONArray getUsers(String accountId) throws IOException, JSONException {

		long processStartTime = new Date().getTime();

		String params = URLEncoder.encode("per_page", "UTF-8") + "=" +
				URLEncoder.encode("999", "UTF-8");

        String apiUrl = "/accounts/" + accountId + "/users";
        HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

        if (_log.isDebugEnabled()) {
			_log.debug("Connecting to root account list in canvas with URL:");
			_log.debug(urlc.getURL().toString());
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

		long streamTime = new Date().getTime();

		StringBuilder result = new StringBuilder();

		String inputLine;

		while ((inputLine = in.readLine()) != null)
			result.append(inputLine);

		in.close();

		JSONArray results = JSONFactoryUtil.createJSONArray(result.toString());

		if (results.length() == 0) {
			return null;
		}

		long processEndTime = new Date().getTime();

		if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
			_log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
			_log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
			_log.info("URL: " + urlc.getURL().toString());
		}

		return results;
	}

	public String addAdmin(String accountId, String userId) throws IOException {

		long processStartTime = new Date().getTime();

		String params = URLEncoder.encode("user_id", "UTF-8") + "=" + URLEncoder.encode(userId, "UTF-8");

		params += "&" + URLEncoder.encode("send_confirmation", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8");

		if (_log.isDebugEnabled()) {
			_log.debug(params);
		}

        String apiUrl = "/accounts/" + accountId + "/admins";
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

		return httpStatus;
	}

	public String removeAdmin(String accountId, String userId) throws IOException {

		long processStartTime = new Date().getTime();

        String apiUrl = "/accounts/" + accountId + "/admins/" + userId;
		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, null);

		if (_log.isDebugEnabled()) {
			_log.debug(urlc.toString());
		}

		urlc.setDoOutput(true);
		urlc.setRequestMethod("DELETE");

		PrintWriter pw = UnsyncPrintWriterPool.borrow(urlc.getOutputStream());
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

		return httpStatus;
	}
	
	public void addPsuedonym(String academyCanvasAccountId, String canvasUserId, String emailAddress, String acadType){
		int tryCount = 5;
		do {
			try {
				CanvasAccountLocalServiceUtil.addPseudonym(
						academyCanvasAccountId, canvasUserId, emailAddress);
				tryCount = 0;
			} catch (Exception e) {
				tryCount--;
				if (_log.isWarnEnabled()) {
						_log.warn("Exception during addPseudonym. User: " + emailAddress	+ " - "	+ canvasUserId
								+ " wasn't added to the "+ academyCanvasAccountId + " academy.");
						_log.warn(e);
				}
			}
		} while (tryCount>0);
	}

	public String addPseudonym(String accountId, String userId, String uniqueIdentifier) throws IOException {

		long processStartTime = new Date().getTime();
		boolean userExists = true;

		try {
			JSONArray array = getPseudonym(accountId, userId);

			if (array == null) {
				userExists = false;
			}
		} catch (Exception e) {
			userExists = false;
		}

		if (userExists) {
			return StringPool.BLANK;
		}

		String params = URLEncoder.encode("user[id]", "UTF-8") + "=" + URLEncoder.encode(userId, "UTF-8");
		params += "&" + URLEncoder.encode("login[unique_id]", "UTF-8") + "=" +
				URLEncoder.encode(uniqueIdentifier, "UTF-8");
		params += "&" + URLEncoder.encode("login[password]", "UTF-8") + "=" +
				URLEncoder.encode("123456", "UTF-8");

		if (_log.isDebugEnabled()) {
			_log.debug(params);
		}

        String apiUrl = "/accounts/" + accountId + "/logins";

		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

		urlc.setDoOutput(true);
		urlc.setRequestMethod("POST");

		PrintWriter pw = UnsyncPrintWriterPool.borrow(urlc.getOutputStream());
		pw.println(params);
		pw.close();
		
		/* Following code avoids IOException and allows us to read response
		 * when response code > 400
		 */
		InputStream is = (urlc.getResponseCode() >= 400) ? urlc.getErrorStream() : urlc.getInputStream();

		UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new InputStreamReader(is));

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

		return httpStatus;
	}
	
	public boolean isPseudonymTaken(String jsonStr) throws SystemException {
		
		boolean taken = false;
		
		try {
			JSONObject entity = JSONFactoryUtil.createJSONObject(jsonStr);
			
			JSONObject errorObj = entity.getJSONObject("errors");
			if (errorObj != null) {
				
				JSONArray uniqIdObjArr = (JSONArray)errorObj.getJSONArray("unique_id");
				if (uniqIdObjArr != null && uniqIdObjArr.length() > 0) {
					JSONObject firstErr = (JSONObject)uniqIdObjArr.getJSONObject(0);
					taken = "taken".equalsIgnoreCase(firstErr.getString("type"));
				}
			}
			
		} catch (JSONException e) {
			_log.error(e);
			throw new SystemException(e);
		}
		
		return taken;
		
	} // isPseudonymTaken

	public String createOrUpdateAccount(String name, String domain) throws IOException {

		long processStartTime = new Date().getTime();

		StringBuilder params = new StringBuilder(URLEncoder.encode("account[name]", "UTF-8")).append("=").append(URLEncoder.encode(name, "UTF-8")).append("&")
				                        .append(URLEncoder.encode("account[domain]", "UTF-8")).append("=").append(URLEncoder.encode(domain, "UTF-8")).append("&")
				                        .append(URLEncoder.encode("account[settings][enable_page_views]", "UTF-8")).append("=db").append("&")
				                        .append(URLEncoder.encode("account[services][analytics]", "UTF-8")).append("=1");
		
		
		if (_log.isDebugEnabled()) {
			_log.debug(params + "\n");
			_log.debug(PropsUtil.get("canvas.base.url"));
		}

        String apiUrl = "/accounts";

        HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params.toString());

		if (_log.isDebugEnabled()) {
			_log.debug(urlc.getURL().toString());
		}

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

		try {
			JSONObject entity = JSONFactoryUtil.createJSONObject(httpStatus);
			String id = entity.getString("id");

				if (_log.isDebugEnabled()) {
					_log.debug("Got ID: " + id + " after creating account");
				}

			addSAMLAuthentication(id);
			addExternalTools(id);
			
			StringBuilder permissions = new StringBuilder()
				.append("permissions[manage_user_logins][explicit]=1")
				.append("&permissions[manage_user_logins][enabled]=0")
				.append("&permissions[manage_user_logins][locked]=1")
				.append("&permissions[read_sis][explicit]=1")
				.append("&permissions[read_sis][enabled]=0")
				.append("&permissions[read_sis][locked]=1")
				.append("&permissions[manage_courses][explicit]=1")
				.append("&permissions[manage_courses][enabled]=0")
				.append("&permissions[manage_courses][locked]=1")
				.append("&permissions[manage_frozen_assignments][enabled]=0");
			
			_setPermissions(id, "AccountAdmin", permissions.toString());

			long processEndTime = new Date().getTime();

			if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
				_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
				_log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
				_log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
				_log.info("URL: " + urlc.getURL().toString());
			}

		} catch (JSONException e) {
				_log.error("Got a json exception when trying to get the id. The data returned from canvas was: " + httpStatus);
				_log.error(e);
		} catch (NullPointerException npe) {
				_log.error(npe);
		} catch (SystemException e) {
				_log.error(e);
		}

        urlc.disconnect();

		return httpStatus;
	}

	public JSONArray getPseudonym(String accountId, String userId) throws IOException, JSONException {

		long processStartTime = new Date().getTime();

		String params = URLEncoder.encode("user[id]", "UTF-8") + "=" + URLEncoder.encode(userId, "UTF-8");

        String apiUrl = "/accounts/" + accountId + "/logins";

		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

		if (_log.isDebugEnabled()) {
			_log.debug("Connecting to root account list in canvas with URL:");
			_log.debug(urlc.getURL().toString());
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

		long streamTime = new Date().getTime();

		StringBuilder result = new StringBuilder();

		String inputLine;

		while ((inputLine = in.readLine()) != null)
			result.append(inputLine);

		in.close();

		JSONArray results = JSONFactoryUtil.createJSONArray(result.toString());

		if (results.length() == 0) {
			return null;
		}

		long processEndTime = new Date().getTime();

		if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
			_log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
			_log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
			_log.info("URL: " + urlc.getURL().toString());
		}

        urlc.disconnect();

		return results;
	}

	public String addSAMLAuthentication(String accountId) throws IOException {

		long processStartTime = new Date().getTime();

		if (_log.isDebugEnabled()) {
			_log.debug("Adding SAML Auth to accountId: " + accountId);
		}
		String samlLoginURL = PropsUtil.get("canvas.saml.authentication.login.url");
		String samlLogoutURL = PropsUtil.get("canvas.saml.authentication.logout.url");
		String fingerprint = PropsUtil.get("canvas.saml.authentication.fingerprint");
		String identifierFormat = PropsUtil.get("canvas.saml.authentication.identifier.format");

		String params = URLEncoder.encode("account_authorization_config[0][log_in_url]", "UTF-8") + "=" +
				URLEncoder.encode(samlLoginURL, "UTF-8");
		params += "&" + URLEncoder.encode("account_authorization_config[0][log_out_url]", "UTF-8") + "=" +
				URLEncoder.encode(samlLogoutURL, "UTF-8");
		params += "&" + URLEncoder.encode("account_authorization_config[0][certificate_fingerprint]", "UTF-8") + "=" +
				URLEncoder.encode(fingerprint, "UTF-8");
		params += "&" + URLEncoder.encode("account_authorization_config[0][identifier_format]", "UTF-8") + "=" +
				URLEncoder.encode(identifierFormat, "UTF-8");
		params += "&" + URLEncoder.encode("account_authorization_config[0][auth_type]", "UTF-8") + "=" +
				URLEncoder.encode("saml", "UTF-8");

		if (_log.isDebugEnabled()) {
			_log.debug(params);
		}
        String apiUrl = "/accounts/" + accountId + "/account_authorization_configs";

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

		return httpStatus;
	}

	public String addExternalTools(String accountId) throws IOException {

		long processStartTime = new Date().getTime();

		String name = PropsUtil.get("canvas.external.tools.name");
		String privacyLevel = PropsUtil.get("canvas.external.tools.privacy.level");
		String consumerKey = PropsUtil.get("canvas.external.tools.consumer.key");
		String sharedSecret = PropsUtil.get("canvas.external.tools.shared.secret");
		String domain = PropsUtil.get("canvas.external.tools.domain");
		String ltiUrl = PropsUtil.get("canvas.external.tools.lti.url");
		String ltiName = PropsUtil.get("canvas.external.tools.lti.name");

		String params = URLEncoder.encode("name", "UTF-8") + "=" +
				URLEncoder.encode(name, "UTF-8");
		params += "&" + URLEncoder.encode("privacy_level", "UTF-8") + "=" +
				URLEncoder.encode(privacyLevel, "UTF-8");
		params += "&" + URLEncoder.encode("consumer_key", "UTF-8") + "=" +
				URLEncoder.encode(consumerKey, "UTF-8");
		params += "&" + URLEncoder.encode("shared_secret", "UTF-8") + "=" +
				URLEncoder.encode(sharedSecret, "UTF-8");
		params += "&" + URLEncoder.encode("domain", "UTF-8") + "=" +
				URLEncoder.encode(domain, "UTF-8");
		
		params += "&" + URLEncoder.encode("course_navigation[url]", "UTF-8") + "=" +
				URLEncoder.encode(ltiUrl, "UTF-8");
		params += "&" + URLEncoder.encode("course_navigation[enabled]", "UTF-8") + "=" +
				URLEncoder.encode("true", "UTF-8");
		params += "&" + URLEncoder.encode("course_navigation[text]", "UTF-8") + "=" +
				URLEncoder.encode(ltiName, "UTF-8");
		params += "&" + URLEncoder.encode("course_navigation[visibility]", "UTF-8") + "=" +
				URLEncoder.encode("admins", "UTF-8");
		
		params += "&" + URLEncoder.encode("account_navigation[url]", "UTF-8") + "=" +
				URLEncoder.encode(ltiUrl, "UTF-8");
		params += "&" + URLEncoder.encode("account_navigation[enabled]", "UTF-8") + "=" +
				URLEncoder.encode("true", "UTF-8");
		params += "&" + URLEncoder.encode("account_navigation[text]", "UTF-8") + "=" +
				URLEncoder.encode(ltiName, "UTF-8");

        params += "&" + URLEncoder.encode("custom_fields[custom_concluded_roles]", "UTF-8") + "=" +
                URLEncoder.encode("$Canvas.membership.concludedRoles", "UTF-8");

		if (_log.isDebugEnabled()) {
			_log.debug(params);
		}

        String apiUrl = "/accounts/" + accountId + "/external_tools";
		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl,params);

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

		return httpStatus;
	}

	public String setPermission(
			String accountId, String roleName, String permissionName, String permission, boolean enabled)
			throws SystemException {

		try {
			long processStartTime = new Date().getTime();

			String enabledValue = "0"; //disabled by default

			if (enabled) {
				enabledValue = "1";
			}

			String params = URLEncoder.encode("permissions[" + permissionName + "][" + permission + "]", "UTF-8") + "=" + URLEncoder.encode(enabledValue, "UTF-8") + "&" +
                            URLEncoder.encode("permissions[" + permissionName + "][explicit]", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");

			if (_log.isDebugEnabled()) {
				_log.debug("setPermission params: " + params);
			}

            String apiUrl = "/accounts/" + accountId + "/roles/" + roleName;

			HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

			urlc.setDoOutput(true);
			urlc.setRequestMethod("PUT");

			OutputStreamWriter out = new OutputStreamWriter(urlc.getOutputStream());
			out.write(params);
			out.close();

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

			return httpStatus;
		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}

			throw new SystemException(e);
		}
	}

    public JSONObject getAccount(String accountId) throws IOException, JSONException {

		long processStartTime = new Date().getTime();

        String params = URLEncoder.encode("includes[]", "UTF-8") + "=" + URLEncoder.encode("domains", "UTF-8");

        String apiUrl = "/accounts/" + accountId;
        HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

        if (_log.isDebugEnabled()) {
            _log.debug("Connecting to accounts list in canvas with URL:");
            _log.debug(urlc.getURL().toString());
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

		long streamTime = new Date().getTime();

        StringBuilder result = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            result.append(inputLine);
        }

        in.close();

		long processEndTime = new Date().getTime();

		if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
			_log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
			_log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
			_log.info("URL: " + urlc.getURL().toString());
		}

        urlc.disconnect();

        return JSONFactoryUtil.createJSONObject(result.toString());
    }

    @Override
    public CanvasAccount getCanvasAccount(long accountId) throws PortalException, SystemException {
        try {
            JSONObject accountJson = getAccount(String.valueOf(accountId));
            CanvasAccount canvasAccount = new CanvasAccountImpl();

            canvasAccount.setAccountId(accountId);
            canvasAccount.setName(accountJson.getString("name"));
            canvasAccount.setRootAccountId(accountJson.getString("root_account_id"));
            canvasAccount.setParentAccountId(accountJson.getString("parent_account_id"));
            canvasAccount.setId(accountJson.getString("id"));
            canvasAccount.setTimeZone(accountJson.getString("default_time_zone"));
            canvasAccount.setSISAccountId(accountJson.getString("sis_account_id"));

            return canvasAccount;
        } catch (Exception e) {
            _log.error(e);
        }

        return null;
    }

    @Override
    public CanvasAccount updateCanvasAccount(CanvasAccount canvasAccount) throws SystemException {
        long processStartTime = new Date().getTime();

        try {
            String params = URLEncoder.encode("account[name]", "UTF-8") + "=" + URLEncoder.encode(canvasAccount.getName(), "UTF-8");
            params += "&" + URLEncoder.encode("account[default_time_zone]", "UTF-8") + "=" + URLEncoder.encode(canvasAccount.getTimeZone(), "UTF-8");

            if (_log.isDebugEnabled()) {
                _log.debug(params + "\n");
                _log.debug(PropsUtil.get("canvas.base.url"));
            }

            String apiUrl = "/accounts/" + String.valueOf(canvasAccount.getAccountId());

            HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

            if (_log.isDebugEnabled()) {
                _log.debug(urlc.getURL().toString());
            }

            urlc.setDoOutput(true);
            urlc.setRequestMethod("PUT");
            urlc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

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

            urlc.disconnect();
        } catch (Exception e) {
            throw new SystemException(e);
        }

        return canvasAccount;
    }

    public JSONObject setAccountName(String accountId, String name) throws IOException, JSONException {
        long processStartTime = new Date().getTime();

        String params = URLEncoder.encode("account[name]", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");

        String apiURL = "/accounts/" + accountId;
        HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiURL, params);

        if (_log.isDebugEnabled()) {
            _log.debug("Updating account name in canvas with URL:");
            _log.debug(urlc.getURL().toString());
        }

        urlc.setDoOutput(true);
        urlc.setRequestMethod("PUT");
		urlc.setRequestProperty(
			HttpHeaders.CONTENT_TYPE, 
			ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED_UTF8);

        OutputStreamWriter out = new OutputStreamWriter(urlc.getOutputStream());
        out.write(params);
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

        long streamTime = new Date().getTime();

        StringBuilder result = new StringBuilder();

        String inputLine;

        while ((inputLine = in.readLine()) != null)
            result.append(inputLine);

        in.close();

        long processEndTime = new Date().getTime();

        if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
            _log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
            _log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
            _log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
            _log.info("URL: " + urlc.getURL().toString());
        }

        if (_log.isDebugEnabled()) {
            _log.debug("Return Object: \n" + result);
        }

        urlc.disconnect();

        return JSONFactoryUtil.createJSONObject(result.toString());
    }

    public String getAccountDomain(String userId) throws IOException, JSONException {
        JSONArray enrollmentArray = CanvasEnrollmentLocalServiceUtil.getEnrollmentsForUser(userId, null);
        for (int i = 0; enrollmentArray != null && i < enrollmentArray.length(); i++) {
            JSONObject curEnrollment = enrollmentArray.getJSONObject(i);
            if (curEnrollment != null) {
                String accountId = curEnrollment.getString("root_account_id");
                if (Validator.isNotNull(accountId)) {
                    String domainHost = getDomainHost(accountId);
                    if (Validator.isNotNull(domainHost)) {
                        return domainHost;
                    }
                }
            }
        }
        return null;
    }

    private String getDomainHost(String accountId) throws IOException, JSONException {
        JSONObject account = getAccount(accountId);
        if (account != null) {
            String domains = account.getString("domains");
            if (Validator.isNotNull(domains)) {
                JSONArray domainArray = JSONFactoryUtil.createJSONArray(domains);
                for (int j = 0; domainArray != null && j < domainArray.length(); j++) {
                    JSONObject domainEntity = domainArray.getJSONObject(j);
                    if (domainEntity != null) {
                        return domainEntity.getString("host");
                    }
                }
            }
        }
        return null;
    }
	
	/**
	 * Sets permissions on an existing role. So effectively, updates the role
	 * and hence uses http PUT method on canvas call. 
	 */
	private void _setPermissions(String accountId, String roleName, String permissions) throws SystemException {
		try {

            String apiUrl = "/accounts/" + accountId + "/roles/" + roleName;

            HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, "");

			if (_log.isDebugEnabled()) {
				_log.debug(urlc.getURL().toString());
				_log.debug("permissions = " + permissions);
			}


			urlc.setDoOutput(true);
			urlc.setRequestMethod("PUT");
			urlc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			OutputStreamWriter out = new OutputStreamWriter(urlc.getOutputStream());
			out.write(permissions);
			out.close();
						
			int responseCode = urlc.getResponseCode();

			if (_log.isDebugEnabled()) {
				_log.debug("Response code = " + responseCode);
			}

			if (responseCode != HttpURLConnection.HTTP_OK) {
				_log.error("Unable to set permissions for role " + roleName + ", and accountId " + accountId);
			}
		} 
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}

			throw new SystemException(e);
		}
	}
	final long TIME_CONSTRAINT = 1000;

	private static Log _log = LogFactoryUtil.getLog(
			CanvasAccountLocalServiceImpl.class);
}