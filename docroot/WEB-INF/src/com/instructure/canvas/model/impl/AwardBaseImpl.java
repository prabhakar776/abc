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

package com.instructure.canvas.model.impl;

import com.instructure.canvas.model.Award;
import com.instructure.canvas.service.AwardLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Award service. Represents a row in the &quot;CANVAS_Award&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AwardImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AwardImpl
 * @see com.instructure.canvas.model.Award
 * @generated
 */
public abstract class AwardBaseImpl extends AwardModelImpl implements Award {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a award model instance should use the {@link Award} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AwardLocalServiceUtil.addAward(this);
		}
		else {
			AwardLocalServiceUtil.updateAward(this);
		}
	}
}