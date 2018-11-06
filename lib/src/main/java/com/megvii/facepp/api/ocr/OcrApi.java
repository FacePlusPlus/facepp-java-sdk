package com.megvii.facepp.api.ocr;

import com.megvii.facepp.api.HttpUtils;
import com.megvii.facepp.api.IFacePPCallBack;
import com.megvii.facepp.api.TransCallBack;
import com.megvii.facepp.api.bean.BankCardResponse;
import com.megvii.facepp.api.bean.DriverLicenseResponse;
import com.megvii.facepp.api.bean.OcrIdCardResponse;
import com.megvii.facepp.api.bean.VehicleResponse;

import java.util.Map;

/**
 * @author by licheng on 2018/7/3.
 */

public class OcrApi implements IOcrApi {

    @Override
    public void ocrIDCard(Map<String, String> params, IFacePPCallBack<OcrIdCardResponse> callBack) {
        ocrIDCard(params, null, callBack);
    }

    @Override
    public void ocrIDCard(Map<String, String> params, byte[] filePath, IFacePPCallBack<OcrIdCardResponse> callBack) {
        HttpUtils.post(API_OCR_IDCARD, params, filePath, new TransCallBack<>(callBack, OcrIdCardResponse.class));
    }

    @Override
    public void ocrDriver(Map<String, String> params, IFacePPCallBack<DriverLicenseResponse> callBack) {
        ocrDriver(params, null, callBack);
    }

    @Override
    public void ocrDriver(Map<String, String> params, byte[] filePath, IFacePPCallBack<DriverLicenseResponse> callBack) {
        HttpUtils.post(API_OCR_DRIVER_LICENSE, params, filePath, new TransCallBack<>(callBack, DriverLicenseResponse.class));
    }

    @Override
    public void ocrVehicle(Map<String, String> params, IFacePPCallBack<VehicleResponse> callBack) {
        ocrVehicle(params, null, callBack);
    }

    @Override
    public void ocrVehicle(Map<String, String> params, byte[] filePath, IFacePPCallBack<VehicleResponse> callBack) {
        HttpUtils.post(API_OCR_VEHICLE_LICENSE, params, filePath, new TransCallBack<>(callBack, VehicleResponse.class));
    }

    @Override
    public void ocrBankCard(Map<String, String> params, IFacePPCallBack<BankCardResponse> callBack) {
        ocrBankCard(params, null, callBack);
    }

    @Override
    public void ocrBankCard(Map<String, String> params, byte[] filePath, IFacePPCallBack<BankCardResponse> callBack) {
        HttpUtils.post(API_OCR_BANK_CARD, params, filePath, new TransCallBack<>(callBack, BankCardResponse.class));
    }
}
