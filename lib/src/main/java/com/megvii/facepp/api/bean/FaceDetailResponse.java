package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */

public class FaceDetailResponse extends BaseResponse {

    private String face_token;

    private String user_id;

    private CommonRect face_rectangle;

    private List<FaceSet> facesets;

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

    public CommonRect getFace_rectangle() {
        return face_rectangle;
    }

    public void setFace_rectangle(CommonRect face_rectangle) {
        this.face_rectangle = face_rectangle;
    }

    public List<FaceSet> getFacesets() {
        return facesets;
    }

    public void setFacesets(List<FaceSet> facesets) {
        this.facesets = facesets;
    }

    @Override
    public String toString() {
        return "{" +
                "\"face_token\":\'" + face_token + "\'" +
                ", \"user_id\":\'" + user_id + "\'" +
                ", \"face_rectangle\":" + face_rectangle +
                ", \"facesets\":" + facesets +
                '}';
    }
}
