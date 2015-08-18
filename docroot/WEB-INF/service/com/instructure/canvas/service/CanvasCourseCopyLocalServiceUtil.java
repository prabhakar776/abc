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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CanvasCourseCopy. This utility wraps
 * {@link com.instructure.canvas.service.impl.CanvasCourseCopyLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasCourseCopyLocalService
 * @see com.instructure.canvas.service.base.CanvasCourseCopyLocalServiceBaseImpl
 * @see com.instructure.canvas.service.impl.CanvasCourseCopyLocalServiceImpl
 * @generated
 */
public class CanvasCourseCopyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.instructure.canvas.service.impl.CanvasCourseCopyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static void copyCourse(java.lang.String sourceCourseId,
		java.lang.String newCourseId) throws java.io.IOException {
		getService().copyCourse(sourceCourseId, newCourseId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CanvasCourseCopyLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CanvasCourseCopyLocalService.class.getName());

			if (invokableLocalService instanceof CanvasCourseCopyLocalService) {
				_service = (CanvasCourseCopyLocalService)invokableLocalService;
			}
			else {
				_service = new CanvasCourseCopyLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CanvasCourseCopyLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CanvasCourseCopyLocalService service) {
	}

	private static CanvasCourseCopyLocalService _service;
}