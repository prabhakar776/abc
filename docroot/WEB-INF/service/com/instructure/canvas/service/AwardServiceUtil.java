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
 * Provides the remote service utility for Award. This utility wraps
 * {@link com.instructure.canvas.service.impl.AwardServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AwardService
 * @see com.instructure.canvas.service.base.AwardServiceBaseImpl
 * @see com.instructure.canvas.service.impl.AwardServiceImpl
 * @generated
 */
public class AwardServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.instructure.canvas.service.impl.AwardServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.instructure.canvas.model.Award addAward(
		java.lang.String cvlId, java.lang.String cvlName, double score,
		long certificateArticleId, long letterArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAward(cvlId, cvlName, score, certificateArticleId,
			letterArticleId);
	}

	public static void deactivateAward(long awardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deactivateAward(awardId);
	}

	public static java.util.List<com.instructure.canvas.model.Award> getActiveAwards()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActiveAwards();
	}

	public static com.instructure.canvas.model.Award getAwardByCVLId(
		java.lang.String cvlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAwardByCVLId(cvlId);
	}

	public static com.instructure.canvas.model.Award getAwardByCVLName(
		java.lang.String cvlName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAwardByCVLName(cvlName);
	}

	public static java.io.File getCertificate(long canvasUserId, long courseId,
		java.util.Map<java.lang.String, java.lang.String> variables,
		java.lang.String languageId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .getCertificate(canvasUserId, courseId, variables,
			languageId, themeDisplay);
	}

	public static java.io.File getLetter(long canvasUserId, long courseId,
		java.util.Map<java.lang.String, java.lang.String> variables,
		java.lang.String languageId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .getLetter(canvasUserId, courseId, variables, languageId,
			themeDisplay);
	}

	public static com.instructure.canvas.model.Award getAward(long awardId,
		java.lang.String cvlId) {
		return getService().getAward(awardId, cvlId);
	}

	public static void clearService() {
		_service = null;
	}

	public static AwardService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AwardService.class.getName());

			if (invokableService instanceof AwardService) {
				_service = (AwardService)invokableService;
			}
			else {
				_service = new AwardServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(AwardServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AwardService service) {
	}

	private static AwardService _service;
}