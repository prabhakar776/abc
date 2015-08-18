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
 * This class is a wrapper for {@link CanvasEnrollment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasEnrollment
 * @generated
 */
public class CanvasEnrollmentWrapper implements CanvasEnrollment,
	ModelWrapper<CanvasEnrollment> {
	public CanvasEnrollmentWrapper(CanvasEnrollment canvasEnrollment) {
		_canvasEnrollment = canvasEnrollment;
	}

	@Override
	public Class<?> getModelClass() {
		return CanvasEnrollment.class;
	}

	@Override
	public String getModelClassName() {
		return CanvasEnrollment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("courseId", getCourseId());
		attributes.put("userId", getUserId());
		attributes.put("role", getRole());
		attributes.put("sectionId", getSectionId());
		attributes.put("status", getStatus());
		attributes.put("associatedUserId", getAssociatedUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		String sectionId = (String)attributes.get("sectionId");

		if (sectionId != null) {
			setSectionId(sectionId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String associatedUserId = (String)attributes.get("associatedUserId");

		if (associatedUserId != null) {
			setAssociatedUserId(associatedUserId);
		}
	}

	/**
	* Returns the primary key of this canvas enrollment.
	*
	* @return the primary key of this canvas enrollment
	*/
	@Override
	public long getPrimaryKey() {
		return _canvasEnrollment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this canvas enrollment.
	*
	* @param primaryKey the primary key of this canvas enrollment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_canvasEnrollment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the course ID of this canvas enrollment.
	*
	* @return the course ID of this canvas enrollment
	*/
	@Override
	public long getCourseId() {
		return _canvasEnrollment.getCourseId();
	}

	/**
	* Sets the course ID of this canvas enrollment.
	*
	* @param courseId the course ID of this canvas enrollment
	*/
	@Override
	public void setCourseId(long courseId) {
		_canvasEnrollment.setCourseId(courseId);
	}

	/**
	* Returns the user ID of this canvas enrollment.
	*
	* @return the user ID of this canvas enrollment
	*/
	@Override
	public java.lang.String getUserId() {
		return _canvasEnrollment.getUserId();
	}

	/**
	* Sets the user ID of this canvas enrollment.
	*
	* @param userId the user ID of this canvas enrollment
	*/
	@Override
	public void setUserId(java.lang.String userId) {
		_canvasEnrollment.setUserId(userId);
	}

	/**
	* Returns the role of this canvas enrollment.
	*
	* @return the role of this canvas enrollment
	*/
	@Override
	public java.lang.String getRole() {
		return _canvasEnrollment.getRole();
	}

	/**
	* Sets the role of this canvas enrollment.
	*
	* @param role the role of this canvas enrollment
	*/
	@Override
	public void setRole(java.lang.String role) {
		_canvasEnrollment.setRole(role);
	}

	/**
	* Returns the section ID of this canvas enrollment.
	*
	* @return the section ID of this canvas enrollment
	*/
	@Override
	public java.lang.String getSectionId() {
		return _canvasEnrollment.getSectionId();
	}

	/**
	* Sets the section ID of this canvas enrollment.
	*
	* @param sectionId the section ID of this canvas enrollment
	*/
	@Override
	public void setSectionId(java.lang.String sectionId) {
		_canvasEnrollment.setSectionId(sectionId);
	}

	/**
	* Returns the status of this canvas enrollment.
	*
	* @return the status of this canvas enrollment
	*/
	@Override
	public java.lang.String getStatus() {
		return _canvasEnrollment.getStatus();
	}

	/**
	* Sets the status of this canvas enrollment.
	*
	* @param status the status of this canvas enrollment
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_canvasEnrollment.setStatus(status);
	}

	/**
	* Returns the associated user ID of this canvas enrollment.
	*
	* @return the associated user ID of this canvas enrollment
	*/
	@Override
	public java.lang.String getAssociatedUserId() {
		return _canvasEnrollment.getAssociatedUserId();
	}

	/**
	* Sets the associated user ID of this canvas enrollment.
	*
	* @param associatedUserId the associated user ID of this canvas enrollment
	*/
	@Override
	public void setAssociatedUserId(java.lang.String associatedUserId) {
		_canvasEnrollment.setAssociatedUserId(associatedUserId);
	}

	@Override
	public boolean isNew() {
		return _canvasEnrollment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_canvasEnrollment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _canvasEnrollment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_canvasEnrollment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _canvasEnrollment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _canvasEnrollment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_canvasEnrollment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _canvasEnrollment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_canvasEnrollment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_canvasEnrollment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_canvasEnrollment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CanvasEnrollmentWrapper((CanvasEnrollment)_canvasEnrollment.clone());
	}

	@Override
	public int compareTo(
		com.instructure.canvas.model.CanvasEnrollment canvasEnrollment) {
		return _canvasEnrollment.compareTo(canvasEnrollment);
	}

	@Override
	public int hashCode() {
		return _canvasEnrollment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.CanvasEnrollment> toCacheModel() {
		return _canvasEnrollment.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.CanvasEnrollment toEscapedModel() {
		return new CanvasEnrollmentWrapper(_canvasEnrollment.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.CanvasEnrollment toUnescapedModel() {
		return new CanvasEnrollmentWrapper(_canvasEnrollment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _canvasEnrollment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _canvasEnrollment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_canvasEnrollment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CanvasEnrollmentWrapper)) {
			return false;
		}

		CanvasEnrollmentWrapper canvasEnrollmentWrapper = (CanvasEnrollmentWrapper)obj;

		if (Validator.equals(_canvasEnrollment,
					canvasEnrollmentWrapper._canvasEnrollment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CanvasEnrollment getWrappedCanvasEnrollment() {
		return _canvasEnrollment;
	}

	@Override
	public CanvasEnrollment getWrappedModel() {
		return _canvasEnrollment;
	}

	@Override
	public void resetOriginalValues() {
		_canvasEnrollment.resetOriginalValues();
	}

	private CanvasEnrollment _canvasEnrollment;
}