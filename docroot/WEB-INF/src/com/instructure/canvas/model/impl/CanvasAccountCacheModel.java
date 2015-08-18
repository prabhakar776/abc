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

import com.instructure.canvas.model.CanvasAccount;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CanvasAccount in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasAccount
 * @generated
 */
public class CanvasAccountCacheModel implements CacheModel<CanvasAccount>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{accountId=");
		sb.append(accountId);
		sb.append(", id=");
		sb.append(id);
		sb.append(", parentAccountId=");
		sb.append(parentAccountId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", rootAccountId=");
		sb.append(rootAccountId);
		sb.append(", SISAccountId=");
		sb.append(SISAccountId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", timeZone=");
		sb.append(timeZone);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CanvasAccount toEntityModel() {
		CanvasAccountImpl canvasAccountImpl = new CanvasAccountImpl();

		canvasAccountImpl.setAccountId(accountId);

		if (id == null) {
			canvasAccountImpl.setId(StringPool.BLANK);
		}
		else {
			canvasAccountImpl.setId(id);
		}

		if (parentAccountId == null) {
			canvasAccountImpl.setParentAccountId(StringPool.BLANK);
		}
		else {
			canvasAccountImpl.setParentAccountId(parentAccountId);
		}

		if (name == null) {
			canvasAccountImpl.setName(StringPool.BLANK);
		}
		else {
			canvasAccountImpl.setName(name);
		}

		if (rootAccountId == null) {
			canvasAccountImpl.setRootAccountId(StringPool.BLANK);
		}
		else {
			canvasAccountImpl.setRootAccountId(rootAccountId);
		}

		if (SISAccountId == null) {
			canvasAccountImpl.setSISAccountId(StringPool.BLANK);
		}
		else {
			canvasAccountImpl.setSISAccountId(SISAccountId);
		}

		canvasAccountImpl.setStatus(status);

		if (timeZone == null) {
			canvasAccountImpl.setTimeZone(StringPool.BLANK);
		}
		else {
			canvasAccountImpl.setTimeZone(timeZone);
		}

		canvasAccountImpl.resetOriginalValues();

		return canvasAccountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		accountId = objectInput.readLong();
		id = objectInput.readUTF();
		parentAccountId = objectInput.readUTF();
		name = objectInput.readUTF();
		rootAccountId = objectInput.readUTF();
		SISAccountId = objectInput.readUTF();
		status = objectInput.readLong();
		timeZone = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(accountId);

		if (id == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(id);
		}

		if (parentAccountId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(parentAccountId);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (rootAccountId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rootAccountId);
		}

		if (SISAccountId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(SISAccountId);
		}

		objectOutput.writeLong(status);

		if (timeZone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timeZone);
		}
	}

	public long accountId;
	public String id;
	public String parentAccountId;
	public String name;
	public String rootAccountId;
	public String SISAccountId;
	public long status;
	public String timeZone;
}