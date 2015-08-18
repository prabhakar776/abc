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

import com.instructure.canvas.model.Award;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the award service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AwardPersistenceImpl
 * @see AwardUtil
 * @generated
 */
public interface AwardPersistence extends BasePersistence<Award> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AwardUtil} to access the award persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the awards where active = &#63;.
	*
	* @param active the active
	* @return the matching awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.Award> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the awards where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of awards
	* @param end the upper bound of the range of awards (not inclusive)
	* @return the range of matching awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.Award> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the awards where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of awards
	* @param end the upper bound of the range of awards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.Award> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first award in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching award
	* @throws com.instructure.canvas.NoSuchAwardException if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award findByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first award in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching award, or <code>null</code> if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award fetchByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last award in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching award
	* @throws com.instructure.canvas.NoSuchAwardException if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award findByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last award in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching award, or <code>null</code> if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award fetchByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the awards before and after the current award in the ordered set where active = &#63;.
	*
	* @param awardId the primary key of the current award
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next award
	* @throws com.instructure.canvas.NoSuchAwardException if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award[] findByActive_PrevAndNext(
		long awardId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the awards where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of awards where active = &#63;.
	*
	* @param active the active
	* @return the number of matching awards
	* @throws SystemException if a system exception occurred
	*/
	public int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the award where cvlId = &#63; or throws a {@link com.instructure.canvas.NoSuchAwardException} if it could not be found.
	*
	* @param cvlId the cvl ID
	* @return the matching award
	* @throws com.instructure.canvas.NoSuchAwardException if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award findByCVL_ID(
		java.lang.String cvlId)
		throws com.instructure.canvas.NoSuchAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the award where cvlId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cvlId the cvl ID
	* @return the matching award, or <code>null</code> if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award fetchByCVL_ID(
		java.lang.String cvlId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the award where cvlId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cvlId the cvl ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching award, or <code>null</code> if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award fetchByCVL_ID(
		java.lang.String cvlId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the award where cvlId = &#63; from the database.
	*
	* @param cvlId the cvl ID
	* @return the award that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award removeByCVL_ID(
		java.lang.String cvlId)
		throws com.instructure.canvas.NoSuchAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of awards where cvlId = &#63;.
	*
	* @param cvlId the cvl ID
	* @return the number of matching awards
	* @throws SystemException if a system exception occurred
	*/
	public int countByCVL_ID(java.lang.String cvlId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the award where cvlName = &#63; or throws a {@link com.instructure.canvas.NoSuchAwardException} if it could not be found.
	*
	* @param cvlName the cvl name
	* @return the matching award
	* @throws com.instructure.canvas.NoSuchAwardException if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award findByCVL_Name(
		java.lang.String cvlName)
		throws com.instructure.canvas.NoSuchAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the award where cvlName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cvlName the cvl name
	* @return the matching award, or <code>null</code> if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award fetchByCVL_Name(
		java.lang.String cvlName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the award where cvlName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cvlName the cvl name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching award, or <code>null</code> if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award fetchByCVL_Name(
		java.lang.String cvlName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the award where cvlName = &#63; from the database.
	*
	* @param cvlName the cvl name
	* @return the award that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award removeByCVL_Name(
		java.lang.String cvlName)
		throws com.instructure.canvas.NoSuchAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of awards where cvlName = &#63;.
	*
	* @param cvlName the cvl name
	* @return the number of matching awards
	* @throws SystemException if a system exception occurred
	*/
	public int countByCVL_Name(java.lang.String cvlName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the award in the entity cache if it is enabled.
	*
	* @param award the award
	*/
	public void cacheResult(com.instructure.canvas.model.Award award);

	/**
	* Caches the awards in the entity cache if it is enabled.
	*
	* @param awards the awards
	*/
	public void cacheResult(
		java.util.List<com.instructure.canvas.model.Award> awards);

	/**
	* Creates a new award with the primary key. Does not add the award to the database.
	*
	* @param awardId the primary key for the new award
	* @return the new award
	*/
	public com.instructure.canvas.model.Award create(long awardId);

	/**
	* Removes the award with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param awardId the primary key of the award
	* @return the award that was removed
	* @throws com.instructure.canvas.NoSuchAwardException if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award remove(long awardId)
		throws com.instructure.canvas.NoSuchAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.instructure.canvas.model.Award updateImpl(
		com.instructure.canvas.model.Award award)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the award with the primary key or throws a {@link com.instructure.canvas.NoSuchAwardException} if it could not be found.
	*
	* @param awardId the primary key of the award
	* @return the award
	* @throws com.instructure.canvas.NoSuchAwardException if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award findByPrimaryKey(long awardId)
		throws com.instructure.canvas.NoSuchAwardException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the award with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param awardId the primary key of the award
	* @return the award, or <code>null</code> if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.Award fetchByPrimaryKey(long awardId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the awards.
	*
	* @return the awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.Award> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the awards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of awards
	* @param end the upper bound of the range of awards (not inclusive)
	* @return the range of awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.Award> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the awards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of awards
	* @param end the upper bound of the range of awards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.Award> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the awards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of awards.
	*
	* @return the number of awards
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}