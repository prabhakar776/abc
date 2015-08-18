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
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.CanvasAccountServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.CanvasAccountServiceSoap
 * @generated
 */
public class CanvasAccountSoap implements Serializable {
	public static CanvasAccountSoap toSoapModel(CanvasAccount model) {
		CanvasAccountSoap soapModel = new CanvasAccountSoap();

		soapModel.setAccountId(model.getAccountId());
		soapModel.setId(model.getId());
		soapModel.setParentAccountId(model.getParentAccountId());
		soapModel.setName(model.getName());
		soapModel.setRootAccountId(model.getRootAccountId());
		soapModel.setSISAccountId(model.getSISAccountId());
		soapModel.setStatus(model.getStatus());
		soapModel.setTimeZone(model.getTimeZone());

		return soapModel;
	}

	public static CanvasAccountSoap[] toSoapModels(CanvasAccount[] models) {
		CanvasAccountSoap[] soapModels = new CanvasAccountSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CanvasAccountSoap[][] toSoapModels(CanvasAccount[][] models) {
		CanvasAccountSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CanvasAccountSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CanvasAccountSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CanvasAccountSoap[] toSoapModels(List<CanvasAccount> models) {
		List<CanvasAccountSoap> soapModels = new ArrayList<CanvasAccountSoap>(models.size());

		for (CanvasAccount model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CanvasAccountSoap[soapModels.size()]);
	}

	public CanvasAccountSoap() {
	}

	public long getPrimaryKey() {
		return _accountId;
	}

	public void setPrimaryKey(long pk) {
		setAccountId(pk);
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getParentAccountId() {
		return _parentAccountId;
	}

	public void setParentAccountId(String parentAccountId) {
		_parentAccountId = parentAccountId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getRootAccountId() {
		return _rootAccountId;
	}

	public void setRootAccountId(String rootAccountId) {
		_rootAccountId = rootAccountId;
	}

	public String getSISAccountId() {
		return _SISAccountId;
	}

	public void setSISAccountId(String SISAccountId) {
		_SISAccountId = SISAccountId;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public String getTimeZone() {
		return _timeZone;
	}

	public void setTimeZone(String timeZone) {
		_timeZone = timeZone;
	}

	private long _accountId;
	private String _id;
	private String _parentAccountId;
	private String _name;
	private String _rootAccountId;
	private String _SISAccountId;
	private long _status;
	private String _timeZone;
}