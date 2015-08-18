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
 * Provides a wrapper for {@link UserAwardService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserAwardService
 * @generated
 */
public class UserAwardServiceWrapper implements UserAwardService,
	ServiceWrapper<UserAwardService> {
	public UserAwardServiceWrapper(UserAwardService userAwardService) {
		_userAwardService = userAwardService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userAwardService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userAwardService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userAwardService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.instructure.canvas.model.UserAward getCertificate(
		long canvasUserId, long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAwardService.getCertificate(canvasUserId, courseId);
	}

	@Override
	public com.instructure.canvas.model.UserAward getLetter(long canvasUserId,
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAwardService.getLetter(canvasUserId, courseId);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.UserAward> findByCanvasUserId(
		long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAwardService.findByCanvasUserId(canvasUserId);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.UserAward> mergeUserAwards(
		long companyId, long fromCanvasUserId, long toCanvasUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userAwardService.mergeUserAwards(companyId, fromCanvasUserId,
			toCanvasUserId);
	}

	@Override
	public com.instructure.canvas.model.UserAward updateUserAward(
		com.instructure.canvas.model.UserAward userAward)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAwardService.updateUserAward(userAward);
	}

	@Override
	public com.instructure.canvas.model.UserAward fetchByCourseId(
		long courseId, long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAwardService.fetchByCourseId(courseId, canvasUserId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserAwardService getWrappedUserAwardService() {
		return _userAwardService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserAwardService(UserAwardService userAwardService) {
		_userAwardService = userAwardService;
	}

	@Override
	public UserAwardService getWrappedService() {
		return _userAwardService;
	}

	@Override
	public void setWrappedService(UserAwardService userAwardService) {
		_userAwardService = userAwardService;
	}

	private UserAwardService _userAwardService;
}