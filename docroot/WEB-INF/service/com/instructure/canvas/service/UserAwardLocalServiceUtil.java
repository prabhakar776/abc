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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UserAward. This utility wraps
 * {@link com.instructure.canvas.service.impl.UserAwardLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserAwardLocalService
 * @see com.instructure.canvas.service.base.UserAwardLocalServiceBaseImpl
 * @see com.instructure.canvas.service.impl.UserAwardLocalServiceImpl
 * @generated
 */
public class UserAwardLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.instructure.canvas.service.impl.UserAwardLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user award to the database. Also notifies the appropriate model listeners.
	*
	* @param userAward the user award
	* @return the user award that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward addUserAward(
		com.instructure.canvas.model.UserAward userAward)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserAward(userAward);
	}

	/**
	* Creates a new user award with the primary key. Does not add the user award to the database.
	*
	* @param id the primary key for the new user award
	* @return the new user award
	*/
	public static com.instructure.canvas.model.UserAward createUserAward(
		long id) {
		return getService().createUserAward(id);
	}

	/**
	* Deletes the user award with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the user award
	* @return the user award that was removed
	* @throws PortalException if a user award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward deleteUserAward(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserAward(id);
	}

	/**
	* Deletes the user award from the database. Also notifies the appropriate model listeners.
	*
	* @param userAward the user award
	* @return the user award that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward deleteUserAward(
		com.instructure.canvas.model.UserAward userAward)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserAward(userAward);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.UserAwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.UserAwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.instructure.canvas.model.UserAward fetchUserAward(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserAward(id);
	}

	/**
	* Returns the user award with the primary key.
	*
	* @param id the primary key of the user award
	* @return the user award
	* @throws PortalException if a user award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward getUserAward(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserAward(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.instructure.canvas.model.UserAward> getUserAwards(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserAwards(start, end);
	}

	/**
	* Returns the number of user awards.
	*
	* @return the number of user awards
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserAwardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserAwardsCount();
	}

	/**
	* Updates the user award in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userAward the user award
	* @return the user award that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.UserAward updateUserAward(
		com.instructure.canvas.model.UserAward userAward)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserAward(userAward);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.instructure.canvas.model.UserAward getCertificate(
		long canvasUserId, long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCertificate(canvasUserId, courseId);
	}

	public static com.instructure.canvas.model.UserAward getLetter(
		long canvasUserId, long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLetter(canvasUserId, courseId);
	}

	public static com.instructure.canvas.model.UserAward getUserAward(
		java.lang.String certId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserAward(certId);
	}

	public static java.util.List<com.instructure.canvas.model.UserAward> findByCanvasUserId(
		long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCanvasUserId(canvasUserId);
	}

	/**
	* This method merges certificates and letters of fromCanvasUserId into toCanvasUserId
	*/
	public static java.util.List<com.instructure.canvas.model.UserAward> mergeUserAwards(
		long companyId, long fromCanvasUserId, long toCanvasUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .mergeUserAwards(companyId, fromCanvasUserId, toCanvasUserId);
	}

	/**
	* This method will be executed when the call to canvas fails and we need to remove the copies of files created in repository.
	*
	* @param companyId
	* @param toCanvasUserId
	*/
	public static void revertUserAwards(long companyId, long toCanvasUserId,
		java.util.List<com.instructure.canvas.model.UserAward> toUserAwardsList)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.revertUserAwards(companyId, toCanvasUserId, toUserAwardsList);
	}

	public static com.instructure.canvas.model.UserAward fetchByCourseId(
		long courseId, long canvasUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByCourseId(courseId, canvasUserId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserAwardLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserAwardLocalService.class.getName());

			if (invokableLocalService instanceof UserAwardLocalService) {
				_service = (UserAwardLocalService)invokableLocalService;
			}
			else {
				_service = new UserAwardLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserAwardLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserAwardLocalService service) {
	}

	private static UserAwardLocalService _service;
}