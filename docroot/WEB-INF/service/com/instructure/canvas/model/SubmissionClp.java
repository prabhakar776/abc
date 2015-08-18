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
import com.instructure.canvas.service.SubmissionLocalServiceUtil;

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
public class SubmissionClp extends BaseModelImpl<Submission>
	implements Submission {
	public SubmissionClp() {
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

	@Override
	public long getSubmissionId() {
		return _submissionId;
	}

	@Override
	public void setSubmissionId(long submissionId) {
		_submissionId = submissionId;

		if (_submissionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmissionId", long.class);

				method.invoke(_submissionRemoteModel, submissionId);
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

		if (_submissionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignmentId", long.class);

				method.invoke(_submissionRemoteModel, assignmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCourseId() {
		return _courseId;
	}

	@Override
	public void setCourseId(long courseId) {
		_courseId = courseId;

		if (_submissionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseId", long.class);

				method.invoke(_submissionRemoteModel, courseId);
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

		if (_submissionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRemoteModel.getClass();

				Method method = clazz.getMethod("setAttempt", int.class);

				method.invoke(_submissionRemoteModel, attempt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGrade() {
		return _grade;
	}

	@Override
	public void setGrade(String grade) {
		_grade = grade;

		if (_submissionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRemoteModel.getClass();

				Method method = clazz.getMethod("setGrade", String.class);

				method.invoke(_submissionRemoteModel, grade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtmlUrl() {
		return _htmlUrl;
	}

	@Override
	public void setHtmlUrl(String htmlUrl) {
		_htmlUrl = htmlUrl;

		if (_submissionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRemoteModel.getClass();

				Method method = clazz.getMethod("setHtmlUrl", String.class);

				method.invoke(_submissionRemoteModel, htmlUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getScore() {
		return _score;
	}

	@Override
	public void setScore(double score) {
		_score = score;

		if (_submissionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRemoteModel.getClass();

				Method method = clazz.getMethod("setScore", double.class);

				method.invoke(_submissionRemoteModel, score);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubmissionDate() {
		return _submissionDate;
	}

	@Override
	public void setSubmissionDate(String submissionDate) {
		_submissionDate = submissionDate;

		if (_submissionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmissionDate",
						String.class);

				method.invoke(_submissionRemoteModel, submissionDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGraderId() {
		return _graderId;
	}

	@Override
	public void setGraderId(String graderId) {
		_graderId = graderId;

		if (_submissionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRemoteModel.getClass();

				Method method = clazz.getMethod("setGraderId", String.class);

				method.invoke(_submissionRemoteModel, graderId);
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

		if (_submissionRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_submissionRemoteModel, userId);
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

	public BaseModel<?> getSubmissionRemoteModel() {
		return _submissionRemoteModel;
	}

	public void setSubmissionRemoteModel(BaseModel<?> submissionRemoteModel) {
		_submissionRemoteModel = submissionRemoteModel;
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

		Class<?> remoteModelClass = _submissionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_submissionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SubmissionLocalServiceUtil.addSubmission(this);
		}
		else {
			SubmissionLocalServiceUtil.updateSubmission(this);
		}
	}

	@Override
	public Submission toEscapedModel() {
		return (Submission)ProxyUtil.newProxyInstance(Submission.class.getClassLoader(),
			new Class[] { Submission.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SubmissionClp clone = new SubmissionClp();

		clone.setSubmissionId(getSubmissionId());
		clone.setAssignmentId(getAssignmentId());
		clone.setCourseId(getCourseId());
		clone.setAttempt(getAttempt());
		clone.setGrade(getGrade());
		clone.setHtmlUrl(getHtmlUrl());
		clone.setScore(getScore());
		clone.setSubmissionDate(getSubmissionDate());
		clone.setGraderId(getGraderId());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(Submission submission) {
		long primaryKey = submission.getPrimaryKey();

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

		if (!(obj instanceof SubmissionClp)) {
			return false;
		}

		SubmissionClp submission = (SubmissionClp)obj;

		long primaryKey = submission.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{submissionId=");
		sb.append(getSubmissionId());
		sb.append(", assignmentId=");
		sb.append(getAssignmentId());
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append(", attempt=");
		sb.append(getAttempt());
		sb.append(", grade=");
		sb.append(getGrade());
		sb.append(", htmlUrl=");
		sb.append(getHtmlUrl());
		sb.append(", score=");
		sb.append(getScore());
		sb.append(", submissionDate=");
		sb.append(getSubmissionDate());
		sb.append(", graderId=");
		sb.append(getGraderId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.Submission");
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
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attempt</column-name><column-value><![CDATA[");
		sb.append(getAttempt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>grade</column-name><column-value><![CDATA[");
		sb.append(getGrade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htmlUrl</column-name><column-value><![CDATA[");
		sb.append(getHtmlUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>score</column-name><column-value><![CDATA[");
		sb.append(getScore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submissionDate</column-name><column-value><![CDATA[");
		sb.append(getSubmissionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>graderId</column-name><column-value><![CDATA[");
		sb.append(getGraderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
	private BaseModel<?> _submissionRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}