package com.facepp.result;

import java.util.Dictionary;
import java.util.Hashtable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.facepp.error.FaceppParseException;

/**
 * the request result type<br />
 * Example<br />
 * {@code FaceppResult faceppResult = request-result.}<br />
 * {@code faceppResult.get("face").get(0).get("attribute").get("gender").get("value").toString()}
 * @author moon5ckq
 * @since 1.0.0
 * @version 1.1.0
 */
public class FaceppResult {
	static public enum JsonType {
		INT, BOOL, DOUBLE, STRING, JSON, ARRAY
	}
	
	static private Dictionary<String, JsonType> keyWordDict;
	
	static {
		keyWordDict = new Hashtable<String, FaceppResult.JsonType>();
		keyWordDict.put("session_id", JsonType.STRING);
		keyWordDict.put("url", JsonType.STRING);
		keyWordDict.put("img_id", JsonType.STRING);
		keyWordDict.put("face_id", JsonType.STRING);
		keyWordDict.put("person_id", JsonType.STRING);
		keyWordDict.put("group_id", JsonType.STRING);
		keyWordDict.put("img_width", JsonType.INT);
		keyWordDict.put("img_height", JsonType.INT);
		keyWordDict.put("face", JsonType.ARRAY);
		keyWordDict.put("width", JsonType.DOUBLE);
		keyWordDict.put("height", JsonType.DOUBLE);
		keyWordDict.put("eye_left", JsonType.JSON);
		keyWordDict.put("eye_right", JsonType.JSON);
		keyWordDict.put("mouth_left", JsonType.JSON);
		keyWordDict.put("mouth_right", JsonType.JSON);
		keyWordDict.put("attribute", JsonType.JSON);
		keyWordDict.put("gender", JsonType.JSON);
		keyWordDict.put("age", JsonType.JSON);
		keyWordDict.put("race", JsonType.JSON);
		keyWordDict.put("similarity", JsonType.DOUBLE);
		keyWordDict.put("component_similarity", JsonType.JSON);
		keyWordDict.put("is_same_person", JsonType.BOOL);
		keyWordDict.put("candidate", JsonType.ARRAY);
		keyWordDict.put("results", JsonType.ARRAY);
		keyWordDict.put("status", JsonType.STRING);
		keyWordDict.put("response", JsonType.STRING);
		keyWordDict.put("x", JsonType.DOUBLE);
		keyWordDict.put("y", JsonType.DOUBLE);
		
		keyWordDict.put("has_untrained_face", JsonType.BOOL);
		keyWordDict.put("has_untrained_person", JsonType.BOOL);
		keyWordDict.put("tag", JsonType.STRING);
		keyWordDict.put("person_name", JsonType.STRING);
		keyWordDict.put("group_name", JsonType.STRING);
		keyWordDict.put("eyebrow", JsonType.DOUBLE);
		keyWordDict.put("nose", JsonType.DOUBLE);
		keyWordDict.put("eye", JsonType.DOUBLE);
		keyWordDict.put("mouth", JsonType.DOUBLE);
		keyWordDict.put("confidence", JsonType.DOUBLE);
		keyWordDict.put("success", JsonType.BOOL);
		keyWordDict.put("name", JsonType.STRING);
		keyWordDict.put("description", JsonType.STRING);
		keyWordDict.put("position", JsonType.JSON);
		keyWordDict.put("person", JsonType.ARRAY);
		keyWordDict.put("group", JsonType.ARRAY);
		keyWordDict.put("QUOTA_ALL", JsonType.INT);
		keyWordDict.put("QUOTA_SEARCH", JsonType.INT);
		keyWordDict.put("center", JsonType.JSON);
		
		keyWordDict.put("ungrouped", JsonType.JSON);
		keyWordDict.put("result", JsonType.JSON);
		
	}
	
	private Object json;
	private JsonType type;
	private int httpResponseCode = 0;
	
	/**
	 * @param json
	 */
	public FaceppResult(Object json) {
		this.json = json;
		this.type = JsonType.JSON;
	}
	
