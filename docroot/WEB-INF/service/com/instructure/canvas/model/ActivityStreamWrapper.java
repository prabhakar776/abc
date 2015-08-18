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
 * This class is a wrapper for {@link ActivityStream}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityStream
 * @generated
 */
public class ActivityStreamWrapper implements ActivityStream,
	ModelWrapper<ActivityStream> {
	public ActivityStreamWrapper(ActivityStream activityStream) {
		_activityStream = activityStream;
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

	/**
	* Returns the primary key of this activity stream.
	*
	* @return the primary key of this activity stream
	*/
	@Override
	public long getPrimaryKey() {
		return _activityStream.getPrimaryKey();
	}

	/**
	* Sets the primary key of this activity stream.
	*
	* @param primaryKey the primary key of this activity stream
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_activityStream.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the activity stream ID of this activity stream.
	*
	* @return the activity stream ID of this activity stream
	*/
	@Override
	public long getActivityStreamId() {
		return _activityStream.getActivityStreamId();
	}

	/**
	* Sets the activity stream ID of this activity stream.
	*
	* @param activityStreamId the activity stream ID of this activity stream
	*/
	@Override
	public void setActivityStreamId(long activityStreamId) {
		_activityStream.setActivityStreamId(activityStreamId);
	}

	/**
	* Returns the created at of this activity stream.
	*
	* @return the created at of this activity stream
	*/
	@Override
	public java.lang.String getCreatedAt() {
		return _activityStream.getCreatedAt();
	}

	/**
	* Sets the created at of this activity stream.
	*
	* @param createdAt the created at of this activity stream
	*/
	@Override
	public void setCreatedAt(java.lang.String createdAt) {
		_activityStream.setCreatedAt(createdAt);
	}

	/**
	* Returns the updated at of this activity stream.
	*
	* @return the updated at of this activity stream
	*/
	@Override
	public java.lang.String getUpdatedAt() {
		return _activityStream.getUpdatedAt();
	}

	/**
	* Sets the updated at of this activity stream.
	*
	* @param updatedAt the updated at of this activity stream
	*/
	@Override
	public void setUpdatedAt(java.lang.String updatedAt) {
		_activityStream.setUpdatedAt(updatedAt);
	}

	/**
	* Returns the ID of this activity stream.
	*
	* @return the ID of this activity stream
	*/
	@Override
	public long getId() {
		return _activityStream.getId();
	}

	/**
	* Sets the ID of this activity stream.
	*
	* @param id the ID of this activity stream
	*/
	@Override
	public void setId(long id) {
		_activityStream.setId(id);
	}

	/**
	* Returns the title of this activity stream.
	*
	* @return the title of this activity stream
	*/
	@Override
	public java.lang.String getTitle() {
		return _activityStream.getTitle();
	}

	/**
	* Sets the title of this activity stream.
	*
	* @param title the title of this activity stream
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_activityStream.setTitle(title);
	}

	/**
	* Returns the message of this activity stream.
	*
	* @return the message of this activity stream
	*/
	@Override
	public java.lang.String getMessage() {
		return _activityStream.getMessage();
	}

	/**
	* Sets the message of this activity stream.
	*
	* @param message the message of this activity stream
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_activityStream.setMessage(message);
	}

	/**
	* Returns the type of this activity stream.
	*
	* @return the type of this activity stream
	*/
	@Override
	public java.lang.String getType() {
		return _activityStream.getType();
	}

	/**
	* Sets the type of this activity stream.
	*
	* @param type the type of this activity stream
	*/
	@Override
	public void setType(java.lang.String type) {
		_activityStream.setType(type);
	}

	/**
	* Returns the context type of this activity stream.
	*
	* @return the context type of this activity stream
	*/
	@Override
	public java.lang.String getContextType() {
		return _activityStream.getContextType();
	}

	/**
	* Sets the context type of this activity stream.
	*
	* @param contextType the context type of this activity stream
	*/
	@Override
	public void setContextType(java.lang.String contextType) {
		_activityStream.setContextType(contextType);
	}

	/**
	* Returns the course ID of this activity stream.
	*
	* @return the course ID of this activity stream
	*/
	@Override
	public long getCourseId() {
		return _activityStream.getCourseId();
	}

	/**
	* Sets the course ID of this activity stream.
	*
	* @param courseId the course ID of this activity stream
	*/
	@Override
	public void setCourseId(long courseId) {
		_activityStream.setCourseId(courseId);
	}

	/**
	* Returns the group ID of this activity stream.
	*
	* @return the group ID of this activity stream
	*/
	@Override
	public java.lang.String getGroupId() {
		return _activityStream.getGroupId();
	}

	/**
	* Sets the group ID of this activity stream.
	*
	* @param groupId the group ID of this activity stream
	*/
	@Override
	public void setGroupId(java.lang.String groupId) {
		_activityStream.setGroupId(groupId);
	}

	/**
	* Returns the html url of this activity stream.
	*
	* @return the html url of this activity stream
	*/
	@Override
	public java.lang.String getHtmlUrl() {
		return _activityStream.getHtmlUrl();
	}

	/**
	* Sets the html url of this activity stream.
	*
	* @param htmlUrl the html url of this activity stream
	*/
	@Override
	public void setHtmlUrl(java.lang.String htmlUrl) {
		_activityStream.setHtmlUrl(htmlUrl);
	}

	@Override
	public boolean isNew() {
		return _activityStream.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_activityStream.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _activityStream.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_activityStream.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _activityStream.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _activityStream.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_activityStream.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _activityStream.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_activityStream.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_activityStream.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_activityStream.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ActivityStreamWrapper((ActivityStream)_activityStream.clone());
	}

	@Override
	public int compareTo(
		com.instructure.canvas.model.ActivityStream activityStream) {
		return _activityStream.compareTo(activityStream);
	}

	@Override
	public int hashCode() {
		return _activityStream.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.ActivityStream> toCacheModel() {
		return _activityStream.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.ActivityStream toEscapedModel() {
		return new ActivityStreamWrapper(_activityStream.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.ActivityStream toUnescapedModel() {
		return new ActivityStreamWrapper(_activityStream.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _activityStream.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _activityStream.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_activityStream.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActivityStreamWrapper)) {
			return false;
		}

		ActivityStreamWrapper activityStreamWrapper = (ActivityStreamWrapper)obj;

		if (Validator.equals(_activityStream,
					activityStreamWrapper._activityStream)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ActivityStream getWrappedActivityStream() {
		return _activityStream;
	}

	@Override
	public ActivityStream getWrappedModel() {
		return _activityStream;
	}

	@Override
	public void resetOriginalValues() {
		_activityStream.resetOriginalValues();
	}

	private ActivityStream _activityStream;
}