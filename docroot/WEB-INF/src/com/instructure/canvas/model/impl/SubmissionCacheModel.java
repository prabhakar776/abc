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

import com.instructure.canvas.model.Submission;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Submission in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Submission
 * @generated
 */
public class SubmissionCacheModel implements CacheModel<Submission>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{submissionId=");
		sb.append(submissionId);
		sb.append(", assignmentId=");
		sb.append(assignmentId);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", attempt=");
		sb.append(attempt);
		sb.append(", grade=");
		sb.append(grade);
		sb.append(", htmlUrl=");
		sb.append(htmlUrl);
		sb.append(", score=");
		sb.append(score);
		sb.append(", submissionDate=");
		sb.append(submissionDate);
		sb.append(", graderId=");
		sb.append(graderId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Submission toEntityModel() {
		SubmissionImpl submissionImpl = new SubmissionImpl();

		submissionImpl.setSubmissionId(submissionId);
		submissionImpl.setAssignmentId(assignmentId);
		submissionImpl.setCourseId(courseId);
		submissionImpl.setAttempt(attempt);

		if (grade == null) {
			submissionImpl.setGrade(StringPool.BLANK);
		}
		else {
			submissionImpl.setGrade(grade);
		}

		if (htmlUrl == null) {
			submissionImpl.setHtmlUrl(StringPool.BLANK);
		}
		else {
			submissionImpl.setHtmlUrl(htmlUrl);
		}

		submissionImpl.setScore(score);

		if (submissionDate == null) {
			submissionImpl.setSubmissionDate(StringPool.BLANK);
		}
		else {
			submissionImpl.setSubmissionDate(submissionDate);
		}

		if (graderId == null) {
			submissionImpl.setGraderId(StringPool.BLANK);
		}
		else {
			submissionImpl.setGraderId(graderId);
		}

		submissionImpl.setUserId(userId);

		submissionImpl.resetOriginalValues();

		return submissionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		submissionId = objectInput.readLong();
		assignmentId = objectInput.readLong();
		courseId = objectInput.readLong();
		attempt = objectInput.readInt();
		grade = objectInput.readUTF();
		htmlUrl = objectInput.readUTF();
		score = objectInput.readDouble();
		submissionDate = objectInput.readUTF();
		graderId = objectInput.readUTF();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(submissionId);
		objectOutput.writeLong(assignmentId);
		objectOutput.writeLong(courseId);
		objectOutput.writeInt(attempt);

		if (grade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(grade);
		}

		if (htmlUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htmlUrl);
		}

		objectOutput.writeDouble(score);

		if (submissionDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(submissionDate);
		}

		if (graderId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(graderId);
		}

		objectOutput.writeLong(userId);
	}

	public long submissionId;
	public long assignmentId;
	public long courseId;
	public int attempt;
	public String grade;
	public String htmlUrl;
	public double score;
	public String submissionDate;
	public String graderId;
	public long userId;
}