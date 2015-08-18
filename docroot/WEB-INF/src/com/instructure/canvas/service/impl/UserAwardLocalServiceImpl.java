package com.instructure.canvas.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;

import com.cisco.utility.constants.CiscoConstants;
import com.cisco.utility.service.UtilityLocalServiceUtil;
import com.instructure.canvas.model.UserAward;
import com.instructure.canvas.model.impl.UserAwardImpl;
import com.instructure.canvas.service.AwardLocalServiceUtil;
import com.instructure.canvas.service.base.UserAwardLocalServiceBaseImpl;
import com.instructure.canvas.util.CanvasApiUtils;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.User;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * The implementation of the user award local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.instructure.canvas.service.UserAwardLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.UserAwardLocalServiceBaseImpl
 * @see com.instructure.canvas.service.UserAwardLocalServiceUtil
 */
public class UserAwardLocalServiceImpl extends UserAwardLocalServiceBaseImpl {
	
	public UserAward getCertificate(long canvasUserId, long courseId) 
		throws SystemException{
			
		/*return userAwardPersistence.fetchByCUID_CID_L(
			canvasUserId, courseId, false);*/
		
		//REST call to MongoDB
		UserAward award = getUserAward(canvasUserId, courseId);
		if(award == null){
			log.info("Reading from PostgreSQL");
			return userAwardPersistence.fetchByCUID_CID_L(
					canvasUserId, courseId, false);
		}
			
			return award;
	}
	
	private UserAward getUserAward(long canvasUserId, long courseId){
		//REST call
		String url = REST_HOST.concat(GET_CERTIFICATE.replace("courseid", String.valueOf(courseId))).concat(StringPool.QUESTION)
					.concat("canvasUserId").concat(StringPool.EQUAL).concat(String.valueOf(canvasUserId));
		log.info("REST url : "+url);
		
		JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
		if(obj != null && obj.has("entity")){
			obj = obj.getJSONObject("entity");
		}
		
		return getUserAwardFromJSON(obj);
	}
	
	public UserAward getLetter(long canvasUserId, long courseId) 
		throws SystemException{
		/*return userAwardPersistence.fetchByCUID_CID_L(
			canvasUserId, courseId, true);*/
		
		//REST call to MongoDB
		UserAward award = getUserAward(canvasUserId, courseId);
		if(award == null){
			log.info("Reading from PostgreSQL");
			return userAwardPersistence.fetchByCUID_CID_L(
					canvasUserId, courseId, true);
		}
		return award;
	}
	
	public UserAward getUserAward(String certId) throws SystemException {
		return userAwardPersistence.fetchByCertID(certId);
	}
	
	
	public List<UserAward> findByCanvasUserId(long canvasUserId)
			throws SystemException {
		//REST call
		String url = REST_HOST.concat(GET_USERAWARD_BY_CANVASUSERID).concat(String.valueOf(canvasUserId));
		log.info("REST url : "+url);
		
		return getUserAwardsFromURL(url) == null ? userAwardLocalService.findByCanvasUserId(canvasUserId) : getUserAwardsFromURL(url);
	}
	private List<UserAward> getUserAwardsFromURL(String url) {
		List<UserAward> userAwards = new ArrayList<UserAward>();
		JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
		if(obj != null && obj.has("entities")){
			JSONArray array = obj.getJSONArray("entities");
			if(array != null && array.length() > 0){
				for(int i=0; i<array.length(); i++){
					userAwards.add(getUserAwardFromJSON(array.getJSONObject(i)));
				}
			}else{
				log.info("Couldn't find UserAward from MongoDB");
			}
		}else{
			log.info("Couldn't find UserAward from MongoDB");
		}
		return userAwards;
	}

	private UserAward getUserAwardFromJSON(JSONObject obj) {
		UserAward award = new UserAwardImpl();
		
		if(obj != null){
			DateFormat sdf = DateFormatFactoryUtil.getSimpleDateFormat("MM/dd/yyyy");
			
			award.setCanvasUserId(obj.getLong("canvasUserId"));
			award.setCertId(obj.getString("certId"));
			award.setCourseId(obj.getLong("courseId"));
			if(obj.getString("createDate") != null && StringUtils.isNotEmpty(obj.getString("createDate"))){
				try {
					award.setCreateDate( sdf.parse(obj.getString("createDate")));
				} catch (ParseException e) {
					log.error("Exception in parsing date");
					log.error(e);
				}
			}
			award.setExternalId(obj.getLong("externalId"));
			award.setId(obj.getLong("id"));
			award.setLetter(obj.getBoolean("letter"));
			
		}else{
			log.info("No UserAward data found from MongoDB");
		}
		return award;
	}

