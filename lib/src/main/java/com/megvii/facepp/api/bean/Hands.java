package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class Hands {

    private Gesture gesture;

    private CommonRect hand_rectangle;

    public Gesture getGesture() {
        return gesture;
    }

    public void setGesture(Gesture gesture) {
        this.gesture = gesture;
    }

    public CommonRect getHand_rectangle() {
        return hand_rectangle;
    }

    public void setHand_rectangle(CommonRect hand_rectangle) {
        this.hand_rectangle = hand_rectangle;
    }

    @Override
    public String toString() {
        return "{" +
                "\"gesture\":" + gesture +
                ", \"hand_rectangle\":" + hand_rectangle +
                '}';
    }
}
