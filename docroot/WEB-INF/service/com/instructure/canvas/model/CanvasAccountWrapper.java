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
 * This class is a wrapper for {@link CanvasAccount}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasAccount
 * @generated
 */
public class CanvasAccountWrapper implements CanvasAccount,
	ModelWrapper<CanvasAccount> {
	public CanvasAccountWrapper(CanvasAccount canvasAccount) {
		_canvasAccount = canvasAccount;
	}

	@Override
	public Class<?> getModelClass() {
		return CanvasAccount.class;
	}

	@Override
	public String getModelClassName() {
		return CanvasAccount.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("accountId", getAccountId());
		attributes.put("id", getId());
		attributes.put("parentAccountId", getParentAccountId());
		attributes.put("name", getName());
		attributes.put("rootAccountId", getRootAccountId());
		attributes.put("SISAccountId", getSISAccountId());
		attributes.put("status", getStatus());
		attributes.put("timeZone", getTimeZone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String parentAccountId = (String)attributes.get("parentAccountId");

		if (parentAccountId != null) {
			setParentAccountId(parentAccountId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String rootAccountId = (String)attributes.get("rootAccountId");

		if (rootAccountId != null) {
			setRootAccountId(rootAccountId);
		}

		String SISAccountId = (String)attributes.get("SISAccountId");

		if (SISAccountId != null) {
			setSISAccountId(SISAccountId);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String timeZone = (String)attributes.get("timeZone");

		if (timeZone != null) {
			setTimeZone(timeZone);
		}
	}

	/**
	* Returns the primary key of this canvas account.
	*
	* @return the primary key of this canvas account
	*/
	@Override
	public long getPrimaryKey() {
		return _canvasAccount.getPrimaryKey();
	}

	/**
	* Sets the primary key of this canvas account.
	*
	* @param primaryKey the primary key of this canvas account
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_canvasAccount.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the account ID of this canvas account.
	*
	* @return the account ID of this canvas account
	*/
	@Override
	public long getAccountId() {
		return _canvasAccount.getAccountId();
	}

	/**
	* Sets the account ID of this canvas account.
	*
	* @param accountId the account ID of this canvas account
	*/
	@Override
	public void setAccountId(long accountId) {
		_canvasAccount.setAccountId(accountId);
	}

	/**
	* Returns the ID of this canvas account.
	*
	* @return the ID of this canvas account
	*/
	@Override
	public java.lang.String getId() {
		return _canvasAccount.getId();
	}

	/**
	* Sets the ID of this canvas account.
	*
	* @param id the ID of this canvas account
	*/
	@Override
	public void setId(java.lang.String id) {
		_canvasAccount.setId(id);
	}

	/**
	* Returns the parent account ID of this canvas account.
	*
	* @return the parent account ID of this canvas account
	*/
	@Override
	public java.lang.String getParentAccountId() {
		return _canvasAccount.getParentAccountId();
	}

	/**
	* Sets the parent account ID of this canvas account.
	*
	* @param parentAccountId the parent account ID of this canvas account
	*/
	@Override
	public void setParentAccountId(java.lang.String parentAccountId) {
		_canvasAccount.setParentAccountId(parentAccountId);
	}

	/**
	* Returns the name of this canvas account.
	*
	* @return the name of this canvas account
	*/
	@Override
	public java.lang.String getName() {
		return _canvasAccount.getName();
	}

	/**
	* Sets the name of this canvas account.
	*
	* @param name the name of this canvas account
	*/
	@Override
	public void setName(java.lang.String name) {
		_canvasAccount.setName(name);
	}

	/**
	* Returns the root account ID of this canvas account.
	*
	* @return the root account ID of this canvas account
	*/
	@Override
	public java.lang.String getRootAccountId() {
		return _canvasAccount.getRootAccountId();
	}

	/**
	* Sets the root account ID of this canvas account.
	*
	* @param rootAccountId the root account ID of this canvas account
	*/
	@Override
	public void setRootAccountId(java.lang.String rootAccountId) {
		_canvasAccount.setRootAccountId(rootAccountId);
	}

	/**
	* Returns the s i s account ID of this canvas account.
	*
	* @return the s i s account ID of this canvas account
	*/
	@Override
	public java.lang.String getSISAccountId() {
		return _canvasAccount.getSISAccountId();
	}

	/**
	* Sets the s i s account ID of this canvas account.
	*
	* @param SISAccountId the s i s account ID of this canvas account
	*/
	@Override
	public void setSISAccountId(java.lang.String SISAccountId) {
		_canvasAccount.setSISAccountId(SISAccountId);
	}

	/**
	* Returns the status of this canvas account.
	*
	* @return the status of this canvas account
	*/
	@Override
	public long getStatus() {
		return _canvasAccount.getStatus();
	}

	/**
	* Sets the status of this canvas account.
	*
	* @param status the status of this canvas account
	*/
	@Override
	public void setStatus(long status) {
		_canvasAccount.setStatus(status);
	}

	/**
	* Returns the time zone of this canvas account.
	*
	* @return the time zone of this canvas account
	*/
	@Override
	public java.lang.String getTimeZone() {
		return _canvasAccount.getTimeZone();
	}

	/**
	* Sets the time zone of this canvas account.
	*
	* @param timeZone the time zone of this canvas account
	*/
	@Override
	public void setTimeZone(java.lang.String timeZone) {
		_canvasAccount.setTimeZone(timeZone);
	}

	@Override
	public boolean isNew() {
		return _canvasAccount.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_canvasAccount.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _canvasAccount.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_canvasAccount.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _canvasAccount.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _canvasAccount.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_canvasAccount.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _canvasAccount.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_canvasAccount.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_canvasAccount.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_canvasAccount.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CanvasAccountWrapper((CanvasAccount)_canvasAccount.clone());
	}

	@Override
	public int compareTo(
		com.instructure.canvas.model.CanvasAccount canvasAccount) {
		return _canvasAccount.compareTo(canvasAccount);
	}

	@Override
	public int hashCode() {
		return _canvasAccount.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.CanvasAccount> toCacheModel() {
		return _canvasAccount.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.CanvasAccount toEscapedModel() {
		return new CanvasAccountWrapper(_canvasAccount.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.CanvasAccount toUnescapedModel() {
		return new CanvasAccountWrapper(_canvasAccount.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _canvasAccount.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _canvasAccount.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_canvasAccount.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CanvasAccountWrapper)) {
			return false;
		}

		CanvasAccountWrapper canvasAccountWrapper = (CanvasAccountWrapper)obj;

		if (Validator.equals(_canvasAccount, canvasAccountWrapper._canvasAccount)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CanvasAccount getWrappedCanvasAccount() {
		return _canvasAccount;
	}

	@Override
	public CanvasAccount getWrappedModel() {
		return _canvasAccount;
	}

	@Override
	public void resetOriginalValues() {
		_canvasAccount.resetOriginalValues();
	}

	private CanvasAccount _canvasAccount;
}