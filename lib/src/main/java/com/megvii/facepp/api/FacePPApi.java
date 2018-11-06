package com.megvii.facepp.api;

import com.megvii.facepp.api.bean.BankCardResponse;
import com.megvii.facepp.api.bean.BeautyResponse;
import com.megvii.facepp.api.bean.CompareResponse;
import com.megvii.facepp.api.bean.DetectResponse;
import com.megvii.facepp.api.bean.DriverLicenseResponse;
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
import com.megvii.facepp.api.bean.GestureResponse;
import com.megvii.facepp.api.bean.HumanBodyDetectResponse;
import com.megvii.facepp.api.bean.HumanSegmentResponse;
import com.megvii.facepp.api.bean.LicensePlatResponse;
import com.megvii.facepp.api.bean.MergeFaceResponse;
import com.megvii.facepp.api.bean.OcrIdCardResponse;
import com.megvii.facepp.api.bean.RecognizeTextRespons;
import com.megvii.facepp.api.bean.SceneDetectResponse;
import com.megvii.facepp.api.bean.SearchResponse;
import com.megvii.facepp.api.bean.SkeletonResponse;
import com.megvii.facepp.api.bean.VehicleResponse;
import com.megvii.facepp.api.face.FaceApi;
import com.megvii.facepp.api.face.IFaceApi;
import com.megvii.facepp.api.humanbody.HumanBodyApi;
import com.megvii.facepp.api.humanbody.IHumanBodyApi;
import com.megvii.facepp.api.image.IImageApi;
import com.megvii.facepp.api.image.ImageApi;
import com.megvii.facepp.api.ocr.IOcrApi;
import com.megvii.facepp.api.ocr.OcrApi;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个类是为了外部调用方便。外部只需要知道有个FacePPApi 就可以了
 *
 * @author by licheng on 2018/6/13.
 */
public class FacePPApi implements IFaceApi, IHumanBodyApi, IOcrApi, IImageApi {

    private static final String API_KEY = "api_key";
    private static final String API_SECRET = "api_secret";

    private Map<String, String> AUTH_INFO = new HashMap<>();

    // 人脸识别Api
    private IFaceApi faceApi = new FaceApi();
    // 证件识别Api
    private IOcrApi ocrApi = new OcrApi();
    // 图像识别Api
    private IImageApi imageApi = new ImageApi();
    // 人体识别Api
    private IHumanBodyApi humanBodyApi = new HumanBodyApi();

    public FacePPApi(String apiKey, String apiSecret) {
        AUTH_INFO.put(API_KEY, apiKey);
        AUTH_INFO.put(API_SECRET, apiSecret);
    }

    @Override
    public void detect(Map<String, String> params, IFacePPCallBack<DetectResponse> callBack) {
        faceApi.detect(buildParams(params), callBack);
    }

    @Override
    public void detect(Map<String, String> params, byte[] filePath, IFacePPCallBack<DetectResponse> callBack) {
        faceApi.detect(buildParams(params), filePath, callBack);
    }

    @Override
    public void compare(Map<String, String> params, IFacePPCallBack<CompareResponse> callBack) {
        faceApi.compare(buildParams(params), callBack);
    }

    @Override
    public void compare(Map<String, String> params, Map<String, byte[]> file_1, IFacePPCallBack<CompareResponse> callBack) {
        faceApi.compare(buildParams(params), file_1, callBack);
    }

    @Override
    public void compare(Map<String, String> params, byte[] file_1, byte[] file_2, IFacePPCallBack<CompareResponse> callBack) {
        faceApi.compare(buildParams(params), file_1, file_2, callBack);
    }

    @Override
    public void search(Map<String, String> params, IFacePPCallBack<SearchResponse> callBack) {
        faceApi.search(buildParams(params), callBack);
    }

    @Override
    public void search(Map<String, String> params, byte[] filePath, IFacePPCallBack<SearchResponse> callBack) {
        faceApi.search(buildParams(params), filePath, callBack);
    }

    @Override
    public void facesetCreate(Map<String, String> params, IFacePPCallBack<FaceSetCreatResponse> callBack) {
        faceApi.facesetCreate(buildParams(params), callBack);
    }

    @Override
    public void facesetAddFace(Map<String, String> params, IFacePPCallBack<FaceSetAddResponse> callBack) {
        faceApi.facesetAddFace(buildParams(params), callBack);
    }

