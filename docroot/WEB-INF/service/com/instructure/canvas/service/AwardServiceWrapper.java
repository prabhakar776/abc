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
 * Provides a wrapper for {@link AwardService}.
 *
 * @author Brian Wing Shun Chan
 * @see AwardService
 * @generated
 */
public class AwardServiceWrapper implements AwardService,
	ServiceWrapper<AwardService> {
	public AwardServiceWrapper(AwardService awardService) {
		_awardService = awardService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _awardService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_awardService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _awardService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.instructure.canvas.model.Award addAward(java.lang.String cvlId,
		java.lang.String cvlName, double score, long certificateArticleId,
		long letterArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardService.addAward(cvlId, cvlName, score,
			certificateArticleId, letterArticleId);
	}

	@Override
	public void deactivateAward(long awardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_awardService.deactivateAward(awardId);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.Award> getActiveAwards()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardService.getActiveAwards();
	}

	@Override
	public com.instructure.canvas.model.Award getAwardByCVLId(
		java.lang.String cvlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardService.getAwardByCVLId(cvlId);
	}

	@Override
	public com.instructure.canvas.model.Award getAwardByCVLName(
		java.lang.String cvlName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardService.getAwardByCVLName(cvlName);
	}

	@Override
	public java.io.File getCertificate(long canvasUserId, long courseId,
		java.util.Map<java.lang.String, java.lang.String> variables,
		java.lang.String languageId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _awardService.getCertificate(canvasUserId, courseId, variables,
			languageId, themeDisplay);
	}

	@Override
	public java.io.File getLetter(long canvasUserId, long courseId,
		java.util.Map<java.lang.String, java.lang.String> variables,
		java.lang.String languageId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _awardService.getLetter(canvasUserId, courseId, variables,
			languageId, themeDisplay);
	}

	@Override
	public com.instructure.canvas.model.Award getAward(long awardId,
		java.lang.String cvlId) {
		return _awardService.getAward(awardId, cvlId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AwardService getWrappedAwardService() {
		return _awardService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAwardService(AwardService awardService) {
		_awardService = awardService;
	}

	@Override
	public AwardService getWrappedService() {
		return _awardService;
	}

	@Override
	public void setWrappedService(AwardService awardService) {
		_awardService = awardService;
	}

	private AwardService _awardService;
}