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

import com.instructure.canvas.NoSuchCanvasAccountException;
import com.instructure.canvas.model.CanvasAccount;
import com.instructure.canvas.model.impl.CanvasAccountImpl;
import com.instructure.canvas.model.impl.CanvasAccountModelImpl;

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
 * The persistence implementation for the canvas account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasAccountPersistence
 * @see CanvasAccountUtil
 * @generated
 */
public class CanvasAccountPersistenceImpl extends BasePersistenceImpl<CanvasAccount>
	implements CanvasAccountPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CanvasAccountUtil} to access the canvas account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CanvasAccountImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
			CanvasAccountModelImpl.FINDER_CACHE_ENABLED,
			CanvasAccountImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
			CanvasAccountModelImpl.FINDER_CACHE_ENABLED,
			CanvasAccountImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
			CanvasAccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CanvasAccountPersistenceImpl() {
		setModelClass(CanvasAccount.class);
	}

	/**
	 * Caches the canvas account in the entity cache if it is enabled.
	 *
	 * @param canvasAccount the canvas account
	 */
	@Override
	public void cacheResult(CanvasAccount canvasAccount) {
		EntityCacheUtil.putResult(CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
			CanvasAccountImpl.class, canvasAccount.getPrimaryKey(),
			canvasAccount);

		canvasAccount.resetOriginalValues();
	}

	/**
	 * Caches the canvas accounts in the entity cache if it is enabled.
	 *
	 * @param canvasAccounts the canvas accounts
	 */
	@Override
	public void cacheResult(List<CanvasAccount> canvasAccounts) {
		for (CanvasAccount canvasAccount : canvasAccounts) {
			if (EntityCacheUtil.getResult(
						CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
						CanvasAccountImpl.class, canvasAccount.getPrimaryKey()) == null) {
				cacheResult(canvasAccount);
			}
			else {
				canvasAccount.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all canvas accounts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CanvasAccountImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CanvasAccountImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the canvas account.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CanvasAccount canvasAccount) {
		EntityCacheUtil.removeResult(CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
			CanvasAccountImpl.class, canvasAccount.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CanvasAccount> canvasAccounts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CanvasAccount canvasAccount : canvasAccounts) {
			EntityCacheUtil.removeResult(CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
				CanvasAccountImpl.class, canvasAccount.getPrimaryKey());
		}
	}

	/**
	 * Creates a new canvas account with the primary key. Does not add the canvas account to the database.
	 *
	 * @param accountId the primary key for the new canvas account
	 * @return the new canvas account
	 */
	@Override
	public CanvasAccount create(long accountId) {
		CanvasAccount canvasAccount = new CanvasAccountImpl();

		canvasAccount.setNew(true);
		canvasAccount.setPrimaryKey(accountId);

		return canvasAccount;
	}

	/**
	 * Removes the canvas account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the canvas account
	 * @return the canvas account that was removed
	 * @throws com.instructure.canvas.NoSuchCanvasAccountException if a canvas account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasAccount remove(long accountId)
		throws NoSuchCanvasAccountException, SystemException {
		return remove((Serializable)accountId);
	}

	/**
	 * Removes the canvas account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the canvas account
	 * @return the canvas account that was removed
	 * @throws com.instructure.canvas.NoSuchCanvasAccountException if a canvas account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasAccount remove(Serializable primaryKey)
		throws NoSuchCanvasAccountException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CanvasAccount canvasAccount = (CanvasAccount)session.get(CanvasAccountImpl.class,
					primaryKey);

			if (canvasAccount == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCanvasAccountException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(canvasAccount);
		}
		catch (NoSuchCanvasAccountException nsee) {
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
	protected CanvasAccount removeImpl(CanvasAccount canvasAccount)
		throws SystemException {
		canvasAccount = toUnwrappedModel(canvasAccount);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(canvasAccount)) {
				canvasAccount = (CanvasAccount)session.get(CanvasAccountImpl.class,
						canvasAccount.getPrimaryKeyObj());
			}

			if (canvasAccount != null) {
				session.delete(canvasAccount);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (canvasAccount != null) {
			clearCache(canvasAccount);
		}

		return canvasAccount;
	}

	@Override
	public CanvasAccount updateImpl(
		com.instructure.canvas.model.CanvasAccount canvasAccount)
		throws SystemException {
		canvasAccount = toUnwrappedModel(canvasAccount);

		boolean isNew = canvasAccount.isNew();

		Session session = null;

		try {
			session = openSession();

			if (canvasAccount.isNew()) {
				session.save(canvasAccount);

				canvasAccount.setNew(false);
			}
			else {
				session.merge(canvasAccount);
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

		EntityCacheUtil.putResult(CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
			CanvasAccountImpl.class, canvasAccount.getPrimaryKey(),
			canvasAccount);

		return canvasAccount;
	}

	protected CanvasAccount toUnwrappedModel(CanvasAccount canvasAccount) {
		if (canvasAccount instanceof CanvasAccountImpl) {
			return canvasAccount;
		}

		CanvasAccountImpl canvasAccountImpl = new CanvasAccountImpl();

		canvasAccountImpl.setNew(canvasAccount.isNew());
		canvasAccountImpl.setPrimaryKey(canvasAccount.getPrimaryKey());

		canvasAccountImpl.setAccountId(canvasAccount.getAccountId());
		canvasAccountImpl.setId(canvasAccount.getId());
		canvasAccountImpl.setParentAccountId(canvasAccount.getParentAccountId());
		canvasAccountImpl.setName(canvasAccount.getName());
		canvasAccountImpl.setRootAccountId(canvasAccount.getRootAccountId());
		canvasAccountImpl.setSISAccountId(canvasAccount.getSISAccountId());
		canvasAccountImpl.setStatus(canvasAccount.getStatus());
		canvasAccountImpl.setTimeZone(canvasAccount.getTimeZone());

		return canvasAccountImpl;
	}

	/**
	 * Returns the canvas account with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the canvas account
	 * @return the canvas account
	 * @throws com.instructure.canvas.NoSuchCanvasAccountException if a canvas account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasAccount findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCanvasAccountException, SystemException {
		CanvasAccount canvasAccount = fetchByPrimaryKey(primaryKey);

		if (canvasAccount == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCanvasAccountException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return canvasAccount;
	}

	/**
	 * Returns the canvas account with the primary key or throws a {@link com.instructure.canvas.NoSuchCanvasAccountException} if it could not be found.
	 *
	 * @param accountId the primary key of the canvas account
	 * @return the canvas account
	 * @throws com.instructure.canvas.NoSuchCanvasAccountException if a canvas account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasAccount findByPrimaryKey(long accountId)
		throws NoSuchCanvasAccountException, SystemException {
		return findByPrimaryKey((Serializable)accountId);
	}

	/**
	 * Returns the canvas account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the canvas account
	 * @return the canvas account, or <code>null</code> if a canvas account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasAccount fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CanvasAccount canvasAccount = (CanvasAccount)EntityCacheUtil.getResult(CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
				CanvasAccountImpl.class, primaryKey);

		if (canvasAccount == _nullCanvasAccount) {
			return null;
		}

		if (canvasAccount == null) {
			Session session = null;

			try {
				session = openSession();

				canvasAccount = (CanvasAccount)session.get(CanvasAccountImpl.class,
						primaryKey);

				if (canvasAccount != null) {
					cacheResult(canvasAccount);
				}
				else {
					EntityCacheUtil.putResult(CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
						CanvasAccountImpl.class, primaryKey, _nullCanvasAccount);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CanvasAccountModelImpl.ENTITY_CACHE_ENABLED,
					CanvasAccountImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return canvasAccount;
	}

	/**
	 * Returns the canvas account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountId the primary key of the canvas account
	 * @return the canvas account, or <code>null</code> if a canvas account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CanvasAccount fetchByPrimaryKey(long accountId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)accountId);
	}

	/**
	 * Returns all the canvas accounts.
	 *
	 * @return the canvas accounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CanvasAccount> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the canvas accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of canvas accounts
	 * @param end the upper bound of the range of canvas accounts (not inclusive)
	 * @return the range of canvas accounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CanvasAccount> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the canvas accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.CanvasAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of canvas accounts
	 * @param end the upper bound of the range of canvas accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of canvas accounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CanvasAccount> findAll(int start, int end,
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

		List<CanvasAccount> list = (List<CanvasAccount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CANVASACCOUNT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANVASACCOUNT;

				if (pagination) {
					sql = sql.concat(CanvasAccountModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CanvasAccount>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CanvasAccount>(list);
				}
				else {
					list = (List<CanvasAccount>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the canvas accounts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CanvasAccount canvasAccount : findAll()) {
			remove(canvasAccount);
		}
	}

	/**
	 * Returns the number of canvas accounts.
	 *
	 * @return the number of canvas accounts
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

				Query q = session.createQuery(_SQL_COUNT_CANVASACCOUNT);

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
	 * Initializes the canvas account persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.CanvasAccount")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CanvasAccount>> listenersList = new ArrayList<ModelListener<CanvasAccount>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CanvasAccount>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CanvasAccountImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CANVASACCOUNT = "SELECT canvasAccount FROM CanvasAccount canvasAccount";
	private static final String _SQL_COUNT_CANVASACCOUNT = "SELECT COUNT(canvasAccount) FROM CanvasAccount canvasAccount";
	private static final String _ORDER_BY_ENTITY_ALIAS = "canvasAccount.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CanvasAccount exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CanvasAccountPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static CanvasAccount _nullCanvasAccount = new CanvasAccountImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CanvasAccount> toCacheModel() {
				return _nullCanvasAccountCacheModel;
			}
		};

	private static CacheModel<CanvasAccount> _nullCanvasAccountCacheModel = new CacheModel<CanvasAccount>() {
			@Override
			public CanvasAccount toEntityModel() {
				return _nullCanvasAccount;
			}
		};
}