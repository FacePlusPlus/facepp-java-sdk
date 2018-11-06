package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class ContentConfidence {

    private String content;
    private float confidence;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
                "\"content\":\'" + content + "\'" +
                ", \"confidence\":" + confidence +
                '}';
    }
}
