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

package com.instructure.canvas.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Assignment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Assignment
 * @generated
 */
public class AssignmentWrapper implements Assignment, ModelWrapper<Assignment> {
	public AssignmentWrapper(Assignment assignment) {
		_assignment = assignment;
	}

	@Override
	public Class<?> getModelClass() {
		return Assignment.class;
	}

	@Override
	public String getModelClassName() {
		return Assignment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("assignmentId", getAssignmentId());
		attributes.put("name", getName());
		attributes.put("submissionType", getSubmissionType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long assignmentId = (Long)attributes.get("assignmentId");

		if (assignmentId != null) {
			setAssignmentId(assignmentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String submissionType = (String)attributes.get("submissionType");

		if (submissionType != null) {
			setSubmissionType(submissionType);
		}
	}

	/**
	* Returns the primary key of this assignment.
	*
	* @return the primary key of this assignment
	*/
	@Override
	public long getPrimaryKey() {
		return _assignment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this assignment.
	*
	* @param primaryKey the primary key of this assignment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_assignment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the assignment ID of this assignment.
	*
	* @return the assignment ID of this assignment
	*/
	@Override
	public long getAssignmentId() {
		return _assignment.getAssignmentId();
	}

	/**
	* Sets the assignment ID of this assignment.
	*
	* @param assignmentId the assignment ID of this assignment
	*/
	@Override
	public void setAssignmentId(long assignmentId) {
		_assignment.setAssignmentId(assignmentId);
	}

	/**
	* Returns the name of this assignment.
	*
	* @return the name of this assignment
	*/
	@Override
	public java.lang.String getName() {
		return _assignment.getName();
	}

	/**
	* Sets the name of this assignment.
	*
	* @param name the name of this assignment
	*/
	@Override
	public void setName(java.lang.String name) {
		_assignment.setName(name);
	}

	/**
	* Returns the submission type of this assignment.
	*
	* @return the submission type of this assignment
	*/
	@Override
	public java.lang.String getSubmissionType() {
		return _assignment.getSubmissionType();
	}

	/**
	* Sets the submission type of this assignment.
	*
	* @param submissionType the submission type of this assignment
	*/
	@Override
	public void setSubmissionType(java.lang.String submissionType) {
		_assignment.setSubmissionType(submissionType);
	}

	@Override
	public boolean isNew() {
		return _assignment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_assignment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _assignment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_assignment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _assignment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _assignment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_assignment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _assignment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_assignment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_assignment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_assignment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AssignmentWrapper((Assignment)_assignment.clone());
	}

	@Override
	public int compareTo(com.instructure.canvas.model.Assignment assignment) {
		return _assignment.compareTo(assignment);
	}

	@Override
	public int hashCode() {
		return _assignment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.Assignment> toCacheModel() {
		return _assignment.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.Assignment toEscapedModel() {
		return new AssignmentWrapper(_assignment.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.Assignment toUnescapedModel() {
		return new AssignmentWrapper(_assignment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _assignment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _assignment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_assignment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssignmentWrapper)) {
			return false;
		}

		AssignmentWrapper assignmentWrapper = (AssignmentWrapper)obj;

		if (Validator.equals(_assignment, assignmentWrapper._assignment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Assignment getWrappedAssignment() {
		return _assignment;
	}

	@Override
	public Assignment getWrappedModel() {
		return _assignment;
	}

	@Override
	public void resetOriginalValues() {
		_assignment.resetOriginalValues();
	}

	private Assignment _assignment;
}