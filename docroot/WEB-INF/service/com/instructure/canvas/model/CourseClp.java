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

import com.instructure.canvas.service.ClpSerializer;
import com.instructure.canvas.service.CourseLocalServiceUtil;

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
public class CourseClp extends BaseModelImpl<Course> implements Course {
	public CourseClp() {
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
	public long getPrimaryKey() {
		return _canvasId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCanvasId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _canvasId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getCanvasId() {
		return _canvasId;
	}

	@Override
	public void setCanvasId(long canvasId) {
		_canvasId = canvasId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCanvasId", long.class);

				method.invoke(_courseRemoteModel, canvasId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_courseRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_courseRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEnrollments() {
		return _enrollments;
	}

	@Override
	public void setEnrollments(String enrollments) {
		_enrollments = enrollments;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setEnrollments", String.class);

				method.invoke(_courseRemoteModel, enrollments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCourse_code() {
		return _course_code;
	}

	@Override
	public void setCourse_code(String course_code) {
		_course_code = course_code;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourse_code", String.class);

				method.invoke(_courseRemoteModel, course_code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSis_course_id() {
		return _sis_course_id;
	}

	@Override
	public void setSis_course_id(String sis_course_id) {
		_sis_course_id = sis_course_id;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setSis_course_id", String.class);

				method.invoke(_courseRemoteModel, sis_course_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCalendar() {
		return _calendar;
	}

	@Override
	public void setCalendar(String calendar) {
		_calendar = calendar;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCalendar", String.class);

				method.invoke(_courseRemoteModel, calendar);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_courseRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNetacadCoreOfferingId() {
		return _netacadCoreOfferingId;
	}

	@Override
	public void setNetacadCoreOfferingId(String netacadCoreOfferingId) {
		_netacadCoreOfferingId = netacadCoreOfferingId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setNetacadCoreOfferingId",
						String.class);

				method.invoke(_courseRemoteModel, netacadCoreOfferingId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		_accountId = accountId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountId", long.class);

				method.invoke(_courseRemoteModel, accountId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNetacadCVLId() {
		return _netacadCVLId;
	}

	@Override
	public void setNetacadCVLId(String netacadCVLId) {
		_netacadCVLId = netacadCVLId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setNetacadCVLId", String.class);

				method.invoke(_courseRemoteModel, netacadCVLId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_courseRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_courseRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCourseRemoteModel() {
		return _courseRemoteModel;
	}

	public void setCourseRemoteModel(BaseModel<?> courseRemoteModel) {
		_courseRemoteModel = courseRemoteModel;
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

		Class<?> remoteModelClass = _courseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_courseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseLocalServiceUtil.addCourse(this);
		}
		else {
			CourseLocalServiceUtil.updateCourse(this);
		}
	}

	@Override
	public Course toEscapedModel() {
		return (Course)ProxyUtil.newProxyInstance(Course.class.getClassLoader(),
			new Class[] { Course.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseClp clone = new CourseClp();

		clone.setCanvasId(getCanvasId());
		clone.setName(getName());
		clone.setId(getId());
		clone.setEnrollments(getEnrollments());
		clone.setCourse_code(getCourse_code());
		clone.setSis_course_id(getSis_course_id());
		clone.setCalendar(getCalendar());
		clone.setUrl(getUrl());
		clone.setNetacadCoreOfferingId(getNetacadCoreOfferingId());
		clone.setAccountId(getAccountId());
		clone.setNetacadCVLId(getNetacadCVLId());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());

		return clone;
	}

	@Override
	public int compareTo(Course course) {
		long primaryKey = course.getPrimaryKey();

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

		if (!(obj instanceof CourseClp)) {
			return false;
		}

		CourseClp course = (CourseClp)obj;

		long primaryKey = course.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{canvasId=");
		sb.append(getCanvasId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", enrollments=");
		sb.append(getEnrollments());
		sb.append(", course_code=");
		sb.append(getCourse_code());
		sb.append(", sis_course_id=");
		sb.append(getSis_course_id());
		sb.append(", calendar=");
		sb.append(getCalendar());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", netacadCoreOfferingId=");
		sb.append(getNetacadCoreOfferingId());
		sb.append(", accountId=");
		sb.append(getAccountId());
		sb.append(", netacadCVLId=");
		sb.append(getNetacadCVLId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.instructure.canvas.model.Course");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>canvasId</column-name><column-value><![CDATA[");
		sb.append(getCanvasId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enrollments</column-name><column-value><![CDATA[");
		sb.append(getEnrollments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>course_code</column-name><column-value><![CDATA[");
		sb.append(getCourse_code());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sis_course_id</column-name><column-value><![CDATA[");
		sb.append(getSis_course_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>calendar</column-name><column-value><![CDATA[");
		sb.append(getCalendar());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>netacadCoreOfferingId</column-name><column-value><![CDATA[");
		sb.append(getNetacadCoreOfferingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>netacadCVLId</column-name><column-value><![CDATA[");
		sb.append(getNetacadCVLId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _courseRemoteModel;
	private Class<?> _clpSerializerClass = com.instructure.canvas.service.ClpSerializer.class;
}