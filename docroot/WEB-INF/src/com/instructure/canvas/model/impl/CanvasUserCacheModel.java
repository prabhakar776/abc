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

import com.instructure.canvas.model.CanvasUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CanvasUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasUser
 * @generated
 */
public class CanvasUserCacheModel implements CacheModel<CanvasUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", SID=");
		sb.append(SID);
		sb.append(", loginId=");
		sb.append(loginId);
		sb.append(", password=");
		sb.append(password);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", status=");
		sb.append(status);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", canvasUserId=");
		sb.append(canvasUserId);
		sb.append(", currentScore=");
		sb.append(currentScore);
		sb.append(", finalScore=");
		sb.append(finalScore);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CanvasUser toEntityModel() {
		CanvasUserImpl canvasUserImpl = new CanvasUserImpl();

		canvasUserImpl.setUserId(userId);

		if (SID == null) {
			canvasUserImpl.setSID(StringPool.BLANK);
		}
		else {
			canvasUserImpl.setSID(SID);
		}

		if (loginId == null) {
			canvasUserImpl.setLoginId(StringPool.BLANK);
		}
		else {
			canvasUserImpl.setLoginId(loginId);
		}

		if (password == null) {
			canvasUserImpl.setPassword(StringPool.BLANK);
		}
		else {
			canvasUserImpl.setPassword(password);
		}

		if (firstName == null) {
			canvasUserImpl.setFirstName(StringPool.BLANK);
		}
		else {
			canvasUserImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			canvasUserImpl.setLastName(StringPool.BLANK);
		}
		else {
			canvasUserImpl.setLastName(lastName);
		}

		if (email == null) {
			canvasUserImpl.setEmail(StringPool.BLANK);
		}
		else {
			canvasUserImpl.setEmail(email);
		}

		if (status == null) {
			canvasUserImpl.setStatus(StringPool.BLANK);
		}
		else {
			canvasUserImpl.setStatus(status);
		}

		if (fullName == null) {
			canvasUserImpl.setFullName(StringPool.BLANK);
		}
		else {
			canvasUserImpl.setFullName(fullName);
		}

		if (canvasUserId == null) {
			canvasUserImpl.setCanvasUserId(StringPool.BLANK);
		}
		else {
			canvasUserImpl.setCanvasUserId(canvasUserId);
		}

		canvasUserImpl.setCurrentScore(currentScore);
		canvasUserImpl.setFinalScore(finalScore);

		canvasUserImpl.resetOriginalValues();

		return canvasUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		SID = objectInput.readUTF();
		loginId = objectInput.readUTF();
		password = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		email = objectInput.readUTF();
		status = objectInput.readUTF();
		fullName = objectInput.readUTF();
		canvasUserId = objectInput.readUTF();
		currentScore = objectInput.readDouble();
		finalScore = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);

		if (SID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(SID);
		}

		if (loginId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(loginId);
		}

		if (password == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (canvasUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(canvasUserId);
		}

		objectOutput.writeDouble(currentScore);
		objectOutput.writeDouble(finalScore);
	}

	public long userId;
	public String SID;
	public String loginId;
	public String password;
	public String firstName;
	public String lastName;
	public String email;
	public String status;
	public String fullName;
	public String canvasUserId;
	public double currentScore;
	public double finalScore;
}