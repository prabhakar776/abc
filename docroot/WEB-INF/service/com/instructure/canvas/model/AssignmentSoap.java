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

package com.instructure.canvas.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.instructure.canvas.service.http.AssignmentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.http.AssignmentServiceSoap
 * @generated
 */
public class AssignmentSoap implements Serializable {
	public static AssignmentSoap toSoapModel(Assignment model) {
		AssignmentSoap soapModel = new AssignmentSoap();

		soapModel.setAssignmentId(model.getAssignmentId());
		soapModel.setName(model.getName());
		soapModel.setSubmissionType(model.getSubmissionType());

		return soapModel;
	}

	public static AssignmentSoap[] toSoapModels(Assignment[] models) {
		AssignmentSoap[] soapModels = new AssignmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AssignmentSoap[][] toSoapModels(Assignment[][] models) {
		AssignmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AssignmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AssignmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AssignmentSoap[] toSoapModels(List<Assignment> models) {
		List<AssignmentSoap> soapModels = new ArrayList<AssignmentSoap>(models.size());

		for (Assignment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AssignmentSoap[soapModels.size()]);
	}

	public AssignmentSoap() {
	}

	public long getPrimaryKey() {
		return _assignmentId;
	}

	public void setPrimaryKey(long pk) {
		setAssignmentId(pk);
	}

	public long getAssignmentId() {
		return _assignmentId;
	}

	public void setAssignmentId(long assignmentId) {
		_assignmentId = assignmentId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSubmissionType() {
		return _submissionType;
	}

	public void setSubmissionType(String submissionType) {
		_submissionType = submissionType;
	}

	private long _assignmentId;
	private String _name;
	private String _submissionType;
}