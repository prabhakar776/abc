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

package com.instructure.canvas.service.persistence;

import com.instructure.canvas.model.EnrollmentSeat;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the enrollment seat service. This utility wraps {@link EnrollmentSeatPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnrollmentSeatPersistence
 * @see EnrollmentSeatPersistenceImpl
 * @generated
 */
public class EnrollmentSeatUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(EnrollmentSeat enrollmentSeat) {
		getPersistence().clearCache(enrollmentSeat);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EnrollmentSeat> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EnrollmentSeat> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EnrollmentSeat> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EnrollmentSeat update(EnrollmentSeat enrollmentSeat)
		throws SystemException {
		return getPersistence().update(enrollmentSeat);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EnrollmentSeat update(EnrollmentSeat enrollmentSeat,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(enrollmentSeat, serviceContext);
	}

	/**
	* Returns the enrollment seat where token = &#63; or throws a {@link com.instructure.canvas.NoSuchEnrollmentSeatException} if it could not be found.
	*
	* @param token the token
	* @return the matching enrollment seat
	* @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat findByToken(
		java.lang.String token)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByToken(token);
	}

	/**
	* Returns the enrollment seat where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param token the token
	* @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat fetchByToken(
		java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByToken(token);
	}

	/**
	* Returns the enrollment seat where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param token the token
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat fetchByToken(
		java.lang.String token, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByToken(token, retrieveFromCache);
	}

	/**
	* Removes the enrollment seat where token = &#63; from the database.
	*
	* @param token the token
	* @return the enrollment seat that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat removeByToken(
		java.lang.String token)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByToken(token);
	}

	/**
	* Returns the number of enrollment seats where token = &#63;.
	*
	* @param token the token
	* @return the number of matching enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	public static int countByToken(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByToken(token);
	}

	/**
	* Returns the enrollment seat where courseId = &#63; or throws a {@link com.instructure.canvas.NoSuchEnrollmentSeatException} if it could not be found.
	*
	* @param courseId the course ID
	* @return the matching enrollment seat
	* @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat findByCourseId(
		java.lang.String courseId)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(courseId);
	}

	/**
	* Returns the enrollment seat where courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseId the course ID
	* @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat fetchByCourseId(
		java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourseId(courseId);
	}

	/**
	* Returns the enrollment seat where courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseId the course ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat fetchByCourseId(
		java.lang.String courseId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourseId(courseId, retrieveFromCache);
	}

	/**
	* Removes the enrollment seat where courseId = &#63; from the database.
	*
	* @param courseId the course ID
	* @return the enrollment seat that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat removeByCourseId(
		java.lang.String courseId)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCourseId(courseId);
	}

	/**
	* Returns the number of enrollment seats where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseId(java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseId(courseId);
	}

	/**
	* Caches the enrollment seat in the entity cache if it is enabled.
	*
	* @param enrollmentSeat the enrollment seat
	*/
	public static void cacheResult(
		com.instructure.canvas.model.EnrollmentSeat enrollmentSeat) {
		getPersistence().cacheResult(enrollmentSeat);
	}

	/**
	* Caches the enrollment seats in the entity cache if it is enabled.
	*
	* @param enrollmentSeats the enrollment seats
	*/
	public static void cacheResult(
		java.util.List<com.instructure.canvas.model.EnrollmentSeat> enrollmentSeats) {
		getPersistence().cacheResult(enrollmentSeats);
	}

	/**
	* Creates a new enrollment seat with the primary key. Does not add the enrollment seat to the database.
	*
	* @param id the primary key for the new enrollment seat
	* @return the new enrollment seat
	*/
	public static com.instructure.canvas.model.EnrollmentSeat create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the enrollment seat with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the enrollment seat
	* @return the enrollment seat that was removed
	* @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a enrollment seat with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat remove(long id)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.instructure.canvas.model.EnrollmentSeat updateImpl(
		com.instructure.canvas.model.EnrollmentSeat enrollmentSeat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(enrollmentSeat);
	}

	/**
	* Returns the enrollment seat with the primary key or throws a {@link com.instructure.canvas.NoSuchEnrollmentSeatException} if it could not be found.
	*
	* @param id the primary key of the enrollment seat
	* @return the enrollment seat
	* @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a enrollment seat with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat findByPrimaryKey(
		long id)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the enrollment seat with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the enrollment seat
	* @return the enrollment seat, or <code>null</code> if a enrollment seat with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.EnrollmentSeat fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the enrollment seats.
	*
	* @return the enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.EnrollmentSeat> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.instructure.canvas.model.EnrollmentSeat> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the enrollment seats.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.EnrollmentSeatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enrollment seats
	* @param end the upper bound of the range of enrollment seats (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.EnrollmentSeat> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the enrollment seats from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of enrollment seats.
	*
	* @return the number of enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EnrollmentSeatPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EnrollmentSeatPersistence)PortletBeanLocatorUtil.locate(com.instructure.canvas.service.ClpSerializer.getServletContextName(),
					EnrollmentSeatPersistence.class.getName());

			ReferenceRegistry.registerReference(EnrollmentSeatUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EnrollmentSeatPersistence persistence) {
	}

	private static EnrollmentSeatPersistence _persistence;
}