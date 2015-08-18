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

package com.instructure.canvas.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the CanvasUser service. Represents a row in the &quot;CANVAS_CanvasUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CanvasUserModel
 * @see com.instructure.canvas.model.impl.CanvasUserImpl
 * @see com.instructure.canvas.model.impl.CanvasUserModelImpl
 * @generated
 */
public interface CanvasUser extends CanvasUserModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.instructure.canvas.model.impl.CanvasUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
}