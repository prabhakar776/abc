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
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.CanvasUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.CanvasUserServiceSoap
 * @generated
 */
public class CanvasUserSoap implements Serializable {
	public static CanvasUserSoap toSoapModel(CanvasUser model) {
		CanvasUserSoap soapModel = new CanvasUserSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setSID(model.getSID());
		soapModel.setLoginId(model.getLoginId());
		soapModel.setPassword(model.getPassword());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmail(model.getEmail());
		soapModel.setStatus(model.getStatus());
		soapModel.setFullName(model.getFullName());
		soapModel.setCanvasUserId(model.getCanvasUserId());
		soapModel.setCurrentScore(model.getCurrentScore());
		soapModel.setFinalScore(model.getFinalScore());

		return soapModel;
	}

	public static CanvasUserSoap[] toSoapModels(CanvasUser[] models) {
		CanvasUserSoap[] soapModels = new CanvasUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CanvasUserSoap[][] toSoapModels(CanvasUser[][] models) {
		CanvasUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CanvasUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CanvasUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CanvasUserSoap[] toSoapModels(List<CanvasUser> models) {
		List<CanvasUserSoap> soapModels = new ArrayList<CanvasUserSoap>(models.size());

		for (CanvasUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CanvasUserSoap[soapModels.size()]);
	}

	public CanvasUserSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getSID() {
		return _SID;
	}

	public void setSID(String SID) {
		_SID = SID;
	}

	public String getLoginId() {
		return _loginId;
	}

	public void setLoginId(String loginId) {
		_loginId = loginId;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getCanvasUserId() {
		return _canvasUserId;
	}

	public void setCanvasUserId(String canvasUserId) {
		_canvasUserId = canvasUserId;
	}

	public double getCurrentScore() {
		return _currentScore;
	}

	public void setCurrentScore(double currentScore) {
		_currentScore = currentScore;
	}

	public double getFinalScore() {
		return _finalScore;
	}

	public void setFinalScore(double finalScore) {
		_finalScore = finalScore;
	}

	private long _userId;
	private String _SID;
	private String _loginId;
	private String _password;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _status;
	private String _fullName;
	private String _canvasUserId;
	private double _currentScore;
	private double _finalScore;
}