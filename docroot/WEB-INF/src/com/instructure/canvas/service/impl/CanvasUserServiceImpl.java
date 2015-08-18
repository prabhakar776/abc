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

import com.cisco.utility.constants.CiscoConstants;
import com.cisco.utility.service.UtilityLocalServiceUtil;
import com.instructure.canvas.service.base.CanvasUserServiceBaseImpl;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;


/**
 * The implementation of the canvas user remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.CanvasUserService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.CanvasUserServiceBaseImpl
 * @see com.instructure.canvas.service.CanvasUserServiceUtil
 */
public class CanvasUserServiceImpl extends CanvasUserServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.CanvasUserServiceUtil} to access the canvas user remote service.
	 */

	public String getNineDigitId(String canvasUserId) {
		try {
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();

			long userId = UtilityLocalServiceUtil.getEntityId(companyId, User.class.getName(), CiscoConstants.EXPANDO_CANVAS_USER_ID, canvasUserId);

			return UtilityLocalServiceUtil.getExpandoValue(companyId, User.class.getName(), CiscoConstants.EXPANDO_CNAMS_USER_ID, userId);
		} catch (NoSuchUserException nsue) {
			return "-1";
		} catch (SystemException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
			return "-1";
		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
			return "-1";
		}
	}

	public JSONObject getJSONNineDigitId(String canvasUserId) {
		try {
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();

			long userId = UtilityLocalServiceUtil.getEntityId(companyId, User.class.getName(), CiscoConstants.EXPANDO_CANVAS_USER_ID, canvasUserId);

			String netacadId = UtilityLocalServiceUtil.getExpandoValue(companyId, User.class.getName(), CiscoConstants.EXPANDO_CNAMS_USER_ID, userId);

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("id", netacadId);

			return jsonObject;
		} catch (NoSuchUserException nsue) {
			return JSONFactoryUtil.createJSONObject();
		} catch (SystemException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
			return JSONFactoryUtil.createJSONObject();
		} catch (PortalException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
			return JSONFactoryUtil.createJSONObject();
		}
	}


	private static Log _log = LogFactoryUtil.getLog(CourseServiceImpl.class);
}