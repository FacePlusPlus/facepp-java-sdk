# FacePlusPlus Java SDK

This SDK uses apache.http lib and json lib.
The new FacePP API has been online in 17 Oct. 2013.

## 1. Install
1. download [faceppsdk.jar](https://raw.github.com/FacePlusPlus/facepp-java-sdk/facepp-v3/FaceppSDK/output/faceppsdk.jar);
2. add it to java project.

## 2. Import package
* `import com.facepp.*;`

	or

* AutoComplete it with your editor or IDE.

## 3. Call FaceppAPI
1. create a com.facepp.http.HttpRequests object

	`HttpRequests httpRequests = new HttpRequests(you_api_key_string, you_api_secret_string);`
	
  * use server in china and https:
	
	`HttpRequests httpRequests = new HttpRequests(you_api_key_string, you_api_secret_string, true, false);`

2. create a com.facepp.http.PostParameters object with all parameters

	```
	PostParameters postParameters =
	      new PostParameters()
	          .setUrl("http://cn.faceplusplus.com/wp-content/themes/faceplusplus.zh/assets/img/demo/9.jpg")
	          .setAttribute("all");
	```

3. request

	`httpRequests.request("detection", "detect", postParameters);`

	or

	`httpRequests.detectionDetect(postParameters);`


4. get the result use the com.facepp.json.FaceppJson object

	`JSONObejct result = httpRequests.detectionDetect(postParameters);`

## 4. Get value from result
* Example:

	`result.getJSONArray("face").length()`

	`result.getJSONArray("face").getJSONObject(0).getString("face_id")`

	```
	result.getJSONArray("face").getJSONObject(0).getJSONObject("attribute")
	    .getJSONObject("gender").getDouble("confidence")
	```

## 5. Debug
1. View the post request
	
	`postParameters.getMultiPart().writeTo(System.out);`

2. View the result like a pure json

	`System.out.println(result)`

* a sample about multipart http post message

		--0soLYaK4lNBytrh912fNS15mSORsgy_J
		Content-Disposition: form-data; name="PERSON_NAME"
		Content-Type: text/plain; charset=US-ASCII
		Content-Transfer-Encoding: 8bit
		
		
		MY_PERSON_NAME
		--0soLYaK4lNBytrh912fNS15mSORsgy_J
		Content-Disposition: form-data; name="GROUP_NAME"
		Content-Type: text/plain; charset=US-ASCII
		Content-Transfer-Encoding: 8bit
		
		
		MY_GROUP_NAME
		--0soLYaK4lNBytrh912fNS15mSORsgy_J--


## 6. For Android
* note that you can not requst on **MainActivity**, you need to new a thread to do what you want

* note that you need add internet **uses-permission** into **AndroidManifest.xml**

	`<uses-permission android:name="android.permission.INTERNET"/>`

## 7. More sample codes

* FaceppDemo 
	
	An Java project with FaceppSDK

* FaceppAndroidDemo

	An Android project with FaceppSDK

* PictureDetect

	An Android application. To get a picture, detect with FaceppSDK, then mark all faces out.

## 7. Change Log
* 1.0.0

	The default api

* 1.1.0

	Add the new api `grouping' into SDK.

* 1.2.0

	Add https request method, and set it to default. We can use `debug = true` to  open http to instead of https.

* 2.0.0

	Face-Plus-Plus 2.0 has released. This SDK can use the new API now.

* 2.1.0

	Face-Plus-Plus 2.0 was free right now, and add more new function. This SDK can use the new API now.
	And, removing FaceppResult class, using JSONObject to instead of it to record the result.

* 2.1.1

	Fix bugs.