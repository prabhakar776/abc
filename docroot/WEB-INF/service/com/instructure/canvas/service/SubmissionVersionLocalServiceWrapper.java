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
 * Provides a wrapper for {@link SubmissionVersionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionVersionLocalService
 * @generated
 */
public class SubmissionVersionLocalServiceWrapper
	implements SubmissionVersionLocalService,
		ServiceWrapper<SubmissionVersionLocalService> {
	public SubmissionVersionLocalServiceWrapper(
		SubmissionVersionLocalService submissionVersionLocalService) {
		_submissionVersionLocalService = submissionVersionLocalService;
	}

	/**
	* Adds the submission version to the database. Also notifies the appropriate model listeners.
	*
	* @param submissionVersion the submission version
	* @return the submission version that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.SubmissionVersion addSubmissionVersion(
		com.instructure.canvas.model.SubmissionVersion submissionVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.addSubmissionVersion(submissionVersion);
	}

	/**
	* Creates a new submission version with the primary key. Does not add the submission version to the database.
	*
	* @param submissionId the primary key for the new submission version
	* @return the new submission version
	*/
	@Override
	public com.instructure.canvas.model.SubmissionVersion createSubmissionVersion(
		long submissionId) {
		return _submissionVersionLocalService.createSubmissionVersion(submissionId);
	}

	/**
	* Deletes the submission version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionId the primary key of the submission version
	* @return the submission version that was removed
	* @throws PortalException if a submission version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.SubmissionVersion deleteSubmissionVersion(
		long submissionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.deleteSubmissionVersion(submissionId);
	}

	/**
	* Deletes the submission version from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionVersion the submission version
	* @return the submission version that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.SubmissionVersion deleteSubmissionVersion(
		com.instructure.canvas.model.SubmissionVersion submissionVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.deleteSubmissionVersion(submissionVersion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _submissionVersionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.SubmissionVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.SubmissionVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.instructure.canvas.model.SubmissionVersion fetchSubmissionVersion(
		long submissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.fetchSubmissionVersion(submissionId);
	}

	/**
	* Returns the submission version with the primary key.
	*
	* @param submissionId the primary key of the submission version
	* @return the submission version
	* @throws PortalException if a submission version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.SubmissionVersion getSubmissionVersion(
		long submissionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.getSubmissionVersion(submissionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the submission versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.SubmissionVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submission versions
	* @param end the upper bound of the range of submission versions (not inclusive)
	* @return the range of submission versions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.instructure.canvas.model.SubmissionVersion> getSubmissionVersions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.getSubmissionVersions(start, end);
	}

	/**
	* Returns the number of submission versions.
	*
	* @return the number of submission versions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSubmissionVersionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.getSubmissionVersionsCount();
	}

	/**
	* Updates the submission version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param submissionVersion the submission version
	* @return the submission version that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.SubmissionVersion updateSubmissionVersion(
		com.instructure.canvas.model.SubmissionVersion submissionVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionVersionLocalService.updateSubmissionVersion(submissionVersion);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _submissionVersionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_submissionVersionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _submissionVersionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.SubmissionVersion> getSubmissionHistory(
		java.lang.String studentId, java.lang.String courseId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _submissionVersionLocalService.getSubmissionHistory(studentId,
			courseId);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.SubmissionVersion> getSubmissionHistory(
		java.util.List<java.lang.String> assignmentIds,
		java.lang.String courseId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _submissionVersionLocalService.getSubmissionHistory(assignmentIds,
			courseId);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.SubmissionVersion> getSubmissionHistory(
		java.lang.String studentId, java.lang.String assignmentId,
		java.lang.String courseId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _submissionVersionLocalService.getSubmissionHistory(studentId,
			assignmentId, courseId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubmissionVersionLocalService getWrappedSubmissionVersionLocalService() {
		return _submissionVersionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubmissionVersionLocalService(
		SubmissionVersionLocalService submissionVersionLocalService) {
		_submissionVersionLocalService = submissionVersionLocalService;
	}

	@Override
	public SubmissionVersionLocalService getWrappedService() {
		return _submissionVersionLocalService;
	}

	@Override
	public void setWrappedService(
		SubmissionVersionLocalService submissionVersionLocalService) {
		_submissionVersionLocalService = submissionVersionLocalService;
	}

	private SubmissionVersionLocalService _submissionVersionLocalService;
}