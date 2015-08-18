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
import com.instructure.canvas.service.EnrollmentSeatLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class EnrollmentSeatClp extends BaseModelImpl<EnrollmentSeat>
	implements EnrollmentSeat {
	public EnrollmentSeatClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EnrollmentSeat.class;
	}

	@Override
	public String getModelClassName() {
		return EnrollmentSeat.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("token", getToken());
		attributes.put("rootAccountId", getRootAccountId());
		attributes.put("courseId", getCourseId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("redeemDate", getRedeemDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}

		String rootAccountId = (String)attributes.get("rootAccountId");

		if (rootAccountId != null) {
			setRootAccountId(rootAccountId);
		}

		String courseId = (String)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date redeemDate = (Date)attributes.get("redeemDate");

		if (redeemDate != null) {
			setRedeemDate(redeemDate);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_enrollmentSeatRemoteModel != null) {
			try {
				Class<?> clazz = _enrollmentSeatRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_enrollmentSeatRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToken() {
		return _token;
	}

	@Override
	public void setToken(String token) {
		_token = token;

		if (_enrollmentSeatRemoteModel != null) {
			try {
				Class<?> clazz = _enrollmentSeatRemoteModel.getClass();

				Method method = clazz.getMethod("setToken", String.class);

				method.invoke(_enrollmentSeatRemoteModel, token);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRootAccountId() {
		return _rootAccountId;
	}

	@Override
	public void setRootAccountId(String rootAccountId) {
		_rootAccountId = rootAccountId;

		if (_enrollmentSeatRemoteModel != null) {
			try {
				Class<?> clazz = _enrollmentSeatRemoteModel.getClass();

				Method method = clazz.getMethod("setRootAccountId", String.class);

				method.invoke(_enrollmentSeatRemoteModel, rootAccountId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCourseId() {
		return _courseId;
	}

	@Override
	public void setCourseId(String courseId) {
		_courseId = courseId;

		if (_enrollmentSeatRemoteModel != null) {
			try {
				Class<?> clazz = _enrollmentSeatRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseId", String.class);

				method.invoke(_enrollmentSeatRemoteModel, courseId);
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

		if (_enrollmentSeatRemoteModel != null) {
			try {
				Class<?> clazz = _enrollmentSeatRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_enrollmentSeatRemoteModel, userId);
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_enrollmentSeatRemoteModel != null) {
			try {
				Class<?> clazz = _enrollmentSeatRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_enrollmentSeatRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRedeemDate() {
		return _redeemDate;
	}

	@Override
	public void setRedeemDate(Date redeemDate) {
		_redeemDate = redeemDate;

		if (_enrollmentSeatRemoteModel != null) {
			try {
				Class<?> clazz = _enrollmentSeatRemoteModel.getClass();

				Method method = clazz.getMethod("setRedeemDate", Date.class);

				method.invoke(_enrollmentSeatRemoteModel, redeemDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEnrollmentSeatRemoteModel() {
		return _enrollmentSeatRemoteModel;
	}

	public void setEnrollmentSeatRemoteModel(
		BaseModel<?> enrollmentSeatRemoteModel) {
		_enrollmentSeatRemoteModel = enrollmentSeatRemoteModel;
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

		Class<?> remoteModelClass = _enrollmentSeatRemoteModel.getClass();

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

		Object returnValue = method.invoke(_enrollmentSeatRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EnrollmentSeatLocalServiceUtil.addEnrollmentSeat(this);
		}
		else {
			EnrollmentSeatLocalServiceUtil.updateEnrollmentSeat(this);
		}
	}

	@Override
	public EnrollmentSeat toEscapedModel() {
		return (EnrollmentSeat)ProxyUtil.newProxyInstance(EnrollmentSeat.class.getClassLoader(),
			new Class[] { EnrollmentSeat.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EnrollmentSeatClp clone = new EnrollmentSeatClp();

		clone.setId(getId());
		clone.setToken(getToken());
		clone.setRootAccountId(getRootAccountId());
		clone.setCourseId(getCourseId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setRedeemDate(getRedeemDate());

		return clone;
	}

	@Override
	public int compareTo(EnrollmentSeat enrollmentSeat) {
		long primaryKey = enrollmentSeat.getPrimaryKey();

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

		if (!(obj instanceof EnrollmentSeatClp)) {
			return false;
		}

		EnrollmentSeatClp enrollmentSeat = (EnrollmentSeatClp)obj;

		long primaryKey = enrollmentSeat.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", token=");
		sb.append(getToken());
		sb.append(", rootAccountId=");
		sb.append(getRootAccountId());
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", redeemDate=");
		sb.append(getRedeemDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.EnrollmentSeat");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>token</column-name><column-value><![CDATA[");
		sb.append(getToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootAccountId</column-name><column-value><![CDATA[");
		sb.append(getRootAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>redeemDate</column-name><column-value><![CDATA[");
		sb.append(getRedeemDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _token;
	private String _rootAccountId;
	private String _courseId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _redeemDate;
	private BaseModel<?> _enrollmentSeatRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}