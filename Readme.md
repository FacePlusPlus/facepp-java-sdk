# FacePlusPlus Java SDK

This SDK uses apache.http lib and json lib.

## 1. Install
1. download [facepp.jar](http://faceplusplus.com/static/sdk/java/facepp.jar);
2. add it to java project.

## 2. Import package
* `import com.facepp.*;`

	or

* AutoComplete it with your editor or IDE.

## 3. Call FaceppAPI
1. create a com.facepp.http.HttpRequests object

	`HttpRequests httpRequests = new HttpRequests(you_api_key_string, you_api_secret_string);`

2. create a com.facepp.http.PostParameters object with all parameters

	`PostParameters postParameters = new PostParameters().setUrl("http://faceplusplus.com/static/img/demo/8.jpg").setAttribute("all");`

3. request

	`httpRequests.request("detection", "detect", postParameters);`

	or

	`httpRequests.detectionDetect(postParameters);`


4. get the result use the com.facepp.json.FaceppJson object

	`FaceppResult result = httpRequests.detectionDetect(postParameters);`

## 4. Get value from result
* Example:

	`result.get("face").getCount()`

	`result.get("face").get(0).get("face_id").toString()`

	`result.get("face").get(0).get("").toString("attribute").get("gender").get("confidence").toDouble()`

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
