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

package com.instructure.canvas.service.http;

import com.instructure.canvas.service.UserAwardServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.instructure.canvas.service.UserAwardServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.instructure.canvas.model.UserAwardSoap}.
 * If the method in the service utility returns a
 * {@link com.instructure.canvas.model.UserAward}, that is translated to a
 * {@link com.instructure.canvas.model.UserAwardSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAwardServiceHttp
 * @see com.instructure.canvas.model.UserAwardSoap
 * @see com.instructure.canvas.service.UserAwardServiceUtil
 * @generated
 */
public class UserAwardServiceSoap {
	public static com.instructure.canvas.model.UserAwardSoap getCertificate(
		long canvasUserId, long courseId) throws RemoteException {
		try {
			com.instructure.canvas.model.UserAward returnValue = UserAwardServiceUtil.getCertificate(canvasUserId,
					courseId);

			return com.instructure.canvas.model.UserAwardSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.instructure.canvas.model.UserAwardSoap getLetter(
		long canvasUserId, long courseId) throws RemoteException {
		try {
			com.instructure.canvas.model.UserAward returnValue = UserAwardServiceUtil.getLetter(canvasUserId,
					courseId);

			return com.instructure.canvas.model.UserAwardSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.instructure.canvas.model.UserAwardSoap[] findByCanvasUserId(
		long canvasUserId) throws RemoteException {
		try {
			java.util.List<com.instructure.canvas.model.UserAward> returnValue = UserAwardServiceUtil.findByCanvasUserId(canvasUserId);

			return com.instructure.canvas.model.UserAwardSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.instructure.canvas.model.UserAwardSoap[] mergeUserAwards(
		long companyId, long fromCanvasUserId, long toCanvasUserId)
		throws RemoteException {
		try {
			java.util.List<com.instructure.canvas.model.UserAward> returnValue = UserAwardServiceUtil.mergeUserAwards(companyId,
					fromCanvasUserId, toCanvasUserId);

			return com.instructure.canvas.model.UserAwardSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.instructure.canvas.model.UserAwardSoap updateUserAward(
		com.instructure.canvas.model.UserAwardSoap userAward)
		throws RemoteException {
		try {
			com.instructure.canvas.model.UserAward returnValue = UserAwardServiceUtil.updateUserAward(com.instructure.canvas.model.impl.UserAwardModelImpl.toModel(
						userAward));

			return com.instructure.canvas.model.UserAwardSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.instructure.canvas.model.UserAwardSoap fetchByCourseId(
		long courseId, long canvasUserId) throws RemoteException {
		try {
			com.instructure.canvas.model.UserAward returnValue = UserAwardServiceUtil.fetchByCourseId(courseId,
					canvasUserId);

			return com.instructure.canvas.model.UserAwardSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UserAwardServiceSoap.class);
}