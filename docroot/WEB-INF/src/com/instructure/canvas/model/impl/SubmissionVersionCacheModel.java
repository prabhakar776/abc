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

import com.instructure.canvas.model.SubmissionVersion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SubmissionVersion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionVersion
 * @generated
 */
public class SubmissionVersionCacheModel implements CacheModel<SubmissionVersion>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{submissionId=");
		sb.append(submissionId);
		sb.append(", assignmentId=");
		sb.append(assignmentId);
		sb.append(", assignmentName=");
		sb.append(assignmentName);
		sb.append(", attempt=");
		sb.append(attempt);
		sb.append(", body=");
		sb.append(body);
		sb.append(", currentGrade=");
		sb.append(currentGrade);
		sb.append(", currentGradedAt=");
		sb.append(currentGradedAt);
		sb.append(", currentGrader=");
		sb.append(currentGrader);
		sb.append(", gradeMatchesCurrentSubmission=");
		sb.append(gradeMatchesCurrentSubmission);
		sb.append(", gradedAt=");
		sb.append(gradedAt);
		sb.append(", grader=");
		sb.append(grader);
		sb.append(", graderId=");
		sb.append(graderId);
		sb.append(", newGrade=");
		sb.append(newGrade);
		sb.append(", newGradedAt=");
		sb.append(newGradedAt);
		sb.append(", newGrader=");
		sb.append(newGrader);
		sb.append(", previousGrade=");
		sb.append(previousGrade);
		sb.append(", previousGradedAt=");
		sb.append(previousGradedAt);
		sb.append(", previousGrader=");
		sb.append(previousGrader);
		sb.append(", score=");
		sb.append(score);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", submissionType=");
		sb.append(submissionType);
		sb.append(", url=");
		sb.append(url);
		sb.append(", workflowState=");
		sb.append(workflowState);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SubmissionVersion toEntityModel() {
		SubmissionVersionImpl submissionVersionImpl = new SubmissionVersionImpl();

		submissionVersionImpl.setSubmissionId(submissionId);
		submissionVersionImpl.setAssignmentId(assignmentId);

		if (assignmentName == null) {
			submissionVersionImpl.setAssignmentName(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setAssignmentName(assignmentName);
		}

		submissionVersionImpl.setAttempt(attempt);

		if (body == null) {
			submissionVersionImpl.setBody(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setBody(body);
		}

		if (currentGrade == null) {
			submissionVersionImpl.setCurrentGrade(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setCurrentGrade(currentGrade);
		}

		if (currentGradedAt == null) {
			submissionVersionImpl.setCurrentGradedAt(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setCurrentGradedAt(currentGradedAt);
		}

		if (currentGrader == null) {
			submissionVersionImpl.setCurrentGrader(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setCurrentGrader(currentGrader);
		}

		if (gradeMatchesCurrentSubmission == null) {
			submissionVersionImpl.setGradeMatchesCurrentSubmission(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setGradeMatchesCurrentSubmission(gradeMatchesCurrentSubmission);
		}

		if (gradedAt == null) {
			submissionVersionImpl.setGradedAt(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setGradedAt(gradedAt);
		}

		if (grader == null) {
			submissionVersionImpl.setGrader(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setGrader(grader);
		}

		submissionVersionImpl.setGraderId(graderId);

		if (newGrade == null) {
			submissionVersionImpl.setNewGrade(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setNewGrade(newGrade);
		}

		if (newGradedAt == null) {
			submissionVersionImpl.setNewGradedAt(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setNewGradedAt(newGradedAt);
		}

		if (newGrader == null) {
			submissionVersionImpl.setNewGrader(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setNewGrader(newGrader);
		}

		if (previousGrade == null) {
			submissionVersionImpl.setPreviousGrade(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setPreviousGrade(previousGrade);
		}

		if (previousGradedAt == null) {
			submissionVersionImpl.setPreviousGradedAt(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setPreviousGradedAt(previousGradedAt);
		}

		if (previousGrader == null) {
			submissionVersionImpl.setPreviousGrader(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setPreviousGrader(previousGrader);
		}

		submissionVersionImpl.setScore(score);

		if (userName == null) {
			submissionVersionImpl.setUserName(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setUserName(userName);
		}

		submissionVersionImpl.setUserId(userId);

		if (submissionType == null) {
			submissionVersionImpl.setSubmissionType(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setSubmissionType(submissionType);
		}

		if (url == null) {
			submissionVersionImpl.setUrl(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setUrl(url);
		}

		if (workflowState == null) {
			submissionVersionImpl.setWorkflowState(StringPool.BLANK);
		}
		else {
			submissionVersionImpl.setWorkflowState(workflowState);
		}

		submissionVersionImpl.resetOriginalValues();

		return submissionVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		submissionId = objectInput.readLong();
		assignmentId = objectInput.readLong();
		assignmentName = objectInput.readUTF();
		attempt = objectInput.readInt();
		body = objectInput.readUTF();
		currentGrade = objectInput.readUTF();
		currentGradedAt = objectInput.readUTF();
		currentGrader = objectInput.readUTF();
		gradeMatchesCurrentSubmission = objectInput.readUTF();
		gradedAt = objectInput.readUTF();
		grader = objectInput.readUTF();
		graderId = objectInput.readLong();
		newGrade = objectInput.readUTF();
		newGradedAt = objectInput.readUTF();
		newGrader = objectInput.readUTF();
		previousGrade = objectInput.readUTF();
		previousGradedAt = objectInput.readUTF();
		previousGrader = objectInput.readUTF();
		score = objectInput.readLong();
		userName = objectInput.readUTF();
		userId = objectInput.readLong();
		submissionType = objectInput.readUTF();
		url = objectInput.readUTF();
		workflowState = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(submissionId);
		objectOutput.writeLong(assignmentId);

		if (assignmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assignmentName);
		}

		objectOutput.writeInt(attempt);

		if (body == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(body);
		}

		if (currentGrade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentGrade);
		}

		if (currentGradedAt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentGradedAt);
		}

		if (currentGrader == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentGrader);
		}

		if (gradeMatchesCurrentSubmission == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gradeMatchesCurrentSubmission);
		}

		if (gradedAt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gradedAt);
		}

		if (grader == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(grader);
		}

		objectOutput.writeLong(graderId);

		if (newGrade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newGrade);
		}

		if (newGradedAt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newGradedAt);
		}

		if (newGrader == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newGrader);
		}

		if (previousGrade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(previousGrade);
		}

		if (previousGradedAt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(previousGradedAt);
		}

		if (previousGrader == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(previousGrader);
		}

		objectOutput.writeLong(score);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(userId);

		if (submissionType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(submissionType);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (workflowState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflowState);
		}
	}

	public long submissionId;
	public long assignmentId;
	public String assignmentName;
	public int attempt;
	public String body;
	public String currentGrade;
	public String currentGradedAt;
	public String currentGrader;
	public String gradeMatchesCurrentSubmission;
	public String gradedAt;
	public String grader;
	public long graderId;
	public String newGrade;
	public String newGradedAt;
	public String newGrader;
	public String previousGrade;
	public String previousGradedAt;
	public String previousGrader;
	public long score;
	public String userName;
	public long userId;
	public String submissionType;
	public String url;
	public String workflowState;
}