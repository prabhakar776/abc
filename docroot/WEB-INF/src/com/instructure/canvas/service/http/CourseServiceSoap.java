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

package com.instructure.canvas.service.http;

import com.instructure.canvas.service.CourseServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.instructure.canvas.service.CourseServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.instructure.canvas.model.CourseSoap}.
 * If the method in the service utility returns a
 * {@link com.instructure.canvas.model.Course}, that is translated to a
 * {@link com.instructure.canvas.model.CourseSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseServiceHttp
 * @see com.instructure.canvas.model.CourseSoap
 * @see com.instructure.canvas.service.CourseServiceUtil
 * @generated
 */
public class CourseServiceSoap {
	public static java.lang.String createCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String longName,
		java.lang.String accountId, java.lang.String termId,
		java.lang.String status, java.lang.String netacadCoreOfferingId)
		throws RemoteException {
		try {
			java.lang.String returnValue = CourseServiceUtil.createCourse(courseId,
					shortName, longName, accountId, termId, status,
					netacadCoreOfferingId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String createCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String longName,
		java.lang.String accountId, java.lang.String termId,
		java.lang.String status, java.lang.String netacadCoreOfferingId,
		int startYear, int startMonth, int startDay, int concludeYear,
		int concludeMonth, int concludeDay, java.lang.String timeZoneId,
		boolean enforceDates) throws RemoteException {
		try {
			java.lang.String returnValue = CourseServiceUtil.createCourse(courseId,
					shortName, longName, accountId, termId, status,
					netacadCoreOfferingId, startYear, startMonth, startDay,
					concludeYear, concludeMonth, concludeDay, timeZoneId,
					enforceDates);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.instructure.canvas.model.CourseSoap getCourseByOID(
		java.lang.String oid) throws RemoteException {
		try {
			com.instructure.canvas.model.Course returnValue = CourseServiceUtil.getCourseByOID(oid);

			return com.instructure.canvas.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.instructure.canvas.model.CourseSoap getCourseById(long id)
		throws RemoteException {
		try {
			com.instructure.canvas.model.Course returnValue = CourseServiceUtil.getCourseById(id);

			return com.instructure.canvas.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.instructure.canvas.model.CourseSoap[] getCoursesByCVLId(
		java.util.List<java.lang.String> cvlIds) throws RemoteException {
		try {
			java.util.List<com.instructure.canvas.model.Course> returnValue = CourseServiceUtil.getCoursesByCVLId(cvlIds);

			return com.instructure.canvas.model.CourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void updateCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String courseCode, int startDay,
		int startMonth, int startYear, int concludeDay, int concludeMonth,
		int concludeYear, java.lang.String timeZoneId)
		throws RemoteException {
		try {
			CourseServiceUtil.updateCourse(courseId, shortName, courseCode,
				startDay, startMonth, startYear, concludeDay, concludeMonth,
				concludeYear, timeZoneId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CourseServiceSoap.class);
}