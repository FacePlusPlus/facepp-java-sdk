package com.megvii.facepp.api.image;

import com.megvii.facepp.api.IFacePPCallBack;
import com.megvii.facepp.api.bean.LicensePlatResponse;
import com.megvii.facepp.api.bean.MergeFaceResponse;
import com.megvii.facepp.api.bean.RecognizeTextRespons;
import com.megvii.facepp.api.bean.SceneDetectResponse;

import java.util.Map;

/**
 * @author by licheng on 2018/7/3.
 */

public interface IImageApi {

    String BASE_URL = "https://api-cn.faceplusplus.com/imagepp";

    String API_IMAGE_SCENE_DETECT = BASE_URL + "/beta/detectsceneandobject";
    String API_IMAGE_RECOGNIZE_TEXT = BASE_URL + "/v1/recognizetext";
    String API_IMAGE_MERGE_FACE = BASE_URL + "/v1/mergeface";
    String API_IMAGE_LICENSE_PLATE = BASE_URL + "/v1/licenseplate";

    /**
     * 场景识别
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/5671708">场景识别 Api文档</>
     */
    void detectScene(Map<String, String> params, IFacePPCallBack<SceneDetectResponse> callBack);

    void detectScene(Map<String, String> params, byte[] filePath, IFacePPCallBack<SceneDetectResponse> callBack);

    /**
     * 文字识别
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/7776484">文字识别 Api文档</>
     */
    void recognizeText(Map<String, String> params, IFacePPCallBack<RecognizeTextRespons> callBack);

    void recognizeText(Map<String, String> params, byte[] filePath, IFacePPCallBack<RecognizeTextRespons> callBack);

    /**
     * 人脸融合
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/20813963">人脸融合 Api文档</>
     */
    void mergeFace(Map<String, String> params, IFacePPCallBack<MergeFaceResponse> callBack);

    void mergeFace(Map<String, String> params, Map<String, byte[]> filePath, IFacePPCallBack<MergeFaceResponse> callBack);

    void mergeFace(Map<String, String> params, byte[] template_file, byte[] merge_file, IFacePPCallBack<MergeFaceResponse> callBack);

    void mergeFace(Map<String, String> params, Map<String, byte[]> file1, Map<String, byte[]> file2, IFacePPCallBack<MergeFaceResponse> callBack);

    /**
     * 车牌识别
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/33915254">车牌识别 Api文档</>
     */
    void recognizePlat(Map<String, String> params, IFacePPCallBack<LicensePlatResponse> callBack);

    void recognizePlat(Map<String, String> params, byte[] filePath, IFacePPCallBack<LicensePlatResponse> callBack);
}
