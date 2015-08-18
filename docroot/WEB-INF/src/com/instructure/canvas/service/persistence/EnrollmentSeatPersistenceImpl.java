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

import com.instructure.canvas.NoSuchEnrollmentSeatException;
import com.instructure.canvas.model.EnrollmentSeat;
import com.instructure.canvas.model.impl.EnrollmentSeatImpl;
import com.instructure.canvas.model.impl.EnrollmentSeatModelImpl;

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
 * The persistence implementation for the enrollment seat service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnrollmentSeatPersistence
 * @see EnrollmentSeatUtil
 * @generated
 */
public class EnrollmentSeatPersistenceImpl extends BasePersistenceImpl<EnrollmentSeat>
	implements EnrollmentSeatPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EnrollmentSeatUtil} to access the enrollment seat persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EnrollmentSeatImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
			EnrollmentSeatModelImpl.FINDER_CACHE_ENABLED,
			EnrollmentSeatImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
			EnrollmentSeatModelImpl.FINDER_CACHE_ENABLED,
			EnrollmentSeatImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
			EnrollmentSeatModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_TOKEN = new FinderPath(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
			EnrollmentSeatModelImpl.FINDER_CACHE_ENABLED,
			EnrollmentSeatImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByToken",
			new String[] { String.class.getName() },
			EnrollmentSeatModelImpl.TOKEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TOKEN = new FinderPath(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
			EnrollmentSeatModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByToken",
			new String[] { String.class.getName() });

	/**
	 * Returns the enrollment seat where token = &#63; or throws a {@link com.instructure.canvas.NoSuchEnrollmentSeatException} if it could not be found.
	 *
	 * @param token the token
	 * @return the matching enrollment seat
	 * @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a matching enrollment seat could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat findByToken(String token)
		throws NoSuchEnrollmentSeatException, SystemException {
		EnrollmentSeat enrollmentSeat = fetchByToken(token);

		if (enrollmentSeat == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("token=");
			msg.append(token);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEnrollmentSeatException(msg.toString());
		}

		return enrollmentSeat;
	}

	/**
	 * Returns the enrollment seat where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat fetchByToken(String token) throws SystemException {
		return fetchByToken(token, true);
	}

	/**
	 * Returns the enrollment seat where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat fetchByToken(String token, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { token };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TOKEN,
					finderArgs, this);
		}

		if (result instanceof EnrollmentSeat) {
			EnrollmentSeat enrollmentSeat = (EnrollmentSeat)result;

			if (!Validator.equals(token, enrollmentSeat.getToken())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ENROLLMENTSEAT_WHERE);

			boolean bindToken = false;

			if (token == null) {
				query.append(_FINDER_COLUMN_TOKEN_TOKEN_1);
			}
			else if (token.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				query.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindToken) {
					qPos.add(token);
				}

				List<EnrollmentSeat> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EnrollmentSeatPersistenceImpl.fetchByToken(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EnrollmentSeat enrollmentSeat = list.get(0);

					result = enrollmentSeat;

					cacheResult(enrollmentSeat);

					if ((enrollmentSeat.getToken() == null) ||
							!enrollmentSeat.getToken().equals(token)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
							finderArgs, enrollmentSeat);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN,
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
			return (EnrollmentSeat)result;
		}
	}

	/**
	 * Removes the enrollment seat where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the enrollment seat that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat removeByToken(String token)
		throws NoSuchEnrollmentSeatException, SystemException {
		EnrollmentSeat enrollmentSeat = findByToken(token);

		return remove(enrollmentSeat);
	}

	/**
	 * Returns the number of enrollment seats where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching enrollment seats
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByToken(String token) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TOKEN;

		Object[] finderArgs = new Object[] { token };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENROLLMENTSEAT_WHERE);

			boolean bindToken = false;

			if (token == null) {
				query.append(_FINDER_COLUMN_TOKEN_TOKEN_1);
			}
			else if (token.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				query.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindToken) {
					qPos.add(token);
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

	private static final String _FINDER_COLUMN_TOKEN_TOKEN_1 = "enrollmentSeat.token IS NULL";
	private static final String _FINDER_COLUMN_TOKEN_TOKEN_2 = "enrollmentSeat.token = ?";
	private static final String _FINDER_COLUMN_TOKEN_TOKEN_3 = "(enrollmentSeat.token IS NULL OR enrollmentSeat.token = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_COURSEID = new FinderPath(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
			EnrollmentSeatModelImpl.FINDER_CACHE_ENABLED,
			EnrollmentSeatImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCourseId", new String[] { String.class.getName() },
			EnrollmentSeatModelImpl.COURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
			EnrollmentSeatModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { String.class.getName() });

	/**
	 * Returns the enrollment seat where courseId = &#63; or throws a {@link com.instructure.canvas.NoSuchEnrollmentSeatException} if it could not be found.
	 *
	 * @param courseId the course ID
	 * @return the matching enrollment seat
	 * @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a matching enrollment seat could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat findByCourseId(String courseId)
		throws NoSuchEnrollmentSeatException, SystemException {
		EnrollmentSeat enrollmentSeat = fetchByCourseId(courseId);

		if (enrollmentSeat == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("courseId=");
			msg.append(courseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEnrollmentSeatException(msg.toString());
		}

		return enrollmentSeat;
	}

	/**
	 * Returns the enrollment seat where courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param courseId the course ID
	 * @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat fetchByCourseId(String courseId)
		throws SystemException {
		return fetchByCourseId(courseId, true);
	}

	/**
	 * Returns the enrollment seat where courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param courseId the course ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching enrollment seat, or <code>null</code> if a matching enrollment seat could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat fetchByCourseId(String courseId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { courseId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COURSEID,
					finderArgs, this);
		}

		if (result instanceof EnrollmentSeat) {
			EnrollmentSeat enrollmentSeat = (EnrollmentSeat)result;

			if (!Validator.equals(courseId, enrollmentSeat.getCourseId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ENROLLMENTSEAT_WHERE);

			boolean bindCourseId = false;

			if (courseId == null) {
				query.append(_FINDER_COLUMN_COURSEID_COURSEID_1);
			}
			else if (courseId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSEID_COURSEID_3);
			}
			else {
				bindCourseId = true;

				query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCourseId) {
					qPos.add(courseId);
				}

				List<EnrollmentSeat> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EnrollmentSeatPersistenceImpl.fetchByCourseId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EnrollmentSeat enrollmentSeat = list.get(0);

					result = enrollmentSeat;

					cacheResult(enrollmentSeat);

					if ((enrollmentSeat.getCourseId() == null) ||
							!enrollmentSeat.getCourseId().equals(courseId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
							finderArgs, enrollmentSeat);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID,
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
			return (EnrollmentSeat)result;
		}
	}

	/**
	 * Removes the enrollment seat where courseId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @return the enrollment seat that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat removeByCourseId(String courseId)
		throws NoSuchEnrollmentSeatException, SystemException {
		EnrollmentSeat enrollmentSeat = findByCourseId(courseId);

		return remove(enrollmentSeat);
	}

	/**
	 * Returns the number of enrollment seats where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching enrollment seats
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseId(String courseId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEID;

		Object[] finderArgs = new Object[] { courseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENROLLMENTSEAT_WHERE);

			boolean bindCourseId = false;

			if (courseId == null) {
				query.append(_FINDER_COLUMN_COURSEID_COURSEID_1);
			}
			else if (courseId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSEID_COURSEID_3);
			}
			else {
				bindCourseId = true;

				query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCourseId) {
					qPos.add(courseId);
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

	private static final String _FINDER_COLUMN_COURSEID_COURSEID_1 = "enrollmentSeat.courseId IS NULL";
	private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "enrollmentSeat.courseId = ?";
	private static final String _FINDER_COLUMN_COURSEID_COURSEID_3 = "(enrollmentSeat.courseId IS NULL OR enrollmentSeat.courseId = '')";

	public EnrollmentSeatPersistenceImpl() {
		setModelClass(EnrollmentSeat.class);
	}

	/**
	 * Caches the enrollment seat in the entity cache if it is enabled.
	 *
	 * @param enrollmentSeat the enrollment seat
	 */
	@Override
	public void cacheResult(EnrollmentSeat enrollmentSeat) {
		EntityCacheUtil.putResult(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
			EnrollmentSeatImpl.class, enrollmentSeat.getPrimaryKey(),
			enrollmentSeat);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
			new Object[] { enrollmentSeat.getToken() }, enrollmentSeat);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
			new Object[] { enrollmentSeat.getCourseId() }, enrollmentSeat);

		enrollmentSeat.resetOriginalValues();
	}

	/**
	 * Caches the enrollment seats in the entity cache if it is enabled.
	 *
	 * @param enrollmentSeats the enrollment seats
	 */
	@Override
	public void cacheResult(List<EnrollmentSeat> enrollmentSeats) {
		for (EnrollmentSeat enrollmentSeat : enrollmentSeats) {
			if (EntityCacheUtil.getResult(
						EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
						EnrollmentSeatImpl.class, enrollmentSeat.getPrimaryKey()) == null) {
				cacheResult(enrollmentSeat);
			}
			else {
				enrollmentSeat.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all enrollment seats.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EnrollmentSeatImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EnrollmentSeatImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the enrollment seat.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EnrollmentSeat enrollmentSeat) {
		EntityCacheUtil.removeResult(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
			EnrollmentSeatImpl.class, enrollmentSeat.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(enrollmentSeat);
	}

	@Override
	public void clearCache(List<EnrollmentSeat> enrollmentSeats) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EnrollmentSeat enrollmentSeat : enrollmentSeats) {
			EntityCacheUtil.removeResult(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
				EnrollmentSeatImpl.class, enrollmentSeat.getPrimaryKey());

			clearUniqueFindersCache(enrollmentSeat);
		}
	}

	protected void cacheUniqueFindersCache(EnrollmentSeat enrollmentSeat) {
		if (enrollmentSeat.isNew()) {
			Object[] args = new Object[] { enrollmentSeat.getToken() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args,
				enrollmentSeat);

			args = new Object[] { enrollmentSeat.getCourseId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID, args,
				enrollmentSeat);
		}
		else {
			EnrollmentSeatModelImpl enrollmentSeatModelImpl = (EnrollmentSeatModelImpl)enrollmentSeat;

			if ((enrollmentSeatModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { enrollmentSeat.getToken() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args,
					enrollmentSeat);
			}

			if ((enrollmentSeatModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { enrollmentSeat.getCourseId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID, args,
					enrollmentSeat);
			}
		}
	}

	protected void clearUniqueFindersCache(EnrollmentSeat enrollmentSeat) {
		EnrollmentSeatModelImpl enrollmentSeatModelImpl = (EnrollmentSeatModelImpl)enrollmentSeat;

		Object[] args = new Object[] { enrollmentSeat.getToken() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);

		if ((enrollmentSeatModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
			args = new Object[] { enrollmentSeatModelImpl.getOriginalToken() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);
		}

		args = new Object[] { enrollmentSeat.getCourseId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID, args);

		if ((enrollmentSeatModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COURSEID.getColumnBitmask()) != 0) {
			args = new Object[] { enrollmentSeatModelImpl.getOriginalCourseId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID, args);
		}
	}

	/**
	 * Creates a new enrollment seat with the primary key. Does not add the enrollment seat to the database.
	 *
	 * @param id the primary key for the new enrollment seat
	 * @return the new enrollment seat
	 */
	@Override
	public EnrollmentSeat create(long id) {
		EnrollmentSeat enrollmentSeat = new EnrollmentSeatImpl();

		enrollmentSeat.setNew(true);
		enrollmentSeat.setPrimaryKey(id);

		return enrollmentSeat;
	}

	/**
	 * Removes the enrollment seat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the enrollment seat
	 * @return the enrollment seat that was removed
	 * @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a enrollment seat with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat remove(long id)
		throws NoSuchEnrollmentSeatException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the enrollment seat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the enrollment seat
	 * @return the enrollment seat that was removed
	 * @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a enrollment seat with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat remove(Serializable primaryKey)
		throws NoSuchEnrollmentSeatException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EnrollmentSeat enrollmentSeat = (EnrollmentSeat)session.get(EnrollmentSeatImpl.class,
					primaryKey);

			if (enrollmentSeat == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEnrollmentSeatException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(enrollmentSeat);
		}
		catch (NoSuchEnrollmentSeatException nsee) {
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
	protected EnrollmentSeat removeImpl(EnrollmentSeat enrollmentSeat)
		throws SystemException {
		enrollmentSeat = toUnwrappedModel(enrollmentSeat);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(enrollmentSeat)) {
				enrollmentSeat = (EnrollmentSeat)session.get(EnrollmentSeatImpl.class,
						enrollmentSeat.getPrimaryKeyObj());
			}

			if (enrollmentSeat != null) {
				session.delete(enrollmentSeat);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (enrollmentSeat != null) {
			clearCache(enrollmentSeat);
		}

		return enrollmentSeat;
	}

	@Override
	public EnrollmentSeat updateImpl(
		com.instructure.canvas.model.EnrollmentSeat enrollmentSeat)
		throws SystemException {
		enrollmentSeat = toUnwrappedModel(enrollmentSeat);

		boolean isNew = enrollmentSeat.isNew();

		Session session = null;

		try {
			session = openSession();

			if (enrollmentSeat.isNew()) {
				session.save(enrollmentSeat);

				enrollmentSeat.setNew(false);
			}
			else {
				session.merge(enrollmentSeat);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EnrollmentSeatModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
			EnrollmentSeatImpl.class, enrollmentSeat.getPrimaryKey(),
			enrollmentSeat);

		clearUniqueFindersCache(enrollmentSeat);
		cacheUniqueFindersCache(enrollmentSeat);

		return enrollmentSeat;
	}

	protected EnrollmentSeat toUnwrappedModel(EnrollmentSeat enrollmentSeat) {
		if (enrollmentSeat instanceof EnrollmentSeatImpl) {
			return enrollmentSeat;
		}

		EnrollmentSeatImpl enrollmentSeatImpl = new EnrollmentSeatImpl();

		enrollmentSeatImpl.setNew(enrollmentSeat.isNew());
		enrollmentSeatImpl.setPrimaryKey(enrollmentSeat.getPrimaryKey());

		enrollmentSeatImpl.setId(enrollmentSeat.getId());
		enrollmentSeatImpl.setToken(enrollmentSeat.getToken());
		enrollmentSeatImpl.setRootAccountId(enrollmentSeat.getRootAccountId());
		enrollmentSeatImpl.setCourseId(enrollmentSeat.getCourseId());
		enrollmentSeatImpl.setUserId(enrollmentSeat.getUserId());
		enrollmentSeatImpl.setCreateDate(enrollmentSeat.getCreateDate());
		enrollmentSeatImpl.setRedeemDate(enrollmentSeat.getRedeemDate());

		return enrollmentSeatImpl;
	}

	/**
	 * Returns the enrollment seat with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the enrollment seat
	 * @return the enrollment seat
	 * @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a enrollment seat with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEnrollmentSeatException, SystemException {
		EnrollmentSeat enrollmentSeat = fetchByPrimaryKey(primaryKey);

		if (enrollmentSeat == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEnrollmentSeatException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return enrollmentSeat;
	}

	/**
	 * Returns the enrollment seat with the primary key or throws a {@link com.instructure.canvas.NoSuchEnrollmentSeatException} if it could not be found.
	 *
	 * @param id the primary key of the enrollment seat
	 * @return the enrollment seat
	 * @throws com.instructure.canvas.NoSuchEnrollmentSeatException if a enrollment seat with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat findByPrimaryKey(long id)
		throws NoSuchEnrollmentSeatException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the enrollment seat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the enrollment seat
	 * @return the enrollment seat, or <code>null</code> if a enrollment seat with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EnrollmentSeat enrollmentSeat = (EnrollmentSeat)EntityCacheUtil.getResult(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
				EnrollmentSeatImpl.class, primaryKey);

		if (enrollmentSeat == _nullEnrollmentSeat) {
			return null;
		}

		if (enrollmentSeat == null) {
			Session session = null;

			try {
				session = openSession();

				enrollmentSeat = (EnrollmentSeat)session.get(EnrollmentSeatImpl.class,
						primaryKey);

				if (enrollmentSeat != null) {
					cacheResult(enrollmentSeat);
				}
				else {
					EntityCacheUtil.putResult(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
						EnrollmentSeatImpl.class, primaryKey,
						_nullEnrollmentSeat);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EnrollmentSeatModelImpl.ENTITY_CACHE_ENABLED,
					EnrollmentSeatImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return enrollmentSeat;
	}

	/**
	 * Returns the enrollment seat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the enrollment seat
	 * @return the enrollment seat, or <code>null</code> if a enrollment seat with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollmentSeat fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the enrollment seats.
	 *
	 * @return the enrollment seats
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollmentSeat> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enrollment seats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.EnrollmentSeatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enrollment seats
	 * @param end the upper bound of the range of enrollment seats (not inclusive)
	 * @return the range of enrollment seats
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollmentSeat> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the enrollment seats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.EnrollmentSeatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enrollment seats
	 * @param end the upper bound of the range of enrollment seats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of enrollment seats
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollmentSeat> findAll(int start, int end,
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

		List<EnrollmentSeat> list = (List<EnrollmentSeat>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENROLLMENTSEAT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENROLLMENTSEAT;

				if (pagination) {
					sql = sql.concat(EnrollmentSeatModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EnrollmentSeat>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnrollmentSeat>(list);
				}
				else {
					list = (List<EnrollmentSeat>)QueryUtil.list(q,
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
	 * Removes all the enrollment seats from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EnrollmentSeat enrollmentSeat : findAll()) {
			remove(enrollmentSeat);
		}
	}

	/**
	 * Returns the number of enrollment seats.
	 *
	 * @return the number of enrollment seats
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

				Query q = session.createQuery(_SQL_COUNT_ENROLLMENTSEAT);

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
	 * Initializes the enrollment seat persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.EnrollmentSeat")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EnrollmentSeat>> listenersList = new ArrayList<ModelListener<EnrollmentSeat>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EnrollmentSeat>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EnrollmentSeatImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ENROLLMENTSEAT = "SELECT enrollmentSeat FROM EnrollmentSeat enrollmentSeat";
	private static final String _SQL_SELECT_ENROLLMENTSEAT_WHERE = "SELECT enrollmentSeat FROM EnrollmentSeat enrollmentSeat WHERE ";
	private static final String _SQL_COUNT_ENROLLMENTSEAT = "SELECT COUNT(enrollmentSeat) FROM EnrollmentSeat enrollmentSeat";
	private static final String _SQL_COUNT_ENROLLMENTSEAT_WHERE = "SELECT COUNT(enrollmentSeat) FROM EnrollmentSeat enrollmentSeat WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "enrollmentSeat.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EnrollmentSeat exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EnrollmentSeat exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EnrollmentSeatPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static EnrollmentSeat _nullEnrollmentSeat = new EnrollmentSeatImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EnrollmentSeat> toCacheModel() {
				return _nullEnrollmentSeatCacheModel;
			}
		};

	private static CacheModel<EnrollmentSeat> _nullEnrollmentSeatCacheModel = new CacheModel<EnrollmentSeat>() {
			@Override
			public EnrollmentSeat toEntityModel() {
				return _nullEnrollmentSeat;
			}
		};
}