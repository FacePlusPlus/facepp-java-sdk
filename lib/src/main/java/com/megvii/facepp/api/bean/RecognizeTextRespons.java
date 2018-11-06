package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */

public class RecognizeTextRespons extends BaseResponse {

    private List<TextResult> result;

    public List<TextResult> getResult() {
        return result;
    }

    public void setResult(List<TextResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "{" +
                "\"result\":" + result +
                '}';
    }
}
