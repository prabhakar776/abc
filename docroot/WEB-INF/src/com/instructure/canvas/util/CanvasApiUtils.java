package com.instructure.canvas.util;

import com.cisco.utility.service.OAuthToken;
import com.cisco.utility.service.OAuthTokenService;
import com.instructure.canvas.model.Award;
import com.instructure.canvas.model.Course;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class CanvasApiUtils {

	private static String baseUrl = PropsUtil.get("canvas.base.url");

	public static int getApiPageCount(String linkHeader) {
		int relLastIndex = -1;
		int lastPage = -1;

		if (linkHeader != null) {
			relLastIndex = linkHeader.lastIndexOf(StringPool.COMMA);
		}

		if (relLastIndex == -1) {
			// the results do not have multiple pages (only 1 page)
			int relFirstIndex = linkHeader.lastIndexOf("rel=\"first\"");

			// make sure there is at least one page
			if (relFirstIndex != -1) {
				// since there is only 1 page, start from 0
				relLastIndex = 0;
			}
		}

		if (relLastIndex != -1) {
			int pageFromIndex = linkHeader.indexOf(PAGE_MARKER_2, relLastIndex);

			if (pageFromIndex == -1) {
				pageFromIndex = linkHeader.indexOf(PAGE_MARKER_1, relLastIndex);
			}

			int pageToIndex = linkHeader.indexOf(StringPool.AMPERSAND, pageFromIndex + 1);

			if (pageToIndex == -1) {
				pageToIndex = linkHeader.indexOf('>', pageFromIndex);
			}

			if (pageFromIndex != -1 && pageToIndex != -1) {
				String lastPageString = linkHeader.substring(pageFromIndex + PAGE_MARKER_1.length(), pageToIndex);

				lastPage = GetterUtil.getInteger(lastPageString);
			}
		}
		return lastPage;
	}
	
	public static Date getDateFromCanvasString(String dateString) {
		if (Validator.isNotNull(dateString)) {
			try {
				DateTimeFormatter isoDateFormat = ISODateTimeFormat.dateTimeNoMillis();
				return isoDateFormat.parseDateTime(dateString).toDate();
			} catch (Exception e) {
				log.error("Error parsing date string: " + dateString + " | Error Msg: " + e.getMessage());
			}
		}
		return null;
	}

	public static int getApiPageCountWithRegex(String linkHeader) {
		try {
			Matcher matcher = pagePattern.matcher(linkHeader);
			return matcher.find() ? Integer.parseInt(matcher.group(1)) : 1;
		} catch (Exception e) {
			log.error("linkHeader: " + linkHeader + ", " + e);
		}
		return 1;
	}

	/**
	 * Get the next page url from the link header.
	 * 
	 * @param linkHeader the link header.
	 * @return the next page url.
	 */
	public static String getNextPageURLUsingRegEx(String linkHeader) {
		if (linkHeader != null) {
			Matcher matcher = nextPagePattern.matcher(linkHeader);
			return matcher.find() ? matcher.group(1) : "";
		} else {
			return null;
		}
	}
	
	/**
	 * Overloaded method which passes the params separately.
	 */
	public static JSONArray getAllPagesOfCanvasAPI(String apiURLStr, String params) throws IOException {
		if (Validator.isNotNull(params)) {
			return getAllPagesOfCanvasAPI(apiURLStr + StringPool.QUESTION + params);
		} else {
			return getAllPagesOfCanvasAPI(apiURLStr);
		}
	}
	
	/**
	 * This method fetches all pages of a Canvas API URL
	 * Invoke it with full canvas API URL with all URL parameters.
	 * Do not specify per_page or page_num parameters in the URL
	 */
	public static JSONArray getAllPagesOfCanvasAPI(String apiURLStr) throws IOException {
		// Start do-while loop with given URL
		String nextPageURL = baseUrl + apiURLStr;
		
		JSONArray apiJSONOutput = JSONFactoryUtil.createJSONArray();
		int pageNum = 0;
		long methodStartTime = System.currentTimeMillis();
		
		// set the initial per page count to a max value so that Canvas don't just pick the 10 per page count and end in multiple iteration
		if (apiURLStr.contains(StringPool.QUESTION)) {
			nextPageURL += "&per_page=999";
		} else {
			nextPageURL += "?per_page=999";
		}
		
		do {
			pageNum++;
			
			long startTime = System.currentTimeMillis();
			HttpURLConnection urlc = CanvasURLConnectionFactory.getCanvasURL(nextPageURL);
	
			UnsyncBufferedReader bufferedReader = new UnsyncBufferedReader(new InputStreamReader(urlc.getInputStream()));
	
			StringBuilder httpResponse = new StringBuilder();
			String line;
	
			while ((line = bufferedReader.readLine()) != null) {
				httpResponse.append(line);
			}
	
			if (log.isDebugEnabled()) {
				log.debug("Raw JSON Response:\n" + httpResponse + "\n");
				
				log.debug(nextPageURL + ": took " + (new Date().getTime() - startTime) + " ms" );
			}
			
			nextPageURL = getNextPageURLUsingRegEx(urlc.getHeaderField("Link"));
			
			try {
				JSONArray thisPageOutput = null;
				
				// certain API calls returns only a single JSON object and not an array
				// (wraping it in a JSON array as the return type of the method is always an array)
				if (httpResponse.indexOf("[") == 0) {
					thisPageOutput = JSONFactoryUtil.createJSONArray(httpResponse.toString());
				} else {
					thisPageOutput = JSONFactoryUtil.createJSONArray();
					thisPageOutput.put(JSONFactoryUtil.createJSONObject(httpResponse.toString()));
				}
				
				/* 
				 * Append output of this page to overall api output
				 * Optimization: Avoid copying of JSON Array into output JSON array for page 1
				 */
				if (pageNum == 1) {
					// If we are on page 1
					// Set this page's output as final output.
					apiJSONOutput = thisPageOutput;
				} else {
					// Append this page output to final output
					for (int i = 0; i < thisPageOutput.length(); i++) {
						apiJSONOutput.put(thisPageOutput.getJSONObject(i));
					}
				}
			} catch (JSONException e) {
				log.error("Error constructing JSON object for canvas API URL: " + nextPageURL + " with response: " + httpResponse, e);
			} finally {
				try {
					bufferedReader.close();
					urlc.disconnect();
				} catch (Exception e) {
					log.error("Error closing connections", e);
				}
			}
		} while (Validator.isNotNull(nextPageURL));
		
		log.info(apiURLStr + ": took " + (System.currentTimeMillis() - methodStartTime) + " ms to fetch " + pageNum + " page(s)");

		return apiJSONOutput;
	}

	public static JSONObject getJSONObjectFromUrl(String url) {
		InputStream is = null;
		String json = "";
		long processStartTime = 0; 
		JSONObject jObj = null;
		
	    // Making HTTP request
	    try {
	    	//get OAuth token
			OAuthToken token = OAuthTokenService.getValidAccessToken();
			log.info("-------------  OAuth token from URL : "+token.getAccessToken());
	    	
	        // defaultHttpClient
	    	HttpParams params = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(params, 5000);
			params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
			HttpClient httpClient = new DefaultHttpClient(params);
			
	        HttpGet httpGet = new HttpGet(url);
	        httpGet.setHeader("Authorization", "Bearer ".concat(token.getAccessToken()));
	        httpGet.setHeader("Accept", "*/*");

	        processStartTime = new Date().getTime();
	        HttpResponse httpResponse = httpClient.execute(httpGet);
	        long processEndTime = new Date().getTime();
	        
	        HttpEntity httpEntity = httpResponse.getEntity();
	        StatusLine statusLine = httpResponse.getStatusLine();
	        is = httpEntity.getContent();
	        
	        
		    log.info("Time take by REST service is : "+(processEndTime-processStartTime)+ " milliseconds");
	        
		    json = convertStreamToString(is);
		    
		    if(json != null && statusLine.getStatusCode() == 200){
		    	
			    //JSONArray jsonArray = null;
			    // try parse the string to a JSON array
			    try {
			    	
			    	jObj = JSONFactoryUtil.createJSONObject(json);
			    	//jObj = jObj.getJSONObject("entity");
			    	
				} catch (JSONException e) {
					log.error(e.toString());
					e.printStackTrace();
				}
		    }else{
		    	log.info("No Data found from MongoDB, Status code is "+statusLine.getStatusCode());
		    }
	        
	    } catch (UnsupportedEncodingException e) {
	       log.error(e);
	    } catch (ClientProtocolException e) {
	    	log.error(e);
	    } catch (IOException e) {
	    	log.error(e);
	    } catch (Exception e1) {
	    	log.error(e1);
		}
	    
	    
		// return JSON String
	    return jObj;

	}
	
	public static String convertStreamToString(InputStream is) throws UnsupportedEncodingException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        try{
            while ((line = reader.readLine()) != null){
                    sb.append(line + "\n");
            } 
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return sb.toString();
	}
	
	public static int postDataToMongoDB(String url, Object obj) throws ClientProtocolException, IOException, ConnectException{
		
		//get OAuth token
		OAuthToken token = null;
		try {
			token = OAuthTokenService.getValidAccessToken();
			log.info("-------------  OAuth token from URL : "+token.getAccessToken());
		} catch (Exception e) {
			log.error(e);
		}

		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, 5000);
		params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		HttpClient httpclient = new DefaultHttpClient(params);
		
		HttpPost post = new HttpPost(url);
	    post.setHeader("Content-type", "application/json");
	    post.setHeader("Authorization", "Bearer ".concat(token.getAccessToken()));
	    post.setHeader("Accept", "*/*");
	    post.setEntity(new StringEntity(obj.toString(), "UTF-8"));
    	log.info("json : "+obj.toString());
	    
	    
	    long processStartTime = new Date().getTime();
	    HttpResponse httpresponse = httpclient.execute(post);
	    long processEndTime = new Date().getTime();
	    
	    HttpEntity entity = httpresponse.getEntity();
	    InputStream stream = entity.getContent();
	   
	    String result = convertStreamToString(stream);
	    StatusLine statusLine = httpresponse.getStatusLine();
	    
	    if(result != null && statusLine.getStatusCode() == 200){
			log.info("created/updated in MongoDB with primary key "+obj.hashCode());
			log.info("Time take by REST service to create/update is : "+(processEndTime-processStartTime)+ " milliseconds");
		}else{
			log.info("Couldn't create in MongoDB with primary key "+obj.hashCode()+" return code is "+statusLine.getStatusCode());
		}
		return statusLine.getStatusCode();
	}

	public static int deleteFromMongoDB(String url, String id) throws ClientProtocolException, IOException{
		//get OAuth token
		OAuthToken token = null;
		try {
			token = OAuthTokenService.getValidAccessToken();
			log.info("-------------  OAuth token from URL : "+token.getAccessToken());
		} catch (Exception e) {
			log.error(e);
		}
		
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, 5000);
		params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		HttpClient httpclient = new DefaultHttpClient(params);
		
		HttpDelete delete = new HttpDelete(url);
		delete.setHeader("Authorization", "Bearer ".concat(token.getAccessToken()));
		delete.setHeader("Accept", "*/*");
		
		long processStartTime = new Date().getTime();
	    HttpResponse httpresponse = httpclient.execute(delete);
	    long processEndTime = new Date().getTime();
	    
	    StatusLine statusLine = httpresponse.getStatusLine();
	    if(statusLine.getStatusCode() == 200){
			log.info("deleted from MongoDB with id "+id);
			log.info("Time take by REST service to delete is : "+(processEndTime-processStartTime)+ " milliseconds");
		}else{
			log.info("Couldn't delete in MongoDB with id "+id+" return code is "+statusLine.getStatusCode());
		}
		return statusLine.getStatusCode();
	}
	
	
	public static Pattern nextPagePattern = Pattern.compile(",<(.*?)>;\\s+rel=\"next\"");
	public static Pattern pagePattern = Pattern.compile(".*\\bpage=(\\d+).*?>;\\s+rel=\"last\"");
	public static final String PAGE_MARKER_1 = "&page=";
	public static final String PAGE_MARKER_2 = "?page=";
	
	private static Log log = LogFactoryUtil.getLog(CanvasApiUtils.class);
}