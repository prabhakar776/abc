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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the CanvasUser service. Represents a row in the &quot;CANVAS_CanvasUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.instructure.canvas.model.impl.CanvasUserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.instructure.canvas.model.impl.CanvasUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasUser
 * @see com.instructure.canvas.model.impl.CanvasUserImpl
 * @see com.instructure.canvas.model.impl.CanvasUserModelImpl
 * @generated
 */
public interface CanvasUserModel extends BaseModel<CanvasUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a canvas user model instance should use the {@link CanvasUser} interface instead.
	 */

	/**
	 * Returns the primary key of this canvas user.
	 *
	 * @return the primary key of this canvas user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this canvas user.
	 *
	 * @param primaryKey the primary key of this canvas user
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the user ID of this canvas user.
	 *
	 * @return the user ID of this canvas user
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this canvas user.
	 *
	 * @param userId the user ID of this canvas user
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this canvas user.
	 *
	 * @return the user uuid of this canvas user
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this canvas user.
	 *
	 * @param userUuid the user uuid of this canvas user
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the s i d of this canvas user.
	 *
	 * @return the s i d of this canvas user
	 */
	@AutoEscape
	public String getSID();

	/**
	 * Sets the s i d of this canvas user.
	 *
	 * @param SID the s i d of this canvas user
	 */
	public void setSID(String SID);

	/**
	 * Returns the login ID of this canvas user.
	 *
	 * @return the login ID of this canvas user
	 */
	@AutoEscape
	public String getLoginId();

	/**
	 * Sets the login ID of this canvas user.
	 *
	 * @param loginId the login ID of this canvas user
	 */
	public void setLoginId(String loginId);

	/**
	 * Returns the password of this canvas user.
	 *
	 * @return the password of this canvas user
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this canvas user.
	 *
	 * @param password the password of this canvas user
	 */
	public void setPassword(String password);

	/**
	 * Returns the first name of this canvas user.
	 *
	 * @return the first name of this canvas user
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this canvas user.
	 *
	 * @param firstName the first name of this canvas user
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this canvas user.
	 *
	 * @return the last name of this canvas user
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this canvas user.
	 *
	 * @param lastName the last name of this canvas user
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the email of this canvas user.
	 *
	 * @return the email of this canvas user
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this canvas user.
	 *
	 * @param email the email of this canvas user
	 */
	public void setEmail(String email);

	/**
	 * Returns the status of this canvas user.
	 *
	 * @return the status of this canvas user
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this canvas user.
	 *
	 * @param status the status of this canvas user
	 */
	public void setStatus(String status);

	/**
	 * Returns the full name of this canvas user.
	 *
	 * @return the full name of this canvas user
	 */
	@AutoEscape
	public String getFullName();

	/**
	 * Sets the full name of this canvas user.
	 *
	 * @param fullName the full name of this canvas user
	 */
	public void setFullName(String fullName);

	/**
	 * Returns the canvas user ID of this canvas user.
	 *
	 * @return the canvas user ID of this canvas user
	 */
	@AutoEscape
	public String getCanvasUserId();

	/**
	 * Sets the canvas user ID of this canvas user.
	 *
	 * @param canvasUserId the canvas user ID of this canvas user
	 */
	public void setCanvasUserId(String canvasUserId);

	/**
	 * Returns the current score of this canvas user.
	 *
	 * @return the current score of this canvas user
	 */
	public double getCurrentScore();

	/**
	 * Sets the current score of this canvas user.
	 *
	 * @param currentScore the current score of this canvas user
	 */
	public void setCurrentScore(double currentScore);

	/**
	 * Returns the final score of this canvas user.
	 *
	 * @return the final score of this canvas user
	 */
	public double getFinalScore();

	/**
	 * Sets the final score of this canvas user.
	 *
	 * @param finalScore the final score of this canvas user
	 */
	public void setFinalScore(double finalScore);

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
	public int compareTo(CanvasUser canvasUser);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CanvasUser> toCacheModel();

	@Override
	public CanvasUser toEscapedModel();

	@Override
	public CanvasUser toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}