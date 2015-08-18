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

import com.instructure.canvas.service.CanvasEnrollmentLocalServiceUtil;
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
public class CanvasEnrollmentClp extends BaseModelImpl<CanvasEnrollment>
	implements CanvasEnrollment {
	public CanvasEnrollmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CanvasEnrollment.class;
	}

	@Override
	public String getModelClassName() {
		return CanvasEnrollment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _courseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCourseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _courseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("courseId", getCourseId());
		attributes.put("userId", getUserId());
		attributes.put("role", getRole());
		attributes.put("sectionId", getSectionId());
		attributes.put("status", getStatus());
		attributes.put("associatedUserId", getAssociatedUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		String sectionId = (String)attributes.get("sectionId");

		if (sectionId != null) {
			setSectionId(sectionId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String associatedUserId = (String)attributes.get("associatedUserId");

		if (associatedUserId != null) {
			setAssociatedUserId(associatedUserId);
		}
	}

	@Override
	public long getCourseId() {
		return _courseId;
	}

	@Override
	public void setCourseId(long courseId) {
		_courseId = courseId;

		if (_canvasEnrollmentRemoteModel != null) {
			try {
				Class<?> clazz = _canvasEnrollmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseId", long.class);

				method.invoke(_canvasEnrollmentRemoteModel, courseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(String userId) {
		_userId = userId;

		if (_canvasEnrollmentRemoteModel != null) {
			try {
				Class<?> clazz = _canvasEnrollmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", String.class);

				method.invoke(_canvasEnrollmentRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRole() {
		return _role;
	}

	@Override
	public void setRole(String role) {
		_role = role;

		if (_canvasEnrollmentRemoteModel != null) {
			try {
				Class<?> clazz = _canvasEnrollmentRemoteModel.getClass();

				Method method = clazz.getMethod("setRole", String.class);

				method.invoke(_canvasEnrollmentRemoteModel, role);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSectionId() {
		return _sectionId;
	}

	@Override
	public void setSectionId(String sectionId) {
		_sectionId = sectionId;

		if (_canvasEnrollmentRemoteModel != null) {
			try {
				Class<?> clazz = _canvasEnrollmentRemoteModel.getClass();

				Method method = clazz.getMethod("setSectionId", String.class);

				method.invoke(_canvasEnrollmentRemoteModel, sectionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_canvasEnrollmentRemoteModel != null) {
			try {
				Class<?> clazz = _canvasEnrollmentRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_canvasEnrollmentRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssociatedUserId() {
		return _associatedUserId;
	}

	@Override
	public void setAssociatedUserId(String associatedUserId) {
		_associatedUserId = associatedUserId;

		if (_canvasEnrollmentRemoteModel != null) {
			try {
				Class<?> clazz = _canvasEnrollmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAssociatedUserId",
						String.class);

				method.invoke(_canvasEnrollmentRemoteModel, associatedUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCanvasEnrollmentRemoteModel() {
		return _canvasEnrollmentRemoteModel;
	}

	public void setCanvasEnrollmentRemoteModel(
		BaseModel<?> canvasEnrollmentRemoteModel) {
		_canvasEnrollmentRemoteModel = canvasEnrollmentRemoteModel;
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

		Class<?> remoteModelClass = _canvasEnrollmentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_canvasEnrollmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CanvasEnrollmentLocalServiceUtil.addCanvasEnrollment(this);
		}
		else {
			CanvasEnrollmentLocalServiceUtil.updateCanvasEnrollment(this);
		}
	}

	@Override
	public CanvasEnrollment toEscapedModel() {
		return (CanvasEnrollment)ProxyUtil.newProxyInstance(CanvasEnrollment.class.getClassLoader(),
			new Class[] { CanvasEnrollment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CanvasEnrollmentClp clone = new CanvasEnrollmentClp();

		clone.setCourseId(getCourseId());
		clone.setUserId(getUserId());
		clone.setRole(getRole());
		clone.setSectionId(getSectionId());
		clone.setStatus(getStatus());
		clone.setAssociatedUserId(getAssociatedUserId());

		return clone;
	}

	@Override
	public int compareTo(CanvasEnrollment canvasEnrollment) {
		long primaryKey = canvasEnrollment.getPrimaryKey();

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

		if (!(obj instanceof CanvasEnrollmentClp)) {
			return false;
		}

		CanvasEnrollmentClp canvasEnrollment = (CanvasEnrollmentClp)obj;

		long primaryKey = canvasEnrollment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{courseId=");
		sb.append(getCourseId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", role=");
		sb.append(getRole());
		sb.append(", sectionId=");
		sb.append(getSectionId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", associatedUserId=");
		sb.append(getAssociatedUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.CanvasEnrollment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>role</column-name><column-value><![CDATA[");
		sb.append(getRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sectionId</column-name><column-value><![CDATA[");
		sb.append(getSectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>associatedUserId</column-name><column-value><![CDATA[");
		sb.append(getAssociatedUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _courseId;
	private String _userId;
	private String _role;
	private String _sectionId;
	private String _status;
	private String _associatedUserId;
	private BaseModel<?> _canvasEnrollmentRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}