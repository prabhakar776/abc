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

import com.instructure.canvas.service.ActivityStreamLocalServiceUtil;
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
public class ActivityStreamClp extends BaseModelImpl<ActivityStream>
	implements ActivityStream {
	public ActivityStreamClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ActivityStream.class;
	}

	@Override
	public String getModelClassName() {
		return ActivityStream.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _activityStreamId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setActivityStreamId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _activityStreamId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activityStreamId", getActivityStreamId());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("updatedAt", getUpdatedAt());
		attributes.put("id", getId());
		attributes.put("title", getTitle());
		attributes.put("message", getMessage());
		attributes.put("type", getType());
		attributes.put("contextType", getContextType());
		attributes.put("courseId", getCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("htmlUrl", getHtmlUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long activityStreamId = (Long)attributes.get("activityStreamId");

		if (activityStreamId != null) {
			setActivityStreamId(activityStreamId);
		}

		String createdAt = (String)attributes.get("createdAt");

		if (createdAt != null) {
			setCreatedAt(createdAt);
		}

		String updatedAt = (String)attributes.get("updatedAt");

		if (updatedAt != null) {
			setUpdatedAt(updatedAt);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String contextType = (String)attributes.get("contextType");

		if (contextType != null) {
			setContextType(contextType);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		String groupId = (String)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String htmlUrl = (String)attributes.get("htmlUrl");

		if (htmlUrl != null) {
			setHtmlUrl(htmlUrl);
		}
	}

	@Override
	public long getActivityStreamId() {
		return _activityStreamId;
	}

	@Override
	public void setActivityStreamId(long activityStreamId) {
		_activityStreamId = activityStreamId;

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityStreamId",
						long.class);

				method.invoke(_activityStreamRemoteModel, activityStreamId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedAt() {
		return _createdAt;
	}

	@Override
	public void setCreatedAt(String createdAt) {
		_createdAt = createdAt;

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedAt", String.class);

				method.invoke(_activityStreamRemoteModel, createdAt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUpdatedAt() {
		return _updatedAt;
	}

	@Override
	public void setUpdatedAt(String updatedAt) {
		_updatedAt = updatedAt;

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedAt", String.class);

				method.invoke(_activityStreamRemoteModel, updatedAt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_activityStreamRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_activityStreamRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessage() {
		return _message;
	}

	@Override
	public void setMessage(String message) {
		_message = message;

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setMessage", String.class);

				method.invoke(_activityStreamRemoteModel, message);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_activityStreamRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContextType() {
		return _contextType;
	}

	@Override
	public void setContextType(String contextType) {
		_contextType = contextType;

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setContextType", String.class);

				method.invoke(_activityStreamRemoteModel, contextType);
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

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseId", long.class);

				method.invoke(_activityStreamRemoteModel, courseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(String groupId) {
		_groupId = groupId;

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", String.class);

				method.invoke(_activityStreamRemoteModel, groupId);
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

		if (_activityStreamRemoteModel != null) {
			try {
				Class<?> clazz = _activityStreamRemoteModel.getClass();

				Method method = clazz.getMethod("setHtmlUrl", String.class);

				method.invoke(_activityStreamRemoteModel, htmlUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getActivityStreamRemoteModel() {
		return _activityStreamRemoteModel;
	}

	public void setActivityStreamRemoteModel(
		BaseModel<?> activityStreamRemoteModel) {
		_activityStreamRemoteModel = activityStreamRemoteModel;
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

		Class<?> remoteModelClass = _activityStreamRemoteModel.getClass();

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

		Object returnValue = method.invoke(_activityStreamRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ActivityStreamLocalServiceUtil.addActivityStream(this);
		}
		else {
			ActivityStreamLocalServiceUtil.updateActivityStream(this);
		}
	}

	@Override
	public ActivityStream toEscapedModel() {
		return (ActivityStream)ProxyUtil.newProxyInstance(ActivityStream.class.getClassLoader(),
			new Class[] { ActivityStream.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ActivityStreamClp clone = new ActivityStreamClp();

		clone.setActivityStreamId(getActivityStreamId());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setId(getId());
		clone.setTitle(getTitle());
		clone.setMessage(getMessage());
		clone.setType(getType());
		clone.setContextType(getContextType());
		clone.setCourseId(getCourseId());
		clone.setGroupId(getGroupId());
		clone.setHtmlUrl(getHtmlUrl());

		return clone;
	}

	@Override
	public int compareTo(ActivityStream activityStream) {
		long primaryKey = activityStream.getPrimaryKey();

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

		if (!(obj instanceof ActivityStreamClp)) {
			return false;
		}

		ActivityStreamClp activityStream = (ActivityStreamClp)obj;

		long primaryKey = activityStream.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{activityStreamId=");
		sb.append(getActivityStreamId());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", contextType=");
		sb.append(getContextType());
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", htmlUrl=");
		sb.append(getHtmlUrl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.ActivityStream");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>activityStreamId</column-name><column-value><![CDATA[");
		sb.append(getActivityStreamId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdAt</column-name><column-value><![CDATA[");
		sb.append(getCreatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedAt</column-name><column-value><![CDATA[");
		sb.append(getUpdatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contextType</column-name><column-value><![CDATA[");
		sb.append(getContextType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htmlUrl</column-name><column-value><![CDATA[");
		sb.append(getHtmlUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _activityStreamId;
	private String _createdAt;
	private String _updatedAt;
	private long _id;
	private String _title;
	private String _message;
	private String _type;
	private String _contextType;
	private long _courseId;
	private String _groupId;
	private String _htmlUrl;
	private BaseModel<?> _activityStreamRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}