	/**
	 * @param json
	 * @param httpResponseCode
	 */
	public FaceppResult(Object json, int httpResponseCode) {
		this.json = json;
		this.type = JsonType.JSON;
		this.httpResponseCode = httpResponseCode;
	}
	
	/**
	 * @param json
	 * @param type
	 * @param httpResponseCode
	 */
	public FaceppResult(Object json, JsonType type, int httpResponseCode) {
		this.json = json;
		this.type = type;
		this.httpResponseCode = httpResponseCode;
	}
	
	private JSONArray a(String key) {
		try {
			return ((JSONObject)json).getJSONArray(key);
		} catch (JSONException e) {
		}
		return null;
	}
	
	private JSONObject j(String key) {
		try {
			return ((JSONObject)json).getJSONObject(key);
		} catch (JSONException e) {
		}
		return null;
	}
	
	private String s(String key) {
		try {
			return ((JSONObject)json).getString(key);
		} catch (JSONException e) {
		}
		return null;
	}
	
	private Double d(String key) {
		try {
			return ((JSONObject)json).getDouble(key);
		} catch (JSONException e) {
		}
		return null;
	}
	
	private Boolean b(String key) {
		try {
			return ((JSONObject)json).getBoolean(key);
		} catch (JSONException e) {
		}
		return null;
	}
	
	private Integer i(String key) {
		try {
			return ((JSONObject)json).getInt(key);
		} catch (JSONException e) {
		}
		return null;
	}
	
	
	
	private JSONArray getArray(String key) {
		return a(key);
	}
	
	private JSONObject getJson(String key) {
		return j(key);
	}
	
	private String getString(String key) {
		return s(key);
	}
	
	private Double getDouble(String key) {
		return d(key);
	}
	
	private Boolean getBoolean(String key) {
		return b(key);
	}
	
	private Integer getInt(String key) {
		return i(key);
	}

