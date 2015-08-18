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
 * This class is a wrapper for {@link CertLetterQueue}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CertLetterQueue
 * @generated
 */
public class CertLetterQueueWrapper implements CertLetterQueue,
	ModelWrapper<CertLetterQueue> {
	public CertLetterQueueWrapper(CertLetterQueue certLetterQueue) {
		_certLetterQueue = certLetterQueue;
	}

	@Override
	public Class<?> getModelClass() {
		return CertLetterQueue.class;
	}

	@Override
	public String getModelClassName() {
		return CertLetterQueue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("courseId", getCourseId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("status", getStatus());
		attributes.put("errorDescription", getErrorDescription());
		attributes.put("errorCount", getErrorCount());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("zipFileLocation", getZipFileLocation());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("type", getType());
		attributes.put("downloadDate", getDownloadDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String errorDescription = (String)attributes.get("errorDescription");

		if (errorDescription != null) {
			setErrorDescription(errorDescription);
		}

		Integer errorCount = (Integer)attributes.get("errorCount");

		if (errorCount != null) {
			setErrorCount(errorCount);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		String zipFileLocation = (String)attributes.get("zipFileLocation");

		if (zipFileLocation != null) {
			setZipFileLocation(zipFileLocation);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Date downloadDate = (Date)attributes.get("downloadDate");

		if (downloadDate != null) {
			setDownloadDate(downloadDate);
		}
	}

	/**
	* Returns the primary key of this cert letter queue.
	*
	* @return the primary key of this cert letter queue
	*/
	@Override
	public long getPrimaryKey() {
		return _certLetterQueue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cert letter queue.
	*
	* @param primaryKey the primary key of this cert letter queue
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_certLetterQueue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this cert letter queue.
	*
	* @return the ID of this cert letter queue
	*/
	@Override
	public long getId() {
		return _certLetterQueue.getId();
	}

	/**
	* Sets the ID of this cert letter queue.
	*
	* @param id the ID of this cert letter queue
	*/
	@Override
	public void setId(long id) {
		_certLetterQueue.setId(id);
	}

	/**
	* Returns the course ID of this cert letter queue.
	*
	* @return the course ID of this cert letter queue
	*/
	@Override
	public long getCourseId() {
		return _certLetterQueue.getCourseId();
	}

	/**
	* Sets the course ID of this cert letter queue.
	*
	* @param courseId the course ID of this cert letter queue
	*/
	@Override
	public void setCourseId(long courseId) {
		_certLetterQueue.setCourseId(courseId);
	}

	/**
	* Returns the create date of this cert letter queue.
	*
	* @return the create date of this cert letter queue
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _certLetterQueue.getCreateDate();
	}

	/**
	* Sets the create date of this cert letter queue.
	*
	* @param createDate the create date of this cert letter queue
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_certLetterQueue.setCreateDate(createDate);
	}

	/**
	* Returns the created by of this cert letter queue.
	*
	* @return the created by of this cert letter queue
	*/
	@Override
	public long getCreatedBy() {
		return _certLetterQueue.getCreatedBy();
	}

	/**
	* Sets the created by of this cert letter queue.
	*
	* @param createdBy the created by of this cert letter queue
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_certLetterQueue.setCreatedBy(createdBy);
	}

	/**
	* Returns the status of this cert letter queue.
	*
	* @return the status of this cert letter queue
	*/
	@Override
	public java.lang.String getStatus() {
		return _certLetterQueue.getStatus();
	}

	/**
	* Sets the status of this cert letter queue.
	*
	* @param status the status of this cert letter queue
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_certLetterQueue.setStatus(status);
	}

	/**
	* Returns the error description of this cert letter queue.
	*
	* @return the error description of this cert letter queue
	*/
	@Override
	public java.lang.String getErrorDescription() {
		return _certLetterQueue.getErrorDescription();
	}

	/**
	* Sets the error description of this cert letter queue.
	*
	* @param errorDescription the error description of this cert letter queue
	*/
	@Override
	public void setErrorDescription(java.lang.String errorDescription) {
		_certLetterQueue.setErrorDescription(errorDescription);
	}

	/**
	* Returns the error count of this cert letter queue.
	*
	* @return the error count of this cert letter queue
	*/
	@Override
	public int getErrorCount() {
		return _certLetterQueue.getErrorCount();
	}

	/**
	* Sets the error count of this cert letter queue.
	*
	* @param errorCount the error count of this cert letter queue
	*/
	@Override
	public void setErrorCount(int errorCount) {
		_certLetterQueue.setErrorCount(errorCount);
	}

	/**
	* Returns the modified date of this cert letter queue.
	*
	* @return the modified date of this cert letter queue
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _certLetterQueue.getModifiedDate();
	}

	/**
	* Sets the modified date of this cert letter queue.
	*
	* @param modifiedDate the modified date of this cert letter queue
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_certLetterQueue.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the start time of this cert letter queue.
	*
	* @return the start time of this cert letter queue
	*/
	@Override
	public java.util.Date getStartTime() {
		return _certLetterQueue.getStartTime();
	}

	/**
	* Sets the start time of this cert letter queue.
	*
	* @param startTime the start time of this cert letter queue
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_certLetterQueue.setStartTime(startTime);
	}

	/**
	* Returns the end time of this cert letter queue.
	*
	* @return the end time of this cert letter queue
	*/
	@Override
	public java.util.Date getEndTime() {
		return _certLetterQueue.getEndTime();
	}

	/**
	* Sets the end time of this cert letter queue.
	*
	* @param endTime the end time of this cert letter queue
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_certLetterQueue.setEndTime(endTime);
	}

	/**
	* Returns the zip file location of this cert letter queue.
	*
	* @return the zip file location of this cert letter queue
	*/
	@Override
	public java.lang.String getZipFileLocation() {
		return _certLetterQueue.getZipFileLocation();
	}

	/**
	* Sets the zip file location of this cert letter queue.
	*
	* @param zipFileLocation the zip file location of this cert letter queue
	*/
	@Override
	public void setZipFileLocation(java.lang.String zipFileLocation) {
		_certLetterQueue.setZipFileLocation(zipFileLocation);
	}

	/**
	* Returns the expiry date of this cert letter queue.
	*
	* @return the expiry date of this cert letter queue
	*/
	@Override
	public java.util.Date getExpiryDate() {
		return _certLetterQueue.getExpiryDate();
	}

	/**
	* Sets the expiry date of this cert letter queue.
	*
	* @param expiryDate the expiry date of this cert letter queue
	*/
	@Override
	public void setExpiryDate(java.util.Date expiryDate) {
		_certLetterQueue.setExpiryDate(expiryDate);
	}

	/**
	* Returns the type of this cert letter queue.
	*
	* @return the type of this cert letter queue
	*/
	@Override
	public java.lang.String getType() {
		return _certLetterQueue.getType();
	}

	/**
	* Sets the type of this cert letter queue.
	*
	* @param type the type of this cert letter queue
	*/
	@Override
	public void setType(java.lang.String type) {
		_certLetterQueue.setType(type);
	}

	/**
	* Returns the download date of this cert letter queue.
	*
	* @return the download date of this cert letter queue
	*/
	@Override
	public java.util.Date getDownloadDate() {
		return _certLetterQueue.getDownloadDate();
	}

	/**
	* Sets the download date of this cert letter queue.
	*
	* @param downloadDate the download date of this cert letter queue
	*/
	@Override
	public void setDownloadDate(java.util.Date downloadDate) {
		_certLetterQueue.setDownloadDate(downloadDate);
	}

	@Override
	public boolean isNew() {
		return _certLetterQueue.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_certLetterQueue.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _certLetterQueue.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_certLetterQueue.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _certLetterQueue.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _certLetterQueue.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_certLetterQueue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _certLetterQueue.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_certLetterQueue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_certLetterQueue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_certLetterQueue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CertLetterQueueWrapper((CertLetterQueue)_certLetterQueue.clone());
	}

	@Override
	public int compareTo(
		com.instructure.canvas.model.CertLetterQueue certLetterQueue) {
		return _certLetterQueue.compareTo(certLetterQueue);
	}

	@Override
	public int hashCode() {
		return _certLetterQueue.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.CertLetterQueue> toCacheModel() {
		return _certLetterQueue.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.CertLetterQueue toEscapedModel() {
		return new CertLetterQueueWrapper(_certLetterQueue.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.CertLetterQueue toUnescapedModel() {
		return new CertLetterQueueWrapper(_certLetterQueue.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _certLetterQueue.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _certLetterQueue.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_certLetterQueue.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CertLetterQueueWrapper)) {
			return false;
		}

		CertLetterQueueWrapper certLetterQueueWrapper = (CertLetterQueueWrapper)obj;

		if (Validator.equals(_certLetterQueue,
					certLetterQueueWrapper._certLetterQueue)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CertLetterQueue getWrappedCertLetterQueue() {
		return _certLetterQueue;
	}

	@Override
	public CertLetterQueue getWrappedModel() {
		return _certLetterQueue;
	}

	@Override
	public void resetOriginalValues() {
		_certLetterQueue.resetOriginalValues();
	}

	private CertLetterQueue _certLetterQueue;
}