package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class FaceToken extends BaseResponse {

    private String face_token;

    private String user_id;

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
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
                ", \"user_id\":\'" + user_id + "\'" +
                '}';
    }
}
