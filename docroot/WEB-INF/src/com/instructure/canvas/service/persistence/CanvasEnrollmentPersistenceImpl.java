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

import com.instructure.canvas.NoSuchCanvasEnrollmentException;
import com.instructure.canvas.model.CanvasEnrollment;
import com.instructure.canvas.model.impl.CanvasEnrollmentImpl;
import com.instructure.canvas.model.impl.CanvasEnrollmentModelImpl;

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
 * The persistence implementation for the canvas enrollment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasEnrollmentPersistence
 * @see CanvasEnrollmentUtil
 * @generated
 */
public class CanvasEnrollmentPersistenceImpl extends BasePersistenceImpl<CanvasEnrollment>
	implements CanvasEnrollmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CanvasEnrollmentUtil} to access the canvas enrollment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CanvasEnrollmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			CanvasEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			CanvasEnrollmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			CanvasEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			CanvasEnrollmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			CanvasEnrollmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CanvasEnrollmentPersistenceImpl() {
		setModelClass(CanvasEnrollment.class);
	}

	/**
	 * Caches the canvas enrollment in the entity cache if it is enabled.
	 *
	 * @param canvasEnrollment the canvas enrollment
	 */
	@Override
	public void cacheResult(CanvasEnrollment canvasEnrollment) {
		EntityCacheUtil.putResult(CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			CanvasEnrollmentImpl.class, canvasEnrollment.getPrimaryKey(),
			canvasEnrollment);

		canvasEnrollment.resetOriginalValues();
	}

	/**
	 * Caches the canvas enrollments in the entity cache if it is enabled.
	 *
	 * @param canvasEnrollments the canvas enrollments
	 */
	@Override
	public void cacheResult(List<CanvasEnrollment> canvasEnrollments) {
		for (CanvasEnrollment canvasEnrollment : canvasEnrollments) {
			if (EntityCacheUtil.getResult(
						CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
						CanvasEnrollmentImpl.class,
						canvasEnrollment.getPrimaryKey()) == null) {
				cacheResult(canvasEnrollment);
			}
			else {
				canvasEnrollment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all canvas enrollments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CanvasEnrollmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CanvasEnrollmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the canvas enrollment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CanvasEnrollment canvasEnrollment) {
		EntityCacheUtil.removeResult(CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			CanvasEnrollmentImpl.class, canvasEnrollment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CanvasEnrollment> canvasEnrollments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CanvasEnrollment canvasEnrollment : canvasEnrollments) {
			EntityCacheUtil.removeResult(CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
				CanvasEnrollmentImpl.class, canvasEnrollment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new canvas enrollment with the primary key. Does not add the canvas enrollment to the database.
	 *
	 * @param courseId the primary key for the new canvas enrollment
	 * @return the new canvas enrollment
	 */
	@Override
	public CanvasEnrollment create(long courseId) {
		CanvasEnrollment canvasEnrollment = new CanvasEnrollmentImpl();

		canvasEnrollment.setNew(true);
		canvasEnrollment.setPrimaryKey(courseId);

		return canvasEnrollment;
	}

	/**
	 * Removes the canvas enrollment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseId the primary key of the canvas enrollment
	 * @return the canvas enrollment that was removed
	 * @throws com.instructure.canvas.NoSuchCanvasEnrollmentException if a canvas enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasEnrollment remove(long courseId)
		throws NoSuchCanvasEnrollmentException, SystemException {
		return remove((Serializable)courseId);
	}

	/**
	 * Removes the canvas enrollment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the canvas enrollment
	 * @return the canvas enrollment that was removed
	 * @throws com.instructure.canvas.NoSuchCanvasEnrollmentException if a canvas enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasEnrollment remove(Serializable primaryKey)
		throws NoSuchCanvasEnrollmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CanvasEnrollment canvasEnrollment = (CanvasEnrollment)session.get(CanvasEnrollmentImpl.class,
					primaryKey);

			if (canvasEnrollment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCanvasEnrollmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(canvasEnrollment);
		}
		catch (NoSuchCanvasEnrollmentException nsee) {
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
	protected CanvasEnrollment removeImpl(CanvasEnrollment canvasEnrollment)
		throws SystemException {
		canvasEnrollment = toUnwrappedModel(canvasEnrollment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(canvasEnrollment)) {
				canvasEnrollment = (CanvasEnrollment)session.get(CanvasEnrollmentImpl.class,
						canvasEnrollment.getPrimaryKeyObj());
			}

			if (canvasEnrollment != null) {
				session.delete(canvasEnrollment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (canvasEnrollment != null) {
			clearCache(canvasEnrollment);
		}

		return canvasEnrollment;
	}

	@Override
	public CanvasEnrollment updateImpl(
		com.instructure.canvas.model.CanvasEnrollment canvasEnrollment)
		throws SystemException {
		canvasEnrollment = toUnwrappedModel(canvasEnrollment);

		boolean isNew = canvasEnrollment.isNew();

		Session session = null;

		try {
			session = openSession();

			if (canvasEnrollment.isNew()) {
				session.save(canvasEnrollment);

				canvasEnrollment.setNew(false);
			}
			else {
				session.merge(canvasEnrollment);
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

		EntityCacheUtil.putResult(CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			CanvasEnrollmentImpl.class, canvasEnrollment.getPrimaryKey(),
			canvasEnrollment);

		return canvasEnrollment;
	}

	protected CanvasEnrollment toUnwrappedModel(
		CanvasEnrollment canvasEnrollment) {
		if (canvasEnrollment instanceof CanvasEnrollmentImpl) {
			return canvasEnrollment;
		}

		CanvasEnrollmentImpl canvasEnrollmentImpl = new CanvasEnrollmentImpl();

		canvasEnrollmentImpl.setNew(canvasEnrollment.isNew());
		canvasEnrollmentImpl.setPrimaryKey(canvasEnrollment.getPrimaryKey());

		canvasEnrollmentImpl.setCourseId(canvasEnrollment.getCourseId());
		canvasEnrollmentImpl.setUserId(canvasEnrollment.getUserId());
		canvasEnrollmentImpl.setRole(canvasEnrollment.getRole());
		canvasEnrollmentImpl.setSectionId(canvasEnrollment.getSectionId());
		canvasEnrollmentImpl.setStatus(canvasEnrollment.getStatus());
		canvasEnrollmentImpl.setAssociatedUserId(canvasEnrollment.getAssociatedUserId());

		return canvasEnrollmentImpl;
	}

	/**
	 * Returns the canvas enrollment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the canvas enrollment
	 * @return the canvas enrollment
	 * @throws com.instructure.canvas.NoSuchCanvasEnrollmentException if a canvas enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasEnrollment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCanvasEnrollmentException, SystemException {
		CanvasEnrollment canvasEnrollment = fetchByPrimaryKey(primaryKey);

		if (canvasEnrollment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCanvasEnrollmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return canvasEnrollment;
	}

	/**
	 * Returns the canvas enrollment with the primary key or throws a {@link com.instructure.canvas.NoSuchCanvasEnrollmentException} if it could not be found.
	 *
	 * @param courseId the primary key of the canvas enrollment
	 * @return the canvas enrollment
	 * @throws com.instructure.canvas.NoSuchCanvasEnrollmentException if a canvas enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasEnrollment findByPrimaryKey(long courseId)
		throws NoSuchCanvasEnrollmentException, SystemException {
		return findByPrimaryKey((Serializable)courseId);
	}

	/**
	 * Returns the canvas enrollment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the canvas enrollment
	 * @return the canvas enrollment, or <code>null</code> if a canvas enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasEnrollment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CanvasEnrollment canvasEnrollment = (CanvasEnrollment)EntityCacheUtil.getResult(CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
				CanvasEnrollmentImpl.class, primaryKey);

		if (canvasEnrollment == _nullCanvasEnrollment) {
			return null;
		}

		if (canvasEnrollment == null) {
			Session session = null;

			try {
				session = openSession();

				canvasEnrollment = (CanvasEnrollment)session.get(CanvasEnrollmentImpl.class,
						primaryKey);

				if (canvasEnrollment != null) {
					cacheResult(canvasEnrollment);
				}
				else {
					EntityCacheUtil.putResult(CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
						CanvasEnrollmentImpl.class, primaryKey,
						_nullCanvasEnrollment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CanvasEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
					CanvasEnrollmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return canvasEnrollment;
	}

	/**
	 * Returns the canvas enrollment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseId the primary key of the canvas enrollment
	 * @return the canvas enrollment, or <code>null</code> if a canvas enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasEnrollment fetchByPrimaryKey(long courseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)courseId);
	}

	/**
	 * Returns all the canvas enrollments.
	 *
	 * @return the canvas enrollments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CanvasEnrollment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the canvas enrollments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasEnrollmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of canvas enrollments
	 * @param end the upper bound of the range of canvas enrollments (not inclusive)
	 * @return the range of canvas enrollments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CanvasEnrollment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the canvas enrollments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasEnrollmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of canvas enrollments
	 * @param end the upper bound of the range of canvas enrollments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of canvas enrollments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CanvasEnrollment> findAll(int start, int end,
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

		List<CanvasEnrollment> list = (List<CanvasEnrollment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CANVASENROLLMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANVASENROLLMENT;

				if (pagination) {
					sql = sql.concat(CanvasEnrollmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CanvasEnrollment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CanvasEnrollment>(list);
				}
				else {
					list = (List<CanvasEnrollment>)QueryUtil.list(q,
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
	 * Removes all the canvas enrollments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CanvasEnrollment canvasEnrollment : findAll()) {
			remove(canvasEnrollment);
		}
	}

	/**
	 * Returns the number of canvas enrollments.
	 *
	 * @return the number of canvas enrollments
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

				Query q = session.createQuery(_SQL_COUNT_CANVASENROLLMENT);

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
	 * Initializes the canvas enrollment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.CanvasEnrollment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CanvasEnrollment>> listenersList = new ArrayList<ModelListener<CanvasEnrollment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CanvasEnrollment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CanvasEnrollmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CANVASENROLLMENT = "SELECT canvasEnrollment FROM CanvasEnrollment canvasEnrollment";
	private static final String _SQL_COUNT_CANVASENROLLMENT = "SELECT COUNT(canvasEnrollment) FROM CanvasEnrollment canvasEnrollment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "canvasEnrollment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CanvasEnrollment exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CanvasEnrollmentPersistenceImpl.class);
	private static CanvasEnrollment _nullCanvasEnrollment = new CanvasEnrollmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CanvasEnrollment> toCacheModel() {
				return _nullCanvasEnrollmentCacheModel;
			}
		};

	private static CacheModel<CanvasEnrollment> _nullCanvasEnrollmentCacheModel = new CacheModel<CanvasEnrollment>() {
			@Override
			public CanvasEnrollment toEntityModel() {
				return _nullCanvasEnrollment;
			}
		};
}