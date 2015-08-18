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

import com.instructure.canvas.model.UserAward;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserAward in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserAward
 * @generated
 */
public class UserAwardCacheModel implements CacheModel<UserAward>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", canvasUserId=");
		sb.append(canvasUserId);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", externalId=");
		sb.append(externalId);
		sb.append(", certId=");
		sb.append(certId);
		sb.append(", letter=");
		sb.append(letter);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserAward toEntityModel() {
		UserAwardImpl userAwardImpl = new UserAwardImpl();

		userAwardImpl.setId(id);
		userAwardImpl.setCanvasUserId(canvasUserId);
		userAwardImpl.setCourseId(courseId);
		userAwardImpl.setExternalId(externalId);

		if (certId == null) {
			userAwardImpl.setCertId(StringPool.BLANK);
		}
		else {
			userAwardImpl.setCertId(certId);
		}

		userAwardImpl.setLetter(letter);

		if (createDate == Long.MIN_VALUE) {
			userAwardImpl.setCreateDate(null);
		}
		else {
			userAwardImpl.setCreateDate(new Date(createDate));
		}

		userAwardImpl.resetOriginalValues();

		return userAwardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		canvasUserId = objectInput.readLong();
		courseId = objectInput.readLong();
		externalId = objectInput.readLong();
		certId = objectInput.readUTF();
		letter = objectInput.readBoolean();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(canvasUserId);
		objectOutput.writeLong(courseId);
		objectOutput.writeLong(externalId);

		if (certId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certId);
		}

		objectOutput.writeBoolean(letter);
		objectOutput.writeLong(createDate);
	}

	public long id;
	public long canvasUserId;
	public long courseId;
	public long externalId;
	public String certId;
	public boolean letter;
	public long createDate;
}