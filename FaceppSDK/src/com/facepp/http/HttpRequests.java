package com.facepp.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.json.JSONException;
import org.json.JSONObject;

import com.facepp.error.FaceppParseException;
import com.facepp.result.FaceppResult;

/**
 * request to faceplusplus.com<br />
 * {@code new HttpRequests(apiKey, apiSecret).request("detection", "detect", postParameters)}<br />
 * 
 * {@code new HttpRequests(apiKey, apiSecret).train()}
 * @author moon5ckq
 * @since 1.0.0
 * @version 1.2.0
 */
public class HttpRequests {
	
	static final private String WEBSITE_CN = "https://apicn.faceplusplus.com/v2/";
	static final private String DWEBSITE_CN = "http://apicn.faceplusplus.com/v2/";
	static final private String WEBSITE_US = "https://apius.faceplusplus.com/v2/";
	static final private String DWEBSITE_US = "http://apius.faceplusplus.com/v2/";
	 
	static final private int BUFFERSIZE = 1048576;
	static final private int TIMEOUT = 30000;
	static final private int SYNC_TIMEOUT = 60000;
	
	private String webSite;
	private String apiKey, apiSecret;
	private PostParameters params;
	private int httpTimeOut = TIMEOUT;
	
	
	/**
	 * default is 30 sec
	 * set http timeout limit (million second)
	 * @param timeOut
	 */
	public void setHttpTimeOut(int timeOut) {
		this.httpTimeOut = timeOut;
	}
	
	/**
	 * (million second)
	 * @return http timeout limit
	 */
	public int getHttpTimeOut() {
		return this.httpTimeOut;
	}
	
	/**
	 * @return api_key
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * @return api_secret
	 */
	public String getApiSecret() {
		return apiSecret;
	}

	/**
	 * @param apiSecret
	 */
	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}
	
	/**
	 * if isCN is true, then use AliCloud, false to Amazon<br />
	 * if isDebug is true, then use http, otherwise https
	 * @param isCN
	 * @param isDebug
	 */
	public void setWebSite(boolean isCN, boolean isDebug) {
		if (isCN && isDebug) webSite = DWEBSITE_CN;
		else if (isCN && !isDebug) webSite = WEBSITE_CN;
		else if (!isCN && isDebug) webSite = DWEBSITE_US;
		else if (!isCN && !isDebug) webSite = WEBSITE_US;
	}
	
	/**
	 * @return a webSite clone
	 */
	public String getWebSite() {
		return new String(webSite);
	}

	/**
	 * {@link #request(String, String, PostParameters)}<br />
	 * faceplusplus.com/[control]/[action]<br />
	 * default use parameters which {@link #getParams}
	 * @param control
	 * @param action
	 * @return a result object
	 */
	public FaceppResult request(String control, String action) throws FaceppParseException {
		return request(control, action, getParams());
	}
	
