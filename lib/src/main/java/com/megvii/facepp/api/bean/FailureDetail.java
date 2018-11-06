package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/9/28.
 */

public class FailureDetail {

    private String faceToken;

    private String reason;

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "{" +
                "\"faceToken\":\'" + faceToken + "\'" +
                ", \"reason\":\'" + reason + "\'" +
                '}';
    }
}
