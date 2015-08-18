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

import com.instructure.canvas.model.CanvasEnrollment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CanvasEnrollment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasEnrollment
 * @generated
 */
public class CanvasEnrollmentCacheModel implements CacheModel<CanvasEnrollment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{courseId=");
		sb.append(courseId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", role=");
		sb.append(role);
		sb.append(", sectionId=");
		sb.append(sectionId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", associatedUserId=");
		sb.append(associatedUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CanvasEnrollment toEntityModel() {
		CanvasEnrollmentImpl canvasEnrollmentImpl = new CanvasEnrollmentImpl();

		canvasEnrollmentImpl.setCourseId(courseId);

		if (userId == null) {
			canvasEnrollmentImpl.setUserId(StringPool.BLANK);
		}
		else {
			canvasEnrollmentImpl.setUserId(userId);
		}

		if (role == null) {
			canvasEnrollmentImpl.setRole(StringPool.BLANK);
		}
		else {
			canvasEnrollmentImpl.setRole(role);
		}

		if (sectionId == null) {
			canvasEnrollmentImpl.setSectionId(StringPool.BLANK);
		}
		else {
			canvasEnrollmentImpl.setSectionId(sectionId);
		}

		if (status == null) {
			canvasEnrollmentImpl.setStatus(StringPool.BLANK);
		}
		else {
			canvasEnrollmentImpl.setStatus(status);
		}

		if (associatedUserId == null) {
			canvasEnrollmentImpl.setAssociatedUserId(StringPool.BLANK);
		}
		else {
			canvasEnrollmentImpl.setAssociatedUserId(associatedUserId);
		}

		canvasEnrollmentImpl.resetOriginalValues();

		return canvasEnrollmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		courseId = objectInput.readLong();
		userId = objectInput.readUTF();
		role = objectInput.readUTF();
		sectionId = objectInput.readUTF();
		status = objectInput.readUTF();
		associatedUserId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(courseId);

		if (userId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userId);
		}

		if (role == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(role);
		}

		if (sectionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sectionId);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (associatedUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associatedUserId);
		}
	}

	public long courseId;
	public String userId;
	public String role;
	public String sectionId;
	public String status;
	public String associatedUserId;
}