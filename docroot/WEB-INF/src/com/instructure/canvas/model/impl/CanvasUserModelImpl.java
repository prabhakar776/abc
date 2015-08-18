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

package com.instructure.canvas.model.impl;

import com.instructure.canvas.model.CanvasUser;
import com.instructure.canvas.model.CanvasUserModel;
import com.instructure.canvas.model.CanvasUserSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CanvasUser service. Represents a row in the &quot;CANVAS_CanvasUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.instructure.canvas.model.CanvasUserModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CanvasUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasUserImpl
 * @see com.instructure.canvas.model.CanvasUser
 * @see com.instructure.canvas.model.CanvasUserModel
 * @generated
 */
@JSON(strict = true)
public class CanvasUserModelImpl extends BaseModelImpl<CanvasUser>
	implements CanvasUserModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a canvas user model instance should use the {@link com.instructure.canvas.model.CanvasUser} interface instead.
	 */
	public static final String TABLE_NAME = "CANVAS_CanvasUser";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userId", Types.BIGINT },
			{ "SID", Types.VARCHAR },
			{ "loginId", Types.VARCHAR },
			{ "password_", Types.VARCHAR },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "status", Types.VARCHAR },
			{ "fullName", Types.VARCHAR },
			{ "canvasUserId", Types.VARCHAR },
			{ "currentScore", Types.DOUBLE },
			{ "finalScore", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table CANVAS_CanvasUser (userId LONG not null primary key,SID VARCHAR(75) null,loginId VARCHAR(75) null,password_ VARCHAR(75) null,firstName VARCHAR(75) null,lastName VARCHAR(75) null,email VARCHAR(75) null,status VARCHAR(75) null,fullName VARCHAR(75) null,canvasUserId VARCHAR(75) null,currentScore DOUBLE,finalScore DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table CANVAS_CanvasUser";
	public static final String ORDER_BY_JPQL = " ORDER BY canvasUser.userId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CANVAS_CanvasUser.userId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.instructure.canvas.model.CanvasUser"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.instructure.canvas.model.CanvasUser"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CanvasUser toModel(CanvasUserSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CanvasUser model = new CanvasUserImpl();

		model.setUserId(soapModel.getUserId());
		model.setSID(soapModel.getSID());
		model.setLoginId(soapModel.getLoginId());
		model.setPassword(soapModel.getPassword());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setEmail(soapModel.getEmail());
		model.setStatus(soapModel.getStatus());
		model.setFullName(soapModel.getFullName());
		model.setCanvasUserId(soapModel.getCanvasUserId());
		model.setCurrentScore(soapModel.getCurrentScore());
		model.setFinalScore(soapModel.getFinalScore());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CanvasUser> toModels(CanvasUserSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CanvasUser> models = new ArrayList<CanvasUser>(soapModels.length);

		for (CanvasUserSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.instructure.canvas.model.CanvasUser"));

	public CanvasUserModelImpl() {
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
	public Class<?> getModelClass() {
		return CanvasUser.class;
	}

	@Override
	public String getModelClassName() {
		return CanvasUser.class.getName();
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

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getSID() {
		if (_SID == null) {
			return StringPool.BLANK;
		}
		else {
			return _SID;
		}
	}

	@Override
	public void setSID(String SID) {
		_SID = SID;
	}

	@JSON
	@Override
	public String getLoginId() {
		if (_loginId == null) {
			return StringPool.BLANK;
		}
		else {
			return _loginId;
		}
	}

	@Override
	public void setLoginId(String loginId) {
		_loginId = loginId;
	}

	@JSON
	@Override
	public String getPassword() {
		if (_password == null) {
			return StringPool.BLANK;
		}
		else {
			return _password;
		}
	}

	@Override
	public void setPassword(String password) {
		_password = password;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	@JSON
	@Override
	public String getFullName() {
		if (_fullName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	@JSON
	@Override
	public String getCanvasUserId() {
		if (_canvasUserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _canvasUserId;
		}
	}

	@Override
	public void setCanvasUserId(String canvasUserId) {
		_canvasUserId = canvasUserId;
	}

	@JSON
	@Override
	public double getCurrentScore() {
		return _currentScore;
	}

	@Override
	public void setCurrentScore(double currentScore) {
		_currentScore = currentScore;
	}

	@JSON
	@Override
	public double getFinalScore() {
		return _finalScore;
	}

	@Override
	public void setFinalScore(double finalScore) {
		_finalScore = finalScore;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CanvasUser.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CanvasUser toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CanvasUser)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CanvasUserImpl canvasUserImpl = new CanvasUserImpl();

		canvasUserImpl.setUserId(getUserId());
		canvasUserImpl.setSID(getSID());
		canvasUserImpl.setLoginId(getLoginId());
		canvasUserImpl.setPassword(getPassword());
		canvasUserImpl.setFirstName(getFirstName());
		canvasUserImpl.setLastName(getLastName());
		canvasUserImpl.setEmail(getEmail());
		canvasUserImpl.setStatus(getStatus());
		canvasUserImpl.setFullName(getFullName());
		canvasUserImpl.setCanvasUserId(getCanvasUserId());
		canvasUserImpl.setCurrentScore(getCurrentScore());
		canvasUserImpl.setFinalScore(getFinalScore());

		canvasUserImpl.resetOriginalValues();

		return canvasUserImpl;
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

		if (!(obj instanceof CanvasUser)) {
			return false;
		}

		CanvasUser canvasUser = (CanvasUser)obj;

		long primaryKey = canvasUser.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<CanvasUser> toCacheModel() {
		CanvasUserCacheModel canvasUserCacheModel = new CanvasUserCacheModel();

		canvasUserCacheModel.userId = getUserId();

		canvasUserCacheModel.SID = getSID();

		String SID = canvasUserCacheModel.SID;

		if ((SID != null) && (SID.length() == 0)) {
			canvasUserCacheModel.SID = null;
		}

		canvasUserCacheModel.loginId = getLoginId();

		String loginId = canvasUserCacheModel.loginId;

		if ((loginId != null) && (loginId.length() == 0)) {
			canvasUserCacheModel.loginId = null;
		}

		canvasUserCacheModel.password = getPassword();

		String password = canvasUserCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			canvasUserCacheModel.password = null;
		}

		canvasUserCacheModel.firstName = getFirstName();

		String firstName = canvasUserCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			canvasUserCacheModel.firstName = null;
		}

		canvasUserCacheModel.lastName = getLastName();

		String lastName = canvasUserCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			canvasUserCacheModel.lastName = null;
		}

		canvasUserCacheModel.email = getEmail();

		String email = canvasUserCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			canvasUserCacheModel.email = null;
		}

		canvasUserCacheModel.status = getStatus();

		String status = canvasUserCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			canvasUserCacheModel.status = null;
		}

		canvasUserCacheModel.fullName = getFullName();

		String fullName = canvasUserCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			canvasUserCacheModel.fullName = null;
		}

		canvasUserCacheModel.canvasUserId = getCanvasUserId();

		String canvasUserId = canvasUserCacheModel.canvasUserId;

		if ((canvasUserId != null) && (canvasUserId.length() == 0)) {
			canvasUserCacheModel.canvasUserId = null;
		}

		canvasUserCacheModel.currentScore = getCurrentScore();

		canvasUserCacheModel.finalScore = getFinalScore();

		return canvasUserCacheModel;
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

	private static ClassLoader _classLoader = CanvasUser.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CanvasUser.class
		};
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
	private CanvasUser _escapedModel;
}