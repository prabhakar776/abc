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

import com.instructure.canvas.NoSuchUserAwardException;
import com.instructure.canvas.model.UserAward;
import com.instructure.canvas.model.impl.UserAwardImpl;
import com.instructure.canvas.model.impl.UserAwardModelImpl;

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
 * The persistence implementation for the user award service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAwardPersistence
 * @see UserAwardUtil
 * @generated
 */
public class UserAwardPersistenceImpl extends BasePersistenceImpl<UserAward>
	implements UserAwardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserAwardUtil} to access the user award persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserAwardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, UserAwardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, UserAwardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CUID_CID_L = new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, UserAwardImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCUID_CID_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			UserAwardModelImpl.CANVASUSERID_COLUMN_BITMASK |
			UserAwardModelImpl.COURSEID_COLUMN_BITMASK |
			UserAwardModelImpl.LETTER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CUID_CID_L = new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCUID_CID_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns the user award where canvasUserId = &#63; and courseId = &#63; and letter = &#63; or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	 *
	 * @param canvasUserId the canvas user ID
	 * @param courseId the course ID
	 * @param letter the letter
	 * @return the matching user award
	 * @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward findByCUID_CID_L(long canvasUserId, long courseId,
		boolean letter) throws NoSuchUserAwardException, SystemException {
		UserAward userAward = fetchByCUID_CID_L(canvasUserId, courseId, letter);

		if (userAward == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("canvasUserId=");
			msg.append(canvasUserId);

			msg.append(", courseId=");
			msg.append(courseId);

			msg.append(", letter=");
			msg.append(letter);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserAwardException(msg.toString());
		}

		return userAward;
	}

	/**
	 * Returns the user award where canvasUserId = &#63; and courseId = &#63; and letter = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param canvasUserId the canvas user ID
	 * @param courseId the course ID
	 * @param letter the letter
	 * @return the matching user award, or <code>null</code> if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward fetchByCUID_CID_L(long canvasUserId, long courseId,
		boolean letter) throws SystemException {
		return fetchByCUID_CID_L(canvasUserId, courseId, letter, true);
	}

	/**
	 * Returns the user award where canvasUserId = &#63; and courseId = &#63; and letter = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param canvasUserId the canvas user ID
	 * @param courseId the course ID
	 * @param letter the letter
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user award, or <code>null</code> if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward fetchByCUID_CID_L(long canvasUserId, long courseId,
		boolean letter, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { canvasUserId, courseId, letter };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CUID_CID_L,
					finderArgs, this);
		}

		if (result instanceof UserAward) {
			UserAward userAward = (UserAward)result;

			if ((canvasUserId != userAward.getCanvasUserId()) ||
					(courseId != userAward.getCourseId()) ||
					(letter != userAward.getLetter())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_USERAWARD_WHERE);

			query.append(_FINDER_COLUMN_CUID_CID_L_CANVASUSERID_2);

			query.append(_FINDER_COLUMN_CUID_CID_L_COURSEID_2);

			query.append(_FINDER_COLUMN_CUID_CID_L_LETTER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(canvasUserId);

				qPos.add(courseId);

				qPos.add(letter);

				List<UserAward> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CUID_CID_L,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserAwardPersistenceImpl.fetchByCUID_CID_L(long, long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserAward userAward = list.get(0);

					result = userAward;

					cacheResult(userAward);

					if ((userAward.getCanvasUserId() != canvasUserId) ||
							(userAward.getCourseId() != courseId) ||
							(userAward.getLetter() != letter)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CUID_CID_L,
							finderArgs, userAward);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CUID_CID_L,
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
			return (UserAward)result;
		}
	}

	/**
	 * Removes the user award where canvasUserId = &#63; and courseId = &#63; and letter = &#63; from the database.
	 *
	 * @param canvasUserId the canvas user ID
	 * @param courseId the course ID
	 * @param letter the letter
	 * @return the user award that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward removeByCUID_CID_L(long canvasUserId, long courseId,
		boolean letter) throws NoSuchUserAwardException, SystemException {
		UserAward userAward = findByCUID_CID_L(canvasUserId, courseId, letter);

		return remove(userAward);
	}

	/**
	 * Returns the number of user awards where canvasUserId = &#63; and courseId = &#63; and letter = &#63;.
	 *
	 * @param canvasUserId the canvas user ID
	 * @param courseId the course ID
	 * @param letter the letter
	 * @return the number of matching user awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCUID_CID_L(long canvasUserId, long courseId,
		boolean letter) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CUID_CID_L;

		Object[] finderArgs = new Object[] { canvasUserId, courseId, letter };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_USERAWARD_WHERE);

			query.append(_FINDER_COLUMN_CUID_CID_L_CANVASUSERID_2);

			query.append(_FINDER_COLUMN_CUID_CID_L_COURSEID_2);

			query.append(_FINDER_COLUMN_CUID_CID_L_LETTER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(canvasUserId);

				qPos.add(courseId);

				qPos.add(letter);

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

	private static final String _FINDER_COLUMN_CUID_CID_L_CANVASUSERID_2 = "userAward.canvasUserId = ? AND ";
	private static final String _FINDER_COLUMN_CUID_CID_L_COURSEID_2 = "userAward.courseId = ? AND ";
	private static final String _FINDER_COLUMN_CUID_CID_L_LETTER_2 = "userAward.letter = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COURSEID = new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, UserAwardImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCourseId",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserAwardModelImpl.COURSEID_COLUMN_BITMASK |
			UserAwardModelImpl.CANVASUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the user award where courseId = &#63; and canvasUserId = &#63; or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	 *
	 * @param courseId the course ID
	 * @param canvasUserId the canvas user ID
	 * @return the matching user award
	 * @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward findByCourseId(long courseId, long canvasUserId)
		throws NoSuchUserAwardException, SystemException {
		UserAward userAward = fetchByCourseId(courseId, canvasUserId);

		if (userAward == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("courseId=");
			msg.append(courseId);

			msg.append(", canvasUserId=");
			msg.append(canvasUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserAwardException(msg.toString());
		}

		return userAward;
	}

	/**
	 * Returns the user award where courseId = &#63; and canvasUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param courseId the course ID
	 * @param canvasUserId the canvas user ID
	 * @return the matching user award, or <code>null</code> if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward fetchByCourseId(long courseId, long canvasUserId)
		throws SystemException {
		return fetchByCourseId(courseId, canvasUserId, true);
	}

	/**
	 * Returns the user award where courseId = &#63; and canvasUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param courseId the course ID
	 * @param canvasUserId the canvas user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user award, or <code>null</code> if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward fetchByCourseId(long courseId, long canvasUserId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { courseId, canvasUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COURSEID,
					finderArgs, this);
		}

		if (result instanceof UserAward) {
			UserAward userAward = (UserAward)result;

			if ((courseId != userAward.getCourseId()) ||
					(canvasUserId != userAward.getCanvasUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERAWARD_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			query.append(_FINDER_COLUMN_COURSEID_CANVASUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(canvasUserId);

				List<UserAward> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserAwardPersistenceImpl.fetchByCourseId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserAward userAward = list.get(0);

					result = userAward;

					cacheResult(userAward);

					if ((userAward.getCourseId() != courseId) ||
							(userAward.getCanvasUserId() != canvasUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
							finderArgs, userAward);
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
			return (UserAward)result;
		}
	}

	/**
	 * Removes the user award where courseId = &#63; and canvasUserId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @param canvasUserId the canvas user ID
	 * @return the user award that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward removeByCourseId(long courseId, long canvasUserId)
		throws NoSuchUserAwardException, SystemException {
		UserAward userAward = findByCourseId(courseId, canvasUserId);

		return remove(userAward);
	}

	/**
	 * Returns the number of user awards where courseId = &#63; and canvasUserId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param canvasUserId the canvas user ID
	 * @return the number of matching user awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseId(long courseId, long canvasUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEID;

		Object[] finderArgs = new Object[] { courseId, canvasUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERAWARD_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			query.append(_FINDER_COLUMN_COURSEID_CANVASUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(canvasUserId);

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

	private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "userAward.courseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEID_CANVASUSERID_2 = "userAward.canvasUserId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CERTID = new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, UserAwardImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCertID",
			new String[] { String.class.getName() },
			UserAwardModelImpl.CERTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CERTID = new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCertID",
			new String[] { String.class.getName() });

	/**
	 * Returns the user award where certId = &#63; or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	 *
	 * @param certId the cert ID
	 * @return the matching user award
	 * @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward findByCertID(String certId)
		throws NoSuchUserAwardException, SystemException {
		UserAward userAward = fetchByCertID(certId);

		if (userAward == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("certId=");
			msg.append(certId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserAwardException(msg.toString());
		}

		return userAward;
	}

	/**
	 * Returns the user award where certId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param certId the cert ID
	 * @return the matching user award, or <code>null</code> if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward fetchByCertID(String certId) throws SystemException {
		return fetchByCertID(certId, true);
	}

	/**
	 * Returns the user award where certId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param certId the cert ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user award, or <code>null</code> if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward fetchByCertID(String certId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { certId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CERTID,
					finderArgs, this);
		}

		if (result instanceof UserAward) {
			UserAward userAward = (UserAward)result;

			if (!Validator.equals(certId, userAward.getCertId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERAWARD_WHERE);

			boolean bindCertId = false;

			if (certId == null) {
				query.append(_FINDER_COLUMN_CERTID_CERTID_1);
			}
			else if (certId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CERTID_CERTID_3);
			}
			else {
				bindCertId = true;

				query.append(_FINDER_COLUMN_CERTID_CERTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCertId) {
					qPos.add(certId);
				}

				List<UserAward> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserAwardPersistenceImpl.fetchByCertID(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserAward userAward = list.get(0);

					result = userAward;

					cacheResult(userAward);

					if ((userAward.getCertId() == null) ||
							!userAward.getCertId().equals(certId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTID,
							finderArgs, userAward);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTID,
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
			return (UserAward)result;
		}
	}

	/**
	 * Removes the user award where certId = &#63; from the database.
	 *
	 * @param certId the cert ID
	 * @return the user award that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward removeByCertID(String certId)
		throws NoSuchUserAwardException, SystemException {
		UserAward userAward = findByCertID(certId);

		return remove(userAward);
	}

	/**
	 * Returns the number of user awards where certId = &#63;.
	 *
	 * @param certId the cert ID
	 * @return the number of matching user awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCertID(String certId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTID;

		Object[] finderArgs = new Object[] { certId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERAWARD_WHERE);

			boolean bindCertId = false;

			if (certId == null) {
				query.append(_FINDER_COLUMN_CERTID_CERTID_1);
			}
			else if (certId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CERTID_CERTID_3);
			}
			else {
				bindCertId = true;

				query.append(_FINDER_COLUMN_CERTID_CERTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCertId) {
					qPos.add(certId);
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

	private static final String _FINDER_COLUMN_CERTID_CERTID_1 = "userAward.certId IS NULL";
	private static final String _FINDER_COLUMN_CERTID_CERTID_2 = "userAward.certId = ?";
	private static final String _FINDER_COLUMN_CERTID_CERTID_3 = "(userAward.certId IS NULL OR userAward.certId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CANVASUSERID =
		new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, UserAwardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCanvasUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANVASUSERID =
		new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, UserAwardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCanvasUserId",
			new String[] { Long.class.getName() },
			UserAwardModelImpl.CANVASUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANVASUSERID = new FinderPath(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCanvasUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user awards where canvasUserId = &#63;.
	 *
	 * @param canvasUserId the canvas user ID
	 * @return the matching user awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAward> findByCanvasUserId(long canvasUserId)
		throws SystemException {
		return findByCanvasUserId(canvasUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user awards where canvasUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.UserAwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param canvasUserId the canvas user ID
	 * @param start the lower bound of the range of user awards
	 * @param end the upper bound of the range of user awards (not inclusive)
	 * @return the range of matching user awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAward> findByCanvasUserId(long canvasUserId, int start,
		int end) throws SystemException {
		return findByCanvasUserId(canvasUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user awards where canvasUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.UserAwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param canvasUserId the canvas user ID
	 * @param start the lower bound of the range of user awards
	 * @param end the upper bound of the range of user awards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAward> findByCanvasUserId(long canvasUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANVASUSERID;
			finderArgs = new Object[] { canvasUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CANVASUSERID;
			finderArgs = new Object[] {
					canvasUserId,
					
					start, end, orderByComparator
				};
		}

		List<UserAward> list = (List<UserAward>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserAward userAward : list) {
				if ((canvasUserId != userAward.getCanvasUserId())) {
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

			query.append(_SQL_SELECT_USERAWARD_WHERE);

			query.append(_FINDER_COLUMN_CANVASUSERID_CANVASUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserAwardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(canvasUserId);

				if (!pagination) {
					list = (List<UserAward>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserAward>(list);
				}
				else {
					list = (List<UserAward>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first user award in the ordered set where canvasUserId = &#63;.
	 *
	 * @param canvasUserId the canvas user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user award
	 * @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward findByCanvasUserId_First(long canvasUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserAwardException, SystemException {
		UserAward userAward = fetchByCanvasUserId_First(canvasUserId,
				orderByComparator);

		if (userAward != null) {
			return userAward;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("canvasUserId=");
		msg.append(canvasUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAwardException(msg.toString());
	}

	/**
	 * Returns the first user award in the ordered set where canvasUserId = &#63;.
	 *
	 * @param canvasUserId the canvas user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user award, or <code>null</code> if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward fetchByCanvasUserId_First(long canvasUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserAward> list = findByCanvasUserId(canvasUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user award in the ordered set where canvasUserId = &#63;.
	 *
	 * @param canvasUserId the canvas user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user award
	 * @throws com.instructure.canvas.NoSuchUserAwardException if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward findByCanvasUserId_Last(long canvasUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserAwardException, SystemException {
		UserAward userAward = fetchByCanvasUserId_Last(canvasUserId,
				orderByComparator);

		if (userAward != null) {
			return userAward;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("canvasUserId=");
		msg.append(canvasUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAwardException(msg.toString());
	}

	/**
	 * Returns the last user award in the ordered set where canvasUserId = &#63;.
	 *
	 * @param canvasUserId the canvas user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user award, or <code>null</code> if a matching user award could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward fetchByCanvasUserId_Last(long canvasUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCanvasUserId(canvasUserId);

		if (count == 0) {
			return null;
		}

		List<UserAward> list = findByCanvasUserId(canvasUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user awards before and after the current user award in the ordered set where canvasUserId = &#63;.
	 *
	 * @param id the primary key of the current user award
	 * @param canvasUserId the canvas user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user award
	 * @throws com.instructure.canvas.NoSuchUserAwardException if a user award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward[] findByCanvasUserId_PrevAndNext(long id,
		long canvasUserId, OrderByComparator orderByComparator)
		throws NoSuchUserAwardException, SystemException {
		UserAward userAward = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			UserAward[] array = new UserAwardImpl[3];

			array[0] = getByCanvasUserId_PrevAndNext(session, userAward,
					canvasUserId, orderByComparator, true);

			array[1] = userAward;

			array[2] = getByCanvasUserId_PrevAndNext(session, userAward,
					canvasUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserAward getByCanvasUserId_PrevAndNext(Session session,
		UserAward userAward, long canvasUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERAWARD_WHERE);

		query.append(_FINDER_COLUMN_CANVASUSERID_CANVASUSERID_2);

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
			query.append(UserAwardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(canvasUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userAward);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserAward> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user awards where canvasUserId = &#63; from the database.
	 *
	 * @param canvasUserId the canvas user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCanvasUserId(long canvasUserId)
		throws SystemException {
		for (UserAward userAward : findByCanvasUserId(canvasUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userAward);
		}
	}

	/**
	 * Returns the number of user awards where canvasUserId = &#63;.
	 *
	 * @param canvasUserId the canvas user ID
	 * @return the number of matching user awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCanvasUserId(long canvasUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CANVASUSERID;

		Object[] finderArgs = new Object[] { canvasUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERAWARD_WHERE);

			query.append(_FINDER_COLUMN_CANVASUSERID_CANVASUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(canvasUserId);

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

	private static final String _FINDER_COLUMN_CANVASUSERID_CANVASUSERID_2 = "userAward.canvasUserId = ?";

	public UserAwardPersistenceImpl() {
		setModelClass(UserAward.class);
	}

	/**
	 * Caches the user award in the entity cache if it is enabled.
	 *
	 * @param userAward the user award
	 */
	@Override
	public void cacheResult(UserAward userAward) {
		EntityCacheUtil.putResult(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardImpl.class, userAward.getPrimaryKey(), userAward);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CUID_CID_L,
			new Object[] {
				userAward.getCanvasUserId(), userAward.getCourseId(),
				userAward.getLetter()
			}, userAward);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
			new Object[] { userAward.getCourseId(), userAward.getCanvasUserId() },
			userAward);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTID,
			new Object[] { userAward.getCertId() }, userAward);

		userAward.resetOriginalValues();
	}

	/**
	 * Caches the user awards in the entity cache if it is enabled.
	 *
	 * @param userAwards the user awards
	 */
	@Override
	public void cacheResult(List<UserAward> userAwards) {
		for (UserAward userAward : userAwards) {
			if (EntityCacheUtil.getResult(
						UserAwardModelImpl.ENTITY_CACHE_ENABLED,
						UserAwardImpl.class, userAward.getPrimaryKey()) == null) {
				cacheResult(userAward);
			}
			else {
				userAward.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user awards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserAwardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserAwardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user award.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserAward userAward) {
		EntityCacheUtil.removeResult(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardImpl.class, userAward.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userAward);
	}

	@Override
	public void clearCache(List<UserAward> userAwards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserAward userAward : userAwards) {
			EntityCacheUtil.removeResult(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
				UserAwardImpl.class, userAward.getPrimaryKey());

			clearUniqueFindersCache(userAward);
		}
	}

	protected void cacheUniqueFindersCache(UserAward userAward) {
		if (userAward.isNew()) {
			Object[] args = new Object[] {
					userAward.getCanvasUserId(), userAward.getCourseId(),
					userAward.getLetter()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CUID_CID_L, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CUID_CID_L, args,
				userAward);

			args = new Object[] {
					userAward.getCourseId(), userAward.getCanvasUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID, args,
				userAward);

			args = new Object[] { userAward.getCertId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTID, args,
				userAward);
		}
		else {
			UserAwardModelImpl userAwardModelImpl = (UserAwardModelImpl)userAward;

			if ((userAwardModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CUID_CID_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userAward.getCanvasUserId(), userAward.getCourseId(),
						userAward.getLetter()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CUID_CID_L,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CUID_CID_L,
					args, userAward);
			}

			if ((userAwardModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userAward.getCourseId(), userAward.getCanvasUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID, args,
					userAward);
			}

			if ((userAwardModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CERTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userAward.getCertId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTID, args,
					userAward);
			}
		}
	}

	protected void clearUniqueFindersCache(UserAward userAward) {
		UserAwardModelImpl userAwardModelImpl = (UserAwardModelImpl)userAward;

		Object[] args = new Object[] {
				userAward.getCanvasUserId(), userAward.getCourseId(),
				userAward.getLetter()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUID_CID_L, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CUID_CID_L, args);

		if ((userAwardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CUID_CID_L.getColumnBitmask()) != 0) {
			args = new Object[] {
					userAwardModelImpl.getOriginalCanvasUserId(),
					userAwardModelImpl.getOriginalCourseId(),
					userAwardModelImpl.getOriginalLetter()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUID_CID_L, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CUID_CID_L, args);
		}

		args = new Object[] { userAward.getCourseId(), userAward.getCanvasUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID, args);

		if ((userAwardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COURSEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					userAwardModelImpl.getOriginalCourseId(),
					userAwardModelImpl.getOriginalCanvasUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID, args);
		}

		args = new Object[] { userAward.getCertId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTID, args);

		if ((userAwardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CERTID.getColumnBitmask()) != 0) {
			args = new Object[] { userAwardModelImpl.getOriginalCertId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTID, args);
		}
	}

	/**
	 * Creates a new user award with the primary key. Does not add the user award to the database.
	 *
	 * @param id the primary key for the new user award
	 * @return the new user award
	 */
	@Override
	public UserAward create(long id) {
		UserAward userAward = new UserAwardImpl();

		userAward.setNew(true);
		userAward.setPrimaryKey(id);

		return userAward;
	}

	/**
	 * Removes the user award with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the user award
	 * @return the user award that was removed
	 * @throws com.instructure.canvas.NoSuchUserAwardException if a user award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward remove(long id)
		throws NoSuchUserAwardException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the user award with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user award
	 * @return the user award that was removed
	 * @throws com.instructure.canvas.NoSuchUserAwardException if a user award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward remove(Serializable primaryKey)
		throws NoSuchUserAwardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserAward userAward = (UserAward)session.get(UserAwardImpl.class,
					primaryKey);

			if (userAward == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserAwardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userAward);
		}
		catch (NoSuchUserAwardException nsee) {
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
	protected UserAward removeImpl(UserAward userAward)
		throws SystemException {
		userAward = toUnwrappedModel(userAward);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userAward)) {
				userAward = (UserAward)session.get(UserAwardImpl.class,
						userAward.getPrimaryKeyObj());
			}

			if (userAward != null) {
				session.delete(userAward);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userAward != null) {
			clearCache(userAward);
		}

		return userAward;
	}

	@Override
	public UserAward updateImpl(
		com.instructure.canvas.model.UserAward userAward)
		throws SystemException {
		userAward = toUnwrappedModel(userAward);

		boolean isNew = userAward.isNew();

		UserAwardModelImpl userAwardModelImpl = (UserAwardModelImpl)userAward;

		Session session = null;

		try {
			session = openSession();

			if (userAward.isNew()) {
				session.save(userAward);

				userAward.setNew(false);
			}
			else {
				session.merge(userAward);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserAwardModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userAwardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANVASUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userAwardModelImpl.getOriginalCanvasUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANVASUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANVASUSERID,
					args);

				args = new Object[] { userAwardModelImpl.getCanvasUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANVASUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANVASUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
			UserAwardImpl.class, userAward.getPrimaryKey(), userAward);

		clearUniqueFindersCache(userAward);
		cacheUniqueFindersCache(userAward);

		return userAward;
	}

	protected UserAward toUnwrappedModel(UserAward userAward) {
		if (userAward instanceof UserAwardImpl) {
			return userAward;
		}

		UserAwardImpl userAwardImpl = new UserAwardImpl();

		userAwardImpl.setNew(userAward.isNew());
		userAwardImpl.setPrimaryKey(userAward.getPrimaryKey());

		userAwardImpl.setId(userAward.getId());
		userAwardImpl.setCanvasUserId(userAward.getCanvasUserId());
		userAwardImpl.setCourseId(userAward.getCourseId());
		userAwardImpl.setExternalId(userAward.getExternalId());
		userAwardImpl.setCertId(userAward.getCertId());
		userAwardImpl.setLetter(userAward.isLetter());
		userAwardImpl.setCreateDate(userAward.getCreateDate());

		return userAwardImpl;
	}

	/**
	 * Returns the user award with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user award
	 * @return the user award
	 * @throws com.instructure.canvas.NoSuchUserAwardException if a user award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserAwardException, SystemException {
		UserAward userAward = fetchByPrimaryKey(primaryKey);

		if (userAward == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserAwardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userAward;
	}

	/**
	 * Returns the user award with the primary key or throws a {@link com.instructure.canvas.NoSuchUserAwardException} if it could not be found.
	 *
	 * @param id the primary key of the user award
	 * @return the user award
	 * @throws com.instructure.canvas.NoSuchUserAwardException if a user award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward findByPrimaryKey(long id)
		throws NoSuchUserAwardException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the user award with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user award
	 * @return the user award, or <code>null</code> if a user award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserAward userAward = (UserAward)EntityCacheUtil.getResult(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
				UserAwardImpl.class, primaryKey);

		if (userAward == _nullUserAward) {
			return null;
		}

		if (userAward == null) {
			Session session = null;

			try {
				session = openSession();

				userAward = (UserAward)session.get(UserAwardImpl.class,
						primaryKey);

				if (userAward != null) {
					cacheResult(userAward);
				}
				else {
					EntityCacheUtil.putResult(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
						UserAwardImpl.class, primaryKey, _nullUserAward);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserAwardModelImpl.ENTITY_CACHE_ENABLED,
					UserAwardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userAward;
	}

	/**
	 * Returns the user award with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the user award
	 * @return the user award, or <code>null</code> if a user award with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAward fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the user awards.
	 *
	 * @return the user awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAward> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user awards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.UserAwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user awards
	 * @param end the upper bound of the range of user awards (not inclusive)
	 * @return the range of user awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAward> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user awards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.UserAwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user awards
	 * @param end the upper bound of the range of user awards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user awards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAward> findAll(int start, int end,
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

		List<UserAward> list = (List<UserAward>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERAWARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERAWARD;

				if (pagination) {
					sql = sql.concat(UserAwardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserAward>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserAward>(list);
				}
				else {
					list = (List<UserAward>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the user awards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserAward userAward : findAll()) {
			remove(userAward);
		}
	}

	/**
	 * Returns the number of user awards.
	 *
	 * @return the number of user awards
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

				Query q = session.createQuery(_SQL_COUNT_USERAWARD);

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
	 * Initializes the user award persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.UserAward")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserAward>> listenersList = new ArrayList<ModelListener<UserAward>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserAward>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserAwardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERAWARD = "SELECT userAward FROM UserAward userAward";
	private static final String _SQL_SELECT_USERAWARD_WHERE = "SELECT userAward FROM UserAward userAward WHERE ";
	private static final String _SQL_COUNT_USERAWARD = "SELECT COUNT(userAward) FROM UserAward userAward";
	private static final String _SQL_COUNT_USERAWARD_WHERE = "SELECT COUNT(userAward) FROM UserAward userAward WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userAward.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserAward exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserAward exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserAwardPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static UserAward _nullUserAward = new UserAwardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserAward> toCacheModel() {
				return _nullUserAwardCacheModel;
			}
		};

	private static CacheModel<UserAward> _nullUserAwardCacheModel = new CacheModel<UserAward>() {
			@Override
			public UserAward toEntityModel() {
				return _nullUserAward;
			}
		};
}