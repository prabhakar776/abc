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
 * Provides the remote service utility for CanvasUser. This utility wraps
 * {@link com.instructure.canvas.service.impl.CanvasUserServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasUserService
 * @see com.instructure.canvas.service.base.CanvasUserServiceBaseImpl
 * @see com.instructure.canvas.service.impl.CanvasUserServiceImpl
 * @generated
 */
public class CanvasUserServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.instructure.canvas.service.impl.CanvasUserServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.lang.String getNineDigitId(java.lang.String canvasUserId) {
		return getService().getNineDigitId(canvasUserId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getJSONNineDigitId(
		java.lang.String canvasUserId) {
		return getService().getJSONNineDigitId(canvasUserId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CanvasUserService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CanvasUserService.class.getName());

			if (invokableService instanceof CanvasUserService) {
				_service = (CanvasUserService)invokableService;
			}
			else {
				_service = new CanvasUserServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(CanvasUserServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CanvasUserService service) {
	}

	private static CanvasUserService _service;
}