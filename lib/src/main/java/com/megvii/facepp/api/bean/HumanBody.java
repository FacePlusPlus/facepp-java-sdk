package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class HumanBody {

    private float confidence;

    private CommonRect humanbody_rectangle;

    private BodyAttribute attributes;

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public CommonRect getHumanbody_rectangle() {
        return humanbody_rectangle;
    }

    public void setHumanbody_rectangle(CommonRect humanbody_rectangle) {
        this.humanbody_rectangle = humanbody_rectangle;
    }

    public BodyAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(BodyAttribute attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "{" +
                "\"confidence\":" + confidence +
                ", \"humanbody_rectangle\":" + humanbody_rectangle +
                ", \"attributes\":" + attributes +
                '}';
    }
}
