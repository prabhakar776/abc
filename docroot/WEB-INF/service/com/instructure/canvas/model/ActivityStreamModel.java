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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ActivityStream service. Represents a row in the &quot;CANVAS_ActivityStream&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.instructure.canvas.model.impl.ActivityStreamModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.instructure.canvas.model.impl.ActivityStreamImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityStream
 * @see com.instructure.canvas.model.impl.ActivityStreamImpl
 * @see com.instructure.canvas.model.impl.ActivityStreamModelImpl
 * @generated
 */
public interface ActivityStreamModel extends BaseModel<ActivityStream> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a activity stream model instance should use the {@link ActivityStream} interface instead.
	 */

	/**
	 * Returns the primary key of this activity stream.
	 *
	 * @return the primary key of this activity stream
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this activity stream.
	 *
	 * @param primaryKey the primary key of this activity stream
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the activity stream ID of this activity stream.
	 *
	 * @return the activity stream ID of this activity stream
	 */
	public long getActivityStreamId();

	/**
	 * Sets the activity stream ID of this activity stream.
	 *
	 * @param activityStreamId the activity stream ID of this activity stream
	 */
	public void setActivityStreamId(long activityStreamId);

	/**
	 * Returns the created at of this activity stream.
	 *
	 * @return the created at of this activity stream
	 */
	@AutoEscape
	public String getCreatedAt();

	/**
	 * Sets the created at of this activity stream.
	 *
	 * @param createdAt the created at of this activity stream
	 */
	public void setCreatedAt(String createdAt);

	/**
	 * Returns the updated at of this activity stream.
	 *
	 * @return the updated at of this activity stream
	 */
	@AutoEscape
	public String getUpdatedAt();

	/**
	 * Sets the updated at of this activity stream.
	 *
	 * @param updatedAt the updated at of this activity stream
	 */
	public void setUpdatedAt(String updatedAt);

	/**
	 * Returns the ID of this activity stream.
	 *
	 * @return the ID of this activity stream
	 */
	public long getId();

	/**
	 * Sets the ID of this activity stream.
	 *
	 * @param id the ID of this activity stream
	 */
	public void setId(long id);

	/**
	 * Returns the title of this activity stream.
	 *
	 * @return the title of this activity stream
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this activity stream.
	 *
	 * @param title the title of this activity stream
	 */
	public void setTitle(String title);

	/**
	 * Returns the message of this activity stream.
	 *
	 * @return the message of this activity stream
	 */
	@AutoEscape
	public String getMessage();

	/**
	 * Sets the message of this activity stream.
	 *
	 * @param message the message of this activity stream
	 */
	public void setMessage(String message);

	/**
	 * Returns the type of this activity stream.
	 *
	 * @return the type of this activity stream
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this activity stream.
	 *
	 * @param type the type of this activity stream
	 */
	public void setType(String type);

	/**
	 * Returns the context type of this activity stream.
	 *
	 * @return the context type of this activity stream
	 */
	@AutoEscape
	public String getContextType();

	/**
	 * Sets the context type of this activity stream.
	 *
	 * @param contextType the context type of this activity stream
	 */
	public void setContextType(String contextType);

	/**
	 * Returns the course ID of this activity stream.
	 *
	 * @return the course ID of this activity stream
	 */
	public long getCourseId();

	/**
	 * Sets the course ID of this activity stream.
	 *
	 * @param courseId the course ID of this activity stream
	 */
	public void setCourseId(long courseId);

	/**
	 * Returns the group ID of this activity stream.
	 *
	 * @return the group ID of this activity stream
	 */
	@AutoEscape
	public String getGroupId();

	/**
	 * Sets the group ID of this activity stream.
	 *
	 * @param groupId the group ID of this activity stream
	 */
	public void setGroupId(String groupId);

	/**
	 * Returns the html url of this activity stream.
	 *
	 * @return the html url of this activity stream
	 */
	@AutoEscape
	public String getHtmlUrl();

	/**
	 * Sets the html url of this activity stream.
	 *
	 * @param htmlUrl the html url of this activity stream
	 */
	public void setHtmlUrl(String htmlUrl);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ActivityStream activityStream);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ActivityStream> toCacheModel();

	@Override
	public ActivityStream toEscapedModel();

	@Override
	public ActivityStream toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}