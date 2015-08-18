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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for UserAward. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserAwardServiceUtil
 * @see com.instructure.canvas.service.base.UserAwardServiceBaseImpl
 * @see com.instructure.canvas.service.impl.UserAwardServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface UserAwardService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserAwardServiceUtil} to access the user award remote service. Add custom service methods to {@link com.instructure.canvas.service.impl.UserAwardServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = false)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.instructure.canvas.model.UserAward getCertificate(
		long canvasUserId, long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = false)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.instructure.canvas.model.UserAward getLetter(long canvasUserId,
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = false)
	public java.util.List<com.instructure.canvas.model.UserAward> findByCanvasUserId(
		long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = false)
	public java.util.List<com.instructure.canvas.model.UserAward> mergeUserAwards(
		long companyId, long fromCanvasUserId, long toCanvasUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = false)
	public com.instructure.canvas.model.UserAward updateUserAward(
		com.instructure.canvas.model.UserAward userAward)
		throws com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = false)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.instructure.canvas.model.UserAward fetchByCourseId(
		long courseId, long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException;
}