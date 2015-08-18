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

import com.instructure.canvas.NoSuchCertLetterQueueException;
import com.instructure.canvas.model.CertLetterQueue;
import com.instructure.canvas.model.impl.CertLetterQueueImpl;
import com.instructure.canvas.model.impl.CertLetterQueueModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the cert letter queue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CertLetterQueuePersistence
 * @see CertLetterQueueUtil
 * @generated
 */
public class CertLetterQueuePersistenceImpl extends BasePersistenceImpl<CertLetterQueue>
	implements CertLetterQueuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CertLetterQueueUtil} to access the cert letter queue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CertLetterQueueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDERRORCOUNT =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatusAndErrorCount",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDERRORCOUNT =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusAndErrorCount",
			new String[] { String.class.getName(), Integer.class.getName() },
			CertLetterQueueModelImpl.STATUS_COLUMN_BITMASK |
			CertLetterQueueModelImpl.ERRORCOUNT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDERRORCOUNT = new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndErrorCount",
			new String[] { String.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSANDERRORCOUNT =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByStatusAndErrorCount",
			new String[] { String.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the cert letter queues where status = &#63; and errorCount = &#63;.
	 *
	 * @param status the status
	 * @param errorCount the error count
	 * @return the matching cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CertLetterQueue> findByStatusAndErrorCount(String status,
		int errorCount) throws SystemException {
		return findByStatusAndErrorCount(status, errorCount, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CertLetterQueue> findByStatusAndErrorCount(String status,
		int errorCount, int start, int end) throws SystemException {
		return findByStatusAndErrorCount(status, errorCount, start, end, null);
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
	@Override
	public List<CertLetterQueue> findByStatusAndErrorCount(String status,
		int errorCount, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDERRORCOUNT;
			finderArgs = new Object[] { status, errorCount };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDERRORCOUNT;
			finderArgs = new Object[] {
					status, errorCount,
					
					start, end, orderByComparator
				};
		}

		List<CertLetterQueue> list = (List<CertLetterQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CertLetterQueue certLetterQueue : list) {
				if (!Validator.equals(status, certLetterQueue.getStatus()) ||
						(errorCount != certLetterQueue.getErrorCount())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_2);
			}

			query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_ERRORCOUNT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				qPos.add(errorCount);

				if (!pagination) {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CertLetterQueue>(list);
				}
				else {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CertLetterQueue findByStatusAndErrorCount_First(String status,
		int errorCount, OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByStatusAndErrorCount_First(status,
				errorCount, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", errorCount=");
		msg.append(errorCount);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByStatusAndErrorCount_First(String status,
		int errorCount, OrderByComparator orderByComparator)
		throws SystemException {
		List<CertLetterQueue> list = findByStatusAndErrorCount(status,
				errorCount, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue findByStatusAndErrorCount_Last(String status,
		int errorCount, OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByStatusAndErrorCount_Last(status,
				errorCount, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", errorCount=");
		msg.append(errorCount);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByStatusAndErrorCount_Last(String status,
		int errorCount, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusAndErrorCount(status, errorCount);

		if (count == 0) {
			return null;
		}

		List<CertLetterQueue> list = findByStatusAndErrorCount(status,
				errorCount, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue[] findByStatusAndErrorCount_PrevAndNext(long id,
		String status, int errorCount, OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CertLetterQueue[] array = new CertLetterQueueImpl[3];

			array[0] = getByStatusAndErrorCount_PrevAndNext(session,
					certLetterQueue, status, errorCount, orderByComparator, true);

			array[1] = certLetterQueue;

			array[2] = getByStatusAndErrorCount_PrevAndNext(session,
					certLetterQueue, status, errorCount, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CertLetterQueue getByStatusAndErrorCount_PrevAndNext(
		Session session, CertLetterQueue certLetterQueue, String status,
		int errorCount, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_2);
		}

		query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_ERRORCOUNT_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		qPos.add(errorCount);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certLetterQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CertLetterQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<CertLetterQueue> findByStatusAndErrorCount(String[] statuses,
		int[] errorCounts) throws SystemException {
		return findByStatusAndErrorCount(statuses, errorCounts,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CertLetterQueue> findByStatusAndErrorCount(String[] statuses,
		int[] errorCounts, int start, int end) throws SystemException {
		return findByStatusAndErrorCount(statuses, errorCounts, start, end, null);
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
	@Override
	public List<CertLetterQueue> findByStatusAndErrorCount(String[] statuses,
		int[] errorCounts, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1) &&
				(errorCounts != null) && (errorCounts.length == 1)) {
			return findByStatusAndErrorCount(statuses[0], errorCounts[0],
				start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					StringUtil.merge(statuses), StringUtil.merge(errorCounts)
				};
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(statuses), StringUtil.merge(errorCounts),
					
					start, end, orderByComparator
				};
		}

		List<CertLetterQueue> list = (List<CertLetterQueue>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDERRORCOUNT,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CertLetterQueue certLetterQueue : list) {
				if (!ArrayUtil.contains(statuses, certLetterQueue.getStatus()) ||
						!ArrayUtil.contains(errorCounts,
							certLetterQueue.getErrorCount())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

			boolean conjunctionable = false;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					String status = statuses[i];

					if (status == null) {
						query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_4);
					}
					else if (status.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_6);
					}
					else {
						query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_5);
					}

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((errorCounts == null) || (errorCounts.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < errorCounts.length; i++) {
					query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_ERRORCOUNT_5);

					if ((i + 1) < errorCounts.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (errorCounts != null) {
					qPos.add(errorCounts);
				}

				if (!pagination) {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CertLetterQueue>(list);
				}
				else {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDERRORCOUNT,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDERRORCOUNT,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cert letter queues where status = &#63; and errorCount = &#63; from the database.
	 *
	 * @param status the status
	 * @param errorCount the error count
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatusAndErrorCount(String status, int errorCount)
		throws SystemException {
		for (CertLetterQueue certLetterQueue : findByStatusAndErrorCount(
				status, errorCount, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(certLetterQueue);
		}
	}

	/**
	 * Returns the number of cert letter queues where status = &#63; and errorCount = &#63;.
	 *
	 * @param status the status
	 * @param errorCount the error count
	 * @return the number of matching cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatusAndErrorCount(String status, int errorCount)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUSANDERRORCOUNT;

		Object[] finderArgs = new Object[] { status, errorCount };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CERTLETTERQUEUE_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_2);
			}

			query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_ERRORCOUNT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				qPos.add(errorCount);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cert letter queues where status = any &#63; and errorCount = any &#63;.
	 *
	 * @param statuses the statuses
	 * @param errorCounts the error counts
	 * @return the number of matching cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatusAndErrorCount(String[] statuses, int[] errorCounts)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				StringUtil.merge(statuses), StringUtil.merge(errorCounts)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSANDERRORCOUNT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_CERTLETTERQUEUE_WHERE);

			boolean conjunctionable = false;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					String status = statuses[i];

					if (status == null) {
						query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_4);
					}
					else if (status.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_6);
					}
					else {
						query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_5);
					}

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((errorCounts == null) || (errorCounts.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < errorCounts.length; i++) {
					query.append(_FINDER_COLUMN_STATUSANDERRORCOUNT_ERRORCOUNT_5);

					if ((i + 1) < errorCounts.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (errorCounts != null) {
					qPos.add(errorCounts);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSANDERRORCOUNT,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSANDERRORCOUNT,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_1 = "certLetterQueue.status IS NULL AND ";
	private static final String _FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_2 = "certLetterQueue.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_3 = "(certLetterQueue.status IS NULL OR certLetterQueue.status = '') AND ";
	private static final String _FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_4 = "(" +
		removeConjunction(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_1) + ")";
	private static final String _FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_2) + ")";
	private static final String _FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_6 = "(" +
		removeConjunction(_FINDER_COLUMN_STATUSANDERRORCOUNT_STATUS_3) + ")";
	private static final String _FINDER_COLUMN_STATUSANDERRORCOUNT_ERRORCOUNT_2 = "certLetterQueue.errorCount = ?";
	private static final String _FINDER_COLUMN_STATUSANDERRORCOUNT_ERRORCOUNT_5 = "(" +
		removeConjunction(_FINDER_COLUMN_STATUSANDERRORCOUNT_ERRORCOUNT_2) +
		")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDSTATUSCREATEDBYANDTYPE =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseIdStatusCreatedByAndType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDSTATUSCREATEDBYANDTYPE =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdStatusCreatedByAndType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			CertLetterQueueModelImpl.COURSEID_COLUMN_BITMASK |
			CertLetterQueueModelImpl.STATUS_COLUMN_BITMASK |
			CertLetterQueueModelImpl.CREATEDBY_COLUMN_BITMASK |
			CertLetterQueueModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDSTATUSCREATEDBYANDTYPE =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdStatusCreatedByAndType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			});

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
	@Override
	public List<CertLetterQueue> findByCourseIdStatusCreatedByAndType(
		long courseId, String status, long createdBy, String type)
		throws SystemException {
		return findByCourseIdStatusCreatedByAndType(courseId, status,
			createdBy, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CertLetterQueue> findByCourseIdStatusCreatedByAndType(
		long courseId, String status, long createdBy, String type, int start,
		int end) throws SystemException {
		return findByCourseIdStatusCreatedByAndType(courseId, status,
			createdBy, type, start, end, null);
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
	@Override
	public List<CertLetterQueue> findByCourseIdStatusCreatedByAndType(
		long courseId, String status, long createdBy, String type, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDSTATUSCREATEDBYANDTYPE;
			finderArgs = new Object[] { courseId, status, createdBy, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDSTATUSCREATEDBYANDTYPE;
			finderArgs = new Object[] {
					courseId, status, createdBy, type,
					
					start, end, orderByComparator
				};
		}

		List<CertLetterQueue> list = (List<CertLetterQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CertLetterQueue certLetterQueue : list) {
				if ((courseId != certLetterQueue.getCourseId()) ||
						!Validator.equals(status, certLetterQueue.getStatus()) ||
						(createdBy != certLetterQueue.getCreatedBy()) ||
						!Validator.equals(type, certLetterQueue.getType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_COURSEID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_2);
			}

			query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_CREATEDBY_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				if (bindStatus) {
					qPos.add(status);
				}

				qPos.add(createdBy);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CertLetterQueue>(list);
				}
				else {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CertLetterQueue findByCourseIdStatusCreatedByAndType_First(
		long courseId, String status, long createdBy, String type,
		OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByCourseIdStatusCreatedByAndType_First(courseId,
				status, createdBy, type, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", createdBy=");
		msg.append(createdBy);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByCourseIdStatusCreatedByAndType_First(
		long courseId, String status, long createdBy, String type,
		OrderByComparator orderByComparator) throws SystemException {
		List<CertLetterQueue> list = findByCourseIdStatusCreatedByAndType(courseId,
				status, createdBy, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue findByCourseIdStatusCreatedByAndType_Last(
		long courseId, String status, long createdBy, String type,
		OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByCourseIdStatusCreatedByAndType_Last(courseId,
				status, createdBy, type, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", createdBy=");
		msg.append(createdBy);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByCourseIdStatusCreatedByAndType_Last(
		long courseId, String status, long createdBy, String type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseIdStatusCreatedByAndType(courseId, status,
				createdBy, type);

		if (count == 0) {
			return null;
		}

		List<CertLetterQueue> list = findByCourseIdStatusCreatedByAndType(courseId,
				status, createdBy, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue[] findByCourseIdStatusCreatedByAndType_PrevAndNext(
		long id, long courseId, String status, long createdBy, String type,
		OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CertLetterQueue[] array = new CertLetterQueueImpl[3];

			array[0] = getByCourseIdStatusCreatedByAndType_PrevAndNext(session,
					certLetterQueue, courseId, status, createdBy, type,
					orderByComparator, true);

			array[1] = certLetterQueue;

			array[2] = getByCourseIdStatusCreatedByAndType_PrevAndNext(session,
					certLetterQueue, courseId, status, createdBy, type,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CertLetterQueue getByCourseIdStatusCreatedByAndType_PrevAndNext(
		Session session, CertLetterQueue certLetterQueue, long courseId,
		String status, long createdBy, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

		query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_COURSEID_2);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_2);
		}

		query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_CREATEDBY_2);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		if (bindStatus) {
			qPos.add(status);
		}

		qPos.add(createdBy);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certLetterQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CertLetterQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public void removeByCourseIdStatusCreatedByAndType(long courseId,
		String status, long createdBy, String type) throws SystemException {
		for (CertLetterQueue certLetterQueue : findByCourseIdStatusCreatedByAndType(
				courseId, status, createdBy, type, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(certLetterQueue);
		}
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
	@Override
	public int countByCourseIdStatusCreatedByAndType(long courseId,
		String status, long createdBy, String type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEIDSTATUSCREATEDBYANDTYPE;

		Object[] finderArgs = new Object[] { courseId, status, createdBy, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CERTLETTERQUEUE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_COURSEID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_2);
			}

			query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_CREATEDBY_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				if (bindStatus) {
					qPos.add(status);
				}

				qPos.add(createdBy);

				if (bindType) {
					qPos.add(type);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_COURSEID_2 =
		"certLetterQueue.courseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_1 =
		"certLetterQueue.status IS NULL AND ";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_2 =
		"certLetterQueue.status = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_STATUS_3 =
		"(certLetterQueue.status IS NULL OR certLetterQueue.status = '') AND ";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_CREATEDBY_2 =
		"certLetterQueue.createdBy = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_1 =
		"certLetterQueue.type IS NULL";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_2 =
		"certLetterQueue.type = ?";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSCREATEDBYANDTYPE_TYPE_3 =
		"(certLetterQueue.type IS NULL OR certLetterQueue.type = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDSTATUSANDCREATEDBY =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseIdStatusAndCreatedBy",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDSTATUSANDCREATEDBY =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdStatusAndCreatedBy",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			CertLetterQueueModelImpl.COURSEID_COLUMN_BITMASK |
			CertLetterQueueModelImpl.STATUS_COLUMN_BITMASK |
			CertLetterQueueModelImpl.CREATEDBY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDSTATUSANDCREATEDBY =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdStatusAndCreatedBy",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63;.
	 *
	 * @param courseId the course ID
	 * @param status the status
	 * @param createdBy the created by
	 * @return the matching cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CertLetterQueue> findByCourseIdStatusAndCreatedBy(
		long courseId, String status, long createdBy) throws SystemException {
		return findByCourseIdStatusAndCreatedBy(courseId, status, createdBy,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CertLetterQueue> findByCourseIdStatusAndCreatedBy(
		long courseId, String status, long createdBy, int start, int end)
		throws SystemException {
		return findByCourseIdStatusAndCreatedBy(courseId, status, createdBy,
			start, end, null);
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
	@Override
	public List<CertLetterQueue> findByCourseIdStatusAndCreatedBy(
		long courseId, String status, long createdBy, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDSTATUSANDCREATEDBY;
			finderArgs = new Object[] { courseId, status, createdBy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDSTATUSANDCREATEDBY;
			finderArgs = new Object[] {
					courseId, status, createdBy,
					
					start, end, orderByComparator
				};
		}

		List<CertLetterQueue> list = (List<CertLetterQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CertLetterQueue certLetterQueue : list) {
				if ((courseId != certLetterQueue.getCourseId()) ||
						!Validator.equals(status, certLetterQueue.getStatus()) ||
						(createdBy != certLetterQueue.getCreatedBy())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_COURSEID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_2);
			}

			query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_CREATEDBY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				if (bindStatus) {
					qPos.add(status);
				}

				qPos.add(createdBy);

				if (!pagination) {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CertLetterQueue>(list);
				}
				else {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CertLetterQueue findByCourseIdStatusAndCreatedBy_First(
		long courseId, String status, long createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByCourseIdStatusAndCreatedBy_First(courseId,
				status, createdBy, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByCourseIdStatusAndCreatedBy_First(
		long courseId, String status, long createdBy,
		OrderByComparator orderByComparator) throws SystemException {
		List<CertLetterQueue> list = findByCourseIdStatusAndCreatedBy(courseId,
				status, createdBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue findByCourseIdStatusAndCreatedBy_Last(
		long courseId, String status, long createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByCourseIdStatusAndCreatedBy_Last(courseId,
				status, createdBy, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByCourseIdStatusAndCreatedBy_Last(
		long courseId, String status, long createdBy,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseIdStatusAndCreatedBy(courseId, status,
				createdBy);

		if (count == 0) {
			return null;
		}

		List<CertLetterQueue> list = findByCourseIdStatusAndCreatedBy(courseId,
				status, createdBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue[] findByCourseIdStatusAndCreatedBy_PrevAndNext(
		long id, long courseId, String status, long createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CertLetterQueue[] array = new CertLetterQueueImpl[3];

			array[0] = getByCourseIdStatusAndCreatedBy_PrevAndNext(session,
					certLetterQueue, courseId, status, createdBy,
					orderByComparator, true);

			array[1] = certLetterQueue;

			array[2] = getByCourseIdStatusAndCreatedBy_PrevAndNext(session,
					certLetterQueue, courseId, status, createdBy,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CertLetterQueue getByCourseIdStatusAndCreatedBy_PrevAndNext(
		Session session, CertLetterQueue certLetterQueue, long courseId,
		String status, long createdBy, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

		query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_COURSEID_2);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_2);
		}

		query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_CREATEDBY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		if (bindStatus) {
			qPos.add(status);
		}

		qPos.add(createdBy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certLetterQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CertLetterQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cert letter queues where courseId = &#63; and status = &#63; and createdBy = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @param status the status
	 * @param createdBy the created by
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdStatusAndCreatedBy(long courseId,
		String status, long createdBy) throws SystemException {
		for (CertLetterQueue certLetterQueue : findByCourseIdStatusAndCreatedBy(
				courseId, status, createdBy, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(certLetterQueue);
		}
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
	@Override
	public int countByCourseIdStatusAndCreatedBy(long courseId, String status,
		long createdBy) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEIDSTATUSANDCREATEDBY;

		Object[] finderArgs = new Object[] { courseId, status, createdBy };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CERTLETTERQUEUE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_COURSEID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_2);
			}

			query.append(_FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_CREATEDBY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				if (bindStatus) {
					qPos.add(status);
				}

				qPos.add(createdBy);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_COURSEID_2 =
		"certLetterQueue.courseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_1 =
		"certLetterQueue.status IS NULL AND ";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_2 =
		"certLetterQueue.status = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_STATUS_3 =
		"(certLetterQueue.status IS NULL OR certLetterQueue.status = '') AND ";
	private static final String _FINDER_COLUMN_COURSEIDSTATUSANDCREATEDBY_CREATEDBY_2 =
		"certLetterQueue.createdBy = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDCREATEDBY =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseIdAndCreatedBy",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDCREATEDBY =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndCreatedBy",
			new String[] { Long.class.getName(), Long.class.getName() },
			CertLetterQueueModelImpl.COURSEID_COLUMN_BITMASK |
			CertLetterQueueModelImpl.CREATEDBY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDCREATEDBY = new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndCreatedBy",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the cert letter queues where courseId = &#63; and createdBy = &#63;.
	 *
	 * @param courseId the course ID
	 * @param createdBy the created by
	 * @return the matching cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CertLetterQueue> findByCourseIdAndCreatedBy(long courseId,
		long createdBy) throws SystemException {
		return findByCourseIdAndCreatedBy(courseId, createdBy,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CertLetterQueue> findByCourseIdAndCreatedBy(long courseId,
		long createdBy, int start, int end) throws SystemException {
		return findByCourseIdAndCreatedBy(courseId, createdBy, start, end, null);
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
	@Override
	public List<CertLetterQueue> findByCourseIdAndCreatedBy(long courseId,
		long createdBy, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDCREATEDBY;
			finderArgs = new Object[] { courseId, createdBy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDCREATEDBY;
			finderArgs = new Object[] {
					courseId, createdBy,
					
					start, end, orderByComparator
				};
		}

		List<CertLetterQueue> list = (List<CertLetterQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CertLetterQueue certLetterQueue : list) {
				if ((courseId != certLetterQueue.getCourseId()) ||
						(createdBy != certLetterQueue.getCreatedBy())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDCREATEDBY_COURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDCREATEDBY_CREATEDBY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(createdBy);

				if (!pagination) {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CertLetterQueue>(list);
				}
				else {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CertLetterQueue findByCourseIdAndCreatedBy_First(long courseId,
		long createdBy, OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByCourseIdAndCreatedBy_First(courseId,
				createdBy, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByCourseIdAndCreatedBy_First(long courseId,
		long createdBy, OrderByComparator orderByComparator)
		throws SystemException {
		List<CertLetterQueue> list = findByCourseIdAndCreatedBy(courseId,
				createdBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue findByCourseIdAndCreatedBy_Last(long courseId,
		long createdBy, OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByCourseIdAndCreatedBy_Last(courseId,
				createdBy, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByCourseIdAndCreatedBy_Last(long courseId,
		long createdBy, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndCreatedBy(courseId, createdBy);

		if (count == 0) {
			return null;
		}

		List<CertLetterQueue> list = findByCourseIdAndCreatedBy(courseId,
				createdBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue[] findByCourseIdAndCreatedBy_PrevAndNext(long id,
		long courseId, long createdBy, OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CertLetterQueue[] array = new CertLetterQueueImpl[3];

			array[0] = getByCourseIdAndCreatedBy_PrevAndNext(session,
					certLetterQueue, courseId, createdBy, orderByComparator,
					true);

			array[1] = certLetterQueue;

			array[2] = getByCourseIdAndCreatedBy_PrevAndNext(session,
					certLetterQueue, courseId, createdBy, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CertLetterQueue getByCourseIdAndCreatedBy_PrevAndNext(
		Session session, CertLetterQueue certLetterQueue, long courseId,
		long createdBy, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

		query.append(_FINDER_COLUMN_COURSEIDANDCREATEDBY_COURSEID_2);

		query.append(_FINDER_COLUMN_COURSEIDANDCREATEDBY_CREATEDBY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		qPos.add(createdBy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certLetterQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CertLetterQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cert letter queues where courseId = &#63; and createdBy = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @param createdBy the created by
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndCreatedBy(long courseId, long createdBy)
		throws SystemException {
		for (CertLetterQueue certLetterQueue : findByCourseIdAndCreatedBy(
				courseId, createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(certLetterQueue);
		}
	}

	/**
	 * Returns the number of cert letter queues where courseId = &#63; and createdBy = &#63;.
	 *
	 * @param courseId the course ID
	 * @param createdBy the created by
	 * @return the number of matching cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseIdAndCreatedBy(long courseId, long createdBy)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEIDANDCREATEDBY;

		Object[] finderArgs = new Object[] { courseId, createdBy };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CERTLETTERQUEUE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDCREATEDBY_COURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDCREATEDBY_CREATEDBY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(createdBy);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COURSEIDANDCREATEDBY_COURSEID_2 = "certLetterQueue.courseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDCREATEDBY_CREATEDBY_2 = "certLetterQueue.createdBy = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDEXPIRYDATE =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatusAndExpiryDate",
			new String[] {
				String.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSANDEXPIRYDATE =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByStatusAndExpiryDate",
			new String[] { String.class.getName(), Date.class.getName() });

	/**
	 * Returns all the cert letter queues where status = &#63; and expiryDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param expiryDate the expiry date
	 * @return the matching cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CertLetterQueue> findByStatusAndExpiryDate(String status,
		Date expiryDate) throws SystemException {
		return findByStatusAndExpiryDate(status, expiryDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CertLetterQueue> findByStatusAndExpiryDate(String status,
		Date expiryDate, int start, int end) throws SystemException {
		return findByStatusAndExpiryDate(status, expiryDate, start, end, null);
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
	@Override
	public List<CertLetterQueue> findByStatusAndExpiryDate(String status,
		Date expiryDate, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDEXPIRYDATE;
		finderArgs = new Object[] {
				status, expiryDate,
				
				start, end, orderByComparator
			};

		List<CertLetterQueue> list = (List<CertLetterQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CertLetterQueue certLetterQueue : list) {
				if (!Validator.equals(status, certLetterQueue.getStatus()) ||
						(expiryDate.getTime() <= certLetterQueue.getExpiryDate()
																	.getTime())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_2);
			}

			boolean bindExpiryDate = false;

			if (expiryDate == null) {
				query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_EXPIRYDATE_1);
			}
			else {
				bindExpiryDate = true;

				query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_EXPIRYDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (bindExpiryDate) {
					qPos.add(CalendarUtil.getTimestamp(expiryDate));
				}

				if (!pagination) {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CertLetterQueue>(list);
				}
				else {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CertLetterQueue findByStatusAndExpiryDate_First(String status,
		Date expiryDate, OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByStatusAndExpiryDate_First(status,
				expiryDate, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", expiryDate=");
		msg.append(expiryDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByStatusAndExpiryDate_First(String status,
		Date expiryDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<CertLetterQueue> list = findByStatusAndExpiryDate(status,
				expiryDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue findByStatusAndExpiryDate_Last(String status,
		Date expiryDate, OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByStatusAndExpiryDate_Last(status,
				expiryDate, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", expiryDate=");
		msg.append(expiryDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByStatusAndExpiryDate_Last(String status,
		Date expiryDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusAndExpiryDate(status, expiryDate);

		if (count == 0) {
			return null;
		}

		List<CertLetterQueue> list = findByStatusAndExpiryDate(status,
				expiryDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue[] findByStatusAndExpiryDate_PrevAndNext(long id,
		String status, Date expiryDate, OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CertLetterQueue[] array = new CertLetterQueueImpl[3];

			array[0] = getByStatusAndExpiryDate_PrevAndNext(session,
					certLetterQueue, status, expiryDate, orderByComparator, true);

			array[1] = certLetterQueue;

			array[2] = getByStatusAndExpiryDate_PrevAndNext(session,
					certLetterQueue, status, expiryDate, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CertLetterQueue getByStatusAndExpiryDate_PrevAndNext(
		Session session, CertLetterQueue certLetterQueue, String status,
		Date expiryDate, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_2);
		}

		boolean bindExpiryDate = false;

		if (expiryDate == null) {
			query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_EXPIRYDATE_1);
		}
		else {
			bindExpiryDate = true;

			query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_EXPIRYDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (bindExpiryDate) {
			qPos.add(CalendarUtil.getTimestamp(expiryDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certLetterQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CertLetterQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cert letter queues where status = &#63; and expiryDate &lt; &#63; from the database.
	 *
	 * @param status the status
	 * @param expiryDate the expiry date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatusAndExpiryDate(String status, Date expiryDate)
		throws SystemException {
		for (CertLetterQueue certLetterQueue : findByStatusAndExpiryDate(
				status, expiryDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(certLetterQueue);
		}
	}

	/**
	 * Returns the number of cert letter queues where status = &#63; and expiryDate &lt; &#63;.
	 *
	 * @param status the status
	 * @param expiryDate the expiry date
	 * @return the number of matching cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatusAndExpiryDate(String status, Date expiryDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSANDEXPIRYDATE;

		Object[] finderArgs = new Object[] { status, expiryDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CERTLETTERQUEUE_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_2);
			}

			boolean bindExpiryDate = false;

			if (expiryDate == null) {
				query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_EXPIRYDATE_1);
			}
			else {
				bindExpiryDate = true;

				query.append(_FINDER_COLUMN_STATUSANDEXPIRYDATE_EXPIRYDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (bindExpiryDate) {
					qPos.add(CalendarUtil.getTimestamp(expiryDate));
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_1 = "certLetterQueue.status IS NULL AND ";
	private static final String _FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_2 = "certLetterQueue.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDEXPIRYDATE_STATUS_3 = "(certLetterQueue.status IS NULL OR certLetterQueue.status = '') AND ";
	private static final String _FINDER_COLUMN_STATUSANDEXPIRYDATE_EXPIRYDATE_1 = "certLetterQueue.expiryDate < NULL";
	private static final String _FINDER_COLUMN_STATUSANDEXPIRYDATE_EXPIRYDATE_2 = "certLetterQueue.expiryDate < ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDCREATEDBYANDSTATUSNOTEQUAL =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED,
			CertLetterQueueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseIdCreatedByAndStatusNotEqual",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEIDCREATEDBYANDSTATUSNOTEQUAL =
		new FinderPath(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByCourseIdCreatedByAndStatusNotEqual",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the cert letter queues where courseId = &#63; and createdBy = &#63; and status &ne; &#63;.
	 *
	 * @param courseId the course ID
	 * @param createdBy the created by
	 * @param status the status
	 * @return the matching cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CertLetterQueue> findByCourseIdCreatedByAndStatusNotEqual(
		long courseId, long createdBy, String status) throws SystemException {
		return findByCourseIdCreatedByAndStatusNotEqual(courseId, createdBy,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CertLetterQueue> findByCourseIdCreatedByAndStatusNotEqual(
		long courseId, long createdBy, String status, int start, int end)
		throws SystemException {
		return findByCourseIdCreatedByAndStatusNotEqual(courseId, createdBy,
			status, start, end, null);
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
	@Override
	public List<CertLetterQueue> findByCourseIdCreatedByAndStatusNotEqual(
		long courseId, long createdBy, String status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDCREATEDBYANDSTATUSNOTEQUAL;
		finderArgs = new Object[] {
				courseId, createdBy, status,
				
				start, end, orderByComparator
			};

		List<CertLetterQueue> list = (List<CertLetterQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CertLetterQueue certLetterQueue : list) {
				if ((courseId != certLetterQueue.getCourseId()) ||
						(createdBy != certLetterQueue.getCreatedBy()) ||
						Validator.equals(status, certLetterQueue.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_COURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_CREATEDBY_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(createdBy);

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CertLetterQueue>(list);
				}
				else {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CertLetterQueue findByCourseIdCreatedByAndStatusNotEqual_First(
		long courseId, long createdBy, String status,
		OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByCourseIdCreatedByAndStatusNotEqual_First(courseId,
				createdBy, status, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", createdBy=");
		msg.append(createdBy);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByCourseIdCreatedByAndStatusNotEqual_First(
		long courseId, long createdBy, String status,
		OrderByComparator orderByComparator) throws SystemException {
		List<CertLetterQueue> list = findByCourseIdCreatedByAndStatusNotEqual(courseId,
				createdBy, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue findByCourseIdCreatedByAndStatusNotEqual_Last(
		long courseId, long createdBy, String status,
		OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByCourseIdCreatedByAndStatusNotEqual_Last(courseId,
				createdBy, status, orderByComparator);

		if (certLetterQueue != null) {
			return certLetterQueue;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", createdBy=");
		msg.append(createdBy);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertLetterQueueException(msg.toString());
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
	@Override
	public CertLetterQueue fetchByCourseIdCreatedByAndStatusNotEqual_Last(
		long courseId, long createdBy, String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseIdCreatedByAndStatusNotEqual(courseId,
				createdBy, status);

		if (count == 0) {
			return null;
		}

		List<CertLetterQueue> list = findByCourseIdCreatedByAndStatusNotEqual(courseId,
				createdBy, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CertLetterQueue[] findByCourseIdCreatedByAndStatusNotEqual_PrevAndNext(
		long id, long courseId, long createdBy, String status,
		OrderByComparator orderByComparator)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CertLetterQueue[] array = new CertLetterQueueImpl[3];

			array[0] = getByCourseIdCreatedByAndStatusNotEqual_PrevAndNext(session,
					certLetterQueue, courseId, createdBy, status,
					orderByComparator, true);

			array[1] = certLetterQueue;

			array[2] = getByCourseIdCreatedByAndStatusNotEqual_PrevAndNext(session,
					certLetterQueue, courseId, createdBy, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CertLetterQueue getByCourseIdCreatedByAndStatusNotEqual_PrevAndNext(
		Session session, CertLetterQueue certLetterQueue, long courseId,
		long createdBy, String status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTLETTERQUEUE_WHERE);

		query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_COURSEID_2);

		query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_CREATEDBY_2);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CertLetterQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		qPos.add(createdBy);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certLetterQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CertLetterQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cert letter queues where courseId = &#63; and createdBy = &#63; and status &ne; &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @param createdBy the created by
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdCreatedByAndStatusNotEqual(long courseId,
		long createdBy, String status) throws SystemException {
		for (CertLetterQueue certLetterQueue : findByCourseIdCreatedByAndStatusNotEqual(
				courseId, createdBy, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(certLetterQueue);
		}
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
	@Override
	public int countByCourseIdCreatedByAndStatusNotEqual(long courseId,
		long createdBy, String status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEIDCREATEDBYANDSTATUSNOTEQUAL;

		Object[] finderArgs = new Object[] { courseId, createdBy, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CERTLETTERQUEUE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_COURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_CREATEDBY_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(createdBy);

				if (bindStatus) {
					qPos.add(status);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_COURSEID_2 =
		"certLetterQueue.courseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_CREATEDBY_2 =
		"certLetterQueue.createdBy = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_1 =
		"certLetterQueue.status IS NOT NULL";
	private static final String _FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_2 =
		"certLetterQueue.status != ?";
	private static final String _FINDER_COLUMN_COURSEIDCREATEDBYANDSTATUSNOTEQUAL_STATUS_3 =
		"(certLetterQueue.status IS NULL OR certLetterQueue.status != '')";

	public CertLetterQueuePersistenceImpl() {
		setModelClass(CertLetterQueue.class);
	}

	/**
	 * Caches the cert letter queue in the entity cache if it is enabled.
	 *
	 * @param certLetterQueue the cert letter queue
	 */
	@Override
	public void cacheResult(CertLetterQueue certLetterQueue) {
		EntityCacheUtil.putResult(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueImpl.class, certLetterQueue.getPrimaryKey(),
			certLetterQueue);

		certLetterQueue.resetOriginalValues();
	}

	/**
	 * Caches the cert letter queues in the entity cache if it is enabled.
	 *
	 * @param certLetterQueues the cert letter queues
	 */
	@Override
	public void cacheResult(List<CertLetterQueue> certLetterQueues) {
		for (CertLetterQueue certLetterQueue : certLetterQueues) {
			if (EntityCacheUtil.getResult(
						CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
						CertLetterQueueImpl.class,
						certLetterQueue.getPrimaryKey()) == null) {
				cacheResult(certLetterQueue);
			}
			else {
				certLetterQueue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cert letter queues.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CertLetterQueueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CertLetterQueueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cert letter queue.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CertLetterQueue certLetterQueue) {
		EntityCacheUtil.removeResult(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueImpl.class, certLetterQueue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CertLetterQueue> certLetterQueues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CertLetterQueue certLetterQueue : certLetterQueues) {
			EntityCacheUtil.removeResult(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
				CertLetterQueueImpl.class, certLetterQueue.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cert letter queue with the primary key. Does not add the cert letter queue to the database.
	 *
	 * @param id the primary key for the new cert letter queue
	 * @return the new cert letter queue
	 */
	@Override
	public CertLetterQueue create(long id) {
		CertLetterQueue certLetterQueue = new CertLetterQueueImpl();

		certLetterQueue.setNew(true);
		certLetterQueue.setPrimaryKey(id);

		return certLetterQueue;
	}

	/**
	 * Removes the cert letter queue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cert letter queue
	 * @return the cert letter queue that was removed
	 * @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CertLetterQueue remove(long id)
		throws NoSuchCertLetterQueueException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the cert letter queue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cert letter queue
	 * @return the cert letter queue that was removed
	 * @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CertLetterQueue remove(Serializable primaryKey)
		throws NoSuchCertLetterQueueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CertLetterQueue certLetterQueue = (CertLetterQueue)session.get(CertLetterQueueImpl.class,
					primaryKey);

			if (certLetterQueue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCertLetterQueueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(certLetterQueue);
		}
		catch (NoSuchCertLetterQueueException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CertLetterQueue removeImpl(CertLetterQueue certLetterQueue)
		throws SystemException {
		certLetterQueue = toUnwrappedModel(certLetterQueue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(certLetterQueue)) {
				certLetterQueue = (CertLetterQueue)session.get(CertLetterQueueImpl.class,
						certLetterQueue.getPrimaryKeyObj());
			}

			if (certLetterQueue != null) {
				session.delete(certLetterQueue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (certLetterQueue != null) {
			clearCache(certLetterQueue);
		}

		return certLetterQueue;
	}

	@Override
	public CertLetterQueue updateImpl(
		com.instructure.canvas.model.CertLetterQueue certLetterQueue)
		throws SystemException {
		certLetterQueue = toUnwrappedModel(certLetterQueue);

		boolean isNew = certLetterQueue.isNew();

		CertLetterQueueModelImpl certLetterQueueModelImpl = (CertLetterQueueModelImpl)certLetterQueue;

		Session session = null;

		try {
			session = openSession();

			if (certLetterQueue.isNew()) {
				session.save(certLetterQueue);

				certLetterQueue.setNew(false);
			}
			else {
				session.merge(certLetterQueue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CertLetterQueueModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((certLetterQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDERRORCOUNT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certLetterQueueModelImpl.getOriginalStatus(),
						certLetterQueueModelImpl.getOriginalErrorCount()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDERRORCOUNT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDERRORCOUNT,
					args);

				args = new Object[] {
						certLetterQueueModelImpl.getStatus(),
						certLetterQueueModelImpl.getErrorCount()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDERRORCOUNT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDERRORCOUNT,
					args);
			}

			if ((certLetterQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDSTATUSCREATEDBYANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certLetterQueueModelImpl.getOriginalCourseId(),
						certLetterQueueModelImpl.getOriginalStatus(),
						certLetterQueueModelImpl.getOriginalCreatedBy(),
						certLetterQueueModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDSTATUSCREATEDBYANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDSTATUSCREATEDBYANDTYPE,
					args);

				args = new Object[] {
						certLetterQueueModelImpl.getCourseId(),
						certLetterQueueModelImpl.getStatus(),
						certLetterQueueModelImpl.getCreatedBy(),
						certLetterQueueModelImpl.getType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDSTATUSCREATEDBYANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDSTATUSCREATEDBYANDTYPE,
					args);
			}

			if ((certLetterQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDSTATUSANDCREATEDBY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certLetterQueueModelImpl.getOriginalCourseId(),
						certLetterQueueModelImpl.getOriginalStatus(),
						certLetterQueueModelImpl.getOriginalCreatedBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDSTATUSANDCREATEDBY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDSTATUSANDCREATEDBY,
					args);

				args = new Object[] {
						certLetterQueueModelImpl.getCourseId(),
						certLetterQueueModelImpl.getStatus(),
						certLetterQueueModelImpl.getCreatedBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDSTATUSANDCREATEDBY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDSTATUSANDCREATEDBY,
					args);
			}

			if ((certLetterQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDCREATEDBY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certLetterQueueModelImpl.getOriginalCourseId(),
						certLetterQueueModelImpl.getOriginalCreatedBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDCREATEDBY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDCREATEDBY,
					args);

				args = new Object[] {
						certLetterQueueModelImpl.getCourseId(),
						certLetterQueueModelImpl.getCreatedBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDCREATEDBY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDCREATEDBY,
					args);
			}
		}

		EntityCacheUtil.putResult(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
			CertLetterQueueImpl.class, certLetterQueue.getPrimaryKey(),
			certLetterQueue);

		return certLetterQueue;
	}

	protected CertLetterQueue toUnwrappedModel(CertLetterQueue certLetterQueue) {
		if (certLetterQueue instanceof CertLetterQueueImpl) {
			return certLetterQueue;
		}

		CertLetterQueueImpl certLetterQueueImpl = new CertLetterQueueImpl();

		certLetterQueueImpl.setNew(certLetterQueue.isNew());
		certLetterQueueImpl.setPrimaryKey(certLetterQueue.getPrimaryKey());

		certLetterQueueImpl.setId(certLetterQueue.getId());
		certLetterQueueImpl.setCourseId(certLetterQueue.getCourseId());
		certLetterQueueImpl.setCreateDate(certLetterQueue.getCreateDate());
		certLetterQueueImpl.setCreatedBy(certLetterQueue.getCreatedBy());
		certLetterQueueImpl.setStatus(certLetterQueue.getStatus());
		certLetterQueueImpl.setErrorDescription(certLetterQueue.getErrorDescription());
		certLetterQueueImpl.setErrorCount(certLetterQueue.getErrorCount());
		certLetterQueueImpl.setModifiedDate(certLetterQueue.getModifiedDate());
		certLetterQueueImpl.setStartTime(certLetterQueue.getStartTime());
		certLetterQueueImpl.setEndTime(certLetterQueue.getEndTime());
		certLetterQueueImpl.setZipFileLocation(certLetterQueue.getZipFileLocation());
		certLetterQueueImpl.setExpiryDate(certLetterQueue.getExpiryDate());
		certLetterQueueImpl.setType(certLetterQueue.getType());
		certLetterQueueImpl.setDownloadDate(certLetterQueue.getDownloadDate());

		return certLetterQueueImpl;
	}

	/**
	 * Returns the cert letter queue with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cert letter queue
	 * @return the cert letter queue
	 * @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CertLetterQueue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCertLetterQueueException, SystemException {
		CertLetterQueue certLetterQueue = fetchByPrimaryKey(primaryKey);

		if (certLetterQueue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCertLetterQueueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return certLetterQueue;
	}

	/**
	 * Returns the cert letter queue with the primary key or throws a {@link com.instructure.canvas.NoSuchCertLetterQueueException} if it could not be found.
	 *
	 * @param id the primary key of the cert letter queue
	 * @return the cert letter queue
	 * @throws com.instructure.canvas.NoSuchCertLetterQueueException if a cert letter queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CertLetterQueue findByPrimaryKey(long id)
		throws NoSuchCertLetterQueueException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the cert letter queue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cert letter queue
	 * @return the cert letter queue, or <code>null</code> if a cert letter queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CertLetterQueue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CertLetterQueue certLetterQueue = (CertLetterQueue)EntityCacheUtil.getResult(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
				CertLetterQueueImpl.class, primaryKey);

		if (certLetterQueue == _nullCertLetterQueue) {
			return null;
		}

		if (certLetterQueue == null) {
			Session session = null;

			try {
				session = openSession();

				certLetterQueue = (CertLetterQueue)session.get(CertLetterQueueImpl.class,
						primaryKey);

				if (certLetterQueue != null) {
					cacheResult(certLetterQueue);
				}
				else {
					EntityCacheUtil.putResult(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
						CertLetterQueueImpl.class, primaryKey,
						_nullCertLetterQueue);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CertLetterQueueModelImpl.ENTITY_CACHE_ENABLED,
					CertLetterQueueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return certLetterQueue;
	}

	/**
	 * Returns the cert letter queue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cert letter queue
	 * @return the cert letter queue, or <code>null</code> if a cert letter queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CertLetterQueue fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the cert letter queues.
	 *
	 * @return the cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CertLetterQueue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CertLetterQueue> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<CertLetterQueue> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CertLetterQueue> list = (List<CertLetterQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CERTLETTERQUEUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CERTLETTERQUEUE;

				if (pagination) {
					sql = sql.concat(CertLetterQueueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CertLetterQueue>(list);
				}
				else {
					list = (List<CertLetterQueue>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cert letter queues from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CertLetterQueue certLetterQueue : findAll()) {
			remove(certLetterQueue);
		}
	}

	/**
	 * Returns the number of cert letter queues.
	 *
	 * @return the number of cert letter queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CERTLETTERQUEUE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the cert letter queue persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.CertLetterQueue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CertLetterQueue>> listenersList = new ArrayList<ModelListener<CertLetterQueue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CertLetterQueue>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CertLetterQueueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CERTLETTERQUEUE = "SELECT certLetterQueue FROM CertLetterQueue certLetterQueue";
	private static final String _SQL_SELECT_CERTLETTERQUEUE_WHERE = "SELECT certLetterQueue FROM CertLetterQueue certLetterQueue WHERE ";
	private static final String _SQL_COUNT_CERTLETTERQUEUE = "SELECT COUNT(certLetterQueue) FROM CertLetterQueue certLetterQueue";
	private static final String _SQL_COUNT_CERTLETTERQUEUE_WHERE = "SELECT COUNT(certLetterQueue) FROM CertLetterQueue certLetterQueue WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "certLetterQueue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CertLetterQueue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CertLetterQueue exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CertLetterQueuePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "type"
			});
	private static CertLetterQueue _nullCertLetterQueue = new CertLetterQueueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CertLetterQueue> toCacheModel() {
				return _nullCertLetterQueueCacheModel;
			}
		};

	private static CacheModel<CertLetterQueue> _nullCertLetterQueueCacheModel = new CacheModel<CertLetterQueue>() {
			@Override
			public CertLetterQueue toEntityModel() {
				return _nullCertLetterQueue;
			}
		};
}