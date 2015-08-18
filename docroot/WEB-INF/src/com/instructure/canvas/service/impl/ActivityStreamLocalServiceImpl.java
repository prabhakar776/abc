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

import com.instructure.canvas.model.ActivityStream;
import com.instructure.canvas.model.impl.ActivityStreamImpl;
import com.instructure.canvas.service.base.ActivityStreamLocalServiceBaseImpl;
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
 * The implementation of the activity stream local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.ActivityStreamLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.ActivityStreamLocalServiceBaseImpl
 * @see com.instructure.canvas.service.ActivityStreamLocalServiceUtil
 */
public class ActivityStreamLocalServiceImpl
        extends ActivityStreamLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.ActivityStreamLocalServiceUtil} to access the activity stream local service.
	 */

    public List<ActivityStream> getActivityStreams(String userToken) throws JSONException {
        try {

            long processStartTime = new Date().getTime();

            if (userToken.equals(StringPool.BLANK)) {
                userToken = PropsUtil.get("canvas.token");
            }

            String params = URLEncoder.encode("as_user_id", "UTF-8") + "=" +
                    URLEncoder.encode(userToken, "UTF-8");

            String apiUrl = "/users/activity_stream";
            HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

            if (_log.isDebugEnabled()) {
                _log.debug("Connecting to user activity stream in canvas with URL:");
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

            JSONArray entities = JSONFactoryUtil.createJSONArray(result.toString());

            List<ActivityStream> entityList = new ArrayList<ActivityStream>();

            for (int i = 0; i < entities.length(); i++) {
                JSONObject curEntity = entities.getJSONObject(i);
                ActivityStream entity = new ActivityStreamImpl();

                entity.setCreatedAt(curEntity.getString("created_at"));
                entity.setUpdatedAt(curEntity.getString("updates_at"));
                entity.setId(curEntity.getLong("id"));
                entity.setTitle(curEntity.getString("title"));
                entity.setMessage(curEntity.getString("message"));
                entity.setType(curEntity.getString("type"));
                entity.setContextType(curEntity.getString("context_type"));
                entity.setCourseId(curEntity.getLong("course_id"));
                entity.setGroupId(curEntity.getString("group_id"));
                entity.setHtmlUrl(curEntity.getString("html_url"));
                
                entityList.add(entity);
            }

			long processEndTime = new Date().getTime();

            if (_log.isInfoEnabled()) {
                _log.info("It took: " + (processEndTime - processStartTime) + " milliseconds to complete process");
            }
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
        return new ArrayList<ActivityStream>();
    }

    private final long TIME_CONSTRAINT = 1000;

    private static Log _log = LogFactoryUtil.getLog(
            ActivityStreamLocalServiceImpl.class);
}
