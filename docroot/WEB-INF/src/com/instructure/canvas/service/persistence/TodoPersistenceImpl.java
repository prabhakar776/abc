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

import com.instructure.canvas.NoSuchTodoException;
import com.instructure.canvas.model.Todo;
import com.instructure.canvas.model.impl.TodoImpl;
import com.instructure.canvas.model.impl.TodoModelImpl;

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
 * The persistence implementation for the todo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoPersistence
 * @see TodoUtil
 * @generated
 */
public class TodoPersistenceImpl extends BasePersistenceImpl<Todo>
	implements TodoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TodoUtil} to access the todo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TodoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TodoPersistenceImpl() {
		setModelClass(Todo.class);
	}

	/**
	 * Caches the todo in the entity cache if it is enabled.
	 *
	 * @param todo the todo
	 */
	@Override
	public void cacheResult(Todo todo) {
		EntityCacheUtil.putResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoImpl.class, todo.getPrimaryKey(), todo);

		todo.resetOriginalValues();
	}

	/**
	 * Caches the todos in the entity cache if it is enabled.
	 *
	 * @param todos the todos
	 */
	@Override
	public void cacheResult(List<Todo> todos) {
		for (Todo todo : todos) {
			if (EntityCacheUtil.getResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
						TodoImpl.class, todo.getPrimaryKey()) == null) {
				cacheResult(todo);
			}
			else {
				todo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all todos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TodoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TodoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the todo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Todo todo) {
		EntityCacheUtil.removeResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoImpl.class, todo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Todo> todos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Todo todo : todos) {
			EntityCacheUtil.removeResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
				TodoImpl.class, todo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new todo with the primary key. Does not add the todo to the database.
	 *
	 * @param todoId the primary key for the new todo
	 * @return the new todo
	 */
	@Override
	public Todo create(long todoId) {
		Todo todo = new TodoImpl();

		todo.setNew(true);
		todo.setPrimaryKey(todoId);

		return todo;
	}

	/**
	 * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo that was removed
	 * @throws com.instructure.canvas.NoSuchTodoException if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo remove(long todoId) throws NoSuchTodoException, SystemException {
		return remove((Serializable)todoId);
	}

	/**
	 * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the todo
	 * @return the todo that was removed
	 * @throws com.instructure.canvas.NoSuchTodoException if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo remove(Serializable primaryKey)
		throws NoSuchTodoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Todo todo = (Todo)session.get(TodoImpl.class, primaryKey);

			if (todo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTodoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(todo);
		}
		catch (NoSuchTodoException nsee) {
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
	protected Todo removeImpl(Todo todo) throws SystemException {
		todo = toUnwrappedModel(todo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(todo)) {
				todo = (Todo)session.get(TodoImpl.class, todo.getPrimaryKeyObj());
			}

			if (todo != null) {
				session.delete(todo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (todo != null) {
			clearCache(todo);
		}

		return todo;
	}

	@Override
	public Todo updateImpl(com.instructure.canvas.model.Todo todo)
		throws SystemException {
		todo = toUnwrappedModel(todo);

		boolean isNew = todo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (todo.isNew()) {
				session.save(todo);

				todo.setNew(false);
			}
			else {
				session.merge(todo);
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

		EntityCacheUtil.putResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoImpl.class, todo.getPrimaryKey(), todo);

		return todo;
	}

	protected Todo toUnwrappedModel(Todo todo) {
		if (todo instanceof TodoImpl) {
			return todo;
		}

		TodoImpl todoImpl = new TodoImpl();

		todoImpl.setNew(todo.isNew());
		todoImpl.setPrimaryKey(todo.getPrimaryKey());

		todoImpl.setTodoId(todo.getTodoId());
		todoImpl.setType(todo.getType());
		todoImpl.setAssignmentName(todo.getAssignmentName());
		todoImpl.setAssignmentDescription(todo.getAssignmentDescription());
		todoImpl.setIgnore_(todo.getIgnore_());
		todoImpl.setIgnorePermanently(todo.getIgnorePermanently());
		todoImpl.setNeedsGradingCount(todo.getNeedsGradingCount());
		todoImpl.setContextType(todo.getContextType());
		todoImpl.setCourseId(todo.getCourseId());
		todoImpl.setGroupId(todo.getGroupId());
		todoImpl.setHtmlUrl(todo.getHtmlUrl());

		return todoImpl;
	}

	/**
	 * Returns the todo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the todo
	 * @return the todo
	 * @throws com.instructure.canvas.NoSuchTodoException if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTodoException, SystemException {
		Todo todo = fetchByPrimaryKey(primaryKey);

		if (todo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTodoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return todo;
	}

	/**
	 * Returns the todo with the primary key or throws a {@link com.instructure.canvas.NoSuchTodoException} if it could not be found.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo
	 * @throws com.instructure.canvas.NoSuchTodoException if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo findByPrimaryKey(long todoId)
		throws NoSuchTodoException, SystemException {
		return findByPrimaryKey((Serializable)todoId);
	}

	/**
	 * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the todo
	 * @return the todo, or <code>null</code> if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Todo todo = (Todo)EntityCacheUtil.getResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
				TodoImpl.class, primaryKey);

		if (todo == _nullTodo) {
			return null;
		}

		if (todo == null) {
			Session session = null;

			try {
				session = openSession();

				todo = (Todo)session.get(TodoImpl.class, primaryKey);

				if (todo != null) {
					cacheResult(todo);
				}
				else {
					EntityCacheUtil.putResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
						TodoImpl.class, primaryKey, _nullTodo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
					TodoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return todo;
	}

	/**
	 * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo, or <code>null</code> if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo fetchByPrimaryKey(long todoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)todoId);
	}

	/**
	 * Returns all the todos.
	 *
	 * @return the todos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Todo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the todos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of todos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Todo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the todos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of todos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Todo> findAll(int start, int end,
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

		List<Todo> list = (List<Todo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TODO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TODO;

				if (pagination) {
					sql = sql.concat(TodoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Todo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Todo>(list);
				}
				else {
					list = (List<Todo>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the todos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Todo todo : findAll()) {
			remove(todo);
		}
	}

	/**
	 * Returns the number of todos.
	 *
	 * @return the number of todos
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

				Query q = session.createQuery(_SQL_COUNT_TODO);

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
	 * Initializes the todo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.Todo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Todo>> listenersList = new ArrayList<ModelListener<Todo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Todo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TodoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TODO = "SELECT todo FROM Todo todo";
	private static final String _SQL_COUNT_TODO = "SELECT COUNT(todo) FROM Todo todo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "todo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Todo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TodoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static Todo _nullTodo = new TodoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Todo> toCacheModel() {
				return _nullTodoCacheModel;
			}
		};

	private static CacheModel<Todo> _nullTodoCacheModel = new CacheModel<Todo>() {
			@Override
			public Todo toEntityModel() {
				return _nullTodo;
			}
		};
}