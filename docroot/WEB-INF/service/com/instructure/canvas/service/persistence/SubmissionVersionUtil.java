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

import com.instructure.canvas.model.SubmissionVersion;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the submission version service. This utility wraps {@link SubmissionVersionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionVersionPersistence
 * @see SubmissionVersionPersistenceImpl
 * @generated
 */
public class SubmissionVersionUtil {
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
	public static void clearCache(SubmissionVersion submissionVersion) {
		getPersistence().clearCache(submissionVersion);
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
	public static List<SubmissionVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubmissionVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubmissionVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SubmissionVersion update(SubmissionVersion submissionVersion)
		throws SystemException {
		return getPersistence().update(submissionVersion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SubmissionVersion update(
		SubmissionVersion submissionVersion, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(submissionVersion, serviceContext);
	}

	/**
	* Caches the submission version in the entity cache if it is enabled.
	*
	* @param submissionVersion the submission version
	*/
	public static void cacheResult(
		com.instructure.canvas.model.SubmissionVersion submissionVersion) {
		getPersistence().cacheResult(submissionVersion);
	}

	/**
	* Caches the submission versions in the entity cache if it is enabled.
	*
	* @param submissionVersions the submission versions
	*/
	public static void cacheResult(
		java.util.List<com.instructure.canvas.model.SubmissionVersion> submissionVersions) {
		getPersistence().cacheResult(submissionVersions);
	}

	/**
	* Creates a new submission version with the primary key. Does not add the submission version to the database.
	*
	* @param submissionId the primary key for the new submission version
	* @return the new submission version
	*/
	public static com.instructure.canvas.model.SubmissionVersion create(
		long submissionId) {
		return getPersistence().create(submissionId);
	}

	/**
	* Removes the submission version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionId the primary key of the submission version
	* @return the submission version that was removed
	* @throws com.instructure.canvas.NoSuchSubmissionVersionException if a submission version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.SubmissionVersion remove(
		long submissionId)
		throws com.instructure.canvas.NoSuchSubmissionVersionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(submissionId);
	}

	public static com.instructure.canvas.model.SubmissionVersion updateImpl(
		com.instructure.canvas.model.SubmissionVersion submissionVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(submissionVersion);
	}

	/**
	* Returns the submission version with the primary key or throws a {@link com.instructure.canvas.NoSuchSubmissionVersionException} if it could not be found.
	*
	* @param submissionId the primary key of the submission version
	* @return the submission version
	* @throws com.instructure.canvas.NoSuchSubmissionVersionException if a submission version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.SubmissionVersion findByPrimaryKey(
		long submissionId)
		throws com.instructure.canvas.NoSuchSubmissionVersionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(submissionId);
	}

	/**
	* Returns the submission version with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param submissionId the primary key of the submission version
	* @return the submission version, or <code>null</code> if a submission version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.SubmissionVersion fetchByPrimaryKey(
		long submissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(submissionId);
	}

	/**
	* Returns all the submission versions.
	*
	* @return the submission versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.SubmissionVersion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the submission versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.SubmissionVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submission versions
	* @param end the upper bound of the range of submission versions (not inclusive)
	* @return the range of submission versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.SubmissionVersion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the submission versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.SubmissionVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submission versions
	* @param end the upper bound of the range of submission versions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of submission versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.SubmissionVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the submission versions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of submission versions.
	*
	* @return the number of submission versions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubmissionVersionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubmissionVersionPersistence)PortletBeanLocatorUtil.locate(com.instructure.canvas.service.ClpSerializer.getServletContextName(),
					SubmissionVersionPersistence.class.getName());

			ReferenceRegistry.registerReference(SubmissionVersionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SubmissionVersionPersistence persistence) {
	}

	private static SubmissionVersionPersistence _persistence;
}