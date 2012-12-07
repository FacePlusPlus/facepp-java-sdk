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
 * @version 1.0.0
 */
public class HttpRequests {
	
	static final private String WEBSITE = "http://api.faceplusplus.com/";
	static final private int BUFFERSIZE = 1048576;
	static final private int TIMEOUT = 30000;
	static final private int TRAINTIMEOUT = 60000;
	
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
	
	/**
	 * {@link #train(PostParameters, long)}<br />
	 * default timeout time is 1 min, use parameters which {@link #getParams}
	 * @return a result object
	* @throws FaceppParseException
	 */
	public FaceppResult train() throws FaceppParseException {
		return train(getParams(), TRAINTIMEOUT);
	}
	/**
	 * {@link #train(PostParameters, long)}<br />
	 * timeout time is [timeOut]ms, use parameters which {@link #getParams}
	 * @param timeOut
	 * @return a result object
	* @throws FaceppParseException
	 */
	public FaceppResult train(long timeOut) throws FaceppParseException {
		return train(getParams(), timeOut);
	}
	/**
	 * {@link #train(PostParameters, long)}<br />
	 * default timeout time is 5000ms
	 * @param params
	 * @return a result object
	* @throws FaceppParseException
	 */
	public FaceppResult train(PostParameters params) throws FaceppParseException {
		return train(params, TRAINTIMEOUT);
	}
	
