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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user award service. This utility wraps {@link UserAwardPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAwardPersistence
 * @see UserAwardPersistenceImpl
 * @generated
 */
public class UserAwardUtil {
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
	public static void clearCache(UserAward userAward) {
		getPersistence().clearCache(userAward);
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
	public static List<UserAward> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserAward> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserAward> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserAward update(UserAward userAward)
		throws SystemException {
		return getPersistence().update(userAward);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserAward update(UserAward userAward,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userAward, serviceContext);
	}

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
	public static com.instructure.canvas.model.UserAward findByCUID_CID_L(
		long canvasUserId, long courseId, boolean letter)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCUID_CID_L(canvasUserId, courseId, letter);
	}

	/**
	* Returns the user award where canvasUserId = &#63; and courseId = &#63; and letter = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param canvasUserId the canvas user ID
	* @param courseId the course ID
	* @param letter the letter
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward fetchByCUID_CID_L(
		long canvasUserId, long courseId, boolean letter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCUID_CID_L(canvasUserId, courseId, letter);
	}

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
	public static com.instructure.canvas.model.UserAward fetchByCUID_CID_L(
		long canvasUserId, long courseId, boolean letter,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCUID_CID_L(canvasUserId, courseId, letter,
			retrieveFromCache);
	}

	/**
	* Removes the user award where canvasUserId = &#63; and courseId = &#63; and letter = &#63; from the database.
	*
	* @param canvasUserId the canvas user ID
	* @param courseId the course ID
	* @param letter the letter
	* @return the user award that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward removeByCUID_CID_L(
		long canvasUserId, long courseId, boolean letter)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByCUID_CID_L(canvasUserId, courseId, letter);
	}

	/**
	* Returns the number of user awards where canvasUserId = &#63; and courseId = &#63; and letter = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @param courseId the course ID
	* @param letter the letter
	* @return the number of matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCUID_CID_L(long canvasUserId, long courseId,
		boolean letter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCUID_CID_L(canvasUserId, courseId, letter);
	}

	/**
	* Returns the user award where courseId = &#63; and canvasUserId = &#63; or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	*
	* @param courseId the course ID
	* @param canvasUserId the canvas user ID
	* @return the matching user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward findByCourseId(
		long courseId, long canvasUserId)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(courseId, canvasUserId);
	}

	/**
	* Returns the user award where courseId = &#63; and canvasUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseId the course ID
	* @param canvasUserId the canvas user ID
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward fetchByCourseId(
		long courseId, long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourseId(courseId, canvasUserId);
	}

	/**
	* Returns the user award where courseId = &#63; and canvasUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseId the course ID
	* @param canvasUserId the canvas user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward fetchByCourseId(
		long courseId, long canvasUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseId(courseId, canvasUserId, retrieveFromCache);
	}

	/**
	* Removes the user award where courseId = &#63; and canvasUserId = &#63; from the database.
	*
	* @param courseId the course ID
	* @param canvasUserId the canvas user ID
	* @return the user award that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward removeByCourseId(
		long courseId, long canvasUserId)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCourseId(courseId, canvasUserId);
	}

	/**
	* Returns the number of user awards where courseId = &#63; and canvasUserId = &#63;.
	*
	* @param courseId the course ID
	* @param canvasUserId the canvas user ID
	* @return the number of matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseId(long courseId, long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseId(courseId, canvasUserId);
	}

	/**
	* Returns the user award where certId = &#63; or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	*
	* @param certId the cert ID
	* @return the matching user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward findByCertID(
		java.lang.String certId)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCertID(certId);
	}

	/**
	* Returns the user award where certId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param certId the cert ID
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward fetchByCertID(
		java.lang.String certId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCertID(certId);
	}

	/**
	* Returns the user award where certId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param certId the cert ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward fetchByCertID(
		java.lang.String certId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCertID(certId, retrieveFromCache);
	}

	/**
	* Removes the user award where certId = &#63; from the database.
	*
	* @param certId the cert ID
	* @return the user award that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward removeByCertID(
		java.lang.String certId)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCertID(certId);
	}

	/**
	* Returns the number of user awards where certId = &#63;.
	*
	* @param certId the cert ID
	* @return the number of matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCertID(java.lang.String certId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCertID(certId);
	}

	/**
	* Returns all the user awards where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @return the matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.UserAward> findByCanvasUserId(
		long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCanvasUserId(canvasUserId);
	}

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
	public static java.util.List<com.instructure.canvas.model.UserAward> findByCanvasUserId(
		long canvasUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCanvasUserId(canvasUserId, start, end);
	}

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
	public static java.util.List<com.instructure.canvas.model.UserAward> findByCanvasUserId(
		long canvasUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCanvasUserId(canvasUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first user award in the ordered set where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward findByCanvasUserId_First(
		long canvasUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCanvasUserId_First(canvasUserId, orderByComparator);
	}

	/**
	* Returns the first user award in the ordered set where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward fetchByCanvasUserId_First(
		long canvasUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCanvasUserId_First(canvasUserId, orderByComparator);
	}

	/**
	* Returns the last user award in the ordered set where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward findByCanvasUserId_Last(
		long canvasUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCanvasUserId_Last(canvasUserId, orderByComparator);
	}

	/**
	* Returns the last user award in the ordered set where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user award, or <code>null</code> if a matching user award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward fetchByCanvasUserId_Last(
		long canvasUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCanvasUserId_Last(canvasUserId, orderByComparator);
	}

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
	public static com.instructure.canvas.model.UserAward[] findByCanvasUserId_PrevAndNext(
		long id, long canvasUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCanvasUserId_PrevAndNext(id, canvasUserId,
			orderByComparator);
	}

	/**
	* Removes all the user awards where canvasUserId = &#63; from the database.
	*
	* @param canvasUserId the canvas user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCanvasUserId(long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCanvasUserId(canvasUserId);
	}

	/**
	* Returns the number of user awards where canvasUserId = &#63;.
	*
	* @param canvasUserId the canvas user ID
	* @return the number of matching user awards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCanvasUserId(long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCanvasUserId(canvasUserId);
	}

	/**
	* Caches the user award in the entity cache if it is enabled.
	*
	* @param userAward the user award
	*/
	public static void cacheResult(
		com.instructure.canvas.model.UserAward userAward) {
		getPersistence().cacheResult(userAward);
	}

	/**
	* Caches the user awards in the entity cache if it is enabled.
	*
	* @param userAwards the user awards
	*/
	public static void cacheResult(
		java.util.List<com.instructure.canvas.model.UserAward> userAwards) {
		getPersistence().cacheResult(userAwards);
	}

	/**
	* Creates a new user award with the primary key. Does not add the user award to the database.
	*
	* @param id the primary key for the new user award
	* @return the new user award
	*/
	public static com.instructure.canvas.model.UserAward create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the user award with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the user award
	* @return the user award that was removed
	* @throws com.instructure.canvas.NoSuchUserAwardException if a user award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward remove(long id)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.instructure.canvas.model.UserAward updateImpl(
		com.instructure.canvas.model.UserAward userAward)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userAward);
	}

	/**
	* Returns the user award with the primary key or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	*
	* @param id the primary key of the user award
	* @return the user award
	* @throws com.instructure.canvas.NoSuchUserAwardException if a user award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward findByPrimaryKey(
		long id)
		throws com.instructure.canvas.NoSuchUserAwardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the user award with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the user award
	* @return the user award, or <code>null</code> if a user award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the user awards.
	*
	* @return the user awards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.UserAward> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.instructure.canvas.model.UserAward> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.instructure.canvas.model.UserAward> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user awards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user awards.
	*
	* @return the number of user awards
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserAwardPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserAwardPersistence)PortletBeanLocatorUtil.locate(com.instructure.canvas.service.ClpSerializer.getServletContextName(),
					UserAwardPersistence.class.getName());

			ReferenceRegistry.registerReference(UserAwardUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserAwardPersistence persistence) {
	}

	private static UserAwardPersistence _persistence;
}