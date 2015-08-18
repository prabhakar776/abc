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

import com.instructure.canvas.model.ActivityStream;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the activity stream service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityStreamPersistenceImpl
 * @see ActivityStreamUtil
 * @generated
 */
public interface ActivityStreamPersistence extends BasePersistence<ActivityStream> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActivityStreamUtil} to access the activity stream persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the activity stream in the entity cache if it is enabled.
	*
	* @param activityStream the activity stream
	*/
	public void cacheResult(
		com.instructure.canvas.model.ActivityStream activityStream);

	/**
	* Caches the activity streams in the entity cache if it is enabled.
	*
	* @param activityStreams the activity streams
	*/
	public void cacheResult(
		java.util.List<com.instructure.canvas.model.ActivityStream> activityStreams);

	/**
	* Creates a new activity stream with the primary key. Does not add the activity stream to the database.
	*
	* @param activityStreamId the primary key for the new activity stream
	* @return the new activity stream
	*/
	public com.instructure.canvas.model.ActivityStream create(
		long activityStreamId);

	/**
	* Removes the activity stream with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityStreamId the primary key of the activity stream
	* @return the activity stream that was removed
	* @throws com.instructure.canvas.NoSuchActivityStreamException if a activity stream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.ActivityStream remove(
		long activityStreamId)
		throws com.instructure.canvas.NoSuchActivityStreamException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.instructure.canvas.model.ActivityStream updateImpl(
		com.instructure.canvas.model.ActivityStream activityStream)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the activity stream with the primary key or throws a {@link com.instructure.canvas.NoSuchActivityStreamException} if it could not be found.
	*
	* @param activityStreamId the primary key of the activity stream
	* @return the activity stream
	* @throws com.instructure.canvas.NoSuchActivityStreamException if a activity stream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.ActivityStream findByPrimaryKey(
		long activityStreamId)
		throws com.instructure.canvas.NoSuchActivityStreamException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the activity stream with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activityStreamId the primary key of the activity stream
	* @return the activity stream, or <code>null</code> if a activity stream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.ActivityStream fetchByPrimaryKey(
		long activityStreamId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the activity streams.
	*
	* @return the activity streams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.ActivityStream> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the activity streams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.ActivityStreamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activity streams
	* @param end the upper bound of the range of activity streams (not inclusive)
	* @return the range of activity streams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.ActivityStream> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the activity streams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.ActivityStreamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activity streams
	* @param end the upper bound of the range of activity streams (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of activity streams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.ActivityStream> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the activity streams from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of activity streams.
	*
	* @return the number of activity streams
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}