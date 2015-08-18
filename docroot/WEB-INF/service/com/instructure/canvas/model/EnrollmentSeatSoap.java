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
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.EnrollmentSeatServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.EnrollmentSeatServiceSoap
 * @generated
 */
public class EnrollmentSeatSoap implements Serializable {
	public static EnrollmentSeatSoap toSoapModel(EnrollmentSeat model) {
		EnrollmentSeatSoap soapModel = new EnrollmentSeatSoap();

		soapModel.setId(model.getId());
		soapModel.setToken(model.getToken());
		soapModel.setRootAccountId(model.getRootAccountId());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setRedeemDate(model.getRedeemDate());

		return soapModel;
	}

	public static EnrollmentSeatSoap[] toSoapModels(EnrollmentSeat[] models) {
		EnrollmentSeatSoap[] soapModels = new EnrollmentSeatSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EnrollmentSeatSoap[][] toSoapModels(EnrollmentSeat[][] models) {
		EnrollmentSeatSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnrollmentSeatSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnrollmentSeatSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EnrollmentSeatSoap[] toSoapModels(List<EnrollmentSeat> models) {
		List<EnrollmentSeatSoap> soapModels = new ArrayList<EnrollmentSeatSoap>(models.size());

		for (EnrollmentSeat model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnrollmentSeatSoap[soapModels.size()]);
	}

	public EnrollmentSeatSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getToken() {
		return _token;
	}

	public void setToken(String token) {
		_token = token;
	}

	public String getRootAccountId() {
		return _rootAccountId;
	}

	public void setRootAccountId(String rootAccountId) {
		_rootAccountId = rootAccountId;
	}

	public String getCourseId() {
		return _courseId;
	}

	public void setCourseId(String courseId) {
		_courseId = courseId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getRedeemDate() {
		return _redeemDate;
	}

	public void setRedeemDate(Date redeemDate) {
		_redeemDate = redeemDate;
	}

	private long _id;
	private String _token;
	private String _rootAccountId;
	private String _courseId;
	private long _userId;
	private Date _createDate;
	private Date _redeemDate;
}