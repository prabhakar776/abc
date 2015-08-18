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

import com.instructure.canvas.NoSuchSubmissionException;
import com.instructure.canvas.model.Submission;
import com.instructure.canvas.model.impl.SubmissionImpl;
import com.instructure.canvas.model.impl.SubmissionModelImpl;

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
 * The persistence implementation for the submission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubmissionPersistence
 * @see SubmissionUtil
 * @generated
 */
public class SubmissionPersistenceImpl extends BasePersistenceImpl<Submission>
	implements SubmissionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubmissionUtil} to access the submission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubmissionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SubmissionPersistenceImpl() {
		setModelClass(Submission.class);
	}

	/**
	 * Caches the submission in the entity cache if it is enabled.
	 *
	 * @param submission the submission
	 */
	@Override
	public void cacheResult(Submission submission) {
		EntityCacheUtil.putResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionImpl.class, submission.getPrimaryKey(), submission);

		submission.resetOriginalValues();
	}

	/**
	 * Caches the submissions in the entity cache if it is enabled.
	 *
	 * @param submissions the submissions
	 */
	@Override
	public void cacheResult(List<Submission> submissions) {
		for (Submission submission : submissions) {
			if (EntityCacheUtil.getResult(
						SubmissionModelImpl.ENTITY_CACHE_ENABLED,
						SubmissionImpl.class, submission.getPrimaryKey()) == null) {
				cacheResult(submission);
			}
			else {
				submission.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all submissions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubmissionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubmissionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the submission.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Submission submission) {
		EntityCacheUtil.removeResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionImpl.class, submission.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Submission> submissions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Submission submission : submissions) {
			EntityCacheUtil.removeResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
				SubmissionImpl.class, submission.getPrimaryKey());
		}
	}

	/**
	 * Creates a new submission with the primary key. Does not add the submission to the database.
	 *
	 * @param submissionId the primary key for the new submission
	 * @return the new submission
	 */
	@Override
	public Submission create(long submissionId) {
		Submission submission = new SubmissionImpl();

		submission.setNew(true);
		submission.setPrimaryKey(submissionId);

		return submission;
	}

	/**
	 * Removes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param submissionId the primary key of the submission
	 * @return the submission that was removed
	 * @throws com.instructure.canvas.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission remove(long submissionId)
		throws NoSuchSubmissionException, SystemException {
		return remove((Serializable)submissionId);
	}

	/**
	 * Removes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the submission
	 * @return the submission that was removed
	 * @throws com.instructure.canvas.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission remove(Serializable primaryKey)
		throws NoSuchSubmissionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Submission submission = (Submission)session.get(SubmissionImpl.class,
					primaryKey);

			if (submission == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubmissionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(submission);
		}
		catch (NoSuchSubmissionException nsee) {
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
	protected Submission removeImpl(Submission submission)
		throws SystemException {
		submission = toUnwrappedModel(submission);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(submission)) {
				submission = (Submission)session.get(SubmissionImpl.class,
						submission.getPrimaryKeyObj());
			}

			if (submission != null) {
				session.delete(submission);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (submission != null) {
			clearCache(submission);
		}

		return submission;
	}

	@Override
	public Submission updateImpl(
		com.instructure.canvas.model.Submission submission)
		throws SystemException {
		submission = toUnwrappedModel(submission);

		boolean isNew = submission.isNew();

		Session session = null;

		try {
			session = openSession();

			if (submission.isNew()) {
				session.save(submission);

				submission.setNew(false);
			}
			else {
				session.merge(submission);
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

		EntityCacheUtil.putResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionImpl.class, submission.getPrimaryKey(), submission);

		return submission;
	}

	protected Submission toUnwrappedModel(Submission submission) {
		if (submission instanceof SubmissionImpl) {
			return submission;
		}

		SubmissionImpl submissionImpl = new SubmissionImpl();

		submissionImpl.setNew(submission.isNew());
		submissionImpl.setPrimaryKey(submission.getPrimaryKey());

		submissionImpl.setSubmissionId(submission.getSubmissionId());
		submissionImpl.setAssignmentId(submission.getAssignmentId());
		submissionImpl.setCourseId(submission.getCourseId());
		submissionImpl.setAttempt(submission.getAttempt());
		submissionImpl.setGrade(submission.getGrade());
		submissionImpl.setHtmlUrl(submission.getHtmlUrl());
		submissionImpl.setScore(submission.getScore());
		submissionImpl.setSubmissionDate(submission.getSubmissionDate());
		submissionImpl.setGraderId(submission.getGraderId());
		submissionImpl.setUserId(submission.getUserId());

		return submissionImpl;
	}

	/**
	 * Returns the submission with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the submission
	 * @return the submission
	 * @throws com.instructure.canvas.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByPrimaryKey(primaryKey);

		if (submission == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubmissionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return submission;
	}

	/**
	 * Returns the submission with the primary key or throws a {@link com.instructure.canvas.NoSuchSubmissionException} if it could not be found.
	 *
	 * @param submissionId the primary key of the submission
	 * @return the submission
	 * @throws com.instructure.canvas.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByPrimaryKey(long submissionId)
		throws NoSuchSubmissionException, SystemException {
		return findByPrimaryKey((Serializable)submissionId);
	}

	/**
	 * Returns the submission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the submission
	 * @return the submission, or <code>null</code> if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Submission submission = (Submission)EntityCacheUtil.getResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
				SubmissionImpl.class, primaryKey);

		if (submission == _nullSubmission) {
			return null;
		}

		if (submission == null) {
			Session session = null;

			try {
				session = openSession();

				submission = (Submission)session.get(SubmissionImpl.class,
						primaryKey);

				if (submission != null) {
					cacheResult(submission);
				}
				else {
					EntityCacheUtil.putResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
						SubmissionImpl.class, primaryKey, _nullSubmission);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
					SubmissionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return submission;
	}

	/**
	 * Returns the submission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param submissionId the primary key of the submission
	 * @return the submission, or <code>null</code> if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByPrimaryKey(long submissionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)submissionId);
	}

	/**
	 * Returns all the submissions.
	 *
	 * @return the submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findAll(int start, int end,
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBMISSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBMISSION;

				if (pagination) {
					sql = sql.concat(SubmissionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the submissions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Submission submission : findAll()) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions.
	 *
	 * @return the number of submissions
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

				Query q = session.createQuery(_SQL_COUNT_SUBMISSION);

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
	 * Initializes the submission persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.instructure.canvas.model.Submission")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Submission>> listenersList = new ArrayList<ModelListener<Submission>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Submission>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubmissionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBMISSION = "SELECT submission FROM Submission submission";
	private static final String _SQL_COUNT_SUBMISSION = "SELECT COUNT(submission) FROM Submission submission";
	private static final String _ORDER_BY_ENTITY_ALIAS = "submission.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Submission exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubmissionPersistenceImpl.class);
	private static Submission _nullSubmission = new SubmissionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Submission> toCacheModel() {
				return _nullSubmissionCacheModel;
			}
		};

	private static CacheModel<Submission> _nullSubmissionCacheModel = new CacheModel<Submission>() {
			@Override
			public Submission toEntityModel() {
				return _nullSubmission;
			}
		};
}