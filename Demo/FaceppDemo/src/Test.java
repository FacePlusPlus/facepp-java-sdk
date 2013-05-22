import java.nio.charset.Charset;
import java.util.ArrayList;

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.facepp.result.FaceppResult;


public class Test {

public static void main(String[] args) {
		
		//replace api_key and api_secret here (note)
		HttpRequests httpRequests = new HttpRequests("api_key", "api_secret", true, true);
		
		FaceppResult result = null;
		
		try {
			
			System.out.println(Charset.forName("UTF-8").name());
		
			System.out.println("FacePlusPlus API Test:");
			
			//detection/detect
			result = httpRequests.detectionDetect(new PostParameters().setUrl("http://cn.faceplusplus.com/wp-content/themes/faceplusplus.zh/assets/img/demo/9.jpg"));
			System.out.println(result);
			
			System.out.println(result.get("face").get(0).get("position").get("center"));
			
			//-----------------Person-----------------
			//person/create
			System.out.println("\nperson/create");
			for (int i = 0; i < result.get("face").getCount(); ++i)
				System.out.println(httpRequests.personCreate(new PostParameters().setPersonName("person_"+i)));
			
			new PostParameters().setPersonName("person_"+0).setFaceId(result.get("face").get(0).get("face_id").toString()).getMultiPart().writeTo(System.out);
			
			//person/add_face
			System.out.println("\nperson/add_face");
			for (int i = 0; i < result.get("face").getCount(); ++i)
				System.out.println(httpRequests.personAddFace(new PostParameters().setPersonName("person_"+i).setFaceId(result.get("face").get(i).get("face_id").toString())));
			
			//person/set_info
			System.out.println("\nperson/set_info");
			for (int i = 0; i < result.get("face").getCount(); ++i) {
				new PostParameters().setPersonName("person_"+i).setTag("中文 tag_"+i).getMultiPart().writeTo(System.out);
				System.out.println(httpRequests.personSetInfo(new PostParameters().setPersonName("person_"+i).setTag("中文 tag_"+i)));
			}
			
			//person/get_info
			System.out.println("\nperson/get_info");
			for (int i = 0; i < result.get("face").getCount(); ++i)
				System.out.println(httpRequests.personGetInfo(new PostParameters().setPersonName("person_"+i)));
			
			
			
			//-----------------Group-----------------
			//group/create
			System.out.println("\ngroup/create");
			System.out.println(httpRequests.groupCreate(new PostParameters().setGroupName("group_0")));
			
			//group/add_person
			System.out.println("\ngroup/add_person");
			ArrayList<String> personList = new ArrayList<String>();
			for (int i = 0; i < result.get("face").getCount(); ++i)
				personList.add("person_"+i);
			
			new PostParameters().setGroupName("group_0").setPersonName(personList).getMultiPart().writeTo(System.out);
			System.out.println(httpRequests.groupAddPerson(new PostParameters().setGroupName("group_0").setPersonName(personList)));
			
			//group/set_info
			System.out.println("\ngroup/set_info");
			System.out.println(httpRequests.groupSetInfo(new PostParameters().setGroupName("group_0").setTag("group tag")));
			
			//group/get_info
			System.out.println("\ngroup/get_info");
			System.out.println(httpRequests.groupGetInfo(new PostParameters().setGroupName("group_0")));
			
			
			//-----------------Recognition-----------------
			
			//recognition/train
			FaceppResult syncRet = null; 
			
			System.out.println("\ntrain/Identify");
			syncRet = httpRequests.trainIdentify(new PostParameters().setGroupName("group_0"));
			System.out.println(syncRet);
			System.out.println(httpRequests.getSessionSync(syncRet.get("session_id").toString()));
			
			System.out.println("\ntrain/verify");
			for (int i = 0; i < result.get("face").getCount(); ++i) {
				syncRet = httpRequests.trainVerify(new PostParameters().setPersonName("person_" + i));
				System.out.println(httpRequests.getSessionSync(syncRet.get("session_id").toString()));
			}
			
			//recognition/recognize
			System.out.println("\nrecognition/identify");
			System.out.println(httpRequests.recognitionIdentify(new PostParameters().setGroupName("group_0").setUrl("http://cn.faceplusplus.com/wp-content/themes/faceplusplus.zh/assets/img/demo/5.jpg")));
			
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
			System.out.println(httpRequests.groupDelete(new PostParameters().setGroupName("group_0")));
			
			//person/delete
			System.out.println("\nperson/delete");
			System.out.println(httpRequests.personDelete(new PostParameters().setPersonName("person_0")));
			
		} catch(FaceppParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
		} finally {
			try {
				for (int i = 1; i < result.get("face").getCount(); ++i)
					httpRequests.personDelete(new PostParameters().setPersonName("person_"+i));
			} catch (FaceppParseException e) {
				e.printStackTrace();
			}
		}
	}
}
