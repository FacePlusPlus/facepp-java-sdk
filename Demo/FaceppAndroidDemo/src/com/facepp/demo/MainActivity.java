package com.facepp.demo;

import java.io.IOException;
import java.util.ArrayList;

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.facepp.result.FaceppResult;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

/**
 * Facepp SDK Android test
 * 
 * Look result at debug area.(Log cat)
 * @author moon5ckq
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        new Thread(new Runnable() {
			public void run() {
				HttpRequests httpRequests = new HttpRequests("api_key", "api_secret");
				
				FaceppResult result = null;
				
				try {
				
					System.out.println("FacePlusPlus API Test:");
					
					//detection/detect
					result = httpRequests.detectionDetect(new PostParameters().setUrl("http://faceplusplus.com/static/img/demo/20.jpg"));
					System.out.println(result);
					
					//-----------------Person-----------------
					//person/create
					System.out.println("\nperson/create");
					for (int i = 0; i < result.get("face").getCount(); ++i)
						System.out.println(httpRequests.personCreate(new PostParameters().setPersonName("person_"+i)));
					
					//person/add_face
					System.out.println("\nperson/add_face");
					for (int i = 0; i < result.get("face").getCount(); ++i)
						System.out.println(httpRequests.personAddFace(new PostParameters().setPersonName("person_"+i).setFaceId(result.get("face").get(i).get("face_id").toString())));
					
					//person/set_info
					System.out.println("\nperson/set_info");
					for (int i = 0; i < result.get("face").getCount(); ++i)
						System.out.println(httpRequests.personSetInfo(new PostParameters().setPersonName("person_"+i).setTag("tag_"+i)));
					
					//person/get_info
					System.out.println("\nperson/get_info");
					for (int i = 0; i < result.get("face").getCount(); ++i)
						System.out.println(httpRequests.personGetInfo(new PostParameters().setPersonName("person_"+i)));
					
					
					
					//-----------------Group-----------------
					//group/create
					System.out.println("\ngroup/create");
					System.out.println(httpRequests.groupCreate(new PostParameters().setGroupName("group_test")));
					
					//group/add_person
					System.out.println("\ngroup/add_person");
					ArrayList<String> personList = new ArrayList<String>();
					for (int i = 0; i < result.get("face").getCount(); ++i)
						personList.add("person_"+i);
					System.out.println(httpRequests.groupAddPerson(new PostParameters().setGroupName("group_test").setPersonName(personList)));
					
					//group/set_info
					System.out.println("\ngroup/set_info");
					System.out.println(httpRequests.groupSetInfo(new PostParameters().setGroupName("group_test").setTag("group tag")));
					
					//group/get_info
					System.out.println("\ngroup/get_info");
					System.out.println(httpRequests.groupGetInfo(new PostParameters().setGroupName("group_test")));
					
					
					//-----------------Recognition-----------------
					//recognition/compare
					System.out.println("\nrecognition/compare");
					System.out.println(httpRequests.recognitionCompare(
							new PostParameters().setFaceId1(result.get("face").get(0).get("face_id").toString()).setFaceId2(result.get("face").get(1).get("face_id").toString())));
					
					//recognition/train
					System.out.println("\nrecognition/train");
					System.out.println(httpRequests.train(new PostParameters().setGroupName("group_test").setType("all")));
					
					//recognition/recognize
					System.out.println("\nrecognition/recognize");
					System.out.println(httpRequests.recognitionRecognize(new PostParameters().setGroupName("group_test").setUrl("http://faceplusplus.com/static/img/demo/20.jpg")));
					
					//recognition/search
					System.out.println("\nrecognition/search");
					System.out.println(httpRequests.recognitionSearch(new PostParameters().setGroupName("group_test").setKeyFaceId(result.get("face").get(0).get("face_id").toString())));
					
					//recognition/verify
					System.out.println("\nrecognition/verify");
					System.out.println(httpRequests.recognitionVerify(new PostParameters().setPersonName("person_0").setFaceId(result.get("face").get(0).get("face_id").toString())));
					System.out.println(httpRequests.recognitionVerify(new PostParameters().setPersonName("person_1").setFaceId(result.get("face").get(0).get("face_id").toString())));
					
					//-----------------Info-----------------
					//info/get_app
					System.out.println("\ninfo/get_app");
					System.out.println(httpRequests.infoGetApp());
					
					//info/get_face
					System.out.println("\ninfo/get_app");
					System.out.println(httpRequests.infoGetFace(new PostParameters().setFaceId(result.get("face").get(0).get("face_id").toString())));
					
					//info/get_group_list
					System.out.println("\ninfo/get_group_list");
					System.out.println(httpRequests.infoGetGroupList());
					
					//info/get_image
					System.out.println("\ninfo/get_image");
					System.out.println(httpRequests.infoGetImage(new PostParameters().setImgId(result.get("img_id").toString())));
					
					//info/get_person_list
					System.out.println("\ninfo/get_person_list");
					System.out.println(httpRequests.infoGetPersonList());
					
					//info/get_quota
					System.out.println("\ninfo/get_quota");
					System.out.println(httpRequests.infoGetQuota());
					
					//info/get_session
					System.out.println("\ninfo/get_session");
					System.out.println(httpRequests.infoGetSession(new PostParameters().setSessionId(result.get("session_id").toString())));
					
					
					//-----At last----
					//person/remove_face
					System.out.println("\nperson/remove_face");
					System.out.println(httpRequests.personRemoveFace(new PostParameters().setPersonName("person_0").setFaceId(result.get("face").get(0).get("face_id").toString())));
					
					//group/delete
					System.out.println("\ngroup/delete");
					System.out.println(httpRequests.groupDelete(new PostParameters().setGroupName("group_test")));
					
					//person/delete
					System.out.println("\nperson/delete");
					System.out.println(httpRequests.personDelete(new PostParameters().setPersonName("person_0")));
					
				} catch(FaceppParseException e) {
					e.printStackTrace();
				} catch (Exception e) {
				} finally {
					
					//delete all person
					try {
						for (int i = 1; i < result.get("face").getCount(); ++i) {
							try {		
								httpRequests.personDelete(new PostParameters().setPersonName("person_"+i));
							} catch (FaceppParseException e) {
								e.printStackTrace();
							}
						}
					} catch (FaceppParseException e) {
						e.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				try {
					//-----Debug----
					//How to watch what's the http post sent?
					//If we have a PostParameters object, we can do .getMultiPart().wrtieTo(outputStream) to watch the message.
					System.out.println("\nDebug");
					System.out.println("=========message=========");
					PostParameters postParameters = new PostParameters().setPersonName("a person").setGroupName("a group");
					postParameters.getMultiPart().writeTo(System.out);
					System.out.println("=========message=========");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
