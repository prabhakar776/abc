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

import com.instructure.canvas.model.CanvasAccount;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the canvas account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasAccountPersistenceImpl
 * @see CanvasAccountUtil
 * @generated
 */
public interface CanvasAccountPersistence extends BasePersistence<CanvasAccount> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CanvasAccountUtil} to access the canvas account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the canvas account in the entity cache if it is enabled.
	*
	* @param canvasAccount the canvas account
	*/
	public void cacheResult(
		com.instructure.canvas.model.CanvasAccount canvasAccount);

	/**
	* Caches the canvas accounts in the entity cache if it is enabled.
	*
	* @param canvasAccounts the canvas accounts
	*/
	public void cacheResult(
		java.util.List<com.instructure.canvas.model.CanvasAccount> canvasAccounts);

	/**
	* Creates a new canvas account with the primary key. Does not add the canvas account to the database.
	*
	* @param accountId the primary key for the new canvas account
	* @return the new canvas account
	*/
	public com.instructure.canvas.model.CanvasAccount create(long accountId);

	/**
	* Removes the canvas account with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param accountId the primary key of the canvas account
	* @return the canvas account that was removed
	* @throws com.instructure.canvas.NoSuchCanvasAccountException if a canvas account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CanvasAccount remove(long accountId)
		throws com.instructure.canvas.NoSuchCanvasAccountException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.instructure.canvas.model.CanvasAccount updateImpl(
		com.instructure.canvas.model.CanvasAccount canvasAccount)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the canvas account with the primary key or throws a {@link com.instructure.canvas.NoSuchCanvasAccountException} if it could not be found.
	*
	* @param accountId the primary key of the canvas account
	* @return the canvas account
	* @throws com.instructure.canvas.NoSuchCanvasAccountException if a canvas account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CanvasAccount findByPrimaryKey(
		long accountId)
		throws com.instructure.canvas.NoSuchCanvasAccountException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the canvas account with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param accountId the primary key of the canvas account
	* @return the canvas account, or <code>null</code> if a canvas account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CanvasAccount fetchByPrimaryKey(
		long accountId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the canvas accounts.
	*
	* @return the canvas accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CanvasAccount> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the canvas accounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of canvas accounts
	* @param end the upper bound of the range of canvas accounts (not inclusive)
	* @return the range of canvas accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CanvasAccount> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the canvas accounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of canvas accounts
	* @param end the upper bound of the range of canvas accounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of canvas accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CanvasAccount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the canvas accounts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of canvas accounts.
	*
	* @return the number of canvas accounts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}