	/**
	 * This method merges certificates and letters of fromCanvasUserId into toCanvasUserId
	 */
	public List<UserAward> mergeUserAwards(long companyId, long fromCanvasUserId, long toCanvasUserId) throws SystemException, PortalException {
		
		long targetLRUserId = UtilityLocalServiceUtil.getEntityId(companyId, User.class.getName(), CiscoConstants.EXPANDO_CANVAS_USER_ID, String.valueOf(toCanvasUserId));
		
		List<UserAward> toUserAwardsList = new ArrayList<UserAward>();
		//List<UserAward> fromUserAwardsList = userAwardPersistence.findByCanvasUserId(fromCanvasUserId);
		
		//REST call
		List<UserAward> fromUserAwardsList = findByCanvasUserId(fromCanvasUserId);
		if(fromUserAwardsList == null){
			log.info("Reading from PostgreSQL");
			fromUserAwardsList = userAwardPersistence.findByCanvasUserId(fromCanvasUserId);
		}
		
		try {
			for (UserAward fromUserAward : fromUserAwardsList) {

				String type = fromUserAward.isLetter()? "Letter" : "Certificate";
				
				log.info("Copying " + type + " linked to course " + fromUserAward.getCourseId() + " with id: " + fromUserAward.getId()
						+ " and filename: " + fromUserAward.getCertId());

				// Check if the same certificate for the courseId exists in the toUser.
				//UserAward existingUserAward = userAwardPersistence.fetchByCourseId(fromUserAward.getCourseId(), toCanvasUserId);
				
				//REST call
				UserAward existingUserAward = fetchByCourseId(fromUserAward.getCourseId(), toCanvasUserId);
				if (existingUserAward == null){
					log.info("Reading from PostgreSQL");
					existingUserAward = userAwardPersistence.fetchByCourseId(fromUserAward.getCourseId(), toCanvasUserId);
				}
				// If its not duplicate only then we will add that certificate.
				if (existingUserAward == null || existingUserAward.isLetter() == fromUserAward.isLetter()) {
					UserAward toUserAward = (UserAward) fromUserAward.clone();
					long id = CounterLocalServiceUtil.increment(UserAward.class.getName());
					toUserAward.setId(id);
					toUserAward.setCanvasUserId(toCanvasUserId);
					
					// Create a copy of the generated certificate/letter under target user and copy the updated file name
					// to the copied userAward entry
					File fromAwardFile = AwardLocalServiceUtil.getExistingFile(fromUserAward, companyId);
					boolean isFileReadError = false;
					
					FileInputStream fis = null;
					try {
						fis = new FileInputStream(fromAwardFile);
					} catch (FileNotFoundException fnfe) {
						log.error("Unable to find file " + fromAwardFile.getName(), fnfe);
						isFileReadError = true;
					}
					
					if (!isFileReadError) {
						// the filename will be of the format '<fromUserId>/<awardName>.pdf'
						String originalFilename = fromUserAward.getCertId();
						int slashIndex = originalFilename.indexOf('/');
						if (slashIndex > 0) {
							originalFilename = originalFilename.substring(slashIndex + 1, originalFilename.length());
						}
						
						// the newFilename will be now of the format '<toUserId>/<awardName>.pdf'
						String newFileName = AwardLocalServiceUtil.addFileToDL(companyId, fis, originalFilename, toCanvasUserId);
						toUserAward.setCertId(newFileName);
						
						log.debug("Added " + type + " " + newFileName + " to LR user " + targetLRUserId);
					}
					
					//userAwardLocalService.addUserAward(toUserAward);
					
					//REST call
					updateUserAward(toUserAward);
					
					toUserAwardsList.add(toUserAward);
				
				} else {
					log.info("A duplicate " + type + " already have it with courseId :: " + fromUserAward.getCourseId() + ". Skiping this certificate." );
				}
			}
		} catch (Exception e) {
			// If an exception occurs half the way in coping the awards (e.g after 2 out of 5), call the revert methods to
			// delete the partially copied award files before throwing the error (as this cannot be triggered from main merge method)
			if (!toUserAwardsList.isEmpty()) {
				revertUserAwards(companyId, toCanvasUserId, toUserAwardsList);
			}
			
			if (e instanceof SystemException) {
				throw (SystemException) e;
			} else {
				new SystemException(e);
			}
		}
		
		return toUserAwardsList;
	}
	