//	/**
//	 * {@link #train(PostParameters, long)}<br />
//	 * default timeout time is 1 min, use parameters which {@link #getParams}
//	 * @return a result object
//	* @throws FaceppParseException
//	 */
//	public FaceppResult train() throws FaceppParseException {
//		return train(getParams(), TRAINTIMEOUT);
//	}
//	/**
//	 * {@link #train(PostParameters, long)}<br />
//	 * timeout time is [timeOut]ms, use parameters which {@link #getParams}
//	 * @param timeOut
//	 * @return a result object
//	* @throws FaceppParseException
//	 */
//	public FaceppResult train(long timeOut) throws FaceppParseException {
//		return train(getParams(), timeOut);
//	}
//	/**
//	 * {@link #train(PostParameters, long)}<br />
//	 * default timeout time is 5000ms
//	 * @param params
//	 * @return a result object
//	* @throws FaceppParseException
//	 */
//	public FaceppResult train(PostParameters params) throws FaceppParseException {
//		return train(params, TRAINTIMEOUT);
//	}
//	
//	/**
//	 * timeout time is [timeOut]ms, the method is synchronized. <br />
//	 * If training is success, return the result about "/info/get_session?session_id=..". <br />
//	 * If timeout, then return a json object which "session_id = ...".
//	 * @param params
//	 * @param timeOut
//	 * @return a result object
//	 * @throws FaceppParseException
//	 */
//	public FaceppResult train(PostParameters params, long timeOut) throws FaceppParseException {
//		
//		final long timeOutFinal = timeOut;
//		String sessionIdTmp = null;
//		FaceppResult fj = null;
//		try {
//			fj = this.request("recognition", "train", params);
//			sessionIdTmp = fj.get("session_id").toString();
//		} catch (FaceppParseException e) {
//			if (fj.isError()) return fj;
//			throw new FaceppParseException("Train error.");
//		}
//		final StringBuilder sb = new StringBuilder();
//		final String sessionId = sessionIdTmp;
//		
//		long t = new Date().getTime() + timeOutFinal;
//		while (true) {
//			FaceppResult rst =  HttpRequests.this.request("info", "get_session", new PostParameters().setSessionId(sessionId));
//			try {
//				if (rst.get("status").toString().equals("SUCC")) {
//					sb.append(rst.toString());
//					break;
//				} else if (rst.get("status").toString().equals("INVALID_SESSION")) {
//					sb.append("INVALID_SESSION");
//					break;
//				}
//			} catch (FaceppParseException e) {
//				sb.append("Unknow error.");
//				break;
//			}
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				sb.append("Thread.sleep error.");
//				break;
//			}
//			if (new Date().getTime() >= t) {
//				sb.append("Time Out");
//				break;
//			}
//		}
//		
//		String rst = sb.toString();
//		if (rst.equals("INVALID_SESSION")) {
//			throw new FaceppParseException("Invaild session, unknow error.");
//		} else if (rst.equals("Unknow error.")) {
//			throw new FaceppParseException("Unknow error.");
//		} else if (rst.equals("Thread.sleep error.")) {
//			throw new FaceppParseException("Thread.sleep error.");
//		} else if (rst.equals("Time Out")) {
//			return fj;
//		} else {
//			try {
//				return new FaceppResult(new JSONObject(rst), 200);
//			} catch (JSONException e) {
//			}
//		}
//		
//		return null;
//	}
	
	/**
	 * default timeout time is 1 minute
	 * @param sessionId
	 * @return the getSession Result
	 * @throws FaceppParseException
	 */
	public FaceppResult getSessionSync(String sessionId) throws FaceppParseException {
		return getSessionSync(sessionId, SYNC_TIMEOUT);
	}
	
	/**
	 * timeout time is [timeOut]ms, the method is synchronized.
	 * @param sessionId
	 * @param timeOut
	 * @return the getSession Result
	 * @throws FaceppParseException
	 */
	public FaceppResult getSessionSync(String sessionId, long timeOut) throws FaceppParseException {
		final StringBuilder sb = new StringBuilder();
		long t = new Date().getTime() + timeOut;
		while (true) {
			FaceppResult rst =  HttpRequests.this.request("info", "get_session", new PostParameters().setSessionId(sessionId));
			try {
				if (rst.get("status").toString().equals("SUCC")) {
					sb.append(rst.toString());
					break;
				} else if (rst.get("status").toString().equals("INVALID_SESSION")) {
					sb.append("INVALID_SESSION");
					break;
				}
			} catch (FaceppParseException e) {
				sb.append("Unknow error.");
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				sb.append("Thread.sleep error.");
				break;
			}
			if (new Date().getTime() >= t) {
				sb.append("Time Out");
				break;
			}
		}
		
		String rst = sb.toString();
		if (rst.equals("INVALID_SESSION")) {
			throw new FaceppParseException("Invaild session, unknow error.");
		} else if (rst.equals("Unknow error.")) {
			throw new FaceppParseException("Unknow error.");
		} else if (rst.equals("Thread.sleep error.")) {
			throw new FaceppParseException("Thread.sleep error.");
		} else if (rst.equals("Time Out")) {
			throw new FaceppParseException("Get session time out.");
		} else {
			try {
				return new FaceppResult(new JSONObject(rst), 200);
			} catch (JSONException e) {
			}
		}
		
		return null;
	}
	
	/**
	 * faceplusplus.com/[control]/[action]?[params]<br />
	 * http request timeout time is 5000ms
	 * @param control
	 * @param action
	 * @param params
	 * @return a result object
	 * @throws FaceppParseException
	 */
	public FaceppResult request(String control, String action, PostParameters params) throws FaceppParseException {
		URL url;
		HttpURLConnection urlConn = null;
		try {
			url = new URL(webSite+control+"/"+action);
			urlConn = (HttpURLConnection) url.openConnection();
	        urlConn.setRequestMethod("POST");
	        urlConn.setConnectTimeout(httpTimeOut);
	        urlConn.setReadTimeout(httpTimeOut);
	        urlConn.setDoOutput(true);

	        urlConn.setRequestProperty("connection", "keep-alive");
	        urlConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + params.boundaryString());
			
	        MultipartEntity reqEntity = params.getMultiPart();
            
            reqEntity.addPart("api_key", new StringBody(apiKey));
            reqEntity.addPart("api_secret", new StringBody(apiSecret));
	        
            reqEntity.writeTo(urlConn.getOutputStream());
            
            String resultString = null;
            if (urlConn.getResponseCode() == 200)
            	resultString = readString(urlConn.getInputStream());
            else
            	resultString = readString(urlConn.getErrorStream());
	        
            FaceppResult result = new FaceppResult( new JSONObject(resultString), urlConn.getResponseCode());
            
            
            if (result.isError()) {
            	
            	
            	if (result.get("error").toString().equals("API not found"))
            		throw new FaceppParseException("API not found");
            	
            	throw new FaceppParseException("API error.", result.getErrorCode(), result.getErrorMessage(), result.getHttpResponseCode());
            }
            return result;
		} catch (Exception e) {
			throw new FaceppParseException("error :" + e.toString());
		}
	}
	
	private static String readString(InputStream is) {
		StringBuffer rst = new StringBuffer();
		
		byte[] buffer = new byte[BUFFERSIZE];
		int len = 0;
		
		try {
			while ((len = is.read(buffer)) > 0)
				for (int i = 0; i < len; ++i)
					rst.append((char)buffer[i]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rst.toString();
	}
	
	/**
	 * create {@link HttpRequests} <br />
	 * api_key=...,api_secret=... <br />
	 * use https and AliCloud default
	 * @param apiKey
	 * @param apiSecret
	 */
	public HttpRequests(String apiKey, String apiSecret) {
		super();
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.webSite = WEBSITE_CN;
	}

	/**
	 * use https default
	 * create a empty {@link HttpRequests} object
	 */
	public HttpRequests() {
		super();
	}
	
	/**
	 * create {@link HttpRequests} <br />
	 * api_key=...,api_secret=...<br />
	 * the isCN and isDebug use like {@link setWebSite}}
	 * @param apiKey
	 * @param apiSecret
	 * @param isCN
	 * @param isDebug
	 */
	public HttpRequests(String apiKey, String apiSecret, boolean isCN, boolean isDebug) {
		super();
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		setWebSite(isCN, isDebug);
	}
	
	/**
	 * @return {@link PostParameters} object
	 */
	public PostParameters getParams() {
		if (params == null) params = new PostParameters();
		return params;
	}
	
	/**
	 * set default PostParameters
	 * @param params
	 */
	public void setParams(PostParameters params) {
		this.params = params;
	}
	
	//all api here
	
	public FaceppResult detectionDetect() throws FaceppParseException {
		return request("detection", "detect");
	}
	public FaceppResult detectionDetect(PostParameters params) throws FaceppParseException{
		return request("detection", "detect", params);
	}

	public FaceppResult trainVerify() throws FaceppParseException {
		return request("train", "verify");
	}
	public FaceppResult trainVerify(PostParameters params) throws FaceppParseException{
		return request("train", "verify", params);
	}

	public FaceppResult trainSearch() throws FaceppParseException {
		return request("train", "search");
	}
	public FaceppResult trainSearch(PostParameters params) throws FaceppParseException{
		return request("train", "search", params);
	}

	public FaceppResult trainIdentify() throws FaceppParseException {
		return request("train", "identify");
	}
	public FaceppResult trainIdentify(PostParameters params) throws FaceppParseException{
		return request("train", "identify", params);
	}

	public FaceppResult recognitionCompare() throws FaceppParseException {
		return request("recognition", "compare");
	}
	public FaceppResult recognitionCompare(PostParameters params) throws FaceppParseException{
		return request("recognition", "compare", params);
	}

	public FaceppResult recognitionVerify() throws FaceppParseException {
		return request("recognition", "verify");
	}
	public FaceppResult recognitionVerify(PostParameters params) throws FaceppParseException{
		return request("recognition", "verify", params);
	}

	public FaceppResult recognitionSearch() throws FaceppParseException {
		return request("recognition", "search");
	}
	public FaceppResult recognitionSearch(PostParameters params) throws FaceppParseException{
		return request("recognition", "search", params);
	}

	public FaceppResult recognitionIdentify() throws FaceppParseException {
		return request("recognition", "identify");
	}
	public FaceppResult recognitionIdentify(PostParameters params) throws FaceppParseException{
		return request("recognition", "identify", params);
	}

	public FaceppResult groupingGrouping() throws FaceppParseException {
		return request("grouping", "grouping");
	}
	public FaceppResult groupingGrouping(PostParameters params) throws FaceppParseException{
		return request("grouping", "grouping", params);
	}

	public FaceppResult personCreate() throws FaceppParseException {
		return request("person", "create");
	}
	public FaceppResult personCreate(PostParameters params) throws FaceppParseException{
		return request("person", "create", params);
	}

	public FaceppResult personDelete() throws FaceppParseException {
		return request("person", "delete");
	}
	public FaceppResult personDelete(PostParameters params) throws FaceppParseException{
		return request("person", "delete", params);
	}

	public FaceppResult personAddFace() throws FaceppParseException {
		return request("person", "add_face");
	}
	public FaceppResult personAddFace(PostParameters params) throws FaceppParseException{
		return request("person", "add_face", params);
	}

	public FaceppResult personRemoveFace() throws FaceppParseException {
		return request("person", "remove_face");
	}
	public FaceppResult personRemoveFace(PostParameters params) throws FaceppParseException{
		return request("person", "remove_face", params);
	}

	public FaceppResult personSetInfo() throws FaceppParseException {
		return request("person", "set_info");
	}
	public FaceppResult personSetInfo(PostParameters params) throws FaceppParseException{
		return request("person", "set_info", params);
	}

	public FaceppResult personGetInfo() throws FaceppParseException {
		return request("person", "get_info");
	}
	public FaceppResult personGetInfo(PostParameters params) throws FaceppParseException{
		return request("person", "get_info", params);
	}

	public FaceppResult facesetCreate() throws FaceppParseException {
		return request("faceset", "create");
	}
	public FaceppResult facesetCreate(PostParameters params) throws FaceppParseException{
		return request("faceset", "create", params);
	}

	public FaceppResult facesetDelete() throws FaceppParseException {
		return request("faceset", "delete");
	}
	public FaceppResult facesetDelete(PostParameters params) throws FaceppParseException{
		return request("faceset", "delete", params);
	}

	public FaceppResult facesetAddFace() throws FaceppParseException {
		return request("faceset", "add_face");
	}
	public FaceppResult facesetAddFace(PostParameters params) throws FaceppParseException{
		return request("faceset", "add_face", params);
	}

	public FaceppResult facesetRemoveFace() throws FaceppParseException {
		return request("faceset", "remove_face");
	}
	public FaceppResult facesetRemoveFace(PostParameters params) throws FaceppParseException{
		return request("faceset", "remove_face", params);
	}

	public FaceppResult facesetSetInfo() throws FaceppParseException {
		return request("faceset", "set_info");
	}
	public FaceppResult facesetSetInfo(PostParameters params) throws FaceppParseException{
		return request("faceset", "set_info", params);
	}

	public FaceppResult facesetGetInfo() throws FaceppParseException {
		return request("faceset", "get_info");
	}
	public FaceppResult facesetGetInfo(PostParameters params) throws FaceppParseException{
		return request("faceset", "get_info", params);
	}

	public FaceppResult groupCreate() throws FaceppParseException {
		return request("group", "create");
	}
	public FaceppResult groupCreate(PostParameters params) throws FaceppParseException{
		return request("group", "create", params);
	}

	public FaceppResult groupDelete() throws FaceppParseException {
		return request("group", "delete");
	}
	public FaceppResult groupDelete(PostParameters params) throws FaceppParseException{
		return request("group", "delete", params);
	}

	public FaceppResult groupAddPerson() throws FaceppParseException {
		return request("group", "add_person");
	}
	public FaceppResult groupAddPerson(PostParameters params) throws FaceppParseException{
		return request("group", "add_person", params);
	}

	public FaceppResult groupRemovePerson() throws FaceppParseException {
		return request("group", "remove_person");
	}
	public FaceppResult groupRemovePerson(PostParameters params) throws FaceppParseException{
		return request("group", "remove_person", params);
	}

	public FaceppResult groupSetInfo() throws FaceppParseException {
		return request("group", "set_info");
	}
	public FaceppResult groupSetInfo(PostParameters params) throws FaceppParseException{
		return request("group", "set_info", params);
	}

	public FaceppResult groupGetInfo() throws FaceppParseException {
		return request("group", "get_info");
	}
	public FaceppResult groupGetInfo(PostParameters params) throws FaceppParseException{
		return request("group", "get_info", params);
	}

	public FaceppResult infoGetImage() throws FaceppParseException {
		return request("info", "get_image");
	}
	public FaceppResult infoGetImage(PostParameters params) throws FaceppParseException{
		return request("info", "get_image", params);
	}

	public FaceppResult infoGetFace() throws FaceppParseException {
		return request("info", "get_face");
	}
	public FaceppResult infoGetFace(PostParameters params) throws FaceppParseException{
		return request("info", "get_face", params);
	}

	public FaceppResult infoGetPersonList() throws FaceppParseException {
		return request("info", "get_person_list");
	}
	public FaceppResult infoGetPersonList(PostParameters params) throws FaceppParseException{
		return request("info", "get_person_list", params);
	}

	public FaceppResult infoGetFacesetList() throws FaceppParseException {
		return request("info", "get_faceset_list");
	}
	public FaceppResult infoGetFacesetList(PostParameters params) throws FaceppParseException{
		return request("info", "get_faceset_list", params);
	}

	public FaceppResult infoGetGroupList() throws FaceppParseException {
		return request("info", "get_group_list");
	}
	public FaceppResult infoGetGroupList(PostParameters params) throws FaceppParseException{
		return request("info", "get_group_list", params);
	}

	public FaceppResult infoGetSession() throws FaceppParseException {
		return request("info", "get_session");
	}
	public FaceppResult infoGetSession(PostParameters params) throws FaceppParseException{
		return request("info", "get_session", params);
	}

	public FaceppResult infoGetQuota() throws FaceppParseException {
		return request("info", "get_quota");
	}
	public FaceppResult infoGetQuota(PostParameters params) throws FaceppParseException{
		return request("info", "get_quota", params);
	}

	public FaceppResult infoGetApp() throws FaceppParseException {
		return request("info", "get_app");
	}
	public FaceppResult infoGetApp(PostParameters params) throws FaceppParseException{
		return request("info", "get_app", params);
	}

}
