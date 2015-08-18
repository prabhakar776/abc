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

package com.instructure.canvas.service;

import com.instructure.canvas.model.ActivityStreamClp;
import com.instructure.canvas.model.AssignmentClp;
import com.instructure.canvas.model.AwardClp;
import com.instructure.canvas.model.CanvasAccountClp;
import com.instructure.canvas.model.CanvasEnrollmentClp;
import com.instructure.canvas.model.CanvasUserClp;
import com.instructure.canvas.model.CertLetterQueueClp;
import com.instructure.canvas.model.CourseClp;
import com.instructure.canvas.model.EnrollmentSeatClp;
import com.instructure.canvas.model.SubmissionClp;
import com.instructure.canvas.model.SubmissionVersionClp;
import com.instructure.canvas.model.TodoClp;
import com.instructure.canvas.model.UserAwardClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"canvas-integration-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"canvas-integration-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "canvas-integration-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ActivityStreamClp.class.getName())) {
			return translateInputActivityStream(oldModel);
		}

		if (oldModelClassName.equals(AssignmentClp.class.getName())) {
			return translateInputAssignment(oldModel);
		}

		if (oldModelClassName.equals(AwardClp.class.getName())) {
			return translateInputAward(oldModel);
		}

		if (oldModelClassName.equals(CanvasAccountClp.class.getName())) {
			return translateInputCanvasAccount(oldModel);
		}

		if (oldModelClassName.equals(CanvasEnrollmentClp.class.getName())) {
			return translateInputCanvasEnrollment(oldModel);
		}

		if (oldModelClassName.equals(CanvasUserClp.class.getName())) {
			return translateInputCanvasUser(oldModel);
		}

		if (oldModelClassName.equals(CertLetterQueueClp.class.getName())) {
			return translateInputCertLetterQueue(oldModel);
		}

		if (oldModelClassName.equals(CourseClp.class.getName())) {
			return translateInputCourse(oldModel);
		}

		if (oldModelClassName.equals(EnrollmentSeatClp.class.getName())) {
			return translateInputEnrollmentSeat(oldModel);
		}

		if (oldModelClassName.equals(SubmissionClp.class.getName())) {
			return translateInputSubmission(oldModel);
		}

		if (oldModelClassName.equals(SubmissionVersionClp.class.getName())) {
			return translateInputSubmissionVersion(oldModel);
		}

		if (oldModelClassName.equals(TodoClp.class.getName())) {
			return translateInputTodo(oldModel);
		}

		if (oldModelClassName.equals(UserAwardClp.class.getName())) {
			return translateInputUserAward(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputActivityStream(BaseModel<?> oldModel) {
		ActivityStreamClp oldClpModel = (ActivityStreamClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getActivityStreamRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAssignment(BaseModel<?> oldModel) {
		AssignmentClp oldClpModel = (AssignmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAssignmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAward(BaseModel<?> oldModel) {
		AwardClp oldClpModel = (AwardClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAwardRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCanvasAccount(BaseModel<?> oldModel) {
		CanvasAccountClp oldClpModel = (CanvasAccountClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCanvasAccountRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCanvasEnrollment(BaseModel<?> oldModel) {
		CanvasEnrollmentClp oldClpModel = (CanvasEnrollmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCanvasEnrollmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCanvasUser(BaseModel<?> oldModel) {
		CanvasUserClp oldClpModel = (CanvasUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCanvasUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCertLetterQueue(BaseModel<?> oldModel) {
		CertLetterQueueClp oldClpModel = (CertLetterQueueClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCertLetterQueueRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourse(BaseModel<?> oldModel) {
		CourseClp oldClpModel = (CourseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEnrollmentSeat(BaseModel<?> oldModel) {
		EnrollmentSeatClp oldClpModel = (EnrollmentSeatClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEnrollmentSeatRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSubmission(BaseModel<?> oldModel) {
		SubmissionClp oldClpModel = (SubmissionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSubmissionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSubmissionVersion(BaseModel<?> oldModel) {
		SubmissionVersionClp oldClpModel = (SubmissionVersionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSubmissionVersionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTodo(BaseModel<?> oldModel) {
		TodoClp oldClpModel = (TodoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTodoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserAward(BaseModel<?> oldModel) {
		UserAwardClp oldClpModel = (UserAwardClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserAwardRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.ActivityStreamImpl")) {
			return translateOutputActivityStream(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.AssignmentImpl")) {
			return translateOutputAssignment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.AwardImpl")) {
			return translateOutputAward(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.CanvasAccountImpl")) {
			return translateOutputCanvasAccount(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.CanvasEnrollmentImpl")) {
			return translateOutputCanvasEnrollment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.CanvasUserImpl")) {
			return translateOutputCanvasUser(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.CertLetterQueueImpl")) {
			return translateOutputCertLetterQueue(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.CourseImpl")) {
			return translateOutputCourse(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.EnrollmentSeatImpl")) {
			return translateOutputEnrollmentSeat(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.SubmissionImpl")) {
			return translateOutputSubmission(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.SubmissionVersionImpl")) {
			return translateOutputSubmissionVersion(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.TodoImpl")) {
			return translateOutputTodo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.instructure.canvas.model.impl.UserAwardImpl")) {
			return translateOutputUserAward(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.instructure.canvas.NoSuchActivityStreamException")) {
			return new com.instructure.canvas.NoSuchActivityStreamException();
		}

		if (className.equals("com.instructure.canvas.NoSuchAssignmentException")) {
			return new com.instructure.canvas.NoSuchAssignmentException();
		}

		if (className.equals("com.instructure.canvas.NoSuchAwardException")) {
			return new com.instructure.canvas.NoSuchAwardException();
		}

		if (className.equals(
					"com.instructure.canvas.NoSuchCanvasAccountException")) {
			return new com.instructure.canvas.NoSuchCanvasAccountException();
		}

		if (className.equals(
					"com.instructure.canvas.NoSuchCanvasEnrollmentException")) {
			return new com.instructure.canvas.NoSuchCanvasEnrollmentException();
		}

		if (className.equals("com.instructure.canvas.NoSuchCanvasUserException")) {
			return new com.instructure.canvas.NoSuchCanvasUserException();
		}

		if (className.equals(
					"com.instructure.canvas.NoSuchCertLetterQueueException")) {
			return new com.instructure.canvas.NoSuchCertLetterQueueException();
		}

		if (className.equals("com.instructure.canvas.NoSuchCourseException")) {
			return new com.instructure.canvas.NoSuchCourseException();
		}

		if (className.equals(
					"com.instructure.canvas.NoSuchEnrollmentSeatException")) {
			return new com.instructure.canvas.NoSuchEnrollmentSeatException();
		}

		if (className.equals("com.instructure.canvas.NoSuchSubmissionException")) {
			return new com.instructure.canvas.NoSuchSubmissionException();
		}

		if (className.equals(
					"com.instructure.canvas.NoSuchSubmissionVersionException")) {
			return new com.instructure.canvas.NoSuchSubmissionVersionException();
		}

		if (className.equals("com.instructure.canvas.NoSuchTodoException")) {
			return new com.instructure.canvas.NoSuchTodoException();
		}

		if (className.equals("com.instructure.canvas.NoSuchUserAwardException")) {
			return new com.instructure.canvas.NoSuchUserAwardException();
		}

		return throwable;
	}

	public static Object translateOutputActivityStream(BaseModel<?> oldModel) {
		ActivityStreamClp newModel = new ActivityStreamClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setActivityStreamRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAssignment(BaseModel<?> oldModel) {
		AssignmentClp newModel = new AssignmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAssignmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAward(BaseModel<?> oldModel) {
		AwardClp newModel = new AwardClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAwardRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCanvasAccount(BaseModel<?> oldModel) {
		CanvasAccountClp newModel = new CanvasAccountClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCanvasAccountRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCanvasEnrollment(BaseModel<?> oldModel) {
		CanvasEnrollmentClp newModel = new CanvasEnrollmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCanvasEnrollmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCanvasUser(BaseModel<?> oldModel) {
		CanvasUserClp newModel = new CanvasUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCanvasUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCertLetterQueue(BaseModel<?> oldModel) {
		CertLetterQueueClp newModel = new CertLetterQueueClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCertLetterQueueRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourse(BaseModel<?> oldModel) {
		CourseClp newModel = new CourseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEnrollmentSeat(BaseModel<?> oldModel) {
		EnrollmentSeatClp newModel = new EnrollmentSeatClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEnrollmentSeatRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSubmission(BaseModel<?> oldModel) {
		SubmissionClp newModel = new SubmissionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSubmissionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSubmissionVersion(BaseModel<?> oldModel) {
		SubmissionVersionClp newModel = new SubmissionVersionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSubmissionVersionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTodo(BaseModel<?> oldModel) {
		TodoClp newModel = new TodoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTodoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserAward(BaseModel<?> oldModel) {
		UserAwardClp newModel = new UserAwardClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserAwardRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}