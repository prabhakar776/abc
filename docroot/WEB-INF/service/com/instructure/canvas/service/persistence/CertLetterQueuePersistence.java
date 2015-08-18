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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the cert letter queue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CertLetterQueuePersistenceImpl
 * @see CertLetterQueueUtil
 * @generated
 */
public interface CertLetterQueuePersistence extends BasePersistence<CertLetterQueue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CertLetterQueueUtil} to access the cert letter queue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cert letter queues where status = &#63; and errorCount = &#63;.
	*
	* @param status the status
	* @param errorCount the error count
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String status, int errorCount)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String status, int errorCount, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String status, int errorCount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByStatusAndErrorCount_First(
		java.lang.String status, int errorCount,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cert letter queue in the ordered set where status = &#63; and errorCount = &#63;.
	*
	* @param status the status
	* @param errorCount the error count
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CertLetterQueue fetchByStatusAndErrorCount_First(
		java.lang.String status, int errorCount,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByStatusAndErrorCount_Last(
		java.lang.String status, int errorCount,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cert letter queue in the ordered set where status = &#63; and errorCount = &#63;.
	*
	* @param status the status
	* @param errorCount the error count
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CertLetterQueue fetchByStatusAndErrorCount_Last(
		java.lang.String status, int errorCount,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue[] findByStatusAndErrorCount_PrevAndNext(
		long id, java.lang.String status, int errorCount,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String[] statuses, int[] errorCounts)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String[] statuses, int[] errorCounts, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndErrorCount(
		java.lang.String[] statuses, int[] errorCounts, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cert letter queues where status = &#63; and errorCount = &#63; from the database.
	*
	* @param status the status
	* @param errorCount the error count
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndErrorCount(java.lang.String status,
		int errorCount)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cert letter queues where status = &#63; and errorCount = &#63;.
	*
	* @param status the status
	* @param errorCount the error count
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndErrorCount(java.lang.String status,
		int errorCount)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cert letter queues where status = any &#63; and errorCount = any &#63;.
	*
	* @param statuses the statuses
	* @param errorCounts the error counts
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndErrorCount(java.lang.String[] statuses,
		int[] errorCounts)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusCreatedByAndType(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusCreatedByAndType(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusCreatedByAndType(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByCourseIdStatusCreatedByAndType_First(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue fetchByCourseIdStatusCreatedByAndType_First(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByCourseIdStatusCreatedByAndType_Last(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue fetchByCourseIdStatusCreatedByAndType_Last(
		long courseId, java.lang.String status, long createdBy,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue[] findByCourseIdStatusCreatedByAndType_PrevAndNext(
		long id, long courseId, java.lang.String status, long createdBy,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63; and type = &#63; from the database.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseIdStatusCreatedByAndType(long courseId,
		java.lang.String status, long createdBy, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCourseIdStatusCreatedByAndType(long courseId,
		java.lang.String status, long createdBy, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusAndCreatedBy(
		long courseId, java.lang.String status, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusAndCreatedBy(
		long courseId, java.lang.String status, long createdBy, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdStatusAndCreatedBy(
		long courseId, java.lang.String status, long createdBy, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByCourseIdStatusAndCreatedBy_First(
		long courseId, java.lang.String status, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue fetchByCourseIdStatusAndCreatedBy_First(
		long courseId, java.lang.String status, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByCourseIdStatusAndCreatedBy_Last(
		long courseId, java.lang.String status, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue fetchByCourseIdStatusAndCreatedBy_Last(
		long courseId, java.lang.String status, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue[] findByCourseIdStatusAndCreatedBy_PrevAndNext(
		long id, long courseId, java.lang.String status, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63; from the database.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseIdStatusAndCreatedBy(long courseId,
		java.lang.String status, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param createdBy the created by
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseIdStatusAndCreatedBy(long courseId,
		java.lang.String status, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cert letter queues where courseId = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdAndCreatedBy(
		long courseId, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdAndCreatedBy(
		long courseId, long createdBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdAndCreatedBy(
		long courseId, long createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByCourseIdAndCreatedBy_First(
		long courseId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CertLetterQueue fetchByCourseIdAndCreatedBy_First(
		long courseId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByCourseIdAndCreatedBy_Last(
		long courseId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cert letter queue in the ordered set where courseId = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CertLetterQueue fetchByCourseIdAndCreatedBy_Last(
		long courseId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue[] findByCourseIdAndCreatedBy_PrevAndNext(
		long id, long courseId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cert letter queues where courseId = &#63; and createdBy = &#63; from the database.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseIdAndCreatedBy(long courseId, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cert letter queues where courseId = &#63; and createdBy = &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseIdAndCreatedBy(long courseId, long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cert letter queues where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndExpiryDate(
		java.lang.String status, java.util.Date expiryDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndExpiryDate(
		java.lang.String status, java.util.Date expiryDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByStatusAndExpiryDate(
		java.lang.String status, java.util.Date expiryDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByStatusAndExpiryDate_First(
		java.lang.String status, java.util.Date expiryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cert letter queue in the ordered set where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CertLetterQueue fetchByStatusAndExpiryDate_First(
		java.lang.String status, java.util.Date expiryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByStatusAndExpiryDate_Last(
		java.lang.String status, java.util.Date expiryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cert letter queue in the ordered set where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cert letter queue, or <code>null</code> if a matching cert letter queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CertLetterQueue fetchByStatusAndExpiryDate_Last(
		java.lang.String status, java.util.Date expiryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue[] findByStatusAndExpiryDate_PrevAndNext(
		long id, java.lang.String status, java.util.Date expiryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cert letter queues where status = &#63; and expiryDate &lt; &#63; from the database.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndExpiryDate(java.lang.String status,
		java.util.Date expiryDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cert letter queues where status = &#63; and expiryDate &lt; &#63;.
	*
	* @param status the status
	* @param expiryDate the expiry date
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndExpiryDate(java.lang.String status,
		java.util.Date expiryDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cert letter queues where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @return the matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdCreatedByAndStatusNotEqual(
		long courseId, long createdBy, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdCreatedByAndStatusNotEqual(
		long courseId, long createdBy, java.lang.String status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findByCourseIdCreatedByAndStatusNotEqual(
		long courseId, long createdBy, java.lang.String status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByCourseIdCreatedByAndStatusNotEqual_First(
		long courseId, long createdBy, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue fetchByCourseIdCreatedByAndStatusNotEqual_First(
		long courseId, long createdBy, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue findByCourseIdCreatedByAndStatusNotEqual_Last(
		long courseId, long createdBy, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue fetchByCourseIdCreatedByAndStatusNotEqual_Last(
		long courseId, long createdBy, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.instructure.canvas.model.CertLetterQueue[] findByCourseIdCreatedByAndStatusNotEqual_PrevAndNext(
		long id, long courseId, long createdBy, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cert letter queues where courseId = &#63; and createdBy = &#63; and status &ne; &#63; from the database.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseIdCreatedByAndStatusNotEqual(long courseId,
		long createdBy, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cert letter queues where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	*
	* @param courseId the course ID
	* @param createdBy the created by
	* @param status the status
	* @return the number of matching cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseIdCreatedByAndStatusNotEqual(long courseId,
		long createdBy, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the cert letter queue in the entity cache if it is enabled.
	*
	* @param certLetterQueue the cert letter queue
	*/
	public void cacheResult(
		com.instructure.canvas.model.CertLetterQueue certLetterQueue);

	/**
	* Caches the cert letter queues in the entity cache if it is enabled.
	*
	* @param certLetterQueues the cert letter queues
	*/
	public void cacheResult(
		java.util.List<com.instructure.canvas.model.CertLetterQueue> certLetterQueues);

	/**
	* Creates a new cert letter queue with the primary key. Does not add the cert letter queue to the database.
	*
	* @param id the primary key for the new cert letter queue
	* @return the new cert letter queue
	*/
	public com.instructure.canvas.model.CertLetterQueue create(long id);

	/**
	* Removes the cert letter queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cert letter queue
	* @return the cert letter queue that was removed
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CertLetterQueue remove(long id)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.instructure.canvas.model.CertLetterQueue updateImpl(
		com.instructure.canvas.model.CertLetterQueue certLetterQueue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cert letter queue with the primary key or throws a {@link com.instructure.canvas.NoSuchCertLetterQueueException} if it could not be found.
	*
	* @param id the primary key of the cert letter queue
	* @return the cert letter queue
	* @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CertLetterQueue findByPrimaryKey(
		long id)
		throws com.instructure.canvas.NoSuchCertLetterQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cert letter queue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cert letter queue
	* @return the cert letter queue, or <code>null</code> if a cert letter queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.instructure.canvas.model.CertLetterQueue fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cert letter queues.
	*
	* @return the cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.instructure.canvas.model.CertLetterQueue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cert letter queues from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cert letter queues.
	*
	* @return the number of cert letter queues
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}