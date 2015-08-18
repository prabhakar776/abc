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

import com.instructure.canvas.model.Award;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Award in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Award
 * @generated
 */
public class AwardCacheModel implements CacheModel<Award>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{awardId=");
		sb.append(awardId);
		sb.append(", cvlId=");
		sb.append(cvlId);
		sb.append(", cvlName=");
		sb.append(cvlName);
		sb.append(", score=");
		sb.append(score);
		sb.append(", letterArticleId=");
		sb.append(letterArticleId);
		sb.append(", certificateArticleId=");
		sb.append(certificateArticleId);
		sb.append(", active=");
		sb.append(active);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Award toEntityModel() {
		AwardImpl awardImpl = new AwardImpl();

		awardImpl.setAwardId(awardId);

		if (cvlId == null) {
			awardImpl.setCvlId(StringPool.BLANK);
		}
		else {
			awardImpl.setCvlId(cvlId);
		}

		if (cvlName == null) {
			awardImpl.setCvlName(StringPool.BLANK);
		}
		else {
			awardImpl.setCvlName(cvlName);
		}

		awardImpl.setScore(score);
		awardImpl.setLetterArticleId(letterArticleId);
		awardImpl.setCertificateArticleId(certificateArticleId);
		awardImpl.setActive(active);

		if (createDate == Long.MIN_VALUE) {
			awardImpl.setCreateDate(null);
		}
		else {
			awardImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			awardImpl.setModifiedDate(null);
		}
		else {
			awardImpl.setModifiedDate(new Date(modifiedDate));
		}

		awardImpl.resetOriginalValues();

		return awardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		awardId = objectInput.readLong();
		cvlId = objectInput.readUTF();
		cvlName = objectInput.readUTF();
		score = objectInput.readDouble();
		letterArticleId = objectInput.readLong();
		certificateArticleId = objectInput.readLong();
		active = objectInput.readBoolean();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(awardId);

		if (cvlId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cvlId);
		}

		if (cvlName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cvlName);
		}

		objectOutput.writeDouble(score);
		objectOutput.writeLong(letterArticleId);
		objectOutput.writeLong(certificateArticleId);
		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long awardId;
	public String cvlId;
	public String cvlName;
	public double score;
	public long letterArticleId;
	public long certificateArticleId;
	public boolean active;
	public long createDate;
	public long modifiedDate;
}