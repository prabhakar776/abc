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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Todo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Todo
 * @generated
 */
public class TodoWrapper implements Todo, ModelWrapper<Todo> {
	public TodoWrapper(Todo todo) {
		_todo = todo;
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

	/**
	* Returns the primary key of this todo.
	*
	* @return the primary key of this todo
	*/
	@Override
	public long getPrimaryKey() {
		return _todo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this todo.
	*
	* @param primaryKey the primary key of this todo
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_todo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the todo ID of this todo.
	*
	* @return the todo ID of this todo
	*/
	@Override
	public long getTodoId() {
		return _todo.getTodoId();
	}

	/**
	* Sets the todo ID of this todo.
	*
	* @param todoId the todo ID of this todo
	*/
	@Override
	public void setTodoId(long todoId) {
		_todo.setTodoId(todoId);
	}

	/**
	* Returns the type of this todo.
	*
	* @return the type of this todo
	*/
	@Override
	public java.lang.String getType() {
		return _todo.getType();
	}

	/**
	* Sets the type of this todo.
	*
	* @param type the type of this todo
	*/
	@Override
	public void setType(java.lang.String type) {
		_todo.setType(type);
	}

	/**
	* Returns the assignment name of this todo.
	*
	* @return the assignment name of this todo
	*/
	@Override
	public java.lang.String getAssignmentName() {
		return _todo.getAssignmentName();
	}

	/**
	* Sets the assignment name of this todo.
	*
	* @param assignmentName the assignment name of this todo
	*/
	@Override
	public void setAssignmentName(java.lang.String assignmentName) {
		_todo.setAssignmentName(assignmentName);
	}

	/**
	* Returns the assignment description of this todo.
	*
	* @return the assignment description of this todo
	*/
	@Override
	public java.lang.String getAssignmentDescription() {
		return _todo.getAssignmentDescription();
	}

	/**
	* Sets the assignment description of this todo.
	*
	* @param assignmentDescription the assignment description of this todo
	*/
	@Override
	public void setAssignmentDescription(java.lang.String assignmentDescription) {
		_todo.setAssignmentDescription(assignmentDescription);
	}

	/**
	* Returns the ignore_ of this todo.
	*
	* @return the ignore_ of this todo
	*/
	@Override
	public java.lang.String getIgnore_() {
		return _todo.getIgnore_();
	}

	/**
	* Sets the ignore_ of this todo.
	*
	* @param ignore_ the ignore_ of this todo
	*/
	@Override
	public void setIgnore_(java.lang.String ignore_) {
		_todo.setIgnore_(ignore_);
	}

	/**
	* Returns the ignore permanently of this todo.
	*
	* @return the ignore permanently of this todo
	*/
	@Override
	public java.lang.String getIgnorePermanently() {
		return _todo.getIgnorePermanently();
	}

	/**
	* Sets the ignore permanently of this todo.
	*
	* @param ignorePermanently the ignore permanently of this todo
	*/
	@Override
	public void setIgnorePermanently(java.lang.String ignorePermanently) {
		_todo.setIgnorePermanently(ignorePermanently);
	}

	/**
	* Returns the needs grading count of this todo.
	*
	* @return the needs grading count of this todo
	*/
	@Override
	public long getNeedsGradingCount() {
		return _todo.getNeedsGradingCount();
	}

	/**
	* Sets the needs grading count of this todo.
	*
	* @param needsGradingCount the needs grading count of this todo
	*/
	@Override
	public void setNeedsGradingCount(long needsGradingCount) {
		_todo.setNeedsGradingCount(needsGradingCount);
	}

	/**
	* Returns the context type of this todo.
	*
	* @return the context type of this todo
	*/
	@Override
	public java.lang.String getContextType() {
		return _todo.getContextType();
	}

	/**
	* Sets the context type of this todo.
	*
	* @param contextType the context type of this todo
	*/
	@Override
	public void setContextType(java.lang.String contextType) {
		_todo.setContextType(contextType);
	}

	/**
	* Returns the course ID of this todo.
	*
	* @return the course ID of this todo
	*/
	@Override
	public java.lang.String getCourseId() {
		return _todo.getCourseId();
	}

	/**
	* Sets the course ID of this todo.
	*
	* @param courseId the course ID of this todo
	*/
	@Override
	public void setCourseId(java.lang.String courseId) {
		_todo.setCourseId(courseId);
	}

	/**
	* Returns the group ID of this todo.
	*
	* @return the group ID of this todo
	*/
	@Override
	public java.lang.String getGroupId() {
		return _todo.getGroupId();
	}

	/**
	* Sets the group ID of this todo.
	*
	* @param groupId the group ID of this todo
	*/
	@Override
	public void setGroupId(java.lang.String groupId) {
		_todo.setGroupId(groupId);
	}

	/**
	* Returns the html url of this todo.
	*
	* @return the html url of this todo
	*/
	@Override
	public java.lang.String getHtmlUrl() {
		return _todo.getHtmlUrl();
	}

	/**
	* Sets the html url of this todo.
	*
	* @param htmlUrl the html url of this todo
	*/
	@Override
	public void setHtmlUrl(java.lang.String htmlUrl) {
		_todo.setHtmlUrl(htmlUrl);
	}

	@Override
	public boolean isNew() {
		return _todo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_todo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _todo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_todo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _todo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _todo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_todo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _todo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_todo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_todo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_todo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TodoWrapper((Todo)_todo.clone());
	}

	@Override
	public int compareTo(com.instructure.canvas.model.Todo todo) {
		return _todo.compareTo(todo);
	}

	@Override
	public int hashCode() {
		return _todo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.Todo> toCacheModel() {
		return _todo.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.Todo toEscapedModel() {
		return new TodoWrapper(_todo.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.Todo toUnescapedModel() {
		return new TodoWrapper(_todo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _todo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _todo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_todo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TodoWrapper)) {
			return false;
		}

		TodoWrapper todoWrapper = (TodoWrapper)obj;

		if (Validator.equals(_todo, todoWrapper._todo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Todo getWrappedTodo() {
		return _todo;
	}

	@Override
	public Todo getWrappedModel() {
		return _todo;
	}

	@Override
	public void resetOriginalValues() {
		_todo.resetOriginalValues();
	}

	private Todo _todo;
}