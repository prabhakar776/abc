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

import com.instructure.canvas.model.Todo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Todo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Todo
 * @generated
 */
public class TodoCacheModel implements CacheModel<Todo>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{todoId=");
		sb.append(todoId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", assignmentName=");
		sb.append(assignmentName);
		sb.append(", assignmentDescription=");
		sb.append(assignmentDescription);
		sb.append(", ignore_=");
		sb.append(ignore_);
		sb.append(", ignorePermanently=");
		sb.append(ignorePermanently);
		sb.append(", needsGradingCount=");
		sb.append(needsGradingCount);
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
	public Todo toEntityModel() {
		TodoImpl todoImpl = new TodoImpl();

		todoImpl.setTodoId(todoId);

		if (type == null) {
			todoImpl.setType(StringPool.BLANK);
		}
		else {
			todoImpl.setType(type);
		}

		if (assignmentName == null) {
			todoImpl.setAssignmentName(StringPool.BLANK);
		}
		else {
			todoImpl.setAssignmentName(assignmentName);
		}

		if (assignmentDescription == null) {
			todoImpl.setAssignmentDescription(StringPool.BLANK);
		}
		else {
			todoImpl.setAssignmentDescription(assignmentDescription);
		}

		if (ignore_ == null) {
			todoImpl.setIgnore_(StringPool.BLANK);
		}
		else {
			todoImpl.setIgnore_(ignore_);
		}

		if (ignorePermanently == null) {
			todoImpl.setIgnorePermanently(StringPool.BLANK);
		}
		else {
			todoImpl.setIgnorePermanently(ignorePermanently);
		}

		todoImpl.setNeedsGradingCount(needsGradingCount);

		if (contextType == null) {
			todoImpl.setContextType(StringPool.BLANK);
		}
		else {
			todoImpl.setContextType(contextType);
		}

		if (courseId == null) {
			todoImpl.setCourseId(StringPool.BLANK);
		}
		else {
			todoImpl.setCourseId(courseId);
		}

		if (groupId == null) {
			todoImpl.setGroupId(StringPool.BLANK);
		}
		else {
			todoImpl.setGroupId(groupId);
		}

		if (htmlUrl == null) {
			todoImpl.setHtmlUrl(StringPool.BLANK);
		}
		else {
			todoImpl.setHtmlUrl(htmlUrl);
		}

		todoImpl.resetOriginalValues();

		return todoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		todoId = objectInput.readLong();
		type = objectInput.readUTF();
		assignmentName = objectInput.readUTF();
		assignmentDescription = objectInput.readUTF();
		ignore_ = objectInput.readUTF();
		ignorePermanently = objectInput.readUTF();
		needsGradingCount = objectInput.readLong();
		contextType = objectInput.readUTF();
		courseId = objectInput.readUTF();
		groupId = objectInput.readUTF();
		htmlUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(todoId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (assignmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assignmentName);
		}

		if (assignmentDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assignmentDescription);
		}

		if (ignore_ == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ignore_);
		}

		if (ignorePermanently == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ignorePermanently);
		}

		objectOutput.writeLong(needsGradingCount);

		if (contextType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contextType);
		}

		if (courseId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseId);
		}

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

	public long todoId;
	public String type;
	public String assignmentName;
	public String assignmentDescription;
	public String ignore_;
	public String ignorePermanently;
	public long needsGradingCount;
	public String contextType;
	public String courseId;
	public String groupId;
	public String htmlUrl;
}