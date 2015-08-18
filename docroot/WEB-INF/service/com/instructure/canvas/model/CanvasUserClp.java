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

import com.instructure.canvas.service.CanvasUserLocalServiceUtil;
import com.instructure.canvas.service.ClpSerializer;

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
public class CanvasUserClp extends BaseModelImpl<CanvasUser>
	implements CanvasUser {
	public CanvasUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CanvasUser.class;
	}

	@Override
	public String getModelClassName() {
		return CanvasUser.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("SID", getSID());
		attributes.put("loginId", getLoginId());
		attributes.put("password", getPassword());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("status", getStatus());
		attributes.put("fullName", getFullName());
		attributes.put("canvasUserId", getCanvasUserId());
		attributes.put("currentScore", getCurrentScore());
		attributes.put("finalScore", getFinalScore());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String SID = (String)attributes.get("SID");

		if (SID != null) {
			setSID(SID);
		}

		String loginId = (String)attributes.get("loginId");

		if (loginId != null) {
			setLoginId(loginId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String canvasUserId = (String)attributes.get("canvasUserId");

		if (canvasUserId != null) {
			setCanvasUserId(canvasUserId);
		}

		Double currentScore = (Double)attributes.get("currentScore");

		if (currentScore != null) {
			setCurrentScore(currentScore);
		}

		Double finalScore = (Double)attributes.get("finalScore");

		if (finalScore != null) {
			setFinalScore(finalScore);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_canvasUserRemoteModel, userId);
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
	public String getSID() {
		return _SID;
	}

	@Override
	public void setSID(String SID) {
		_SID = SID;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSID", String.class);

				method.invoke(_canvasUserRemoteModel, SID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLoginId() {
		return _loginId;
	}

	@Override
	public void setLoginId(String loginId) {
		_loginId = loginId;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLoginId", String.class);

				method.invoke(_canvasUserRemoteModel, loginId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassword() {
		return _password;
	}

	@Override
	public void setPassword(String password) {
		_password = password;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPassword", String.class);

				method.invoke(_canvasUserRemoteModel, password);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_canvasUserRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_canvasUserRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_canvasUserRemoteModel, email);
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

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_canvasUserRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFullName() {
		return _fullName;
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setFullName", String.class);

				method.invoke(_canvasUserRemoteModel, fullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCanvasUserId() {
		return _canvasUserId;
	}

	@Override
	public void setCanvasUserId(String canvasUserId) {
		_canvasUserId = canvasUserId;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCanvasUserId", String.class);

				method.invoke(_canvasUserRemoteModel, canvasUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCurrentScore() {
		return _currentScore;
	}

	@Override
	public void setCurrentScore(double currentScore) {
		_currentScore = currentScore;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentScore", double.class);

				method.invoke(_canvasUserRemoteModel, currentScore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFinalScore() {
		return _finalScore;
	}

	@Override
	public void setFinalScore(double finalScore) {
		_finalScore = finalScore;

		if (_canvasUserRemoteModel != null) {
			try {
				Class<?> clazz = _canvasUserRemoteModel.getClass();

				Method method = clazz.getMethod("setFinalScore", double.class);

				method.invoke(_canvasUserRemoteModel, finalScore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCanvasUserRemoteModel() {
		return _canvasUserRemoteModel;
	}

	public void setCanvasUserRemoteModel(BaseModel<?> canvasUserRemoteModel) {
		_canvasUserRemoteModel = canvasUserRemoteModel;
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

		Class<?> remoteModelClass = _canvasUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_canvasUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CanvasUserLocalServiceUtil.addCanvasUser(this);
		}
		else {
			CanvasUserLocalServiceUtil.updateCanvasUser(this);
		}
	}

	@Override
	public CanvasUser toEscapedModel() {
		return (CanvasUser)ProxyUtil.newProxyInstance(CanvasUser.class.getClassLoader(),
			new Class[] { CanvasUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CanvasUserClp clone = new CanvasUserClp();

		clone.setUserId(getUserId());
		clone.setSID(getSID());
		clone.setLoginId(getLoginId());
		clone.setPassword(getPassword());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setEmail(getEmail());
		clone.setStatus(getStatus());
		clone.setFullName(getFullName());
		clone.setCanvasUserId(getCanvasUserId());
		clone.setCurrentScore(getCurrentScore());
		clone.setFinalScore(getFinalScore());

		return clone;
	}

	@Override
	public int compareTo(CanvasUser canvasUser) {
		long primaryKey = canvasUser.getPrimaryKey();

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

		if (!(obj instanceof CanvasUserClp)) {
			return false;
		}

		CanvasUserClp canvasUser = (CanvasUserClp)obj;

		long primaryKey = canvasUser.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", SID=");
		sb.append(getSID());
		sb.append(", loginId=");
		sb.append(getLoginId());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", canvasUserId=");
		sb.append(getCanvasUserId());
		sb.append(", currentScore=");
		sb.append(getCurrentScore());
		sb.append(", finalScore=");
		sb.append(getFinalScore());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.CanvasUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SID</column-name><column-value><![CDATA[");
		sb.append(getSID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loginId</column-name><column-value><![CDATA[");
		sb.append(getLoginId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password</column-name><column-value><![CDATA[");
		sb.append(getPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canvasUserId</column-name><column-value><![CDATA[");
		sb.append(getCanvasUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentScore</column-name><column-value><![CDATA[");
		sb.append(getCurrentScore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finalScore</column-name><column-value><![CDATA[");
		sb.append(getFinalScore());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private String _SID;
	private String _loginId;
	private String _password;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _status;
	private String _fullName;
	private String _canvasUserId;
	private double _currentScore;
	private double _finalScore;
	private BaseModel<?> _canvasUserRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}