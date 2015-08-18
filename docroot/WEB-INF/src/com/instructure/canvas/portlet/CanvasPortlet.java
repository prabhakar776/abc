package com.instructure.canvas.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;

import com.cisco.utility.constants.CiscoConstants;
import com.cisco.utility.service.UtilityLocalServiceUtil;
import com.instructure.canvas.model.Award;
import com.instructure.canvas.model.Course;
import com.instructure.canvas.service.AwardLocalServiceUtil;
import com.instructure.canvas.service.CourseLocalServiceUtil;
import com.instructure.canvas.util.CanvasApiUtils;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.salesforce.model.SalesforceAccount;
import com.liferay.salesforce.service.SalesforceAccountLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

public class CanvasPortlet extends MVCPortlet {

	public void getCertificate(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException {
		Long canvasUserId = ParamUtil.getLong(actionRequest, "canvasUserId");
		Long courseId = ParamUtil.getLong(actionRequest, "courseId");

		try {
			User instructor = PortalUtil.getUser(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long studentId = UtilityLocalServiceUtil.getEntityId(
					companyId, User.class.getName(),
					CiscoConstants.EXPANDO_CANVAS_USER_ID,
					String.valueOf(canvasUserId));

			User student = UserLocalServiceUtil.getUser(studentId);

			Course course = CourseLocalServiceUtil.getCourseById(courseId);

			String courseAccountId = String.valueOf(course.getAccountId());

			List<SalesforceAccount> salesforceAccounts = SalesforceAccountLocalServiceUtil.getAccountsByInstutionIdAndRecordType(courseAccountId, PropsUtil.get("account.recordtype.id"));

			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, student.getLocale());

			String today = dateFormat.format(new Date());
			Map<String, String> variables = new HashMap<String, String>();
			variables.put("instructor-name", instructor.getFullName());
			variables.put("student-name", student.getFullName());
			variables.put("course-title", course.getName());
			variables.put("academy-name", salesforceAccounts.get(0).getName());
			variables.put("location", salesforceAccounts.get(0).getBillingCountry());
			variables.put("date", today);

			File certificate = AwardLocalServiceUtil.getCertificate(
					canvasUserId, courseId, variables, student.getLanguageId(),
					themeDisplay);

			if (certificate == null) {
				throw new PortalException("Error getting the certificate for " +
					student.getEmailAddress() + " for course " + course.getName());
			}

			HttpServletRequest request =
					PortalUtil.getHttpServletRequest(actionRequest);

			HttpServletResponse response =
					PortalUtil.getHttpServletResponse(actionResponse);

			InputStream is = new FileInputStream(certificate);

			String contentType = MimeTypesUtil
					.getContentType(certificate.getName());

			ServletResponseUtil.sendFile(
					request, response, certificate.getName(), is, contentType);
		}
		catch (PortalException e) {
			_log.error(e);

			SessionErrors.add(actionRequest, "your-request-failed-to-complete");
		}
		catch (SystemException e) {
			_log.error(e);
			
			SessionErrors.add(actionRequest, "your-request-failed-to-complete");
		}
	}

	@ProcessAction(name = "getLetter")
	public void getLetter(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException {
		Long canvasUserId = ParamUtil.getLong(actionRequest, "canvasUserId");
		Long courseId = ParamUtil.getLong(actionRequest, "courseId");

		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long studentId = UtilityLocalServiceUtil.getEntityId(
					companyId, User.class.getName(),
					CiscoConstants.EXPANDO_CANVAS_USER_ID,
					String.valueOf(canvasUserId));

			User student = UserLocalServiceUtil.getUser(studentId);

			DateFormat dateFormat = DateFormat.getDateInstance(
					DateFormat.MEDIUM, student.getLocale());

			String today = dateFormat.format(new Date());

			Map<String, String> variables = new HashMap<String, String>();
			variables.put("student-name", student.getFullName());
			variables.put("date", today);

			File certificate = AwardLocalServiceUtil.getLetter(
					canvasUserId, courseId, variables, student.getLanguageId(),
					themeDisplay);

			if (certificate == null) {
				throw new PortalException("Error getting the certificate for " +
					student.getEmailAddress());
			}
			
			HttpServletRequest request =
					PortalUtil.getHttpServletRequest(actionRequest);

			HttpServletResponse response =
					PortalUtil.getHttpServletResponse(actionResponse);

			InputStream is = new FileInputStream(certificate);

			String contentType = MimeTypesUtil.getContentType(certificate.getName());

			ServletResponseUtil.sendFile(
					request, response, certificate.getName(), is, contentType);
		}
		catch (PortalException e) {
			_log.error(e);

			SessionErrors.add(actionRequest, "your-request-failed-to-complete");
		}
		catch (SystemException e) {
			_log.error(e);
			
			SessionErrors.add(actionRequest, "your-request-failed-to-complete");
		}
	}

	@ProcessAction(name = "deleteCVL")
	public void deleteCVL(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException, PortalException {

		long awardId = ParamUtil.getLong(actionRequest, "awardId");

		Award award = AwardLocalServiceUtil.deleteAward(awardId);
		
		//REST call to MongoDB
		
		String deleteURL = REST_HOST.concat(DELETE_AWARD_URL).concat(String.valueOf(awardId));
		_log.info("REST url : "+deleteURL);
		
		int status = 0;
		try {
			status = CanvasApiUtils.deleteFromMongoDB(deleteURL, String.valueOf(awardId));
		} catch (ClientProtocolException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		}
		if(status == 200){
			_log.info("Delete successful : "+awardId);
		}
				
	}

	@ProcessAction(name = "editCVL")
	public void editCVL(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, SystemException, PortalException {

		long awardId = ParamUtil.getLong(actionRequest, "awardId");
		String cvlId = ParamUtil.getString(actionRequest, "netacadCVLId");
		String cvlName = ParamUtil.getString(actionRequest, "cvlName");
		double score = ParamUtil.getDouble(actionRequest, "score");
		long certificateArticleId = ParamUtil.getLong(actionRequest, "certificateArticleId");
		long letterArticleId = ParamUtil.getLong(actionRequest, "letterArticleId");

		List<String> errors = new ArrayList<String>();

		cvlId = AwardLocalServiceUtil.generate18CharId(cvlId);

		if (!validate(cvlId, score, errors)) {
			for (String error : errors) {
				SessionErrors.add(actionRequest, error);
			}

			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			actionResponse.setRenderParameter("mvcPath", "/html/edit_cvl.jsp");

			return;
		}

		//edit existing
		if (Validator.isNotNull(awardId)) {
			try {
				Award award = AwardLocalServiceUtil.getAward(awardId);
	
				if (!cvlId.equals(award.getCvlId()) ) {
					Award temp = AwardLocalServiceUtil.getAwardByCVLId(cvlId);
					
					if (temp != null) {
						if (temp.getAwardId() != award.getAwardId()) {
							SessionErrors.add(actionRequest, "duplicate-cvlId");
							
							PortalUtil.copyRequestParameters(actionRequest, actionResponse);

							actionResponse.setRenderParameter("mvcPath", "/html/edit_cvl.jsp");
							
							return;
						}
					}
				}
				
				if (!cvlName.equals(award.getCvlName()) ) {
					Award temp = AwardLocalServiceUtil.getAwardByCVLName(URLEncoder.encode(cvlName, "UTF-8")+"#"+cvlId);
					if (temp != null) {
						if (temp.getAwardId() != award.getAwardId()) {
							SessionErrors.add(actionRequest, "duplicate-cvlName");
							
							PortalUtil.copyRequestParameters(actionRequest, actionResponse);

							actionResponse.setRenderParameter("mvcPath", "/html/edit_cvl.jsp");
							
							return;
						}
					}
				}
				
				award.setCvlId(cvlId);
				award.setCvlName(cvlName);
				award.setScore(score);
				award.setCertificateArticleId(certificateArticleId);
				award.setLetterArticleId(letterArticleId);
				award.setModifiedDate(new Date());

				AwardLocalServiceUtil.updateAward(award);
				
				
				
				//REST call to MongoDB
				
				// get the courseID from cvlID
				String courseId = null;
				List<String> cvlIds = new ArrayList<String>();
				cvlIds.add(award.getCvlId());
				
				String params = StringUtils.join(cvlIds, "&cvlId=");
				String url = REST_HOST.concat(COURSE_BY_CVL_IDS_URL).concat(StringPool.QUESTION).concat("cvlId=").concat(params);
				_log.info("REST url : "+url);
				
				JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
				JSONArray jsonArray = obj.getJSONArray("entities");
				
				if(jsonArray != null){
					courseId = jsonArray.getJSONObject(0).getString("id");
				}else{
					_log.info("Couldn't retrieve Courses from MongoDB");
				}		
				
				
				String updateURL = REST_HOST.concat(CREATE_UPDATE_AWARD_URL.replace("courseid", courseId));
				_log.info("REST url : "+updateURL);
				

				int statusCode = CanvasApiUtils.postDataToMongoDB(updateURL, award);
				if(statusCode != 200){
					//error from server, then throw SystemException - Dual write transaction mgmt.
					_log.info("TRANSECTION FAILED to create Award ");
					throw new SystemException();
				}else{
					_log.info("TRANSECTION SUCCEED to create Award ");
				}
	
				sendRedirect(actionRequest, actionResponse);
				
				return;
			}catch (ConnectException e) {
				//if REST server is down, then throw SystemException - Dual write transaction mgmt.
				throw new SystemException();
			} catch (PortalException e) {
				_log.error("Error updating new CVL " + cvlId + " with letters and certificates", e);
			}
		}

		if (AwardLocalServiceUtil.getAwardByCVLId(cvlId) != null) {
			SessionErrors.add(actionRequest, "duplicate-cvlId");
			
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			actionResponse.setRenderParameter("mvcPath", "/html/edit_cvl.jsp");
		}
		else if (AwardLocalServiceUtil.getAwardByCVLName(cvlName+"#"+cvlId) != null) {
			SessionErrors.add(actionRequest, "duplicate-cvlName");
			
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			actionResponse.setRenderParameter("mvcPath", "/html/edit_cvl.jsp");
		}
		else {
			AwardLocalServiceUtil.addAward(cvlId, cvlName, score, certificateArticleId, letterArticleId);
		}
	}

	private boolean validate(String cvlId, double score, List<String> errors) {

		boolean valid = true;

		if (Validator.isNull(cvlId)) {
			errors.add("invalid-cvlid");
			valid = false;
		}

		if (Validator.isNull(score)) {
			errors.add("invalid-score");
			valid = false;
		}

		return valid;
	}

	private static Log _log = LogFactoryUtil.getLog(CanvasPortlet.class);

	private static final String REST_HOST = PropsUtil.get("rest.api.host");
	private static final String DELETE_AWARD_URL = PortletProps.get("rest.api.url.delete.award");
	private static final String COURSE_BY_CVL_IDS_URL = PortletProps.get("rest.api.url.get.course.by.cvl.ids");
	private static final String CREATE_UPDATE_AWARD_URL = PortletProps.get("rest.api.url.create.update.award");
}