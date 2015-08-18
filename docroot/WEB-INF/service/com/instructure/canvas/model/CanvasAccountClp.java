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

import com.instructure.canvas.service.CanvasAccountLocalServiceUtil;
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
public class CanvasAccountClp extends BaseModelImpl<CanvasAccount>
	implements CanvasAccount {
	public CanvasAccountClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CanvasAccount.class;
	}

	@Override
	public String getModelClassName() {
		return CanvasAccount.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _accountId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAccountId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _accountId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("accountId", getAccountId());
		attributes.put("id", getId());
		attributes.put("parentAccountId", getParentAccountId());
		attributes.put("name", getName());
		attributes.put("rootAccountId", getRootAccountId());
		attributes.put("SISAccountId", getSISAccountId());
		attributes.put("status", getStatus());
		attributes.put("timeZone", getTimeZone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String parentAccountId = (String)attributes.get("parentAccountId");

		if (parentAccountId != null) {
			setParentAccountId(parentAccountId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String rootAccountId = (String)attributes.get("rootAccountId");

		if (rootAccountId != null) {
			setRootAccountId(rootAccountId);
		}

		String SISAccountId = (String)attributes.get("SISAccountId");

		if (SISAccountId != null) {
			setSISAccountId(SISAccountId);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String timeZone = (String)attributes.get("timeZone");

		if (timeZone != null) {
			setTimeZone(timeZone);
		}
	}

	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		_accountId = accountId;

		if (_canvasAccountRemoteModel != null) {
			try {
				Class<?> clazz = _canvasAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountId", long.class);

				method.invoke(_canvasAccountRemoteModel, accountId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getId() {
		return _id;
	}

	@Override
	public void setId(String id) {
		_id = id;

		if (_canvasAccountRemoteModel != null) {
			try {
				Class<?> clazz = _canvasAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setId", String.class);

				method.invoke(_canvasAccountRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParentAccountId() {
		return _parentAccountId;
	}

	@Override
	public void setParentAccountId(String parentAccountId) {
		_parentAccountId = parentAccountId;

		if (_canvasAccountRemoteModel != null) {
			try {
				Class<?> clazz = _canvasAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setParentAccountId",
						String.class);

				method.invoke(_canvasAccountRemoteModel, parentAccountId);
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

		if (_canvasAccountRemoteModel != null) {
			try {
				Class<?> clazz = _canvasAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_canvasAccountRemoteModel, name);
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

		if (_canvasAccountRemoteModel != null) {
			try {
				Class<?> clazz = _canvasAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setRootAccountId", String.class);

				method.invoke(_canvasAccountRemoteModel, rootAccountId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSISAccountId() {
		return _SISAccountId;
	}

	@Override
	public void setSISAccountId(String SISAccountId) {
		_SISAccountId = SISAccountId;

		if (_canvasAccountRemoteModel != null) {
			try {
				Class<?> clazz = _canvasAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setSISAccountId", String.class);

				method.invoke(_canvasAccountRemoteModel, SISAccountId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatus() {
		return _status;
	}

	@Override
	public void setStatus(long status) {
		_status = status;

		if (_canvasAccountRemoteModel != null) {
			try {
				Class<?> clazz = _canvasAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", long.class);

				method.invoke(_canvasAccountRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTimeZone() {
		return _timeZone;
	}

	@Override
	public void setTimeZone(String timeZone) {
		_timeZone = timeZone;

		if (_canvasAccountRemoteModel != null) {
			try {
				Class<?> clazz = _canvasAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setTimeZone", String.class);

				method.invoke(_canvasAccountRemoteModel, timeZone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCanvasAccountRemoteModel() {
		return _canvasAccountRemoteModel;
	}

	public void setCanvasAccountRemoteModel(
		BaseModel<?> canvasAccountRemoteModel) {
		_canvasAccountRemoteModel = canvasAccountRemoteModel;
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

		Class<?> remoteModelClass = _canvasAccountRemoteModel.getClass();

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

		Object returnValue = method.invoke(_canvasAccountRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CanvasAccountLocalServiceUtil.addCanvasAccount(this);
		}
		else {
			CanvasAccountLocalServiceUtil.updateCanvasAccount(this);
		}
	}

	@Override
	public CanvasAccount toEscapedModel() {
		return (CanvasAccount)ProxyUtil.newProxyInstance(CanvasAccount.class.getClassLoader(),
			new Class[] { CanvasAccount.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CanvasAccountClp clone = new CanvasAccountClp();

		clone.setAccountId(getAccountId());
		clone.setId(getId());
		clone.setParentAccountId(getParentAccountId());
		clone.setName(getName());
		clone.setRootAccountId(getRootAccountId());
		clone.setSISAccountId(getSISAccountId());
		clone.setStatus(getStatus());
		clone.setTimeZone(getTimeZone());

		return clone;
	}

	@Override
	public int compareTo(CanvasAccount canvasAccount) {
		long primaryKey = canvasAccount.getPrimaryKey();

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

		if (!(obj instanceof CanvasAccountClp)) {
			return false;
		}

		CanvasAccountClp canvasAccount = (CanvasAccountClp)obj;

		long primaryKey = canvasAccount.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{accountId=");
		sb.append(getAccountId());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", parentAccountId=");
		sb.append(getParentAccountId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", rootAccountId=");
		sb.append(getRootAccountId());
		sb.append(", SISAccountId=");
		sb.append(getSISAccountId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", timeZone=");
		sb.append(getTimeZone());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.CanvasAccount");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentAccountId</column-name><column-value><![CDATA[");
		sb.append(getParentAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootAccountId</column-name><column-value><![CDATA[");
		sb.append(getRootAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SISAccountId</column-name><column-value><![CDATA[");
		sb.append(getSISAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeZone</column-name><column-value><![CDATA[");
		sb.append(getTimeZone());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _accountId;
	private String _id;
	private String _parentAccountId;
	private String _name;
	private String _rootAccountId;
	private String _SISAccountId;
	private long _status;
	private String _timeZone;
	private BaseModel<?> _canvasAccountRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}