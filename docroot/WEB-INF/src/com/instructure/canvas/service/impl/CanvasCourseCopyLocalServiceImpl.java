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

import com.instructure.canvas.service.base.CanvasCourseCopyLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasURLConnectionFactory;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.util.portlet.PortletProps;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

/**
 * The implementation of the canvas course copy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.CanvasCourseCopyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.CanvasCourseCopyLocalServiceBaseImpl
 * @see com.instructure.canvas.service.CanvasCourseCopyLocalServiceUtil
 */
public class CanvasCourseCopyLocalServiceImpl
	extends CanvasCourseCopyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.CanvasCourseCopyLocalServiceUtil} to access the canvas course copy local service.
	 */

	public void copyCourse(String sourceCourseId, String newCourseId) throws IOException {

		long processStartTime = new Date().getTime();

		String params = URLEncoder.encode("source_course", "UTF-8") + "=" + URLEncoder.encode(sourceCourseId, "UTF-8");

		if (_log.isDebugEnabled()) {
			_log.debug(params);
		}

        String apiUrl = "/courses/" + newCourseId + "/course_copy";

		HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

        if  (_log.isDebugEnabled()) {
            _log.debug(urlc.getURL().toString());
        }

		urlc.setDoOutput(true);
		urlc.setRequestMethod("POST");

		PrintWriter pw = UnsyncPrintWriterPool.borrow(urlc.getOutputStream());

		pw.close();

		UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));

		long streamTime = new Date().getTime();

		String httpStatus = unsyncBufferedReader.readLine();

		unsyncBufferedReader.close();

		if  (_log.isDebugEnabled()) {
			_log.debug(httpStatus);
		}

		long processEndTime = new Date().getTime();

		if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
			_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
			_log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
			_log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
			_log.info("URL: " + urlc.getURL().toString());
		}

        urlc.disconnect();
	}

	private final long TIME_CONSTRAINT = 1000;

	private static Log _log = LogFactoryUtil.getLog(CanvasCourseCopyLocalServiceImpl.class);
}