    @Override
    public void facesetRemoveFace(Map<String, String> params, IFacePPCallBack<FaceSetRemoveResponse> callBack) {
        faceApi.facesetRemoveFace(buildParams(params), callBack);
    }

    @Override
    public void facesetUpdate(Map<String, String> params, IFacePPCallBack<FaceSetUpdateResponse> callBack) {
        faceApi.facesetUpdate(buildParams(params), callBack);
    }

    @Override
    public void facesetDetail(Map<String, String> params, IFacePPCallBack<FaceSetDetailResponse> callBack) {
        faceApi.facesetDetail(buildParams(params), callBack);
    }

    @Override
    public void facesetDelete(Map<String, String> params, IFacePPCallBack<FaceSetDeleteResponse> callBack) {
        faceApi.facesetDelete(buildParams(params), callBack);
    }

    @Override
    public void facesetList(Map<String, String> params, IFacePPCallBack<FaceSetListResponse> callBack) {
        faceApi.facesetList(buildParams(params), callBack);
    }

    @Override
    public void faceAnalyze(Map<String, String> params, IFacePPCallBack<FaceAnalyzeResponse> callBack) {
        faceApi.faceAnalyze(buildParams(params), callBack);
    }

    @Override
    public void faceDetail(Map<String, String> params, IFacePPCallBack<FaceDetailResponse> callBack) {
        faceApi.faceDetail(buildParams(params), callBack);
    }

    @Override
    public void setFaceUserId(Map<String, String> params, IFacePPCallBack<FaceToken> callBack) {
        faceApi.setFaceUserId(buildParams(params), callBack);
    }

    @Override
    public void beautify(Map<String, String> params, IFacePPCallBack<BeautyResponse> callBack) {
        faceApi.beautify(buildParams(params), callBack);
    }

    @Override
    public void beautify(Map<String, String> params, byte[] filePath, IFacePPCallBack<BeautyResponse> callBack) {
        faceApi.beautify(buildParams(params), filePath, callBack);
    }

    @Override
    public void facesetAddFaceAsync(Map<String, String> params, IFacePPCallBack<FaceSetAddResponse> callBack) {
        faceApi.facesetAddFaceAsync(buildParams(params), callBack);
    }

    @Override
    public void facesetRemoveFaceAsync(Map<String, String> params, IFacePPCallBack<FaceSetRemoveResponse> callBack) {
        faceApi.facesetRemoveFaceAsync(buildParams(params), callBack);
    }

    @Override
    public void facesetTaskQuery(Map<String, String> params, IFacePPCallBack<TaskQueryResponse> callBack) {
        faceApi.facesetTaskQuery(buildParams(params), callBack);
    }

    /***********************************************************************************************/

    @Override
    public void detectHumanBody(Map<String, String> params, IFacePPCallBack<HumanBodyDetectResponse> callBack) {
        humanBodyApi.detectHumanBody(buildParams(params), callBack);
    }

    @Override
    public void detectHumanBody(Map<String, String> params, byte[] filePath, IFacePPCallBack<HumanBodyDetectResponse> callBack) {
        humanBodyApi.detectHumanBody(buildParams(params), filePath, callBack);
    }

    @Override
    public void segment(Map<String, String> params, IFacePPCallBack<HumanSegmentResponse> callBack) {
        humanBodyApi.segment(buildParams(params), callBack);
    }

    @Override
    public void segment(Map<String, String> params, byte[] filePath, IFacePPCallBack<HumanSegmentResponse> callBack) {
        humanBodyApi.segment(buildParams(params), filePath, callBack);
    }

    @Override
    public void gesture(Map<String, String> params, IFacePPCallBack<GestureResponse> callBack) {
        humanBodyApi.gesture(buildParams(params), callBack);
    }

    @Override
    public void gesture(Map<String, String> params, byte[] filePath, IFacePPCallBack<GestureResponse> callBack) {
        humanBodyApi.gesture(buildParams(params), filePath, callBack);
    }

    @Override
    public void skeleton(Map<String, String> params, IFacePPCallBack<SkeletonResponse> callBack) {
        humanBodyApi.skeleton(buildParams(params), callBack);
    }

    @Override
    public void skeleton(Map<String, String> params, byte[] filePath, IFacePPCallBack<SkeletonResponse> callBack) {
        humanBodyApi.skeleton(buildParams(params), filePath, callBack);
    }

