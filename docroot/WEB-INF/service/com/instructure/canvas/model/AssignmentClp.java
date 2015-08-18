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

import com.instructure.canvas.service.AssignmentLocalServiceUtil;
import com.instructure.canvas.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AssignmentClp extends BaseModelImpl<Assignment>
	implements Assignment {
	public AssignmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Assignment.class;
	}

	@Override
	public String getModelClassName() {
		return Assignment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _assignmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAssignmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _assignmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("assignmentId", getAssignmentId());
		attributes.put("name", getName());
		attributes.put("submissionType", getSubmissionType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long assignmentId = (Long)attributes.get("assignmentId");

		if (assignmentId != null) {
			setAssignmentId(assignmentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String submissionType = (String)attributes.get("submissionType");

		if (submissionType != null) {
			setSubmissionType(submissionType);
		}
	}

	@Override
	public long getAssignmentId() {
		return _assignmentId;
	}

	@Override
	public void setAssignmentId(long assignmentId) {
		_assignmentId = assignmentId;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignmentId", long.class);

				method.invoke(_assignmentRemoteModel, assignmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_assignmentRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubmissionType() {
		return _submissionType;
	}

	@Override
	public void setSubmissionType(String submissionType) {
		_submissionType = submissionType;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmissionType",
						String.class);

				method.invoke(_assignmentRemoteModel, submissionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAssignmentRemoteModel() {
		return _assignmentRemoteModel;
	}

	public void setAssignmentRemoteModel(BaseModel<?> assignmentRemoteModel) {
		_assignmentRemoteModel = assignmentRemoteModel;
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

		Class<?> remoteModelClass = _assignmentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_assignmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AssignmentLocalServiceUtil.addAssignment(this);
		}
		else {
			AssignmentLocalServiceUtil.updateAssignment(this);
		}
	}

	@Override
	public Assignment toEscapedModel() {
		return (Assignment)ProxyUtil.newProxyInstance(Assignment.class.getClassLoader(),
			new Class[] { Assignment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AssignmentClp clone = new AssignmentClp();

		clone.setAssignmentId(getAssignmentId());
		clone.setName(getName());
		clone.setSubmissionType(getSubmissionType());

		return clone;
	}

	@Override
	public int compareTo(Assignment assignment) {
		long primaryKey = assignment.getPrimaryKey();

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

		if (!(obj instanceof AssignmentClp)) {
			return false;
		}

		AssignmentClp assignment = (AssignmentClp)obj;

		long primaryKey = assignment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{assignmentId=");
		sb.append(getAssignmentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", submissionType=");
		sb.append(getSubmissionType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.Assignment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>assignmentId</column-name><column-value><![CDATA[");
		sb.append(getAssignmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submissionType</column-name><column-value><![CDATA[");
		sb.append(getSubmissionType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _assignmentId;
	private String _name;
	private String _submissionType;
	private BaseModel<?> _assignmentRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}