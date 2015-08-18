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

import com.instructure.canvas.NoSuchCourseException;
import com.instructure.canvas.model.Course;
import com.instructure.canvas.model.impl.CourseImpl;
import com.instructure.canvas.model.impl.CourseModelImpl;

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
 * The persistence implementation for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoursePersistence
 * @see CourseUtil
 * @generated
 */
public class CoursePersistenceImpl extends BasePersistenceImpl<Course>
	implements CoursePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ID = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchById",
			new String[] { Long.class.getName() },
			CourseModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById",
			new String[] { Long.class.getName() });

	/**
	 * Returns the course where id = &#63; or throws a {@link com.instructure.canvas.NoSuchCourseException} if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching course
	 * @throws com.instructure.canvas.NoSuchCourseException if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course findById(long id)
		throws NoSuchCourseException, SystemException {
		Course course = fetchById(id);

		if (course == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseException(msg.toString());
		}

		return course;
	}

	/**
	 * Returns the course where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course fetchById(long id) throws SystemException {
		return fetchById(id, true);
	}

	/**
	 * Returns the course where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course fetchById(long id, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ID,
					finderArgs, this);
		}

		if (result instanceof Course) {
			Course course = (Course)result;

			if ((id != course.getId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSE_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				List<Course> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CoursePersistenceImpl.fetchById(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Course course = list.get(0);

					result = course;

					cacheResult(course);

					if ((course.getId() != id)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
							finderArgs, course);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, finderArgs);

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
			return (Course)result;
		}
	}

	/**
	 * Removes the course where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the course that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course removeById(long id)
		throws NoSuchCourseException, SystemException {
		Course course = findById(id);

		return remove(course);
	}

	/**
	 * Returns the number of courses where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countById(long id) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ID;

		Object[] finderArgs = new Object[] { id };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "course.id = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NETACADOFFERINGID = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNetacadOfferingId",
			new String[] { String.class.getName() },
			CourseModelImpl.NETACADCOREOFFERINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NETACADOFFERINGID = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNetacadOfferingId", new String[] { String.class.getName() });

	/**
	 * Returns the course where netacadCoreOfferingId = &#63; or throws a {@link com.instructure.canvas.NoSuchCourseException} if it could not be found.
	 *
	 * @param netacadCoreOfferingId the netacad core offering ID
	 * @return the matching course
	 * @throws com.instructure.canvas.NoSuchCourseException if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course findByNetacadOfferingId(String netacadCoreOfferingId)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByNetacadOfferingId(netacadCoreOfferingId);

		if (course == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("netacadCoreOfferingId=");
			msg.append(netacadCoreOfferingId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseException(msg.toString());
		}

		return course;
	}

	/**
	 * Returns the course where netacadCoreOfferingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param netacadCoreOfferingId the netacad core offering ID
	 * @return the matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course fetchByNetacadOfferingId(String netacadCoreOfferingId)
		throws SystemException {
		return fetchByNetacadOfferingId(netacadCoreOfferingId, true);
	}

	/**
	 * Returns the course where netacadCoreOfferingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param netacadCoreOfferingId the netacad core offering ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course fetchByNetacadOfferingId(String netacadCoreOfferingId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { netacadCoreOfferingId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NETACADOFFERINGID,
					finderArgs, this);
		}

		if (result instanceof Course) {
			Course course = (Course)result;

			if (!Validator.equals(netacadCoreOfferingId,
						course.getNetacadCoreOfferingId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSE_WHERE);

			boolean bindNetacadCoreOfferingId = false;

			if (netacadCoreOfferingId == null) {
				query.append(_FINDER_COLUMN_NETACADOFFERINGID_NETACADCOREOFFERINGID_1);
			}
			else if (netacadCoreOfferingId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NETACADOFFERINGID_NETACADCOREOFFERINGID_3);
			}
			else {
				bindNetacadCoreOfferingId = true;

				query.append(_FINDER_COLUMN_NETACADOFFERINGID_NETACADCOREOFFERINGID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNetacadCoreOfferingId) {
					qPos.add(netacadCoreOfferingId);
				}

				List<Course> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NETACADOFFERINGID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CoursePersistenceImpl.fetchByNetacadOfferingId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Course course = list.get(0);

					result = course;

					cacheResult(course);

					if ((course.getNetacadCoreOfferingId() == null) ||
							!course.getNetacadCoreOfferingId()
									   .equals(netacadCoreOfferingId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NETACADOFFERINGID,
							finderArgs, course);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NETACADOFFERINGID,
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
			return (Course)result;
		}
	}

	/**
	 * Removes the course where netacadCoreOfferingId = &#63; from the database.
	 *
	 * @param netacadCoreOfferingId the netacad core offering ID
	 * @return the course that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course removeByNetacadOfferingId(String netacadCoreOfferingId)
		throws NoSuchCourseException, SystemException {
		Course course = findByNetacadOfferingId(netacadCoreOfferingId);

		return remove(course);
	}

	/**
	 * Returns the number of courses where netacadCoreOfferingId = &#63;.
	 *
	 * @param netacadCoreOfferingId the netacad core offering ID
	 * @return the number of matching courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNetacadOfferingId(String netacadCoreOfferingId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NETACADOFFERINGID;

		Object[] finderArgs = new Object[] { netacadCoreOfferingId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_WHERE);

			boolean bindNetacadCoreOfferingId = false;

			if (netacadCoreOfferingId == null) {
				query.append(_FINDER_COLUMN_NETACADOFFERINGID_NETACADCOREOFFERINGID_1);
			}
			else if (netacadCoreOfferingId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NETACADOFFERINGID_NETACADCOREOFFERINGID_3);
			}
			else {
				bindNetacadCoreOfferingId = true;

				query.append(_FINDER_COLUMN_NETACADOFFERINGID_NETACADCOREOFFERINGID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNetacadCoreOfferingId) {
					qPos.add(netacadCoreOfferingId);
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

	private static final String _FINDER_COLUMN_NETACADOFFERINGID_NETACADCOREOFFERINGID_1 =
		"course.netacadCoreOfferingId IS NULL";
	private static final String _FINDER_COLUMN_NETACADOFFERINGID_NETACADCOREOFFERINGID_2 =
		"course.netacadCoreOfferingId = ?";
	private static final String _FINDER_COLUMN_NETACADOFFERINGID_NETACADCOREOFFERINGID_3 =
		"(course.netacadCoreOfferingId IS NULL OR course.netacadCoreOfferingId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NETACADCVLID =
		new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNetacadCVLId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NETACADCVLID =
		new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNetacadCVLId",
			new String[] { String.class.getName() },
			CourseModelImpl.NETACADCVLID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NETACADCVLID = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNetacadCVLId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the courses where netacadCVLId = &#63;.
	 *
	 * @param netacadCVLId the netacad c v l ID
	 * @return the matching courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Course> findByNetacadCVLId(String netacadCVLId)
		throws SystemException {
		return findByNetacadCVLId(netacadCVLId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Course> findByNetacadCVLId(String netacadCVLId, int start,
		int end) throws SystemException {
		return findByNetacadCVLId(netacadCVLId, start, end, null);
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
	@Override
	public List<Course> findByNetacadCVLId(String netacadCVLId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NETACADCVLID;
			finderArgs = new Object[] { netacadCVLId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NETACADCVLID;
			finderArgs = new Object[] {
					netacadCVLId,
					
					start, end, orderByComparator
				};
		}

		List<Course> list = (List<Course>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Course course : list) {
				if (!Validator.equals(netacadCVLId, course.getNetacadCVLId())) {
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

			query.append(_SQL_SELECT_COURSE_WHERE);

			boolean bindNetacadCVLId = false;

			if (netacadCVLId == null) {
				query.append(_FINDER_COLUMN_NETACADCVLID_NETACADCVLID_1);
			}
			else if (netacadCVLId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NETACADCVLID_NETACADCVLID_3);
			}
			else {
				bindNetacadCVLId = true;

				query.append(_FINDER_COLUMN_NETACADCVLID_NETACADCVLID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNetacadCVLId) {
					qPos.add(netacadCVLId);
				}

				if (!pagination) {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Course>(list);
				}
				else {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first course in the ordered set where netacadCVLId = &#63;.
	 *
	 * @param netacadCVLId the netacad c v l ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course
	 * @throws com.instructure.canvas.NoSuchCourseException if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course findByNetacadCVLId_First(String netacadCVLId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByNetacadCVLId_First(netacadCVLId,
				orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("netacadCVLId=");
		msg.append(netacadCVLId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
	}

	/**
	 * Returns the first course in the ordered set where netacadCVLId = &#63;.
	 *
	 * @param netacadCVLId the netacad c v l ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course fetchByNetacadCVLId_First(String netacadCVLId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Course> list = findByNetacadCVLId(netacadCVLId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Course findByNetacadCVLId_Last(String netacadCVLId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByNetacadCVLId_Last(netacadCVLId, orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("netacadCVLId=");
		msg.append(netacadCVLId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
	}

	/**
	 * Returns the last course in the ordered set where netacadCVLId = &#63;.
	 *
	 * @param netacadCVLId the netacad c v l ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course fetchByNetacadCVLId_Last(String netacadCVLId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNetacadCVLId(netacadCVLId);

		if (count == 0) {
			return null;
		}

		List<Course> list = findByNetacadCVLId(netacadCVLId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Course[] findByNetacadCVLId_PrevAndNext(long canvasId,
		String netacadCVLId, OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = findByPrimaryKey(canvasId);

		Session session = null;

		try {
			session = openSession();

			Course[] array = new CourseImpl[3];

			array[0] = getByNetacadCVLId_PrevAndNext(session, course,
					netacadCVLId, orderByComparator, true);

			array[1] = course;

			array[2] = getByNetacadCVLId_PrevAndNext(session, course,
					netacadCVLId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Course getByNetacadCVLId_PrevAndNext(Session session,
		Course course, String netacadCVLId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSE_WHERE);

		boolean bindNetacadCVLId = false;

		if (netacadCVLId == null) {
			query.append(_FINDER_COLUMN_NETACADCVLID_NETACADCVLID_1);
		}
		else if (netacadCVLId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NETACADCVLID_NETACADCVLID_3);
		}
		else {
			bindNetacadCVLId = true;

			query.append(_FINDER_COLUMN_NETACADCVLID_NETACADCVLID_2);
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
			query.append(CourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNetacadCVLId) {
			qPos.add(netacadCVLId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(course);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Course> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the courses where netacadCVLId = &#63; from the database.
	 *
	 * @param netacadCVLId the netacad c v l ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNetacadCVLId(String netacadCVLId)
		throws SystemException {
		for (Course course : findByNetacadCVLId(netacadCVLId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(course);
		}
	}

	/**
	 * Returns the number of courses where netacadCVLId = &#63;.
	 *
	 * @param netacadCVLId the netacad c v l ID
	 * @return the number of matching courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNetacadCVLId(String netacadCVLId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NETACADCVLID;

		Object[] finderArgs = new Object[] { netacadCVLId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_WHERE);

			boolean bindNetacadCVLId = false;

			if (netacadCVLId == null) {
				query.append(_FINDER_COLUMN_NETACADCVLID_NETACADCVLID_1);
			}
			else if (netacadCVLId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NETACADCVLID_NETACADCVLID_3);
			}
			else {
				bindNetacadCVLId = true;

				query.append(_FINDER_COLUMN_NETACADCVLID_NETACADCVLID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNetacadCVLId) {
					qPos.add(netacadCVLId);
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

	private static final String _FINDER_COLUMN_NETACADCVLID_NETACADCVLID_1 = "course.netacadCVLId IS NULL";
	private static final String _FINDER_COLUMN_NETACADCVLID_NETACADCVLID_2 = "course.netacadCVLId = ?";
	private static final String _FINDER_COLUMN_NETACADCVLID_NETACADCVLID_3 = "(course.netacadCVLId IS NULL OR course.netacadCVLId = '')";

	public CoursePersistenceImpl() {
		setModelClass(Course.class);
	}

	/**
	 * Caches the course in the entity cache if it is enabled.
	 *
	 * @param course the course
	 */
	@Override
	public void cacheResult(Course course) {
		EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey(), course);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { course.getId() }, course);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NETACADOFFERINGID,
			new Object[] { course.getNetacadCoreOfferingId() }, course);

		course.resetOriginalValues();
	}

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses
	 */
	@Override
	public void cacheResult(List<Course> courses) {
		for (Course course : courses) {
			if (EntityCacheUtil.getResult(
						CourseModelImpl.ENTITY_CACHE_ENABLED, CourseImpl.class,
						course.getPrimaryKey()) == null) {
				cacheResult(course);
			}
			else {
				course.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all courses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Course course) {
		EntityCacheUtil.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(course);
	}

	@Override
	public void clearCache(List<Course> courses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Course course : courses) {
			EntityCacheUtil.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
				CourseImpl.class, course.getPrimaryKey());

			clearUniqueFindersCache(course);
		}
	}

	protected void cacheUniqueFindersCache(Course course) {
		if (course.isNew()) {
			Object[] args = new Object[] { course.getId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID, args, course);

			args = new Object[] { course.getNetacadCoreOfferingId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NETACADOFFERINGID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NETACADOFFERINGID,
				args, course);
		}
		else {
			CourseModelImpl courseModelImpl = (CourseModelImpl)course;

			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { course.getId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID, args, course);
			}

			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NETACADOFFERINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { course.getNetacadCoreOfferingId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NETACADOFFERINGID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NETACADOFFERINGID,
					args, course);
			}
		}
	}

	protected void clearUniqueFindersCache(Course course) {
		CourseModelImpl courseModelImpl = (CourseModelImpl)course;

		Object[] args = new Object[] { course.getId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);

		if ((courseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
			args = new Object[] { courseModelImpl.getOriginalId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);
		}

		args = new Object[] { course.getNetacadCoreOfferingId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NETACADOFFERINGID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NETACADOFFERINGID,
			args);

		if ((courseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NETACADOFFERINGID.getColumnBitmask()) != 0) {
			args = new Object[] {
					courseModelImpl.getOriginalNetacadCoreOfferingId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NETACADOFFERINGID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NETACADOFFERINGID,
				args);
		}
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param canvasId the primary key for the new course
	 * @return the new course
	 */
	@Override
	public Course create(long canvasId) {
		Course course = new CourseImpl();

		course.setNew(true);
		course.setPrimaryKey(canvasId);

		return course;
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param canvasId the primary key of the course
	 * @return the course that was removed
	 * @throws com.instructure.canvas.NoSuchCourseException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course remove(long canvasId)
		throws NoSuchCourseException, SystemException {
		return remove((Serializable)canvasId);
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course that was removed
	 * @throws com.instructure.canvas.NoSuchCourseException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course remove(Serializable primaryKey)
		throws NoSuchCourseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Course course = (Course)session.get(CourseImpl.class, primaryKey);

			if (course == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(course);
		}
		catch (NoSuchCourseException nsee) {
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
	protected Course removeImpl(Course course) throws SystemException {
		course = toUnwrappedModel(course);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(course)) {
				course = (Course)session.get(CourseImpl.class,
						course.getPrimaryKeyObj());
			}

			if (course != null) {
				session.delete(course);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (course != null) {
			clearCache(course);
		}

		return course;
	}

	@Override
	public Course updateImpl(com.instructure.canvas.model.Course course)
		throws SystemException {
		course = toUnwrappedModel(course);

		boolean isNew = course.isNew();

		CourseModelImpl courseModelImpl = (CourseModelImpl)course;

		Session session = null;

		try {
			session = openSession();

			if (course.isNew()) {
				session.save(course);

				course.setNew(false);
			}
			else {
				session.merge(course);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NETACADCVLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseModelImpl.getOriginalNetacadCVLId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NETACADCVLID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NETACADCVLID,
					args);

				args = new Object[] { courseModelImpl.getNetacadCVLId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NETACADCVLID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NETACADCVLID,
					args);
			}
		}

		EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey(), course);

		clearUniqueFindersCache(course);
		cacheUniqueFindersCache(course);

		return course;
	}

	protected Course toUnwrappedModel(Course course) {
		if (course instanceof CourseImpl) {
			return course;
		}

		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setNew(course.isNew());
		courseImpl.setPrimaryKey(course.getPrimaryKey());

		courseImpl.setCanvasId(course.getCanvasId());
		courseImpl.setName(course.getName());
		courseImpl.setId(course.getId());
		courseImpl.setEnrollments(course.getEnrollments());
		courseImpl.setCourse_code(course.getCourse_code());
		courseImpl.setSis_course_id(course.getSis_course_id());
		courseImpl.setCalendar(course.getCalendar());
		courseImpl.setUrl(course.getUrl());
		courseImpl.setNetacadCoreOfferingId(course.getNetacadCoreOfferingId());
		courseImpl.setAccountId(course.getAccountId());
		courseImpl.setNetacadCVLId(course.getNetacadCVLId());
		courseImpl.setStartDate(course.getStartDate());
		courseImpl.setEndDate(course.getEndDate());

		return courseImpl;
	}

	/**
	 * Returns the course with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course
	 * @throws com.instructure.canvas.NoSuchCourseException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByPrimaryKey(primaryKey);

		if (course == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return course;
	}

	/**
	 * Returns the course with the primary key or throws a {@link com.instructure.canvas.NoSuchCourseException} if it could not be found.
	 *
	 * @param canvasId the primary key of the course
	 * @return the course
	 * @throws com.instructure.canvas.NoSuchCourseException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course findByPrimaryKey(long canvasId)
		throws NoSuchCourseException, SystemException {
		return findByPrimaryKey((Serializable)canvasId);
	}

	/**
	 * Returns the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Course course = (Course)EntityCacheUtil.getResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
				CourseImpl.class, primaryKey);

		if (course == _nullCourse) {
			return null;
		}

		if (course == null) {
			Session session = null;

			try {
				session = openSession();

				course = (Course)session.get(CourseImpl.class, primaryKey);

				if (course != null) {
					cacheResult(course);
				}
				else {
					EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
						CourseImpl.class, primaryKey, _nullCourse);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
					CourseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return course;
	}

	/**
	 * Returns the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param canvasId the primary key of the course
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course fetchByPrimaryKey(long canvasId) throws SystemException {
		return fetchByPrimaryKey((Serializable)canvasId);
	}

	/**
	 * Returns all the courses.
	 *
	 * @return the courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Course> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Course> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Course> findAll(int start, int end,
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

		List<Course> list = (List<Course>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSE;

				if (pagination) {
					sql = sql.concat(CourseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Course>(list);
				}
				else {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the courses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Course course : findAll()) {
			remove(course);
		}
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
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

				Query q = session.createQuery(_SQL_COUNT_COURSE);

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
	 * Initializes the course persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.Course")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Course>> listenersList = new ArrayList<ModelListener<Course>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Course>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSE = "SELECT course FROM Course course";
	private static final String _SQL_SELECT_COURSE_WHERE = "SELECT course FROM Course course WHERE ";
	private static final String _SQL_COUNT_COURSE = "SELECT COUNT(course) FROM Course course";
	private static final String _SQL_COUNT_COURSE_WHERE = "SELECT COUNT(course) FROM Course course WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "course.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Course exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Course exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CoursePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static Course _nullCourse = new CourseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Course> toCacheModel() {
				return _nullCourseCacheModel;
			}
		};

	private static CacheModel<Course> _nullCourseCacheModel = new CacheModel<Course>() {
			@Override
			public Course toEntityModel() {
				return _nullCourse;
			}
		};
}