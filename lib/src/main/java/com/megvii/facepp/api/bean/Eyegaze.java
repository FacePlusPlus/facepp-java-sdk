package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class Eyegaze {

    private EyegazeItem right_eye_gaze;

    private EyegazeItem left_eye_gaze;

    public EyegazeItem getRight_eye_gaze() {
        return right_eye_gaze;
    }

    public void setRight_eye_gaze(EyegazeItem right_eye_gaze) {
        this.right_eye_gaze = right_eye_gaze;
    }

    public EyegazeItem getLeft_eye_gaze() {
        return left_eye_gaze;
    }

    public void setLeft_eye_gaze(EyegazeItem left_eye_gaze) {
        this.left_eye_gaze = left_eye_gaze;
    }

    @Override
    public String toString() {
        return "{" +
                "\"right_eye_gaze\":" + right_eye_gaze +
                ", \"left_eye_gaze\":" + left_eye_gaze +
                '}';
    }
}
