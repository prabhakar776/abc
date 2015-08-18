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
 * Provides a wrapper for {@link ActivityStreamService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityStreamService
 * @generated
 */
public class ActivityStreamServiceWrapper implements ActivityStreamService,
	ServiceWrapper<ActivityStreamService> {
	public ActivityStreamServiceWrapper(
		ActivityStreamService activityStreamService) {
		_activityStreamService = activityStreamService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _activityStreamService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_activityStreamService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _activityStreamService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ActivityStreamService getWrappedActivityStreamService() {
		return _activityStreamService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedActivityStreamService(
		ActivityStreamService activityStreamService) {
		_activityStreamService = activityStreamService;
	}

	@Override
	public ActivityStreamService getWrappedService() {
		return _activityStreamService;
	}

	@Override
	public void setWrappedService(ActivityStreamService activityStreamService) {
		_activityStreamService = activityStreamService;
	}

	private ActivityStreamService _activityStreamService;
}