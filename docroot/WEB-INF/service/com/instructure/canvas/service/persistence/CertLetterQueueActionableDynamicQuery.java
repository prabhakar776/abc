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

package com.instructure.canvas.service.persistence;

import com.instructure.canvas.model.CertLetterQueue;
import com.instructure.canvas.service.CertLetterQueueLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class CertLetterQueueActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CertLetterQueueActionableDynamicQuery() throws SystemException {
		setBaseLocalService(CertLetterQueueLocalServiceUtil.getService());
		setClass(CertLetterQueue.class);

		setClassLoader(com.instructure.canvas.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("id");
	}
}