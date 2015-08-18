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
 * Provides a wrapper for {@link CertLetterQueueService}.
 *
 * @author Brian Wing Shun Chan
 * @see CertLetterQueueService
 * @generated
 */
public class CertLetterQueueServiceWrapper implements CertLetterQueueService,
	ServiceWrapper<CertLetterQueueService> {
	public CertLetterQueueServiceWrapper(
		CertLetterQueueService certLetterQueueService) {
		_certLetterQueueService = certLetterQueueService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _certLetterQueueService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_certLetterQueueService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _certLetterQueueService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> getCertLetterStatusByCourseIdUserId(
		long courseId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _certLetterQueueService.getCertLetterStatusByCourseIdUserId(courseId,
			userId);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> getByCourseIdStatusCreatedByAndType(
		long courseId, java.lang.String status, long userId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _certLetterQueueService.getByCourseIdStatusCreatedByAndType(courseId,
			status, userId, type);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CertLetterQueueService getWrappedCertLetterQueueService() {
		return _certLetterQueueService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCertLetterQueueService(
		CertLetterQueueService certLetterQueueService) {
		_certLetterQueueService = certLetterQueueService;
	}

	@Override
	public CertLetterQueueService getWrappedService() {
		return _certLetterQueueService;
	}

	@Override
	public void setWrappedService(CertLetterQueueService certLetterQueueService) {
		_certLetterQueueService = certLetterQueueService;
	}

	private CertLetterQueueService _certLetterQueueService;
}