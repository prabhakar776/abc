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
import com.instructure.canvas.service.UserAwardLocalServiceUtil;

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
public class UserAwardClp extends BaseModelImpl<UserAward> implements UserAward {
	public UserAwardClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserAward.class;
	}

	@Override
	public String getModelClassName() {
		return UserAward.class.getName();
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
		attributes.put("canvasUserId", getCanvasUserId());
		attributes.put("courseId", getCourseId());
		attributes.put("externalId", getExternalId());
		attributes.put("certId", getCertId());
		attributes.put("letter", getLetter());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long canvasUserId = (Long)attributes.get("canvasUserId");

		if (canvasUserId != null) {
			setCanvasUserId(canvasUserId);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long externalId = (Long)attributes.get("externalId");

		if (externalId != null) {
			setExternalId(externalId);
		}

		String certId = (String)attributes.get("certId");

		if (certId != null) {
			setCertId(certId);
		}

		Boolean letter = (Boolean)attributes.get("letter");

		if (letter != null) {
			setLetter(letter);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_userAwardRemoteModel != null) {
			try {
				Class<?> clazz = _userAwardRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_userAwardRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCanvasUserId() {
		return _canvasUserId;
	}

	@Override
	public void setCanvasUserId(long canvasUserId) {
		_canvasUserId = canvasUserId;

		if (_userAwardRemoteModel != null) {
			try {
				Class<?> clazz = _userAwardRemoteModel.getClass();

				Method method = clazz.getMethod("setCanvasUserId", long.class);

				method.invoke(_userAwardRemoteModel, canvasUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCanvasUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCanvasUserId(), "uuid",
			_canvasUserUuid);
	}

	@Override
	public void setCanvasUserUuid(String canvasUserUuid) {
		_canvasUserUuid = canvasUserUuid;
	}

	@Override
	public long getCourseId() {
		return _courseId;
	}

	@Override
	public void setCourseId(long courseId) {
		_courseId = courseId;

		if (_userAwardRemoteModel != null) {
			try {
				Class<?> clazz = _userAwardRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseId", long.class);

				method.invoke(_userAwardRemoteModel, courseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getExternalId() {
		return _externalId;
	}

	@Override
	public void setExternalId(long externalId) {
		_externalId = externalId;

		if (_userAwardRemoteModel != null) {
			try {
				Class<?> clazz = _userAwardRemoteModel.getClass();

				Method method = clazz.getMethod("setExternalId", long.class);

				method.invoke(_userAwardRemoteModel, externalId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCertId() {
		return _certId;
	}

	@Override
	public void setCertId(String certId) {
		_certId = certId;

		if (_userAwardRemoteModel != null) {
			try {
				Class<?> clazz = _userAwardRemoteModel.getClass();

				Method method = clazz.getMethod("setCertId", String.class);

				method.invoke(_userAwardRemoteModel, certId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLetter() {
		return _letter;
	}

	@Override
	public boolean isLetter() {
		return _letter;
	}

	@Override
	public void setLetter(boolean letter) {
		_letter = letter;

		if (_userAwardRemoteModel != null) {
			try {
				Class<?> clazz = _userAwardRemoteModel.getClass();

				Method method = clazz.getMethod("setLetter", boolean.class);

				method.invoke(_userAwardRemoteModel, letter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_userAwardRemoteModel != null) {
			try {
				Class<?> clazz = _userAwardRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_userAwardRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserAwardRemoteModel() {
		return _userAwardRemoteModel;
	}

	public void setUserAwardRemoteModel(BaseModel<?> userAwardRemoteModel) {
		_userAwardRemoteModel = userAwardRemoteModel;
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

		Class<?> remoteModelClass = _userAwardRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userAwardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserAwardLocalServiceUtil.addUserAward(this);
		}
		else {
			UserAwardLocalServiceUtil.updateUserAward(this);
		}
	}

	@Override
	public UserAward toEscapedModel() {
		return (UserAward)ProxyUtil.newProxyInstance(UserAward.class.getClassLoader(),
			new Class[] { UserAward.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserAwardClp clone = new UserAwardClp();

		clone.setId(getId());
		clone.setCanvasUserId(getCanvasUserId());
		clone.setCourseId(getCourseId());
		clone.setExternalId(getExternalId());
		clone.setCertId(getCertId());
		clone.setLetter(getLetter());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(UserAward userAward) {
		long primaryKey = userAward.getPrimaryKey();

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

		if (!(obj instanceof UserAwardClp)) {
			return false;
		}

		UserAwardClp userAward = (UserAwardClp)obj;

		long primaryKey = userAward.getPrimaryKey();

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
		sb.append(", canvasUserId=");
		sb.append(getCanvasUserId());
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append(", externalId=");
		sb.append(getExternalId());
		sb.append(", certId=");
		sb.append(getCertId());
		sb.append(", letter=");
		sb.append(getLetter());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.UserAward");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canvasUserId</column-name><column-value><![CDATA[");
		sb.append(getCanvasUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalId</column-name><column-value><![CDATA[");
		sb.append(getExternalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certId</column-name><column-value><![CDATA[");
		sb.append(getCertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>letter</column-name><column-value><![CDATA[");
		sb.append(getLetter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _canvasUserId;
	private String _canvasUserUuid;
	private long _courseId;
	private long _externalId;
	private String _certId;
	private boolean _letter;
	private Date _createDate;
	private BaseModel<?> _userAwardRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}