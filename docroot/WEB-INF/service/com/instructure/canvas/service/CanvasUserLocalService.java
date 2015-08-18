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
 * Provides the local service interface for CanvasUser. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasUserLocalServiceUtil
 * @see com.instructure.canvas.service.base.CanvasUserLocalServiceBaseImpl
 * @see com.instructure.canvas.service.impl.CanvasUserLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CanvasUserLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CanvasUserLocalServiceUtil} to access the canvas user local service. Add custom service methods to {@link com.instructure.canvas.service.impl.CanvasUserLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the canvas user to the database. Also notifies the appropriate model listeners.
	*
	* @param canvasUser the canvas user
	* @return the canvas user that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.instructure.canvas.model.CanvasUser addCanvasUser(
		com.instructure.canvas.model.CanvasUser canvasUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new canvas user with the primary key. Does not add the canvas user to the database.
	*
	* @param userId the primary key for the new canvas user
	* @return the new canvas user
	*/
	public com.instructure.canvas.model.CanvasUser createCanvasUser(long userId);

	/**
	* Deletes the canvas user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the canvas user
	* @return the canvas user that was removed
	* @throws PortalException if a canvas user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.instructure.canvas.model.CanvasUser deleteCanvasUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the canvas user from the database. Also notifies the appropriate model listeners.
	*
	* @param canvasUser the canvas user
	* @return the canvas user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.instructure.canvas.model.CanvasUser deleteCanvasUser(
		com.instructure.canvas.model.CanvasUser canvasUser)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public com.instructure.canvas.model.CanvasUser fetchCanvasUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the canvas user with the primary key.
	*
	* @param userId the primary key of the canvas user
	* @return the canvas user
	* @throws PortalException if a canvas user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.instructure.canvas.model.CanvasUser getCanvasUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.instructure.canvas.model.CanvasUser> getCanvasUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of canvas users.
	*
	* @return the number of canvas users
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCanvasUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the canvas user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param canvasUser the canvas user
	* @return the canvas user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.instructure.canvas.model.CanvasUser updateCanvasUser(
		com.instructure.canvas.model.CanvasUser canvasUser)
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
	public java.util.List<com.instructure.canvas.model.CanvasUser> getTeachersByCourseId(
		java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.instructure.canvas.model.CanvasUser> getStudentsByCourseId(
		java.lang.String courseId, int[] total, int page, int perPage,
		java.lang.String orderBy, boolean ascending)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.instructure.canvas.model.CanvasUser> getStudentsByCourseId(
		java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.instructure.canvas.model.CanvasUser> searchUsers(
		java.lang.String rootAccountId, java.lang.String keywords, int[] total,
		int page, int perPage, java.lang.String orderBy, boolean ascending)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String createUser(java.lang.String userId,
		java.lang.String loginId, java.lang.String password,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String email, java.lang.String status,
		java.lang.String rootAccountId) throws java.io.IOException;

	public java.lang.String updateUser(java.lang.String userId,
		java.lang.String fullName) throws java.io.IOException;

	public java.lang.String updateUser(java.lang.String userId,
		java.lang.String fullName, java.lang.String language)
		throws java.io.IOException;

	public java.lang.String updateUser(java.lang.String userId,
		java.lang.String fullName, java.lang.String language,
		java.lang.String avatarUrl) throws java.io.IOException;

	public java.lang.String updateUserTimeZone(java.lang.String userId,
		java.lang.String fullName, java.lang.String timeZoneId)
		throws java.io.IOException;

	public java.lang.String updateUser(java.lang.String userId,
		java.lang.String fullName, java.lang.String language,
		java.lang.String avatarUrl, java.lang.String timeZoneId)
		throws java.io.IOException;

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
	public java.lang.String mergerStudentUser(
		java.lang.String sourceCanvasUserId, java.lang.String targetCanvasUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException;

	public void updateEmailNotificationsPreference(java.lang.String userId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateCanvasEmailAddress(java.lang.String userId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException;

	/**
	* This is a workarround to get rid of a canvas bug in accessing source user courses by SAML authentication
	* and updating email address latter from profile due to duplicate pseudonyms which gets created
	* due to merge users as stated in NEX-8273
	*/
	public void fixMergedLogins(java.lang.String canvasUserId,
		java.lang.String targetEmailId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String isExistingUserInCanvas(
		java.lang.String rootAcctID, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException;
}