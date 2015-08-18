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

import com.cisco.utility.constants.CiscoConstants;
import com.cisco.utility.service.UtilityLocalServiceUtil;
import com.instructure.canvas.model.Assignment;
import com.instructure.canvas.model.Award;
import com.instructure.canvas.model.CanvasUser;
import com.instructure.canvas.model.Certificate;
import com.instructure.canvas.model.Course;
import com.instructure.canvas.model.Letter;
import com.instructure.canvas.model.Merit;
import com.instructure.canvas.model.SubmissionVersion;
import com.instructure.canvas.model.UserAward;
import com.instructure.canvas.model.impl.AwardImpl;
import com.instructure.canvas.model.impl.CourseImpl;
import com.instructure.canvas.service.AssignmentLocalServiceUtil;
import com.instructure.canvas.service.CanvasUserLocalServiceUtil;
import com.instructure.canvas.service.CourseLocalServiceUtil;
import com.instructure.canvas.service.SubmissionVersionLocalServiceUtil;
import com.instructure.canvas.service.UserAwardLocalServiceUtil;
import com.instructure.canvas.service.base.AwardLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasApiUtils;
import com.instructure.canvas.util.CanvasConstants;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.DocumentConversionUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateDirectoryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.salesforce.model.SalesforceAccount;
import com.liferay.salesforce.service.SalesforceAccountLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;
import com.liferay.portal.NoSuchUserException;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

/**
 * The implementation of the award local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.service.AwardLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.AwardLocalServiceBaseImpl
 * @see com.instructure.canvas.service.AwardLocalServiceUtil
 */
