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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the enrollment seat service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnrollmentSeatPersistenceImpl
 * @see EnrollmentSeatUtil
 * @generated
 */
public interface EnrollmentSeatPersistence extends BasePersistence<EnrollmentSeat> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnrollmentSeatUtil} to access the enrollment seat persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the enrollment seat where token = &#63; or throws a {@link com.instructure.canvas.NoSuchEnrollmentSeatException} if it could not be found.
	*
	* @param token the token
	* @return the matching enrollment seat
	* @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat findByToken(
		java.lang.String token)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrollment seat where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param token the token
	* @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat fetchByToken(
		java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrollment seat where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param token the token
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat fetchByToken(
		java.lang.String token, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the enrollment seat where token = &#63; from the database.
	*
	* @param token the token
	* @return the enrollment seat that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat removeByToken(
		java.lang.String token)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enrollment seats where token = &#63;.
	*
	* @param token the token
	* @return the number of matching enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	public int countByToken(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrollment seat where courseId = &#63; or throws a {@link com.instructure.canvas.NoSuchEnrollmentSeatException} if it could not be found.
	*
	* @param courseId the course ID
	* @return the matching enrollment seat
	* @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat findByCourseId(
		java.lang.String courseId)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrollment seat where courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseId the course ID
	* @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat fetchByCourseId(
		java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrollment seat where courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseId the course ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat fetchByCourseId(
		java.lang.String courseId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the enrollment seat where courseId = &#63; from the database.
	*
	* @param courseId the course ID
	* @return the enrollment seat that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat removeByCourseId(
		java.lang.String courseId)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enrollment seats where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the enrollment seat in the entity cache if it is enabled.
	*
	* @param enrollmentSeat the enrollment seat
	*/
	public void cacheResult(
		com.instructure.canvas.model.EnrollmentSeat enrollmentSeat);

	/**
	* Caches the enrollment seats in the entity cache if it is enabled.
	*
	* @param enrollmentSeats the enrollment seats
	*/
	public void cacheResult(
		java.util.List<com.instructure.canvas.model.EnrollmentSeat> enrollmentSeats);

	/**
	* Creates a new enrollment seat with the primary key. Does not add the enrollment seat to the database.
	*
	* @param id the primary key for the new enrollment seat
	* @return the new enrollment seat
	*/
	public com.instructure.canvas.model.EnrollmentSeat create(long id);

	/**
	* Removes the enrollment seat with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the enrollment seat
	* @return the enrollment seat that was removed
	* @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a enrollment seat with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat remove(long id)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.instructure.canvas.model.EnrollmentSeat updateImpl(
		com.instructure.canvas.model.EnrollmentSeat enrollmentSeat)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrollment seat with the primary key or throws a {@link com.instructure.canvas.NoSuchEnrollmentSeatException} if it could not be found.
	*
	* @param id the primary key of the enrollment seat
	* @return the enrollment seat
	* @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a enrollment seat with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat findByPrimaryKey(long id)
		throws com.instructure.canvas.NoSuchEnrollmentSeatException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrollment seat with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the enrollment seat
	* @return the enrollment seat, or <code>null</code> if a enrollment seat with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.EnrollmentSeat fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enrollment seats.
	*
	* @return the enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.EnrollmentSeat> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.EnrollmentSeat> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.EnrollmentSeat> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enrollment seats from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enrollment seats.
	*
	* @return the number of enrollment seats
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}