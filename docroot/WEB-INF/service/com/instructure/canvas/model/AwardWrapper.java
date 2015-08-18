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
 * This class is a wrapper for {@link Award}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Award
 * @generated
 */
public class AwardWrapper implements Award, ModelWrapper<Award> {
	public AwardWrapper(Award award) {
		_award = award;
	}

	@Override
	public Class<?> getModelClass() {
		return Award.class;
	}

	@Override
	public String getModelClassName() {
		return Award.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("awardId", getAwardId());
		attributes.put("cvlId", getCvlId());
		attributes.put("cvlName", getCvlName());
		attributes.put("score", getScore());
		attributes.put("letterArticleId", getLetterArticleId());
		attributes.put("certificateArticleId", getCertificateArticleId());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long awardId = (Long)attributes.get("awardId");

		if (awardId != null) {
			setAwardId(awardId);
		}

		String cvlId = (String)attributes.get("cvlId");

		if (cvlId != null) {
			setCvlId(cvlId);
		}

		String cvlName = (String)attributes.get("cvlName");

		if (cvlName != null) {
			setCvlName(cvlName);
		}

		Double score = (Double)attributes.get("score");

		if (score != null) {
			setScore(score);
		}

		Long letterArticleId = (Long)attributes.get("letterArticleId");

		if (letterArticleId != null) {
			setLetterArticleId(letterArticleId);
		}

		Long certificateArticleId = (Long)attributes.get("certificateArticleId");

		if (certificateArticleId != null) {
			setCertificateArticleId(certificateArticleId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this award.
	*
	* @return the primary key of this award
	*/
	@Override
	public long getPrimaryKey() {
		return _award.getPrimaryKey();
	}

	/**
	* Sets the primary key of this award.
	*
	* @param primaryKey the primary key of this award
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_award.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the award ID of this award.
	*
	* @return the award ID of this award
	*/
	@Override
	public long getAwardId() {
		return _award.getAwardId();
	}

	/**
	* Sets the award ID of this award.
	*
	* @param awardId the award ID of this award
	*/
	@Override
	public void setAwardId(long awardId) {
		_award.setAwardId(awardId);
	}

	/**
	* Returns the cvl ID of this award.
	*
	* @return the cvl ID of this award
	*/
	@Override
	public java.lang.String getCvlId() {
		return _award.getCvlId();
	}

	/**
	* Sets the cvl ID of this award.
	*
	* @param cvlId the cvl ID of this award
	*/
	@Override
	public void setCvlId(java.lang.String cvlId) {
		_award.setCvlId(cvlId);
	}

	/**
	* Returns the cvl name of this award.
	*
	* @return the cvl name of this award
	*/
	@Override
	public java.lang.String getCvlName() {
		return _award.getCvlName();
	}

	/**
	* Sets the cvl name of this award.
	*
	* @param cvlName the cvl name of this award
	*/
	@Override
	public void setCvlName(java.lang.String cvlName) {
		_award.setCvlName(cvlName);
	}

	/**
	* Returns the score of this award.
	*
	* @return the score of this award
	*/
	@Override
	public double getScore() {
		return _award.getScore();
	}

	/**
	* Sets the score of this award.
	*
	* @param score the score of this award
	*/
	@Override
	public void setScore(double score) {
		_award.setScore(score);
	}

	/**
	* Returns the letter article ID of this award.
	*
	* @return the letter article ID of this award
	*/
	@Override
	public long getLetterArticleId() {
		return _award.getLetterArticleId();
	}

	/**
	* Sets the letter article ID of this award.
	*
	* @param letterArticleId the letter article ID of this award
	*/
	@Override
	public void setLetterArticleId(long letterArticleId) {
		_award.setLetterArticleId(letterArticleId);
	}

	/**
	* Returns the certificate article ID of this award.
	*
	* @return the certificate article ID of this award
	*/
	@Override
	public long getCertificateArticleId() {
		return _award.getCertificateArticleId();
	}

	/**
	* Sets the certificate article ID of this award.
	*
	* @param certificateArticleId the certificate article ID of this award
	*/
	@Override
	public void setCertificateArticleId(long certificateArticleId) {
		_award.setCertificateArticleId(certificateArticleId);
	}

	/**
	* Returns the active of this award.
	*
	* @return the active of this award
	*/
	@Override
	public boolean getActive() {
		return _award.getActive();
	}

	/**
	* Returns <code>true</code> if this award is active.
	*
	* @return <code>true</code> if this award is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _award.isActive();
	}

	/**
	* Sets whether this award is active.
	*
	* @param active the active of this award
	*/
	@Override
	public void setActive(boolean active) {
		_award.setActive(active);
	}

	/**
	* Returns the create date of this award.
	*
	* @return the create date of this award
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _award.getCreateDate();
	}

	/**
	* Sets the create date of this award.
	*
	* @param createDate the create date of this award
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_award.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this award.
	*
	* @return the modified date of this award
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _award.getModifiedDate();
	}

	/**
	* Sets the modified date of this award.
	*
	* @param modifiedDate the modified date of this award
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_award.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _award.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_award.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _award.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_award.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _award.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _award.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_award.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _award.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_award.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_award.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_award.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AwardWrapper((Award)_award.clone());
	}

	@Override
	public int compareTo(com.instructure.canvas.model.Award award) {
		return _award.compareTo(award);
	}

	@Override
	public int hashCode() {
		return _award.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.Award> toCacheModel() {
		return _award.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.Award toEscapedModel() {
		return new AwardWrapper(_award.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.Award toUnescapedModel() {
		return new AwardWrapper(_award.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _award.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _award.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_award.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AwardWrapper)) {
			return false;
		}

		AwardWrapper awardWrapper = (AwardWrapper)obj;

		if (Validator.equals(_award, awardWrapper._award)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Award getWrappedAward() {
		return _award;
	}

	@Override
	public Award getWrappedModel() {
		return _award;
	}

	@Override
	public void resetOriginalValues() {
		_award.resetOriginalValues();
	}

	private Award _award;
}