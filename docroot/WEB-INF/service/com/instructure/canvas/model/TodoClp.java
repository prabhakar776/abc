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
import com.instructure.canvas.service.TodoLocalServiceUtil;

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
public class TodoClp extends BaseModelImpl<Todo> implements Todo {
	public TodoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Todo.class;
	}

	@Override
	public String getModelClassName() {
		return Todo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _todoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTodoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _todoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("todoId", getTodoId());
		attributes.put("type", getType());
		attributes.put("assignmentName", getAssignmentName());
		attributes.put("assignmentDescription", getAssignmentDescription());
		attributes.put("ignore_", getIgnore_());
		attributes.put("ignorePermanently", getIgnorePermanently());
		attributes.put("needsGradingCount", getNeedsGradingCount());
		attributes.put("contextType", getContextType());
		attributes.put("courseId", getCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("htmlUrl", getHtmlUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long todoId = (Long)attributes.get("todoId");

		if (todoId != null) {
			setTodoId(todoId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String assignmentName = (String)attributes.get("assignmentName");

		if (assignmentName != null) {
			setAssignmentName(assignmentName);
		}

		String assignmentDescription = (String)attributes.get(
				"assignmentDescription");

		if (assignmentDescription != null) {
			setAssignmentDescription(assignmentDescription);
		}

		String ignore_ = (String)attributes.get("ignore_");

		if (ignore_ != null) {
			setIgnore_(ignore_);
		}

		String ignorePermanently = (String)attributes.get("ignorePermanently");

		if (ignorePermanently != null) {
			setIgnorePermanently(ignorePermanently);
		}

		Long needsGradingCount = (Long)attributes.get("needsGradingCount");

		if (needsGradingCount != null) {
			setNeedsGradingCount(needsGradingCount);
		}

		String contextType = (String)attributes.get("contextType");

		if (contextType != null) {
			setContextType(contextType);
		}

		String courseId = (String)attributes.get("courseId");

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
	public long getTodoId() {
		return _todoId;
	}

	@Override
	public void setTodoId(long todoId) {
		_todoId = todoId;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setTodoId", long.class);

				method.invoke(_todoRemoteModel, todoId);
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

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_todoRemoteModel, type);
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

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignmentName",
						String.class);

				method.invoke(_todoRemoteModel, assignmentName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssignmentDescription() {
		return _assignmentDescription;
	}

	@Override
	public void setAssignmentDescription(String assignmentDescription) {
		_assignmentDescription = assignmentDescription;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignmentDescription",
						String.class);

				method.invoke(_todoRemoteModel, assignmentDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIgnore_() {
		return _ignore_;
	}

	@Override
	public void setIgnore_(String ignore_) {
		_ignore_ = ignore_;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setIgnore_", String.class);

				method.invoke(_todoRemoteModel, ignore_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIgnorePermanently() {
		return _ignorePermanently;
	}

	@Override
	public void setIgnorePermanently(String ignorePermanently) {
		_ignorePermanently = ignorePermanently;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setIgnorePermanently",
						String.class);

				method.invoke(_todoRemoteModel, ignorePermanently);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNeedsGradingCount() {
		return _needsGradingCount;
	}

	@Override
	public void setNeedsGradingCount(long needsGradingCount) {
		_needsGradingCount = needsGradingCount;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setNeedsGradingCount",
						long.class);

				method.invoke(_todoRemoteModel, needsGradingCount);
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

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setContextType", String.class);

				method.invoke(_todoRemoteModel, contextType);
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

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseId", String.class);

				method.invoke(_todoRemoteModel, courseId);
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

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", String.class);

				method.invoke(_todoRemoteModel, groupId);
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

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setHtmlUrl", String.class);

				method.invoke(_todoRemoteModel, htmlUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTodoRemoteModel() {
		return _todoRemoteModel;
	}

	public void setTodoRemoteModel(BaseModel<?> todoRemoteModel) {
		_todoRemoteModel = todoRemoteModel;
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

		Class<?> remoteModelClass = _todoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_todoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TodoLocalServiceUtil.addTodo(this);
		}
		else {
			TodoLocalServiceUtil.updateTodo(this);
		}
	}

	@Override
	public Todo toEscapedModel() {
		return (Todo)ProxyUtil.newProxyInstance(Todo.class.getClassLoader(),
			new Class[] { Todo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TodoClp clone = new TodoClp();

		clone.setTodoId(getTodoId());
		clone.setType(getType());
		clone.setAssignmentName(getAssignmentName());
		clone.setAssignmentDescription(getAssignmentDescription());
		clone.setIgnore_(getIgnore_());
		clone.setIgnorePermanently(getIgnorePermanently());
		clone.setNeedsGradingCount(getNeedsGradingCount());
		clone.setContextType(getContextType());
		clone.setCourseId(getCourseId());
		clone.setGroupId(getGroupId());
		clone.setHtmlUrl(getHtmlUrl());

		return clone;
	}

	@Override
	public int compareTo(Todo todo) {
		long primaryKey = todo.getPrimaryKey();

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

		if (!(obj instanceof TodoClp)) {
			return false;
		}

		TodoClp todo = (TodoClp)obj;

		long primaryKey = todo.getPrimaryKey();

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

		sb.append("{todoId=");
		sb.append(getTodoId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", assignmentName=");
		sb.append(getAssignmentName());
		sb.append(", assignmentDescription=");
		sb.append(getAssignmentDescription());
		sb.append(", ignore_=");
		sb.append(getIgnore_());
		sb.append(", ignorePermanently=");
		sb.append(getIgnorePermanently());
		sb.append(", needsGradingCount=");
		sb.append(getNeedsGradingCount());
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
		sb.append("com.instructure.canvas.model.Todo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>todoId</column-name><column-value><![CDATA[");
		sb.append(getTodoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assignmentName</column-name><column-value><![CDATA[");
		sb.append(getAssignmentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assignmentDescription</column-name><column-value><![CDATA[");
		sb.append(getAssignmentDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ignore_</column-name><column-value><![CDATA[");
		sb.append(getIgnore_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ignorePermanently</column-name><column-value><![CDATA[");
		sb.append(getIgnorePermanently());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>needsGradingCount</column-name><column-value><![CDATA[");
		sb.append(getNeedsGradingCount());
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

	private long _todoId;
	private String _type;
	private String _assignmentName;
	private String _assignmentDescription;
	private String _ignore_;
	private String _ignorePermanently;
	private long _needsGradingCount;
	private String _contextType;
	private String _courseId;
	private String _groupId;
	private String _htmlUrl;
	private BaseModel<?> _todoRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}