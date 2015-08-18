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

import com.instructure.canvas.model.UserAward;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user award service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAwardPersistenceImpl
 * @see UserAwardUtil
 * @generated
 */
public interface UserAwardPersistence extends BasePersistence<UserAward> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserAwardUtil} to access the user award persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the user award where canvasUserId = &#63; and courseId = &#63; and letter = &#63; or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	*
	* @param canvasUserId the canvas user ID
	* @param courseId the course ID
	* @param letter the letter
	* @return the matching user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward findByCUID_CID_L(
		long canvasUserId, long courseId, boolean letter)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user award where canvasUserId = &#63; and courseId = &#63; and letter = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param canvasUserId the canvas user ID
	* @param courseId the course ID
	* @param letter the letter
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward fetchByCUID_CID_L(
		long canvasUserId, long courseId, boolean letter)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user award where canvasUserId = &#63; and courseId = &#63; and letter = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param canvasUserId the canvas user ID
	* @param courseId the course ID
	* @param letter the letter
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward fetchByCUID_CID_L(
		long canvasUserId, long courseId, boolean letter,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user award where canvasUserId = &#63; and courseId = &#63; and letter = &#63; from the database.
	*
	* @param canvasUserId the canvas user ID
	* @param courseId the course ID
	* @param letter the letter
	* @return the user award that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward removeByCUID_CID_L(
		long canvasUserId, long courseId, boolean letter)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user awards where canvasUserId = &#63; and courseId = &#63; and letter = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @param courseId the course ID
	* @param letter the letter
	* @return the number of matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public int countByCUID_CID_L(long canvasUserId, long courseId,
		boolean letter)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user award where courseId = &#63; and canvasUserId = &#63; or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	*
	* @param courseId the course ID
	* @param canvasUserId the canvas user ID
	* @return the matching user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward findByCourseId(
		long courseId, long canvasUserId)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user award where courseId = &#63; and canvasUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseId the course ID
	* @param canvasUserId the canvas user ID
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward fetchByCourseId(
		long courseId, long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user award where courseId = &#63; and canvasUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseId the course ID
	* @param canvasUserId the canvas user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward fetchByCourseId(
		long courseId, long canvasUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user award where courseId = &#63; and canvasUserId = &#63; from the database.
	*
	* @param courseId the course ID
	* @param canvasUserId the canvas user ID
	* @return the user award that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward removeByCourseId(
		long courseId, long canvasUserId)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user awards where courseId = &#63; and canvasUserId = &#63;.
	*
	* @param courseId the course ID
	* @param canvasUserId the canvas user ID
	* @return the number of matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(long courseId, long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user award where certId = &#63; or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	*
	* @param certId the cert ID
	* @return the matching user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward findByCertID(
		java.lang.String certId)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user award where certId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param certId the cert ID
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward fetchByCertID(
		java.lang.String certId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user award where certId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param certId the cert ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward fetchByCertID(
		java.lang.String certId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user award where certId = &#63; from the database.
	*
	* @param certId the cert ID
	* @return the user award that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward removeByCertID(
		java.lang.String certId)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user awards where certId = &#63;.
	*
	* @param certId the cert ID
	* @return the number of matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public int countByCertID(java.lang.String certId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user awards where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @return the matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.UserAward> findByCanvasUserId(
		long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user awards where canvasUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.UserAwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param canvasUserId the canvas user ID
	* @param start the lower bound of the range of user awards
	* @param end the upper bound of the range of user awards (not inclusive)
	* @return the range of matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.UserAward> findByCanvasUserId(
		long canvasUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user awards where canvasUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.UserAwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param canvasUserId the canvas user ID
	* @param start the lower bound of the range of user awards
	* @param end the upper bound of the range of user awards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.UserAward> findByCanvasUserId(
		long canvasUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user award in the ordered set where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward findByCanvasUserId_First(
		long canvasUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user award in the ordered set where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward fetchByCanvasUserId_First(
		long canvasUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user award in the ordered set where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward findByCanvasUserId_Last(
		long canvasUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user award in the ordered set where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward fetchByCanvasUserId_Last(
		long canvasUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user awards before and after the current user award in the ordered set where canvasUserId = &#63;.
	*
	* @param id the primary key of the current user award
	* @param canvasUserId the canvas user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a user award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward[] findByCanvasUserId_PrevAndNext(
		long id, long canvasUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user awards where canvasUserId = &#63; from the database.
	*
	* @param canvasUserId the canvas user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCanvasUserId(long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user awards where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @return the number of matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public int countByCanvasUserId(long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user award in the entity cache if it is enabled.
	*
	* @param userAward the user award
	*/
	public void cacheResult(com.instructure.canvas.model.UserAward userAward);

	/**
	* Caches the user awards in the entity cache if it is enabled.
	*
	* @param userAwards the user awards
	*/
	public void cacheResult(
		java.util.List<com.instructure.canvas.model.UserAward> userAwards);

	/**
	* Creates a new user award with the primary key. Does not add the user award to the database.
	*
	* @param id the primary key for the new user award
	* @return the new user award
	*/
	public com.instructure.canvas.model.UserAward create(long id);

	/**
	* Removes the user award with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the user award
	* @return the user award that was removed
	* @throws com.instructure.canvas.NoSuchUserAwardException if a user award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward remove(long id)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.instructure.canvas.model.UserAward updateImpl(
		com.instructure.canvas.model.UserAward userAward)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user award with the primary key or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	*
	* @param id the primary key of the user award
	* @return the user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a user award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward findByPrimaryKey(long id)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user award with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the user award
	* @return the user award, or <code>null</code> if a user award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.UserAward fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user awards.
	*
	* @return the user awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.UserAward> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user awards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.UserAwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user awards
	* @param end the upper bound of the range of user awards (not inclusive)
	* @return the range of user awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.UserAward> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user awards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.UserAwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user awards
	* @param end the upper bound of the range of user awards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.UserAward> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user awards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user awards.
	*
	* @return the number of user awards
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}