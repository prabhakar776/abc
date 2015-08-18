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
 * Provides the remote service utility for UserAward. This utility wraps
 * {@link com.instructure.canvas.service.impl.UserAwardServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserAwardService
 * @see com.instructure.canvas.service.base.UserAwardServiceBaseImpl
 * @see com.instructure.canvas.service.impl.UserAwardServiceImpl
 * @generated
 */
public class UserAwardServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.instructure.canvas.service.impl.UserAwardServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.instructure.canvas.model.UserAward getCertificate(
		long canvasUserId, long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCertificate(canvasUserId, courseId);
	}

	public static com.instructure.canvas.model.UserAward getLetter(
		long canvasUserId, long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLetter(canvasUserId, courseId);
	}

	public static java.util.List<com.instructure.canvas.model.UserAward> findByCanvasUserId(
		long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCanvasUserId(canvasUserId);
	}

	public static java.util.List<com.instructure.canvas.model.UserAward> mergeUserAwards(
		long companyId, long fromCanvasUserId, long toCanvasUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .mergeUserAwards(companyId, fromCanvasUserId, toCanvasUserId);
	}

	public static com.instructure.canvas.model.UserAward updateUserAward(
		com.instructure.canvas.model.UserAward userAward)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserAward(userAward);
	}

	public static com.instructure.canvas.model.UserAward fetchByCourseId(
		long courseId, long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByCourseId(courseId, canvasUserId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserAwardService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserAwardService.class.getName());

			if (invokableService instanceof UserAwardService) {
				_service = (UserAwardService)invokableService;
			}
			else {
				_service = new UserAwardServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(UserAwardServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserAwardService service) {
	}

	private static UserAwardService _service;
}