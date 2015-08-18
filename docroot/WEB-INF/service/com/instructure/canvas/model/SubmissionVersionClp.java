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

import com.instructure.canvas.service.ClpSerializer;
import com.instructure.canvas.service.SubmissionVersionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class SubmissionVersionClp extends BaseModelImpl<SubmissionVersion>
	implements SubmissionVersion {
	public SubmissionVersionClp() {
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
	public long getPrimaryKey() {
		return _submissionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubmissionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _submissionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSubmissionId() {
		return _submissionId;
	}

	@Override
	public void setSubmissionId(long submissionId) {
		_submissionId = submissionId;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmissionId", long.class);

				method.invoke(_submissionVersionRemoteModel, submissionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssignmentId() {
		return _assignmentId;
	}

	@Override
	public void setAssignmentId(long assignmentId) {
		_assignmentId = assignmentId;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignmentId", long.class);

				method.invoke(_submissionVersionRemoteModel, assignmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssignmentName() {
		return _assignmentName;
	}

	@Override
	public void setAssignmentName(String assignmentName) {
		_assignmentName = assignmentName;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignmentName",
						String.class);

				method.invoke(_submissionVersionRemoteModel, assignmentName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAttempt() {
		return _attempt;
	}

	@Override
	public void setAttempt(int attempt) {
		_attempt = attempt;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setAttempt", int.class);

				method.invoke(_submissionVersionRemoteModel, attempt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBody() {
		return _body;
	}

	@Override
	public void setBody(String body) {
		_body = body;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setBody", String.class);

				method.invoke(_submissionVersionRemoteModel, body);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentGrade() {
		return _currentGrade;
	}

	@Override
	public void setCurrentGrade(String currentGrade) {
		_currentGrade = currentGrade;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentGrade", String.class);

				method.invoke(_submissionVersionRemoteModel, currentGrade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentGradedAt() {
		return _currentGradedAt;
	}

	@Override
	public void setCurrentGradedAt(String currentGradedAt) {
		_currentGradedAt = currentGradedAt;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentGradedAt",
						String.class);

				method.invoke(_submissionVersionRemoteModel, currentGradedAt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentGrader() {
		return _currentGrader;
	}

	@Override
	public void setCurrentGrader(String currentGrader) {
		_currentGrader = currentGrader;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentGrader", String.class);

				method.invoke(_submissionVersionRemoteModel, currentGrader);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGradeMatchesCurrentSubmission() {
		return _gradeMatchesCurrentSubmission;
	}

	@Override
	public void setGradeMatchesCurrentSubmission(
		String gradeMatchesCurrentSubmission) {
		_gradeMatchesCurrentSubmission = gradeMatchesCurrentSubmission;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setGradeMatchesCurrentSubmission",
						String.class);

				method.invoke(_submissionVersionRemoteModel,
					gradeMatchesCurrentSubmission);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGradedAt() {
		return _gradedAt;
	}

	@Override
	public void setGradedAt(String gradedAt) {
		_gradedAt = gradedAt;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setGradedAt", String.class);

				method.invoke(_submissionVersionRemoteModel, gradedAt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGrader() {
		return _grader;
	}

	@Override
	public void setGrader(String grader) {
		_grader = grader;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setGrader", String.class);

				method.invoke(_submissionVersionRemoteModel, grader);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGraderId() {
		return _graderId;
	}

	@Override
	public void setGraderId(long graderId) {
		_graderId = graderId;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setGraderId", long.class);

				method.invoke(_submissionVersionRemoteModel, graderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewGrade() {
		return _newGrade;
	}

	@Override
	public void setNewGrade(String newGrade) {
		_newGrade = newGrade;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setNewGrade", String.class);

				method.invoke(_submissionVersionRemoteModel, newGrade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewGradedAt() {
		return _newGradedAt;
	}

	@Override
	public void setNewGradedAt(String newGradedAt) {
		_newGradedAt = newGradedAt;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setNewGradedAt", String.class);

				method.invoke(_submissionVersionRemoteModel, newGradedAt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewGrader() {
		return _newGrader;
	}

	@Override
	public void setNewGrader(String newGrader) {
		_newGrader = newGrader;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setNewGrader", String.class);

				method.invoke(_submissionVersionRemoteModel, newGrader);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPreviousGrade() {
		return _previousGrade;
	}

	@Override
	public void setPreviousGrade(String previousGrade) {
		_previousGrade = previousGrade;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setPreviousGrade", String.class);

				method.invoke(_submissionVersionRemoteModel, previousGrade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPreviousGradedAt() {
		return _previousGradedAt;
	}

	@Override
	public void setPreviousGradedAt(String previousGradedAt) {
		_previousGradedAt = previousGradedAt;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setPreviousGradedAt",
						String.class);

				method.invoke(_submissionVersionRemoteModel, previousGradedAt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPreviousGrader() {
		return _previousGrader;
	}

	@Override
	public void setPreviousGrader(String previousGrader) {
		_previousGrader = previousGrader;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setPreviousGrader",
						String.class);

				method.invoke(_submissionVersionRemoteModel, previousGrader);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getScore() {
		return _score;
	}

	@Override
	public void setScore(long score) {
		_score = score;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setScore", long.class);

				method.invoke(_submissionVersionRemoteModel, score);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_submissionVersionRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_submissionVersionRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getSubmissionType() {
		return _submissionType;
	}

	@Override
	public void setSubmissionType(String submissionType) {
		_submissionType = submissionType;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmissionType",
						String.class);

				method.invoke(_submissionVersionRemoteModel, submissionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_submissionVersionRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkflowState() {
		return _workflowState;
	}

	@Override
	public void setWorkflowState(String workflowState) {
		_workflowState = workflowState;

		if (_submissionVersionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowState", String.class);

				method.invoke(_submissionVersionRemoteModel, workflowState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSubmissionVersionRemoteModel() {
		return _submissionVersionRemoteModel;
	}

	public void setSubmissionVersionRemoteModel(
		BaseModel<?> submissionVersionRemoteModel) {
		_submissionVersionRemoteModel = submissionVersionRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _submissionVersionRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_submissionVersionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SubmissionVersionLocalServiceUtil.addSubmissionVersion(this);
		}
		else {
			SubmissionVersionLocalServiceUtil.updateSubmissionVersion(this);
		}
	}

	@Override
	public SubmissionVersion toEscapedModel() {
		return (SubmissionVersion)ProxyUtil.newProxyInstance(SubmissionVersion.class.getClassLoader(),
			new Class[] { SubmissionVersion.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SubmissionVersionClp clone = new SubmissionVersionClp();

		clone.setSubmissionId(getSubmissionId());
		clone.setAssignmentId(getAssignmentId());
		clone.setAssignmentName(getAssignmentName());
		clone.setAttempt(getAttempt());
		clone.setBody(getBody());
		clone.setCurrentGrade(getCurrentGrade());
		clone.setCurrentGradedAt(getCurrentGradedAt());
		clone.setCurrentGrader(getCurrentGrader());
		clone.setGradeMatchesCurrentSubmission(getGradeMatchesCurrentSubmission());
		clone.setGradedAt(getGradedAt());
		clone.setGrader(getGrader());
		clone.setGraderId(getGraderId());
		clone.setNewGrade(getNewGrade());
		clone.setNewGradedAt(getNewGradedAt());
		clone.setNewGrader(getNewGrader());
		clone.setPreviousGrade(getPreviousGrade());
		clone.setPreviousGradedAt(getPreviousGradedAt());
		clone.setPreviousGrader(getPreviousGrader());
		clone.setScore(getScore());
		clone.setUserName(getUserName());
		clone.setUserId(getUserId());
		clone.setSubmissionType(getSubmissionType());
		clone.setUrl(getUrl());
		clone.setWorkflowState(getWorkflowState());

		return clone;
	}

	@Override
	public int compareTo(SubmissionVersion submissionVersion) {
		long primaryKey = submissionVersion.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubmissionVersionClp)) {
			return false;
		}

		SubmissionVersionClp submissionVersion = (SubmissionVersionClp)obj;

		long primaryKey = submissionVersion.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{submissionId=");
		sb.append(getSubmissionId());
		sb.append(", assignmentId=");
		sb.append(getAssignmentId());
		sb.append(", assignmentName=");
		sb.append(getAssignmentName());
		sb.append(", attempt=");
		sb.append(getAttempt());
		sb.append(", body=");
		sb.append(getBody());
		sb.append(", currentGrade=");
		sb.append(getCurrentGrade());
		sb.append(", currentGradedAt=");
		sb.append(getCurrentGradedAt());
		sb.append(", currentGrader=");
		sb.append(getCurrentGrader());
		sb.append(", gradeMatchesCurrentSubmission=");
		sb.append(getGradeMatchesCurrentSubmission());
		sb.append(", gradedAt=");
		sb.append(getGradedAt());
		sb.append(", grader=");
		sb.append(getGrader());
		sb.append(", graderId=");
		sb.append(getGraderId());
		sb.append(", newGrade=");
		sb.append(getNewGrade());
		sb.append(", newGradedAt=");
		sb.append(getNewGradedAt());
		sb.append(", newGrader=");
		sb.append(getNewGrader());
		sb.append(", previousGrade=");
		sb.append(getPreviousGrade());
		sb.append(", previousGradedAt=");
		sb.append(getPreviousGradedAt());
		sb.append(", previousGrader=");
		sb.append(getPreviousGrader());
		sb.append(", score=");
		sb.append(getScore());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", submissionType=");
		sb.append(getSubmissionType());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", workflowState=");
		sb.append(getWorkflowState());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.SubmissionVersion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>submissionId</column-name><column-value><![CDATA[");
		sb.append(getSubmissionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assignmentId</column-name><column-value><![CDATA[");
		sb.append(getAssignmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assignmentName</column-name><column-value><![CDATA[");
		sb.append(getAssignmentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attempt</column-name><column-value><![CDATA[");
		sb.append(getAttempt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentGrade</column-name><column-value><![CDATA[");
		sb.append(getCurrentGrade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentGradedAt</column-name><column-value><![CDATA[");
		sb.append(getCurrentGradedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentGrader</column-name><column-value><![CDATA[");
		sb.append(getCurrentGrader());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gradeMatchesCurrentSubmission</column-name><column-value><![CDATA[");
		sb.append(getGradeMatchesCurrentSubmission());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gradedAt</column-name><column-value><![CDATA[");
		sb.append(getGradedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>grader</column-name><column-value><![CDATA[");
		sb.append(getGrader());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>graderId</column-name><column-value><![CDATA[");
		sb.append(getGraderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newGrade</column-name><column-value><![CDATA[");
		sb.append(getNewGrade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newGradedAt</column-name><column-value><![CDATA[");
		sb.append(getNewGradedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newGrader</column-name><column-value><![CDATA[");
		sb.append(getNewGrader());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousGrade</column-name><column-value><![CDATA[");
		sb.append(getPreviousGrade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousGradedAt</column-name><column-value><![CDATA[");
		sb.append(getPreviousGradedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousGrader</column-name><column-value><![CDATA[");
		sb.append(getPreviousGrader());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>score</column-name><column-value><![CDATA[");
		sb.append(getScore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submissionType</column-name><column-value><![CDATA[");
		sb.append(getSubmissionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowState</column-name><column-value><![CDATA[");
		sb.append(getWorkflowState());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
	private String _submissionType;
	private String _url;
	private String _workflowState;
	private BaseModel<?> _submissionVersionRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}