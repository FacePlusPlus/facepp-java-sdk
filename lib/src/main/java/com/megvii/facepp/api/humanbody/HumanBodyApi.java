package com.megvii.facepp.api.humanbody;

import com.megvii.facepp.api.HttpUtils;
import com.megvii.facepp.api.IFacePPCallBack;
import com.megvii.facepp.api.TransCallBack;
import com.megvii.facepp.api.bean.GestureResponse;
import com.megvii.facepp.api.bean.HumanBodyDetectResponse;
import com.megvii.facepp.api.bean.HumanSegmentResponse;
import com.megvii.facepp.api.bean.SkeletonResponse;

import java.util.Map;

/**
 * @author by licheng on 2018/7/3.
 */

public class HumanBodyApi implements IHumanBodyApi {

    @Override
    public void detectHumanBody(Map<String, String> params, IFacePPCallBack<HumanBodyDetectResponse> callBack) {
        detectHumanBody(params, null, callBack);
    }

    @Override
    public void detectHumanBody(Map<String, String> params, byte[] filePath, IFacePPCallBack<HumanBodyDetectResponse> callBack) {
        HttpUtils.post(API_HUMANBODY_DETECT, params, filePath, new TransCallBack<>(callBack, HumanBodyDetectResponse.class));
    }

    @Override
    public void segment(Map<String, String> params, IFacePPCallBack<HumanSegmentResponse> callBack) {
        segment(params, null, callBack);
    }

    @Override
    public void segment(Map<String, String> params, byte[] filePath, IFacePPCallBack<HumanSegmentResponse> callBack) {
        HttpUtils.post(API_HUMANBODY_SEGMENT, params, filePath, new TransCallBack<>(callBack, HumanSegmentResponse.class));
    }

    @Override
    public void gesture(Map<String, String> params, IFacePPCallBack<GestureResponse> callBack) {
        gesture(params, null, callBack);
    }

    @Override
    public void gesture(Map<String, String> params, byte[] filePath, IFacePPCallBack<GestureResponse> callBack) {
        HttpUtils.post(API_HUMANBODY_GUSTURE, params, filePath, new TransCallBack<>(callBack, GestureResponse.class));
    }

    @Override
    public void skeleton(Map<String, String> params, IFacePPCallBack<SkeletonResponse> callBack) {
        skeleton(params, null, callBack);
    }

    @Override
    public void skeleton(Map<String, String> params, byte[] filePath, IFacePPCallBack<SkeletonResponse> callBack) {
        HttpUtils.post(API_HUMANBODY_SKELETON, params, filePath, new TransCallBack<>(callBack, SkeletonResponse.class));
    }
}
