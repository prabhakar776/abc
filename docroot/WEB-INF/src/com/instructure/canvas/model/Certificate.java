package com.instructure.canvas.model;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Created with IntelliJ IDEA.
 * User: bswaim
 * Date: 11/16/12
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Certificate extends Merit {

	public Certificate(String academyName, String date, String instructorName, String location, String studentName) {
		this.academyName = academyName;
		this.date = date;
		this.instructorName = instructorName;
		this.location = location;
		this.studentName = studentName;
	}

	public String getAcademyName() {
		return academyName;
	}

	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private String academyName;
	private String date;
	private String instructorName;
	private String location;
	private String studentName;
}
