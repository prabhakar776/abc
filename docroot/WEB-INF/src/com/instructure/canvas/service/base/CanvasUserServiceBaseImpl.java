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

package com.instructure.canvas.service.base;

import com.instructure.canvas.model.CanvasUser;
import com.instructure.canvas.service.CanvasUserService;
import com.instructure.canvas.service.persistence.ActivityStreamPersistence;
import com.instructure.canvas.service.persistence.AssignmentPersistence;
import com.instructure.canvas.service.persistence.AwardPersistence;
import com.instructure.canvas.service.persistence.CanvasAccountPersistence;
import com.instructure.canvas.service.persistence.CanvasEnrollmentPersistence;
import com.instructure.canvas.service.persistence.CanvasUserPersistence;
import com.instructure.canvas.service.persistence.CertLetterQueuePersistence;
import com.instructure.canvas.service.persistence.CoursePersistence;
import com.instructure.canvas.service.persistence.EnrollmentSeatPersistence;
import com.instructure.canvas.service.persistence.SubmissionPersistence;
import com.instructure.canvas.service.persistence.SubmissionVersionPersistence;
import com.instructure.canvas.service.persistence.TodoPersistence;
import com.instructure.canvas.service.persistence.UserAwardPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the canvas user remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.instructure.canvas.service.impl.CanvasUserServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.impl.CanvasUserServiceImpl
 * @see com.instructure.canvas.service.CanvasUserServiceUtil
 * @generated
 */
