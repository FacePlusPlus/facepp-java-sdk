package com.megvii.facepp.api.bean;

import java.util.List;
import java.util.Map;

/**
 * @author by licheng on 2018/7/3.
 */

public class CompareResponse extends BaseResponse {

    private float confidence;

    private Map<String, Float> thresholds;

    private String image_id1;

    private String image_id2;

    private List<Face> faces1;

    private List<Face> faces2;

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public Map<String, Float> getThresholds() {
        return thresholds;
    }

    public void setThresholds(Map<String, Float> thresholds) {
        this.thresholds = thresholds;
    }

    public String getImage_id1() {
        return image_id1;
    }

    public void setImage_id1(String image_id1) {
        this.image_id1 = image_id1;
    }

    public String getImage_id2() {
        return image_id2;
    }

    public void setImage_id2(String image_id2) {
        this.image_id2 = image_id2;
    }

    public List<Face> getFaces1() {
        return faces1;
    }

    public void setFaces1(List<Face> faces1) {
        this.faces1 = faces1;
    }

    public List<Face> getFaces2() {
        return faces2;
    }

    public void setFaces2(List<Face> faces2) {
        this.faces2 = faces2;
    }

    @Override
    public String toString() {
        return "{" +
                "\"confidence\":" + confidence +
                ", \"thresholds\":" + thresholds +
                ", \"image_id1\":\'" + image_id1 + "\'" +
                ", \"image_id2\":\'" + image_id2 + "\'" +
                ", \"faces1\":" + faces1 +
                ", \"faces2\":" + faces2 +
                '}';
    }
}
