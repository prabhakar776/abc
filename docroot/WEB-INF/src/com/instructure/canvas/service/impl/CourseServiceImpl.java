/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.instructure.canvas.service.impl;

import java.io.IOException;
import java.util.List;

import com.instructure.canvas.model.Course;
import com.instructure.canvas.service.base.CourseServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.security.ac.AccessControlled;

/**
 * The implementation of the course remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.CourseService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.CourseServiceBaseImpl
 * @see com.instructure.canvas.service.CourseServiceUtil
 */
public class CourseServiceImpl extends CourseServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.CourseServiceUtil} to access the course remote service.
	 */
	
	@AccessControlled(guestAccessEnabled = false)
	public String createCourse(String courseId, String shortName, String longName, String accountId,
			String termId, String status, String netacadCoreOfferingId) throws IOException, SystemException {
		return courseLocalService.createCourse(courseId, shortName, longName, accountId, termId, status, netacadCoreOfferingId);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public String createCourse(
			String courseId, String shortName, String longName, String accountId, String termId,
			String status, String netacadCoreOfferingId, int startYear,
			int startMonth, int startDay, int concludeYear, int concludeMonth,
			int concludeDay, String timeZoneId, boolean enforceDates)
			throws IOException, SystemException {
		return courseLocalService.createCourse(courseId, shortName, longName, accountId, termId, status, netacadCoreOfferingId, startYear, startMonth, startDay, concludeYear, concludeMonth, concludeDay, timeZoneId, enforceDates);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public Course getCourseByOID(String oid) throws SystemException {
		return courseLocalService.getCourseByOID(oid);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public Course getCourseById(long id) throws SystemException {
		return courseLocalService.getCourseById(id);	
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public List<Course> getCoursesByCVLId(List<String> cvlIds) throws SystemException {
		return courseLocalService.getCoursesByCVLId(cvlIds);
	}
	
	@AccessControlled(guestAccessEnabled = false)
	public void updateCourse(
			String courseId, String shortName, String courseCode, 
			int startDay, int startMonth, int startYear,
			int concludeDay, int concludeMonth, int concludeYear, String timeZoneId) 
			throws SystemException {
		courseLocalService.updateCourse(courseId, shortName, courseCode, startDay, startMonth, startYear, concludeDay, concludeMonth, concludeYear, timeZoneId);
	}
	
}