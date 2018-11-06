package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class EyeStatusAttribute {

    private float normal_glass_eye_open;

    private float no_glass_eye_close;

    private float occlusion;

    private float no_glass_eye_open;

    private float normal_glass_eye_close;

    private float dark_glasses;

    public float getNormal_glass_eye_open() {
        return normal_glass_eye_open;
    }

    public void setNormal_glass_eye_open(float normal_glass_eye_open) {
        this.normal_glass_eye_open = normal_glass_eye_open;
    }

    public float getNo_glass_eye_close() {
        return no_glass_eye_close;
    }

    public void setNo_glass_eye_close(float no_glass_eye_close) {
        this.no_glass_eye_close = no_glass_eye_close;
    }

    public float getOcclusion() {
        return occlusion;
    }

    public void setOcclusion(float occlusion) {
        this.occlusion = occlusion;
    }

    public float getNo_glass_eye_open() {
        return no_glass_eye_open;
    }

    public void setNo_glass_eye_open(float no_glass_eye_open) {
        this.no_glass_eye_open = no_glass_eye_open;
    }

    public float getNormal_glass_eye_close() {
        return normal_glass_eye_close;
    }

    public void setNormal_glass_eye_close(float normal_glass_eye_close) {
        this.normal_glass_eye_close = normal_glass_eye_close;
    }

    public float getDark_glasses() {
        return dark_glasses;
    }

    public void setDark_glasses(float dark_glasses) {
        this.dark_glasses = dark_glasses;
    }

    @Override
    public String toString() {
        return "{" +
                "\"normal_glass_eye_open\":" + normal_glass_eye_open +
                ", \"no_glass_eye_close\":" + no_glass_eye_close +
                ", \"occlusion\":" + occlusion +
                ", \"no_glass_eye_open\":" + no_glass_eye_open +
                ", \"normal_glass_eye_close\":" + normal_glass_eye_close +
                ", \"dark_glasses\":" + dark_glasses +
                '}';
    }
}
