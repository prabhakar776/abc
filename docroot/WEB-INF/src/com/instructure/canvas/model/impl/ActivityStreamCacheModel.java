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

import com.instructure.canvas.model.ActivityStream;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ActivityStream in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityStream
 * @generated
 */
public class ActivityStreamCacheModel implements CacheModel<ActivityStream>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{activityStreamId=");
		sb.append(activityStreamId);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append(", id=");
		sb.append(id);
		sb.append(", title=");
		sb.append(title);
		sb.append(", message=");
		sb.append(message);
		sb.append(", type=");
		sb.append(type);
		sb.append(", contextType=");
		sb.append(contextType);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", htmlUrl=");
		sb.append(htmlUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ActivityStream toEntityModel() {
		ActivityStreamImpl activityStreamImpl = new ActivityStreamImpl();

		activityStreamImpl.setActivityStreamId(activityStreamId);

		if (createdAt == null) {
			activityStreamImpl.setCreatedAt(StringPool.BLANK);
		}
		else {
			activityStreamImpl.setCreatedAt(createdAt);
		}

		if (updatedAt == null) {
			activityStreamImpl.setUpdatedAt(StringPool.BLANK);
		}
		else {
			activityStreamImpl.setUpdatedAt(updatedAt);
		}

		activityStreamImpl.setId(id);

		if (title == null) {
			activityStreamImpl.setTitle(StringPool.BLANK);
		}
		else {
			activityStreamImpl.setTitle(title);
		}

		if (message == null) {
			activityStreamImpl.setMessage(StringPool.BLANK);
		}
		else {
			activityStreamImpl.setMessage(message);
		}

		if (type == null) {
			activityStreamImpl.setType(StringPool.BLANK);
		}
		else {
			activityStreamImpl.setType(type);
		}

		if (contextType == null) {
			activityStreamImpl.setContextType(StringPool.BLANK);
		}
		else {
			activityStreamImpl.setContextType(contextType);
		}

		activityStreamImpl.setCourseId(courseId);

		if (groupId == null) {
			activityStreamImpl.setGroupId(StringPool.BLANK);
		}
		else {
			activityStreamImpl.setGroupId(groupId);
		}

		if (htmlUrl == null) {
			activityStreamImpl.setHtmlUrl(StringPool.BLANK);
		}
		else {
			activityStreamImpl.setHtmlUrl(htmlUrl);
		}

		activityStreamImpl.resetOriginalValues();

		return activityStreamImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		activityStreamId = objectInput.readLong();
		createdAt = objectInput.readUTF();
		updatedAt = objectInput.readUTF();
		id = objectInput.readLong();
		title = objectInput.readUTF();
		message = objectInput.readUTF();
		type = objectInput.readUTF();
		contextType = objectInput.readUTF();
		courseId = objectInput.readLong();
		groupId = objectInput.readUTF();
		htmlUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(activityStreamId);

		if (createdAt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdAt);
		}

		if (updatedAt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updatedAt);
		}

		objectOutput.writeLong(id);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (contextType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contextType);
		}

		objectOutput.writeLong(courseId);

		if (groupId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupId);
		}

		if (htmlUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htmlUrl);
		}
	}

	public long activityStreamId;
	public String createdAt;
	public String updatedAt;
	public long id;
	public String title;
	public String message;
	public String type;
	public String contextType;
	public long courseId;
	public String groupId;
	public String htmlUrl;
}