	/**
	 * This method will be executed when the call to canvas fails and we need to remove the copies of files created in repository.
	 * 
	 * @param companyId
	 * @param toCanvasUserId
	 */
	public void revertUserAwards(long companyId, long toCanvasUserId, List<UserAward> toUserAwardsList) throws SystemException, PortalException {
		if (toUserAwardsList != null) {
			for (UserAward toUserAward : toUserAwardsList) {
				DLStoreUtil.deleteFile(companyId, CompanyConstants.SYSTEM, toUserAward.getCertId());
				log.info("Deleting file: " + toUserAward.getCertId() + " from canvas user: " + toCanvasUserId + " for rolling back the transaction");
			}
		} else {
			log.info("There are no files to be reverted.. for the canvasuserId :"+toCanvasUserId);
		}
	}
	
	public UserAward updateUserAward(UserAward userAward)
			throws SystemException {
		//return userAwardPersistence.update(userAward);
		
		UserAward award = null;
		
		if(CiscoConstants.MODE_WRITE_DUAL.equals(CiscoConstants.WRITE_MODE) || 
				(CiscoConstants.MODE_WRITE_SINGLE.equals(CiscoConstants.WRITE_MODE) && 
				CiscoConstants.DB_WRITE_POSTGRES.equals(CiscoConstants.DATABASE_TO_WRITE))){

			// write data to postgres
			long processStartTime = new Date().getTime();
			award = userAwardPersistence.update(userAward);
			long processEndTime = new Date().getTime();
			log.info("Time take by Liferay service is : "+(processEndTime-processStartTime)+ " milliseconds");
		}
		
		if(CiscoConstants.MODE_WRITE_DUAL.equals(CiscoConstants.WRITE_MODE) ||
				(CiscoConstants.MODE_WRITE_SINGLE.equals(CiscoConstants.WRITE_MODE) && 
				CiscoConstants.DB_WRITE_MONGO.equals(CiscoConstants.DATABASE_TO_WRITE))){
			
			//REST call
			String url = REST_HOST.concat(SAVE_USERAWARD);
			log.info("REST url : "+url);
			// write data only to MongoDB
			saveDataToMongoDB(userAward, url);
		}
		return award;
	}
	
	private void saveDataToMongoDB(UserAward userAward, String url)
			throws SystemException {
		int statusCode = 0;
		try {
			statusCode = CanvasApiUtils.postDataToMongoDB(url, userAward);
			if(statusCode != 200){ 
				//if REST status is not 200 ok, then throw SystemException - Dual write transaction mgmt.
				log.info("Save UserAward TRANSACTION FAILED. STATUS CODE FROM REST IS : "+statusCode);
				 throw new SystemException();
			}else{
				log.info("Save UserAward TRANSACTION SUCCESS. STATUS CODE FROM REST IS : "+statusCode);
			}
		} catch (ConnectException e) {
			log.info("Save UserAward TRANSACTION FAILED. STATUS CODE FROM REST IS : "+statusCode);
			 throw new SystemException();
		} catch (ClientProtocolException e) {
			log.error(e);
			throw new SystemException();
		} catch (IOException e) {
			log.error(e);
			throw new SystemException();
		}
	}
	
	public UserAward fetchByCourseId(long courseId, long canvasUserId)
			throws SystemException {
		
		//REST call
		String url = REST_HOST.concat(GET_USERAWARD_BY_COURSEID_CANVASUSERID.replace("courseId", String.valueOf(courseId)))
				.concat(String.valueOf(canvasUserId));
		log.info("REST url : "+url);
		JSONObject obj = CanvasApiUtils.getJSONObjectFromUrl(url);
		if(obj != null && obj.has("entity")){
			obj = obj.getJSONObject("entity");
		}
		
		return getUserAwardFromJSON(obj);	
	}
	
	private static Log log = LogFactoryUtil.getLog(UserAwardLocalServiceImpl.class);
	
	private static final String REST_HOST = PortletProps.get("rest.api.host");
	private static final String GET_CERTIFICATE = PortletProps.get("rest.api.url.get.certificate");
	private static final String SAVE_USERAWARD = PortletProps.get("rest.api.url.save.useraward");
	private static final String GET_USERAWARD_BY_CANVASUSERID = PortletProps.get("rest.api.url.get.useraward.by.canvasuserid");
	private static final String GET_USERAWARD_BY_COURSEID_CANVASUSERID = PortletProps.get("rest.api.url.get.useraward.by.courseid.canvasuserid");
}