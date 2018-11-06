package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class SearchFaceResult {

    private String face_token;

    private float confidence;

    private String user_id;

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "{" +
                "\"face_token\":\'" + face_token + "\'" +
                ", \"confidence\":" + confidence +
                ", \"user_id\":\'" + user_id + "\'" +
                '}';
    }
}
