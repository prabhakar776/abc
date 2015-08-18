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

import com.instructure.canvas.model.Assignment;
import com.instructure.canvas.model.Submission;
import com.instructure.canvas.model.impl.SubmissionImpl;
import com.instructure.canvas.service.base.SubmissionLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasURLConnectionFactory;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the submission local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.SubmissionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.SubmissionLocalServiceBaseImpl
 * @see com.instructure.canvas.service.SubmissionLocalServiceUtil
 */
public class SubmissionLocalServiceImpl extends SubmissionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.SubmissionLocalServiceUtil} to access the submission local service.
	 */

	public List<Submission> getCompletionSubmissions(long courseId) {
		return getCompletionSubmissions(courseId, 0);
	}
	
	public Submission getCompletionSubmission(
		long courseId, long canvasUserId) {
		List<Submission> submissions = getCompletionSubmissions(
			courseId, canvasUserId);
		
		if (submissions != null && submissions.size() == 1) {
			return submissions.get(0);
		}
		
		return null;
	}
	
	public List<Submission> getCompletionSubmissions(long courseId, long canvasUserId) {

		long processStartTime = new Date().getTime();

		List<Submission> submissions = new ArrayList<Submission>();
		Assignment assignment = assignmentLocalService.getCompletionAssignment(courseId);
		
		if (assignment == null || 
			Validator.isNull(assignment.getAssignmentId())) {
			return submissions;
		}

        String apiUrl = "/courses/" + courseId + "/assignments/" +
                assignment.getAssignmentId() + "/submissions";

		try {
			HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, "");

            if (_log.isDebugEnabled()) {
                _log.debug("Connecting to submissions list with URL: " + urlc.getURL().toString());
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

			for (int i = 0; i < entities.length(); i++) {
				JSONObject entity = entities.getJSONObject(i);

				Long userId = GetterUtil.getLong(entity.getString("user_id"));
				
				if (canvasUserId != 0 && canvasUserId != userId) {
					continue;
				}
				
				Submission submission = new SubmissionImpl();
				
				submission.setAssignmentId(assignment.getAssignmentId());				
				submission.setCourseId(courseId);
				submission.setGrade(entity.getString("grade"));
				submission.setGraderId(entity.getString("graderId"));
				submission.setSubmissionId(GetterUtil.getLong(entity.getString("id")));
				submission.setUserId(userId);
				submission.setSubmissionDate(entity.getString("submitted_at"));
				
				submissions.add(submission);
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
		catch (MalformedURLException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		} 
		catch (JSONException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		} 
		catch (IOException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
				if (e instanceof java.io.FileNotFoundException) {
					_log.debug("Unable to find assignments for Course " + courseId + " in Canvas");
				}
			}
		}

		return submissions;
	}

	public List<Submission> getSubmissionHistory(String studentId, List<String> assignmentIds, String courseId)
			throws IOException, JSONException {

		long processStartTime = new Date().getTime();

		List<Submission> subList = new ArrayList<Submission>();

		String params = "&" + URLEncoder.encode("student_ids[]", "UTF-8") + "="
				+ URLEncoder.encode(studentId, "UTF-8");

		params += "&" + URLEncoder.encode("include[]=submission_history", "UTF-8");

		for (String assignmentId : assignmentIds) {
			params += "&" + URLEncoder.encode("assignment_ids[]", "UTF-8") + "=" +
					URLEncoder.encode(assignmentId, "UTF-8");
		}

		try {

            String apiUrl = "/courses/" + courseId + "/students/submissions";

			HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params);

			BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

			long streamTime = new Date().getTime();

			if (_log.isDebugEnabled()) {
				_log.debug("Connecting to submission list in canvas with URL:");
				_log.debug(urlc.getURL().toString());
			}

			StringBuilder result = new StringBuilder();
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				result.append(inputLine);
			}

			in.close();

			JSONArray submissions = JSONFactoryUtil.createJSONArray(result.toString());

			for (int j = 0; j < submissions.length(); j++) {
				JSONObject curSubmission = submissions.getJSONObject(j);

				JSONArray jsonHistory = curSubmission.getJSONArray("submission_history");

				for (int k = 0; k < jsonHistory.length(); k++) {
					JSONObject submissionHistory = jsonHistory.getJSONObject(k);

					Submission submission = createSubmission(submissionHistory);

					subList.add(submission);
				}
			}

			long processEndTime = new Date().getTime();

			if((processEndTime - processStartTime) > TIME_CONSTRAINT) {
				_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
				_log.info("It took: " + (streamTime - processStartTime) + " milliseconds to connect to Canvas");
				_log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
				_log.info("URL: " + urlc.getURL().toString());
			}

            urlc.disconnect();
		} catch (MalformedURLException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		} catch (JSONException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		} catch (IOException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		}

		return subList;
	}

	private Submission createSubmission(JSONObject curSubmission) {
		Submission submission= new SubmissionImpl();

		submission.setAssignmentId(curSubmission.getLong("assignment_id"));
		submission.setAttempt(curSubmission.getInt("attempt"));
		submission.setGrade(curSubmission.getString("grade"));
		submission.setHtmlUrl(curSubmission.getString("html_url"));
		submission.setScore(curSubmission.getDouble("score"));
		submission.setSubmissionDate(curSubmission.getString("submitted_at"));
		submission.setGraderId(curSubmission.getString("grader_id"));
		submission.setUserId(curSubmission.getLong("user_id"));

		return submission;
	}
	//Changed from 1000 to one millisec so that all API calls are logged.
	private final long TIME_CONSTRAINT = 1;

	private static Log _log = LogFactoryUtil.getLog(SubmissionLocalServiceImpl.class.getName());
}