public abstract class CanvasUserServiceBaseImpl extends BaseServiceImpl
	implements CanvasUserService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.instructure.canvas.service.CanvasUserServiceUtil} to access the canvas user remote service.
	 */

	/**
	 * Returns the activity stream local service.
	 *
	 * @return the activity stream local service
	 */
	public com.instructure.canvas.service.ActivityStreamLocalService getActivityStreamLocalService() {
		return activityStreamLocalService;
	}

	/**
	 * Sets the activity stream local service.
	 *
	 * @param activityStreamLocalService the activity stream local service
	 */
	public void setActivityStreamLocalService(
		com.instructure.canvas.service.ActivityStreamLocalService activityStreamLocalService) {
		this.activityStreamLocalService = activityStreamLocalService;
	}

	/**
	 * Returns the activity stream remote service.
	 *
	 * @return the activity stream remote service
	 */
	public com.instructure.canvas.service.ActivityStreamService getActivityStreamService() {
		return activityStreamService;
	}

	/**
	 * Sets the activity stream remote service.
	 *
	 * @param activityStreamService the activity stream remote service
	 */
	public void setActivityStreamService(
		com.instructure.canvas.service.ActivityStreamService activityStreamService) {
		this.activityStreamService = activityStreamService;
	}

	/**
	 * Returns the activity stream persistence.
	 *
	 * @return the activity stream persistence
	 */
	public ActivityStreamPersistence getActivityStreamPersistence() {
		return activityStreamPersistence;
	}

	/**
	 * Sets the activity stream persistence.
	 *
	 * @param activityStreamPersistence the activity stream persistence
	 */
	public void setActivityStreamPersistence(
		ActivityStreamPersistence activityStreamPersistence) {
		this.activityStreamPersistence = activityStreamPersistence;
	}

	/**
	 * Returns the assignment local service.
	 *
	 * @return the assignment local service
	 */
	public com.instructure.canvas.service.AssignmentLocalService getAssignmentLocalService() {
		return assignmentLocalService;
	}

	/**
	 * Sets the assignment local service.
	 *
	 * @param assignmentLocalService the assignment local service
	 */
	public void setAssignmentLocalService(
		com.instructure.canvas.service.AssignmentLocalService assignmentLocalService) {
		this.assignmentLocalService = assignmentLocalService;
	}

	/**
	 * Returns the assignment remote service.
	 *
	 * @return the assignment remote service
	 */
	public com.instructure.canvas.service.AssignmentService getAssignmentService() {
		return assignmentService;
	}

	/**
	 * Sets the assignment remote service.
	 *
	 * @param assignmentService the assignment remote service
	 */
	public void setAssignmentService(
		com.instructure.canvas.service.AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	/**
	 * Returns the assignment persistence.
	 *
	 * @return the assignment persistence
	 */
	public AssignmentPersistence getAssignmentPersistence() {
		return assignmentPersistence;
	}

	/**
	 * Sets the assignment persistence.
	 *
	 * @param assignmentPersistence the assignment persistence
	 */
	public void setAssignmentPersistence(
		AssignmentPersistence assignmentPersistence) {
		this.assignmentPersistence = assignmentPersistence;
	}

	/**
	 * Returns the award local service.
	 *
	 * @return the award local service
	 */
	public com.instructure.canvas.service.AwardLocalService getAwardLocalService() {
		return awardLocalService;
	}

	/**
	 * Sets the award local service.
	 *
	 * @param awardLocalService the award local service
	 */
	public void setAwardLocalService(
		com.instructure.canvas.service.AwardLocalService awardLocalService) {
		this.awardLocalService = awardLocalService;
	}

	/**
	 * Returns the award remote service.
	 *
	 * @return the award remote service
	 */
	public com.instructure.canvas.service.AwardService getAwardService() {
		return awardService;
	}

	/**
	 * Sets the award remote service.
	 *
	 * @param awardService the award remote service
	 */
	public void setAwardService(
		com.instructure.canvas.service.AwardService awardService) {
		this.awardService = awardService;
	}

	/**
	 * Returns the award persistence.
	 *
	 * @return the award persistence
	 */
	public AwardPersistence getAwardPersistence() {
		return awardPersistence;
	}

	/**
	 * Sets the award persistence.
	 *
	 * @param awardPersistence the award persistence
	 */
	public void setAwardPersistence(AwardPersistence awardPersistence) {
		this.awardPersistence = awardPersistence;
	}

	/**
	 * Returns the canvas account local service.
	 *
	 * @return the canvas account local service
	 */
	public com.instructure.canvas.service.CanvasAccountLocalService getCanvasAccountLocalService() {
		return canvasAccountLocalService;
	}

	/**
	 * Sets the canvas account local service.
	 *
	 * @param canvasAccountLocalService the canvas account local service
	 */
	public void setCanvasAccountLocalService(
		com.instructure.canvas.service.CanvasAccountLocalService canvasAccountLocalService) {
		this.canvasAccountLocalService = canvasAccountLocalService;
	}

	/**
	 * Returns the canvas account remote service.
	 *
	 * @return the canvas account remote service
	 */
	public com.instructure.canvas.service.CanvasAccountService getCanvasAccountService() {
		return canvasAccountService;
	}

	/**
	 * Sets the canvas account remote service.
	 *
	 * @param canvasAccountService the canvas account remote service
	 */
	public void setCanvasAccountService(
		com.instructure.canvas.service.CanvasAccountService canvasAccountService) {
		this.canvasAccountService = canvasAccountService;
	}

	/**
	 * Returns the canvas account persistence.
	 *
	 * @return the canvas account persistence
	 */
	public CanvasAccountPersistence getCanvasAccountPersistence() {
		return canvasAccountPersistence;
	}

	/**
	 * Sets the canvas account persistence.
	 *
	 * @param canvasAccountPersistence the canvas account persistence
	 */
	public void setCanvasAccountPersistence(
		CanvasAccountPersistence canvasAccountPersistence) {
		this.canvasAccountPersistence = canvasAccountPersistence;
	}

	/**
	 * Returns the canvas course copy local service.
	 *
	 * @return the canvas course copy local service
	 */
	public com.instructure.canvas.service.CanvasCourseCopyLocalService getCanvasCourseCopyLocalService() {
		return canvasCourseCopyLocalService;
	}

	/**
	 * Sets the canvas course copy local service.
	 *
	 * @param canvasCourseCopyLocalService the canvas course copy local service
	 */
	public void setCanvasCourseCopyLocalService(
		com.instructure.canvas.service.CanvasCourseCopyLocalService canvasCourseCopyLocalService) {
		this.canvasCourseCopyLocalService = canvasCourseCopyLocalService;
	}

	/**
	 * Returns the canvas enrollment local service.
	 *
	 * @return the canvas enrollment local service
	 */
	public com.instructure.canvas.service.CanvasEnrollmentLocalService getCanvasEnrollmentLocalService() {
		return canvasEnrollmentLocalService;
	}

	/**
	 * Sets the canvas enrollment local service.
	 *
	 * @param canvasEnrollmentLocalService the canvas enrollment local service
	 */
	public void setCanvasEnrollmentLocalService(
		com.instructure.canvas.service.CanvasEnrollmentLocalService canvasEnrollmentLocalService) {
		this.canvasEnrollmentLocalService = canvasEnrollmentLocalService;
	}

	/**
	 * Returns the canvas enrollment remote service.
	 *
	 * @return the canvas enrollment remote service
	 */
	public com.instructure.canvas.service.CanvasEnrollmentService getCanvasEnrollmentService() {
		return canvasEnrollmentService;
	}

	/**
	 * Sets the canvas enrollment remote service.
	 *
	 * @param canvasEnrollmentService the canvas enrollment remote service
	 */
	public void setCanvasEnrollmentService(
		com.instructure.canvas.service.CanvasEnrollmentService canvasEnrollmentService) {
		this.canvasEnrollmentService = canvasEnrollmentService;
	}

	/**
	 * Returns the canvas enrollment persistence.
	 *
	 * @return the canvas enrollment persistence
	 */
	public CanvasEnrollmentPersistence getCanvasEnrollmentPersistence() {
		return canvasEnrollmentPersistence;
	}

	/**
	 * Sets the canvas enrollment persistence.
	 *
	 * @param canvasEnrollmentPersistence the canvas enrollment persistence
	 */
	public void setCanvasEnrollmentPersistence(
		CanvasEnrollmentPersistence canvasEnrollmentPersistence) {
		this.canvasEnrollmentPersistence = canvasEnrollmentPersistence;
	}

	/**
	 * Returns the canvas user local service.
	 *
	 * @return the canvas user local service
	 */
	public com.instructure.canvas.service.CanvasUserLocalService getCanvasUserLocalService() {
		return canvasUserLocalService;
	}

	/**
	 * Sets the canvas user local service.
	 *
	 * @param canvasUserLocalService the canvas user local service
	 */
	public void setCanvasUserLocalService(
		com.instructure.canvas.service.CanvasUserLocalService canvasUserLocalService) {
		this.canvasUserLocalService = canvasUserLocalService;
	}

	/**
	 * Returns the canvas user remote service.
	 *
	 * @return the canvas user remote service
	 */
	public com.instructure.canvas.service.CanvasUserService getCanvasUserService() {
		return canvasUserService;
	}

	/**
	 * Sets the canvas user remote service.
	 *
	 * @param canvasUserService the canvas user remote service
	 */
	public void setCanvasUserService(
		com.instructure.canvas.service.CanvasUserService canvasUserService) {
		this.canvasUserService = canvasUserService;
	}

	/**
	 * Returns the canvas user persistence.
	 *
	 * @return the canvas user persistence
	 */
	public CanvasUserPersistence getCanvasUserPersistence() {
		return canvasUserPersistence;
	}

	/**
	 * Sets the canvas user persistence.
	 *
	 * @param canvasUserPersistence the canvas user persistence
	 */
	public void setCanvasUserPersistence(
		CanvasUserPersistence canvasUserPersistence) {
		this.canvasUserPersistence = canvasUserPersistence;
	}

	/**
	 * Returns the cert letter queue local service.
	 *
	 * @return the cert letter queue local service
	 */
	public com.instructure.canvas.service.CertLetterQueueLocalService getCertLetterQueueLocalService() {
		return certLetterQueueLocalService;
	}

	/**
	 * Sets the cert letter queue local service.
	 *
	 * @param certLetterQueueLocalService the cert letter queue local service
	 */
	public void setCertLetterQueueLocalService(
		com.instructure.canvas.service.CertLetterQueueLocalService certLetterQueueLocalService) {
		this.certLetterQueueLocalService = certLetterQueueLocalService;
	}

	/**
	 * Returns the cert letter queue remote service.
	 *
	 * @return the cert letter queue remote service
	 */
	public com.instructure.canvas.service.CertLetterQueueService getCertLetterQueueService() {
		return certLetterQueueService;
	}

	/**
	 * Sets the cert letter queue remote service.
	 *
	 * @param certLetterQueueService the cert letter queue remote service
	 */
	public void setCertLetterQueueService(
		com.instructure.canvas.service.CertLetterQueueService certLetterQueueService) {
		this.certLetterQueueService = certLetterQueueService;
	}

	/**
	 * Returns the cert letter queue persistence.
	 *
	 * @return the cert letter queue persistence
	 */
	public CertLetterQueuePersistence getCertLetterQueuePersistence() {
		return certLetterQueuePersistence;
	}

	/**
	 * Sets the cert letter queue persistence.
	 *
	 * @param certLetterQueuePersistence the cert letter queue persistence
	 */
	public void setCertLetterQueuePersistence(
		CertLetterQueuePersistence certLetterQueuePersistence) {
		this.certLetterQueuePersistence = certLetterQueuePersistence;
	}

	/**
	 * Returns the course local service.
	 *
	 * @return the course local service
	 */
	public com.instructure.canvas.service.CourseLocalService getCourseLocalService() {
		return courseLocalService;
	}

	/**
	 * Sets the course local service.
	 *
	 * @param courseLocalService the course local service
	 */
	public void setCourseLocalService(
		com.instructure.canvas.service.CourseLocalService courseLocalService) {
		this.courseLocalService = courseLocalService;
	}

	/**
	 * Returns the course remote service.
	 *
	 * @return the course remote service
	 */
	public com.instructure.canvas.service.CourseService getCourseService() {
		return courseService;
	}

	/**
	 * Sets the course remote service.
	 *
	 * @param courseService the course remote service
	 */
	public void setCourseService(
		com.instructure.canvas.service.CourseService courseService) {
		this.courseService = courseService;
	}

	/**
	 * Returns the course persistence.
	 *
	 * @return the course persistence
	 */
	public CoursePersistence getCoursePersistence() {
		return coursePersistence;
	}

	/**
	 * Sets the course persistence.
	 *
	 * @param coursePersistence the course persistence
	 */
	public void setCoursePersistence(CoursePersistence coursePersistence) {
		this.coursePersistence = coursePersistence;
	}

	/**
	 * Returns the enrollment seat local service.
	 *
	 * @return the enrollment seat local service
	 */
	public com.instructure.canvas.service.EnrollmentSeatLocalService getEnrollmentSeatLocalService() {
		return enrollmentSeatLocalService;
	}

	/**
	 * Sets the enrollment seat local service.
	 *
	 * @param enrollmentSeatLocalService the enrollment seat local service
	 */
	public void setEnrollmentSeatLocalService(
		com.instructure.canvas.service.EnrollmentSeatLocalService enrollmentSeatLocalService) {
		this.enrollmentSeatLocalService = enrollmentSeatLocalService;
	}

	/**
	 * Returns the enrollment seat remote service.
	 *
	 * @return the enrollment seat remote service
	 */
	public com.instructure.canvas.service.EnrollmentSeatService getEnrollmentSeatService() {
		return enrollmentSeatService;
	}

	/**
	 * Sets the enrollment seat remote service.
	 *
	 * @param enrollmentSeatService the enrollment seat remote service
	 */
	public void setEnrollmentSeatService(
		com.instructure.canvas.service.EnrollmentSeatService enrollmentSeatService) {
		this.enrollmentSeatService = enrollmentSeatService;
	}

	/**
	 * Returns the enrollment seat persistence.
	 *
	 * @return the enrollment seat persistence
	 */
	public EnrollmentSeatPersistence getEnrollmentSeatPersistence() {
		return enrollmentSeatPersistence;
	}

	/**
	 * Sets the enrollment seat persistence.
	 *
	 * @param enrollmentSeatPersistence the enrollment seat persistence
	 */
	public void setEnrollmentSeatPersistence(
		EnrollmentSeatPersistence enrollmentSeatPersistence) {
		this.enrollmentSeatPersistence = enrollmentSeatPersistence;
	}

	/**
	 * Returns the submission local service.
	 *
	 * @return the submission local service
	 */
	public com.instructure.canvas.service.SubmissionLocalService getSubmissionLocalService() {
		return submissionLocalService;
	}

	/**
	 * Sets the submission local service.
	 *
	 * @param submissionLocalService the submission local service
	 */
	public void setSubmissionLocalService(
		com.instructure.canvas.service.SubmissionLocalService submissionLocalService) {
		this.submissionLocalService = submissionLocalService;
	}

	/**
	 * Returns the submission remote service.
	 *
	 * @return the submission remote service
	 */
	public com.instructure.canvas.service.SubmissionService getSubmissionService() {
		return submissionService;
	}

	/**
	 * Sets the submission remote service.
	 *
	 * @param submissionService the submission remote service
	 */
	public void setSubmissionService(
		com.instructure.canvas.service.SubmissionService submissionService) {
		this.submissionService = submissionService;
	}

	/**
	 * Returns the submission persistence.
	 *
	 * @return the submission persistence
	 */
	public SubmissionPersistence getSubmissionPersistence() {
		return submissionPersistence;
	}

	/**
	 * Sets the submission persistence.
	 *
	 * @param submissionPersistence the submission persistence
	 */
	public void setSubmissionPersistence(
		SubmissionPersistence submissionPersistence) {
		this.submissionPersistence = submissionPersistence;
	}

	/**
	 * Returns the submission version local service.
	 *
	 * @return the submission version local service
	 */
	public com.instructure.canvas.service.SubmissionVersionLocalService getSubmissionVersionLocalService() {
		return submissionVersionLocalService;
	}

	/**
	 * Sets the submission version local service.
	 *
	 * @param submissionVersionLocalService the submission version local service
	 */
	public void setSubmissionVersionLocalService(
		com.instructure.canvas.service.SubmissionVersionLocalService submissionVersionLocalService) {
		this.submissionVersionLocalService = submissionVersionLocalService;
	}

	/**
	 * Returns the submission version remote service.
	 *
	 * @return the submission version remote service
	 */
	public com.instructure.canvas.service.SubmissionVersionService getSubmissionVersionService() {
		return submissionVersionService;
	}

	/**
	 * Sets the submission version remote service.
	 *
	 * @param submissionVersionService the submission version remote service
	 */
	public void setSubmissionVersionService(
		com.instructure.canvas.service.SubmissionVersionService submissionVersionService) {
		this.submissionVersionService = submissionVersionService;
	}

	/**
	 * Returns the submission version persistence.
	 *
	 * @return the submission version persistence
	 */
	public SubmissionVersionPersistence getSubmissionVersionPersistence() {
		return submissionVersionPersistence;
	}

	/**
	 * Sets the submission version persistence.
	 *
	 * @param submissionVersionPersistence the submission version persistence
	 */
	public void setSubmissionVersionPersistence(
		SubmissionVersionPersistence submissionVersionPersistence) {
		this.submissionVersionPersistence = submissionVersionPersistence;
	}

	/**
	 * Returns the todo local service.
	 *
	 * @return the todo local service
	 */
	public com.instructure.canvas.service.TodoLocalService getTodoLocalService() {
		return todoLocalService;
	}

	/**
	 * Sets the todo local service.
	 *
	 * @param todoLocalService the todo local service
	 */
	public void setTodoLocalService(
		com.instructure.canvas.service.TodoLocalService todoLocalService) {
		this.todoLocalService = todoLocalService;
	}

	/**
	 * Returns the todo remote service.
	 *
	 * @return the todo remote service
	 */
	public com.instructure.canvas.service.TodoService getTodoService() {
		return todoService;
	}

	/**
	 * Sets the todo remote service.
	 *
	 * @param todoService the todo remote service
	 */
	public void setTodoService(
		com.instructure.canvas.service.TodoService todoService) {
		this.todoService = todoService;
	}

	/**
	 * Returns the todo persistence.
	 *
	 * @return the todo persistence
	 */
	public TodoPersistence getTodoPersistence() {
		return todoPersistence;
	}

	/**
	 * Sets the todo persistence.
	 *
	 * @param todoPersistence the todo persistence
	 */
	public void setTodoPersistence(TodoPersistence todoPersistence) {
		this.todoPersistence = todoPersistence;
	}

	/**
	 * Returns the user award local service.
	 *
	 * @return the user award local service
	 */
	public com.instructure.canvas.service.UserAwardLocalService getUserAwardLocalService() {
		return userAwardLocalService;
	}

	/**
	 * Sets the user award local service.
	 *
	 * @param userAwardLocalService the user award local service
	 */
	public void setUserAwardLocalService(
		com.instructure.canvas.service.UserAwardLocalService userAwardLocalService) {
		this.userAwardLocalService = userAwardLocalService;
	}

	/**
	 * Returns the user award remote service.
	 *
	 * @return the user award remote service
	 */
	public com.instructure.canvas.service.UserAwardService getUserAwardService() {
		return userAwardService;
	}

	/**
	 * Sets the user award remote service.
	 *
	 * @param userAwardService the user award remote service
	 */
	public void setUserAwardService(
		com.instructure.canvas.service.UserAwardService userAwardService) {
		this.userAwardService = userAwardService;
	}

	/**
	 * Returns the user award persistence.
	 *
	 * @return the user award persistence
	 */
	public UserAwardPersistence getUserAwardPersistence() {
		return userAwardPersistence;
	}

	/**
	 * Sets the user award persistence.
	 *
	 * @param userAwardPersistence the user award persistence
	 */
	public void setUserAwardPersistence(
		UserAwardPersistence userAwardPersistence) {
		this.userAwardPersistence = userAwardPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return CanvasUser.class;
	}

	protected String getModelClassName() {
		return CanvasUser.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = canvasUserPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.instructure.canvas.service.ActivityStreamLocalService.class)
	protected com.instructure.canvas.service.ActivityStreamLocalService activityStreamLocalService;
	@BeanReference(type = com.instructure.canvas.service.ActivityStreamService.class)
	protected com.instructure.canvas.service.ActivityStreamService activityStreamService;
	@BeanReference(type = ActivityStreamPersistence.class)
	protected ActivityStreamPersistence activityStreamPersistence;
	@BeanReference(type = com.instructure.canvas.service.AssignmentLocalService.class)
	protected com.instructure.canvas.service.AssignmentLocalService assignmentLocalService;
	@BeanReference(type = com.instructure.canvas.service.AssignmentService.class)
	protected com.instructure.canvas.service.AssignmentService assignmentService;
	@BeanReference(type = AssignmentPersistence.class)
	protected AssignmentPersistence assignmentPersistence;
	@BeanReference(type = com.instructure.canvas.service.AwardLocalService.class)
	protected com.instructure.canvas.service.AwardLocalService awardLocalService;
	@BeanReference(type = com.instructure.canvas.service.AwardService.class)
	protected com.instructure.canvas.service.AwardService awardService;
	@BeanReference(type = AwardPersistence.class)
	protected AwardPersistence awardPersistence;
	@BeanReference(type = com.instructure.canvas.service.CanvasAccountLocalService.class)
	protected com.instructure.canvas.service.CanvasAccountLocalService canvasAccountLocalService;
	@BeanReference(type = com.instructure.canvas.service.CanvasAccountService.class)
	protected com.instructure.canvas.service.CanvasAccountService canvasAccountService;
	@BeanReference(type = CanvasAccountPersistence.class)
	protected CanvasAccountPersistence canvasAccountPersistence;
	@BeanReference(type = com.instructure.canvas.service.CanvasCourseCopyLocalService.class)
	protected com.instructure.canvas.service.CanvasCourseCopyLocalService canvasCourseCopyLocalService;
	@BeanReference(type = com.instructure.canvas.service.CanvasEnrollmentLocalService.class)
	protected com.instructure.canvas.service.CanvasEnrollmentLocalService canvasEnrollmentLocalService;
	@BeanReference(type = com.instructure.canvas.service.CanvasEnrollmentService.class)
	protected com.instructure.canvas.service.CanvasEnrollmentService canvasEnrollmentService;
	@BeanReference(type = CanvasEnrollmentPersistence.class)
	protected CanvasEnrollmentPersistence canvasEnrollmentPersistence;
	@BeanReference(type = com.instructure.canvas.service.CanvasUserLocalService.class)
	protected com.instructure.canvas.service.CanvasUserLocalService canvasUserLocalService;
	@BeanReference(type = com.instructure.canvas.service.CanvasUserService.class)
	protected com.instructure.canvas.service.CanvasUserService canvasUserService;
	@BeanReference(type = CanvasUserPersistence.class)
	protected CanvasUserPersistence canvasUserPersistence;
	@BeanReference(type = com.instructure.canvas.service.CertLetterQueueLocalService.class)
	protected com.instructure.canvas.service.CertLetterQueueLocalService certLetterQueueLocalService;
	@BeanReference(type = com.instructure.canvas.service.CertLetterQueueService.class)
	protected com.instructure.canvas.service.CertLetterQueueService certLetterQueueService;
	@BeanReference(type = CertLetterQueuePersistence.class)
	protected CertLetterQueuePersistence certLetterQueuePersistence;
	@BeanReference(type = com.instructure.canvas.service.CourseLocalService.class)
	protected com.instructure.canvas.service.CourseLocalService courseLocalService;
	@BeanReference(type = com.instructure.canvas.service.CourseService.class)
	protected com.instructure.canvas.service.CourseService courseService;
	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = com.instructure.canvas.service.EnrollmentSeatLocalService.class)
	protected com.instructure.canvas.service.EnrollmentSeatLocalService enrollmentSeatLocalService;
	@BeanReference(type = com.instructure.canvas.service.EnrollmentSeatService.class)
	protected com.instructure.canvas.service.EnrollmentSeatService enrollmentSeatService;
	@BeanReference(type = EnrollmentSeatPersistence.class)
	protected EnrollmentSeatPersistence enrollmentSeatPersistence;
	@BeanReference(type = com.instructure.canvas.service.SubmissionLocalService.class)
	protected com.instructure.canvas.service.SubmissionLocalService submissionLocalService;
	@BeanReference(type = com.instructure.canvas.service.SubmissionService.class)
	protected com.instructure.canvas.service.SubmissionService submissionService;
	@BeanReference(type = SubmissionPersistence.class)
	protected SubmissionPersistence submissionPersistence;
	@BeanReference(type = com.instructure.canvas.service.SubmissionVersionLocalService.class)
	protected com.instructure.canvas.service.SubmissionVersionLocalService submissionVersionLocalService;
	@BeanReference(type = com.instructure.canvas.service.SubmissionVersionService.class)
	protected com.instructure.canvas.service.SubmissionVersionService submissionVersionService;
	@BeanReference(type = SubmissionVersionPersistence.class)
	protected SubmissionVersionPersistence submissionVersionPersistence;
	@BeanReference(type = com.instructure.canvas.service.TodoLocalService.class)
	protected com.instructure.canvas.service.TodoLocalService todoLocalService;
	@BeanReference(type = com.instructure.canvas.service.TodoService.class)
	protected com.instructure.canvas.service.TodoService todoService;
	@BeanReference(type = TodoPersistence.class)
	protected TodoPersistence todoPersistence;
	@BeanReference(type = com.instructure.canvas.service.UserAwardLocalService.class)
	protected com.instructure.canvas.service.UserAwardLocalService userAwardLocalService;
	@BeanReference(type = com.instructure.canvas.service.UserAwardService.class)
	protected com.instructure.canvas.service.UserAwardService userAwardService;
	@BeanReference(type = UserAwardPersistence.class)
	protected UserAwardPersistence userAwardPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private CanvasUserServiceClpInvoker _clpInvoker = new CanvasUserServiceClpInvoker();
}