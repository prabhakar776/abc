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

import com.instructure.canvas.NoSuchAwardException;
import com.instructure.canvas.model.Award;
import com.instructure.canvas.model.impl.AwardImpl;
import com.instructure.canvas.model.impl.AwardModelImpl;

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
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the award service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AwardPersistence
 * @see AwardUtil
 * @generated
 */
public class AwardPersistenceImpl extends BasePersistenceImpl<Award>
	implements AwardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AwardUtil} to access the award persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AwardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardModelImpl.FINDER_CACHE_ENABLED, AwardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardModelImpl.FINDER_CACHE_ENABLED, AwardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardModelImpl.FINDER_CACHE_ENABLED, AwardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardModelImpl.FINDER_CACHE_ENABLED, AwardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] { Boolean.class.getName() },
			AwardModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the awards where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Award> findByActive(boolean active) throws SystemException {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the awards where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of awards
	 * @param end the upper bound of the range of awards (not inclusive)
	 * @return the range of matching awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Award> findByActive(boolean active, int start, int end)
		throws SystemException {
		return findByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the awards where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of awards
	 * @param end the upper bound of the range of awards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Award> findByActive(boolean active, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active, start, end, orderByComparator };
		}

		List<Award> list = (List<Award>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Award award : list) {
				if ((active != award.getActive())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AWARD_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AwardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<Award>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Award>(list);
				}
				else {
					list = (List<Award>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first award in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching award
	 * @throws com.instructure.canvas.NoSuchAwardException if a matching award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award findByActive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchAwardException, SystemException {
		Award award = fetchByActive_First(active, orderByComparator);

		if (award != null) {
			return award;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAwardException(msg.toString());
	}

	/**
	 * Returns the first award in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching award, or <code>null</code> if a matching award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award fetchByActive_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<Award> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last award in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching award
	 * @throws com.instructure.canvas.NoSuchAwardException if a matching award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award findByActive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchAwardException, SystemException {
		Award award = fetchByActive_Last(active, orderByComparator);

		if (award != null) {
			return award;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAwardException(msg.toString());
	}

	/**
	 * Returns the last award in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching award, or <code>null</code> if a matching award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award fetchByActive_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<Award> list = findByActive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the awards before and after the current award in the ordered set where active = &#63;.
	 *
	 * @param awardId the primary key of the current award
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next award
	 * @throws com.instructure.canvas.NoSuchAwardException if a award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award[] findByActive_PrevAndNext(long awardId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchAwardException, SystemException {
		Award award = findByPrimaryKey(awardId);

		Session session = null;

		try {
			session = openSession();

			Award[] array = new AwardImpl[3];

			array[0] = getByActive_PrevAndNext(session, award, active,
					orderByComparator, true);

			array[1] = award;

			array[2] = getByActive_PrevAndNext(session, award, active,
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

	protected Award getByActive_PrevAndNext(Session session, Award award,
		boolean active, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AWARD_WHERE);

		query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

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
			query.append(AwardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(award);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Award> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the awards where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActive(boolean active) throws SystemException {
		for (Award award : findByActive(active, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(award);
		}
	}

	/**
	 * Returns the number of awards where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByActive(boolean active) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVE;

		Object[] finderArgs = new Object[] { active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AWARD_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "award.active = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CVL_ID = new FinderPath(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardModelImpl.FINDER_CACHE_ENABLED, AwardImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCVL_ID",
			new String[] { String.class.getName() },
			AwardModelImpl.CVLID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CVL_ID = new FinderPath(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCVL_ID",
			new String[] { String.class.getName() });

	/**
	 * Returns the award where cvlId = &#63; or throws a {@link com.instructure.canvas.NoSuchAwardException} if it could not be found.
	 *
	 * @param cvlId the cvl ID
	 * @return the matching award
	 * @throws com.instructure.canvas.NoSuchAwardException if a matching award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award findByCVL_ID(String cvlId)
		throws NoSuchAwardException, SystemException {
		Award award = fetchByCVL_ID(cvlId);

		if (award == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cvlId=");
			msg.append(cvlId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAwardException(msg.toString());
		}

		return award;
	}

	/**
	 * Returns the award where cvlId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cvlId the cvl ID
	 * @return the matching award, or <code>null</code> if a matching award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award fetchByCVL_ID(String cvlId) throws SystemException {
		return fetchByCVL_ID(cvlId, true);
	}

	/**
	 * Returns the award where cvlId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cvlId the cvl ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching award, or <code>null</code> if a matching award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award fetchByCVL_ID(String cvlId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { cvlId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CVL_ID,
					finderArgs, this);
		}

		if (result instanceof Award) {
			Award award = (Award)result;

			if (!Validator.equals(cvlId, award.getCvlId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_AWARD_WHERE);

			boolean bindCvlId = false;

			if (cvlId == null) {
				query.append(_FINDER_COLUMN_CVL_ID_CVLID_1);
			}
			else if (cvlId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CVL_ID_CVLID_3);
			}
			else {
				bindCvlId = true;

				query.append(_FINDER_COLUMN_CVL_ID_CVLID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCvlId) {
					qPos.add(cvlId);
				}

				List<Award> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CVL_ID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AwardPersistenceImpl.fetchByCVL_ID(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Award award = list.get(0);

					result = award;

					cacheResult(award);

					if ((award.getCvlId() == null) ||
							!award.getCvlId().equals(cvlId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CVL_ID,
							finderArgs, award);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CVL_ID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Award)result;
		}
	}

	/**
	 * Removes the award where cvlId = &#63; from the database.
	 *
	 * @param cvlId the cvl ID
	 * @return the award that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award removeByCVL_ID(String cvlId)
		throws NoSuchAwardException, SystemException {
		Award award = findByCVL_ID(cvlId);

		return remove(award);
	}

	/**
	 * Returns the number of awards where cvlId = &#63;.
	 *
	 * @param cvlId the cvl ID
	 * @return the number of matching awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCVL_ID(String cvlId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CVL_ID;

		Object[] finderArgs = new Object[] { cvlId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AWARD_WHERE);

			boolean bindCvlId = false;

			if (cvlId == null) {
				query.append(_FINDER_COLUMN_CVL_ID_CVLID_1);
			}
			else if (cvlId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CVL_ID_CVLID_3);
			}
			else {
				bindCvlId = true;

				query.append(_FINDER_COLUMN_CVL_ID_CVLID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCvlId) {
					qPos.add(cvlId);
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

	private static final String _FINDER_COLUMN_CVL_ID_CVLID_1 = "award.cvlId IS NULL";
	private static final String _FINDER_COLUMN_CVL_ID_CVLID_2 = "award.cvlId = ?";
	private static final String _FINDER_COLUMN_CVL_ID_CVLID_3 = "(award.cvlId IS NULL OR award.cvlId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CVL_NAME = new FinderPath(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardModelImpl.FINDER_CACHE_ENABLED, AwardImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCVL_Name",
			new String[] { String.class.getName() },
			AwardModelImpl.CVLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CVL_NAME = new FinderPath(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCVL_Name",
			new String[] { String.class.getName() });

	/**
	 * Returns the award where cvlName = &#63; or throws a {@link com.instructure.canvas.NoSuchAwardException} if it could not be found.
	 *
	 * @param cvlName the cvl name
	 * @return the matching award
	 * @throws com.instructure.canvas.NoSuchAwardException if a matching award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award findByCVL_Name(String cvlName)
		throws NoSuchAwardException, SystemException {
		Award award = fetchByCVL_Name(cvlName);

		if (award == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cvlName=");
			msg.append(cvlName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAwardException(msg.toString());
		}

		return award;
	}

	/**
	 * Returns the award where cvlName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cvlName the cvl name
	 * @return the matching award, or <code>null</code> if a matching award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award fetchByCVL_Name(String cvlName) throws SystemException {
		return fetchByCVL_Name(cvlName, true);
	}

	/**
	 * Returns the award where cvlName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cvlName the cvl name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching award, or <code>null</code> if a matching award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award fetchByCVL_Name(String cvlName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { cvlName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CVL_NAME,
					finderArgs, this);
		}

		if (result instanceof Award) {
			Award award = (Award)result;

			if (!Validator.equals(cvlName, award.getCvlName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_AWARD_WHERE);

			boolean bindCvlName = false;

			if (cvlName == null) {
				query.append(_FINDER_COLUMN_CVL_NAME_CVLNAME_1);
			}
			else if (cvlName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CVL_NAME_CVLNAME_3);
			}
			else {
				bindCvlName = true;

				query.append(_FINDER_COLUMN_CVL_NAME_CVLNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCvlName) {
					qPos.add(cvlName);
				}

				List<Award> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CVL_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AwardPersistenceImpl.fetchByCVL_Name(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Award award = list.get(0);

					result = award;

					cacheResult(award);

					if ((award.getCvlName() == null) ||
							!award.getCvlName().equals(cvlName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CVL_NAME,
							finderArgs, award);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CVL_NAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Award)result;
		}
	}

	/**
	 * Removes the award where cvlName = &#63; from the database.
	 *
	 * @param cvlName the cvl name
	 * @return the award that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award removeByCVL_Name(String cvlName)
		throws NoSuchAwardException, SystemException {
		Award award = findByCVL_Name(cvlName);

		return remove(award);
	}

	/**
	 * Returns the number of awards where cvlName = &#63;.
	 *
	 * @param cvlName the cvl name
	 * @return the number of matching awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCVL_Name(String cvlName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CVL_NAME;

		Object[] finderArgs = new Object[] { cvlName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AWARD_WHERE);

			boolean bindCvlName = false;

			if (cvlName == null) {
				query.append(_FINDER_COLUMN_CVL_NAME_CVLNAME_1);
			}
			else if (cvlName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CVL_NAME_CVLNAME_3);
			}
			else {
				bindCvlName = true;

				query.append(_FINDER_COLUMN_CVL_NAME_CVLNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCvlName) {
					qPos.add(cvlName);
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

	private static final String _FINDER_COLUMN_CVL_NAME_CVLNAME_1 = "award.cvlName IS NULL";
	private static final String _FINDER_COLUMN_CVL_NAME_CVLNAME_2 = "award.cvlName = ?";
	private static final String _FINDER_COLUMN_CVL_NAME_CVLNAME_3 = "(award.cvlName IS NULL OR award.cvlName = '')";

	public AwardPersistenceImpl() {
		setModelClass(Award.class);
	}

	/**
	 * Caches the award in the entity cache if it is enabled.
	 *
	 * @param award the award
	 */
	@Override
	public void cacheResult(Award award) {
		EntityCacheUtil.putResult(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardImpl.class, award.getPrimaryKey(), award);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CVL_ID,
			new Object[] { award.getCvlId() }, award);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CVL_NAME,
			new Object[] { award.getCvlName() }, award);

		award.resetOriginalValues();
	}

	/**
	 * Caches the awards in the entity cache if it is enabled.
	 *
	 * @param awards the awards
	 */
	@Override
	public void cacheResult(List<Award> awards) {
		for (Award award : awards) {
			if (EntityCacheUtil.getResult(AwardModelImpl.ENTITY_CACHE_ENABLED,
						AwardImpl.class, award.getPrimaryKey()) == null) {
				cacheResult(award);
			}
			else {
				award.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all awards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AwardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AwardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the award.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Award award) {
		EntityCacheUtil.removeResult(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardImpl.class, award.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(award);
	}

	@Override
	public void clearCache(List<Award> awards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Award award : awards) {
			EntityCacheUtil.removeResult(AwardModelImpl.ENTITY_CACHE_ENABLED,
				AwardImpl.class, award.getPrimaryKey());

			clearUniqueFindersCache(award);
		}
	}

	protected void cacheUniqueFindersCache(Award award) {
		if (award.isNew()) {
			Object[] args = new Object[] { award.getCvlId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CVL_ID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CVL_ID, args, award);

			args = new Object[] { award.getCvlName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CVL_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CVL_NAME, args, award);
		}
		else {
			AwardModelImpl awardModelImpl = (AwardModelImpl)award;

			if ((awardModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CVL_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { award.getCvlId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CVL_ID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CVL_ID, args,
					award);
			}

			if ((awardModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CVL_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { award.getCvlName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CVL_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CVL_NAME, args,
					award);
			}
		}
	}

	protected void clearUniqueFindersCache(Award award) {
		AwardModelImpl awardModelImpl = (AwardModelImpl)award;

		Object[] args = new Object[] { award.getCvlId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CVL_ID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CVL_ID, args);

		if ((awardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CVL_ID.getColumnBitmask()) != 0) {
			args = new Object[] { awardModelImpl.getOriginalCvlId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CVL_ID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CVL_ID, args);
		}

		args = new Object[] { award.getCvlName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CVL_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CVL_NAME, args);

		if ((awardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CVL_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { awardModelImpl.getOriginalCvlName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CVL_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CVL_NAME, args);
		}
	}

	/**
	 * Creates a new award with the primary key. Does not add the award to the database.
	 *
	 * @param awardId the primary key for the new award
	 * @return the new award
	 */
	@Override
	public Award create(long awardId) {
		Award award = new AwardImpl();

		award.setNew(true);
		award.setPrimaryKey(awardId);

		return award;
	}

	/**
	 * Removes the award with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param awardId the primary key of the award
	 * @return the award that was removed
	 * @throws com.instructure.canvas.NoSuchAwardException if a award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award remove(long awardId)
		throws NoSuchAwardException, SystemException {
		return remove((Serializable)awardId);
	}

	/**
	 * Removes the award with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the award
	 * @return the award that was removed
	 * @throws com.instructure.canvas.NoSuchAwardException if a award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award remove(Serializable primaryKey)
		throws NoSuchAwardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Award award = (Award)session.get(AwardImpl.class, primaryKey);

			if (award == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAwardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(award);
		}
		catch (NoSuchAwardException nsee) {
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
	protected Award removeImpl(Award award) throws SystemException {
		award = toUnwrappedModel(award);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(award)) {
				award = (Award)session.get(AwardImpl.class,
						award.getPrimaryKeyObj());
			}

			if (award != null) {
				session.delete(award);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (award != null) {
			clearCache(award);
		}

		return award;
	}

	@Override
	public Award updateImpl(com.instructure.canvas.model.Award award)
		throws SystemException {
		award = toUnwrappedModel(award);

		boolean isNew = award.isNew();

		AwardModelImpl awardModelImpl = (AwardModelImpl)award;

		Session session = null;

		try {
			session = openSession();

			if (award.isNew()) {
				session.save(award);

				award.setNew(false);
			}
			else {
				session.merge(award);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AwardModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((awardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { awardModelImpl.getOriginalActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { awardModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}
		}

		EntityCacheUtil.putResult(AwardModelImpl.ENTITY_CACHE_ENABLED,
			AwardImpl.class, award.getPrimaryKey(), award);

		clearUniqueFindersCache(award);
		cacheUniqueFindersCache(award);

		return award;
	}

	protected Award toUnwrappedModel(Award award) {
		if (award instanceof AwardImpl) {
			return award;
		}

		AwardImpl awardImpl = new AwardImpl();

		awardImpl.setNew(award.isNew());
		awardImpl.setPrimaryKey(award.getPrimaryKey());

		awardImpl.setAwardId(award.getAwardId());
		awardImpl.setCvlId(award.getCvlId());
		awardImpl.setCvlName(award.getCvlName());
		awardImpl.setScore(award.getScore());
		awardImpl.setLetterArticleId(award.getLetterArticleId());
		awardImpl.setCertificateArticleId(award.getCertificateArticleId());
		awardImpl.setActive(award.isActive());
		awardImpl.setCreateDate(award.getCreateDate());
		awardImpl.setModifiedDate(award.getModifiedDate());

		return awardImpl;
	}

	/**
	 * Returns the award with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the award
	 * @return the award
	 * @throws com.instructure.canvas.NoSuchAwardException if a award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAwardException, SystemException {
		Award award = fetchByPrimaryKey(primaryKey);

		if (award == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAwardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return award;
	}

	/**
	 * Returns the award with the primary key or throws a {@link com.instructure.canvas.NoSuchAwardException} if it could not be found.
	 *
	 * @param awardId the primary key of the award
	 * @return the award
	 * @throws com.instructure.canvas.NoSuchAwardException if a award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award findByPrimaryKey(long awardId)
		throws NoSuchAwardException, SystemException {
		return findByPrimaryKey((Serializable)awardId);
	}

	/**
	 * Returns the award with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the award
	 * @return the award, or <code>null</code> if a award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Award award = (Award)EntityCacheUtil.getResult(AwardModelImpl.ENTITY_CACHE_ENABLED,
				AwardImpl.class, primaryKey);

		if (award == _nullAward) {
			return null;
		}

		if (award == null) {
			Session session = null;

			try {
				session = openSession();

				award = (Award)session.get(AwardImpl.class, primaryKey);

				if (award != null) {
					cacheResult(award);
				}
				else {
					EntityCacheUtil.putResult(AwardModelImpl.ENTITY_CACHE_ENABLED,
						AwardImpl.class, primaryKey, _nullAward);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AwardModelImpl.ENTITY_CACHE_ENABLED,
					AwardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return award;
	}

	/**
	 * Returns the award with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param awardId the primary key of the award
	 * @return the award, or <code>null</code> if a award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Award fetchByPrimaryKey(long awardId) throws SystemException {
		return fetchByPrimaryKey((Serializable)awardId);
	}

	/**
	 * Returns all the awards.
	 *
	 * @return the awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Award> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the awards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of awards
	 * @param end the upper bound of the range of awards (not inclusive)
	 * @return the range of awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Award> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the awards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of awards
	 * @param end the upper bound of the range of awards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Award> findAll(int start, int end,
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

		List<Award> list = (List<Award>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AWARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AWARD;

				if (pagination) {
					sql = sql.concat(AwardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Award>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Award>(list);
				}
				else {
					list = (List<Award>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the awards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Award award : findAll()) {
			remove(award);
		}
	}

	/**
	 * Returns the number of awards.
	 *
	 * @return the number of awards
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

				Query q = session.createQuery(_SQL_COUNT_AWARD);

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
	 * Initializes the award persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.Award")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Award>> listenersList = new ArrayList<ModelListener<Award>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Award>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AwardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_AWARD = "SELECT award FROM Award award";
	private static final String _SQL_SELECT_AWARD_WHERE = "SELECT award FROM Award award WHERE ";
	private static final String _SQL_COUNT_AWARD = "SELECT COUNT(award) FROM Award award";
	private static final String _SQL_COUNT_AWARD_WHERE = "SELECT COUNT(award) FROM Award award WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "award.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Award exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Award exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AwardPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static Award _nullAward = new AwardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Award> toCacheModel() {
				return _nullAwardCacheModel;
			}
		};

	private static CacheModel<Award> _nullAwardCacheModel = new CacheModel<Award>() {
			@Override
			public Award toEntityModel() {
				return _nullAward;
			}
		};
}