    /***********************************************************************************************/

    @Override
    public void ocrIDCard(Map<String, String> params, IFacePPCallBack<OcrIdCardResponse> callBack) {
        ocrApi.ocrIDCard(buildParams(params), callBack);
    }

    @Override
    public void ocrIDCard(Map<String, String> params, byte[] filePath, IFacePPCallBack<OcrIdCardResponse> callBack) {
        ocrApi.ocrIDCard(buildParams(params), filePath, callBack);
    }

    @Override
    public void ocrDriver(Map<String, String> params, IFacePPCallBack<DriverLicenseResponse> callBack) {
        ocrApi.ocrDriver(buildParams(params), callBack);
    }

    @Override
    public void ocrDriver(Map<String, String> params, byte[] filePath, IFacePPCallBack<DriverLicenseResponse> callBack) {
        ocrApi.ocrDriver(buildParams(params), filePath, callBack);
    }

    @Override
    public void ocrVehicle(Map<String, String> params, IFacePPCallBack<VehicleResponse> callBack) {
        ocrApi.ocrVehicle(buildParams(params), callBack);
    }

    @Override
    public void ocrVehicle(Map<String, String> params, byte[] filePath, IFacePPCallBack<VehicleResponse> callBack) {
        ocrApi.ocrVehicle(buildParams(params), filePath, callBack);
    }

    @Override
    public void ocrBankCard(Map<String, String> params, IFacePPCallBack<BankCardResponse> callBack) {
        ocrApi.ocrBankCard(buildParams(params), callBack);
    }

    @Override
    public void ocrBankCard(Map<String, String> params, byte[] filePath, IFacePPCallBack<BankCardResponse> callBack) {
        ocrApi.ocrBankCard(buildParams(params), filePath, callBack);
    }

    /***********************************************************************************************/

    @Override
    public void detectScene(Map<String, String> params, IFacePPCallBack<SceneDetectResponse> callBack) {
        imageApi.detectScene(buildParams(params), callBack);
    }

    @Override
    public void detectScene(Map<String, String> params, byte[] filePath, IFacePPCallBack<SceneDetectResponse> callBack) {
        imageApi.detectScene(buildParams(params), filePath, callBack);
    }

    @Override
    public void recognizeText(Map<String, String> params, IFacePPCallBack<RecognizeTextRespons> callBack) {
        imageApi.recognizeText(buildParams(params), callBack);
    }

    @Override
    public void recognizeText(Map<String, String> params, byte[] filePath, IFacePPCallBack<RecognizeTextRespons> callBack) {
        imageApi.recognizeText(buildParams(params), filePath, callBack);
    }

    @Override
    public void mergeFace(Map<String, String> params, IFacePPCallBack<MergeFaceResponse> callBack) {
        imageApi.mergeFace(buildParams(params), callBack);
    }

    @Override
    public void mergeFace(Map<String, String> params, Map<String, byte[]> filePath, IFacePPCallBack<MergeFaceResponse> callBack) {
        imageApi.mergeFace(buildParams(params), filePath, callBack);
    }

    @Override
    public void mergeFace(Map<String, String> params, Map<String, byte[]> file1, Map<String, byte[]> file2, IFacePPCallBack<MergeFaceResponse> callBack) {
        imageApi.mergeFace(buildParams(params), file1, file2, callBack);
    }

    @Override
    public void mergeFace(Map<String, String> params, byte[] template_file, byte[] merge_file, IFacePPCallBack<MergeFaceResponse> callBack) {
        imageApi.mergeFace(buildParams(params), template_file, merge_file, callBack);
    }

    @Override
    public void recognizePlat(Map<String, String> params, IFacePPCallBack<LicensePlatResponse> callBack) {
        imageApi.recognizePlat(buildParams(params), callBack);
    }

    @Override
    public void recognizePlat(Map<String, String> params, byte[] filePath, IFacePPCallBack<LicensePlatResponse> callBack) {
        imageApi.recognizePlat(buildParams(params), filePath, callBack);
    }

    private Map<String, String> buildParams(Map<String, String> params) {
        if (null != params) {
            params.putAll(AUTH_INFO);
        } else {
            params = new HashMap<>(AUTH_INFO);
        }
        return params;
    }
}
