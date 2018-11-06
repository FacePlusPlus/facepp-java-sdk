package com.megvii.facepp.api;

import com.alibaba.fastjson.JSONObject;
import com.megvii.facepp.api.bean.BaseResponse;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author by licheng on 2018/7/3.
 */

public class TransCallBack<T extends BaseResponse> implements Callback {

    private Class<T> clazz;

    private IFacePPCallBack<T> facePPCallBack;

    public TransCallBack(IFacePPCallBack<T> facePPCallBack, Class<T> clazz) {
        this.facePPCallBack = facePPCallBack;
        this.clazz = clazz;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        if (null != facePPCallBack) {
            facePPCallBack.onFailed(e.getMessage());
        }
        System.out.println(e.getMessage());
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (null == facePPCallBack) {
            return;
        }
        ResponseBody responseBody = response.body();
        try {
            T result = JSONObject.parseObject(responseBody.string(), clazz);
            String error = result.getError_message();
            if (null != error && !"".equals(error)) {
                facePPCallBack.onFailed(error);
            } else {
                facePPCallBack.onSuccess(result);
            }
        } catch (Exception e) {
            if (null != facePPCallBack) {
                facePPCallBack.onFailed(e.getMessage());
            }
        }
    }
}
