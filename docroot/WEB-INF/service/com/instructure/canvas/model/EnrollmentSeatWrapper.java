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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EnrollmentSeat}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnrollmentSeat
 * @generated
 */
public class EnrollmentSeatWrapper implements EnrollmentSeat,
	ModelWrapper<EnrollmentSeat> {
	public EnrollmentSeatWrapper(EnrollmentSeat enrollmentSeat) {
		_enrollmentSeat = enrollmentSeat;
	}

	@Override
	public Class<?> getModelClass() {
		return EnrollmentSeat.class;
	}

	@Override
	public String getModelClassName() {
		return EnrollmentSeat.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("token", getToken());
		attributes.put("rootAccountId", getRootAccountId());
		attributes.put("courseId", getCourseId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("redeemDate", getRedeemDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}

		String rootAccountId = (String)attributes.get("rootAccountId");

		if (rootAccountId != null) {
			setRootAccountId(rootAccountId);
		}

		String courseId = (String)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date redeemDate = (Date)attributes.get("redeemDate");

		if (redeemDate != null) {
			setRedeemDate(redeemDate);
		}
	}

	/**
	* Returns the primary key of this enrollment seat.
	*
	* @return the primary key of this enrollment seat
	*/
	@Override
	public long getPrimaryKey() {
		return _enrollmentSeat.getPrimaryKey();
	}

	/**
	* Sets the primary key of this enrollment seat.
	*
	* @param primaryKey the primary key of this enrollment seat
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_enrollmentSeat.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this enrollment seat.
	*
	* @return the ID of this enrollment seat
	*/
	@Override
	public long getId() {
		return _enrollmentSeat.getId();
	}

	/**
	* Sets the ID of this enrollment seat.
	*
	* @param id the ID of this enrollment seat
	*/
	@Override
	public void setId(long id) {
		_enrollmentSeat.setId(id);
	}

	/**
	* Returns the token of this enrollment seat.
	*
	* @return the token of this enrollment seat
	*/
	@Override
	public java.lang.String getToken() {
		return _enrollmentSeat.getToken();
	}

	/**
	* Sets the token of this enrollment seat.
	*
	* @param token the token of this enrollment seat
	*/
	@Override
	public void setToken(java.lang.String token) {
		_enrollmentSeat.setToken(token);
	}

	/**
	* Returns the root account ID of this enrollment seat.
	*
	* @return the root account ID of this enrollment seat
	*/
	@Override
	public java.lang.String getRootAccountId() {
		return _enrollmentSeat.getRootAccountId();
	}

	/**
	* Sets the root account ID of this enrollment seat.
	*
	* @param rootAccountId the root account ID of this enrollment seat
	*/
	@Override
	public void setRootAccountId(java.lang.String rootAccountId) {
		_enrollmentSeat.setRootAccountId(rootAccountId);
	}

	/**
	* Returns the course ID of this enrollment seat.
	*
	* @return the course ID of this enrollment seat
	*/
	@Override
	public java.lang.String getCourseId() {
		return _enrollmentSeat.getCourseId();
	}

	/**
	* Sets the course ID of this enrollment seat.
	*
	* @param courseId the course ID of this enrollment seat
	*/
	@Override
	public void setCourseId(java.lang.String courseId) {
		_enrollmentSeat.setCourseId(courseId);
	}

	/**
	* Returns the user ID of this enrollment seat.
	*
	* @return the user ID of this enrollment seat
	*/
	@Override
	public long getUserId() {
		return _enrollmentSeat.getUserId();
	}

	/**
	* Sets the user ID of this enrollment seat.
	*
	* @param userId the user ID of this enrollment seat
	*/
	@Override
	public void setUserId(long userId) {
		_enrollmentSeat.setUserId(userId);
	}

	/**
	* Returns the user uuid of this enrollment seat.
	*
	* @return the user uuid of this enrollment seat
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeat.getUserUuid();
	}

	/**
	* Sets the user uuid of this enrollment seat.
	*
	* @param userUuid the user uuid of this enrollment seat
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_enrollmentSeat.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this enrollment seat.
	*
	* @return the create date of this enrollment seat
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _enrollmentSeat.getCreateDate();
	}

	/**
	* Sets the create date of this enrollment seat.
	*
	* @param createDate the create date of this enrollment seat
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_enrollmentSeat.setCreateDate(createDate);
	}

	/**
	* Returns the redeem date of this enrollment seat.
	*
	* @return the redeem date of this enrollment seat
	*/
	@Override
	public java.util.Date getRedeemDate() {
		return _enrollmentSeat.getRedeemDate();
	}

	/**
	* Sets the redeem date of this enrollment seat.
	*
	* @param redeemDate the redeem date of this enrollment seat
	*/
	@Override
	public void setRedeemDate(java.util.Date redeemDate) {
		_enrollmentSeat.setRedeemDate(redeemDate);
	}

	@Override
	public boolean isNew() {
		return _enrollmentSeat.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_enrollmentSeat.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _enrollmentSeat.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_enrollmentSeat.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _enrollmentSeat.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _enrollmentSeat.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_enrollmentSeat.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _enrollmentSeat.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_enrollmentSeat.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_enrollmentSeat.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_enrollmentSeat.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EnrollmentSeatWrapper((EnrollmentSeat)_enrollmentSeat.clone());
	}

	@Override
	public int compareTo(
		com.instructure.canvas.model.EnrollmentSeat enrollmentSeat) {
		return _enrollmentSeat.compareTo(enrollmentSeat);
	}

	@Override
	public int hashCode() {
		return _enrollmentSeat.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.EnrollmentSeat> toCacheModel() {
		return _enrollmentSeat.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.EnrollmentSeat toEscapedModel() {
		return new EnrollmentSeatWrapper(_enrollmentSeat.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.EnrollmentSeat toUnescapedModel() {
		return new EnrollmentSeatWrapper(_enrollmentSeat.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _enrollmentSeat.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _enrollmentSeat.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_enrollmentSeat.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EnrollmentSeatWrapper)) {
			return false;
		}

		EnrollmentSeatWrapper enrollmentSeatWrapper = (EnrollmentSeatWrapper)obj;

		if (Validator.equals(_enrollmentSeat,
					enrollmentSeatWrapper._enrollmentSeat)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EnrollmentSeat getWrappedEnrollmentSeat() {
		return _enrollmentSeat;
	}

	@Override
	public EnrollmentSeat getWrappedModel() {
		return _enrollmentSeat;
	}

	@Override
	public void resetOriginalValues() {
		_enrollmentSeat.resetOriginalValues();
	}

	private EnrollmentSeat _enrollmentSeat;
}