	///---------------------------------------------------
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return json.toString();
	}
	/**
	 * change to a integer value, if no a integer type , throw the exception
	 * @return a Integer value
	 * @throws FaceppParseException
	 */
	public Integer toInteger() throws FaceppParseException {
		if (this.type != JsonType.INT) {
			throw new FaceppParseException("( " + json.toString() + " ) is not an integer.");
		}
		return (Integer)json;
	}
	/**
	 * change to a double value, if no a double type , throw the exception
	 * @return a Double value
	 * @throws FaceppParseException
	 */
	public Double toDouble() throws FaceppParseException {
		if (this.type != JsonType.DOUBLE) {
			throw new FaceppParseException("( " + json.toString() + " ) is not a float number.");
		}
		return (Double)json;
	}
	/**
	 * change to a boolean value, if no a boolean type , throw the exception
	 * @return a Boolean value
	 * @throws FaceppParseException
	 */
	public Boolean toBoolean() throws FaceppParseException {
		if (this.type != JsonType.BOOL) {
			throw new FaceppParseException("( " + json.toString() + " ) is not a boolean value.");
		}
		return (Boolean)json;
	}
	
	
	/**
	 * if not an array, throw the exception
	 * @return the array length
	 * @throws FaceppParseException
	 */
	public int getCount() throws FaceppParseException {
		if (this.type != JsonType.ARRAY) {
			throw new FaceppParseException("( " + json.toString() + " ) is not an array.");
		}
		
		return ((JSONArray)json).length();
	}
	
	/**
	 * if not an array, throw the exception
	 * @param index
	 * @return the index-th element in array
	 * @throws FaceppParseException
	 */
	public FaceppResult get(int index) throws FaceppParseException {
		
		if (this.type != JsonType.ARRAY) {
			throw new FaceppParseException("( " + json.toString() + " ) is not an array.");
		}
		
		try {
			return new FaceppResult( ((JSONArray)json).getJSONObject(index), JsonType.JSON, httpResponseCode);
		} catch (JSONException e) {	
			throw new FaceppParseException("Json string can not be parsed.");
		}
	}
	
	
	/**
	 * if don't have the key or not a json object, throw the exception
	 * @param key
	 * @return get the value about key
	 * @throws FaceppParseException
	 */
	public FaceppResult get(String key) throws FaceppParseException {
		if (this.type != JsonType.JSON) {
			throw new FaceppParseException("( " + json.toString() + " ) is not json string.");
		}
		
		JsonType returnType = keyWordDict.get(key);
		if (returnType == null) {
			throw new FaceppParseException("invalid key word : " + key + ".");
		}
		
		if (! ((JSONObject)json).has(key)) {
			throw new FaceppParseException("( " + json.toString() + " ) do not have the key "+ key);
		}
		
		switch (returnType) {
		case INT:
			return new FaceppResult( getInt(key), JsonType.INT, httpResponseCode);
		case DOUBLE:
			return new FaceppResult( getDouble(key), JsonType.DOUBLE, httpResponseCode);
		case BOOL:
			return new FaceppResult( getBoolean(key), JsonType.BOOL, httpResponseCode);
		case STRING:
			return new FaceppResult( getString(key), JsonType.STRING, httpResponseCode);
		case ARRAY:
			return new FaceppResult( getArray(key), JsonType.ARRAY, httpResponseCode);
		case JSON:
			return new FaceppResult( getJson(key), JsonType.JSON, httpResponseCode);
		default:
			
		}
		
		return null;
	}
	
	/**
	 * if not a json object, throw the exception<br />
	 * used when api is update but sdk not
	 * @param key
	 * @param type
	 * @return
	 * @throws FaceppParseException
	 */
	public FaceppResult get(String key, JsonType type) throws FaceppParseException {
		if (this.type != JsonType.JSON) {
			throw new FaceppParseException("( " + json.toString() + " ) is not json string.");
		}
		
		switch (type) {
		case INT:
			return new FaceppResult( getInt(key), JsonType.INT, httpResponseCode);
		case DOUBLE:
			return new FaceppResult( getDouble(key), JsonType.DOUBLE, httpResponseCode);
		case BOOL:
			return new FaceppResult( getBoolean(key), JsonType.BOOL, httpResponseCode);
		case STRING:
			return new FaceppResult( getString(key), JsonType.STRING, httpResponseCode);
		case ARRAY:
			return new FaceppResult( getArray(key), JsonType.ARRAY, httpResponseCode);
		case JSON:
			return new FaceppResult( getJson(key), JsonType.JSON, httpResponseCode);
		default:
			
		}
		
		return null;
	}
	
	
	/**
	 * the request result like <br />
	 * {<br />
     * "error": "...",<br /> 
     * "error_code": ...<br />
     * }
	 * @return is a error message
	 */
	public boolean isError() {
		if (this.type != JsonType.JSON) {
			return false;
		}
		return ((JSONObject)json).has("error");
	}
	
	/**
	 * where error : ...
	 * @return the error message
	 * @throws FaceppParseException
	 */
	public String getErrorMessage() throws FaceppParseException {
		if (this.type != JsonType.JSON || !isError()) {
			throw new FaceppParseException("( " + json.toString() + " ) is not an error message.");
		}
		try {
			return ((JSONObject)json).getString("error");
		} catch (JSONException e) {
			throw new FaceppParseException("Json string can not be parsed.");
		}
	}
	
	/**
	 * where error_code : ...
	 * @return the error code
	 * @throws FaceppParseException
	 */
	public int getErrorCode() throws FaceppParseException {
		if (this.type != JsonType.JSON || !isError()) {
			throw new FaceppParseException("( " + json.toString() + " ) is not an error message.");
		}
		try {
			return ((JSONObject)json).getInt("error_code");
		} catch (JSONException e) {
			throw new FaceppParseException("Json string can not be parsed.");
		}
	}
	
	/**
	 * @return the http response code
	 */
	public int getHttpResponseCode() {
		return httpResponseCode;
	}
}
