/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.instructure.canvas.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.SubmissionVersionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.SubmissionVersionServiceSoap
 * @generated
 */
public class SubmissionVersionSoap implements Serializable {
	public static SubmissionVersionSoap toSoapModel(SubmissionVersion model) {
		SubmissionVersionSoap soapModel = new SubmissionVersionSoap();

		soapModel.setSubmissionId(model.getSubmissionId());
		soapModel.setAssignmentId(model.getAssignmentId());
		soapModel.setAssignmentName(model.getAssignmentName());
		soapModel.setAttempt(model.getAttempt());
		soapModel.setBody(model.getBody());
		soapModel.setCurrentGrade(model.getCurrentGrade());
		soapModel.setCurrentGradedAt(model.getCurrentGradedAt());
		soapModel.setCurrentGrader(model.getCurrentGrader());
		soapModel.setGradeMatchesCurrentSubmission(model.getGradeMatchesCurrentSubmission());
		soapModel.setGradedAt(model.getGradedAt());
		soapModel.setGrader(model.getGrader());
		soapModel.setGraderId(model.getGraderId());
		soapModel.setNewGrade(model.getNewGrade());
		soapModel.setNewGradedAt(model.getNewGradedAt());
		soapModel.setNewGrader(model.getNewGrader());
		soapModel.setPreviousGrade(model.getPreviousGrade());
		soapModel.setPreviousGradedAt(model.getPreviousGradedAt());
		soapModel.setPreviousGrader(model.getPreviousGrader());
		soapModel.setScore(model.getScore());
		soapModel.setUserName(model.getUserName());
		soapModel.setUserId(model.getUserId());
		soapModel.setSubmissionType(model.getSubmissionType());
		soapModel.setUrl(model.getUrl());
		soapModel.setWorkflowState(model.getWorkflowState());

		return soapModel;
	}

	public static SubmissionVersionSoap[] toSoapModels(
		SubmissionVersion[] models) {
		SubmissionVersionSoap[] soapModels = new SubmissionVersionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubmissionVersionSoap[][] toSoapModels(
		SubmissionVersion[][] models) {
		SubmissionVersionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubmissionVersionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubmissionVersionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubmissionVersionSoap[] toSoapModels(
		List<SubmissionVersion> models) {
		List<SubmissionVersionSoap> soapModels = new ArrayList<SubmissionVersionSoap>(models.size());

		for (SubmissionVersion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubmissionVersionSoap[soapModels.size()]);
	}

	public SubmissionVersionSoap() {
	}

	public long getPrimaryKey() {
		return _submissionId;
	}

	public void setPrimaryKey(long pk) {
		setSubmissionId(pk);
	}

	public long getSubmissionId() {
		return _submissionId;
	}

	public void setSubmissionId(long submissionId) {
		_submissionId = submissionId;
	}

	public long getAssignmentId() {
		return _assignmentId;
	}

	public void setAssignmentId(long assignmentId) {
		_assignmentId = assignmentId;
	}

	public String getAssignmentName() {
		return _assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		_assignmentName = assignmentName;
	}

	public int getAttempt() {
		return _attempt;
	}

	public void setAttempt(int attempt) {
		_attempt = attempt;
	}

	public String getBody() {
		return _body;
	}

	public void setBody(String body) {
		_body = body;
	}

	public String getCurrentGrade() {
		return _currentGrade;
	}

	public void setCurrentGrade(String currentGrade) {
		_currentGrade = currentGrade;
	}

	public String getCurrentGradedAt() {
		return _currentGradedAt;
	}

	public void setCurrentGradedAt(String currentGradedAt) {
		_currentGradedAt = currentGradedAt;
	}

	public String getCurrentGrader() {
		return _currentGrader;
	}

	public void setCurrentGrader(String currentGrader) {
		_currentGrader = currentGrader;
	}

	public String getGradeMatchesCurrentSubmission() {
		return _gradeMatchesCurrentSubmission;
	}

	public void setGradeMatchesCurrentSubmission(
		String gradeMatchesCurrentSubmission) {
		_gradeMatchesCurrentSubmission = gradeMatchesCurrentSubmission;
	}

	public String getGradedAt() {
		return _gradedAt;
	}

	public void setGradedAt(String gradedAt) {
		_gradedAt = gradedAt;
	}

	public String getGrader() {
		return _grader;
	}

	public void setGrader(String grader) {
		_grader = grader;
	}

	public long getGraderId() {
		return _graderId;
	}

	public void setGraderId(long graderId) {
		_graderId = graderId;
	}

	public String getNewGrade() {
		return _newGrade;
	}

	public void setNewGrade(String newGrade) {
		_newGrade = newGrade;
	}

	public String getNewGradedAt() {
		return _newGradedAt;
	}

	public void setNewGradedAt(String newGradedAt) {
		_newGradedAt = newGradedAt;
	}

	public String getNewGrader() {
		return _newGrader;
	}

	public void setNewGrader(String newGrader) {
		_newGrader = newGrader;
	}

	public String getPreviousGrade() {
		return _previousGrade;
	}

	public void setPreviousGrade(String previousGrade) {
		_previousGrade = previousGrade;
	}

	public String getPreviousGradedAt() {
		return _previousGradedAt;
	}

	public void setPreviousGradedAt(String previousGradedAt) {
		_previousGradedAt = previousGradedAt;
	}

	public String getPreviousGrader() {
		return _previousGrader;
	}

	public void setPreviousGrader(String previousGrader) {
		_previousGrader = previousGrader;
	}

	public long getScore() {
		return _score;
	}

	public void setScore(long score) {
		_score = score;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getSubmissionType() {
		return _submissionType;
	}

	public void setSubmissionType(String submissionType) {
		_submissionType = submissionType;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getWorkflowState() {
		return _workflowState;
	}

	public void setWorkflowState(String workflowState) {
		_workflowState = workflowState;
	}

	private long _submissionId;
	private long _assignmentId;
	private String _assignmentName;
	private int _attempt;
	private String _body;
	private String _currentGrade;
	private String _currentGradedAt;
	private String _currentGrader;
	private String _gradeMatchesCurrentSubmission;
	private String _gradedAt;
	private String _grader;
	private long _graderId;
	private String _newGrade;
	private String _newGradedAt;
	private String _newGrader;
	private String _previousGrade;
	private String _previousGradedAt;
	private String _previousGrader;
	private long _score;
	private String _userName;
	private long _userId;
	private String _submissionType;
	private String _url;
	private String _workflowState;
}