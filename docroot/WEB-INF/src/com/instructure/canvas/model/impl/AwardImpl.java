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

package com.instructure.canvas.model.impl;

import com.liferay.portal.kernel.util.StringBundler;

/**
 * The extended model implementation for the Award service. Represents a row in the &quot;CANVAS_Award&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.instructure.canvas.model.Award} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class AwardImpl extends AwardBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a award model instance should use the {@link com.instructure.canvas.model.Award} interface instead.
	 */
	public AwardImpl() {
	}
	
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{\"awardId\":");
		sb.append(getAwardId());
		sb.append(", \"cvlId\":\"");
		sb.append(getCvlId());
		sb.append("\", \"cvlName\":\"");
		sb.append(getCvlName());
		sb.append("\", \"score\":");
		sb.append(getScore());
		sb.append(", \"letterArticleId\":");
		sb.append(getLetterArticleId());
		sb.append(", \"certificateArticleId\":");
		sb.append(getCertificateArticleId());
		sb.append(", \"active\":");
		sb.append(getActive());
		sb.append(", \"createDate\":\"");
		sb.append(getCreateDate());
		sb.append("\", \"modifiedDate\":\"");
		sb.append(getModifiedDate());
		sb.append("\"}");

		return sb.toString();
	}
}