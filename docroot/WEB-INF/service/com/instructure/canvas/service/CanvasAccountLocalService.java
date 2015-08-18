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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for CanvasAccount. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasAccountLocalServiceUtil
 * @see com.instructure.canvas.service.base.CanvasAccountLocalServiceBaseImpl
 * @see com.instructure.canvas.service.impl.CanvasAccountLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CanvasAccountLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CanvasAccountLocalServiceUtil} to access the canvas account local service. Add custom service methods to {@link com.instructure.canvas.service.impl.CanvasAccountLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the canvas account to the database. Also notifies the appropriate model listeners.
	*
	* @param canvasAccount the canvas account
	* @return the canvas account that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.instructure.canvas.model.CanvasAccount addCanvasAccount(
		com.instructure.canvas.model.CanvasAccount canvasAccount)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new canvas account with the primary key. Does not add the canvas account to the database.
	*
	* @param accountId the primary key for the new canvas account
	* @return the new canvas account
	*/
	public com.instructure.canvas.model.CanvasAccount createCanvasAccount(
		long accountId);

	/**
	* Deletes the canvas account with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param accountId the primary key of the canvas account
	* @return the canvas account that was removed
	* @throws PortalException if a canvas account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.instructure.canvas.model.CanvasAccount deleteCanvasAccount(
		long accountId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the canvas account from the database. Also notifies the appropriate model listeners.
	*
	* @param canvasAccount the canvas account
	* @return the canvas account that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.instructure.canvas.model.CanvasAccount deleteCanvasAccount(
		com.instructure.canvas.model.CanvasAccount canvasAccount)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.instructure.canvas.model.CanvasAccount fetchCanvasAccount(
		long accountId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the canvas account with the primary key.
	*
	* @param accountId the primary key of the canvas account
	* @return the canvas account
	* @throws PortalException if a canvas account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.instructure.canvas.model.CanvasAccount getCanvasAccount(
		long accountId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.instructure.canvas.model.CanvasAccount> getCanvasAccounts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of canvas accounts.
	*
	* @return the number of canvas accounts
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCanvasAccountsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the canvas account in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param canvasAccount the canvas account
	* @return the canvas account that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.instructure.canvas.model.CanvasAccount updateCanvasAccount(
		com.instructure.canvas.model.CanvasAccount canvasAccount)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.instructure.canvas.model.CanvasAccount> getAvailableRootAccounts(
		java.lang.String userToken)
		throws com.liferay.portal.kernel.json.JSONException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getUsers(
		java.lang.String accountId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException;

	public java.lang.String addAdmin(java.lang.String accountId,
		java.lang.String userId) throws java.io.IOException;

	public java.lang.String removeAdmin(java.lang.String accountId,
		java.lang.String userId) throws java.io.IOException;

	public void addPsuedonym(java.lang.String academyCanvasAccountId,
		java.lang.String canvasUserId, java.lang.String emailAddress,
		java.lang.String acadType);

	public java.lang.String addPseudonym(java.lang.String accountId,
		java.lang.String userId, java.lang.String uniqueIdentifier)
		throws java.io.IOException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isPseudonymTaken(java.lang.String jsonStr)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String createOrUpdateAccount(java.lang.String name,
		java.lang.String domain) throws java.io.IOException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getPseudonym(
		java.lang.String accountId, java.lang.String userId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException;

	public java.lang.String addSAMLAuthentication(java.lang.String accountId)
		throws java.io.IOException;

	public java.lang.String addExternalTools(java.lang.String accountId)
		throws java.io.IOException;

	public java.lang.String setPermission(java.lang.String accountId,
		java.lang.String roleName, java.lang.String permissionName,
		java.lang.String permission, boolean enabled)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getAccount(
		java.lang.String accountId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException;

	public com.liferay.portal.kernel.json.JSONObject setAccountName(
		java.lang.String accountId, java.lang.String name)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getAccountDomain(java.lang.String userId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException;
}