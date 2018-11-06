package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class MouthStatus {
    private float close;

    private float surgical_mask_or_respirator;

    private float open;

    private float other_occlusion;

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getSurgical_mask_or_respirator() {
        return surgical_mask_or_respirator;
    }

    public void setSurgical_mask_or_respirator(float surgical_mask_or_respirator) {
        this.surgical_mask_or_respirator = surgical_mask_or_respirator;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getOther_occlusion() {
        return other_occlusion;
    }

    public void setOther_occlusion(float other_occlusion) {
        this.other_occlusion = other_occlusion;
    }

    @Override
    public String toString() {
        return "{" +
                "\"close\":" + close +
                ", \"surgical_mask_or_respirator\":" + surgical_mask_or_respirator +
                ", \"open\":" + open +
                ", \"other_occlusion\":" + other_occlusion +
                '}';
    }
}
