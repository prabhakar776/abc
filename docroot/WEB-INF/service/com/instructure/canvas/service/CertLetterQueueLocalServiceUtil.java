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
 * Provides the local service utility for CertLetterQueue. This utility wraps
 * {@link com.instructure.canvas.service.impl.CertLetterQueueLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CertLetterQueueLocalService
 * @see com.instructure.canvas.service.base.CertLetterQueueLocalServiceBaseImpl
 * @see com.instructure.canvas.service.impl.CertLetterQueueLocalServiceImpl
 * @generated
 */
public class CertLetterQueueLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.instructure.canvas.service.impl.CertLetterQueueLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cert letter queue to the database. Also notifies the appropriate model listeners.
	*
	* @param certLetterQueue the cert letter queue
	* @return the cert letter queue that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue addCertLetterQueue(
		com.instructure.canvas.model.CertLetterQueue certLetterQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCertLetterQueue(certLetterQueue);
	}

	/**
	* Creates a new cert letter queue with the primary key. Does not add the cert letter queue to the database.
	*
	* @param id the primary key for the new cert letter queue
	* @return the new cert letter queue
	*/
	public static com.instructure.canvas.model.CertLetterQueue createCertLetterQueue(
		long id) {
		return getService().createCertLetterQueue(id);
	}

	/**
	* Deletes the cert letter queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cert letter queue
	* @return the cert letter queue that was removed
	* @throws PortalException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue deleteCertLetterQueue(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCertLetterQueue(id);
	}

	/**
	* Deletes the cert letter queue from the database. Also notifies the appropriate model listeners.
	*
	* @param certLetterQueue the cert letter queue
	* @return the cert letter queue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue deleteCertLetterQueue(
		com.instructure.canvas.model.CertLetterQueue certLetterQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCertLetterQueue(certLetterQueue);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.instructure.canvas.model.CertLetterQueue fetchCertLetterQueue(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCertLetterQueue(id);
	}

	/**
	* Returns the cert letter queue with the primary key.
	*
	* @param id the primary key of the cert letter queue
	* @return the cert letter queue
	* @throws PortalException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue getCertLetterQueue(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCertLetterQueue(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cert letter queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @return the range of cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> getCertLetterQueues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCertLetterQueues(start, end);
	}

	/**
	* Returns the number of cert letter queues.
	*
	* @return the number of cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static int getCertLetterQueuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCertLetterQueuesCount();
	}

	/**
	* Updates the cert letter queue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param certLetterQueue the cert letter queue
	* @return the cert letter queue that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue updateCertLetterQueue(
		com.instructure.canvas.model.CertLetterQueue certLetterQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCertLetterQueue(certLetterQueue);
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

	public static boolean addCertLetter(long courseId, long userId,
		java.lang.String status, java.lang.String type)
		throws java.io.IOException {
		return getService().addCertLetter(courseId, userId, status, type);
	}

	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findEligibleEntries()
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService().findEligibleEntries();
	}

	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> getCertLetterStatus(
		long courseId, java.lang.String status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService().getCertLetterStatus(courseId, status, userId);
	}

	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> getCertLetterStatusByCourseIdUserId(
		long courseId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService().getCertLetterStatusByCourseIdUserId(courseId, userId);
	}

	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> getByCourseIdStatusCreatedByAndType(
		long courseId, java.lang.String status, long userId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .getByCourseIdStatusCreatedByAndType(courseId, status,
			userId, type);
	}

	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findEligibleEntriesToExpire()
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService().findEligibleEntriesToExpire();
	}

	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> getCertLetterBYCourseIdCreatedByAndStatusNotEqual(
		long courseId, long userId, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .getCertLetterBYCourseIdCreatedByAndStatusNotEqual(courseId,
			userId, status);
	}

	public static boolean regenerateCertLetter(long courseId, long userId,
		java.lang.String cmd)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService().regenerateCertLetter(courseId, userId, cmd);
	}

	public static void clearService() {
		_service = null;
	}

	public static CertLetterQueueLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CertLetterQueueLocalService.class.getName());

			if (invokableLocalService instanceof CertLetterQueueLocalService) {
				_service = (CertLetterQueueLocalService)invokableLocalService;
			}
			else {
				_service = new CertLetterQueueLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CertLetterQueueLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CertLetterQueueLocalService service) {
	}

	private static CertLetterQueueLocalService _service;
}