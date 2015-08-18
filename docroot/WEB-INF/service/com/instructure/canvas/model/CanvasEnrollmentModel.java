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
 * The base model interface for the CanvasEnrollment service. Represents a row in the &quot;CANVAS_CanvasEnrollment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.instructure.canvas.model.impl.CanvasEnrollmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.instructure.canvas.model.impl.CanvasEnrollmentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasEnrollment
 * @see com.instructure.canvas.model.impl.CanvasEnrollmentImpl
 * @see com.instructure.canvas.model.impl.CanvasEnrollmentModelImpl
 * @generated
 */
public interface CanvasEnrollmentModel extends BaseModel<CanvasEnrollment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a canvas enrollment model instance should use the {@link CanvasEnrollment} interface instead.
	 */

	/**
	 * Returns the primary key of this canvas enrollment.
	 *
	 * @return the primary key of this canvas enrollment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this canvas enrollment.
	 *
	 * @param primaryKey the primary key of this canvas enrollment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the course ID of this canvas enrollment.
	 *
	 * @return the course ID of this canvas enrollment
	 */
	public long getCourseId();

	/**
	 * Sets the course ID of this canvas enrollment.
	 *
	 * @param courseId the course ID of this canvas enrollment
	 */
	public void setCourseId(long courseId);

	/**
	 * Returns the user ID of this canvas enrollment.
	 *
	 * @return the user ID of this canvas enrollment
	 */
	@AutoEscape
	public String getUserId();

	/**
	 * Sets the user ID of this canvas enrollment.
	 *
	 * @param userId the user ID of this canvas enrollment
	 */
	public void setUserId(String userId);

	/**
	 * Returns the role of this canvas enrollment.
	 *
	 * @return the role of this canvas enrollment
	 */
	@AutoEscape
	public String getRole();

	/**
	 * Sets the role of this canvas enrollment.
	 *
	 * @param role the role of this canvas enrollment
	 */
	public void setRole(String role);

	/**
	 * Returns the section ID of this canvas enrollment.
	 *
	 * @return the section ID of this canvas enrollment
	 */
	@AutoEscape
	public String getSectionId();

	/**
	 * Sets the section ID of this canvas enrollment.
	 *
	 * @param sectionId the section ID of this canvas enrollment
	 */
	public void setSectionId(String sectionId);

	/**
	 * Returns the status of this canvas enrollment.
	 *
	 * @return the status of this canvas enrollment
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this canvas enrollment.
	 *
	 * @param status the status of this canvas enrollment
	 */
	public void setStatus(String status);

	/**
	 * Returns the associated user ID of this canvas enrollment.
	 *
	 * @return the associated user ID of this canvas enrollment
	 */
	@AutoEscape
	public String getAssociatedUserId();

	/**
	 * Sets the associated user ID of this canvas enrollment.
	 *
	 * @param associatedUserId the associated user ID of this canvas enrollment
	 */
	public void setAssociatedUserId(String associatedUserId);

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
	public int compareTo(CanvasEnrollment canvasEnrollment);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CanvasEnrollment> toCacheModel();

	@Override
	public CanvasEnrollment toEscapedModel();

	@Override
	public CanvasEnrollment toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}