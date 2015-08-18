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

package com.instructure.canvas.model.impl;

import com.instructure.canvas.model.CertLetterQueue;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CertLetterQueue in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CertLetterQueue
 * @generated
 */
public class CertLetterQueueCacheModel implements CacheModel<CertLetterQueue>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", status=");
		sb.append(status);
		sb.append(", errorDescription=");
		sb.append(errorDescription);
		sb.append(", errorCount=");
		sb.append(errorCount);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", zipFileLocation=");
		sb.append(zipFileLocation);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", type=");
		sb.append(type);
		sb.append(", downloadDate=");
		sb.append(downloadDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CertLetterQueue toEntityModel() {
		CertLetterQueueImpl certLetterQueueImpl = new CertLetterQueueImpl();

		certLetterQueueImpl.setId(id);
		certLetterQueueImpl.setCourseId(courseId);

		if (createDate == Long.MIN_VALUE) {
			certLetterQueueImpl.setCreateDate(null);
		}
		else {
			certLetterQueueImpl.setCreateDate(new Date(createDate));
		}

		certLetterQueueImpl.setCreatedBy(createdBy);

		if (status == null) {
			certLetterQueueImpl.setStatus(StringPool.BLANK);
		}
		else {
			certLetterQueueImpl.setStatus(status);
		}

		if (errorDescription == null) {
			certLetterQueueImpl.setErrorDescription(StringPool.BLANK);
		}
		else {
			certLetterQueueImpl.setErrorDescription(errorDescription);
		}

		certLetterQueueImpl.setErrorCount(errorCount);

		if (modifiedDate == Long.MIN_VALUE) {
			certLetterQueueImpl.setModifiedDate(null);
		}
		else {
			certLetterQueueImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (startTime == Long.MIN_VALUE) {
			certLetterQueueImpl.setStartTime(null);
		}
		else {
			certLetterQueueImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			certLetterQueueImpl.setEndTime(null);
		}
		else {
			certLetterQueueImpl.setEndTime(new Date(endTime));
		}

		if (zipFileLocation == null) {
			certLetterQueueImpl.setZipFileLocation(StringPool.BLANK);
		}
		else {
			certLetterQueueImpl.setZipFileLocation(zipFileLocation);
		}

		if (expiryDate == Long.MIN_VALUE) {
			certLetterQueueImpl.setExpiryDate(null);
		}
		else {
			certLetterQueueImpl.setExpiryDate(new Date(expiryDate));
		}

		if (type == null) {
			certLetterQueueImpl.setType(StringPool.BLANK);
		}
		else {
			certLetterQueueImpl.setType(type);
		}

		if (downloadDate == Long.MIN_VALUE) {
			certLetterQueueImpl.setDownloadDate(null);
		}
		else {
			certLetterQueueImpl.setDownloadDate(new Date(downloadDate));
		}

		certLetterQueueImpl.resetOriginalValues();

		return certLetterQueueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		courseId = objectInput.readLong();
		createDate = objectInput.readLong();
		createdBy = objectInput.readLong();
		status = objectInput.readUTF();
		errorDescription = objectInput.readUTF();
		errorCount = objectInput.readInt();
		modifiedDate = objectInput.readLong();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		zipFileLocation = objectInput.readUTF();
		expiryDate = objectInput.readLong();
		type = objectInput.readUTF();
		downloadDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(courseId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(createdBy);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (errorDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errorDescription);
		}

		objectOutput.writeInt(errorCount);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);

		if (zipFileLocation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zipFileLocation);
		}

		objectOutput.writeLong(expiryDate);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(downloadDate);
	}

	public long id;
	public long courseId;
	public long createDate;
	public long createdBy;
	public String status;
	public String errorDescription;
	public int errorCount;
	public long modifiedDate;
	public long startTime;
	public long endTime;
	public String zipFileLocation;
	public long expiryDate;
	public String type;
	public long downloadDate;
}