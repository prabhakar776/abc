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

import com.instructure.canvas.model.Todo;
import com.instructure.canvas.model.impl.TodoImpl;
import com.instructure.canvas.service.base.TodoLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasURLConnectionFactory;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the todo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.TodoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.TodoLocalServiceBaseImpl
 * @see com.instructure.canvas.service.TodoLocalServiceUtil
 */
public class TodoLocalServiceImpl extends TodoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.TodoLocalServiceUtil} to access the todo local service.
	 */

    public List<Todo> getTodos(String userToken) throws JSONException {

		long processStartTime = new Date().getTime();

		try {
            if (userToken.equals(StringPool.BLANK)) {
                userToken = PropsUtil.get("canvas.token");
            }

            String params = URLEncoder.encode("as_user_id", "UTF-8") + "=" +
                    URLEncoder.encode(userToken, "UTF-8");
            String apiUrl = "/users/self/todo";
            HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

            if (_log.isDebugEnabled()) {
                _log.debug("Connecting to user todo list with URL:");
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

            List<Todo> entityList = new ArrayList<Todo>();

            for (int i = 0; i < entities.length(); i++) {
                JSONObject curEntity = entities.getJSONObject(i);
                JSONObject assignment = JSONFactoryUtil.createJSONObject(curEntity.getString("assignment"));
                Todo entity = new TodoImpl();

                entity.setType(curEntity.getString("type"));
                entity.setAssignmentName(assignment.getString("name"));
                entity.setAssignmentDescription(assignment.getString("description"));
                entity.setIgnore_(curEntity.getString("ignore"));
                entity.setIgnorePermanently(curEntity.getString("ignore_permanently"));
                entity.setHtmlUrl(curEntity.getString("html_url"));
                entity.setNeedsGradingCount(curEntity.getLong("needs_grading_count"));
                entity.setContextType(curEntity.getString("context_type"));
                entity.setCourseId(curEntity.getString("course_id"));
                entity.setGroupId(curEntity.getString("group_id"));

                entityList.add(entity);
            }
			long processEndTime = new Date().getTime();

			if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
				_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
				_log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
				_log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
				_log.info("URL: " + urlc.getURL().toString());
			}

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

		return new ArrayList<Todo>();
	}

	private final long TIME_CONSTRAINT = 1000;

    private static Log _log = LogFactoryUtil.getLog(TodoLocalServiceImpl.class);

}
