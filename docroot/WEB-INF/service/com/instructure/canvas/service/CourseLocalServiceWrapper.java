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
 * Provides a wrapper for {@link CourseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CourseLocalService
 * @generated
 */
public class CourseLocalServiceWrapper implements CourseLocalService,
	ServiceWrapper<CourseLocalService> {
	public CourseLocalServiceWrapper(CourseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}

	/**
	* Adds the course to the database. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.Course addCourse(
		com.instructure.canvas.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.addCourse(course);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param canvasId the primary key for the new course
	* @return the new course
	*/
	@Override
	public com.instructure.canvas.model.Course createCourse(long canvasId) {
		return _courseLocalService.createCourse(canvasId);
	}

	/**
	* Deletes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param canvasId the primary key of the course
	* @return the course that was removed
	* @throws PortalException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.Course deleteCourse(long canvasId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.deleteCourse(canvasId);
	}

	/**
	* Deletes the course from the database. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.Course deleteCourse(
		com.instructure.canvas.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.deleteCourse(course);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseLocalService.dynamicQuery();
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
		return _courseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _courseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _courseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.instructure.canvas.model.Course fetchCourse(long canvasId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.fetchCourse(canvasId);
	}

	/**
	* Returns the course with the primary key.
	*
	* @param canvasId the primary key of the course
	* @return the course
	* @throws PortalException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.Course getCourse(long canvasId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.getCourse(canvasId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of courses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.instructure.canvas.model.Course> getCourses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.getCourses(start, end);
	}

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCoursesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.getCoursesCount();
	}

	/**
	* Updates the course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.Course updateCourse(
		com.instructure.canvas.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.updateCourse(course);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String createCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String longName,
		java.lang.String accountId, java.lang.String termId,
		java.lang.String status, java.lang.String netacadCoreOfferingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _courseLocalService.createCourse(courseId, shortName, longName,
			accountId, termId, status, netacadCoreOfferingId);
	}

	@Override
	public java.lang.String createCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String longName,
		java.lang.String accountId, java.lang.String termId,
		java.lang.String status, java.lang.String netacadCoreOfferingId,
		int startYear, int startMonth, int startDay, int concludeYear,
		int concludeMonth, int concludeDay, java.lang.String timeZoneId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _courseLocalService.createCourse(courseId, shortName, longName,
			accountId, termId, status, netacadCoreOfferingId, startYear,
			startMonth, startDay, concludeYear, concludeMonth, concludeDay,
			timeZoneId);
	}

	@Override
	public java.lang.String createCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String longName,
		java.lang.String accountId, java.lang.String termId,
		java.lang.String status, java.lang.String netacadCoreOfferingId,
		int startYear, int startMonth, int startDay, int concludeYear,
		int concludeMonth, int concludeDay, java.lang.String timeZoneId,
		boolean enforceDates)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _courseLocalService.createCourse(courseId, shortName, longName,
			accountId, termId, status, netacadCoreOfferingId, startYear,
			startMonth, startDay, concludeYear, concludeMonth, concludeDay,
			timeZoneId, enforceDates);
	}

	@Override
	public java.lang.String createCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String longName,
		java.lang.String accountId, java.lang.String termId,
		java.lang.String status, java.lang.String netacadCoreOfferingId,
		int startYear, int startMonth, int startDay, int concludeYear,
		int concludeMonth, int concludeDay, java.lang.String timeZoneId,
		boolean enforceDates, java.lang.String netacadCVLId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _courseLocalService.createCourse(courseId, shortName, longName,
			accountId, termId, status, netacadCoreOfferingId, startYear,
			startMonth, startDay, concludeYear, concludeMonth, concludeDay,
			timeZoneId, enforceDates, netacadCVLId);
	}

	@Override
	public com.instructure.canvas.model.Course getCourseByOID(
		java.lang.String oid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.getCourseByOID(oid);
	}

	@Override
	public com.instructure.canvas.model.Course getCourseById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.getCourseById(id);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.Course> getCoursesByCVLId(
		java.util.List<java.lang.String> cvlIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.getCoursesByCVLId(cvlIds);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.Course> getAllCourses(
		java.lang.String rootAccountId)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _courseLocalService.getAllCourses(rootAccountId);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.Course> getCourses(
		java.lang.String userToken)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _courseLocalService.getCourses(userToken);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.Course> getCourses(
		java.lang.String userToken, java.lang.String[] state)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return _courseLocalService.getCourses(userToken, state);
	}

	/**
	* Adds the activity stream to the database. Also notifies the appropriate model listeners.
	*
	* @param userToken the users Canvas ID
	* @param isStudent true for student, false for instructor. If you want both, use getCourses(String userToken)
	* @return the activity stream that was added
	*/
	@Override
	public java.util.List<com.instructure.canvas.model.Course> getCourses(
		java.lang.String userToken, boolean isStudent)
		throws com.liferay.portal.kernel.json.JSONException {
		return _courseLocalService.getCourses(userToken, isStudent);
	}

	/**
	* Adds the activity stream to the database. Also notifies the appropriate model listeners.
	*
	* @param userToken the users Canvas ID
	* @param isStudent true for student, false for instructor. If you want both, use getCourses(String userToken)
	* @param state the states of the courses to retrieve 'unpublished', 'available', 'completed', 'deleted'
	* @return the activity stream that was added
	*/
	@Override
	public java.util.List<com.instructure.canvas.model.Course> getCourses(
		java.lang.String userToken, boolean isStudent, java.lang.String[] state)
		throws com.liferay.portal.kernel.json.JSONException {
		return _courseLocalService.getCourses(userToken, isStudent, state);
	}

	/**
	* Get the distinct enrolled courses for the instructor.
	*
	* @param userId the user id.
	* @return the list of courses.
	*/
	@Override
	public java.util.List<com.instructure.canvas.model.Course> getDistinctEnrolledCoursesForInstructor(
		java.lang.String userId) {
		return _courseLocalService.getDistinctEnrolledCoursesForInstructor(userId);
	}

	@Override
	public com.instructure.canvas.model.Course getCourse(
		java.lang.String userToken, long courseId)
		throws com.liferay.portal.kernel.json.JSONException {
		return _courseLocalService.getCourse(userToken, courseId);
	}

	@Override
	public boolean isQualifiedForCertificate(long courseId, long canvasUserId) {
		return _courseLocalService.isQualifiedForCertificate(courseId,
			canvasUserId);
	}

	@Override
	public boolean isQualifiedForLetter(long courseId, long canvasUserId) {
		return _courseLocalService.isQualifiedForLetter(courseId, canvasUserId);
	}

	@Override
	public void updateCourse(java.lang.String courseId,
		java.lang.String shortName, java.lang.String courseCode, int startDay,
		int startMonth, int startYear, int concludeDay, int concludeMonth,
		int concludeYear, java.lang.String timeZoneId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseLocalService.updateCourse(courseId, shortName, courseCode,
			startDay, startMonth, startYear, concludeDay, concludeMonth,
			concludeYear, timeZoneId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseLocalService getWrappedCourseLocalService() {
		return _courseLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseLocalService(
		CourseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}

	@Override
	public CourseLocalService getWrappedService() {
		return _courseLocalService;
	}

	@Override
	public void setWrappedService(CourseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}

	private CourseLocalService _courseLocalService;
}