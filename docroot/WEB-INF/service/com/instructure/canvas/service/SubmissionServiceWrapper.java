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
 * Provides a wrapper for {@link SubmissionService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionService
 * @generated
 */
public class SubmissionServiceWrapper implements SubmissionService,
	ServiceWrapper<SubmissionService> {
	public SubmissionServiceWrapper(SubmissionService submissionService) {
		_submissionService = submissionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _submissionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_submissionService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _submissionService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubmissionService getWrappedSubmissionService() {
		return _submissionService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubmissionService(SubmissionService submissionService) {
		_submissionService = submissionService;
	}

	@Override
	public SubmissionService getWrappedService() {
		return _submissionService;
	}

	@Override
	public void setWrappedService(SubmissionService submissionService) {
		_submissionService = submissionService;
	}

	private SubmissionService _submissionService;
}