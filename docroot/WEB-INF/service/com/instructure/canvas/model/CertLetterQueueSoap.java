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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.CertLetterQueueServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.CertLetterQueueServiceSoap
 * @generated
 */
public class CertLetterQueueSoap implements Serializable {
	public static CertLetterQueueSoap toSoapModel(CertLetterQueue model) {
		CertLetterQueueSoap soapModel = new CertLetterQueueSoap();

		soapModel.setId(model.getId());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setStatus(model.getStatus());
		soapModel.setErrorDescription(model.getErrorDescription());
		soapModel.setErrorCount(model.getErrorCount());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setZipFileLocation(model.getZipFileLocation());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setType(model.getType());
		soapModel.setDownloadDate(model.getDownloadDate());

		return soapModel;
	}

	public static CertLetterQueueSoap[] toSoapModels(CertLetterQueue[] models) {
		CertLetterQueueSoap[] soapModels = new CertLetterQueueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CertLetterQueueSoap[][] toSoapModels(
		CertLetterQueue[][] models) {
		CertLetterQueueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CertLetterQueueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CertLetterQueueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CertLetterQueueSoap[] toSoapModels(
		List<CertLetterQueue> models) {
		List<CertLetterQueueSoap> soapModels = new ArrayList<CertLetterQueueSoap>(models.size());

		for (CertLetterQueue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CertLetterQueueSoap[soapModels.size()]);
	}

	public CertLetterQueueSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getErrorDescription() {
		return _errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		_errorDescription = errorDescription;
	}

	public int getErrorCount() {
		return _errorCount;
	}

	public void setErrorCount(int errorCount) {
		_errorCount = errorCount;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public String getZipFileLocation() {
		return _zipFileLocation;
	}

	public void setZipFileLocation(String zipFileLocation) {
		_zipFileLocation = zipFileLocation;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public Date getDownloadDate() {
		return _downloadDate;
	}

	public void setDownloadDate(Date downloadDate) {
		_downloadDate = downloadDate;
	}

	private long _id;
	private long _courseId;
	private Date _createDate;
	private long _createdBy;
	private String _status;
	private String _errorDescription;
	private int _errorCount;
	private Date _modifiedDate;
	private Date _startTime;
	private Date _endTime;
	private String _zipFileLocation;
	private Date _expiryDate;
	private String _type;
	private Date _downloadDate;
}