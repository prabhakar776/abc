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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.TodoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.TodoServiceSoap
 * @generated
 */
public class TodoSoap implements Serializable {
	public static TodoSoap toSoapModel(Todo model) {
		TodoSoap soapModel = new TodoSoap();

		soapModel.setTodoId(model.getTodoId());
		soapModel.setType(model.getType());
		soapModel.setAssignmentName(model.getAssignmentName());
		soapModel.setAssignmentDescription(model.getAssignmentDescription());
		soapModel.setIgnore_(model.getIgnore_());
		soapModel.setIgnorePermanently(model.getIgnorePermanently());
		soapModel.setNeedsGradingCount(model.getNeedsGradingCount());
		soapModel.setContextType(model.getContextType());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setHtmlUrl(model.getHtmlUrl());

		return soapModel;
	}

	public static TodoSoap[] toSoapModels(Todo[] models) {
		TodoSoap[] soapModels = new TodoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TodoSoap[][] toSoapModels(Todo[][] models) {
		TodoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TodoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TodoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TodoSoap[] toSoapModels(List<Todo> models) {
		List<TodoSoap> soapModels = new ArrayList<TodoSoap>(models.size());

		for (Todo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TodoSoap[soapModels.size()]);
	}

	public TodoSoap() {
	}

	public long getPrimaryKey() {
		return _todoId;
	}

	public void setPrimaryKey(long pk) {
		setTodoId(pk);
	}

	public long getTodoId() {
		return _todoId;
	}

	public void setTodoId(long todoId) {
		_todoId = todoId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getAssignmentName() {
		return _assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		_assignmentName = assignmentName;
	}

	public String getAssignmentDescription() {
		return _assignmentDescription;
	}

	public void setAssignmentDescription(String assignmentDescription) {
		_assignmentDescription = assignmentDescription;
	}

	public String getIgnore_() {
		return _ignore_;
	}

	public void setIgnore_(String ignore_) {
		_ignore_ = ignore_;
	}

	public String getIgnorePermanently() {
		return _ignorePermanently;
	}

	public void setIgnorePermanently(String ignorePermanently) {
		_ignorePermanently = ignorePermanently;
	}

	public long getNeedsGradingCount() {
		return _needsGradingCount;
	}

	public void setNeedsGradingCount(long needsGradingCount) {
		_needsGradingCount = needsGradingCount;
	}

	public String getContextType() {
		return _contextType;
	}

	public void setContextType(String contextType) {
		_contextType = contextType;
	}

	public String getCourseId() {
		return _courseId;
	}

	public void setCourseId(String courseId) {
		_courseId = courseId;
	}

	public String getGroupId() {
		return _groupId;
	}

	public void setGroupId(String groupId) {
		_groupId = groupId;
	}

	public String getHtmlUrl() {
		return _htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		_htmlUrl = htmlUrl;
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
}