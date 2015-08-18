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
 * This class is a wrapper for {@link UserAward}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAward
 * @generated
 */
public class UserAwardWrapper implements UserAward, ModelWrapper<UserAward> {
	public UserAwardWrapper(UserAward userAward) {
		_userAward = userAward;
	}

	@Override
	public Class<?> getModelClass() {
		return UserAward.class;
	}

	@Override
	public String getModelClassName() {
		return UserAward.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("canvasUserId", getCanvasUserId());
		attributes.put("courseId", getCourseId());
		attributes.put("externalId", getExternalId());
		attributes.put("certId", getCertId());
		attributes.put("letter", getLetter());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long canvasUserId = (Long)attributes.get("canvasUserId");

		if (canvasUserId != null) {
			setCanvasUserId(canvasUserId);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long externalId = (Long)attributes.get("externalId");

		if (externalId != null) {
			setExternalId(externalId);
		}

		String certId = (String)attributes.get("certId");

		if (certId != null) {
			setCertId(certId);
		}

		Boolean letter = (Boolean)attributes.get("letter");

		if (letter != null) {
			setLetter(letter);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this user award.
	*
	* @return the primary key of this user award
	*/
	@Override
	public long getPrimaryKey() {
		return _userAward.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user award.
	*
	* @param primaryKey the primary key of this user award
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userAward.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this user award.
	*
	* @return the ID of this user award
	*/
	@Override
	public long getId() {
		return _userAward.getId();
	}

	/**
	* Sets the ID of this user award.
	*
	* @param id the ID of this user award
	*/
	@Override
	public void setId(long id) {
		_userAward.setId(id);
	}

	/**
	* Returns the canvas user ID of this user award.
	*
	* @return the canvas user ID of this user award
	*/
	@Override
	public long getCanvasUserId() {
		return _userAward.getCanvasUserId();
	}

	/**
	* Sets the canvas user ID of this user award.
	*
	* @param canvasUserId the canvas user ID of this user award
	*/
	@Override
	public void setCanvasUserId(long canvasUserId) {
		_userAward.setCanvasUserId(canvasUserId);
	}

	/**
	* Returns the canvas user uuid of this user award.
	*
	* @return the canvas user uuid of this user award
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCanvasUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAward.getCanvasUserUuid();
	}

	/**
	* Sets the canvas user uuid of this user award.
	*
	* @param canvasUserUuid the canvas user uuid of this user award
	*/
	@Override
	public void setCanvasUserUuid(java.lang.String canvasUserUuid) {
		_userAward.setCanvasUserUuid(canvasUserUuid);
	}

	/**
	* Returns the course ID of this user award.
	*
	* @return the course ID of this user award
	*/
	@Override
	public long getCourseId() {
		return _userAward.getCourseId();
	}

	/**
	* Sets the course ID of this user award.
	*
	* @param courseId the course ID of this user award
	*/
	@Override
	public void setCourseId(long courseId) {
		_userAward.setCourseId(courseId);
	}

	/**
	* Returns the external ID of this user award.
	*
	* @return the external ID of this user award
	*/
	@Override
	public long getExternalId() {
		return _userAward.getExternalId();
	}

	/**
	* Sets the external ID of this user award.
	*
	* @param externalId the external ID of this user award
	*/
	@Override
	public void setExternalId(long externalId) {
		_userAward.setExternalId(externalId);
	}

	/**
	* Returns the cert ID of this user award.
	*
	* @return the cert ID of this user award
	*/
	@Override
	public java.lang.String getCertId() {
		return _userAward.getCertId();
	}

	/**
	* Sets the cert ID of this user award.
	*
	* @param certId the cert ID of this user award
	*/
	@Override
	public void setCertId(java.lang.String certId) {
		_userAward.setCertId(certId);
	}

	/**
	* Returns the letter of this user award.
	*
	* @return the letter of this user award
	*/
	@Override
	public boolean getLetter() {
		return _userAward.getLetter();
	}

	/**
	* Returns <code>true</code> if this user award is letter.
	*
	* @return <code>true</code> if this user award is letter; <code>false</code> otherwise
	*/
	@Override
	public boolean isLetter() {
		return _userAward.isLetter();
	}

	/**
	* Sets whether this user award is letter.
	*
	* @param letter the letter of this user award
	*/
	@Override
	public void setLetter(boolean letter) {
		_userAward.setLetter(letter);
	}

	/**
	* Returns the create date of this user award.
	*
	* @return the create date of this user award
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _userAward.getCreateDate();
	}

	/**
	* Sets the create date of this user award.
	*
	* @param createDate the create date of this user award
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_userAward.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _userAward.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userAward.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userAward.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userAward.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userAward.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userAward.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userAward.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userAward.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userAward.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userAward.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userAward.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserAwardWrapper((UserAward)_userAward.clone());
	}

	@Override
	public int compareTo(com.instructure.canvas.model.UserAward userAward) {
		return _userAward.compareTo(userAward);
	}

	@Override
	public int hashCode() {
		return _userAward.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.UserAward> toCacheModel() {
		return _userAward.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.UserAward toEscapedModel() {
		return new UserAwardWrapper(_userAward.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.UserAward toUnescapedModel() {
		return new UserAwardWrapper(_userAward.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userAward.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userAward.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userAward.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserAwardWrapper)) {
			return false;
		}

		UserAwardWrapper userAwardWrapper = (UserAwardWrapper)obj;

		if (Validator.equals(_userAward, userAwardWrapper._userAward)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserAward getWrappedUserAward() {
		return _userAward;
	}

	@Override
	public UserAward getWrappedModel() {
		return _userAward;
	}

	@Override
	public void resetOriginalValues() {
		_userAward.resetOriginalValues();
	}

	private UserAward _userAward;
}