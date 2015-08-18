package com.instructure.canvas.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * User: Sten Martinez
 * Date: 2/8/13
 * Time: 9:42 AM
 */
public class CanvasURLConnectionFactory {

	private static String token = PropsUtil.get("canvas.token");
	private static String baseUrl = PropsUtil.get("canvas.base.url");

	public static HttpURLConnection getCanvasURL(String apiURL, String params) throws IOException {
		return getCanvasURL(apiURL, params, null);
	}

	/**
	 * Get the canvas url, which is having all the parameters and base url is appended already.
	 * 
	 * @param nextPageUrl the next page url.
	 * @return the HttpURLConnection.
	 * @throws IOException the Input Output Exception.
	 */
	public static HttpURLConnection getCanvasURL(String nextPageUrl) throws IOException {
		if (Validator.isNotNull(nextPageUrl)) {
			URL canvasUrl = new URL(nextPageUrl);

			HttpURLConnection urlc = (HttpURLConnection) canvasUrl.openConnection();
			urlc.addRequestProperty("Authorization", "Bearer " + token);
			return urlc;
		} else {
			return null;
		}
	}
	
	public static HttpURLConnection getCanvasURL(String apiURL, String params, String userToken) throws IOException {
		String targetURL = baseUrl + apiURL;
		if (Validator.isNotNull(params)) {
			targetURL += "?" + params;
		}
		
		if (log.isDebugEnabled()) {
			log.debug("Invoked complete Canvas URL: " + targetURL);
		}

		URL canvasUrl = new URL(targetURL);

		HttpURLConnection urlc = (HttpURLConnection) canvasUrl.openConnection();
		
		if (Validator.isNotNull(userToken)) {
			urlc.addRequestProperty("Authorization", "Bearer " + userToken);
		} else {
			urlc.addRequestProperty("Authorization", "Bearer " + token);
		}

		return urlc;
	}

	private static final Log log = LogFactoryUtil.getLog(CanvasURLConnectionFactory.class);
}