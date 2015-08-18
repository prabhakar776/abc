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
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.UserAwardServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.UserAwardServiceSoap
 * @generated
 */
public class UserAwardSoap implements Serializable {
	public static UserAwardSoap toSoapModel(UserAward model) {
		UserAwardSoap soapModel = new UserAwardSoap();

		soapModel.setId(model.getId());
		soapModel.setCanvasUserId(model.getCanvasUserId());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setExternalId(model.getExternalId());
		soapModel.setCertId(model.getCertId());
		soapModel.setLetter(model.getLetter());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static UserAwardSoap[] toSoapModels(UserAward[] models) {
		UserAwardSoap[] soapModels = new UserAwardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserAwardSoap[][] toSoapModels(UserAward[][] models) {
		UserAwardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserAwardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserAwardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserAwardSoap[] toSoapModels(List<UserAward> models) {
		List<UserAwardSoap> soapModels = new ArrayList<UserAwardSoap>(models.size());

		for (UserAward model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserAwardSoap[soapModels.size()]);
	}

	public UserAwardSoap() {
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

	public long getCanvasUserId() {
		return _canvasUserId;
	}

	public void setCanvasUserId(long canvasUserId) {
		_canvasUserId = canvasUserId;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public long getExternalId() {
		return _externalId;
	}

	public void setExternalId(long externalId) {
		_externalId = externalId;
	}

	public String getCertId() {
		return _certId;
	}

	public void setCertId(String certId) {
		_certId = certId;
	}

	public boolean getLetter() {
		return _letter;
	}

	public boolean isLetter() {
		return _letter;
	}

	public void setLetter(boolean letter) {
		_letter = letter;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _id;
	private long _canvasUserId;
	private long _courseId;
	private long _externalId;
	private String _certId;
	private boolean _letter;
	private Date _createDate;
}