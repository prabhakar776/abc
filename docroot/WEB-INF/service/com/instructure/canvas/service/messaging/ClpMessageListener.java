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

package com.instructure.canvas.service.messaging;

import com.instructure.canvas.service.ActivityStreamLocalServiceUtil;
import com.instructure.canvas.service.ActivityStreamServiceUtil;
import com.instructure.canvas.service.AssignmentLocalServiceUtil;
import com.instructure.canvas.service.AssignmentServiceUtil;
import com.instructure.canvas.service.AwardLocalServiceUtil;
import com.instructure.canvas.service.AwardServiceUtil;
import com.instructure.canvas.service.CanvasAccountLocalServiceUtil;
import com.instructure.canvas.service.CanvasAccountServiceUtil;
import com.instructure.canvas.service.CanvasCourseCopyLocalServiceUtil;
import com.instructure.canvas.service.CanvasEnrollmentLocalServiceUtil;
import com.instructure.canvas.service.CanvasEnrollmentServiceUtil;
import com.instructure.canvas.service.CanvasUserLocalServiceUtil;
import com.instructure.canvas.service.CanvasUserServiceUtil;
import com.instructure.canvas.service.CertLetterQueueLocalServiceUtil;
import com.instructure.canvas.service.CertLetterQueueServiceUtil;
import com.instructure.canvas.service.ClpSerializer;
import com.instructure.canvas.service.CourseLocalServiceUtil;
import com.instructure.canvas.service.CourseServiceUtil;
import com.instructure.canvas.service.EnrollmentSeatLocalServiceUtil;
import com.instructure.canvas.service.EnrollmentSeatServiceUtil;
import com.instructure.canvas.service.SubmissionLocalServiceUtil;
import com.instructure.canvas.service.SubmissionServiceUtil;
import com.instructure.canvas.service.SubmissionVersionLocalServiceUtil;
import com.instructure.canvas.service.SubmissionVersionServiceUtil;
import com.instructure.canvas.service.TodoLocalServiceUtil;
import com.instructure.canvas.service.TodoServiceUtil;
import com.instructure.canvas.service.UserAwardLocalServiceUtil;
import com.instructure.canvas.service.UserAwardServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ActivityStreamLocalServiceUtil.clearService();

			ActivityStreamServiceUtil.clearService();
			AssignmentLocalServiceUtil.clearService();

			AssignmentServiceUtil.clearService();
			AwardLocalServiceUtil.clearService();

			AwardServiceUtil.clearService();
			CanvasAccountLocalServiceUtil.clearService();

			CanvasAccountServiceUtil.clearService();
			CanvasCourseCopyLocalServiceUtil.clearService();

			CanvasEnrollmentLocalServiceUtil.clearService();

			CanvasEnrollmentServiceUtil.clearService();
			CanvasUserLocalServiceUtil.clearService();

			CanvasUserServiceUtil.clearService();
			CertLetterQueueLocalServiceUtil.clearService();

			CertLetterQueueServiceUtil.clearService();
			CourseLocalServiceUtil.clearService();

			CourseServiceUtil.clearService();
			EnrollmentSeatLocalServiceUtil.clearService();

			EnrollmentSeatServiceUtil.clearService();
			SubmissionLocalServiceUtil.clearService();

			SubmissionServiceUtil.clearService();
			SubmissionVersionLocalServiceUtil.clearService();

			SubmissionVersionServiceUtil.clearService();
			TodoLocalServiceUtil.clearService();

			TodoServiceUtil.clearService();
			UserAwardLocalServiceUtil.clearService();

			UserAwardServiceUtil.clearService();
		}
	}
}