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

import com.instructure.canvas.model.CertLetterQueue;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the cert letter queue service. This utility wraps {@link CertLetterQueuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CertLetterQueuePersistence
 * @see CertLetterQueuePersistenceImpl
 * @generated
 */
public class CertLetterQueueUtil {
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
	public static void clearCache(CertLetterQueue certLetterQueue) {
		getPersistence().clearCache(certLetterQueue);
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
	public static List<CertLetterQueue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CertLetterQueue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CertLetterQueue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CertLetterQueue update(CertLetterQueue certLetterQueue)
		throws SystemException {
		return getPersistence().update(certLetterQueue);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CertLetterQueue update(CertLetterQueue certLetterQueue,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(certLetterQueue, serviceContext);
	}

	/**
	* Returns all the cert letter queues where status = &#63; and errorCount = &#63;.
	*
	* @param status the status
	* @param errorCount the error count
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String status, int errorCount)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndErrorCount(status, errorCount);
	}

	/**
	* Returns a range of all the cert letter queues where status = &#63; and errorCount = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param errorCount the error count
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @return the range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String status, int errorCount, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndErrorCount(status, errorCount, start, end);
	}

	/**
	* Returns an ordered range of all the cert letter queues where status = &#63; and errorCount = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param errorCount the error count
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String status, int errorCount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndErrorCount(status, errorCount, start, end,
			orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where status = &#63; and errorCount = &#63;.
	*
	* @param status the status
	* @param errorCount the error count
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByStatusAndErrorCount_First(
		java.lang.String status, int errorCount,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndErrorCount_First(status, errorCount,
			orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where status = &#63; and errorCount = &#63;.
	*
	* @param status the status
	* @param errorCount the error count
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByStatusAndErrorCount_First(
		java.lang.String status, int errorCount,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndErrorCount_First(status, errorCount,
			orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where status = &#63; and errorCount = &#63;.
	*
	* @param status the status
	* @param errorCount the error count
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByStatusAndErrorCount_Last(
		java.lang.String status, int errorCount,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndErrorCount_Last(status, errorCount,
			orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where status = &#63; and errorCount = &#63;.
	*
	* @param status the status
	* @param errorCount the error count
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByStatusAndErrorCount_Last(
		java.lang.String status, int errorCount,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndErrorCount_Last(status, errorCount,
			orderByComparator);
	}

	/**
	* Returns the cert letter queues before and after the current cert letter queue in the ordered set where status = &#63; and errorCount = &#63;.
	*
	* @param id the primary key of the current cert letter queue
	* @param status the status
	* @param errorCount the error count
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue[] findByStatusAndErrorCount_PrevAndNext(
		long id, java.lang.String status, int errorCount,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndErrorCount_PrevAndNext(id, status,
			errorCount, orderByComparator);
	}

	/**
	* Returns all the cert letter queues where status = any &#63; and errorCount = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statuses the statuses
	* @param errorCounts the error counts
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String[] statuses, int[] errorCounts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndErrorCount(statuses, errorCounts);
	}

	/**
	* Returns a range of all the cert letter queues where status = any &#63; and errorCount = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statuses the statuses
	* @param errorCounts the error counts
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @return the range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String[] statuses, int[] errorCounts, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndErrorCount(statuses, errorCounts, start, end);
	}

	/**
	* Returns an ordered range of all the cert letter queues where status = any &#63; and errorCount = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statuses the statuses
	* @param errorCounts the error counts
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String[] statuses, int[] errorCounts, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndErrorCount(statuses, errorCounts, start,
			end, orderByComparator);
	}

	/**
	* Removes all the cert letter queues where status = &#63; and errorCount = &#63; from the database.
	*
	* @param status the status
	* @param errorCount the error count
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusAndErrorCount(java.lang.String status,
		int errorCount)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusAndErrorCount(status, errorCount);
	}

	/**
	* Returns the number of cert letter queues where status = &#63; and errorCount = &#63;.
	*
	* @param status the status
	* @param errorCount the error count
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndErrorCount(java.lang.String status,
		int errorCount)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndErrorCount(status, errorCount);
	}

	/**
	* Returns the number of cert letter queues where status = any &#63; and errorCount = any &#63;.
	*
	* @param statuses the statuses
	* @param errorCounts the error counts
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndErrorCount(java.lang.String[] statuses,
		int[] errorCounts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndErrorCount(statuses, errorCounts);
	}

	/**
	* Returns all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusCreatedByAndType(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusCreatedByAndType(courseId, status,
			createdBy, type);
	}

	/**
	* Returns a range of all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @return the range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusCreatedByAndType(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusCreatedByAndType(courseId, status,
			createdBy, type, start, end);
	}

	/**
	* Returns an ordered range of all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusCreatedByAndType(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusCreatedByAndType(courseId, status,
			createdBy, type, start, end, orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByCourseIdStatusCreatedByAndType_First(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusCreatedByAndType_First(courseId,
			status, createdBy, type, orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByCourseIdStatusCreatedByAndType_First(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdStatusCreatedByAndType_First(courseId,
			status, createdBy, type, orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByCourseIdStatusCreatedByAndType_Last(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusCreatedByAndType_Last(courseId, status,
			createdBy, type, orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByCourseIdStatusCreatedByAndType_Last(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdStatusCreatedByAndType_Last(courseId,
			status, createdBy, type, orderByComparator);
	}

	/**
	* Returns the cert letter queues before and after the current cert letter queue in the ordered set where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63;.
	*
	* @param id the primary key of the current cert letter queue
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue[] findByCourseIdStatusCreatedByAndType_PrevAndNext(
		long id, long courseId, java.lang.String status, long createdBy,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusCreatedByAndType_PrevAndNext(id,
			courseId, status, createdBy, type, orderByComparator);
	}

	/**
	* Removes all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63; from the database.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseIdStatusCreatedByAndType(long courseId,
		java.lang.String status, long createdBy, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCourseIdStatusCreatedByAndType(courseId, status,
			createdBy, type);
	}

	/**
	* Returns the number of cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseIdStatusCreatedByAndType(long courseId,
		java.lang.String status, long createdBy, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCourseIdStatusCreatedByAndType(courseId, status,
			createdBy, type);
	}

	/**
	* Returns all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusAndCreatedBy(
		long courseId, java.lang.String status, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusAndCreatedBy(courseId, status, createdBy);
	}

	/**
	* Returns a range of all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @return the range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusAndCreatedBy(
		long courseId, java.lang.String status, long createdBy, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusAndCreatedBy(courseId, status,
			createdBy, start, end);
	}

	/**
	* Returns an ordered range of all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusAndCreatedBy(
		long courseId, java.lang.String status, long createdBy, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusAndCreatedBy(courseId, status,
			createdBy, start, end, orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByCourseIdStatusAndCreatedBy_First(
		long courseId, java.lang.String status, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusAndCreatedBy_First(courseId, status,
			createdBy, orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByCourseIdStatusAndCreatedBy_First(
		long courseId, java.lang.String status, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdStatusAndCreatedBy_First(courseId, status,
			createdBy, orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByCourseIdStatusAndCreatedBy_Last(
		long courseId, java.lang.String status, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusAndCreatedBy_Last(courseId, status,
			createdBy, orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByCourseIdStatusAndCreatedBy_Last(
		long courseId, java.lang.String status, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdStatusAndCreatedBy_Last(courseId, status,
			createdBy, orderByComparator);
	}

	/**
	* Returns the cert letter queues before and after the current cert letter queue in the ordered set where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* @param id the primary key of the current cert letter queue
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue[] findByCourseIdStatusAndCreatedBy_PrevAndNext(
		long id, long courseId, java.lang.String status, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdStatusAndCreatedBy_PrevAndNext(id, courseId,
			status, createdBy, orderByComparator);
	}

	/**
	* Removes all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63; from the database.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseIdStatusAndCreatedBy(long courseId,
		java.lang.String status, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCourseIdStatusAndCreatedBy(courseId, status, createdBy);
	}

	/**
	* Returns the number of cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseIdStatusAndCreatedBy(long courseId,
		java.lang.String status, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCourseIdStatusAndCreatedBy(courseId, status,
			createdBy);
	}

	/**
	* Returns all the cert letter queues where courseId = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdAndCreatedBy(
		long courseId, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseIdAndCreatedBy(courseId, createdBy);
	}

	/**
	* Returns a range of all the cert letter queues where courseId = &#63; and createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @return the range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdAndCreatedBy(
		long courseId, long createdBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndCreatedBy(courseId, createdBy, start, end);
	}

	/**
	* Returns an ordered range of all the cert letter queues where courseId = &#63; and createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdAndCreatedBy(
		long courseId, long createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndCreatedBy(courseId, createdBy, start, end,
			orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByCourseIdAndCreatedBy_First(
		long courseId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndCreatedBy_First(courseId, createdBy,
			orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByCourseIdAndCreatedBy_First(
		long courseId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdAndCreatedBy_First(courseId, createdBy,
			orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByCourseIdAndCreatedBy_Last(
		long courseId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndCreatedBy_Last(courseId, createdBy,
			orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByCourseIdAndCreatedBy_Last(
		long courseId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdAndCreatedBy_Last(courseId, createdBy,
			orderByComparator);
	}

	/**
	* Returns the cert letter queues before and after the current cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63;.
	*
	* @param id the primary key of the current cert letter queue
	* @param courseId the course ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue[] findByCourseIdAndCreatedBy_PrevAndNext(
		long id, long courseId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndCreatedBy_PrevAndNext(id, courseId,
			createdBy, orderByComparator);
	}

	/**
	* Removes all the cert letter queues where courseId = &#63; and createdBy = &#63; from the database.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseIdAndCreatedBy(long courseId,
		long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseIdAndCreatedBy(courseId, createdBy);
	}

	/**
	* Returns the number of cert letter queues where courseId = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseIdAndCreatedBy(long courseId, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseIdAndCreatedBy(courseId, createdBy);
	}

	/**
	* Returns all the cert letter queues where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndExpiryDate(
		java.lang.String status, java.util.Date expiryDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndExpiryDate(status, expiryDate);
	}

	/**
	* Returns a range of all the cert letter queues where status = &#63; and expiryDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @return the range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndExpiryDate(
		java.lang.String status, java.util.Date expiryDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndExpiryDate(status, expiryDate, start, end);
	}

	/**
	* Returns an ordered range of all the cert letter queues where status = &#63; and expiryDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndExpiryDate(
		java.lang.String status, java.util.Date expiryDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndExpiryDate(status, expiryDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByStatusAndExpiryDate_First(
		java.lang.String status, java.util.Date expiryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndExpiryDate_First(status, expiryDate,
			orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByStatusAndExpiryDate_First(
		java.lang.String status, java.util.Date expiryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndExpiryDate_First(status, expiryDate,
			orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByStatusAndExpiryDate_Last(
		java.lang.String status, java.util.Date expiryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndExpiryDate_Last(status, expiryDate,
			orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByStatusAndExpiryDate_Last(
		java.lang.String status, java.util.Date expiryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndExpiryDate_Last(status, expiryDate,
			orderByComparator);
	}

	/**
	* Returns the cert letter queues before and after the current cert letter queue in the ordered set where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param id the primary key of the current cert letter queue
	* @param status the status
	* @param expiryDate the expiry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue[] findByStatusAndExpiryDate_PrevAndNext(
		long id, java.lang.String status, java.util.Date expiryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndExpiryDate_PrevAndNext(id, status,
			expiryDate, orderByComparator);
	}

	/**
	* Removes all the cert letter queues where status = &#63; and expiryDate &lt; &#63; from the database.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusAndExpiryDate(java.lang.String status,
		java.util.Date expiryDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusAndExpiryDate(status, expiryDate);
	}

	/**
	* Returns the number of cert letter queues where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndExpiryDate(java.lang.String status,
		java.util.Date expiryDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndExpiryDate(status, expiryDate);
	}

	/**
	* Returns all the cert letter queues where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdCreatedByAndStatusNotEqual(
		long courseId, long createdBy, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdCreatedByAndStatusNotEqual(courseId,
			createdBy, status);
	}

	/**
	* Returns a range of all the cert letter queues where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @return the range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdCreatedByAndStatusNotEqual(
		long courseId, long createdBy, java.lang.String status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdCreatedByAndStatusNotEqual(courseId,
			createdBy, status, start, end);
	}

	/**
	* Returns an ordered range of all the cert letter queues where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdCreatedByAndStatusNotEqual(
		long courseId, long createdBy, java.lang.String status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdCreatedByAndStatusNotEqual(courseId,
			createdBy, status, start, end, orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByCourseIdCreatedByAndStatusNotEqual_First(
		long courseId, long createdBy, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdCreatedByAndStatusNotEqual_First(courseId,
			createdBy, status, orderByComparator);
	}

	/**
	* Returns the first cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByCourseIdCreatedByAndStatusNotEqual_First(
		long courseId, long createdBy, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdCreatedByAndStatusNotEqual_First(courseId,
			createdBy, status, orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByCourseIdCreatedByAndStatusNotEqual_Last(
		long courseId, long createdBy, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdCreatedByAndStatusNotEqual_Last(courseId,
			createdBy, status, orderByComparator);
	}

	/**
	* Returns the last cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByCourseIdCreatedByAndStatusNotEqual_Last(
		long courseId, long createdBy, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdCreatedByAndStatusNotEqual_Last(courseId,
			createdBy, status, orderByComparator);
	}

	/**
	* Returns the cert letter queues before and after the current cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* @param id the primary key of the current cert letter queue
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue[] findByCourseIdCreatedByAndStatusNotEqual_PrevAndNext(
		long id, long courseId, long createdBy, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdCreatedByAndStatusNotEqual_PrevAndNext(id,
			courseId, createdBy, status, orderByComparator);
	}

	/**
	* Removes all the cert letter queues where courseId = &#63; and createdBy = &#63; and status &ne; &#63; from the database.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseIdCreatedByAndStatusNotEqual(
		long courseId, long createdBy, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCourseIdCreatedByAndStatusNotEqual(courseId, createdBy,
			status);
	}

	/**
	* Returns the number of cert letter queues where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseIdCreatedByAndStatusNotEqual(long courseId,
		long createdBy, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCourseIdCreatedByAndStatusNotEqual(courseId,
			createdBy, status);
	}

	/**
	* Caches the cert letter queue in the entity cache if it is enabled.
	*
	* @param certLetterQueue the cert letter queue
	*/
	public static void cacheResult(
		com.instructure.canvas.model.CertLetterQueue certLetterQueue) {
		getPersistence().cacheResult(certLetterQueue);
	}

	/**
	* Caches the cert letter queues in the entity cache if it is enabled.
	*
	* @param certLetterQueues the cert letter queues
	*/
	public static void cacheResult(
		java.util.List<com.instructure.canvas.model.CertLetterQueue> certLetterQueues) {
		getPersistence().cacheResult(certLetterQueues);
	}

	/**
	* Creates a new cert letter queue with the primary key. Does not add the cert letter queue to the database.
	*
	* @param id the primary key for the new cert letter queue
	* @return the new cert letter queue
	*/
	public static com.instructure.canvas.model.CertLetterQueue create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the cert letter queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cert letter queue
	* @return the cert letter queue that was removed
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue remove(long id)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.instructure.canvas.model.CertLetterQueue updateImpl(
		com.instructure.canvas.model.CertLetterQueue certLetterQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(certLetterQueue);
	}

	/**
	* Returns the cert letter queue with the primary key or throws a {@link com.instructure.canvas.NoSuchCertLetterQueueException} if it could not be found.
	*
	* @param id the primary key of the cert letter queue
	* @return the cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue findByPrimaryKey(
		long id)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the cert letter queue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cert letter queue
	* @return the cert letter queue, or <code>null</code> if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.CertLetterQueue fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the cert letter queues.
	*
	* @return the cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cert letter queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @return the range of cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cert letter queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CertLetterQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cert letter queues
	* @param end the upper bound of the range of cert letter queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.CertLetterQueue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cert letter queues from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cert letter queues.
	*
	* @return the number of cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CertLetterQueuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CertLetterQueuePersistence)PortletBeanLocatorUtil.locate(com.instructure.canvas.service.ClpSerializer.getServletContextName(),
					CertLetterQueuePersistence.class.getName());

			ReferenceRegistry.registerReference(CertLetterQueueUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CertLetterQueuePersistence persistence) {
	}

	private static CertLetterQueuePersistence _persistence;
}