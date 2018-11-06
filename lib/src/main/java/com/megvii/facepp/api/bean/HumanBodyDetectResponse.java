package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */

public class HumanBodyDetectResponse extends BaseResponse {

    private List<HumanBody> humanbodies;

    public List<HumanBody> getHumanbodies() {
        return humanbodies;
    }

    public void setHumanbodies(List<HumanBody> humanbodies) {
        this.humanbodies = humanbodies;
    }

    @Override
    public String toString() {
        return "{" +
                "\"humanbodies\":" + humanbodies +
                '}';
    }
}
