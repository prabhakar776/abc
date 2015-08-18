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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Course. This utility wraps
 * {@link com.instructure.canvas.service.impl.CourseServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CourseService
 * @see com.instructure.canvas.service.base.CourseServiceBaseImpl
 * @see com.instructure.canvas.service.impl.CourseServiceImpl
 * @generated
 */
public class CourseServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.instructure.canvas.service.impl.CourseServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.lang.String createCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String longName,
		java.lang.String accountId, java.lang.String termId,
		java.lang.String status, java.lang.String netacadCoreOfferingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .createCourse(courseId, shortName, longName, accountId,
			termId, status, netacadCoreOfferingId);
	}

	public static java.lang.String createCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String longName,
		java.lang.String accountId, java.lang.String termId,
		java.lang.String status, java.lang.String netacadCoreOfferingId,
		int startYear, int startMonth, int startDay, int concludeYear,
		int concludeMonth, int concludeDay, java.lang.String timeZoneId,
		boolean enforceDates)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .createCourse(courseId, shortName, longName, accountId,
			termId, status, netacadCoreOfferingId, startYear, startMonth,
			startDay, concludeYear, concludeMonth, concludeDay, timeZoneId,
			enforceDates);
	}

	public static com.instructure.canvas.model.Course getCourseByOID(
		java.lang.String oid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourseByOID(oid);
	}

	public static com.instructure.canvas.model.Course getCourseById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourseById(id);
	}

	public static java.util.List<com.instructure.canvas.model.Course> getCoursesByCVLId(
		java.util.List<java.lang.String> cvlIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoursesByCVLId(cvlIds);
	}

	public static void updateCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String courseCode, int startDay,
		int startMonth, int startYear, int concludeDay, int concludeMonth,
		int concludeYear, java.lang.String timeZoneId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateCourse(courseId, shortName, courseCode, startDay,
			startMonth, startYear, concludeDay, concludeMonth, concludeYear,
			timeZoneId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CourseService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CourseService.class.getName());

			if (invokableService instanceof CourseService) {
				_service = (CourseService)invokableService;
			}
			else {
				_service = new CourseServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(CourseServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CourseService service) {
	}

	private static CourseService _service;
}