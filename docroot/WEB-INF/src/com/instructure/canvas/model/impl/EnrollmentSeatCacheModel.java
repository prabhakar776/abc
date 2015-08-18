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

import com.instructure.canvas.model.EnrollmentSeat;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EnrollmentSeat in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EnrollmentSeat
 * @generated
 */
public class EnrollmentSeatCacheModel implements CacheModel<EnrollmentSeat>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", token=");
		sb.append(token);
		sb.append(", rootAccountId=");
		sb.append(rootAccountId);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", redeemDate=");
		sb.append(redeemDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EnrollmentSeat toEntityModel() {
		EnrollmentSeatImpl enrollmentSeatImpl = new EnrollmentSeatImpl();

		enrollmentSeatImpl.setId(id);

		if (token == null) {
			enrollmentSeatImpl.setToken(StringPool.BLANK);
		}
		else {
			enrollmentSeatImpl.setToken(token);
		}

		if (rootAccountId == null) {
			enrollmentSeatImpl.setRootAccountId(StringPool.BLANK);
		}
		else {
			enrollmentSeatImpl.setRootAccountId(rootAccountId);
		}

		if (courseId == null) {
			enrollmentSeatImpl.setCourseId(StringPool.BLANK);
		}
		else {
			enrollmentSeatImpl.setCourseId(courseId);
		}

		enrollmentSeatImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			enrollmentSeatImpl.setCreateDate(null);
		}
		else {
			enrollmentSeatImpl.setCreateDate(new Date(createDate));
		}

		if (redeemDate == Long.MIN_VALUE) {
			enrollmentSeatImpl.setRedeemDate(null);
		}
		else {
			enrollmentSeatImpl.setRedeemDate(new Date(redeemDate));
		}

		enrollmentSeatImpl.resetOriginalValues();

		return enrollmentSeatImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		token = objectInput.readUTF();
		rootAccountId = objectInput.readUTF();
		courseId = objectInput.readUTF();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		redeemDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (token == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(token);
		}

		if (rootAccountId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rootAccountId);
		}

		if (courseId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseId);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(redeemDate);
	}

	public long id;
	public String token;
	public String rootAccountId;
	public String courseId;
	public long userId;
	public long createDate;
	public long redeemDate;
}