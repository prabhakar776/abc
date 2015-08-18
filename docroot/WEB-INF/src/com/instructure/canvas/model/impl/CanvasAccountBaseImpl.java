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

import com.instructure.canvas.model.CanvasAccount;
import com.instructure.canvas.service.CanvasAccountLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the CanvasAccount service. Represents a row in the &quot;CANVAS_CanvasAccount&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CanvasAccountImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanvasAccountImpl
 * @see com.instructure.canvas.model.CanvasAccount
 * @generated
 */
public abstract class CanvasAccountBaseImpl extends CanvasAccountModelImpl
	implements CanvasAccount {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a canvas account model instance should use the {@link CanvasAccount} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CanvasAccountLocalServiceUtil.addCanvasAccount(this);
		}
		else {
			CanvasAccountLocalServiceUtil.updateCanvasAccount(this);
		}
	}
}