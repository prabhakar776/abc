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

import com.instructure.canvas.model.Course;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Course in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Course
 * @generated
 */
public class CourseCacheModel implements CacheModel<Course>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{canvasId=");
		sb.append(canvasId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", id=");
		sb.append(id);
		sb.append(", enrollments=");
		sb.append(enrollments);
		sb.append(", course_code=");
		sb.append(course_code);
		sb.append(", sis_course_id=");
		sb.append(sis_course_id);
		sb.append(", calendar=");
		sb.append(calendar);
		sb.append(", url=");
		sb.append(url);
		sb.append(", netacadCoreOfferingId=");
		sb.append(netacadCoreOfferingId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", netacadCVLId=");
		sb.append(netacadCVLId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Course toEntityModel() {
		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setCanvasId(canvasId);

		if (name == null) {
			courseImpl.setName(StringPool.BLANK);
		}
		else {
			courseImpl.setName(name);
		}

		courseImpl.setId(id);

		if (enrollments == null) {
			courseImpl.setEnrollments(StringPool.BLANK);
		}
		else {
			courseImpl.setEnrollments(enrollments);
		}

		if (course_code == null) {
			courseImpl.setCourse_code(StringPool.BLANK);
		}
		else {
			courseImpl.setCourse_code(course_code);
		}

		if (sis_course_id == null) {
			courseImpl.setSis_course_id(StringPool.BLANK);
		}
		else {
			courseImpl.setSis_course_id(sis_course_id);
		}

		if (calendar == null) {
			courseImpl.setCalendar(StringPool.BLANK);
		}
		else {
			courseImpl.setCalendar(calendar);
		}

		if (url == null) {
			courseImpl.setUrl(StringPool.BLANK);
		}
		else {
			courseImpl.setUrl(url);
		}

		if (netacadCoreOfferingId == null) {
			courseImpl.setNetacadCoreOfferingId(StringPool.BLANK);
		}
		else {
			courseImpl.setNetacadCoreOfferingId(netacadCoreOfferingId);
		}

		courseImpl.setAccountId(accountId);

		if (netacadCVLId == null) {
			courseImpl.setNetacadCVLId(StringPool.BLANK);
		}
		else {
			courseImpl.setNetacadCVLId(netacadCVLId);
		}

		if (startDate == Long.MIN_VALUE) {
			courseImpl.setStartDate(null);
		}
		else {
			courseImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			courseImpl.setEndDate(null);
		}
		else {
			courseImpl.setEndDate(new Date(endDate));
		}

		courseImpl.resetOriginalValues();

		return courseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		canvasId = objectInput.readLong();
		name = objectInput.readUTF();
		id = objectInput.readLong();
		enrollments = objectInput.readUTF();
		course_code = objectInput.readUTF();
		sis_course_id = objectInput.readUTF();
		calendar = objectInput.readUTF();
		url = objectInput.readUTF();
		netacadCoreOfferingId = objectInput.readUTF();
		accountId = objectInput.readLong();
		netacadCVLId = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(canvasId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(id);

		if (enrollments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(enrollments);
		}

		if (course_code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(course_code);
		}

		if (sis_course_id == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sis_course_id);
		}

		if (calendar == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(calendar);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (netacadCoreOfferingId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(netacadCoreOfferingId);
		}

		objectOutput.writeLong(accountId);

		if (netacadCVLId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(netacadCVLId);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long canvasId;
	public String name;
	public long id;
	public String enrollments;
	public String course_code;
	public String sis_course_id;
	public String calendar;
	public String url;
	public String netacadCoreOfferingId;
	public long accountId;
	public String netacadCVLId;
	public long startDate;
	public long endDate;
}