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

import com.instructure.canvas.service.AwardLocalServiceUtil;
import com.instructure.canvas.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AwardClp extends BaseModelImpl<Award> implements Award {
	public AwardClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Award.class;
	}

	@Override
	public String getModelClassName() {
		return Award.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _awardId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAwardId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _awardId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("awardId", getAwardId());
		attributes.put("cvlId", getCvlId());
		attributes.put("cvlName", getCvlName());
		attributes.put("score", getScore());
		attributes.put("letterArticleId", getLetterArticleId());
		attributes.put("certificateArticleId", getCertificateArticleId());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long awardId = (Long)attributes.get("awardId");

		if (awardId != null) {
			setAwardId(awardId);
		}

		String cvlId = (String)attributes.get("cvlId");

		if (cvlId != null) {
			setCvlId(cvlId);
		}

		String cvlName = (String)attributes.get("cvlName");

		if (cvlName != null) {
			setCvlName(cvlName);
		}

		Double score = (Double)attributes.get("score");

		if (score != null) {
			setScore(score);
		}

		Long letterArticleId = (Long)attributes.get("letterArticleId");

		if (letterArticleId != null) {
			setLetterArticleId(letterArticleId);
		}

		Long certificateArticleId = (Long)attributes.get("certificateArticleId");

		if (certificateArticleId != null) {
			setCertificateArticleId(certificateArticleId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getAwardId() {
		return _awardId;
	}

	@Override
	public void setAwardId(long awardId) {
		_awardId = awardId;

		if (_awardRemoteModel != null) {
			try {
				Class<?> clazz = _awardRemoteModel.getClass();

				Method method = clazz.getMethod("setAwardId", long.class);

				method.invoke(_awardRemoteModel, awardId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCvlId() {
		return _cvlId;
	}

	@Override
	public void setCvlId(String cvlId) {
		_cvlId = cvlId;

		if (_awardRemoteModel != null) {
			try {
				Class<?> clazz = _awardRemoteModel.getClass();

				Method method = clazz.getMethod("setCvlId", String.class);

				method.invoke(_awardRemoteModel, cvlId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCvlName() {
		return _cvlName;
	}

	@Override
	public void setCvlName(String cvlName) {
		_cvlName = cvlName;

		if (_awardRemoteModel != null) {
			try {
				Class<?> clazz = _awardRemoteModel.getClass();

				Method method = clazz.getMethod("setCvlName", String.class);

				method.invoke(_awardRemoteModel, cvlName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getScore() {
		return _score;
	}

	@Override
	public void setScore(double score) {
		_score = score;

		if (_awardRemoteModel != null) {
			try {
				Class<?> clazz = _awardRemoteModel.getClass();

				Method method = clazz.getMethod("setScore", double.class);

				method.invoke(_awardRemoteModel, score);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLetterArticleId() {
		return _letterArticleId;
	}

	@Override
	public void setLetterArticleId(long letterArticleId) {
		_letterArticleId = letterArticleId;

		if (_awardRemoteModel != null) {
			try {
				Class<?> clazz = _awardRemoteModel.getClass();

				Method method = clazz.getMethod("setLetterArticleId", long.class);

				method.invoke(_awardRemoteModel, letterArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCertificateArticleId() {
		return _certificateArticleId;
	}

	@Override
	public void setCertificateArticleId(long certificateArticleId) {
		_certificateArticleId = certificateArticleId;

		if (_awardRemoteModel != null) {
			try {
				Class<?> clazz = _awardRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateArticleId",
						long.class);

				method.invoke(_awardRemoteModel, certificateArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_awardRemoteModel != null) {
			try {
				Class<?> clazz = _awardRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_awardRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_awardRemoteModel != null) {
			try {
				Class<?> clazz = _awardRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_awardRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_awardRemoteModel != null) {
			try {
				Class<?> clazz = _awardRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_awardRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAwardRemoteModel() {
		return _awardRemoteModel;
	}

	public void setAwardRemoteModel(BaseModel<?> awardRemoteModel) {
		_awardRemoteModel = awardRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _awardRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_awardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AwardLocalServiceUtil.addAward(this);
		}
		else {
			AwardLocalServiceUtil.updateAward(this);
		}
	}

	@Override
	public Award toEscapedModel() {
		return (Award)ProxyUtil.newProxyInstance(Award.class.getClassLoader(),
			new Class[] { Award.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AwardClp clone = new AwardClp();

		clone.setAwardId(getAwardId());
		clone.setCvlId(getCvlId());
		clone.setCvlName(getCvlName());
		clone.setScore(getScore());
		clone.setLetterArticleId(getLetterArticleId());
		clone.setCertificateArticleId(getCertificateArticleId());
		clone.setActive(getActive());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Award award) {
		long primaryKey = award.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AwardClp)) {
			return false;
		}

		AwardClp award = (AwardClp)obj;

		long primaryKey = award.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{awardId=");
		sb.append(getAwardId());
		sb.append(", cvlId=");
		sb.append(getCvlId());
		sb.append(", cvlName=");
		sb.append(getCvlName());
		sb.append(", score=");
		sb.append(getScore());
		sb.append(", letterArticleId=");
		sb.append(getLetterArticleId());
		sb.append(", certificateArticleId=");
		sb.append(getCertificateArticleId());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.Award");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>awardId</column-name><column-value><![CDATA[");
		sb.append(getAwardId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cvlId</column-name><column-value><![CDATA[");
		sb.append(getCvlId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cvlName</column-name><column-value><![CDATA[");
		sb.append(getCvlName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>score</column-name><column-value><![CDATA[");
		sb.append(getScore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>letterArticleId</column-name><column-value><![CDATA[");
		sb.append(getLetterArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateArticleId</column-name><column-value><![CDATA[");
		sb.append(getCertificateArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _awardRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}