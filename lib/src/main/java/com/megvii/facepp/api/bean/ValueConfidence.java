package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class ValueConfidence {

    private String value;

    private float confidence;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        return "{" +
                "\"value\":\'" + value + "\'" +
                ", \"confidence\":" + confidence +
                '}';
    }
}
