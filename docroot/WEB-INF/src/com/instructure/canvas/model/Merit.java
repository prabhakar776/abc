package com.instructure.canvas.model;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Created with IntelliJ IDEA.
 * User: gabriel
 * Date: 11/16/12
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Merit {

	public String getIdentifier(){
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	protected String identifier;

	private static Log _log = LogFactoryUtil.getLog(Merit.class);
}