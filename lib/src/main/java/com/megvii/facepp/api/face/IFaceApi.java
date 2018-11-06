package com.megvii.facepp.api.face;

import com.megvii.facepp.api.IFacePPCallBack;
import com.megvii.facepp.api.TaskQueryResponse;
import com.megvii.facepp.api.bean.BeautyResponse;
import com.megvii.facepp.api.bean.CompareResponse;
import com.megvii.facepp.api.bean.DetectResponse;
import com.megvii.facepp.api.bean.FaceAnalyzeResponse;
import com.megvii.facepp.api.bean.FaceDetailResponse;
import com.megvii.facepp.api.bean.FaceSetAddResponse;
import com.megvii.facepp.api.bean.FaceSetCreatResponse;
import com.megvii.facepp.api.bean.FaceSetDeleteResponse;
import com.megvii.facepp.api.bean.FaceSetDetailResponse;
import com.megvii.facepp.api.bean.FaceSetListResponse;
import com.megvii.facepp.api.bean.FaceSetRemoveResponse;
import com.megvii.facepp.api.bean.FaceSetUpdateResponse;
import com.megvii.facepp.api.bean.FaceToken;
import com.megvii.facepp.api.bean.SearchResponse;

import java.util.Map;

/**
 * @author by licheng on 2018/7/3.
 */

public interface IFaceApi {

    String BASE_URL = "https://api-cn.faceplusplus.com/facepp";

    String API_DETECT = BASE_URL + "/v3/detect";
    String API_COMPARE = BASE_URL + "/v3/compare";
    String API_SEARCH = BASE_URL + "/v3/search";
    String API_FACE_SET_CREATE = BASE_URL + "/v3/faceset/create";
    String API_FACE_SET_ADD_FACE = BASE_URL + "/v3/faceset/addface";
    String API_FACE_SET_REMOVE_FACE = BASE_URL + "/v3/faceset/removeface";
    String API_FACE_SET_UPDATE = BASE_URL + "/v3/faceset/update";
    String API_FACE_SET_GET_FACESETS = BASE_URL + "/v3/faceset/getfacesets";
    String API_FACE_SET_GET_DETAIL = BASE_URL + "/v3/faceset/getdetail";
    String API_FACE_SET_DELETE = BASE_URL + "/v3/faceset/delete";

    String API_FACE_SET_ADD_FACE_ASYNC = BASE_URL + "/v3/faceset/async/addface";
    String API_FACE_SET_REMOVE_FACE_ASYNC = BASE_URL + "/v3/faceset/async/removeface";
    String API_FACE_SET_TASK_QUERY = BASE_URL + "/v3/faceset/async/task_status";

    String API_FACE_ANALYZE = BASE_URL + "/v3/face/analyze";
    String API_FACE_GET_DETAIL = BASE_URL + "/v3/face/getdetail";
    String API_FACE_SET_USER_ID = BASE_URL + "/v3/face/setuserid";

    String API_BEAUTY = BASE_URL + "/beta/beautify";

    /**
     * 人脸检测
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888373">detect Api文档</>
     */
    void detect(Map<String, String> params, IFacePPCallBack<DetectResponse> callBack);

    void detect(Map<String, String> params, byte[] filePath, IFacePPCallBack<DetectResponse> callBack);

    /**
     * 人脸对比
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4887586">compare Api文档</>
     */
    void compare(Map<String, String> params, IFacePPCallBack<CompareResponse> callBack);

    void compare(Map<String, String> params, Map<String, byte[]> file_1, IFacePPCallBack<CompareResponse> callBack);

    void compare(Map<String, String> params, byte[] file_1, byte[] file_2, IFacePPCallBack<CompareResponse> callBack);

    /**
     * 从 faceSet 中检索人脸
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888381">search Api文档</>
     */
    void search(Map<String, String> params, IFacePPCallBack<SearchResponse> callBack);

    void search(Map<String, String> params, byte[] filePath, IFacePPCallBack<SearchResponse> callBack);

    /**
     * 创建 faceSet
     *
     * @see <a href="https://api-cn.faceplusplus.com/facepp/v3/faceset/create">faceset/create Api文档</>
     */
    void facesetCreate(Map<String, String> params, IFacePPCallBack<FaceSetCreatResponse> callBack);

    /**
     * 向 faceset 添加人脸
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888389">faceset/addface Api文档</>
     */
    void facesetAddFace(Map<String, String> params, IFacePPCallBack<FaceSetAddResponse> callBack);

    /**
     * 从 faceSet 中删除人脸
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888399">faceset/removeface Api文档</>
     */
    void facesetRemoveFace(Map<String, String> params, IFacePPCallBack<FaceSetRemoveResponse> callBack);

    /**
     * 更新 faceSet 的信息
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888401">faceset/update Api文档</>
     */
    void facesetUpdate(Map<String, String> params, IFacePPCallBack<FaceSetUpdateResponse> callBack);

    /**
     * 获取 faceSet 的详细信息
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888395">faceset/getdetail Api文档</>
     */
    void facesetDetail(Map<String, String> params, IFacePPCallBack<FaceSetDetailResponse> callBack);

    /**
     * 删除 faceSet
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888393">faceset/delete Api文档</>
     */
    void facesetDelete(Map<String, String> params, IFacePPCallBack<FaceSetDeleteResponse> callBack);

    /**
     * 获取 Api key 下的 faceSet 列表
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888397">faceset/getfacesets Api文档</>
     */
    void facesetList(Map<String, String> params, IFacePPCallBack<FaceSetListResponse> callBack);

    /**
     * 分析 faceToken（最多5个），得到关键点、属性等信息
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888383">face/analyze Api文档</>
     */
    void faceAnalyze(Map<String, String> params, IFacePPCallBack<FaceAnalyzeResponse> callBack);

    /**
     * 获取 faceToken 信息，image_id，人脸框，所属 faceSet
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888385">face/getdetail Api文档</>
     */
    void faceDetail(Map<String, String> params, IFacePPCallBack<FaceDetailResponse> callBack);

    /**
     * 给 faceToken 设置 user_id（方便对接客户业务系统）
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888387">face/setuserid Api文档</>
     */
    void setFaceUserId(Map<String, String> params, IFacePPCallBack<FaceToken> callBack);

    /**
     * 人脸美化（美白+磨皮）
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/34878217">beautify Api文档</>
     */
    void beautify(Map<String, String> params, IFacePPCallBack<BeautyResponse> callBack);

    void beautify(Map<String, String> params, byte[] filePath, IFacePPCallBack<BeautyResponse> callBack);

    /**
     * 向 faceset 添加人脸
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888389">faceset/addface Api文档</>
     */
    void facesetAddFaceAsync(Map<String, String> params, IFacePPCallBack<FaceSetAddResponse> callBack);

    /**
     * 从 faceSet 中删除人脸
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888399">faceset/removeface Api文档</>
     */
    void facesetRemoveFaceAsync(Map<String, String> params, IFacePPCallBack<FaceSetRemoveResponse> callBack);

    /**
     * 查询之前调用的异步添加/删除人脸请求，异步任务当前的状态
     *
     * @<a href="https://console.faceplusplus.com.cn/documents/40622157">faceset/taskQuery Api文档</>
     */
    void facesetTaskQuery(Map<String, String> params, IFacePPCallBack<TaskQueryResponse> callBack);

}
