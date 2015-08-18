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
 * This class is a wrapper for {@link SubmissionVersion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionVersion
 * @generated
 */
public class SubmissionVersionWrapper implements SubmissionVersion,
	ModelWrapper<SubmissionVersion> {
	public SubmissionVersionWrapper(SubmissionVersion submissionVersion) {
		_submissionVersion = submissionVersion;
	}

	@Override
	public Class<?> getModelClass() {
		return SubmissionVersion.class;
	}

	@Override
	public String getModelClassName() {
		return SubmissionVersion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("submissionId", getSubmissionId());
		attributes.put("assignmentId", getAssignmentId());
		attributes.put("assignmentName", getAssignmentName());
		attributes.put("attempt", getAttempt());
		attributes.put("body", getBody());
		attributes.put("currentGrade", getCurrentGrade());
		attributes.put("currentGradedAt", getCurrentGradedAt());
		attributes.put("currentGrader", getCurrentGrader());
		attributes.put("gradeMatchesCurrentSubmission",
			getGradeMatchesCurrentSubmission());
		attributes.put("gradedAt", getGradedAt());
		attributes.put("grader", getGrader());
		attributes.put("graderId", getGraderId());
		attributes.put("newGrade", getNewGrade());
		attributes.put("newGradedAt", getNewGradedAt());
		attributes.put("newGrader", getNewGrader());
		attributes.put("previousGrade", getPreviousGrade());
		attributes.put("previousGradedAt", getPreviousGradedAt());
		attributes.put("previousGrader", getPreviousGrader());
		attributes.put("score", getScore());
		attributes.put("userName", getUserName());
		attributes.put("userId", getUserId());
		attributes.put("submissionType", getSubmissionType());
		attributes.put("url", getUrl());
		attributes.put("workflowState", getWorkflowState());

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

		String assignmentName = (String)attributes.get("assignmentName");

		if (assignmentName != null) {
			setAssignmentName(assignmentName);
		}

		Integer attempt = (Integer)attributes.get("attempt");

		if (attempt != null) {
			setAttempt(attempt);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		String currentGrade = (String)attributes.get("currentGrade");

		if (currentGrade != null) {
			setCurrentGrade(currentGrade);
		}

		String currentGradedAt = (String)attributes.get("currentGradedAt");

		if (currentGradedAt != null) {
			setCurrentGradedAt(currentGradedAt);
		}

		String currentGrader = (String)attributes.get("currentGrader");

		if (currentGrader != null) {
			setCurrentGrader(currentGrader);
		}

		String gradeMatchesCurrentSubmission = (String)attributes.get(
				"gradeMatchesCurrentSubmission");

		if (gradeMatchesCurrentSubmission != null) {
			setGradeMatchesCurrentSubmission(gradeMatchesCurrentSubmission);
		}

		String gradedAt = (String)attributes.get("gradedAt");

		if (gradedAt != null) {
			setGradedAt(gradedAt);
		}

		String grader = (String)attributes.get("grader");

		if (grader != null) {
			setGrader(grader);
		}

		Long graderId = (Long)attributes.get("graderId");

		if (graderId != null) {
			setGraderId(graderId);
		}

		String newGrade = (String)attributes.get("newGrade");

		if (newGrade != null) {
			setNewGrade(newGrade);
		}

		String newGradedAt = (String)attributes.get("newGradedAt");

		if (newGradedAt != null) {
			setNewGradedAt(newGradedAt);
		}

		String newGrader = (String)attributes.get("newGrader");

		if (newGrader != null) {
			setNewGrader(newGrader);
		}

		String previousGrade = (String)attributes.get("previousGrade");

		if (previousGrade != null) {
			setPreviousGrade(previousGrade);
		}

		String previousGradedAt = (String)attributes.get("previousGradedAt");

		if (previousGradedAt != null) {
			setPreviousGradedAt(previousGradedAt);
		}

		String previousGrader = (String)attributes.get("previousGrader");

		if (previousGrader != null) {
			setPreviousGrader(previousGrader);
		}

		Long score = (Long)attributes.get("score");

		if (score != null) {
			setScore(score);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String submissionType = (String)attributes.get("submissionType");

		if (submissionType != null) {
			setSubmissionType(submissionType);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String workflowState = (String)attributes.get("workflowState");

		if (workflowState != null) {
			setWorkflowState(workflowState);
		}
	}

	/**
	* Returns the primary key of this submission version.
	*
	* @return the primary key of this submission version
	*/
	@Override
	public long getPrimaryKey() {
		return _submissionVersion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this submission version.
	*
	* @param primaryKey the primary key of this submission version
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_submissionVersion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the submission ID of this submission version.
	*
	* @return the submission ID of this submission version
	*/
	@Override
	public long getSubmissionId() {
		return _submissionVersion.getSubmissionId();
	}

	/**
	* Sets the submission ID of this submission version.
	*
	* @param submissionId the submission ID of this submission version
	*/
	@Override
	public void setSubmissionId(long submissionId) {
		_submissionVersion.setSubmissionId(submissionId);
	}

	/**
	* Returns the assignment ID of this submission version.
	*
	* @return the assignment ID of this submission version
	*/
	@Override
	public long getAssignmentId() {
		return _submissionVersion.getAssignmentId();
	}

	/**
	* Sets the assignment ID of this submission version.
	*
	* @param assignmentId the assignment ID of this submission version
	*/
	@Override
	public void setAssignmentId(long assignmentId) {
		_submissionVersion.setAssignmentId(assignmentId);
	}

	/**
	* Returns the assignment name of this submission version.
	*
	* @return the assignment name of this submission version
	*/
	@Override
	public java.lang.String getAssignmentName() {
		return _submissionVersion.getAssignmentName();
	}

	/**
	* Sets the assignment name of this submission version.
	*
	* @param assignmentName the assignment name of this submission version
	*/
	@Override
	public void setAssignmentName(java.lang.String assignmentName) {
		_submissionVersion.setAssignmentName(assignmentName);
	}

	/**
	* Returns the attempt of this submission version.
	*
	* @return the attempt of this submission version
	*/
	@Override
	public int getAttempt() {
		return _submissionVersion.getAttempt();
	}

	/**
	* Sets the attempt of this submission version.
	*
	* @param attempt the attempt of this submission version
	*/
	@Override
	public void setAttempt(int attempt) {
		_submissionVersion.setAttempt(attempt);
	}

	/**
	* Returns the body of this submission version.
	*
	* @return the body of this submission version
	*/
	@Override
	public java.lang.String getBody() {
		return _submissionVersion.getBody();
	}

	/**
	* Sets the body of this submission version.
	*
	* @param body the body of this submission version
	*/
	@Override
	public void setBody(java.lang.String body) {
		_submissionVersion.setBody(body);
	}

	/**
	* Returns the current grade of this submission version.
	*
	* @return the current grade of this submission version
	*/
	@Override
	public java.lang.String getCurrentGrade() {
		return _submissionVersion.getCurrentGrade();
	}

	/**
	* Sets the current grade of this submission version.
	*
	* @param currentGrade the current grade of this submission version
	*/
	@Override
	public void setCurrentGrade(java.lang.String currentGrade) {
		_submissionVersion.setCurrentGrade(currentGrade);
	}

	/**
	* Returns the current graded at of this submission version.
	*
	* @return the current graded at of this submission version
	*/
	@Override
	public java.lang.String getCurrentGradedAt() {
		return _submissionVersion.getCurrentGradedAt();
	}

	/**
	* Sets the current graded at of this submission version.
	*
	* @param currentGradedAt the current graded at of this submission version
	*/
	@Override
	public void setCurrentGradedAt(java.lang.String currentGradedAt) {
		_submissionVersion.setCurrentGradedAt(currentGradedAt);
	}

	/**
	* Returns the current grader of this submission version.
	*
	* @return the current grader of this submission version
	*/
	@Override
	public java.lang.String getCurrentGrader() {
		return _submissionVersion.getCurrentGrader();
	}

	/**
	* Sets the current grader of this submission version.
	*
	* @param currentGrader the current grader of this submission version
	*/
	@Override
	public void setCurrentGrader(java.lang.String currentGrader) {
		_submissionVersion.setCurrentGrader(currentGrader);
	}

	/**
	* Returns the grade matches current submission of this submission version.
	*
	* @return the grade matches current submission of this submission version
	*/
	@Override
	public java.lang.String getGradeMatchesCurrentSubmission() {
		return _submissionVersion.getGradeMatchesCurrentSubmission();
	}

	/**
	* Sets the grade matches current submission of this submission version.
	*
	* @param gradeMatchesCurrentSubmission the grade matches current submission of this submission version
	*/
	@Override
	public void setGradeMatchesCurrentSubmission(
		java.lang.String gradeMatchesCurrentSubmission) {
		_submissionVersion.setGradeMatchesCurrentSubmission(gradeMatchesCurrentSubmission);
	}

	/**
	* Returns the graded at of this submission version.
	*
	* @return the graded at of this submission version
	*/
	@Override
	public java.lang.String getGradedAt() {
		return _submissionVersion.getGradedAt();
	}

	/**
	* Sets the graded at of this submission version.
	*
	* @param gradedAt the graded at of this submission version
	*/
	@Override
	public void setGradedAt(java.lang.String gradedAt) {
		_submissionVersion.setGradedAt(gradedAt);
	}

	/**
	* Returns the grader of this submission version.
	*
	* @return the grader of this submission version
	*/
	@Override
	public java.lang.String getGrader() {
		return _submissionVersion.getGrader();
	}

	/**
	* Sets the grader of this submission version.
	*
	* @param grader the grader of this submission version
	*/
	@Override
	public void setGrader(java.lang.String grader) {
		_submissionVersion.setGrader(grader);
	}

	/**
	* Returns the grader ID of this submission version.
	*
	* @return the grader ID of this submission version
	*/
	@Override
	public long getGraderId() {
		return _submissionVersion.getGraderId();
	}

	/**
	* Sets the grader ID of this submission version.
	*
	* @param graderId the grader ID of this submission version
	*/
	@Override
	public void setGraderId(long graderId) {
		_submissionVersion.setGraderId(graderId);
	}

	/**
	* Returns the new grade of this submission version.
	*
	* @return the new grade of this submission version
	*/
	@Override
	public java.lang.String getNewGrade() {
		return _submissionVersion.getNewGrade();
	}

	/**
	* Sets the new grade of this submission version.
	*
	* @param newGrade the new grade of this submission version
	*/
	@Override
	public void setNewGrade(java.lang.String newGrade) {
		_submissionVersion.setNewGrade(newGrade);
	}

	/**
	* Returns the new graded at of this submission version.
	*
	* @return the new graded at of this submission version
	*/
	@Override
	public java.lang.String getNewGradedAt() {
		return _submissionVersion.getNewGradedAt();
	}

	/**
	* Sets the new graded at of this submission version.
	*
	* @param newGradedAt the new graded at of this submission version
	*/
	@Override
	public void setNewGradedAt(java.lang.String newGradedAt) {
		_submissionVersion.setNewGradedAt(newGradedAt);
	}

	/**
	* Returns the new grader of this submission version.
	*
	* @return the new grader of this submission version
	*/
	@Override
	public java.lang.String getNewGrader() {
		return _submissionVersion.getNewGrader();
	}

	/**
	* Sets the new grader of this submission version.
	*
	* @param newGrader the new grader of this submission version
	*/
	@Override
	public void setNewGrader(java.lang.String newGrader) {
		_submissionVersion.setNewGrader(newGrader);
	}

	/**
	* Returns the previous grade of this submission version.
	*
	* @return the previous grade of this submission version
	*/
	@Override
	public java.lang.String getPreviousGrade() {
		return _submissionVersion.getPreviousGrade();
	}

	/**
	* Sets the previous grade of this submission version.
	*
	* @param previousGrade the previous grade of this submission version
	*/
	@Override
	public void setPreviousGrade(java.lang.String previousGrade) {
		_submissionVersion.setPreviousGrade(previousGrade);
	}

	/**
	* Returns the previous graded at of this submission version.
	*
	* @return the previous graded at of this submission version
	*/
	@Override
	public java.lang.String getPreviousGradedAt() {
		return _submissionVersion.getPreviousGradedAt();
	}

	/**
	* Sets the previous graded at of this submission version.
	*
	* @param previousGradedAt the previous graded at of this submission version
	*/
	@Override
	public void setPreviousGradedAt(java.lang.String previousGradedAt) {
		_submissionVersion.setPreviousGradedAt(previousGradedAt);
	}

	/**
	* Returns the previous grader of this submission version.
	*
	* @return the previous grader of this submission version
	*/
	@Override
	public java.lang.String getPreviousGrader() {
		return _submissionVersion.getPreviousGrader();
	}

	/**
	* Sets the previous grader of this submission version.
	*
	* @param previousGrader the previous grader of this submission version
	*/
	@Override
	public void setPreviousGrader(java.lang.String previousGrader) {
		_submissionVersion.setPreviousGrader(previousGrader);
	}

	/**
	* Returns the score of this submission version.
	*
	* @return the score of this submission version
	*/
	@Override
	public long getScore() {
		return _submissionVersion.getScore();
	}

	/**
	* Sets the score of this submission version.
	*
	* @param score the score of this submission version
	*/
	@Override
	public void setScore(long score) {
		_submissionVersion.setScore(score);
	}

	/**
	* Returns the user name of this submission version.
	*
	* @return the user name of this submission version
	*/
	@Override
	public java.lang.String getUserName() {
		return _submissionVersion.getUserName();
	}

	/**
	* Sets the user name of this submission version.
	*
	* @param userName the user name of this submission version
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_submissionVersion.setUserName(userName);
	}

	/**
	* Returns the user ID of this submission version.
	*
	* @return the user ID of this submission version
	*/
	@Override
	public long getUserId() {
		return _submissionVersion.getUserId();
	}

	/**
	* Sets the user ID of this submission version.
	*
	* @param userId the user ID of this submission version
	*/
	@Override
	public void setUserId(long userId) {
		_submissionVersion.setUserId(userId);
	}

	/**
	* Returns the user uuid of this submission version.
	*
	* @return the user uuid of this submission version
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersion.getUserUuid();
	}

	/**
	* Sets the user uuid of this submission version.
	*
	* @param userUuid the user uuid of this submission version
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_submissionVersion.setUserUuid(userUuid);
	}

	/**
	* Returns the submission type of this submission version.
	*
	* @return the submission type of this submission version
	*/
	@Override
	public java.lang.String getSubmissionType() {
		return _submissionVersion.getSubmissionType();
	}

	/**
	* Sets the submission type of this submission version.
	*
	* @param submissionType the submission type of this submission version
	*/
	@Override
	public void setSubmissionType(java.lang.String submissionType) {
		_submissionVersion.setSubmissionType(submissionType);
	}

	/**
	* Returns the url of this submission version.
	*
	* @return the url of this submission version
	*/
	@Override
	public java.lang.String getUrl() {
		return _submissionVersion.getUrl();
	}

	/**
	* Sets the url of this submission version.
	*
	* @param url the url of this submission version
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_submissionVersion.setUrl(url);
	}

	/**
	* Returns the workflow state of this submission version.
	*
	* @return the workflow state of this submission version
	*/
	@Override
	public java.lang.String getWorkflowState() {
		return _submissionVersion.getWorkflowState();
	}

	/**
	* Sets the workflow state of this submission version.
	*
	* @param workflowState the workflow state of this submission version
	*/
	@Override
	public void setWorkflowState(java.lang.String workflowState) {
		_submissionVersion.setWorkflowState(workflowState);
	}

	@Override
	public boolean isNew() {
		return _submissionVersion.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_submissionVersion.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _submissionVersion.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_submissionVersion.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _submissionVersion.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _submissionVersion.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_submissionVersion.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _submissionVersion.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_submissionVersion.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_submissionVersion.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_submissionVersion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubmissionVersionWrapper((SubmissionVersion)_submissionVersion.clone());
	}

	@Override
	public int compareTo(
		com.instructure.canvas.model.SubmissionVersion submissionVersion) {
		return _submissionVersion.compareTo(submissionVersion);
	}

	@Override
	public int hashCode() {
		return _submissionVersion.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.SubmissionVersion> toCacheModel() {
		return _submissionVersion.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.SubmissionVersion toEscapedModel() {
		return new SubmissionVersionWrapper(_submissionVersion.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.SubmissionVersion toUnescapedModel() {
		return new SubmissionVersionWrapper(_submissionVersion.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _submissionVersion.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _submissionVersion.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_submissionVersion.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubmissionVersionWrapper)) {
			return false;
		}

		SubmissionVersionWrapper submissionVersionWrapper = (SubmissionVersionWrapper)obj;

		if (Validator.equals(_submissionVersion,
					submissionVersionWrapper._submissionVersion)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SubmissionVersion getWrappedSubmissionVersion() {
		return _submissionVersion;
	}

	@Override
	public SubmissionVersion getWrappedModel() {
		return _submissionVersion;
	}

	@Override
	public void resetOriginalValues() {
		_submissionVersion.resetOriginalValues();
	}

	private SubmissionVersion _submissionVersion;
}