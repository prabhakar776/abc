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

import com.instructure.canvas.model.Assignment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Assignment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Assignment
 * @generated
 */
public class AssignmentCacheModel implements CacheModel<Assignment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{assignmentId=");
		sb.append(assignmentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", submissionType=");
		sb.append(submissionType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Assignment toEntityModel() {
		AssignmentImpl assignmentImpl = new AssignmentImpl();

		assignmentImpl.setAssignmentId(assignmentId);

		if (name == null) {
			assignmentImpl.setName(StringPool.BLANK);
		}
		else {
			assignmentImpl.setName(name);
		}

		if (submissionType == null) {
			assignmentImpl.setSubmissionType(StringPool.BLANK);
		}
		else {
			assignmentImpl.setSubmissionType(submissionType);
		}

		assignmentImpl.resetOriginalValues();

		return assignmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		assignmentId = objectInput.readLong();
		name = objectInput.readUTF();
		submissionType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(assignmentId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (submissionType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(submissionType);
		}
	}

	public long assignmentId;
	public String name;
	public String submissionType;
}