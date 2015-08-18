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
 * Provides a wrapper for {@link CanvasUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasUserLocalService
 * @generated
 */
public class CanvasUserLocalServiceWrapper implements CanvasUserLocalService,
	ServiceWrapper<CanvasUserLocalService> {
	public CanvasUserLocalServiceWrapper(
		CanvasUserLocalService canvasUserLocalService) {
		_canvasUserLocalService = canvasUserLocalService;
	}

	/**
	* Adds the canvas user to the database. Also notifies the appropriate model listeners.
	*
	* @param canvasUser the canvas user
	* @return the canvas user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.CanvasUser addCanvasUser(
		com.instructure.canvas.model.CanvasUser canvasUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.addCanvasUser(canvasUser);
	}

	/**
	* Creates a new canvas user with the primary key. Does not add the canvas user to the database.
	*
	* @param userId the primary key for the new canvas user
	* @return the new canvas user
	*/
	@Override
	public com.instructure.canvas.model.CanvasUser createCanvasUser(long userId) {
		return _canvasUserLocalService.createCanvasUser(userId);
	}

	/**
	* Deletes the canvas user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the canvas user
	* @return the canvas user that was removed
	* @throws PortalException if a canvas user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.CanvasUser deleteCanvasUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.deleteCanvasUser(userId);
	}

	/**
	* Deletes the canvas user from the database. Also notifies the appropriate model listeners.
	*
	* @param canvasUser the canvas user
	* @return the canvas user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.CanvasUser deleteCanvasUser(
		com.instructure.canvas.model.CanvasUser canvasUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.deleteCanvasUser(canvasUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _canvasUserLocalService.dynamicQuery();
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
		return _canvasUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _canvasUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _canvasUserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _canvasUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _canvasUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.instructure.canvas.model.CanvasUser fetchCanvasUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.fetchCanvasUser(userId);
	}

	/**
	* Returns the canvas user with the primary key.
	*
	* @param userId the primary key of the canvas user
	* @return the canvas user
	* @throws PortalException if a canvas user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.CanvasUser getCanvasUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.getCanvasUser(userId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.instructure.canvas.model.CanvasUser> getCanvasUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.getCanvasUsers(start, end);
	}

	/**
	* Returns the number of canvas users.
	*
	* @return the number of canvas users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCanvasUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.getCanvasUsersCount();
	}

	/**
	* Updates the canvas user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param canvasUser the canvas user
	* @return the canvas user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.CanvasUser updateCanvasUser(
		com.instructure.canvas.model.CanvasUser canvasUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.updateCanvasUser(canvasUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _canvasUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_canvasUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _canvasUserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.CanvasUser> getTeachersByCourseId(
		java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _canvasUserLocalService.getTeachersByCourseId(courseId);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.CanvasUser> getStudentsByCourseId(
		java.lang.String courseId, int[] total, int page, int perPage,
		java.lang.String orderBy, boolean ascending)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.getStudentsByCourseId(courseId, total,
			page, perPage, orderBy, ascending);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.CanvasUser> getStudentsByCourseId(
		java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.getStudentsByCourseId(courseId);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.CanvasUser> searchUsers(
		java.lang.String rootAccountId, java.lang.String keywords, int[] total,
		int page, int perPage, java.lang.String orderBy, boolean ascending)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _canvasUserLocalService.searchUsers(rootAccountId, keywords,
			total, page, perPage, orderBy, ascending);
	}

	@Override
	public java.lang.String createUser(java.lang.String userId,
		java.lang.String loginId, java.lang.String password,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String email, java.lang.String status,
		java.lang.String rootAccountId) throws java.io.IOException {
		return _canvasUserLocalService.createUser(userId, loginId, password,
			firstName, lastName, email, status, rootAccountId);
	}

	@Override
	public java.lang.String updateUser(java.lang.String userId,
		java.lang.String fullName) throws java.io.IOException {
		return _canvasUserLocalService.updateUser(userId, fullName);
	}

	@Override
	public java.lang.String updateUser(java.lang.String userId,
		java.lang.String fullName, java.lang.String language)
		throws java.io.IOException {
		return _canvasUserLocalService.updateUser(userId, fullName, language);
	}

	@Override
	public java.lang.String updateUser(java.lang.String userId,
		java.lang.String fullName, java.lang.String language,
		java.lang.String avatarUrl) throws java.io.IOException {
		return _canvasUserLocalService.updateUser(userId, fullName, language,
			avatarUrl);
	}

	@Override
	public java.lang.String updateUserTimeZone(java.lang.String userId,
		java.lang.String fullName, java.lang.String timeZoneId)
		throws java.io.IOException {
		return _canvasUserLocalService.updateUserTimeZone(userId, fullName,
			timeZoneId);
	}

	@Override
	public java.lang.String updateUser(java.lang.String userId,
		java.lang.String fullName, java.lang.String language,
		java.lang.String avatarUrl, java.lang.String timeZoneId)
		throws java.io.IOException {
		return _canvasUserLocalService.updateUser(userId, fullName, language,
			avatarUrl, timeZoneId);
	}

	/**
	* Provide capability to merge Pure Student User Accounts in NetSpace
	*
	* @param sourceCanvasUserId
	* @param targetCanvasUserId
	* @return
	* @throws IOException
	* @throws SystemException
	* @throws PortalException
	*/
	@Override
	public java.lang.String mergerStudentUser(
		java.lang.String sourceCanvasUserId, java.lang.String targetCanvasUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _canvasUserLocalService.mergerStudentUser(sourceCanvasUserId,
			targetCanvasUserId);
	}

	@Override
	public void updateEmailNotificationsPreference(java.lang.String userId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		_canvasUserLocalService.updateEmailNotificationsPreference(userId,
			emailAddress);
	}

	@Override
	public void updateCanvasEmailAddress(java.lang.String userId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		_canvasUserLocalService.updateCanvasEmailAddress(userId, emailAddress);
	}

	/**
	* This is a workarround to get rid of a canvas bug in accessing source user courses by SAML authentication
	* and updating email address latter from profile due to duplicate pseudonyms which gets created
	* due to merge users as stated in NEX-8273
	*/
	@Override
	public void fixMergedLogins(java.lang.String canvasUserId,
		java.lang.String targetEmailId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		_canvasUserLocalService.fixMergedLogins(canvasUserId, targetEmailId);
	}

	@Override
	public java.lang.String isExistingUserInCanvas(
		java.lang.String rootAcctID, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _canvasUserLocalService.isExistingUserInCanvas(rootAcctID,
			emailAddress);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CanvasUserLocalService getWrappedCanvasUserLocalService() {
		return _canvasUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCanvasUserLocalService(
		CanvasUserLocalService canvasUserLocalService) {
		_canvasUserLocalService = canvasUserLocalService;
	}

	@Override
	public CanvasUserLocalService getWrappedService() {
		return _canvasUserLocalService;
	}

	@Override
	public void setWrappedService(CanvasUserLocalService canvasUserLocalService) {
		_canvasUserLocalService = canvasUserLocalService;
	}

	private CanvasUserLocalService _canvasUserLocalService;
}