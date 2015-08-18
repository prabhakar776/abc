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
 * Provides a wrapper for {@link SubmissionVersionService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionVersionService
 * @generated
 */
public class SubmissionVersionServiceWrapper implements SubmissionVersionService,
	ServiceWrapper<SubmissionVersionService> {
	public SubmissionVersionServiceWrapper(
		SubmissionVersionService submissionVersionService) {
		_submissionVersionService = submissionVersionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _submissionVersionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_submissionVersionService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _submissionVersionService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubmissionVersionService getWrappedSubmissionVersionService() {
		return _submissionVersionService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubmissionVersionService(
		SubmissionVersionService submissionVersionService) {
		_submissionVersionService = submissionVersionService;
	}

	@Override
	public SubmissionVersionService getWrappedService() {
		return _submissionVersionService;
	}

	@Override
	public void setWrappedService(
		SubmissionVersionService submissionVersionService) {
		_submissionVersionService = submissionVersionService;
	}

	private SubmissionVersionService _submissionVersionService;
}