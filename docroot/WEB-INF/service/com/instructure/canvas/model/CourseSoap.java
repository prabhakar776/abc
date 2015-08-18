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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.CourseServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.CourseServiceSoap
 * @generated
 */
public class CourseSoap implements Serializable {
	public static CourseSoap toSoapModel(Course model) {
		CourseSoap soapModel = new CourseSoap();

		soapModel.setCanvasId(model.getCanvasId());
		soapModel.setName(model.getName());
		soapModel.setId(model.getId());
		soapModel.setEnrollments(model.getEnrollments());
		soapModel.setCourse_code(model.getCourse_code());
		soapModel.setSis_course_id(model.getSis_course_id());
		soapModel.setCalendar(model.getCalendar());
		soapModel.setUrl(model.getUrl());
		soapModel.setNetacadCoreOfferingId(model.getNetacadCoreOfferingId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setNetacadCVLId(model.getNetacadCVLId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static CourseSoap[] toSoapModels(Course[] models) {
		CourseSoap[] soapModels = new CourseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseSoap[][] toSoapModels(Course[][] models) {
		CourseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseSoap[] toSoapModels(List<Course> models) {
		List<CourseSoap> soapModels = new ArrayList<CourseSoap>(models.size());

		for (Course model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseSoap[soapModels.size()]);
	}

	public CourseSoap() {
	}

	public long getPrimaryKey() {
		return _canvasId;
	}

	public void setPrimaryKey(long pk) {
		setCanvasId(pk);
	}

	public long getCanvasId() {
		return _canvasId;
	}

	public void setCanvasId(long canvasId) {
		_canvasId = canvasId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getEnrollments() {
		return _enrollments;
	}

	public void setEnrollments(String enrollments) {
		_enrollments = enrollments;
	}

	public String getCourse_code() {
		return _course_code;
	}

	public void setCourse_code(String course_code) {
		_course_code = course_code;
	}

	public String getSis_course_id() {
		return _sis_course_id;
	}

	public void setSis_course_id(String sis_course_id) {
		_sis_course_id = sis_course_id;
	}

	public String getCalendar() {
		return _calendar;
	}

	public void setCalendar(String calendar) {
		_calendar = calendar;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getNetacadCoreOfferingId() {
		return _netacadCoreOfferingId;
	}

	public void setNetacadCoreOfferingId(String netacadCoreOfferingId) {
		_netacadCoreOfferingId = netacadCoreOfferingId;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public String getNetacadCVLId() {
		return _netacadCVLId;
	}

	public void setNetacadCVLId(String netacadCVLId) {
		_netacadCVLId = netacadCVLId;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	private long _canvasId;
	private String _name;
	private long _id;
	private String _enrollments;
	private String _course_code;
	private String _sis_course_id;
	private String _calendar;
	private String _url;
	private String _netacadCoreOfferingId;
	private long _accountId;
	private String _netacadCVLId;
	private Date _startDate;
	private Date _endDate;
}