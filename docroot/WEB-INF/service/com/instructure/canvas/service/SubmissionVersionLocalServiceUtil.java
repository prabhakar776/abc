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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SubmissionVersion. This utility wraps
 * {@link com.instructure.canvas.service.impl.SubmissionVersionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionVersionLocalService
 * @see com.instructure.canvas.service.base.SubmissionVersionLocalServiceBaseImpl
 * @see com.instructure.canvas.service.impl.SubmissionVersionLocalServiceImpl
 * @generated
 */
public class SubmissionVersionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.instructure.canvas.service.impl.SubmissionVersionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the submission version to the database. Also notifies the appropriate model listeners.
	*
	* @param submissionVersion the submission version
	* @return the submission version that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.SubmissionVersion addSubmissionVersion(
		com.instructure.canvas.model.SubmissionVersion submissionVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSubmissionVersion(submissionVersion);
	}

	/**
	* Creates a new submission version with the primary key. Does not add the submission version to the database.
	*
	* @param submissionId the primary key for the new submission version
	* @return the new submission version
	*/
	public static com.instructure.canvas.model.SubmissionVersion createSubmissionVersion(
		long submissionId) {
		return getService().createSubmissionVersion(submissionId);
	}

	/**
	* Deletes the submission version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionId the primary key of the submission version
	* @return the submission version that was removed
	* @throws PortalException if a submission version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.SubmissionVersion deleteSubmissionVersion(
		long submissionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubmissionVersion(submissionId);
	}

	/**
	* Deletes the submission version from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionVersion the submission version
	* @return the submission version that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.SubmissionVersion deleteSubmissionVersion(
		com.instructure.canvas.model.SubmissionVersion submissionVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubmissionVersion(submissionVersion);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.instructure.canvas.model.SubmissionVersion fetchSubmissionVersion(
		long submissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSubmissionVersion(submissionId);
	}

	/**
	* Returns the submission version with the primary key.
	*
	* @param submissionId the primary key of the submission version
	* @return the submission version
	* @throws PortalException if a submission version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.SubmissionVersion getSubmissionVersion(
		long submissionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubmissionVersion(submissionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.instructure.canvas.model.SubmissionVersion> getSubmissionVersions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubmissionVersions(start, end);
	}

	/**
	* Returns the number of submission versions.
	*
	* @return the number of submission versions
	* @throws SystemException if a system exception occurred
	*/
	public static int getSubmissionVersionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubmissionVersionsCount();
	}

	/**
	* Updates the submission version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param submissionVersion the submission version
	* @return the submission version that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.SubmissionVersion updateSubmissionVersion(
		com.instructure.canvas.model.SubmissionVersion submissionVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSubmissionVersion(submissionVersion);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.instructure.canvas.model.SubmissionVersion> getSubmissionHistory(
		java.lang.String studentId, java.lang.String courseId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return getService().getSubmissionHistory(studentId, courseId);
	}

	public static java.util.List<com.instructure.canvas.model.SubmissionVersion> getSubmissionHistory(
		java.util.List<java.lang.String> assignmentIds,
		java.lang.String courseId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return getService().getSubmissionHistory(assignmentIds, courseId);
	}

	public static java.util.List<com.instructure.canvas.model.SubmissionVersion> getSubmissionHistory(
		java.lang.String studentId, java.lang.String assignmentId,
		java.lang.String courseId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return getService()
				   .getSubmissionHistory(studentId, assignmentId, courseId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SubmissionVersionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SubmissionVersionLocalService.class.getName());

			if (invokableLocalService instanceof SubmissionVersionLocalService) {
				_service = (SubmissionVersionLocalService)invokableLocalService;
			}
			else {
				_service = new SubmissionVersionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SubmissionVersionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SubmissionVersionLocalService service) {
	}

	private static SubmissionVersionLocalService _service;
}