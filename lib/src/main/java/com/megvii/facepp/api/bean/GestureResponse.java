package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */

public class GestureResponse extends BaseResponse {
    private List<Hands> hands;

    public List<Hands> getHands() {
        return hands;
    }

    public void setHands(List<Hands> hands) {
        this.hands = hands;
    }

    @Override
    public String toString() {
        return "{" +
                "\"hands\":" + hands +
                '}';
    }
}
