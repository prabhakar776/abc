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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Submission}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Submission
 * @generated
 */
public class SubmissionWrapper implements Submission, ModelWrapper<Submission> {
	public SubmissionWrapper(Submission submission) {
		_submission = submission;
	}

	@Override
	public Class<?> getModelClass() {
		return Submission.class;
	}

	@Override
	public String getModelClassName() {
		return Submission.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("submissionId", getSubmissionId());
		attributes.put("assignmentId", getAssignmentId());
		attributes.put("courseId", getCourseId());
		attributes.put("attempt", getAttempt());
		attributes.put("grade", getGrade());
		attributes.put("htmlUrl", getHtmlUrl());
		attributes.put("score", getScore());
		attributes.put("submissionDate", getSubmissionDate());
		attributes.put("graderId", getGraderId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long submissionId = (Long)attributes.get("submissionId");

		if (submissionId != null) {
			setSubmissionId(submissionId);
		}

		Long assignmentId = (Long)attributes.get("assignmentId");

		if (assignmentId != null) {
			setAssignmentId(assignmentId);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Integer attempt = (Integer)attributes.get("attempt");

		if (attempt != null) {
			setAttempt(attempt);
		}

		String grade = (String)attributes.get("grade");

		if (grade != null) {
			setGrade(grade);
		}

		String htmlUrl = (String)attributes.get("htmlUrl");

		if (htmlUrl != null) {
			setHtmlUrl(htmlUrl);
		}

		Double score = (Double)attributes.get("score");

		if (score != null) {
			setScore(score);
		}

		String submissionDate = (String)attributes.get("submissionDate");

		if (submissionDate != null) {
			setSubmissionDate(submissionDate);
		}

		String graderId = (String)attributes.get("graderId");

		if (graderId != null) {
			setGraderId(graderId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this submission.
	*
	* @return the primary key of this submission
	*/
	@Override
	public long getPrimaryKey() {
		return _submission.getPrimaryKey();
	}

	/**
	* Sets the primary key of this submission.
	*
	* @param primaryKey the primary key of this submission
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_submission.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the submission ID of this submission.
	*
	* @return the submission ID of this submission
	*/
	@Override
	public long getSubmissionId() {
		return _submission.getSubmissionId();
	}

	/**
	* Sets the submission ID of this submission.
	*
	* @param submissionId the submission ID of this submission
	*/
	@Override
	public void setSubmissionId(long submissionId) {
		_submission.setSubmissionId(submissionId);
	}

	/**
	* Returns the assignment ID of this submission.
	*
	* @return the assignment ID of this submission
	*/
	@Override
	public long getAssignmentId() {
		return _submission.getAssignmentId();
	}

	/**
	* Sets the assignment ID of this submission.
	*
	* @param assignmentId the assignment ID of this submission
	*/
	@Override
	public void setAssignmentId(long assignmentId) {
		_submission.setAssignmentId(assignmentId);
	}

	/**
	* Returns the course ID of this submission.
	*
	* @return the course ID of this submission
	*/
	@Override
	public long getCourseId() {
		return _submission.getCourseId();
	}

	/**
	* Sets the course ID of this submission.
	*
	* @param courseId the course ID of this submission
	*/
	@Override
	public void setCourseId(long courseId) {
		_submission.setCourseId(courseId);
	}

	/**
	* Returns the attempt of this submission.
	*
	* @return the attempt of this submission
	*/
	@Override
	public int getAttempt() {
		return _submission.getAttempt();
	}

	/**
	* Sets the attempt of this submission.
	*
	* @param attempt the attempt of this submission
	*/
	@Override
	public void setAttempt(int attempt) {
		_submission.setAttempt(attempt);
	}

	/**
	* Returns the grade of this submission.
	*
	* @return the grade of this submission
	*/
	@Override
	public java.lang.String getGrade() {
		return _submission.getGrade();
	}

	/**
	* Sets the grade of this submission.
	*
	* @param grade the grade of this submission
	*/
	@Override
	public void setGrade(java.lang.String grade) {
		_submission.setGrade(grade);
	}

	/**
	* Returns the html url of this submission.
	*
	* @return the html url of this submission
	*/
	@Override
	public java.lang.String getHtmlUrl() {
		return _submission.getHtmlUrl();
	}

	/**
	* Sets the html url of this submission.
	*
	* @param htmlUrl the html url of this submission
	*/
	@Override
	public void setHtmlUrl(java.lang.String htmlUrl) {
		_submission.setHtmlUrl(htmlUrl);
	}

	/**
	* Returns the score of this submission.
	*
	* @return the score of this submission
	*/
	@Override
	public double getScore() {
		return _submission.getScore();
	}

	/**
	* Sets the score of this submission.
	*
	* @param score the score of this submission
	*/
	@Override
	public void setScore(double score) {
		_submission.setScore(score);
	}

	/**
	* Returns the submission date of this submission.
	*
	* @return the submission date of this submission
	*/
	@Override
	public java.lang.String getSubmissionDate() {
		return _submission.getSubmissionDate();
	}

	/**
	* Sets the submission date of this submission.
	*
	* @param submissionDate the submission date of this submission
	*/
	@Override
	public void setSubmissionDate(java.lang.String submissionDate) {
		_submission.setSubmissionDate(submissionDate);
	}

	/**
	* Returns the grader ID of this submission.
	*
	* @return the grader ID of this submission
	*/
	@Override
	public java.lang.String getGraderId() {
		return _submission.getGraderId();
	}

	/**
	* Sets the grader ID of this submission.
	*
	* @param graderId the grader ID of this submission
	*/
	@Override
	public void setGraderId(java.lang.String graderId) {
		_submission.setGraderId(graderId);
	}

	/**
	* Returns the user ID of this submission.
	*
	* @return the user ID of this submission
	*/
	@Override
	public long getUserId() {
		return _submission.getUserId();
	}

	/**
	* Sets the user ID of this submission.
	*
	* @param userId the user ID of this submission
	*/
	@Override
	public void setUserId(long userId) {
		_submission.setUserId(userId);
	}

	/**
	* Returns the user uuid of this submission.
	*
	* @return the user uuid of this submission
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submission.getUserUuid();
	}

	/**
	* Sets the user uuid of this submission.
	*
	* @param userUuid the user uuid of this submission
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_submission.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _submission.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_submission.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _submission.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_submission.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _submission.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _submission.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_submission.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _submission.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_submission.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_submission.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_submission.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubmissionWrapper((Submission)_submission.clone());
	}

	@Override
	public int compareTo(com.instructure.canvas.model.Submission submission) {
		return _submission.compareTo(submission);
	}

	@Override
	public int hashCode() {
		return _submission.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.Submission> toCacheModel() {
		return _submission.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.Submission toEscapedModel() {
		return new SubmissionWrapper(_submission.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.Submission toUnescapedModel() {
		return new SubmissionWrapper(_submission.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _submission.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _submission.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_submission.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubmissionWrapper)) {
			return false;
		}

		SubmissionWrapper submissionWrapper = (SubmissionWrapper)obj;

		if (Validator.equals(_submission, submissionWrapper._submission)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Submission getWrappedSubmission() {
		return _submission;
	}

	@Override
	public Submission getWrappedModel() {
		return _submission;
	}

	@Override
	public void resetOriginalValues() {
		_submission.resetOriginalValues();
	}

	private Submission _submission;
}