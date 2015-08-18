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
 * Provides a wrapper for {@link CanvasCourseCopyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasCourseCopyLocalService
 * @generated
 */
public class CanvasCourseCopyLocalServiceWrapper
	implements CanvasCourseCopyLocalService,
		ServiceWrapper<CanvasCourseCopyLocalService> {
	public CanvasCourseCopyLocalServiceWrapper(
		CanvasCourseCopyLocalService canvasCourseCopyLocalService) {
		_canvasCourseCopyLocalService = canvasCourseCopyLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _canvasCourseCopyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_canvasCourseCopyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _canvasCourseCopyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void copyCourse(java.lang.String sourceCourseId,
		java.lang.String newCourseId) throws java.io.IOException {
		_canvasCourseCopyLocalService.copyCourse(sourceCourseId, newCourseId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CanvasCourseCopyLocalService getWrappedCanvasCourseCopyLocalService() {
		return _canvasCourseCopyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCanvasCourseCopyLocalService(
		CanvasCourseCopyLocalService canvasCourseCopyLocalService) {
		_canvasCourseCopyLocalService = canvasCourseCopyLocalService;
	}

	@Override
	public CanvasCourseCopyLocalService getWrappedService() {
		return _canvasCourseCopyLocalService;
	}

	@Override
	public void setWrappedService(
		CanvasCourseCopyLocalService canvasCourseCopyLocalService) {
		_canvasCourseCopyLocalService = canvasCourseCopyLocalService;
	}

	private CanvasCourseCopyLocalService _canvasCourseCopyLocalService;
}