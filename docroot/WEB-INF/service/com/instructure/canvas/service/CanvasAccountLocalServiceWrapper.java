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
 * Provides a wrapper for {@link CanvasAccountLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasAccountLocalService
 * @generated
 */
public class CanvasAccountLocalServiceWrapper
	implements CanvasAccountLocalService,
		ServiceWrapper<CanvasAccountLocalService> {
	public CanvasAccountLocalServiceWrapper(
		CanvasAccountLocalService canvasAccountLocalService) {
		_canvasAccountLocalService = canvasAccountLocalService;
	}

	/**
	* Adds the canvas account to the database. Also notifies the appropriate model listeners.
	*
	* @param canvasAccount the canvas account
	* @return the canvas account that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.CanvasAccount addCanvasAccount(
		com.instructure.canvas.model.CanvasAccount canvasAccount)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.addCanvasAccount(canvasAccount);
	}

	/**
	* Creates a new canvas account with the primary key. Does not add the canvas account to the database.
	*
	* @param accountId the primary key for the new canvas account
	* @return the new canvas account
	*/
	@Override
	public com.instructure.canvas.model.CanvasAccount createCanvasAccount(
		long accountId) {
		return _canvasAccountLocalService.createCanvasAccount(accountId);
	}

	/**
	* Deletes the canvas account with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param accountId the primary key of the canvas account
	* @return the canvas account that was removed
	* @throws PortalException if a canvas account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.CanvasAccount deleteCanvasAccount(
		long accountId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.deleteCanvasAccount(accountId);
	}

	/**
	* Deletes the canvas account from the database. Also notifies the appropriate model listeners.
	*
	* @param canvasAccount the canvas account
	* @return the canvas account that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.CanvasAccount deleteCanvasAccount(
		com.instructure.canvas.model.CanvasAccount canvasAccount)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.deleteCanvasAccount(canvasAccount);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _canvasAccountLocalService.dynamicQuery();
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
		return _canvasAccountLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.dynamicQuery(dynamicQuery, start,
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
		return _canvasAccountLocalService.dynamicQueryCount(dynamicQuery);
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
		return _canvasAccountLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.instructure.canvas.model.CanvasAccount fetchCanvasAccount(
		long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.fetchCanvasAccount(accountId);
	}

	/**
	* Returns the canvas account with the primary key.
	*
	* @param accountId the primary key of the canvas account
	* @return the canvas account
	* @throws PortalException if a canvas account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.CanvasAccount getCanvasAccount(
		long accountId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.getCanvasAccount(accountId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.instructure.canvas.model.CanvasAccount> getCanvasAccounts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.getCanvasAccounts(start, end);
	}

	/**
	* Returns the number of canvas accounts.
	*
	* @return the number of canvas accounts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCanvasAccountsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.getCanvasAccountsCount();
	}

	/**
	* Updates the canvas account in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param canvasAccount the canvas account
	* @return the canvas account that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.CanvasAccount updateCanvasAccount(
		com.instructure.canvas.model.CanvasAccount canvasAccount)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.updateCanvasAccount(canvasAccount);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _canvasAccountLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_canvasAccountLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _canvasAccountLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.CanvasAccount> getAvailableRootAccounts(
		java.lang.String userToken)
		throws com.liferay.portal.kernel.json.JSONException {
		return _canvasAccountLocalService.getAvailableRootAccounts(userToken);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getUsers(
		java.lang.String accountId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _canvasAccountLocalService.getUsers(accountId);
	}

	@Override
	public java.lang.String addAdmin(java.lang.String accountId,
		java.lang.String userId) throws java.io.IOException {
		return _canvasAccountLocalService.addAdmin(accountId, userId);
	}

	@Override
	public java.lang.String removeAdmin(java.lang.String accountId,
		java.lang.String userId) throws java.io.IOException {
		return _canvasAccountLocalService.removeAdmin(accountId, userId);
	}

	@Override
	public void addPsuedonym(java.lang.String academyCanvasAccountId,
		java.lang.String canvasUserId, java.lang.String emailAddress,
		java.lang.String acadType) {
		_canvasAccountLocalService.addPsuedonym(academyCanvasAccountId,
			canvasUserId, emailAddress, acadType);
	}

	@Override
	public java.lang.String addPseudonym(java.lang.String accountId,
		java.lang.String userId, java.lang.String uniqueIdentifier)
		throws java.io.IOException {
		return _canvasAccountLocalService.addPseudonym(accountId, userId,
			uniqueIdentifier);
	}

	@Override
	public boolean isPseudonymTaken(java.lang.String jsonStr)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.isPseudonymTaken(jsonStr);
	}

	@Override
	public java.lang.String createOrUpdateAccount(java.lang.String name,
		java.lang.String domain) throws java.io.IOException {
		return _canvasAccountLocalService.createOrUpdateAccount(name, domain);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPseudonym(
		java.lang.String accountId, java.lang.String userId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _canvasAccountLocalService.getPseudonym(accountId, userId);
	}

	@Override
	public java.lang.String addSAMLAuthentication(java.lang.String accountId)
		throws java.io.IOException {
		return _canvasAccountLocalService.addSAMLAuthentication(accountId);
	}

	@Override
	public java.lang.String addExternalTools(java.lang.String accountId)
		throws java.io.IOException {
		return _canvasAccountLocalService.addExternalTools(accountId);
	}

	@Override
	public java.lang.String setPermission(java.lang.String accountId,
		java.lang.String roleName, java.lang.String permissionName,
		java.lang.String permission, boolean enabled)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasAccountLocalService.setPermission(accountId, roleName,
			permissionName, permission, enabled);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getAccount(
		java.lang.String accountId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _canvasAccountLocalService.getAccount(accountId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject setAccountName(
		java.lang.String accountId, java.lang.String name)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _canvasAccountLocalService.setAccountName(accountId, name);
	}

	@Override
	public java.lang.String getAccountDomain(java.lang.String userId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _canvasAccountLocalService.getAccountDomain(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CanvasAccountLocalService getWrappedCanvasAccountLocalService() {
		return _canvasAccountLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCanvasAccountLocalService(
		CanvasAccountLocalService canvasAccountLocalService) {
		_canvasAccountLocalService = canvasAccountLocalService;
	}

	@Override
	public CanvasAccountLocalService getWrappedService() {
		return _canvasAccountLocalService;
	}

	@Override
	public void setWrappedService(
		CanvasAccountLocalService canvasAccountLocalService) {
		_canvasAccountLocalService = canvasAccountLocalService;
	}

	private CanvasAccountLocalService _canvasAccountLocalService;
}