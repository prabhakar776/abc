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

import com.instructure.canvas.NoSuchActivityStreamException;
import com.instructure.canvas.model.ActivityStream;
import com.instructure.canvas.model.impl.ActivityStreamImpl;
import com.instructure.canvas.model.impl.ActivityStreamModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the activity stream service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityStreamPersistence
 * @see ActivityStreamUtil
 * @generated
 */
public class ActivityStreamPersistenceImpl extends BasePersistenceImpl<ActivityStream>
	implements ActivityStreamPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ActivityStreamUtil} to access the activity stream persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ActivityStreamImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
			ActivityStreamModelImpl.FINDER_CACHE_ENABLED,
			ActivityStreamImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
			ActivityStreamModelImpl.FINDER_CACHE_ENABLED,
			ActivityStreamImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
			ActivityStreamModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ActivityStreamPersistenceImpl() {
		setModelClass(ActivityStream.class);
	}

	/**
	 * Caches the activity stream in the entity cache if it is enabled.
	 *
	 * @param activityStream the activity stream
	 */
	@Override
	public void cacheResult(ActivityStream activityStream) {
		EntityCacheUtil.putResult(ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
			ActivityStreamImpl.class, activityStream.getPrimaryKey(),
			activityStream);

		activityStream.resetOriginalValues();
	}

	/**
	 * Caches the activity streams in the entity cache if it is enabled.
	 *
	 * @param activityStreams the activity streams
	 */
	@Override
	public void cacheResult(List<ActivityStream> activityStreams) {
		for (ActivityStream activityStream : activityStreams) {
			if (EntityCacheUtil.getResult(
						ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
						ActivityStreamImpl.class, activityStream.getPrimaryKey()) == null) {
				cacheResult(activityStream);
			}
			else {
				activityStream.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all activity streams.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ActivityStreamImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ActivityStreamImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the activity stream.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ActivityStream activityStream) {
		EntityCacheUtil.removeResult(ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
			ActivityStreamImpl.class, activityStream.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ActivityStream> activityStreams) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ActivityStream activityStream : activityStreams) {
			EntityCacheUtil.removeResult(ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
				ActivityStreamImpl.class, activityStream.getPrimaryKey());
		}
	}

	/**
	 * Creates a new activity stream with the primary key. Does not add the activity stream to the database.
	 *
	 * @param activityStreamId the primary key for the new activity stream
	 * @return the new activity stream
	 */
	@Override
	public ActivityStream create(long activityStreamId) {
		ActivityStream activityStream = new ActivityStreamImpl();

		activityStream.setNew(true);
		activityStream.setPrimaryKey(activityStreamId);

		return activityStream;
	}

	/**
	 * Removes the activity stream with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityStreamId the primary key of the activity stream
	 * @return the activity stream that was removed
	 * @throws com.instructure.canvas.NoSuchActivityStreamException if a activity stream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityStream remove(long activityStreamId)
		throws NoSuchActivityStreamException, SystemException {
		return remove((Serializable)activityStreamId);
	}

	/**
	 * Removes the activity stream with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the activity stream
	 * @return the activity stream that was removed
	 * @throws com.instructure.canvas.NoSuchActivityStreamException if a activity stream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityStream remove(Serializable primaryKey)
		throws NoSuchActivityStreamException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ActivityStream activityStream = (ActivityStream)session.get(ActivityStreamImpl.class,
					primaryKey);

			if (activityStream == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActivityStreamException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(activityStream);
		}
		catch (NoSuchActivityStreamException nsee) {
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
	protected ActivityStream removeImpl(ActivityStream activityStream)
		throws SystemException {
		activityStream = toUnwrappedModel(activityStream);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(activityStream)) {
				activityStream = (ActivityStream)session.get(ActivityStreamImpl.class,
						activityStream.getPrimaryKeyObj());
			}

			if (activityStream != null) {
				session.delete(activityStream);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (activityStream != null) {
			clearCache(activityStream);
		}

		return activityStream;
	}

	@Override
	public ActivityStream updateImpl(
		com.instructure.canvas.model.ActivityStream activityStream)
		throws SystemException {
		activityStream = toUnwrappedModel(activityStream);

		boolean isNew = activityStream.isNew();

		Session session = null;

		try {
			session = openSession();

			if (activityStream.isNew()) {
				session.save(activityStream);

				activityStream.setNew(false);
			}
			else {
				session.merge(activityStream);
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

		EntityCacheUtil.putResult(ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
			ActivityStreamImpl.class, activityStream.getPrimaryKey(),
			activityStream);

		return activityStream;
	}

	protected ActivityStream toUnwrappedModel(ActivityStream activityStream) {
		if (activityStream instanceof ActivityStreamImpl) {
			return activityStream;
		}

		ActivityStreamImpl activityStreamImpl = new ActivityStreamImpl();

		activityStreamImpl.setNew(activityStream.isNew());
		activityStreamImpl.setPrimaryKey(activityStream.getPrimaryKey());

		activityStreamImpl.setActivityStreamId(activityStream.getActivityStreamId());
		activityStreamImpl.setCreatedAt(activityStream.getCreatedAt());
		activityStreamImpl.setUpdatedAt(activityStream.getUpdatedAt());
		activityStreamImpl.setId(activityStream.getId());
		activityStreamImpl.setTitle(activityStream.getTitle());
		activityStreamImpl.setMessage(activityStream.getMessage());
		activityStreamImpl.setType(activityStream.getType());
		activityStreamImpl.setContextType(activityStream.getContextType());
		activityStreamImpl.setCourseId(activityStream.getCourseId());
		activityStreamImpl.setGroupId(activityStream.getGroupId());
		activityStreamImpl.setHtmlUrl(activityStream.getHtmlUrl());

		return activityStreamImpl;
	}

	/**
	 * Returns the activity stream with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity stream
	 * @return the activity stream
	 * @throws com.instructure.canvas.NoSuchActivityStreamException if a activity stream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityStream findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActivityStreamException, SystemException {
		ActivityStream activityStream = fetchByPrimaryKey(primaryKey);

		if (activityStream == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActivityStreamException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return activityStream;
	}

	/**
	 * Returns the activity stream with the primary key or throws a {@link com.instructure.canvas.NoSuchActivityStreamException} if it could not be found.
	 *
	 * @param activityStreamId the primary key of the activity stream
	 * @return the activity stream
	 * @throws com.instructure.canvas.NoSuchActivityStreamException if a activity stream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityStream findByPrimaryKey(long activityStreamId)
		throws NoSuchActivityStreamException, SystemException {
		return findByPrimaryKey((Serializable)activityStreamId);
	}

	/**
	 * Returns the activity stream with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity stream
	 * @return the activity stream, or <code>null</code> if a activity stream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityStream fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ActivityStream activityStream = (ActivityStream)EntityCacheUtil.getResult(ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
				ActivityStreamImpl.class, primaryKey);

		if (activityStream == _nullActivityStream) {
			return null;
		}

		if (activityStream == null) {
			Session session = null;

			try {
				session = openSession();

				activityStream = (ActivityStream)session.get(ActivityStreamImpl.class,
						primaryKey);

				if (activityStream != null) {
					cacheResult(activityStream);
				}
				else {
					EntityCacheUtil.putResult(ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
						ActivityStreamImpl.class, primaryKey,
						_nullActivityStream);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ActivityStreamModelImpl.ENTITY_CACHE_ENABLED,
					ActivityStreamImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return activityStream;
	}

	/**
	 * Returns the activity stream with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityStreamId the primary key of the activity stream
	 * @return the activity stream, or <code>null</code> if a activity stream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityStream fetchByPrimaryKey(long activityStreamId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)activityStreamId);
	}

	/**
	 * Returns all the activity streams.
	 *
	 * @return the activity streams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActivityStream> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity streams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.ActivityStreamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity streams
	 * @param end the upper bound of the range of activity streams (not inclusive)
	 * @return the range of activity streams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActivityStream> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity streams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.ActivityStreamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity streams
	 * @param end the upper bound of the range of activity streams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activity streams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActivityStream> findAll(int start, int end,
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

		List<ActivityStream> list = (List<ActivityStream>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ACTIVITYSTREAM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIVITYSTREAM;

				if (pagination) {
					sql = sql.concat(ActivityStreamModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ActivityStream>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ActivityStream>(list);
				}
				else {
					list = (List<ActivityStream>)QueryUtil.list(q,
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
	 * Removes all the activity streams from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ActivityStream activityStream : findAll()) {
			remove(activityStream);
		}
	}

	/**
	 * Returns the number of activity streams.
	 *
	 * @return the number of activity streams
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

				Query q = session.createQuery(_SQL_COUNT_ACTIVITYSTREAM);

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
	 * Initializes the activity stream persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.ActivityStream")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ActivityStream>> listenersList = new ArrayList<ModelListener<ActivityStream>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ActivityStream>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ActivityStreamImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ACTIVITYSTREAM = "SELECT activityStream FROM ActivityStream activityStream";
	private static final String _SQL_COUNT_ACTIVITYSTREAM = "SELECT COUNT(activityStream) FROM ActivityStream activityStream";
	private static final String _ORDER_BY_ENTITY_ALIAS = "activityStream.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ActivityStream exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ActivityStreamPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "type"
			});
	private static ActivityStream _nullActivityStream = new ActivityStreamImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ActivityStream> toCacheModel() {
				return _nullActivityStreamCacheModel;
			}
		};

	private static CacheModel<ActivityStream> _nullActivityStreamCacheModel = new CacheModel<ActivityStream>() {
			@Override
			public ActivityStream toEntityModel() {
				return _nullActivityStream;
			}
		};
}