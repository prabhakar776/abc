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

import com.instructure.canvas.NoSuchSubmissionVersionException;
import com.instructure.canvas.model.SubmissionVersion;
import com.instructure.canvas.model.impl.SubmissionVersionImpl;
import com.instructure.canvas.model.impl.SubmissionVersionModelImpl;

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
 * The persistence implementation for the submission version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionVersionPersistence
 * @see SubmissionVersionUtil
 * @generated
 */
public class SubmissionVersionPersistenceImpl extends BasePersistenceImpl<SubmissionVersion>
	implements SubmissionVersionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubmissionVersionUtil} to access the submission version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubmissionVersionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionVersionModelImpl.FINDER_CACHE_ENABLED,
			SubmissionVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionVersionModelImpl.FINDER_CACHE_ENABLED,
			SubmissionVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SubmissionVersionPersistenceImpl() {
		setModelClass(SubmissionVersion.class);
	}

	/**
	 * Caches the submission version in the entity cache if it is enabled.
	 *
	 * @param submissionVersion the submission version
	 */
	@Override
	public void cacheResult(SubmissionVersion submissionVersion) {
		EntityCacheUtil.putResult(SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionVersionImpl.class, submissionVersion.getPrimaryKey(),
			submissionVersion);

		submissionVersion.resetOriginalValues();
	}

	/**
	 * Caches the submission versions in the entity cache if it is enabled.
	 *
	 * @param submissionVersions the submission versions
	 */
	@Override
	public void cacheResult(List<SubmissionVersion> submissionVersions) {
		for (SubmissionVersion submissionVersion : submissionVersions) {
			if (EntityCacheUtil.getResult(
						SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
						SubmissionVersionImpl.class,
						submissionVersion.getPrimaryKey()) == null) {
				cacheResult(submissionVersion);
			}
			else {
				submissionVersion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all submission versions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubmissionVersionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubmissionVersionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the submission version.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubmissionVersion submissionVersion) {
		EntityCacheUtil.removeResult(SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionVersionImpl.class, submissionVersion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SubmissionVersion> submissionVersions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SubmissionVersion submissionVersion : submissionVersions) {
			EntityCacheUtil.removeResult(SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
				SubmissionVersionImpl.class, submissionVersion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new submission version with the primary key. Does not add the submission version to the database.
	 *
	 * @param submissionId the primary key for the new submission version
	 * @return the new submission version
	 */
	@Override
	public SubmissionVersion create(long submissionId) {
		SubmissionVersion submissionVersion = new SubmissionVersionImpl();

		submissionVersion.setNew(true);
		submissionVersion.setPrimaryKey(submissionId);

		return submissionVersion;
	}

	/**
	 * Removes the submission version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param submissionId the primary key of the submission version
	 * @return the submission version that was removed
	 * @throws com.instructure.canvas.NoSuchSubmissionVersionException if a submission version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionVersion remove(long submissionId)
		throws NoSuchSubmissionVersionException, SystemException {
		return remove((Serializable)submissionId);
	}

	/**
	 * Removes the submission version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the submission version
	 * @return the submission version that was removed
	 * @throws com.instructure.canvas.NoSuchSubmissionVersionException if a submission version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionVersion remove(Serializable primaryKey)
		throws NoSuchSubmissionVersionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SubmissionVersion submissionVersion = (SubmissionVersion)session.get(SubmissionVersionImpl.class,
					primaryKey);

			if (submissionVersion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubmissionVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(submissionVersion);
		}
		catch (NoSuchSubmissionVersionException nsee) {
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
	protected SubmissionVersion removeImpl(SubmissionVersion submissionVersion)
		throws SystemException {
		submissionVersion = toUnwrappedModel(submissionVersion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(submissionVersion)) {
				submissionVersion = (SubmissionVersion)session.get(SubmissionVersionImpl.class,
						submissionVersion.getPrimaryKeyObj());
			}

			if (submissionVersion != null) {
				session.delete(submissionVersion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (submissionVersion != null) {
			clearCache(submissionVersion);
		}

		return submissionVersion;
	}

	@Override
	public SubmissionVersion updateImpl(
		com.instructure.canvas.model.SubmissionVersion submissionVersion)
		throws SystemException {
		submissionVersion = toUnwrappedModel(submissionVersion);

		boolean isNew = submissionVersion.isNew();

		Session session = null;

		try {
			session = openSession();

			if (submissionVersion.isNew()) {
				session.save(submissionVersion);

				submissionVersion.setNew(false);
			}
			else {
				session.merge(submissionVersion);
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

		EntityCacheUtil.putResult(SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionVersionImpl.class, submissionVersion.getPrimaryKey(),
			submissionVersion);

		return submissionVersion;
	}

	protected SubmissionVersion toUnwrappedModel(
		SubmissionVersion submissionVersion) {
		if (submissionVersion instanceof SubmissionVersionImpl) {
			return submissionVersion;
		}

		SubmissionVersionImpl submissionVersionImpl = new SubmissionVersionImpl();

		submissionVersionImpl.setNew(submissionVersion.isNew());
		submissionVersionImpl.setPrimaryKey(submissionVersion.getPrimaryKey());

		submissionVersionImpl.setSubmissionId(submissionVersion.getSubmissionId());
		submissionVersionImpl.setAssignmentId(submissionVersion.getAssignmentId());
		submissionVersionImpl.setAssignmentName(submissionVersion.getAssignmentName());
		submissionVersionImpl.setAttempt(submissionVersion.getAttempt());
		submissionVersionImpl.setBody(submissionVersion.getBody());
		submissionVersionImpl.setCurrentGrade(submissionVersion.getCurrentGrade());
		submissionVersionImpl.setCurrentGradedAt(submissionVersion.getCurrentGradedAt());
		submissionVersionImpl.setCurrentGrader(submissionVersion.getCurrentGrader());
		submissionVersionImpl.setGradeMatchesCurrentSubmission(submissionVersion.getGradeMatchesCurrentSubmission());
		submissionVersionImpl.setGradedAt(submissionVersion.getGradedAt());
		submissionVersionImpl.setGrader(submissionVersion.getGrader());
		submissionVersionImpl.setGraderId(submissionVersion.getGraderId());
		submissionVersionImpl.setNewGrade(submissionVersion.getNewGrade());
		submissionVersionImpl.setNewGradedAt(submissionVersion.getNewGradedAt());
		submissionVersionImpl.setNewGrader(submissionVersion.getNewGrader());
		submissionVersionImpl.setPreviousGrade(submissionVersion.getPreviousGrade());
		submissionVersionImpl.setPreviousGradedAt(submissionVersion.getPreviousGradedAt());
		submissionVersionImpl.setPreviousGrader(submissionVersion.getPreviousGrader());
		submissionVersionImpl.setScore(submissionVersion.getScore());
		submissionVersionImpl.setUserName(submissionVersion.getUserName());
		submissionVersionImpl.setUserId(submissionVersion.getUserId());
		submissionVersionImpl.setSubmissionType(submissionVersion.getSubmissionType());
		submissionVersionImpl.setUrl(submissionVersion.getUrl());
		submissionVersionImpl.setWorkflowState(submissionVersion.getWorkflowState());

		return submissionVersionImpl;
	}

	/**
	 * Returns the submission version with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the submission version
	 * @return the submission version
	 * @throws com.instructure.canvas.NoSuchSubmissionVersionException if a submission version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubmissionVersionException, SystemException {
		SubmissionVersion submissionVersion = fetchByPrimaryKey(primaryKey);

		if (submissionVersion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubmissionVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return submissionVersion;
	}

	/**
	 * Returns the submission version with the primary key or throws a {@link com.instructure.canvas.NoSuchSubmissionVersionException} if it could not be found.
	 *
	 * @param submissionId the primary key of the submission version
	 * @return the submission version
	 * @throws com.instructure.canvas.NoSuchSubmissionVersionException if a submission version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionVersion findByPrimaryKey(long submissionId)
		throws NoSuchSubmissionVersionException, SystemException {
		return findByPrimaryKey((Serializable)submissionId);
	}

	/**
	 * Returns the submission version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the submission version
	 * @return the submission version, or <code>null</code> if a submission version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionVersion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SubmissionVersion submissionVersion = (SubmissionVersion)EntityCacheUtil.getResult(SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
				SubmissionVersionImpl.class, primaryKey);

		if (submissionVersion == _nullSubmissionVersion) {
			return null;
		}

		if (submissionVersion == null) {
			Session session = null;

			try {
				session = openSession();

				submissionVersion = (SubmissionVersion)session.get(SubmissionVersionImpl.class,
						primaryKey);

				if (submissionVersion != null) {
					cacheResult(submissionVersion);
				}
				else {
					EntityCacheUtil.putResult(SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
						SubmissionVersionImpl.class, primaryKey,
						_nullSubmissionVersion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubmissionVersionModelImpl.ENTITY_CACHE_ENABLED,
					SubmissionVersionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return submissionVersion;
	}

	/**
	 * Returns the submission version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param submissionId the primary key of the submission version
	 * @return the submission version, or <code>null</code> if a submission version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionVersion fetchByPrimaryKey(long submissionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)submissionId);
	}

	/**
	 * Returns all the submission versions.
	 *
	 * @return the submission versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionVersion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SubmissionVersion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SubmissionVersion> findAll(int start, int end,
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

		List<SubmissionVersion> list = (List<SubmissionVersion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBMISSIONVERSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBMISSIONVERSION;

				if (pagination) {
					sql = sql.concat(SubmissionVersionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SubmissionVersion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionVersion>(list);
				}
				else {
					list = (List<SubmissionVersion>)QueryUtil.list(q,
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
	 * Removes all the submission versions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SubmissionVersion submissionVersion : findAll()) {
			remove(submissionVersion);
		}
	}

	/**
	 * Returns the number of submission versions.
	 *
	 * @return the number of submission versions
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

				Query q = session.createQuery(_SQL_COUNT_SUBMISSIONVERSION);

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
	 * Initializes the submission version persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.SubmissionVersion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SubmissionVersion>> listenersList = new ArrayList<ModelListener<SubmissionVersion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SubmissionVersion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubmissionVersionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBMISSIONVERSION = "SELECT submissionVersion FROM SubmissionVersion submissionVersion";
	private static final String _SQL_COUNT_SUBMISSIONVERSION = "SELECT COUNT(submissionVersion) FROM SubmissionVersion submissionVersion";
	private static final String _ORDER_BY_ENTITY_ALIAS = "submissionVersion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubmissionVersion exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubmissionVersionPersistenceImpl.class);
	private static SubmissionVersion _nullSubmissionVersion = new SubmissionVersionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SubmissionVersion> toCacheModel() {
				return _nullSubmissionVersionCacheModel;
			}
		};

	private static CacheModel<SubmissionVersion> _nullSubmissionVersionCacheModel =
		new CacheModel<SubmissionVersion>() {
			@Override
			public SubmissionVersion toEntityModel() {
				return _nullSubmissionVersion;
			}
		};
}