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

import com.instructure.canvas.model.Course;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the course service. This utility wraps {@link CoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoursePersistence
 * @see CoursePersistenceImpl
 * @generated
 */
public class CourseUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Course course) {
		getPersistence().clearCache(course);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Course update(Course course) throws SystemException {
		return getPersistence().update(course);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Course update(Course course, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(course, serviceContext);
	}

	/**
	* Returns the course where id = &#63; or throws a {@link com.instructure.canvas.NoSuchCourseException} if it could not be found.
	*
	* @param id the ID
	* @return the matching course
	* @throws com.instructure.canvas.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course findById(long id)
		throws com.instructure.canvas.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findById(id);
	}

	/**
	* Returns the course where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course fetchById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id);
	}

	/**
	* Returns the course where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course fetchById(long id,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id, retrieveFromCache);
	}

	/**
	* Removes the course where id = &#63; from the database.
	*
	* @param id the ID
	* @return the course that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course removeById(long id)
		throws com.instructure.canvas.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeById(id);
	}

	/**
	* Returns the number of courses where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countById(id);
	}

	/**
	* Returns the course where netacadCoreOfferingId = &#63; or throws a {@link com.instructure.canvas.NoSuchCourseException} if it could not be found.
	*
	* @param netacadCoreOfferingId the netacad core offering ID
	* @return the matching course
	* @throws com.instructure.canvas.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course findByNetacadOfferingId(
		java.lang.String netacadCoreOfferingId)
		throws com.instructure.canvas.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNetacadOfferingId(netacadCoreOfferingId);
	}

	/**
	* Returns the course where netacadCoreOfferingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param netacadCoreOfferingId the netacad core offering ID
	* @return the matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course fetchByNetacadOfferingId(
		java.lang.String netacadCoreOfferingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNetacadOfferingId(netacadCoreOfferingId);
	}

	/**
	* Returns the course where netacadCoreOfferingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param netacadCoreOfferingId the netacad core offering ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course fetchByNetacadOfferingId(
		java.lang.String netacadCoreOfferingId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetacadOfferingId(netacadCoreOfferingId,
			retrieveFromCache);
	}

	/**
	* Removes the course where netacadCoreOfferingId = &#63; from the database.
	*
	* @param netacadCoreOfferingId the netacad core offering ID
	* @return the course that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course removeByNetacadOfferingId(
		java.lang.String netacadCoreOfferingId)
		throws com.instructure.canvas.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByNetacadOfferingId(netacadCoreOfferingId);
	}

	/**
	* Returns the number of courses where netacadCoreOfferingId = &#63;.
	*
	* @param netacadCoreOfferingId the netacad core offering ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNetacadOfferingId(
		java.lang.String netacadCoreOfferingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNetacadOfferingId(netacadCoreOfferingId);
	}

	/**
	* Returns all the courses where netacadCVLId = &#63;.
	*
	* @param netacadCVLId the netacad c v l ID
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.Course> findByNetacadCVLId(
		java.lang.String netacadCVLId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNetacadCVLId(netacadCVLId);
	}

	/**
	* Returns a range of all the courses where netacadCVLId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param netacadCVLId the netacad c v l ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.Course> findByNetacadCVLId(
		java.lang.String netacadCVLId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNetacadCVLId(netacadCVLId, start, end);
	}

	/**
	* Returns an ordered range of all the courses where netacadCVLId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param netacadCVLId the netacad c v l ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.Course> findByNetacadCVLId(
		java.lang.String netacadCVLId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetacadCVLId(netacadCVLId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where netacadCVLId = &#63;.
	*
	* @param netacadCVLId the netacad c v l ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws com.instructure.canvas.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course findByNetacadCVLId_First(
		java.lang.String netacadCVLId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetacadCVLId_First(netacadCVLId, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where netacadCVLId = &#63;.
	*
	* @param netacadCVLId the netacad c v l ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course fetchByNetacadCVLId_First(
		java.lang.String netacadCVLId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetacadCVLId_First(netacadCVLId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where netacadCVLId = &#63;.
	*
	* @param netacadCVLId the netacad c v l ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws com.instructure.canvas.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course findByNetacadCVLId_Last(
		java.lang.String netacadCVLId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetacadCVLId_Last(netacadCVLId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where netacadCVLId = &#63;.
	*
	* @param netacadCVLId the netacad c v l ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course fetchByNetacadCVLId_Last(
		java.lang.String netacadCVLId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetacadCVLId_Last(netacadCVLId, orderByComparator);
	}

	/**
	* Returns the courses before and after the current course in the ordered set where netacadCVLId = &#63;.
	*
	* @param canvasId the primary key of the current course
	* @param netacadCVLId the netacad c v l ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws com.instructure.canvas.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course[] findByNetacadCVLId_PrevAndNext(
		long canvasId, java.lang.String netacadCVLId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetacadCVLId_PrevAndNext(canvasId, netacadCVLId,
			orderByComparator);
	}

	/**
	* Removes all the courses where netacadCVLId = &#63; from the database.
	*
	* @param netacadCVLId the netacad c v l ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNetacadCVLId(java.lang.String netacadCVLId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNetacadCVLId(netacadCVLId);
	}

	/**
	* Returns the number of courses where netacadCVLId = &#63;.
	*
	* @param netacadCVLId the netacad c v l ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNetacadCVLId(java.lang.String netacadCVLId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNetacadCVLId(netacadCVLId);
	}

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course
	*/
	public static void cacheResult(com.instructure.canvas.model.Course course) {
		getPersistence().cacheResult(course);
	}

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public static void cacheResult(
		java.util.List<com.instructure.canvas.model.Course> courses) {
		getPersistence().cacheResult(courses);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param canvasId the primary key for the new course
	* @return the new course
	*/
	public static com.instructure.canvas.model.Course create(long canvasId) {
		return getPersistence().create(canvasId);
	}

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param canvasId the primary key of the course
	* @return the course that was removed
	* @throws com.instructure.canvas.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course remove(long canvasId)
		throws com.instructure.canvas.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(canvasId);
	}

	public static com.instructure.canvas.model.Course updateImpl(
		com.instructure.canvas.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(course);
	}

	/**
	* Returns the course with the primary key or throws a {@link com.instructure.canvas.NoSuchCourseException} if it could not be found.
	*
	* @param canvasId the primary key of the course
	* @return the course
	* @throws com.instructure.canvas.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course findByPrimaryKey(
		long canvasId)
		throws com.instructure.canvas.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(canvasId);
	}

	/**
	* Returns the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param canvasId the primary key of the course
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Course fetchByPrimaryKey(
		long canvasId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(canvasId);
	}

	/**
	* Returns all the courses.
	*
	* @return the courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.Course> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.instructure.canvas.model.Course> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.Course> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the courses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CoursePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoursePersistence)PortletBeanLocatorUtil.locate(com.instructure.canvas.service.ClpSerializer.getServletContextName(),
					CoursePersistence.class.getName());

			ReferenceRegistry.registerReference(CourseUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CoursePersistence persistence) {
	}

	private static CoursePersistence _persistence;
}