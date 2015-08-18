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
 * Provides a wrapper for {@link AssignmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentService
 * @generated
 */
public class AssignmentServiceWrapper implements AssignmentService,
	ServiceWrapper<AssignmentService> {
	public AssignmentServiceWrapper(AssignmentService assignmentService) {
		_assignmentService = assignmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _assignmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_assignmentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _assignmentService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AssignmentService getWrappedAssignmentService() {
		return _assignmentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAssignmentService(AssignmentService assignmentService) {
		_assignmentService = assignmentService;
	}

	@Override
	public AssignmentService getWrappedService() {
		return _assignmentService;
	}

	@Override
	public void setWrappedService(AssignmentService assignmentService) {
		_assignmentService = assignmentService;
	}

	private AssignmentService _assignmentService;
}