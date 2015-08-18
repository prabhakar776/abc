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
 * Provides the local service utility for CanvasEnrollment. This utility wraps
 * {@link com.instructure.canvas.service.impl.CanvasEnrollmentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasEnrollmentLocalService
 * @see com.instructure.canvas.service.base.CanvasEnrollmentLocalServiceBaseImpl
 * @see com.instructure.canvas.service.impl.CanvasEnrollmentLocalServiceImpl
 * @generated
 */
public class CanvasEnrollmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.instructure.canvas.service.impl.CanvasEnrollmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the canvas enrollment to the database. Also notifies the appropriate model listeners.
	*
	* @param canvasEnrollment the canvas enrollment
	* @return the canvas enrollment that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CanvasEnrollment addCanvasEnrollment(
		com.instructure.canvas.model.CanvasEnrollment canvasEnrollment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCanvasEnrollment(canvasEnrollment);
	}

	/**
	* Creates a new canvas enrollment with the primary key. Does not add the canvas enrollment to the database.
	*
	* @param courseId the primary key for the new canvas enrollment
	* @return the new canvas enrollment
	*/
	public static com.instructure.canvas.model.CanvasEnrollment createCanvasEnrollment(
		long courseId) {
		return getService().createCanvasEnrollment(courseId);
	}

	/**
	* Deletes the canvas enrollment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the canvas enrollment
	* @return the canvas enrollment that was removed
	* @throws PortalException if a canvas enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CanvasEnrollment deleteCanvasEnrollment(
		long courseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCanvasEnrollment(courseId);
	}

	/**
	* Deletes the canvas enrollment from the database. Also notifies the appropriate model listeners.
	*
	* @param canvasEnrollment the canvas enrollment
	* @return the canvas enrollment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CanvasEnrollment deleteCanvasEnrollment(
		com.instructure.canvas.model.CanvasEnrollment canvasEnrollment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCanvasEnrollment(canvasEnrollment);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasEnrollmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasEnrollmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.instructure.canvas.model.CanvasEnrollment fetchCanvasEnrollment(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCanvasEnrollment(courseId);
	}

	/**
	* Returns the canvas enrollment with the primary key.
	*
	* @param courseId the primary key of the canvas enrollment
	* @return the canvas enrollment
	* @throws PortalException if a canvas enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CanvasEnrollment getCanvasEnrollment(
		long courseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCanvasEnrollment(courseId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the canvas enrollments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasEnrollmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of canvas enrollments
	* @param end the upper bound of the range of canvas enrollments (not inclusive)
	* @return the range of canvas enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CanvasEnrollment> getCanvasEnrollments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCanvasEnrollments(start, end);
	}

	/**
	* Returns the number of canvas enrollments.
	*
	* @return the number of canvas enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static int getCanvasEnrollmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCanvasEnrollmentsCount();
	}

	/**
	* Updates the canvas enrollment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param canvasEnrollment the canvas enrollment
	* @return the canvas enrollment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CanvasEnrollment updateCanvasEnrollment(
		com.instructure.canvas.model.CanvasEnrollment canvasEnrollment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCanvasEnrollment(canvasEnrollment);
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

	public static void createEnrollment(java.lang.String courseId,
		java.lang.String userId, java.lang.String role,
		java.lang.String sectionId, java.lang.String status,
		java.lang.String associatedUserId) throws java.io.IOException {
		getService()
			.createEnrollment(courseId, userId, role, sectionId, status,
			associatedUserId);
	}

	public static void unenrollStudent(java.lang.String userId,
		java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().unenrollStudent(userId, courseId);
	}

	public static void unenrollTeacher(java.lang.String userId,
		java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().unenrollTeacher(userId, courseId);
	}

	public static void unenrollUser(java.lang.String type,
		java.lang.String userId, java.lang.String courseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().unenrollUser(type, userId, courseId);
	}

	public static java.util.List<com.instructure.canvas.model.Course> getEnrolledCoursesForStudent(
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnrolledCoursesForStudent(userId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getStudentEnrollmentsForUser(
		java.lang.String userId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return getService().getStudentEnrollmentsForUser(userId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getInstructorEnrollmentsForUser(
		java.lang.String userId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return getService().getInstructorEnrollmentsForUser(userId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getEnrollmentsForUser(
		java.lang.String userId, java.lang.String type)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return getService().getEnrollmentsForUser(userId, type);
	}

	public static java.util.List<com.instructure.canvas.model.CanvasUser> getUncertifiedUsers(
		long companyId, long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUncertifiedUsers(companyId, courseId);
	}

	public static void enrollStudent(long companyId, java.util.Locale locale,
		long creatorUserId, java.lang.String rootAccountId,
		java.lang.String courseId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAddress,
		java.lang.String studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.enrollStudent(companyId, locale, creatorUserId, rootAccountId,
			courseId, firstName, lastName, emailAddress, studentId);
	}

	public static java.lang.String createPseudonymForExistingUser(
		long companyId, com.liferay.portal.model.User user,
		java.lang.String rootAccountId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .createPseudonymForExistingUser(companyId, user,
			rootAccountId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CanvasEnrollmentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CanvasEnrollmentLocalService.class.getName());

			if (invokableLocalService instanceof CanvasEnrollmentLocalService) {
				_service = (CanvasEnrollmentLocalService)invokableLocalService;
			}
			else {
				_service = new CanvasEnrollmentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CanvasEnrollmentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CanvasEnrollmentLocalService service) {
	}

	private static CanvasEnrollmentLocalService _service;
}