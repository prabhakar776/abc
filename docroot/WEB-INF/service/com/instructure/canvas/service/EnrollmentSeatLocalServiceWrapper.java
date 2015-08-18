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
 * Provides a wrapper for {@link EnrollmentSeatLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EnrollmentSeatLocalService
 * @generated
 */
public class EnrollmentSeatLocalServiceWrapper
	implements EnrollmentSeatLocalService,
		ServiceWrapper<EnrollmentSeatLocalService> {
	public EnrollmentSeatLocalServiceWrapper(
		EnrollmentSeatLocalService enrollmentSeatLocalService) {
		_enrollmentSeatLocalService = enrollmentSeatLocalService;
	}

	/**
	* Adds the enrollment seat to the database. Also notifies the appropriate model listeners.
	*
	* @param enrollmentSeat the enrollment seat
	* @return the enrollment seat that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.EnrollmentSeat addEnrollmentSeat(
		com.instructure.canvas.model.EnrollmentSeat enrollmentSeat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.addEnrollmentSeat(enrollmentSeat);
	}

	/**
	* Creates a new enrollment seat with the primary key. Does not add the enrollment seat to the database.
	*
	* @param id the primary key for the new enrollment seat
	* @return the new enrollment seat
	*/
	@Override
	public com.instructure.canvas.model.EnrollmentSeat createEnrollmentSeat(
		long id) {
		return _enrollmentSeatLocalService.createEnrollmentSeat(id);
	}

	/**
	* Deletes the enrollment seat with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the enrollment seat
	* @return the enrollment seat that was removed
	* @throws PortalException if a enrollment seat with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.EnrollmentSeat deleteEnrollmentSeat(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.deleteEnrollmentSeat(id);
	}

	/**
	* Deletes the enrollment seat from the database. Also notifies the appropriate model listeners.
	*
	* @param enrollmentSeat the enrollment seat
	* @return the enrollment seat that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.EnrollmentSeat deleteEnrollmentSeat(
		com.instructure.canvas.model.EnrollmentSeat enrollmentSeat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.deleteEnrollmentSeat(enrollmentSeat);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _enrollmentSeatLocalService.dynamicQuery();
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
		return _enrollmentSeatLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.EnrollmentSeatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _enrollmentSeatLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.EnrollmentSeatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _enrollmentSeatLocalService.dynamicQuery(dynamicQuery, start,
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
		return _enrollmentSeatLocalService.dynamicQueryCount(dynamicQuery);
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
		return _enrollmentSeatLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.instructure.canvas.model.EnrollmentSeat fetchEnrollmentSeat(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.fetchEnrollmentSeat(id);
	}

	/**
	* Returns the enrollment seat with the primary key.
	*
	* @param id the primary key of the enrollment seat
	* @return the enrollment seat
	* @throws PortalException if a enrollment seat with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.EnrollmentSeat getEnrollmentSeat(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.getEnrollmentSeat(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the enrollment seats.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.EnrollmentSeatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enrollment seats
	* @param end the upper bound of the range of enrollment seats (not inclusive)
	* @return the range of enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.instructure.canvas.model.EnrollmentSeat> getEnrollmentSeats(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.getEnrollmentSeats(start, end);
	}

	/**
	* Returns the number of enrollment seats.
	*
	* @return the number of enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEnrollmentSeatsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.getEnrollmentSeatsCount();
	}

	/**
	* Updates the enrollment seat in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param enrollmentSeat the enrollment seat
	* @return the enrollment seat that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.EnrollmentSeat updateEnrollmentSeat(
		com.instructure.canvas.model.EnrollmentSeat enrollmentSeat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.updateEnrollmentSeat(enrollmentSeat);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _enrollmentSeatLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_enrollmentSeatLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _enrollmentSeatLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.EnrollmentSeat> createEnrollmentSeats(
		int nSeats, java.lang.String rootAccountId, java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.createEnrollmentSeats(nSeats,
			rootAccountId, courseId);
	}

	@Override
	public com.instructure.canvas.model.EnrollmentSeat getEnrollmentSeat(
		java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.getEnrollmentSeat(token);
	}

	@Override
	public boolean isValidToken(java.lang.String token) {
		return _enrollmentSeatLocalService.isValidToken(token);
	}

	@Override
	public boolean claimEnrollmentSeat(java.lang.String token, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enrollmentSeatLocalService.claimEnrollmentSeat(token, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EnrollmentSeatLocalService getWrappedEnrollmentSeatLocalService() {
		return _enrollmentSeatLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEnrollmentSeatLocalService(
		EnrollmentSeatLocalService enrollmentSeatLocalService) {
		_enrollmentSeatLocalService = enrollmentSeatLocalService;
	}

	@Override
	public EnrollmentSeatLocalService getWrappedService() {
		return _enrollmentSeatLocalService;
	}

	@Override
	public void setWrappedService(
		EnrollmentSeatLocalService enrollmentSeatLocalService) {
		_enrollmentSeatLocalService = enrollmentSeatLocalService;
	}

	private EnrollmentSeatLocalService _enrollmentSeatLocalService;
}