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

import com.instructure.canvas.NoSuchAssignmentException;
import com.instructure.canvas.model.Assignment;
import com.instructure.canvas.model.impl.AssignmentImpl;
import com.instructure.canvas.model.impl.AssignmentModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentPersistence
 * @see AssignmentUtil
 * @generated
 */
public class AssignmentPersistenceImpl extends BasePersistenceImpl<Assignment>
	implements AssignmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AssignmentUtil} to access the assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AssignmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, AssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, AssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AssignmentPersistenceImpl() {
		setModelClass(Assignment.class);
	}

	/**
	 * Caches the assignment in the entity cache if it is enabled.
	 *
	 * @param assignment the assignment
	 */
	@Override
	public void cacheResult(Assignment assignment) {
		EntityCacheUtil.putResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentImpl.class, assignment.getPrimaryKey(), assignment);

		assignment.resetOriginalValues();
	}

	/**
	 * Caches the assignments in the entity cache if it is enabled.
	 *
	 * @param assignments the assignments
	 */
	@Override
	public void cacheResult(List<Assignment> assignments) {
		for (Assignment assignment : assignments) {
			if (EntityCacheUtil.getResult(
						AssignmentModelImpl.ENTITY_CACHE_ENABLED,
						AssignmentImpl.class, assignment.getPrimaryKey()) == null) {
				cacheResult(assignment);
			}
			else {
				assignment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all assignments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AssignmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AssignmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the assignment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Assignment assignment) {
		EntityCacheUtil.removeResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentImpl.class, assignment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Assignment> assignments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Assignment assignment : assignments) {
			EntityCacheUtil.removeResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
				AssignmentImpl.class, assignment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new assignment with the primary key. Does not add the assignment to the database.
	 *
	 * @param assignmentId the primary key for the new assignment
	 * @return the new assignment
	 */
	@Override
	public Assignment create(long assignmentId) {
		Assignment assignment = new AssignmentImpl();

		assignment.setNew(true);
		assignment.setPrimaryKey(assignmentId);

		return assignment;
	}

	/**
	 * Removes the assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment that was removed
	 * @throws com.instructure.canvas.NoSuchAssignmentException if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment remove(long assignmentId)
		throws NoSuchAssignmentException, SystemException {
		return remove((Serializable)assignmentId);
	}

	/**
	 * Removes the assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the assignment
	 * @return the assignment that was removed
	 * @throws com.instructure.canvas.NoSuchAssignmentException if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment remove(Serializable primaryKey)
		throws NoSuchAssignmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Assignment assignment = (Assignment)session.get(AssignmentImpl.class,
					primaryKey);

			if (assignment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(assignment);
		}
		catch (NoSuchAssignmentException nsee) {
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
	protected Assignment removeImpl(Assignment assignment)
		throws SystemException {
		assignment = toUnwrappedModel(assignment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(assignment)) {
				assignment = (Assignment)session.get(AssignmentImpl.class,
						assignment.getPrimaryKeyObj());
			}

			if (assignment != null) {
				session.delete(assignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (assignment != null) {
			clearCache(assignment);
		}

		return assignment;
	}

	@Override
	public Assignment updateImpl(
		com.instructure.canvas.model.Assignment assignment)
		throws SystemException {
		assignment = toUnwrappedModel(assignment);

		boolean isNew = assignment.isNew();

		Session session = null;

		try {
			session = openSession();

			if (assignment.isNew()) {
				session.save(assignment);

				assignment.setNew(false);
			}
			else {
				session.merge(assignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentImpl.class, assignment.getPrimaryKey(), assignment);

		return assignment;
	}

	protected Assignment toUnwrappedModel(Assignment assignment) {
		if (assignment instanceof AssignmentImpl) {
			return assignment;
		}

		AssignmentImpl assignmentImpl = new AssignmentImpl();

		assignmentImpl.setNew(assignment.isNew());
		assignmentImpl.setPrimaryKey(assignment.getPrimaryKey());

		assignmentImpl.setAssignmentId(assignment.getAssignmentId());
		assignmentImpl.setName(assignment.getName());
		assignmentImpl.setSubmissionType(assignment.getSubmissionType());

		return assignmentImpl;
	}

	/**
	 * Returns the assignment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the assignment
	 * @return the assignment
	 * @throws com.instructure.canvas.NoSuchAssignmentException if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAssignmentException, SystemException {
		Assignment assignment = fetchByPrimaryKey(primaryKey);

		if (assignment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return assignment;
	}

	/**
	 * Returns the assignment with the primary key or throws a {@link com.instructure.canvas.NoSuchAssignmentException} if it could not be found.
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment
	 * @throws com.instructure.canvas.NoSuchAssignmentException if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment findByPrimaryKey(long assignmentId)
		throws NoSuchAssignmentException, SystemException {
		return findByPrimaryKey((Serializable)assignmentId);
	}

	/**
	 * Returns the assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the assignment
	 * @return the assignment, or <code>null</code> if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Assignment assignment = (Assignment)EntityCacheUtil.getResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
				AssignmentImpl.class, primaryKey);

		if (assignment == _nullAssignment) {
			return null;
		}

		if (assignment == null) {
			Session session = null;

			try {
				session = openSession();

				assignment = (Assignment)session.get(AssignmentImpl.class,
						primaryKey);

				if (assignment != null) {
					cacheResult(assignment);
				}
				else {
					EntityCacheUtil.putResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
						AssignmentImpl.class, primaryKey, _nullAssignment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
					AssignmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return assignment;
	}

	/**
	 * Returns the assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment, or <code>null</code> if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment fetchByPrimaryKey(long assignmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)assignmentId);
	}

	/**
	 * Returns all the assignments.
	 *
	 * @return the assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assignment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @return the range of assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assignment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assignment> findAll(int start, int end,
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

		List<Assignment> list = (List<Assignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ASSIGNMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ASSIGNMENT;

				if (pagination) {
					sql = sql.concat(AssignmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Assignment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Assignment>(list);
				}
				else {
					list = (List<Assignment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the assignments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Assignment assignment : findAll()) {
			remove(assignment);
		}
	}

	/**
	 * Returns the number of assignments.
	 *
	 * @return the number of assignments
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

				Query q = session.createQuery(_SQL_COUNT_ASSIGNMENT);

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

	/**
	 * Initializes the assignment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.Assignment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Assignment>> listenersList = new ArrayList<ModelListener<Assignment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Assignment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AssignmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ASSIGNMENT = "SELECT assignment FROM Assignment assignment";
	private static final String _SQL_COUNT_ASSIGNMENT = "SELECT COUNT(assignment) FROM Assignment assignment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "assignment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Assignment exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AssignmentPersistenceImpl.class);
	private static Assignment _nullAssignment = new AssignmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Assignment> toCacheModel() {
				return _nullAssignmentCacheModel;
			}
		};

	private static CacheModel<Assignment> _nullAssignmentCacheModel = new CacheModel<Assignment>() {
			@Override
			public Assignment toEntityModel() {
				return _nullAssignment;
			}
		};
}