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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.CanvasEnrollmentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.CanvasEnrollmentServiceSoap
 * @generated
 */
public class CanvasEnrollmentSoap implements Serializable {
	public static CanvasEnrollmentSoap toSoapModel(CanvasEnrollment model) {
		CanvasEnrollmentSoap soapModel = new CanvasEnrollmentSoap();

		soapModel.setCourseId(model.getCourseId());
		soapModel.setUserId(model.getUserId());
		soapModel.setRole(model.getRole());
		soapModel.setSectionId(model.getSectionId());
		soapModel.setStatus(model.getStatus());
		soapModel.setAssociatedUserId(model.getAssociatedUserId());

		return soapModel;
	}

	public static CanvasEnrollmentSoap[] toSoapModels(CanvasEnrollment[] models) {
		CanvasEnrollmentSoap[] soapModels = new CanvasEnrollmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CanvasEnrollmentSoap[][] toSoapModels(
		CanvasEnrollment[][] models) {
		CanvasEnrollmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CanvasEnrollmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CanvasEnrollmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CanvasEnrollmentSoap[] toSoapModels(
		List<CanvasEnrollment> models) {
		List<CanvasEnrollmentSoap> soapModels = new ArrayList<CanvasEnrollmentSoap>(models.size());

		for (CanvasEnrollment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CanvasEnrollmentSoap[soapModels.size()]);
	}

	public CanvasEnrollmentSoap() {
	}

	public long getPrimaryKey() {
		return _courseId;
	}

	public void setPrimaryKey(long pk) {
		setCourseId(pk);
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public String getUserId() {
		return _userId;
	}

	public void setUserId(String userId) {
		_userId = userId;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public String getSectionId() {
		return _sectionId;
	}

	public void setSectionId(String sectionId) {
		_sectionId = sectionId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getAssociatedUserId() {
		return _associatedUserId;
	}

	public void setAssociatedUserId(String associatedUserId) {
		_associatedUserId = associatedUserId;
	}

	private long _courseId;
	private String _userId;
	private String _role;
	private String _sectionId;
	private String _status;
	private String _associatedUserId;
}