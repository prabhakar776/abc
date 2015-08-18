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
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cisco.utility.constants.CiscoConstants;
import com.instructure.canvas.model.CertLetterQueue;
import com.instructure.canvas.model.impl.CertLetterQueueImpl;
import com.instructure.canvas.service.base.CertLetterQueueLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasApiUtils;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * The implementation of the cert letter queue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.instructure.canvas.service.CertLetterQueueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.CertLetterQueueLocalServiceBaseImpl
 * @see com.instructure.canvas.service.CertLetterQueueLocalServiceUtil
 */
public class CertLetterQueueLocalServiceImpl extends
		CertLetterQueueLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.instructure.canvas.service.CertLetterQueueLocalServiceUtil} to access
	 * the cert letter queue local service.
	 */

	public boolean addCertLetter(long courseId, long userId, String status,
			String type) throws IOException {
		try {

			//NEX-4106: Reuse existing record with status ERROR if any
			CertLetterQueue clq = getExistingCertLetterRecord(courseId, userId,
					type);
			Date now = new Date();

			if (clq != null) { // Reuse Existing Record
				clq.setStartTime(null);
				clq.setEndTime(null);
				clq.setExpiryDate(null);
				clq.setZipFileLocation(StringPool.BLANK);
				clq.setErrorDescription(StringPool.BLANK);
			} else {
				long id = counterLocalService.increment();
				clq = certLetterQueuePersistence.create(id);
				clq.setCourseId(courseId);
				clq.setCreatedBy(userId);
				clq.setCreateDate(now);
				clq.setType(type);
			}

			clq.setStatus(status);
			clq.setModifiedDate(now);
			clq.setErrorCount(0);

			return Validator.isNotNull(certLetterQueuePersistence.update(clq,
					false));
		} catch (Exception e) {
			_log.error(e);
		}
		return false;
	}
	
	private CertLetterQueue getExistingCertLetterRecord(long courseID,
			long userID, String type) throws SystemException, IOException {

		for (CertLetterQueue certLetterQueue : getCertLetterStatusByCourseIdUserId(
				courseID, userID)) {
			if (type.equalsIgnoreCase(certLetterQueue.getType()))
				return certLetterQueue;
		}
		return null;
	}

	public List<CertLetterQueue> findEligibleEntries() throws IOException,
			SystemException {

		String[] statusArr = { CiscoConstants.SUBMITTED, CiscoConstants.ERROR };
		int[] errorArr = { 0, 1, 2, 3, 4, 5 };

		return certLetterQueuePersistence.findByStatusAndErrorCount(statusArr,
				errorArr);
	}

	public List<CertLetterQueue> getCertLetterStatus(long courseId,
			String status, long userId) throws IOException, SystemException {
		return certLetterQueuePersistence.findByCourseIdStatusAndCreatedBy(
				courseId, status, userId);
	}

	public List<CertLetterQueue> getCertLetterStatusByCourseIdUserId(
			long courseId, long userId) throws IOException, SystemException {
		
		// code changed by Saurabh to accomodate REST call for getting the records.
		String url = REST_HOST.concat(FIND_BY_COURSEID_AND_CREATED_BY.replace("courseid", String.valueOf(courseId)))
				.concat(String.valueOf(userId));

		_log.info("REST url : "+url);
		
		JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
		
		
		List<CertLetterQueue> certList = new ArrayList<CertLetterQueue>();
		DateFormat sdf = DateFormatFactoryUtil.getSimpleDateFormat("MM/dd/yyyy");
		if(obj != null){
			JSONArray jsonArray = obj.getJSONArray("entities");
			_log.info("Total Certificates found from MongoDB are : "+jsonArray.length());
			for (int j = 0; j < jsonArray.length(); j++) {
				JSONObject jsonObject = jsonArray.getJSONObject(j);
				CertLetterQueue	certLetterQueue = getCertLetterQueue(jsonObject,sdf);
				certList.add(certLetterQueue);
			}

		}else{
			_log.info("Reading from PostgreSQL");
			return certLetterQueuePersistence.findByCourseIdAndCreatedBy(courseId,userId);
		}
		
		return certList;

		
//		return certLetterQueuePersistence.findByCourseIdAndCreatedBy(courseId,
//				userId);
	}

	public List<CertLetterQueue> getByCourseIdStatusCreatedByAndType(
			long courseId, String status, long userId, String type)
			throws IOException, SystemException {
		
		// code changed by Saurabh to accomodate REST call for getting the records.
		String url = REST_HOST.concat(GET_COURSEID_BY_STATUS_CREATED_AND_TYPE.replace("courseid", String.valueOf(courseId))).
				concat(StringPool.QUESTION).
				concat("userId").
				concat(StringPool.EQUAL).
				concat(String.valueOf(userId)).
				concat(StringPool.AMPERSAND).
				concat("status").
				concat(StringPool.EQUAL).
				concat(String.valueOf(status)).
				concat(StringPool.AMPERSAND).
				concat("type").
				concat(StringPool.EQUAL).
				concat(String.valueOf(type));				
		
		_log.info("REST url : "+url);
		
		JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
		
		List<CertLetterQueue> certList = new ArrayList<CertLetterQueue>();
		DateFormat sdf = DateFormatFactoryUtil.getSimpleDateFormat("MM/dd/yyyy");
		if(obj != null){
			JSONArray jsonArray = obj.getJSONArray("entities");
			_log.info("Total Certificates found from MongoDB are : "+jsonArray.length());
			for (int j = 0; j < jsonArray.length(); j++) {
				JSONObject jsonObject = jsonArray.getJSONObject(j);
				CertLetterQueue	certLetterQueue = getCertLetterQueue(jsonObject,sdf);
				certList.add(certLetterQueue);
			}
		}else{
			_log.info("Reading from PostgreSQL");
			return certLetterQueuePersistence.findByCourseIdStatusCreatedByAndType(courseId, status, userId, type);
		}
		
		return certList;
		
		//return certLetterQueuePersistence.findByCourseIdStatusCreatedByAndType(courseId, status, userId, type);
	}

	// method added by saurabh
	/**
	 * 
	 */
	private CertLetterQueue getCertLetterQueue(JSONObject jsonObject, DateFormat sdf){

		CertLetterQueue	certLetterQueue = null;
		certLetterQueue = new CertLetterQueueImpl();
		certLetterQueue.setId(jsonObject.getLong("id"));
		certLetterQueue.setCourseId(jsonObject.getLong("courseid"));
		
		
			try {
				if(jsonObject.getString("createDate") != null){
					certLetterQueue.setCreateDate(sdf.parse(jsonObject.getString("createDate")));
				}
				if(jsonObject.getString("modifiedDate") != null){
					certLetterQueue.setModifiedDate(sdf.parse(jsonObject.getString("modifiedDate")));
				}
				if(jsonObject.getString("startTime") != null){
					certLetterQueue.setStartTime(sdf.parse(jsonObject.getString("startTime")));
				}
				if(jsonObject.getString("endTime") != null){
					certLetterQueue.setEndTime(sdf.parse(jsonObject.getString("endTime")));
				}
				if(jsonObject.getString("expiryDate") != null){
					certLetterQueue.setExpiryDate(sdf.parse(jsonObject.getString("expiryDate")));
				}
				if(jsonObject.getString("downloadDate") != null){
					certLetterQueue.setDownloadDate(sdf.parse(jsonObject.getString("downloadDate")));
				}
			} catch (ParseException e) {
				_log.error(e);
			}
			
		certLetterQueue.setCreatedBy(jsonObject.getLong("createdBy"));
		certLetterQueue.setStatus(jsonObject.getString("status"));
		certLetterQueue.setErrorDescription(jsonObject.getString("errorDescription"));
		
		certLetterQueue.setZipFileLocation(jsonObject.getString("zipFileLocation"));
		
		certLetterQueue.setType(jsonObject.getString("type"));
		
		
		return certLetterQueue;
		
	}
	
	public List<CertLetterQueue> findEligibleEntriesToExpire()
			throws IOException, SystemException {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		return certLetterQueuePersistence.findByStatusAndExpiryDate(
				CiscoConstants.COMPLETED, calendar.getTime());
	}

	public List<CertLetterQueue> getCertLetterBYCourseIdCreatedByAndStatusNotEqual(
			long courseId, long userId, String status) throws IOException,
			SystemException {

		return certLetterQueuePersistence
				.findByCourseIdCreatedByAndStatusNotEqual(courseId, userId,
						status);
	}

	public boolean regenerateCertLetter(long courseId, long userId, String cmd)
			throws IOException, SystemException {

		List<CertLetterQueue> eligibleEntriesList = null;
		Calendar calendar = Calendar.getInstance();
		if (cmd.equals(CiscoConstants.REG_CERTIFICATE))
			cmd = CiscoConstants.CERTIFICATE;
		else if (cmd.equals(CiscoConstants.REG_LETTER))
			cmd = CiscoConstants.LETTER;

		if (_log.isDebugEnabled()) {
			_log.debug("Regenerating " + cmd);
		}

		eligibleEntriesList = getByCourseIdStatusCreatedByAndType(courseId,
				CiscoConstants.COMPLETED, userId, cmd);

		if (Validator.isNotNull(eligibleEntriesList)
				&& eligibleEntriesList.size() > 0) {
			for (CertLetterQueue certLetterQueue : eligibleEntriesList) {
				String zipFileLocation = certLetterQueue.getZipFileLocation();

				try {
					User defaultUser = UserLocalServiceUtil
							.getUser(certLetterQueue.getCreatedBy());
					DLStoreUtil.deleteFile(defaultUser.getCompanyId(),
							CompanyConstants.SYSTEM, zipFileLocation);

					if (_log.isDebugEnabled()) {
						_log.debug(cmd + " Regenearation Action: Deleting existing file from "
								+ zipFileLocation);
					}

				} catch (Exception e) {
					_log.error(e);
				}

				calendar.setTime(new Date());
				certLetterQueue.setStartTime(null);
				certLetterQueue.setStatus(CiscoConstants.SUBMITTED);
				certLetterQueue.setModifiedDate(calendar.getTime());
				certLetterQueue.setZipFileLocation(StringPool.BLANK);
				certLetterQueue.setErrorCount(0);
				certLetterQueue.setErrorDescription(StringPool.BLANK);
				certLetterQueue.setEndTime(null);
				certLetterQueue.setExpiryDate(null);
				certLetterQueue.setType(cmd);
				try {
					return Validator.isNotNull(certLetterQueuePersistence
							.update(certLetterQueue, false));

				} catch (Exception e) {
					_log.error(e);
				}
			}
		}

		return false;
	}

	private static Log _log = LogFactoryUtil
			.getLog(CertLetterQueueLocalServiceImpl.class);
	
	private static final String GET_COURSEID_BY_STATUS_CREATED_AND_TYPE = PortletProps.get("rest.api.url.get.certidbystacreatandtype");
	private static final String FIND_BY_COURSEID_AND_CREATED_BY = PortletProps.get("rest.api.url.get.courseidandcreatdby");
	private static final String REST_HOST = PropsUtil.get("rest.api.host");
}