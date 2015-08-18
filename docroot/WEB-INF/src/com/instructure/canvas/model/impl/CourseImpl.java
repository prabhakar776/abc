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

package com.instructure.canvas.model.impl;

import com.liferay.portal.kernel.util.StringBundler;

/**
 * The extended model implementation for the Course service. Represents a row in the &quot;CANVAS_Course&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.model.Course} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class CourseImpl extends CourseBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a course model instance should use the {@link com.instructure.canvas.model.Course} interface instead.
	 */
	public CourseImpl() {
	}
	
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{\"canvasId\":");
		sb.append(getCanvasId());
		sb.append(", \"name\":\"");
		sb.append(getName());
		sb.append("\", \"id\":");
		sb.append(getId());
		sb.append(", \"enrollments\":\"");
		sb.append(getEnrollments());
		sb.append("\", \"course_code\":\"");
		sb.append(getCourse_code());
		sb.append("\", \"sis_course_id\":\"");
		sb.append(getSis_course_id());
		sb.append("\", \"calendar\":\"");
		sb.append(getCalendar());
		sb.append("\", \"url\":\"");
		sb.append(getUrl());
		sb.append("\", \"netacadCoreOfferingId\":\"");
		sb.append(getNetacadCoreOfferingId());
		sb.append("\", \"accountId\":");
		sb.append(getAccountId());
		sb.append(", \"netacadCVLId\":\"");
		sb.append(getNetacadCVLId());
		sb.append("\", \"startDate\":");
		sb.append(getStartDate());
		sb.append(", \"endDate\":");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}
}