public class AwardLocalServiceImpl extends AwardLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.instructure.canvas.service.AwardLocalServiceUtil} to access the award local service.
	 */

	public Award addAward(String cvlId, String cvlName, double score,
		long certificateArticleId, long letterArticleId)
		throws SystemException {
		long awardId = CounterLocalServiceUtil.increment();

		Award award = createAward(awardId);

		award.setCvlId(cvlId);
		award.setCvlName(cvlName);
		award.setScore(score);
		award.setCertificateArticleId(certificateArticleId);
		award.setLetterArticleId(letterArticleId);
		award.setActive(true);
		award.setCreateDate(new Date());
		award.setModifiedDate(new Date());

		
		
		//create new Award to MongoDB
		
		// get the courseID from cvlID
		/*String courseId = null;
		List<String> cvlIds = new ArrayList<String>();
		cvlIds.add(award.getCvlId());
		
		String params = StringUtils.join(cvlIds, "&cvlId=");
		String url = REST_HOST.concat(COURSE_BY_CVL_IDS_URL).concat(StringPool.QUESTION).concat("cvlId=").concat(params);
		_log.info("REST url : "+url);
		
		JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
		
		
		if(obj != null && obj.has("entities")){
			JSONArray jsonArray = obj.getJSONArray("entities");
			if(jsonArray != null && jsonArray.length() > 0){
				courseId = jsonArray.getJSONObject(0).getString("id");
			}
		}else{
			_log.info("Couldn't retrieve Courses from MongoDB");
		}*/		
			
		String updateURL = REST_HOST.concat(CREATE_UPDATE_AWARD_URL);
		_log.info("REST url : "+updateURL);
		

		try {
			
			long processStartTime = new Date().getTime();
			award = updateAward(award);
		    long processEndTime = new Date().getTime();
		    _log.info("Time take by Liferay service to create Award is : "+(processEndTime-processStartTime)+ " milliseconds");
		    
		    //REST call
			int statusCode = CanvasApiUtils.postDataToMongoDB(updateURL, award);
			if(statusCode != 200){
				//error from server, then throw SystemException - Dual write transaction mgmt.
				_log.info("TRANSECTION FAILED to create Award ");
				throw new SystemException();
			}else{
				_log.info("TRANSECTION SUCCEED to create Award ");
			}
			
		}catch (ConnectException e) {
			//if REST server is down, then throw SystemException - Dual write transaction mgmt.
			throw new SystemException();
		}catch (ClientProtocolException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		}
		
		
		//create Award in DB and return
		return award;
		
	}

	public void deactivateAward(long awardId) throws SystemException, PortalException {
		Award award = getAward(awardId);

		award.setActive(false);
		award.setModifiedDate(new Date());
		
		updateAward(award);
	}

	public String generate18CharId(String id) {

		// This method will take a 15 character ID and return its 18 character ID:
		if (id == null) {
			return null;
		}

		if (id.length() != 15) {
			return null;
		}

		String suffix = "";
		int flags;

		for (int i = 0; i < 3; i++) {
			flags = 0;

			for (int j = 0; j < 5; j++) {
				String c = id.substring(i * 5 + j,i * 5 + j + 1);

				//Only add to flags if c is an uppercase letter:
				if (c.toUpperCase().equals(c) && c.charAt(0) >= 'A' && c.charAt(0) <= 'Z') {
					flags = flags + (1 << j);
				}
			}

			if (flags <= 25) {
				suffix = suffix + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(flags,flags+1);
			}
			else {
                //suffix = suffix + "012345".substring(flags-25,flags-24);

                //http://forceguru.blogspot.com/2010/12/how-salesforce-18-digit-id-is.html
                //http://teachmesalesforce.wordpress.com/2011/06/06/how-salesforce-18-digit-id-is-calculated/
                //http://boards.developerforce.com/t5/General-Development/display-18-character-ID-in-Page-Layout/td-p/49900
                suffix = suffix + "012345".charAt(flags-26);
			}
		}

		return id + suffix;
	}

	public List<Award> getActiveAwards() throws SystemException {
		//return awardPersistence.findByActive(true);
		
		//Get all Active Awards from MongoDB
		String url = REST_HOST.concat(GET_ACTIVE_AWARDS);
		_log.info("REST url : "+url);
		
		JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
		List<Award> awards = null;
		if(obj != null){
			JSONArray jsonArray = obj.getJSONArray("entities");
			if(jsonArray != null && jsonArray.length() > 0){
				awards = getAwardList(jsonArray);
				_log.info("Total Awards found from MongoDB : "+awards.size());
			}else{
				_log.info("Could not find Awards from MongoDB");
				_log.info("Now trying to get from PostgreSQL");
				awards = awardPersistence.findByActive(true);
				_log.info("Total Awards found from PostgreSQL : "+awards.size());
			}
		}
		return awards;
	}

	private List<Award> getAwardList(JSONArray jsonArray){
		List<Award> awards = new ArrayList<Award>();
		DateFormat sdf = DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for(int i=0; i<jsonArray.length(); i++){
			JSONObject awrd = jsonArray.getJSONObject(i);
			Award award = new AwardImpl();
			
			award.setAwardId(awrd.getLong("awardId"));
			award.setCvlId(awrd.getString("cvlId"));
			award.setCvlName(awrd.getString("cvlName"));
			award.setScore(awrd.getDouble("score"));
			award.setLetterArticleId(awrd.getLong("letterArticleId"));
			award.setCertificateArticleId(awrd.getLong("certificateArticleId"));
			award.setActive(awrd.getBoolean("active_"));
			try {
				if(awrd.getString("createDate") != null && awrd.getString("modifiedDate") != null 
						&& StringUtils.isNotEmpty(awrd.getString("createDate")) && StringUtils.isNotEmpty(awrd.getString("modifiedDate"))){
					award.setCreateDate(sdf.parse(awrd.getString("createDate")));
					award.setModifiedDate(sdf.parse(awrd.getString("modifiedDate")));
				}
			} catch (ParseException e) {
				_log.error(e);
			}
			awards.add(award);
		}
		
		return awards;
		
	}
	
	public Award getAwardByCVLId(String cvlId) throws SystemException {
		//REST call - method changed by Ritesh as MongoDB schema changed
		String awardRUL = REST_HOST.concat(GET_AWARD_BY_CVLID).concat(cvlId);
		_log.info("REST url : "+awardRUL);
		
		JSONObject dateObj = CanvasApiUtils.getJSONObjectFromUrl(awardRUL);
		
		Award award = new AwardImpl();
		DateFormat sdf = DateFormatFactoryUtil.getSimpleDateFormat("MM/dd/yyyy");
		
		if(dateObj != null){
			dateObj = dateObj.getJSONObject("entity");
			
			award.setAwardId(dateObj.getLong("awardId"));
			award.setCvlId(dateObj.getString("cvlId"));
			award.setCvlName(dateObj.getString("cvlName"));
			award.setScore(dateObj.getDouble("score"));
			award.setLetterArticleId(dateObj.getLong("letterArticleId"));
			award.setCertificateArticleId(dateObj.getLong("certificateArticleId"));
			award.setActive(dateObj.getBoolean("active_"));
			try {
				if(dateObj.getString("createDate") != null && dateObj.getString("modifiedDate") != null 
						&& StringUtils.isNotEmpty(dateObj.getString("createDate")) && StringUtils.isNotEmpty(dateObj.getString("modifiedDate"))){
					award.setCreateDate(sdf.parse(dateObj.getString("createDate")));
					award.setModifiedDate(sdf.parse(dateObj.getString("modifiedDate")));
				}
			} catch (ParseException e) {
				_log.error(e);
			}
			
		}else{
			_log.info("No data found from MongoDB..Reading from PostgreSQL");
			return awardPersistence.fetchByCVL_ID(cvlId);
		}
		
		return award;
		//return awardPersistence.fetchByCVL_ID(cvlId);
	}

	/**
	 * 
	 */
	public Award getAwardByCVLName(String cvlName) throws SystemException {
		// method changed by Saurabh for REST call
		Award award = new AwardImpl();
		// check if the string passed contains # sign or not, since we have changed the code in CanvasPortlet to send
		// in "cvlName#cvlId" format
		if(cvlName.indexOf("#") != -1){
			
			String cvlNameNew = cvlName.substring(0,cvlName.indexOf("#"));
			//String cvlId = cvlName.substring(cvlName.indexOf("#")+1);
			
			
			
			// get the courseID from cvlID
			/*List<Course> courses = new ArrayList<Course>();
			List<String> cvlIds = new ArrayList<String>();
			cvlIds.add(cvlId);
			
			String params = StringUtils.join(cvlIds, "&cvlId=");
			String url = REST_HOST.concat(COURSE_BY_CVL_IDS_URL).concat(StringPool.QUESTION).concat("cvlId=").concat(params);
			_log.info("REST url : "+url);
			
			JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
			JSONArray jsonArray = obj.getJSONArray("entities");
			
			if(jsonArray != null){
				courses = getCourseListFromJsonArray(jsonArray);
			}else{
				_log.info("Couldn't retrieve Courses from MongoDB");
			}		*/
			
			//if(courses.size() > 0){
				//Course course = courses.get(0);
				
				String awardRUL = REST_HOST.concat(GET_AWARD_BY_CVLNAME)
						.concat(String.valueOf(cvlNameNew));
				
				_log.info("REST url : "+awardRUL);
				
				JSONObject awardObj = CanvasApiUtils.getJSONObjectFromUrl(awardRUL);
				awardObj = awardObj.getJSONObject("entity");
				
				DateFormat sdf = DateFormatFactoryUtil.getSimpleDateFormat("MM/dd/yyyy");
				
				if(awardObj != null){
					award.setAwardId(awardObj.getLong("awardId"));
					award.setCvlId(awardObj.getString("cvlId"));
					award.setCvlName(awardObj.getString("cvlName"));
					award.setScore(awardObj.getDouble("score"));
					award.setLetterArticleId(awardObj.getLong("letterArticleId"));
					award.setCertificateArticleId(awardObj.getLong("certificateArticleId"));
					award.setActive(awardObj.getBoolean("active_"));
					try {
						if(awardObj.getString("createDate") != null && StringUtils.isNotEmpty(awardObj.getString("createDate"))
								&& !awardObj.getString("createDate").equalsIgnoreCase("null")){
							award.setCreateDate(sdf.parse(awardObj.getString("createDate")));
						}
						if(awardObj.getString("modifiedDate") != null && StringUtils.isNotEmpty(awardObj.getString("modifiedDate"))
								&& !awardObj.getString("modifiedDate").equalsIgnoreCase("null")){
							award.setModifiedDate(sdf.parse(awardObj.getString("modifiedDate")));							
						}
					} catch (ParseException e) {
						_log.error(e);
					}
					
				}else{
					return awardPersistence.fetchByCVL_Name(cvlName);
				}
			//}
		}
		return award;
		
		//return awardPersistence.fetchByCVL_Name(cvlName);
	}
	/**
	 * 
	 * @param jsonArray
	 * @return
	 */
	/*private List<Course> getCourseListFromJsonArray(JSONArray jsonArray){
		
		List<Course> courses = new ArrayList<Course>();
   		for (int i = 0; i < jsonArray.length(); i++) {
			   JSONObject course = jsonArray.getJSONObject(i);
			   Course crs = new CourseImpl();
			   crs.setId(course.getLong("id"));
			   crs.setName(course.getString("name"));
			   crs.setAccountId(course.getLong("accountId"));
			   crs.setNetacadCoreOfferingId(course.getString("netacadCoreOfferingId"));
			   crs.setNetacadCVLId(course.getString("netacadCVLId"));
			  
			   courses.add(crs);
		}
		return courses;
	}	*/
	/**
	 * 
	 */
	public File getCertificate(
		long canvasUserId, long courseId, Map<String, String> variables,
		String languageId, ThemeDisplay themeDisplay)
		throws SystemException, PortalException, IOException {
		
		UserAward userAward = userAwardLocalService.getCertificate(canvasUserId, courseId);
		
		if (userAward != null) {
			if (_log.isDebugEnabled()) {
				_log.debug("Returning existing certificate from " + userAward.getCertId());
			}
			
			return getExistingFile(userAward, themeDisplay);
		}
		else {
			Course course = CourseLocalServiceUtil.getCourseById(courseId);
			String cvlId = course.getNetacadCVLId();
			Award award = awardPersistence.fetchByCVL_ID(cvlId);
			
			if (award == null) {
				if (_log.isDebugEnabled()) {
					_log.debug("Award is null");
				}

				return null;
			}
			
			long dlFileEntryId = award.getCertificateArticleId();

			if (Validator.isNull(dlFileEntryId)) {
				if (_log.isDebugEnabled()) {
					_log.debug("Certificate article Id is null");
				}
				
				return null;
			}

			Certificate certificate = new Certificate(
				variables.get("academy-name"),
				variables.get("date"),
				variables.get("instructor-name"),
				variables.get("location"),
				variables.get("student-name"));

			return getFile(
				dlFileEntryId, "pdf", languageId, themeDisplay, certificate, 
				canvasUserId, courseId, false);
		}
	}

	public File getLetter(
		long canvasUserId, long courseId, Map<String, String> variables,
		String languageId, ThemeDisplay themeDisplay)
		throws SystemException, PortalException, IOException {

		UserAward userAward = userAwardLocalService.getLetter(canvasUserId, courseId);

		if (userAward != null) {
			if (_log.isDebugEnabled()) {
				_log.debug("Returning existing letter from " + userAward.getCertId());
			}
			
			return getExistingFile(userAward, themeDisplay);
		}
		else {
			Course course = CourseLocalServiceUtil.getCourseById(courseId);
			String cvlId = course.getNetacadCVLId();
			//Award award = awardPersistence.fetchByCVL_ID(cvlId);
			
			//REST call
			Award award = getAwardByCVLId(cvlId);
			if (award == null) {
				_log.debug("Reading from PostgreSQL");
				award = awardPersistence.fetchByCVL_ID(cvlId);
			}
			if (award == null) {
				if (_log.isDebugEnabled()) {
					_log.debug("Award is null");
				}
				
				return null;
			}

			long dlFileEntryId = award.getLetterArticleId();

			if (Validator.isNull(dlFileEntryId)) {
				if (_log.isDebugEnabled()) {
					_log.debug("Letter article Id is null");
				}

				return null;
			}

			Letter letter = new Letter(
				variables.get("date"), variables.get("student-name"));

			return getFile(
				dlFileEntryId, "pdf", languageId, themeDisplay,
				letter, canvasUserId, courseId, true);
		}
	}

	private File getFile(
		long dlFileEntryId, String targetExtension,String languageId,
		ThemeDisplay themeDisplay, Merit merit, long canvasUserId, long courseId, 
		boolean isLetter) throws SystemException {

        File tempFile = null;

		try {
			PermissionThreadLocal.getPermissionChecker().getUserId();
			long externalId = CounterLocalServiceUtil.increment();
			merit.setIdentifier(String.valueOf(externalId));

			// 1) Load ODT file by filling Velocity template engine and cache
			// it to the registry
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(dlFileEntryId);
			String title = dlFileEntry.getTitle();
			InputStream in = DLFileEntryServiceUtil.getFileAsStream(dlFileEntryId, dlFileEntry.getVersion());
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity, false );

			// 2) Create context Java model
			IContext context = report.createContext();
			if (isLetter) {
				context.put("letter", merit);
			}
			else {
				context.put("certificate", merit);
			}

			// 3) Generate report by merging Java model with the ODT
			tempFile = FileUtil.createTempFile("odt");

			OutputStream out = new FileOutputStream(tempFile);
			report.process( context, out );

            out.flush();

			if (_log.isDebugEnabled()) {
				_log.debug("Report Processed "+
				"File written to " + tempFile.getAbsolutePath() + " Size = " + tempFile.length());
			}

			InputStream is = new FileInputStream(tempFile);
			//FileUtil.delete(tempFile);
			String sourceExtension = "odt";
			String fileName;

			if (Validator.isNotNull(targetExtension)) {

				String id = DLUtil.getTempFileId(dlFileEntryId, dlFileEntry.getVersion(), languageId);

				if (_log.isDebugEnabled()) {
					_log.debug("Converting File");
				}

				File convertedFile = DocumentConversionUtil.convert(
						id + StringPool.PERIOD + canvasUserId + StringPool.PERIOD + courseId,
						is, sourceExtension, targetExtension);

				if (_log.isDebugEnabled()) {
					_log.debug("File Converted");
				}

				if (convertedFile != null) {
					fileName = title.concat(StringPool.PERIOD).concat(targetExtension);
					is = new FileInputStream(convertedFile);
					fileName = addFileToDL(themeDisplay.getCompanyId(), is, fileName, canvasUserId);

					if (fileName == null) {
						return null;
					}

					long userAwardId = CounterLocalServiceUtil.increment();
					UserAward userAward = userAwardLocalService.createUserAward(userAwardId);
					userAward.setCanvasUserId(canvasUserId);
					userAward.setCourseId(courseId);
					userAward.setCertId(fileName);
					userAward.setCreateDate(new Date());
					userAward.setExternalId(externalId);
					userAward.setLetter(isLetter);

					userAwardLocalService.updateUserAward(userAward);
				}

				return convertedFile;
			}

		} 
		catch (Exception e) {
			_log.error(e);
		} finally {
            if (Validator.isNotNull(tempFile))
                FileUtil.delete(tempFile);
		}

		return null;
	}

	public String addFileToDL(
		long companyId, InputStream is, String fileName, long userId)
		throws SystemException, PortalException {

		long repositoryId = CompanyConstants.SYSTEM;
		String directory = String.valueOf(userId);

		try {
			DLStoreUtil.addDirectory(companyId, repositoryId, directory);
		} 
		catch (DuplicateDirectoryException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		}

		try {
			fileName = directory + "/" + fileName;
			DLStoreUtil.addFile(companyId, repositoryId, fileName, is);
			
			if (_log.isDebugEnabled()) {
				_log.debug("File added to DL at " + fileName);
			}
			
			return fileName;
		}
		catch (Exception e) {
			_log.error(e.getMessage());
			_log.error("Error while adding " + fileName + " to DL", e);
		}

		return null;
	}

	private File getExistingFile(UserAward userAward, ThemeDisplay themeDisplay) {
		return getExistingFile(userAward, themeDisplay.getCompanyId());
	}
		
	public File getExistingFile(UserAward userAward, long companyId) {	
		
		try {
			String certId = userAward.getCertId();

			InputStream is = DLStoreUtil.getFileAsStream(
				companyId, CompanyConstants.SYSTEM, certId, "1.0");
			
			if (_log.isDebugEnabled()) {
				_log.debug(certId + " file retrieved from DL successfully");
			}
			
			File tempFile = FileUtil.createTempFile("pdf");
			FileUtil.write(tempFile, is);

			if (_log.isDebugEnabled()) {
				_log.debug("Temp file created at " + tempFile);
			}
			
			return tempFile;
		} 
		catch (Exception e) {
			_log.error(e);
		}

		return null;
	}

	private File getPdfFile(String targetExtension, String languageId,
			Merit merit, String studUserFullName, long canvasUserId, long courseId,
			File tempTemplateFile, DLFileEntry dlFileEntry,
			boolean isCertificate) throws SystemException {

		File tempOdtFile = null;
		String sourceExtension = "odt";
		try {
			long externalId = CounterLocalServiceUtil.increment();
			merit.setIdentifier(String.valueOf(externalId));

			// 1) Load ODT file by filling Velocity template engine and cache
			// it to the registry
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					new FileInputStream(tempTemplateFile),
					TemplateEngineKind.Velocity, false);

			// 2) Create context Java model
			IContext context = report.createContext();

			if (isCertificate)
				context.put("certificate", merit);
			else
				context.put("letter", merit);

			// 3) Generate report by merging Java model with the ODT
			tempOdtFile = FileUtil.createTempFile("odt");

			OutputStream outStream = new FileOutputStream(tempOdtFile);
			report.process(context, outStream);

            outStream.flush();

			if (_log.isDebugEnabled()) {
				_log.debug("Report Processed " + "File written to "
						+ tempOdtFile.getAbsolutePath() + " Size = " + tempOdtFile.length());
			}

			InputStream inStream = new FileInputStream(tempOdtFile);

			if (Validator.isNotNull(targetExtension)) {

				if (_log.isDebugEnabled()) {
					_log.debug("Converting File");
				}

				File convertedFile = DocumentConversionUtil.convert(
						studUserFullName + StringPool.PERIOD + canvasUserId
								+ StringPool.PERIOD + courseId, inStream,
						sourceExtension, targetExtension);

				if (_log.isDebugEnabled()) {
					_log.debug("File Converted to PDF "
							+ convertedFile.getName());
				}

				inStream.close();
				outStream.close();

				return convertedFile;
			}
		} catch (Exception e) {
			_log.error(e);
		} finally {
			if (Validator.isNotNull(tempOdtFile))
				FileUtil.delete(tempOdtFile);
		}
		return null;
	}

	public String getAllCertsForInstructor(String instructorUserId,
			String courseId) {

		User instructorUser = null;
		File certificate = null;
		File tempZipFile = null;
		File tempTemplateFile = null;
		ZipOutputStream zipOutStream = null;
		List<SubmissionVersion> submissionsVersionList = null;
		String status = StringPool.BLANK;
		Set<Long> allUserSet = new TreeSet<Long>();
		Set<Long> certifyUserSet = new TreeSet<Long>();
		Map<String, String> variables = new HashMap<String, String>();

		if (Validator.isNotNull(courseId)) {

			try {
				instructorUser = UserLocalServiceUtil.getUser(Long
						.valueOf(instructorUserId));

				Course course = CourseLocalServiceUtil.getCourseById(Long
						.valueOf(courseId));
				String institutionIDc = String.valueOf(course.getAccountId());
				List<SalesforceAccount> salesforceAccounts = SalesforceAccountLocalServiceUtil
						.getAccountsByInstutionIdAndRecordType(institutionIDc,
								PropsUtil.get("account.recordtype.id"));

				List<CanvasUser> allStudentsList = CanvasUserLocalServiceUtil
						.getStudentsByCourseId(courseId);
				for (CanvasUser CanvasUser : allStudentsList) {
					long userId = UtilityLocalServiceUtil.getEntityId(
							PortalUtil.getDefaultCompanyId(),
							User.class.getName(),
							CiscoConstants.EXPANDO_CANVAS_USER_ID,
							CanvasUser.getCanvasUserId());
					if(Validator.isNotNull(userId))
						allUserSet.add(userId);
				}

				long assignmentId = getRequiredAssignmentId(
						Long.valueOf(courseId), CiscoConstants.CERTIFICATE);
				if (assignmentId == 0)
					return null;

				if (_log.isDebugEnabled()) {
					_log.debug("Required assignmentId for certificate "
							+ assignmentId);
				}

				submissionsVersionList = SubmissionVersionLocalServiceUtil
						.getSubmissionHistory(null,
								String.valueOf(assignmentId), courseId);

				if (Validator.isNotNull(submissionsVersionList)
						&& submissionsVersionList.size() > 0) {

					tempZipFile = FileUtil.createTempFile("zip");
					tempTemplateFile = FileUtil.createTempFile("odt");

					String cvlId = course.getNetacadCVLId();
					Award award = awardPersistence.fetchByCVL_ID(cvlId);
					if (Validator.isNull(award))
						return null;

					long dlFileEntryId = award.getCertificateArticleId();
					if (Validator.isNull(dlFileEntryId))
						return null;

					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil
							.getDLFileEntry(dlFileEntryId);

					// Fetching template once & saving it in a temporary file
					// We are using same temporary template file for all the
					// certificate generation
					InputStream inputStream = DLFileEntryLocalServiceUtil
							.getFileAsStream(Long.parseLong(instructorUserId),
									dlFileEntryId, dlFileEntry.getVersion());
					FileUtil.write(tempTemplateFile, inputStream);
					inputStream.close();

					FileOutputStream fileOutputStream = new FileOutputStream(
							tempZipFile);
					zipOutStream = new ZipOutputStream(fileOutputStream);

					for (SubmissionVersion submissionsVersion : submissionsVersionList) {

						String assignmentName = submissionsVersion
								.getAssignmentName();
						long studCanvasUserid = submissionsVersion.getUserId();
						long studUserId = UtilityLocalServiceUtil.getEntityId(
								instructorUser.getCompanyId(),
								User.class.getName(),
								CiscoConstants.EXPANDO_CANVAS_USER_ID,
								Long.toString(studCanvasUserid));
                        User studentUser = null;
                        try {
						    studentUser = UserLocalServiceUtil.getUser(studUserId);
                        } catch (NoSuchUserException nsue) {
                            _log.error("Liferay user not found for canvas user ID: " + studUserId);
                            continue;
                        }

						String studUserFullName = studentUser.getFullName();

						if (submissionsVersion.getCurrentGrade()
								.equalsIgnoreCase("complete")
								&& certifyUserSet.add(studUserId)) {

							DateFormat dateFormat = DateFormat.getDateInstance(
									DateFormat.MEDIUM, studentUser.getLocale());
							String today = dateFormat.format(new Date());

							variables.put("instructor-name",
									instructorUser.getFullName());
							variables.put("student-name", studUserFullName);
							variables.put("academy-name", salesforceAccounts
									.get(0).getName());
							variables.put("location", salesforceAccounts.get(0)
									.getBillingCountry());

							// If certificate is already generated for the user,
							// we are using his/her certificate generation date
							// not the current date.
							UserAward userAward = UserAwardLocalServiceUtil
									.getCertificate(studCanvasUserid,
											Long.parseLong(courseId));
							if (Validator.isNotNull(userAward)) {
								if (Validator.isNotNull(userAward
										.getCreateDate()))
									variables.put("date", dateFormat
											.format(userAward.getCreateDate()));
								else
									variables.put("date", today);
							} else {
								variables.put("date", today);
							}

							Merit merit = new Certificate(
									variables.get("academy-name"),
									variables.get("date"),
									variables.get("instructor-name"),
									variables.get("location"),
									variables.get("student-name"));

							try {
								certificate = getPdfFile("pdf",
										instructorUser.getLanguageId(), merit,
										studUserFullName, studCanvasUserid,
										Long.valueOf(courseId),
										tempTemplateFile, dlFileEntry,
										Boolean.TRUE);

								if (_log.isDebugEnabled()) {
									_log.debug("user having Canvas Userid "
											+ studCanvasUserid
											+ " getting certificate "
											+ certificate);
								}
							} catch (Exception e) {
								_log.error(e);
							}
							if (Validator.isNotNull(certificate))
								createZipEntry(zipOutStream, certificate);
						}
					}

					if (_log.isDebugEnabled()) {
						_log.debug("Total students who submitted their course "
								+ allUserSet);
						_log.debug("Students who are qualified for getting certificates "
								+ certifyUserSet);
					}

					if (allUserSet.size() != certifyUserSet.size()) {

						allUserSet.removeAll(certifyUserSet);
						String staticMsg = "ineligible-student-csv-msg-for-certificate";
						if (certifyUserSet.size() == 0) 
							staticMsg = "ineligible-all-student-csv-msg-for-certificate";
						File csvFile = generateStudentCsv(
								allUserSet,
								LanguageUtil.get(instructorUser.getLocale(),
										staticMsg));
						if (Validator.isNotNull(csvFile))
							createZipEntry(zipOutStream, csvFile);
					}

					zipOutStream.close();
					fileOutputStream.close();
					String fileLocation = instructorUserId
							+ StringPool.FORWARD_SLASH + courseId
							+ StringPool.UNDERLINE + CiscoConstants.CERTIFICATE
							+ ".zip";
					
					boolean hasFile = DLStoreUtil.hasFile(
							instructorUser.getCompanyId(),
							CompanyConstants.SYSTEM, fileLocation);

					if (hasFile) {

						if (_log.isDebugEnabled())
							_log.debug("File already exist, deleting it first ");

						DLStoreUtil.deleteFile(instructorUser.getCompanyId(),
								CompanyConstants.SYSTEM, fileLocation);
					}
					
					DLStoreUtil.addFile(instructorUser.getCompanyId(),
								CompanyConstants.SYSTEM, fileLocation,
								tempZipFile);
					
					status = fileLocation;

				} else {
                    // There are no eligible students
					String fileLocation = instructorUserId
							+ StringPool.FORWARD_SLASH + courseId
							+ StringPool.UNDERLINE + CiscoConstants.CERTIFICATE
							+ ".zip";
					boolean hasFile = DLStoreUtil.hasFile(
							instructorUser.getCompanyId(),
							CompanyConstants.SYSTEM, fileLocation);

					if (hasFile) {

						if (_log.isDebugEnabled())
							_log.debug("File already exist, deleting it first ");

						DLStoreUtil.deleteFile(instructorUser.getCompanyId(),
								CompanyConstants.SYSTEM, fileLocation);
					}
					tempZipFile = FileUtil.createTempFile("zip");
					FileOutputStream fileOutputStream = new FileOutputStream(
							tempZipFile);
					zipOutStream = new ZipOutputStream(fileOutputStream);
					String staticMsg = "ineligible-all-student-csv-msg-for-certificate";
				
					File csvFile = generateStudentCsv(allUserSet,
						LanguageUtil.get(instructorUser.getLocale(),
								staticMsg));
				    if (Validator.isNotNull(csvFile)) {
					    createZipEntry(zipOutStream, csvFile);
                        zipOutStream.close();
                        fileOutputStream.close();
					    DLStoreUtil.addFile(instructorUser.getCompanyId(),
							CompanyConstants.SYSTEM, fileLocation,
							tempZipFile);
					    status = fileLocation;
                    }
                }
			} catch (Exception e) {
				_log.error(e);
			} finally {
				if (Validator.isNotNull(tempZipFile))
					FileUtil.delete(tempZipFile);
				if (Validator.isNotNull(tempTemplateFile))
					FileUtil.delete(tempTemplateFile);
			}
		}

		return status;
	}

	public String getAllLettersForInstructor(String instructorUserId,
			String courseId) {

		User instructorUser = null;
		File letter = null;
		File tempZipFile = null;
		File tempTemplateFile = null;
		ZipOutputStream zipOutStream = null;
		List<SubmissionVersion> submissionsVersionList = null;
		String status = StringPool.BLANK;
		Set<Long> allUserSet = new TreeSet<Long>();
		Set<Long> certifyUserSet = new TreeSet<Long>();
		Map<String, String> variables = new HashMap<String, String>();

		if (Validator.isNotNull(courseId)) {

			try {
				instructorUser = UserLocalServiceUtil.getUser(Long
						.valueOf(instructorUserId));

				Course course = CourseLocalServiceUtil.getCourseById(Long
						.valueOf(courseId));

				List<CanvasUser> allStudentsList = CanvasUserLocalServiceUtil
						.getStudentsByCourseId(courseId);
				for (CanvasUser CanvasUser : allStudentsList) {
					long userId = UtilityLocalServiceUtil.getEntityId(
							PortalUtil.getDefaultCompanyId(),
							User.class.getName(),
							CiscoConstants.EXPANDO_CANVAS_USER_ID,
							CanvasUser.getCanvasUserId());
					if(Validator.isNotNull(userId))
						allUserSet.add(userId);
				}

				long assignmentId = getRequiredAssignmentId(
						Long.valueOf(courseId), CiscoConstants.LETTER);
				if (assignmentId == 0)
					return null;

				if (_log.isDebugEnabled()) {
					_log.debug("Required assignmentId for letter "
							+ assignmentId);
				}

				submissionsVersionList = SubmissionVersionLocalServiceUtil
						.getSubmissionHistory(null,
								String.valueOf(assignmentId), courseId);

				if (Validator.isNotNull(submissionsVersionList)
						&& submissionsVersionList.size() > 0) {

					tempZipFile = FileUtil.createTempFile("zip");
					tempTemplateFile = FileUtil.createTempFile("odt");

					String cvlId = course.getNetacadCVLId();
					Award award = awardPersistence.fetchByCVL_ID(cvlId);
					if (Validator.isNull(award))
						return null;

					double minScore = award.getScore();

					long dlFileEntryId = award.getLetterArticleId();
					if (Validator.isNull(dlFileEntryId))
						return null;

					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil
							.getDLFileEntry(dlFileEntryId);

					// Fetching template once & saving it in a temporary file
					// We are using same temporary template file for all the
					// certificate generation
					InputStream inputStream = DLFileEntryLocalServiceUtil
							.getFileAsStream(Long.parseLong(instructorUserId),
									dlFileEntryId, dlFileEntry.getVersion());
					FileUtil.write(tempTemplateFile, inputStream);
					inputStream.close();

					FileOutputStream fileOutputStream = new FileOutputStream(
							tempZipFile);
					zipOutStream = new ZipOutputStream(fileOutputStream);

					for (SubmissionVersion submissionsVersion : submissionsVersionList) {

						String assignmentName = submissionsVersion
								.getAssignmentName();
						long studCanvasUserid = submissionsVersion.getUserId();
						long studUserId = UtilityLocalServiceUtil.getEntityId(
								instructorUser.getCompanyId(),
								User.class.getName(),
								CiscoConstants.EXPANDO_CANVAS_USER_ID,
								Long.toString(studCanvasUserid));
						User studentUser = UserLocalServiceUtil
								.getUser(studUserId);
						String studUserFullName = studentUser.getFullName();

						boolean isQualifiedForCert = CourseLocalServiceUtil
								.isQualifiedForCertificate(
										Long.parseLong(courseId),
										studCanvasUserid);

						if (_log.isDebugEnabled()) {
							_log.debug("user having Canvas Userid "
									+ studCanvasUserid
									+ "---------is Qualified For Certificate--------"
									+ isQualifiedForCert);
						}

						if (isQualifiedForCert) {
							if (submissionsVersion.getScore() >= minScore
									&& submissionsVersion.getAttempt() == 1
									&& Validator.isNull(submissionsVersion
											.getGraderId())
									&& certifyUserSet.add(studUserId)) {

								DateFormat dateFormat = DateFormat
										.getDateInstance(DateFormat.MEDIUM,
												studentUser.getLocale());
								String today = dateFormat.format(new Date());

								variables.put("student-name", studUserFullName);

								// If letter is already generated for the user,
								// we are using his/her letter generation date
								// not the current date.
								UserAward userAward = UserAwardLocalServiceUtil
										.getLetter(studCanvasUserid,
												Long.parseLong(courseId));
								if (Validator.isNotNull(userAward)) {
									if (Validator.isNotNull(userAward
											.getCreateDate()))
										variables.put("date", dateFormat
												.format(userAward
														.getCreateDate()));
									else
										variables.put("date", today);
								} else {
									variables.put("date", today);
								}

								Merit merit = new Letter(variables.get("date"),
										variables.get("student-name"));

								try {
									letter = getPdfFile("pdf",
											instructorUser.getLanguageId(),
											merit, studUserFullName, studCanvasUserid,
											Long.valueOf(courseId),
											tempTemplateFile, dlFileEntry,
											Boolean.FALSE);

									if (_log.isDebugEnabled()) {
										_log.debug("user having Canvas Userid "
												+ studCanvasUserid
												+ " getting letter " + letter);
									}
								} catch (Exception e) {
									_log.error(e);
								}
								if (Validator.isNotNull(letter))
									createZipEntry(zipOutStream, letter);
							}
						}
					}

					if (_log.isDebugEnabled()) {
						_log.debug("Total students who submitted their course "
								+ allUserSet);
						_log.debug("Students who are qualified for letter "
								+ certifyUserSet);
					}

					if (allUserSet.size() != certifyUserSet.size()) {

						allUserSet.removeAll(certifyUserSet);
						String staticMsg = "ineligible-student-csv-msg-for-letter";
						if (certifyUserSet.size() == 0) {
							staticMsg = "ineligible-all-student-csv-msg-for-letter";
						}
						File csvFile = generateStudentCsv(allUserSet,
								LanguageUtil.get(instructorUser.getLocale(),
										staticMsg));
						if (Validator.isNotNull(csvFile))
							createZipEntry(zipOutStream, csvFile);
					}

					zipOutStream.close();
					fileOutputStream.close();
					String fileLocation = instructorUserId
							+ StringPool.FORWARD_SLASH + courseId
							+ StringPool.UNDERLINE + CiscoConstants.LETTER
							+ ".zip";
					
					boolean hasFile = DLStoreUtil.hasFile(
							instructorUser.getCompanyId(),
							CompanyConstants.SYSTEM, fileLocation);

					if (hasFile) {

						if (_log.isDebugEnabled())
							_log.debug("File already exist, deleting it first ");

						DLStoreUtil.deleteFile(instructorUser.getCompanyId(),
								CompanyConstants.SYSTEM, fileLocation);
					}

					DLStoreUtil.addFile(instructorUser.getCompanyId(),
								CompanyConstants.SYSTEM, fileLocation,
								tempZipFile);

					status = fileLocation;

				} else {
                    // No Eligible Students.
					String fileLocation = instructorUserId
							+ StringPool.FORWARD_SLASH + courseId
							+ StringPool.UNDERLINE + CiscoConstants.LETTER
							+ ".zip";
					boolean hasFile = DLStoreUtil.hasFile(
							instructorUser.getCompanyId(),
							CompanyConstants.SYSTEM, fileLocation);

					if (hasFile) {

						if (_log.isDebugEnabled())
							_log.debug("File already exist, deleting it first ");

						DLStoreUtil.deleteFile(instructorUser.getCompanyId(),
								CompanyConstants.SYSTEM, fileLocation);
					}
					tempZipFile = FileUtil.createTempFile("zip");
					FileOutputStream fileOutputStream = new FileOutputStream(
							tempZipFile);
					zipOutStream = new ZipOutputStream(fileOutputStream);
					String staticMsg = "ineligible-all-student-csv-msg-for-letter";
				
					File csvFile = generateStudentCsv(allUserSet,
						LanguageUtil.get(instructorUser.getLocale(),
								staticMsg));
				    if (Validator.isNotNull(csvFile)) {
					    createZipEntry(zipOutStream, csvFile);
                        zipOutStream.close();
                        fileOutputStream.close();
					    DLStoreUtil.addFile(instructorUser.getCompanyId(),
							CompanyConstants.SYSTEM, fileLocation,
							tempZipFile);
					    status = fileLocation;
                    }
				}
			} catch (Exception e) {
				_log.error(e);
			} finally {
				if (Validator.isNotNull(tempZipFile))
					FileUtil.delete(tempZipFile);
				if (Validator.isNotNull(tempTemplateFile))
					FileUtil.delete(tempTemplateFile);
			}
		}

		return status;
	}

	public String getZipFileLocation(String instructorUserId, String courseId,
			String type) {

		if (type.equals(CiscoConstants.CERTIFICATE))
			return getAllCertsForInstructor(instructorUserId, courseId);
		else
			return getAllLettersForInstructor(instructorUserId, courseId);
	}

	public long getRequiredAssignmentId(long courseId, String cmd) {

		List<Assignment> assignmentList = AssignmentLocalServiceUtil
				.getAssignments(courseId);
		if (Validator.isNotNull(assignmentList)) {
			for (Assignment assignment : assignmentList) {
				String assignmentName = assignment.getName();
				if (cmd.equals(CiscoConstants.CERTIFICATE)) {
					if ((assignmentName
							.equalsIgnoreCase(CiscoConstants.COURSE_COMPLETION) || assignmentName
							.startsWith(CiscoConstants.COURSE_COMPLETION_PREFIX)||assignmentName.startsWith(CiscoConstants.SELF_ENROLLED_COURSE_PREFIX))) {

						return assignment.getAssignmentId();

					}
				} else if (cmd.equals(CiscoConstants.LETTER)) {
					if (assignmentName
							.equalsIgnoreCase(CiscoConstants.FINAL_EXAM)
							|| assignmentName
									.startsWith(CiscoConstants.FINAL_EXAM_PREFIX)) {

						return assignment.getAssignmentId();

					}
				}
			}
		}

		return 0;
	}
	
	private static File generateStudentCsv(Set nonEligibleStudentSet, String staticMsg)
			throws IOException {

		File tempCsvFile = null;
		User nonEligibleUser = null;
		long nonEligiblesUserId = 0l;
		FileOutputStream fileOutPutStream = null;

		if (Validator.isNotNull(nonEligibleStudentSet)
				&& nonEligibleStudentSet.size() > 0) {

			Iterator itr = nonEligibleStudentSet.iterator();
			StringBuilder resultString = new StringBuilder(staticMsg);
			resultString.append(StringPool.NEW_LINE);
			resultString.append(StringPool.NEW_LINE);
			resultString.append("First Name,Last Name,Email");
			tempCsvFile = FileUtil.createTempFile("csv");

			try {
				fileOutPutStream = new FileOutputStream(tempCsvFile);
				while (itr.hasNext()) {
					nonEligiblesUserId = (Long) itr.next();
					try {
						nonEligibleUser = UserLocalServiceUtil
								.getUser(nonEligiblesUserId);
					} catch (Exception e) {
						_log.error(e);
					}

					resultString.append(StringPool.NEW_LINE);
					resultString.append(nonEligibleUser.getFirstName());
					resultString.append(StringPool.COMMA);
					resultString.append(nonEligibleUser.getLastName());
					resultString.append(StringPool.COMMA);
					resultString.append(nonEligibleUser.getEmailAddress());
				}
				String resultStringStr = resultString.toString();
				fileOutPutStream.write(resultStringStr.getBytes());
			} catch (Exception e) {
				_log.error(e);
			} finally {
				if (Validator.isNotNull(fileOutPutStream))
					fileOutPutStream.close();
			}
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Certs and Letters Job: Created CSV File" + tempCsvFile.getName());
		}
		return tempCsvFile;
	}

	private static void createZipEntry(ZipOutputStream zipOutStream, File file) {

		int len;
		byte[] buffer = new byte[1024];
		String fileName = file.getName();

		if (_log.isDebugEnabled()) {
			_log.debug("saving file " + fileName + " in the final zip file");
		}

		try {
			InputStream inputStream = new FileInputStream(file);
			ZipEntry zipEntry = new ZipEntry(fileName);
			zipOutStream.putNextEntry(zipEntry);

			while ((len = inputStream.read(buffer)) > 0) {
				zipOutStream.write(buffer, 0, len);
			}
			inputStream.close();
			zipOutStream.closeEntry();
		} catch (Exception e) {
			_log.error(e);
		} finally {
			FileUtil.delete(file);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("saved file " + fileName + " in the final zip file");
		}
	}
	
	public Award getAward(long awardId, String cvlId){

		String courseId =null;
		
		// get the courseID from cvlID
		/*List<String> cvlIds = new ArrayList<String>();
		cvlIds.add("a0SV0000000igi5MAA");
		
		String params = StringUtils.join(cvlIds, "&cvlId=");
		String url = REST_HOST.concat(COURSE_BY_CVL_IDS_URL).concat(StringPool.QUESTION).concat("cvlId=").concat(params);
		_log.info("REST url : "+url);
		
		JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
		
		if(obj != null){
			JSONArray jsonArray = obj.getJSONArray("entities");
			if(jsonArray != null &&  jsonArray.length() > 0){
				courseId = jsonArray.getJSONObject(0).getString("id");
			}else{
				_log.info("Couldn't retrieve Courses from MongoDB");
			}	
		}*/	
		
		
		//get Award from MongoDB - REST
		
		String awardURL = REST_HOST.concat(GET_AWARD_BY_ID).concat(String.valueOf(awardId));
		_log.info("REST url : "+awardURL);
		
		DateFormat sdf = DateFormatFactoryUtil.getSimpleDateFormat("MM/dd/yyyy");
		JSONObject awardObj = CanvasApiUtils.getJSONObjectFromUrl(awardURL);
		Award award = new AwardImpl();
		if(awardObj != null && awardObj.getJSONObject("entity") != null){
			awardObj = awardObj.getJSONObject("entity");
			
			award.setCvlId(awardObj.getString("cvlId"));
			award.setCvlName(awardObj.getString("cvlName"));
			award.setScore(awardObj.getDouble("score"));
			award.setCertificateArticleId(awardObj.getLong("certificateArticleId"));
			award.setLetterArticleId(awardObj.getLong("letterArticleId"));
			award.setActive(awardObj.getBoolean("active"));
			
			try {
				if(awardObj.getString("createDate") != null && awardObj.getString("modifiedDate") != null 
						&& StringUtils.isNotEmpty(awardObj.getString("createDate")) && StringUtils.isNotEmpty(awardObj.getString("modifiedDate"))){
					award.setCreateDate(sdf.parse(awardObj.getString("createDate")));
					award.setModifiedDate(sdf.parse(awardObj.getString("modifiedDate")));
				}
			} catch (ParseException e) {
				_log.error(e);
			}
			
			
		}else{
			_log.info("Couldn't retrieve Award from MongoDB");
			try {
				awardLocalService.getAward(awardId);
			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);			
			}
		}				
		return award;
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(AwardLocalServiceImpl.class);
	private static final String REST_HOST = PropsUtil.get("rest.api.host");
	private static final String GET_AWARD_BY_CVLID = PortletProps.get("rest.api.url.get.awardbycvlid");
	private static final String COURSE_BY_CVL_IDS_URL = PortletProps.get("rest.api.url.get.course.by.cvl.ids");
	private static final String GET_AWARD_BY_CVLNAME = PortletProps.get("rest.api.url.get.awardbycvlname");
	private static final String CREATE_UPDATE_AWARD_URL = PortletProps.get("rest.api.url.create.update.award");
	private static final String GET_AWARD_BY_ID = PortletProps.get("rest.api.url.get.award");
	private static final String GET_ACTIVE_AWARDS = PortletProps.get("rest.api.url.get.all.active.awards");
}