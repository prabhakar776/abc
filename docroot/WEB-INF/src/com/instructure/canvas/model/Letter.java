package com.instructure.canvas.model;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Created with IntelliJ IDEA.
 * User: gabriel
 * Date: 11/16/12
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Letter extends Merit {

	public Letter(String date, String studentName) {
		this.date = date;
		this.studentName = studentName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private String date;
	private String studentName;

	private static Log _log = LogFactoryUtil.getLog(Letter.class);
}