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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AwardLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AwardLocalService
 * @generated
 */
public class AwardLocalServiceWrapper implements AwardLocalService,
	ServiceWrapper<AwardLocalService> {
	public AwardLocalServiceWrapper(AwardLocalService awardLocalService) {
		_awardLocalService = awardLocalService;
	}

	/**
	* Adds the award to the database. Also notifies the appropriate model listeners.
	*
	* @param award the award
	* @return the award that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.Award addAward(
		com.instructure.canvas.model.Award award)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.addAward(award);
	}

	/**
	* Creates a new award with the primary key. Does not add the award to the database.
	*
	* @param awardId the primary key for the new award
	* @return the new award
	*/
	@Override
	public com.instructure.canvas.model.Award createAward(long awardId) {
		return _awardLocalService.createAward(awardId);
	}

	/**
	* Deletes the award with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param awardId the primary key of the award
	* @return the award that was removed
	* @throws PortalException if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.Award deleteAward(long awardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.deleteAward(awardId);
	}

	/**
	* Deletes the award from the database. Also notifies the appropriate model listeners.
	*
	* @param award the award
	* @return the award that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.Award deleteAward(
		com.instructure.canvas.model.Award award)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.deleteAward(award);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _awardLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.instructure.canvas.model.Award fetchAward(long awardId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.fetchAward(awardId);
	}

	/**
	* Returns the award with the primary key.
	*
	* @param awardId the primary key of the award
	* @return the award
	* @throws PortalException if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.Award getAward(long awardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.getAward(awardId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.instructure.canvas.model.Award> getAwards(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.getAwards(start, end);
	}

	/**
	* Returns the number of awards.
	*
	* @return the number of awards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAwardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.getAwardsCount();
	}

	/**
	* Updates the award in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param award the award
	* @return the award that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.instructure.canvas.model.Award updateAward(
		com.instructure.canvas.model.Award award)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.updateAward(award);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _awardLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_awardLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _awardLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.instructure.canvas.model.Award addAward(java.lang.String cvlId,
		java.lang.String cvlName, double score, long certificateArticleId,
		long letterArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.addAward(cvlId, cvlName, score,
			certificateArticleId, letterArticleId);
	}

	@Override
	public void deactivateAward(long awardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_awardLocalService.deactivateAward(awardId);
	}

	@Override
	public java.lang.String generate18CharId(java.lang.String id) {
		return _awardLocalService.generate18CharId(id);
	}

	@Override
	public java.util.List<com.instructure.canvas.model.Award> getActiveAwards()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.getActiveAwards();
	}

	@Override
	public com.instructure.canvas.model.Award getAwardByCVLId(
		java.lang.String cvlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.getAwardByCVLId(cvlId);
	}

	@Override
	public com.instructure.canvas.model.Award getAwardByCVLName(
		java.lang.String cvlName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.getAwardByCVLName(cvlName);
	}

	@Override
	public java.io.File getCertificate(long canvasUserId, long courseId,
		java.util.Map<java.lang.String, java.lang.String> variables,
		java.lang.String languageId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _awardLocalService.getCertificate(canvasUserId, courseId,
			variables, languageId, themeDisplay);
	}

	@Override
	public java.io.File getLetter(long canvasUserId, long courseId,
		java.util.Map<java.lang.String, java.lang.String> variables,
		java.lang.String languageId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _awardLocalService.getLetter(canvasUserId, courseId, variables,
			languageId, themeDisplay);
	}

	@Override
	public java.lang.String addFileToDL(long companyId, java.io.InputStream is,
		java.lang.String fileName, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _awardLocalService.addFileToDL(companyId, is, fileName, userId);
	}

	@Override
	public java.io.File getExistingFile(
		com.instructure.canvas.model.UserAward userAward, long companyId) {
		return _awardLocalService.getExistingFile(userAward, companyId);
	}

	@Override
	public java.lang.String getAllCertsForInstructor(
		java.lang.String instructorUserId, java.lang.String courseId) {
		return _awardLocalService.getAllCertsForInstructor(instructorUserId,
			courseId);
	}

	@Override
	public java.lang.String getAllLettersForInstructor(
		java.lang.String instructorUserId, java.lang.String courseId) {
		return _awardLocalService.getAllLettersForInstructor(instructorUserId,
			courseId);
	}

	@Override
	public java.lang.String getZipFileLocation(
		java.lang.String instructorUserId, java.lang.String courseId,
		java.lang.String type) {
		return _awardLocalService.getZipFileLocation(instructorUserId,
			courseId, type);
	}

	@Override
	public long getRequiredAssignmentId(long courseId, java.lang.String cmd) {
		return _awardLocalService.getRequiredAssignmentId(courseId, cmd);
	}

	@Override
	public com.instructure.canvas.model.Award getAward(long awardId,
		java.lang.String cvlId) {
		return _awardLocalService.getAward(awardId, cvlId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AwardLocalService getWrappedAwardLocalService() {
		return _awardLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAwardLocalService(AwardLocalService awardLocalService) {
		_awardLocalService = awardLocalService;
	}

	@Override
	public AwardLocalService getWrappedService() {
		return _awardLocalService;
	}

	@Override
	public void setWrappedService(AwardLocalService awardLocalService) {
		_awardLocalService = awardLocalService;
	}

	private AwardLocalService _awardLocalService;
}