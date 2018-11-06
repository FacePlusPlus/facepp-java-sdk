package com.megvii.facepp.api;

import com.megvii.facepp.api.bean.BaseResponse;

/**
 * @author by licheng on 2018/6/29.
 */

public interface IFacePPCallBack<T extends BaseResponse> {

    void onSuccess(T response);

    void onFailed(String error);
}
