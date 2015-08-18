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

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.instructure.canvas.model.Award;
import com.instructure.canvas.service.base.AwardServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * The implementation of the award remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.AwardService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.AwardServiceBaseImpl
 * @see com.instructure.canvas.service.AwardServiceUtil
 */
public class AwardServiceImpl extends AwardServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.AwardServiceUtil} to access the award remote service.
	 */
	
	@AccessControlled(guestAccessEnabled = false)
	public Award addAward(String cvlId, String cvlName, double score,
			long certificateArticleId, long letterArticleId)
			throws SystemException {
		return awardLocalService.addAward(cvlId, cvlName, score, certificateArticleId, letterArticleId);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public void deactivateAward(long awardId) throws SystemException, PortalException {
		awardLocalService.deactivateAward(awardId);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public List<Award> getActiveAwards() throws SystemException {
		return awardLocalService.getActiveAwards();
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public Award getAwardByCVLId(String cvlId) throws SystemException {
		return awardLocalService.getAwardByCVLId(cvlId);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public Award getAwardByCVLName(String cvlName) throws SystemException {
		return awardLocalService.getAwardByCVLName(cvlName);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public File getCertificate(
			long canvasUserId, long courseId, Map<String, String> variables,
			String languageId, ThemeDisplay themeDisplay)
			throws SystemException, PortalException, IOException {
		return awardLocalService.getCertificate(canvasUserId, courseId, variables, languageId, themeDisplay);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public File getLetter(
			long canvasUserId, long courseId, Map<String, String> variables,
			String languageId, ThemeDisplay themeDisplay)
			throws SystemException, PortalException, IOException {
		return awardLocalService.getLetter(canvasUserId, courseId, variables, languageId, themeDisplay);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public Award getAward(long awardId, String cvlId){
		return awardLocalService.getAward(awardId, cvlId);
	}
}