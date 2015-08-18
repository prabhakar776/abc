package com.instructure.canvas.service.impl;

import com.cisco.utility.constants.CiscoConstants;
import com.instructure.canvas.model.Assignment;
import com.instructure.canvas.model.impl.AssignmentImpl;
import com.instructure.canvas.service.base.AssignmentLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasApiUtils;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the assignment local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.instructure.canvas.service.AssignmentLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.AssignmentLocalServiceBaseImpl
 * @see com.instructure.canvas.service.AssignmentLocalServiceUtil
 */
public class AssignmentLocalServiceImpl extends AssignmentLocalServiceBaseImpl {

	public List<Assignment> getAssignments(long courseId) {
		List<Assignment> assignments = new ArrayList<Assignment>();

        String apiUrl = "/courses/" + courseId + "/assignments";

		try {
			JSONArray entities = CanvasApiUtils.getAllPagesOfCanvasAPI(apiUrl);

			for (int i = 0; i < entities.length(); i++) {
				JSONObject entity = entities.getJSONObject(i);

				Assignment assignment = new AssignmentImpl();
				
				assignment.setAssignmentId(Long.parseLong(entity.getString("id")));
				assignment.setName(entity.getString("name"));
				
				assignments.add(assignment);
			}
		} catch (IOException e) {
			if (e instanceof FileNotFoundException) {
				log.error("Unable to find assignments for Course " + courseId + " in Canvas");
			}
			log.error(e);
		}

		return assignments;
	}
	
	public Assignment getCompletionAssignment(long courseId) {
        String apiUrl = "/courses/" + courseId + "/assignments";

		try {
			JSONArray entities = CanvasApiUtils.getAllPagesOfCanvasAPI(apiUrl);

			for (int i = 0; i < entities.length(); i++) {
				JSONObject entity = entities.getJSONObject(i);

				String name = entity.getString("name");

				if (name.equalsIgnoreCase(CiscoConstants.COURSE_COMPLETION) || name.startsWith(CiscoConstants.COURSE_COMPLETION_PREFIX)) {
					
					Assignment assignment = new AssignmentImpl();
					
					assignment.setAssignmentId(Long.parseLong(entity.getString("id")));
					assignment.setName(name);
					
					return assignment;
				}
			}
		} catch (IOException e) {
			if (e instanceof FileNotFoundException) {
				log.error("Unable to find assignments for Course " + courseId + " in Canvas");
			}
			log.error(e);
		}

		return null;
	}
	
	public List<Assignment> getAssignmentsForVoucherEligibility(String courseId) {
		List<Assignment> assignments = new ArrayList<Assignment>();

        String apiUrl = "/courses/" + courseId + "/assignments";

		try {
			JSONArray entities = CanvasApiUtils.getAllPagesOfCanvasAPI(apiUrl);

			for (int i = 0; i < entities.length(); i++) {
				JSONObject entity = entities.getJSONObject(i);

				Assignment assignment = new AssignmentImpl();

				boolean addAssignment = false;
				String name = entity.getString("name");

				if (name.equalsIgnoreCase(CiscoConstants.FINAL_EXAM) || name.startsWith(CiscoConstants.FINAL_EXAM_PREFIX)) {
					JSONArray submissionTypes = entity.getJSONArray("submission_types");

					for (int j = 0; j < submissionTypes.length(); j++) {
						String submissionType = submissionTypes.getString(j);

						if (submissionType.equalsIgnoreCase("external_tool")) {
							addAssignment = true;
							break;
						}
					}
				
				} else if (name.equalsIgnoreCase(CiscoConstants.COURSE_COMPLETION) || name.startsWith(CiscoConstants.COURSE_COMPLETION_PREFIX)) {
					addAssignment = true;
				}

				if (addAssignment) {
					assignment.setAssignmentId(Long.parseLong(entity.getString("id")));
					assignment.setName(name);

					assignments.add(assignment);
				}
			}

		} catch (IOException e) {
			if (e instanceof FileNotFoundException) {
				log.error("Unable to find assignments for Course " + courseId + " in Canvas");
			}
			log.error(e);
		}

		return assignments;
	}
	
	private static Log log = LogFactoryUtil.getLog(AssignmentLocalServiceImpl.class);
}