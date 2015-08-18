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

import java.io.IOException;
import java.util.List;

import com.instructure.canvas.model.CertLetterQueue;
import com.instructure.canvas.service.base.CertLetterQueueServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.ac.AccessControlled;

/**
 * The implementation of the cert letter queue remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.CertLetterQueueService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.CertLetterQueueServiceBaseImpl
 * @see com.instructure.canvas.service.CertLetterQueueServiceUtil
 */
public class CertLetterQueueServiceImpl extends CertLetterQueueServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.CertLetterQueueServiceUtil} to access the cert letter queue remote service.
	 */
	
	@AccessControlled(guestAccessEnabled = false)
	public List<CertLetterQueue> getCertLetterStatusByCourseIdUserId(
			long courseId, long userId) throws IOException, SystemException {
		return certLetterQueueLocalService.getCertLetterStatusByCourseIdUserId(courseId, userId);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public List<CertLetterQueue> getByCourseIdStatusCreatedByAndType(
			long courseId, String status, long userId, String type)
			throws IOException, SystemException {
		return certLetterQueueLocalService.getByCourseIdStatusCreatedByAndType(courseId, status, userId, type);
	}
	
	
}