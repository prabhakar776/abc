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
 * Provides a wrapper for {@link CanvasUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasUserService
 * @generated
 */
public class CanvasUserServiceWrapper implements CanvasUserService,
	ServiceWrapper<CanvasUserService> {
	public CanvasUserServiceWrapper(CanvasUserService canvasUserService) {
		_canvasUserService = canvasUserService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _canvasUserService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_canvasUserService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _canvasUserService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String getNineDigitId(java.lang.String canvasUserId) {
		return _canvasUserService.getNineDigitId(canvasUserId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getJSONNineDigitId(
		java.lang.String canvasUserId) {
		return _canvasUserService.getJSONNineDigitId(canvasUserId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CanvasUserService getWrappedCanvasUserService() {
		return _canvasUserService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCanvasUserService(CanvasUserService canvasUserService) {
		_canvasUserService = canvasUserService;
	}

	@Override
	public CanvasUserService getWrappedService() {
		return _canvasUserService;
	}

	@Override
	public void setWrappedService(CanvasUserService canvasUserService) {
		_canvasUserService = canvasUserService;
	}

	private CanvasUserService _canvasUserService;
}