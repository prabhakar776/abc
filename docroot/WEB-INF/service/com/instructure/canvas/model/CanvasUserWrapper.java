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
 * This class is a wrapper for {@link CanvasUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasUser
 * @generated
 */
public class CanvasUserWrapper implements CanvasUser, ModelWrapper<CanvasUser> {
	public CanvasUserWrapper(CanvasUser canvasUser) {
		_canvasUser = canvasUser;
	}

	@Override
	public Class<?> getModelClass() {
		return CanvasUser.class;
	}

	@Override
	public String getModelClassName() {
		return CanvasUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("SID", getSID());
		attributes.put("loginId", getLoginId());
		attributes.put("password", getPassword());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("status", getStatus());
		attributes.put("fullName", getFullName());
		attributes.put("canvasUserId", getCanvasUserId());
		attributes.put("currentScore", getCurrentScore());
		attributes.put("finalScore", getFinalScore());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String SID = (String)attributes.get("SID");

		if (SID != null) {
			setSID(SID);
		}

		String loginId = (String)attributes.get("loginId");

		if (loginId != null) {
			setLoginId(loginId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String canvasUserId = (String)attributes.get("canvasUserId");

		if (canvasUserId != null) {
			setCanvasUserId(canvasUserId);
		}

		Double currentScore = (Double)attributes.get("currentScore");

		if (currentScore != null) {
			setCurrentScore(currentScore);
		}

		Double finalScore = (Double)attributes.get("finalScore");

		if (finalScore != null) {
			setFinalScore(finalScore);
		}
	}

	/**
	* Returns the primary key of this canvas user.
	*
	* @return the primary key of this canvas user
	*/
	@Override
	public long getPrimaryKey() {
		return _canvasUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this canvas user.
	*
	* @param primaryKey the primary key of this canvas user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_canvasUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this canvas user.
	*
	* @return the user ID of this canvas user
	*/
	@Override
	public long getUserId() {
		return _canvasUser.getUserId();
	}

	/**
	* Sets the user ID of this canvas user.
	*
	* @param userId the user ID of this canvas user
	*/
	@Override
	public void setUserId(long userId) {
		_canvasUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this canvas user.
	*
	* @return the user uuid of this canvas user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this canvas user.
	*
	* @param userUuid the user uuid of this canvas user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_canvasUser.setUserUuid(userUuid);
	}

	/**
	* Returns the s i d of this canvas user.
	*
	* @return the s i d of this canvas user
	*/
	@Override
	public java.lang.String getSID() {
		return _canvasUser.getSID();
	}

	/**
	* Sets the s i d of this canvas user.
	*
	* @param SID the s i d of this canvas user
	*/
	@Override
	public void setSID(java.lang.String SID) {
		_canvasUser.setSID(SID);
	}

	/**
	* Returns the login ID of this canvas user.
	*
	* @return the login ID of this canvas user
	*/
	@Override
	public java.lang.String getLoginId() {
		return _canvasUser.getLoginId();
	}

	/**
	* Sets the login ID of this canvas user.
	*
	* @param loginId the login ID of this canvas user
	*/
	@Override
	public void setLoginId(java.lang.String loginId) {
		_canvasUser.setLoginId(loginId);
	}

	/**
	* Returns the password of this canvas user.
	*
	* @return the password of this canvas user
	*/
	@Override
	public java.lang.String getPassword() {
		return _canvasUser.getPassword();
	}

	/**
	* Sets the password of this canvas user.
	*
	* @param password the password of this canvas user
	*/
	@Override
	public void setPassword(java.lang.String password) {
		_canvasUser.setPassword(password);
	}

	/**
	* Returns the first name of this canvas user.
	*
	* @return the first name of this canvas user
	*/
	@Override
	public java.lang.String getFirstName() {
		return _canvasUser.getFirstName();
	}

	/**
	* Sets the first name of this canvas user.
	*
	* @param firstName the first name of this canvas user
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_canvasUser.setFirstName(firstName);
	}

	/**
	* Returns the last name of this canvas user.
	*
	* @return the last name of this canvas user
	*/
	@Override
	public java.lang.String getLastName() {
		return _canvasUser.getLastName();
	}

	/**
	* Sets the last name of this canvas user.
	*
	* @param lastName the last name of this canvas user
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_canvasUser.setLastName(lastName);
	}

	/**
	* Returns the email of this canvas user.
	*
	* @return the email of this canvas user
	*/
	@Override
	public java.lang.String getEmail() {
		return _canvasUser.getEmail();
	}

	/**
	* Sets the email of this canvas user.
	*
	* @param email the email of this canvas user
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_canvasUser.setEmail(email);
	}

	/**
	* Returns the status of this canvas user.
	*
	* @return the status of this canvas user
	*/
	@Override
	public java.lang.String getStatus() {
		return _canvasUser.getStatus();
	}

	/**
	* Sets the status of this canvas user.
	*
	* @param status the status of this canvas user
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_canvasUser.setStatus(status);
	}

	/**
	* Returns the full name of this canvas user.
	*
	* @return the full name of this canvas user
	*/
	@Override
	public java.lang.String getFullName() {
		return _canvasUser.getFullName();
	}

	/**
	* Sets the full name of this canvas user.
	*
	* @param fullName the full name of this canvas user
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_canvasUser.setFullName(fullName);
	}

	/**
	* Returns the canvas user ID of this canvas user.
	*
	* @return the canvas user ID of this canvas user
	*/
	@Override
	public java.lang.String getCanvasUserId() {
		return _canvasUser.getCanvasUserId();
	}

	/**
	* Sets the canvas user ID of this canvas user.
	*
	* @param canvasUserId the canvas user ID of this canvas user
	*/
	@Override
	public void setCanvasUserId(java.lang.String canvasUserId) {
		_canvasUser.setCanvasUserId(canvasUserId);
	}

	/**
	* Returns the current score of this canvas user.
	*
	* @return the current score of this canvas user
	*/
	@Override
	public double getCurrentScore() {
		return _canvasUser.getCurrentScore();
	}

	/**
	* Sets the current score of this canvas user.
	*
	* @param currentScore the current score of this canvas user
	*/
	@Override
	public void setCurrentScore(double currentScore) {
		_canvasUser.setCurrentScore(currentScore);
	}

	/**
	* Returns the final score of this canvas user.
	*
	* @return the final score of this canvas user
	*/
	@Override
	public double getFinalScore() {
		return _canvasUser.getFinalScore();
	}

	/**
	* Sets the final score of this canvas user.
	*
	* @param finalScore the final score of this canvas user
	*/
	@Override
	public void setFinalScore(double finalScore) {
		_canvasUser.setFinalScore(finalScore);
	}

	@Override
	public boolean isNew() {
		return _canvasUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_canvasUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _canvasUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_canvasUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _canvasUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _canvasUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_canvasUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _canvasUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_canvasUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_canvasUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_canvasUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CanvasUserWrapper((CanvasUser)_canvasUser.clone());
	}

	@Override
	public int compareTo(com.instructure.canvas.model.CanvasUser canvasUser) {
		return _canvasUser.compareTo(canvasUser);
	}

	@Override
	public int hashCode() {
		return _canvasUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.CanvasUser> toCacheModel() {
		return _canvasUser.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.CanvasUser toEscapedModel() {
		return new CanvasUserWrapper(_canvasUser.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.CanvasUser toUnescapedModel() {
		return new CanvasUserWrapper(_canvasUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _canvasUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _canvasUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_canvasUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CanvasUserWrapper)) {
			return false;
		}

		CanvasUserWrapper canvasUserWrapper = (CanvasUserWrapper)obj;

		if (Validator.equals(_canvasUser, canvasUserWrapper._canvasUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CanvasUser getWrappedCanvasUser() {
		return _canvasUser;
	}

	@Override
	public CanvasUser getWrappedModel() {
		return _canvasUser;
	}

	@Override
	public void resetOriginalValues() {
		_canvasUser.resetOriginalValues();
	}

	private CanvasUser _canvasUser;
}