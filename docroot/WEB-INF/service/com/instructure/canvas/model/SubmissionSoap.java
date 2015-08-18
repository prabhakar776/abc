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
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.SubmissionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.SubmissionServiceSoap
 * @generated
 */
public class SubmissionSoap implements Serializable {
	public static SubmissionSoap toSoapModel(Submission model) {
		SubmissionSoap soapModel = new SubmissionSoap();

		soapModel.setSubmissionId(model.getSubmissionId());
		soapModel.setAssignmentId(model.getAssignmentId());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setAttempt(model.getAttempt());
		soapModel.setGrade(model.getGrade());
		soapModel.setHtmlUrl(model.getHtmlUrl());
		soapModel.setScore(model.getScore());
		soapModel.setSubmissionDate(model.getSubmissionDate());
		soapModel.setGraderId(model.getGraderId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static SubmissionSoap[] toSoapModels(Submission[] models) {
		SubmissionSoap[] soapModels = new SubmissionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubmissionSoap[][] toSoapModels(Submission[][] models) {
		SubmissionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubmissionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubmissionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubmissionSoap[] toSoapModels(List<Submission> models) {
		List<SubmissionSoap> soapModels = new ArrayList<SubmissionSoap>(models.size());

		for (Submission model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubmissionSoap[soapModels.size()]);
	}

	public SubmissionSoap() {
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

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public int getAttempt() {
		return _attempt;
	}

	public void setAttempt(int attempt) {
		_attempt = attempt;
	}

	public String getGrade() {
		return _grade;
	}

	public void setGrade(String grade) {
		_grade = grade;
	}

	public String getHtmlUrl() {
		return _htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		_htmlUrl = htmlUrl;
	}

	public double getScore() {
		return _score;
	}

	public void setScore(double score) {
		_score = score;
	}

	public String getSubmissionDate() {
		return _submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		_submissionDate = submissionDate;
	}

	public String getGraderId() {
		return _graderId;
	}

	public void setGraderId(String graderId) {
		_graderId = graderId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _submissionId;
	private long _assignmentId;
	private long _courseId;
	private int _attempt;
	private String _grade;
	private String _htmlUrl;
	private double _score;
	private String _submissionDate;
	private String _graderId;
	private long _userId;
}