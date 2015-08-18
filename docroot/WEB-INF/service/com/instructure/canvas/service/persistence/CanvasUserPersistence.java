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

import com.instructure.canvas.model.CanvasUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the canvas user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasUserPersistenceImpl
 * @see CanvasUserUtil
 * @generated
 */
public interface CanvasUserPersistence extends BasePersistence<CanvasUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CanvasUserUtil} to access the canvas user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the canvas user in the entity cache if it is enabled.
	*
	* @param canvasUser the canvas user
	*/
	public void cacheResult(com.instructure.canvas.model.CanvasUser canvasUser);

	/**
	* Caches the canvas users in the entity cache if it is enabled.
	*
	* @param canvasUsers the canvas users
	*/
	public void cacheResult(
		java.util.List<com.instructure.canvas.model.CanvasUser> canvasUsers);

	/**
	* Creates a new canvas user with the primary key. Does not add the canvas user to the database.
	*
	* @param userId the primary key for the new canvas user
	* @return the new canvas user
	*/
	public com.instructure.canvas.model.CanvasUser create(long userId);

	/**
	* Removes the canvas user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the canvas user
	* @return the canvas user that was removed
	* @throws com.instructure.canvas.NoSuchCanvasUserException if a canvas user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CanvasUser remove(long userId)
		throws com.instructure.canvas.NoSuchCanvasUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.instructure.canvas.model.CanvasUser updateImpl(
		com.instructure.canvas.model.CanvasUser canvasUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the canvas user with the primary key or throws a {@link com.instructure.canvas.NoSuchCanvasUserException} if it could not be found.
	*
	* @param userId the primary key of the canvas user
	* @return the canvas user
	* @throws com.instructure.canvas.NoSuchCanvasUserException if a canvas user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CanvasUser findByPrimaryKey(long userId)
		throws com.instructure.canvas.NoSuchCanvasUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the canvas user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the canvas user
	* @return the canvas user, or <code>null</code> if a canvas user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CanvasUser fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the canvas users.
	*
	* @return the canvas users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CanvasUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the canvas users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of canvas users
	* @param end the upper bound of the range of canvas users (not inclusive)
	* @return the range of canvas users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CanvasUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the canvas users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of canvas users
	* @param end the upper bound of the range of canvas users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of canvas users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CanvasUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the canvas users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of canvas users.
	*
	* @return the number of canvas users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}