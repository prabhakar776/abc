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

import com.instructure.canvas.service.CertLetterQueueLocalServiceUtil;
import com.instructure.canvas.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class CertLetterQueueClp extends BaseModelImpl<CertLetterQueue>
	implements CertLetterQueue {
	public CertLetterQueueClp() {
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
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_certLetterQueueRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCourseId() {
		return _courseId;
	}

	@Override
	public void setCourseId(long courseId) {
		_courseId = courseId;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseId", long.class);

				method.invoke(_certLetterQueueRemoteModel, courseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_certLetterQueueRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_certLetterQueueRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_certLetterQueueRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getErrorDescription() {
		return _errorDescription;
	}

	@Override
	public void setErrorDescription(String errorDescription) {
		_errorDescription = errorDescription;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorDescription",
						String.class);

				method.invoke(_certLetterQueueRemoteModel, errorDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getErrorCount() {
		return _errorCount;
	}

	@Override
	public void setErrorCount(int errorCount) {
		_errorCount = errorCount;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorCount", int.class);

				method.invoke(_certLetterQueueRemoteModel, errorCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_certLetterQueueRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", Date.class);

				method.invoke(_certLetterQueueRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", Date.class);

				method.invoke(_certLetterQueueRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZipFileLocation() {
		return _zipFileLocation;
	}

	@Override
	public void setZipFileLocation(String zipFileLocation) {
		_zipFileLocation = zipFileLocation;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setZipFileLocation",
						String.class);

				method.invoke(_certLetterQueueRemoteModel, zipFileLocation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpiryDate() {
		return _expiryDate;
	}

	@Override
	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiryDate", Date.class);

				method.invoke(_certLetterQueueRemoteModel, expiryDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_certLetterQueueRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDownloadDate() {
		return _downloadDate;
	}

	@Override
	public void setDownloadDate(Date downloadDate) {
		_downloadDate = downloadDate;

		if (_certLetterQueueRemoteModel != null) {
			try {
				Class<?> clazz = _certLetterQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setDownloadDate", Date.class);

				method.invoke(_certLetterQueueRemoteModel, downloadDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCertLetterQueueRemoteModel() {
		return _certLetterQueueRemoteModel;
	}

	public void setCertLetterQueueRemoteModel(
		BaseModel<?> certLetterQueueRemoteModel) {
		_certLetterQueueRemoteModel = certLetterQueueRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _certLetterQueueRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_certLetterQueueRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CertLetterQueueLocalServiceUtil.addCertLetterQueue(this);
		}
		else {
			CertLetterQueueLocalServiceUtil.updateCertLetterQueue(this);
		}
	}

	@Override
	public CertLetterQueue toEscapedModel() {
		return (CertLetterQueue)ProxyUtil.newProxyInstance(CertLetterQueue.class.getClassLoader(),
			new Class[] { CertLetterQueue.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CertLetterQueueClp clone = new CertLetterQueueClp();

		clone.setId(getId());
		clone.setCourseId(getCourseId());
		clone.setCreateDate(getCreateDate());
		clone.setCreatedBy(getCreatedBy());
		clone.setStatus(getStatus());
		clone.setErrorDescription(getErrorDescription());
		clone.setErrorCount(getErrorCount());
		clone.setModifiedDate(getModifiedDate());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setZipFileLocation(getZipFileLocation());
		clone.setExpiryDate(getExpiryDate());
		clone.setType(getType());
		clone.setDownloadDate(getDownloadDate());

		return clone;
	}

	@Override
	public int compareTo(CertLetterQueue certLetterQueue) {
		long primaryKey = certLetterQueue.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CertLetterQueueClp)) {
			return false;
		}

		CertLetterQueueClp certLetterQueue = (CertLetterQueueClp)obj;

		long primaryKey = certLetterQueue.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", errorDescription=");
		sb.append(getErrorDescription());
		sb.append(", errorCount=");
		sb.append(getErrorCount());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", zipFileLocation=");
		sb.append(getZipFileLocation());
		sb.append(", expiryDate=");
		sb.append(getExpiryDate());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", downloadDate=");
		sb.append(getDownloadDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.CertLetterQueue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorDescription</column-name><column-value><![CDATA[");
		sb.append(getErrorDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorCount</column-name><column-value><![CDATA[");
		sb.append(getErrorCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipFileLocation</column-name><column-value><![CDATA[");
		sb.append(getZipFileLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiryDate</column-name><column-value><![CDATA[");
		sb.append(getExpiryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>downloadDate</column-name><column-value><![CDATA[");
		sb.append(getDownloadDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _certLetterQueueRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}