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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CanvasEnrollmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasEnrollmentService
 * @generated
 */
public class CanvasEnrollmentServiceWrapper implements CanvasEnrollmentService,
	ServiceWrapper<CanvasEnrollmentService> {
	public CanvasEnrollmentServiceWrapper(
		CanvasEnrollmentService canvasEnrollmentService) {
		_canvasEnrollmentService = canvasEnrollmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _canvasEnrollmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_canvasEnrollmentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _canvasEnrollmentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CanvasEnrollmentService getWrappedCanvasEnrollmentService() {
		return _canvasEnrollmentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCanvasEnrollmentService(
		CanvasEnrollmentService canvasEnrollmentService) {
		_canvasEnrollmentService = canvasEnrollmentService;
	}

	@Override
	public CanvasEnrollmentService getWrappedService() {
		return _canvasEnrollmentService;
	}

	@Override
	public void setWrappedService(
		CanvasEnrollmentService canvasEnrollmentService) {
		_canvasEnrollmentService = canvasEnrollmentService;
	}

	private CanvasEnrollmentService _canvasEnrollmentService;
}