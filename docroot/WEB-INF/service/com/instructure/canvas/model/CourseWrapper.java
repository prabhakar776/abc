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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Course}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Course
 * @generated
 */
public class CourseWrapper implements Course, ModelWrapper<Course> {
	public CourseWrapper(Course course) {
		_course = course;
	}

	@Override
	public Class<?> getModelClass() {
		return Course.class;
	}

	@Override
	public String getModelClassName() {
		return Course.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("canvasId", getCanvasId());
		attributes.put("name", getName());
		attributes.put("id", getId());
		attributes.put("enrollments", getEnrollments());
		attributes.put("course_code", getCourse_code());
		attributes.put("sis_course_id", getSis_course_id());
		attributes.put("calendar", getCalendar());
		attributes.put("url", getUrl());
		attributes.put("netacadCoreOfferingId", getNetacadCoreOfferingId());
		attributes.put("accountId", getAccountId());
		attributes.put("netacadCVLId", getNetacadCVLId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long canvasId = (Long)attributes.get("canvasId");

		if (canvasId != null) {
			setCanvasId(canvasId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String enrollments = (String)attributes.get("enrollments");

		if (enrollments != null) {
			setEnrollments(enrollments);
		}

		String course_code = (String)attributes.get("course_code");

		if (course_code != null) {
			setCourse_code(course_code);
		}

		String sis_course_id = (String)attributes.get("sis_course_id");

		if (sis_course_id != null) {
			setSis_course_id(sis_course_id);
		}

		String calendar = (String)attributes.get("calendar");

		if (calendar != null) {
			setCalendar(calendar);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String netacadCoreOfferingId = (String)attributes.get(
				"netacadCoreOfferingId");

		if (netacadCoreOfferingId != null) {
			setNetacadCoreOfferingId(netacadCoreOfferingId);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		String netacadCVLId = (String)attributes.get("netacadCVLId");

		if (netacadCVLId != null) {
			setNetacadCVLId(netacadCVLId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	/**
	* Returns the primary key of this course.
	*
	* @return the primary key of this course
	*/
	@Override
	public long getPrimaryKey() {
		return _course.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course.
	*
	* @param primaryKey the primary key of this course
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_course.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the canvas ID of this course.
	*
	* @return the canvas ID of this course
	*/
	@Override
	public long getCanvasId() {
		return _course.getCanvasId();
	}

	/**
	* Sets the canvas ID of this course.
	*
	* @param canvasId the canvas ID of this course
	*/
	@Override
	public void setCanvasId(long canvasId) {
		_course.setCanvasId(canvasId);
	}

	/**
	* Returns the name of this course.
	*
	* @return the name of this course
	*/
	@Override
	public java.lang.String getName() {
		return _course.getName();
	}

	/**
	* Sets the name of this course.
	*
	* @param name the name of this course
	*/
	@Override
	public void setName(java.lang.String name) {
		_course.setName(name);
	}

	/**
	* Returns the ID of this course.
	*
	* @return the ID of this course
	*/
	@Override
	public long getId() {
		return _course.getId();
	}

	/**
	* Sets the ID of this course.
	*
	* @param id the ID of this course
	*/
	@Override
	public void setId(long id) {
		_course.setId(id);
	}

	/**
	* Returns the enrollments of this course.
	*
	* @return the enrollments of this course
	*/
	@Override
	public java.lang.String getEnrollments() {
		return _course.getEnrollments();
	}

	/**
	* Sets the enrollments of this course.
	*
	* @param enrollments the enrollments of this course
	*/
	@Override
	public void setEnrollments(java.lang.String enrollments) {
		_course.setEnrollments(enrollments);
	}

	/**
	* Returns the course_code of this course.
	*
	* @return the course_code of this course
	*/
	@Override
	public java.lang.String getCourse_code() {
		return _course.getCourse_code();
	}

	/**
	* Sets the course_code of this course.
	*
	* @param course_code the course_code of this course
	*/
	@Override
	public void setCourse_code(java.lang.String course_code) {
		_course.setCourse_code(course_code);
	}

	/**
	* Returns the sis_course_id of this course.
	*
	* @return the sis_course_id of this course
	*/
	@Override
	public java.lang.String getSis_course_id() {
		return _course.getSis_course_id();
	}

	/**
	* Sets the sis_course_id of this course.
	*
	* @param sis_course_id the sis_course_id of this course
	*/
	@Override
	public void setSis_course_id(java.lang.String sis_course_id) {
		_course.setSis_course_id(sis_course_id);
	}

	/**
	* Returns the calendar of this course.
	*
	* @return the calendar of this course
	*/
	@Override
	public java.lang.String getCalendar() {
		return _course.getCalendar();
	}

	/**
	* Sets the calendar of this course.
	*
	* @param calendar the calendar of this course
	*/
	@Override
	public void setCalendar(java.lang.String calendar) {
		_course.setCalendar(calendar);
	}

	/**
	* Returns the url of this course.
	*
	* @return the url of this course
	*/
	@Override
	public java.lang.String getUrl() {
		return _course.getUrl();
	}

	/**
	* Sets the url of this course.
	*
	* @param url the url of this course
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_course.setUrl(url);
	}

	/**
	* Returns the netacad core offering ID of this course.
	*
	* @return the netacad core offering ID of this course
	*/
	@Override
	public java.lang.String getNetacadCoreOfferingId() {
		return _course.getNetacadCoreOfferingId();
	}

	/**
	* Sets the netacad core offering ID of this course.
	*
	* @param netacadCoreOfferingId the netacad core offering ID of this course
	*/
	@Override
	public void setNetacadCoreOfferingId(java.lang.String netacadCoreOfferingId) {
		_course.setNetacadCoreOfferingId(netacadCoreOfferingId);
	}

	/**
	* Returns the account ID of this course.
	*
	* @return the account ID of this course
	*/
	@Override
	public long getAccountId() {
		return _course.getAccountId();
	}

	/**
	* Sets the account ID of this course.
	*
	* @param accountId the account ID of this course
	*/
	@Override
	public void setAccountId(long accountId) {
		_course.setAccountId(accountId);
	}

	/**
	* Returns the netacad c v l ID of this course.
	*
	* @return the netacad c v l ID of this course
	*/
	@Override
	public java.lang.String getNetacadCVLId() {
		return _course.getNetacadCVLId();
	}

	/**
	* Sets the netacad c v l ID of this course.
	*
	* @param netacadCVLId the netacad c v l ID of this course
	*/
	@Override
	public void setNetacadCVLId(java.lang.String netacadCVLId) {
		_course.setNetacadCVLId(netacadCVLId);
	}

	/**
	* Returns the start date of this course.
	*
	* @return the start date of this course
	*/
	@Override
	public java.util.Date getStartDate() {
		return _course.getStartDate();
	}

	/**
	* Sets the start date of this course.
	*
	* @param startDate the start date of this course
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_course.setStartDate(startDate);
	}

	/**
	* Returns the end date of this course.
	*
	* @return the end date of this course
	*/
	@Override
	public java.util.Date getEndDate() {
		return _course.getEndDate();
	}

	/**
	* Sets the end date of this course.
	*
	* @param endDate the end date of this course
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_course.setEndDate(endDate);
	}

	@Override
	public boolean isNew() {
		return _course.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_course.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _course.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_course.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _course.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _course.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_course.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _course.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_course.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_course.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_course.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseWrapper((Course)_course.clone());
	}

	@Override
	public int compareTo(com.instructure.canvas.model.Course course) {
		return _course.compareTo(course);
	}

	@Override
	public int hashCode() {
		return _course.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.instructure.canvas.model.Course> toCacheModel() {
		return _course.toCacheModel();
	}

	@Override
	public com.instructure.canvas.model.Course toEscapedModel() {
		return new CourseWrapper(_course.toEscapedModel());
	}

	@Override
	public com.instructure.canvas.model.Course toUnescapedModel() {
		return new CourseWrapper(_course.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _course.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _course.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_course.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseWrapper)) {
			return false;
		}

		CourseWrapper courseWrapper = (CourseWrapper)obj;

		if (Validator.equals(_course, courseWrapper._course)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Course getWrappedCourse() {
		return _course;
	}

	@Override
	public Course getWrappedModel() {
		return _course;
	}

	@Override
	public void resetOriginalValues() {
		_course.resetOriginalValues();
	}

	private Course _course;
}