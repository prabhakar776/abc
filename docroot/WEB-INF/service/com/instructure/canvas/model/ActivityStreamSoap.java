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
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.ActivityStreamServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.ActivityStreamServiceSoap
 * @generated
 */
public class ActivityStreamSoap implements Serializable {
	public static ActivityStreamSoap toSoapModel(ActivityStream model) {
		ActivityStreamSoap soapModel = new ActivityStreamSoap();

		soapModel.setActivityStreamId(model.getActivityStreamId());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setId(model.getId());
		soapModel.setTitle(model.getTitle());
		soapModel.setMessage(model.getMessage());
		soapModel.setType(model.getType());
		soapModel.setContextType(model.getContextType());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setHtmlUrl(model.getHtmlUrl());

		return soapModel;
	}

	public static ActivityStreamSoap[] toSoapModels(ActivityStream[] models) {
		ActivityStreamSoap[] soapModels = new ActivityStreamSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActivityStreamSoap[][] toSoapModels(ActivityStream[][] models) {
		ActivityStreamSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActivityStreamSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActivityStreamSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActivityStreamSoap[] toSoapModels(List<ActivityStream> models) {
		List<ActivityStreamSoap> soapModels = new ArrayList<ActivityStreamSoap>(models.size());

		for (ActivityStream model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActivityStreamSoap[soapModels.size()]);
	}

	public ActivityStreamSoap() {
	}

	public long getPrimaryKey() {
		return _activityStreamId;
	}

	public void setPrimaryKey(long pk) {
		setActivityStreamId(pk);
	}

	public long getActivityStreamId() {
		return _activityStreamId;
	}

	public void setActivityStreamId(long activityStreamId) {
		_activityStreamId = activityStreamId;
	}

	public String getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(String createdAt) {
		_createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		_updatedAt = updatedAt;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getContextType() {
		return _contextType;
	}

	public void setContextType(String contextType) {
		_contextType = contextType;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
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
}