	/**
	 * timeout time is [timeOut]ms, the method is synchronized. <br />
	 * If training is success, return the result about "/info/get_session?session_id=..". <br />
	 * If timeout, then return a json object which "session_id = ...".
	 * @param params
	 * @param timeOut
	 * @return a result object
	 * @throws FaceppParseException
	 */
	public FaceppResult train(PostParameters params, long timeOut) throws FaceppParseException {
		
		final long timeOutFinal = timeOut;
		String sessionIdTmp = null;
		FaceppResult fj = null;
		try {
			fj = this.request("recognition", "train", params);
			sessionIdTmp = fj.get("session_id").toString();
		} catch (FaceppParseException e) {
			if (fj.isError()) return fj;
			throw new FaceppParseException("Train error.");
		}
		final StringBuilder sb = new StringBuilder();
		final String sessionId = sessionIdTmp;
		
//		Thread thread =  new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
				long t = new Date().getTime() + timeOutFinal;
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
//			}
//		});
		
//		thread.start();
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			throw new FaceppParseException("Thread error.");
//		}
		
		String rst = sb.toString();
		if (rst.equals("INVALID_SESSION")) {
			throw new FaceppParseException("Invaild session, unknow error.");
		} else if (rst.equals("Unknow error.")) {
			throw new FaceppParseException("Unknow error.");
		} else if (rst.equals("Thread.sleep error.")) {
			throw new FaceppParseException("Thread.sleep error.");
		} else if (rst.equals("Time Out")) {
			return fj;
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
			url = new URL(WEBSITE+control+"/"+action);
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
            
            if (result.isError())
            	throw new FaceppParseException("API error.", result.getErrorCode(), result.getErrorMessage(), result.getHttpResponseCode());
            return result;
		} catch (Exception e) {
			throw new FaceppParseException("error : " + e.toString());
			//return new FaceppResult( new JSONObject("{\"error\":"+e.toString()+"}"));
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
	 * api_key=...,api_secret=...
	 * @param apiKey
	 * @param apiSecret
	 */
	public HttpRequests(String apiKey, String apiSecret) {
		super();
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
	}

	/**
	 * create a empty {@link HttpRequests} object
	 */
	public HttpRequests() {
		super();
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
	
	/**
	* {@link #request(String, String)} <br />
	* detection/detect
	* @throws FaceppParseException 
	*/
	public FaceppResult detectionDetect() throws FaceppParseException {
		return request("detection", "detect");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* detection/detect
	* @throws FaceppParseException 
	*/
	public FaceppResult detectionDetect(PostParameters params) throws FaceppParseException{
		return request("detection", "detect", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* info/get_image
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetImage() throws FaceppParseException {
		return request("info", "get_image");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* info/get_image
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetImage(PostParameters params) throws FaceppParseException{
		return request("info", "get_image", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* info/get_face
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetFace() throws FaceppParseException {
		return request("info", "get_face");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* info/get_face
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetFace(PostParameters params) throws FaceppParseException{
		return request("info", "get_face", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* info/get_session
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetSession() throws FaceppParseException {
		return request("info", "get_session");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* info/get_session
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetSession(PostParameters params) throws FaceppParseException{
		return request("info", "get_session", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* info/get_quota
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetQuota() throws FaceppParseException {
		return request("info", "get_quota");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* info/get_quota
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetQuota(PostParameters params) throws FaceppParseException{
		return request("info", "get_quota", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* info/get_person_list
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetPersonList() throws FaceppParseException {
		return request("info", "get_person_list");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* info/get_person_list
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetPersonList(PostParameters params) throws FaceppParseException{
		return request("info", "get_person_list", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* info/get_group_list
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetGroupList() throws FaceppParseException {
		return request("info", "get_group_list");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* info/get_group_list
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetGroupList(PostParameters params) throws FaceppParseException{
		return request("info", "get_group_list", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* info/get_app
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetApp() throws FaceppParseException {
		return request("info", "get_app");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* info/get_app
	* @throws FaceppParseException 
	*/
	public FaceppResult infoGetApp(PostParameters params) throws FaceppParseException{
		return request("info", "get_app", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* person/create
	* @throws FaceppParseException 
	*/
	public FaceppResult personCreate() throws FaceppParseException {
		return request("person", "create");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* person/create
	* @throws FaceppParseException 
	*/
	public FaceppResult personCreate(PostParameters params) throws FaceppParseException{
		return request("person", "create", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* person/delete
	* @throws FaceppParseException 
	*/
	public FaceppResult personDelete() throws FaceppParseException {
		return request("person", "delete");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* person/delete
	* @throws FaceppParseException 
	*/
	public FaceppResult personDelete(PostParameters params) throws FaceppParseException{
		return request("person", "delete", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* person/add_face
	* @throws FaceppParseException 
	*/
	public FaceppResult personAddFace() throws FaceppParseException {
		return request("person", "add_face");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* person/add_face
	* @throws FaceppParseException 
	*/
	public FaceppResult personAddFace(PostParameters params) throws FaceppParseException{
		return request("person", "add_face", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* person/remove_face
	* @throws FaceppParseException 
	*/
	public FaceppResult personRemoveFace() throws FaceppParseException {
		return request("person", "remove_face");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* person/remove_face
	* @throws FaceppParseException 
	*/
	public FaceppResult personRemoveFace(PostParameters params) throws FaceppParseException{
		return request("person", "remove_face", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* person/get_info
	* @throws FaceppParseException 
	*/
	public FaceppResult personGetInfo() throws FaceppParseException {
		return request("person", "get_info");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* person/get_info
	* @throws FaceppParseException 
	*/
	public FaceppResult personGetInfo(PostParameters params) throws FaceppParseException{
		return request("person", "get_info", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* person/set_info
	* @throws FaceppParseException 
	*/
	public FaceppResult personSetInfo() throws FaceppParseException {
		return request("person", "set_info");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* person/set_info
	* @throws FaceppParseException 
	*/
	public FaceppResult personSetInfo(PostParameters params) throws FaceppParseException{
		return request("person", "set_info", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* group/create
	* @throws FaceppParseException 
	*/
	public FaceppResult groupCreate() throws FaceppParseException {
		return request("group", "create");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* group/create
	* @throws FaceppParseException 
	*/
	public FaceppResult groupCreate(PostParameters params) throws FaceppParseException{
		return request("group", "create", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* group/delete
	* @throws FaceppParseException 
	*/
	public FaceppResult groupDelete() throws FaceppParseException {
		return request("group", "delete");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* group/delete
	* @throws FaceppParseException 
	*/
	public FaceppResult groupDelete(PostParameters params) throws FaceppParseException{
		return request("group", "delete", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* group/add_person
	* @throws FaceppParseException 
	*/
	public FaceppResult groupAddPerson() throws FaceppParseException {
		return request("group", "add_person");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* group/add_person
	* @throws FaceppParseException 
	*/
	public FaceppResult groupAddPerson(PostParameters params) throws FaceppParseException{
		return request("group", "add_person", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* group/remove_person
	* @throws FaceppParseException 
	*/
	public FaceppResult groupRemovePerson() throws FaceppParseException {
		return request("group", "remove_person");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* group/remove_person
	* @throws FaceppParseException 
	*/
	public FaceppResult groupRemovePerson(PostParameters params) throws FaceppParseException{
		return request("group", "remove_person", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* group/get_info
	* @throws FaceppParseException 
	*/
	public FaceppResult groupGetInfo() throws FaceppParseException {
		return request("group", "get_info");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* group/get_info
	* @throws FaceppParseException 
	*/
	public FaceppResult groupGetInfo(PostParameters params) throws FaceppParseException{
		return request("group", "get_info", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* group/set_info
	* @throws FaceppParseException 
	*/
	public FaceppResult groupSetInfo() throws FaceppParseException {
		return request("group", "set_info");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* group/set_info
	* @throws FaceppParseException 
	*/
	public FaceppResult groupSetInfo(PostParameters params) throws FaceppParseException{
		return request("group", "set_info", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* recognition/compare
	* @throws FaceppParseException 
	*/
	public FaceppResult recognitionCompare() throws FaceppParseException {
		return request("recognition", "compare");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* recognition/compare
	* @throws FaceppParseException 
	*/
	public FaceppResult recognitionCompare(PostParameters params) throws FaceppParseException{
		return request("recognition", "compare", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* recognition/train
	* @throws FaceppParseException 
	*/
	public FaceppResult recognitionTrain() throws FaceppParseException {
		return request("recognition", "train");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* recognition/train
	* @throws FaceppParseException 
	*/
	public FaceppResult recognitionTrain(PostParameters params) throws FaceppParseException{
		return request("recognition", "train", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* recognition/verify
	* @throws FaceppParseException 
	*/
	public FaceppResult recognitionVerify() throws FaceppParseException {
		return request("recognition", "verify");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* recognition/verify
	* @throws FaceppParseException 
	*/
	public FaceppResult recognitionVerify(PostParameters params) throws FaceppParseException{
		return request("recognition", "verify", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* recognition/recognize
	* @throws FaceppParseException 
	*/
	public FaceppResult recognitionRecognize() throws FaceppParseException {
		return request("recognition", "recognize");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* recognition/recognize
	* @throws FaceppParseException 
	*/
	public FaceppResult recognitionRecognize(PostParameters params) throws FaceppParseException{
		return request("recognition", "recognize", params);
	}



	/**
	* {@link #request(String, String)} <br />
	* recognition/search
	* @throws FaceppParseException 
	*/
	public FaceppResult recognitionSearch() throws FaceppParseException {
		return request("recognition", "search");
	}
	/**
	* {@link #request(String, String, PostParameters)} <br />
	* recognition/search
	* @throws FaceppParseException 
	*/
	public FaceppResult recognitionSearch(PostParameters params) throws FaceppParseException{
		return request("recognition", "search", params);
	}

}
