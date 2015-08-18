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
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.instructure.canvas.model.Submission;
import com.instructure.canvas.model.SubmissionVersion;
import com.instructure.canvas.model.impl.SubmissionVersionImpl;
import com.instructure.canvas.service.base.SubmissionVersionLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasApiUtils;
import com.instructure.canvas.util.CanvasURLConnectionFactory;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * The implementation of the submission version local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.SubmissionVersionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.SubmissionVersionLocalServiceBaseImpl
 * @see com.instructure.canvas.service.SubmissionVersionLocalServiceUtil
 */
public class SubmissionVersionLocalServiceImpl
	extends SubmissionVersionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.SubmissionVersionLocalServiceUtil} to access the submission version local service.
	 */
	
	public List<SubmissionVersion> getSubmissionHistory(String studentId, String courseId)
			throws IOException, JSONException {
		return getSubmissionHistory(studentId, null, courseId);
	}
	
	public List<SubmissionVersion> getSubmissionHistory(List<String> assignmentIds, String courseId) 
			throws IOException, JSONException{
		List<SubmissionVersion> submissions = new ArrayList<SubmissionVersion>();
		
		List<SubmissionVersion> subVersions = getSubmissionHistory(null, null, courseId);
		for(SubmissionVersion sv : subVersions){
			if(assignmentIds.contains(String.valueOf(sv.getAssignmentId()))){
				submissions.add(sv);
			}
		}
		
		return submissions;
	}
	
	
	public List<SubmissionVersion> getSubmissionHistory(String studentId, String assignmentId, String courseId)
			throws IOException, JSONException {
		long start = System.currentTimeMillis();
		List<SubmissionVersion> submissions = new ArrayList<SubmissionVersion>();
		
		String baseParams = "";
		if(studentId != null){
			baseParams = "&" + URLEncoder.encode("user_id", "UTF-8") + "="+ URLEncoder.encode(studentId, "UTF-8");
		}
		if(assignmentId != null){
			baseParams += "&" + URLEncoder.encode("assignment_id", "UTF-8") + "=" +URLEncoder.encode(assignmentId, "UTF-8");
		}
		baseParams += "&" + URLEncoder.encode("per_page=999", "UTF-8");
		
		try {

            String apiUrl = "/courses/" + courseId + "/gradebook_history/feed";
            StringBuilder params = new StringBuilder(baseParams);
            params.append("&page=1");
			HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params.toString());
			
			String linkHeader = urlc.getHeaderField("Link");
			int lastPage = CanvasApiUtils.getApiPageCountWithRegex(linkHeader);
			
			_log.info("Submission History API URL: " + apiUrl + "?" + params);
			
			if (_log.isDebugEnabled()) {
				_log.debug("linkHeader: " + linkHeader + " lastPage: " + lastPage);
			}

			for (int i = 2; i <= lastPage + 1; i++) {
				long reqStart = System.currentTimeMillis();
				BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
	
				long streamTime = new Date().getTime();
	
				if (_log.isDebugEnabled()) {
					_log.debug("Connecting to gradebook_history feed in canvas with URL:");
					_log.debug(urlc.getURL().toString());
				}
	
				StringBuilder result = new StringBuilder();
				String inputLine;
	
				while ((inputLine = in.readLine()) != null) {
					result.append(inputLine);
				}
	
				in.close();
	
				JSONArray submissionsVersions = JSONFactoryUtil.createJSONArray(result.toString());
	
				for (int j = 0; j < submissionsVersions.length(); j++) {
					JSONObject curSubmission = submissionsVersions.getJSONObject(j);
	
					SubmissionVersion submission = createSubmissionVersion(curSubmission);
	
					submissions.add(submission);
				}
				long processEndTime = System.currentTimeMillis();

				if((processEndTime - start) > TIME_CONSTRAINT) {
					_log.info("Transaction exceeded time constraint of " + TIME_CONSTRAINT + " milliseconds");
					_log.info("It took: " + (streamTime - reqStart) + " milliseconds to connect to Canvas");
					_log.info("It took: " + (processEndTime - streamTime) + " milliseconds to process stream");
					_log.info("URL: " + urlc.getURL().toString());
				}
				
				if (i <= lastPage) {
					params = new StringBuilder(baseParams);
					if (_log.isDebugEnabled()) {
						_log.debug(apiUrl + "?" + params + "&page=" + i);
					}

					urlc = CanvasURLConnectionFactory.getCanvasURL(apiUrl, params.append("&page=").append(i).toString());
				}
			}
			_log.info("Total time to process "+lastPage +" pages of submissionHistory "+(System.currentTimeMillis()-start));

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
		return submissions;
	}
	
	private SubmissionVersion createSubmissionVersion(JSONObject curSubmission) {
		SubmissionVersion submissionVersion = new SubmissionVersionImpl();
		
		submissionVersion.setAssignmentId(curSubmission.getLong("assignment_id"));
		submissionVersion.setAssignmentName(curSubmission.getString("assignment_name"));
		submissionVersion.setAttempt(curSubmission.getInt("attempt"));
		submissionVersion.setBody(curSubmission.getString("body"));
		submissionVersion.setCurrentGrade(curSubmission.getString("current_grade"));
		submissionVersion.setCurrentGradedAt(curSubmission.getString("current_graded_at"));
		submissionVersion.setCurrentGrader(curSubmission.getString("current_grader"));
		submissionVersion.setGradeMatchesCurrentSubmission(curSubmission.getString("grade_matches_current_submission"));
		submissionVersion.setGradedAt(curSubmission.getString("graded_at"));
		submissionVersion.setGrader(curSubmission.getString("grader"));
		submissionVersion.setGraderId(curSubmission.getInt("grader_id"));
		submissionVersion.setSubmissionId(curSubmission.getInt("id"));
		submissionVersion.setNewGrade(curSubmission.getString("new_grade"));
		submissionVersion.setNewGradedAt(curSubmission.getString("new_graded_at"));
		submissionVersion.setNewGrader(curSubmission.getString("new_grader"));
		submissionVersion.setPreviousGrade(curSubmission.getString("previous_grade"));
		submissionVersion.setPreviousGradedAt(curSubmission.getString("previous_graded_at"));
		submissionVersion.setPreviousGrader(curSubmission.getString("previous_grader"));
		submissionVersion.setScore(curSubmission.getInt("score"));
		submissionVersion.setUserName(curSubmission.getString("user_name"));
		submissionVersion.setSubmissionType(curSubmission.getString("submission_type"));
		submissionVersion.setUrl(curSubmission.getString("url"));
		submissionVersion.setUserId(curSubmission.getLong("user_id"));
		submissionVersion.setWorkflowState(curSubmission.getString("workflow_state"));
		
		return submissionVersion;
	}

	private final long TIME_CONSTRAINT = 1000;
	private static Log _log = LogFactoryUtil.getLog(SubmissionVersionLocalServiceImpl.class.getName());
}