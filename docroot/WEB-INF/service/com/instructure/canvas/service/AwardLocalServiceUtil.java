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

package com.instructure.canvas.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Award. This utility wraps
 * {@link com.instructure.canvas.service.impl.AwardLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AwardLocalService
 * @see com.instructure.canvas.service.base.AwardLocalServiceBaseImpl
 * @see com.instructure.canvas.service.impl.AwardLocalServiceImpl
 * @generated
 */
public class AwardLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.instructure.canvas.service.impl.AwardLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the award to the database. Also notifies the appropriate model listeners.
	*
	* @param award the award
	* @return the award that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Award addAward(
		com.instructure.canvas.model.Award award)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAward(award);
	}

	/**
	* Creates a new award with the primary key. Does not add the award to the database.
	*
	* @param awardId the primary key for the new award
	* @return the new award
	*/
	public static com.instructure.canvas.model.Award createAward(long awardId) {
		return getService().createAward(awardId);
	}

	/**
	* Deletes the award with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param awardId the primary key of the award
	* @return the award that was removed
	* @throws PortalException if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Award deleteAward(long awardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAward(awardId);
	}

	/**
	* Deletes the award from the database. Also notifies the appropriate model listeners.
	*
	* @param award the award
	* @return the award that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Award deleteAward(
		com.instructure.canvas.model.Award award)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAward(award);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.instructure.canvas.model.Award fetchAward(long awardId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAward(awardId);
	}

	/**
	* Returns the award with the primary key.
	*
	* @param awardId the primary key of the award
	* @return the award
	* @throws PortalException if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Award getAward(long awardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAward(awardId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the awards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.instructure.canvas.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of awards
	* @param end the upper bound of the range of awards (not inclusive)
	* @return the range of awards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.instructure.canvas.model.Award> getAwards(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAwards(start, end);
	}

	/**
	* Returns the number of awards.
	*
	* @return the number of awards
	* @throws SystemException if a system exception occurred
	*/
	public static int getAwardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAwardsCount();
	}

	/**
	* Updates the award in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param award the award
	* @return the award that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.instructure.canvas.model.Award updateAward(
		com.instructure.canvas.model.Award award)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAward(award);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.instructure.canvas.model.Award addAward(
		java.lang.String cvlId, java.lang.String cvlName, double score,
		long certificateArticleId, long letterArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAward(cvlId, cvlName, score, certificateArticleId,
			letterArticleId);
	}

	public static void deactivateAward(long awardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deactivateAward(awardId);
	}

	public static java.lang.String generate18CharId(java.lang.String id) {
		return getService().generate18CharId(id);
	}

	public static java.util.List<com.instructure.canvas.model.Award> getActiveAwards()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActiveAwards();
	}

	public static com.instructure.canvas.model.Award getAwardByCVLId(
		java.lang.String cvlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAwardByCVLId(cvlId);
	}

	public static com.instructure.canvas.model.Award getAwardByCVLName(
		java.lang.String cvlName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAwardByCVLName(cvlName);
	}

	public static java.io.File getCertificate(long canvasUserId, long courseId,
		java.util.Map<java.lang.String, java.lang.String> variables,
		java.lang.String languageId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .getCertificate(canvasUserId, courseId, variables,
			languageId, themeDisplay);
	}

	public static java.io.File getLetter(long canvasUserId, long courseId,
		java.util.Map<java.lang.String, java.lang.String> variables,
		java.lang.String languageId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .getLetter(canvasUserId, courseId, variables, languageId,
			themeDisplay);
	}

	public static java.lang.String addFileToDL(long companyId,
		java.io.InputStream is, java.lang.String fileName, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addFileToDL(companyId, is, fileName, userId);
	}

	public static java.io.File getExistingFile(
		com.instructure.canvas.model.UserAward userAward, long companyId) {
		return getService().getExistingFile(userAward, companyId);
	}

	public static java.lang.String getAllCertsForInstructor(
		java.lang.String instructorUserId, java.lang.String courseId) {
		return getService().getAllCertsForInstructor(instructorUserId, courseId);
	}

	public static java.lang.String getAllLettersForInstructor(
		java.lang.String instructorUserId, java.lang.String courseId) {
		return getService()
				   .getAllLettersForInstructor(instructorUserId, courseId);
	}

	public static java.lang.String getZipFileLocation(
		java.lang.String instructorUserId, java.lang.String courseId,
		java.lang.String type) {
		return getService().getZipFileLocation(instructorUserId, courseId, type);
	}

	public static long getRequiredAssignmentId(long courseId,
		java.lang.String cmd) {
		return getService().getRequiredAssignmentId(courseId, cmd);
	}

	public static com.instructure.canvas.model.Award getAward(long awardId,
		java.lang.String cvlId) {
		return getService().getAward(awardId, cvlId);
	}

	public static void clearService() {
		_service = null;
	}

	public static AwardLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AwardLocalService.class.getName());

			if (invokableLocalService instanceof AwardLocalService) {
				_service = (AwardLocalService)invokableLocalService;
			}
			else {
				_service = new AwardLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AwardLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AwardLocalService service) {
	}

	private static AwardLocalService _service;
}