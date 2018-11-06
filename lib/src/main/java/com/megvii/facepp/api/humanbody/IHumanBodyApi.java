package com.megvii.facepp.api.humanbody;

import com.megvii.facepp.api.IFacePPCallBack;
import com.megvii.facepp.api.bean.GestureResponse;
import com.megvii.facepp.api.bean.HumanBodyDetectResponse;
import com.megvii.facepp.api.bean.HumanSegmentResponse;
import com.megvii.facepp.api.bean.SkeletonResponse;

import java.util.Map;

/**
 * @author by licheng on 2018/7/3.
 */

public interface IHumanBodyApi {

    String BASE_URL = "https://api-cn.faceplusplus.com/humanbodypp";

    String API_HUMANBODY_DETECT = BASE_URL + "/v1/detect";
    String API_HUMANBODY_SEGMENT = BASE_URL + "/v2/segment";
    String API_HUMANBODY_GUSTURE = BASE_URL + "/beta/gesture";
    String API_HUMANBODY_SKELETON = BASE_URL + "/v1/skeleton";

    /**
     * 人体检测和人体属性分析
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/10071565">人体检测和人体属性分析 Api文档</>
     */
    void detectHumanBody(Map<String, String> params, IFacePPCallBack<HumanBodyDetectResponse> callBack);

    void detectHumanBody(Map<String, String> params, byte[] filePath, IFacePPCallBack<HumanBodyDetectResponse> callBack);

    /**
     * 人形抠像
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/10071567">人形抠像 Api文档</>
     */
    void segment(Map<String, String> params, IFacePPCallBack<HumanSegmentResponse> callBack);

    void segment(Map<String, String> params, byte[] filePath, IFacePPCallBack<HumanSegmentResponse> callBack);

    /**
     * 手势识别
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/10065649">手势识别 Api文档</>
     */
    void gesture(Map<String, String> params, IFacePPCallBack<GestureResponse> callBack);

    void gesture(Map<String, String> params, byte[] filePath, IFacePPCallBack<GestureResponse> callBack);

    /**
     * 人体骨骼
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/37664576">人体骨骼 Api文档</>
     */
    void skeleton(Map<String, String> params, IFacePPCallBack<SkeletonResponse> callBack);

    void skeleton(Map<String, String> params, byte[] filePath, IFacePPCallBack<SkeletonResponse> callBack);
}
