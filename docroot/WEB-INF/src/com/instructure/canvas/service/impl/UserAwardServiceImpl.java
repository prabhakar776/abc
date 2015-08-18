/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.instructure.canvas.service.impl;

import java.util.List;

import com.instructure.canvas.model.UserAward;
import com.instructure.canvas.service.base.UserAwardServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.ac.AccessControlled;

/**
 * The implementation of the user award remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.UserAwardService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.UserAwardServiceBaseImpl
 * @see com.instructure.canvas.service.UserAwardServiceUtil
 */
public class UserAwardServiceImpl extends UserAwardServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.UserAwardServiceUtil} to access the user award remote service.
	 */
	
	@AccessControlled(guestAccessEnabled = false)
	public UserAward getCertificate(long canvasUserId, long courseId) 
			throws SystemException{
		return userAwardLocalService.getCertificate(canvasUserId, courseId);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public UserAward getLetter(long canvasUserId, long courseId) 
			throws SystemException{
		return userAwardLocalService.getLetter(canvasUserId, courseId);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public List<UserAward> findByCanvasUserId(long canvasUserId)
			throws SystemException {
		return userAwardLocalService.findByCanvasUserId(canvasUserId);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public List<UserAward> mergeUserAwards(long companyId, long fromCanvasUserId, long toCanvasUserId) throws SystemException, PortalException {
		return userAwardLocalService.mergeUserAwards(companyId, fromCanvasUserId, toCanvasUserId);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public UserAward updateUserAward(UserAward userAward)
			throws SystemException {
		return userAwardLocalService.updateUserAward(userAward);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public UserAward fetchByCourseId(long courseId, long canvasUserId)
			throws SystemException {
		return userAwardLocalService.fetchByCourseId(courseId, canvasUserId);
	}
}