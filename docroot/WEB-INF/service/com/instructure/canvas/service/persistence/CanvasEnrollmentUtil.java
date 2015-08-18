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

import com.instructure.canvas.model.CanvasEnrollment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the canvas enrollment service. This utility wraps {@link CanvasEnrollmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasEnrollmentPersistence
 * @see CanvasEnrollmentPersistenceImpl
 * @generated
 */
public class CanvasEnrollmentUtil {
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
	public static void clearCache(CanvasEnrollment canvasEnrollment) {
		getPersistence().clearCache(canvasEnrollment);
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
	public static List<CanvasEnrollment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CanvasEnrollment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CanvasEnrollment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CanvasEnrollment update(CanvasEnrollment canvasEnrollment)
		throws SystemException {
		return getPersistence().update(canvasEnrollment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CanvasEnrollment update(CanvasEnrollment canvasEnrollment,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(canvasEnrollment, serviceContext);
	}

	/**
	* Caches the canvas enrollment in the entity cache if it is enabled.
	*
	* @param canvasEnrollment the canvas enrollment
	*/
	public static void cacheResult(
		com.instructure.canvas.model.CanvasEnrollment canvasEnrollment) {
		getPersistence().cacheResult(canvasEnrollment);
	}

	/**
	* Caches the canvas enrollments in the entity cache if it is enabled.
	*
	* @param canvasEnrollments the canvas enrollments
	*/
	public static void cacheResult(
		java.util.List<com.instructure.canvas.model.CanvasEnrollment> canvasEnrollments) {
		getPersistence().cacheResult(canvasEnrollments);
	}

	/**
	* Creates a new canvas enrollment with the primary key. Does not add the canvas enrollment to the database.
	*
	* @param courseId the primary key for the new canvas enrollment
	* @return the new canvas enrollment
	*/
	public static com.instructure.canvas.model.CanvasEnrollment create(
		long courseId) {
		return getPersistence().create(courseId);
	}

	/**
	* Removes the canvas enrollment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the canvas enrollment
	* @return the canvas enrollment that was removed
	* @throws com.instructure.canvas.NoSuchCanvasEnrollmentException if a canvas enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CanvasEnrollment remove(
		long courseId)
		throws com.instructure.canvas.NoSuchCanvasEnrollmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(courseId);
	}

	public static com.instructure.canvas.model.CanvasEnrollment updateImpl(
		com.instructure.canvas.model.CanvasEnrollment canvasEnrollment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(canvasEnrollment);
	}

	/**
	* Returns the canvas enrollment with the primary key or throws a {@link com.instructure.canvas.NoSuchCanvasEnrollmentException} if it could not be found.
	*
	* @param courseId the primary key of the canvas enrollment
	* @return the canvas enrollment
	* @throws com.instructure.canvas.NoSuchCanvasEnrollmentException if a canvas enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CanvasEnrollment findByPrimaryKey(
		long courseId)
		throws com.instructure.canvas.NoSuchCanvasEnrollmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(courseId);
	}

	/**
	* Returns the canvas enrollment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseId the primary key of the canvas enrollment
	* @return the canvas enrollment, or <code>null</code> if a canvas enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CanvasEnrollment fetchByPrimaryKey(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(courseId);
	}

	/**
	* Returns all the canvas enrollments.
	*
	* @return the canvas enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CanvasEnrollment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.instructure.canvas.model.CanvasEnrollment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the canvas enrollments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasEnrollmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of canvas enrollments
	* @param end the upper bound of the range of canvas enrollments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of canvas enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CanvasEnrollment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the canvas enrollments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of canvas enrollments.
	*
	* @return the number of canvas enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CanvasEnrollmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CanvasEnrollmentPersistence)PortletBeanLocatorUtil.locate(com.instructure.canvas.service.ClpSerializer.getServletContextName(),
					CanvasEnrollmentPersistence.class.getName());

			ReferenceRegistry.registerReference(CanvasEnrollmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CanvasEnrollmentPersistence persistence) {
	}

	private static CanvasEnrollmentPersistence _persistence;
}