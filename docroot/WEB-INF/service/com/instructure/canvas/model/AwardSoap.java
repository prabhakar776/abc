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
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.AwardServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.AwardServiceSoap
 * @generated
 */
public class AwardSoap implements Serializable {
	public static AwardSoap toSoapModel(Award model) {
		AwardSoap soapModel = new AwardSoap();

		soapModel.setAwardId(model.getAwardId());
		soapModel.setCvlId(model.getCvlId());
		soapModel.setCvlName(model.getCvlName());
		soapModel.setScore(model.getScore());
		soapModel.setLetterArticleId(model.getLetterArticleId());
		soapModel.setCertificateArticleId(model.getCertificateArticleId());
		soapModel.setActive(model.getActive());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AwardSoap[] toSoapModels(Award[] models) {
		AwardSoap[] soapModels = new AwardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AwardSoap[][] toSoapModels(Award[][] models) {
		AwardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AwardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AwardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AwardSoap[] toSoapModels(List<Award> models) {
		List<AwardSoap> soapModels = new ArrayList<AwardSoap>(models.size());

		for (Award model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AwardSoap[soapModels.size()]);
	}

	public AwardSoap() {
	}

	public long getPrimaryKey() {
		return _awardId;
	}

	public void setPrimaryKey(long pk) {
		setAwardId(pk);
	}

	public long getAwardId() {
		return _awardId;
	}

	public void setAwardId(long awardId) {
		_awardId = awardId;
	}

	public String getCvlId() {
		return _cvlId;
	}

	public void setCvlId(String cvlId) {
		_cvlId = cvlId;
	}

	public String getCvlName() {
		return _cvlName;
	}

	public void setCvlName(String cvlName) {
		_cvlName = cvlName;
	}

	public double getScore() {
		return _score;
	}

	public void setScore(double score) {
		_score = score;
	}

	public long getLetterArticleId() {
		return _letterArticleId;
	}

	public void setLetterArticleId(long letterArticleId) {
		_letterArticleId = letterArticleId;
	}

	public long getCertificateArticleId() {
		return _certificateArticleId;
	}

	public void setCertificateArticleId(long certificateArticleId) {
		_certificateArticleId = certificateArticleId;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _awardId;
	private String _cvlId;
	private String _cvlName;
	private double _score;
	private long _letterArticleId;
	private long _certificateArticleId;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
}