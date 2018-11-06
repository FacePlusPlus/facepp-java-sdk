package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class EyeStatus {

    private EyeStatusAttribute left_eye_status;

    private EyeStatusAttribute right_eye_status;

    public EyeStatusAttribute getLeft_eye_status() {
        return left_eye_status;
    }

    public void setLeft_eye_status(EyeStatusAttribute left_eye_status) {
        this.left_eye_status = left_eye_status;
    }

    public EyeStatusAttribute getRight_eye_status() {
        return right_eye_status;
    }

    public void setRight_eye_status(EyeStatusAttribute right_eye_status) {
        this.right_eye_status = right_eye_status;
    }

    @Override
    public String toString() {
        return "{" +
                "\"left_eye_status\":" + left_eye_status +
                ", \"right_eye_status\":" + right_eye_status +
                '}';
    }
}
