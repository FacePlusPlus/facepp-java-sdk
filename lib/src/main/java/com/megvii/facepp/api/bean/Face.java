package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class Face {

    private String face_token;

    private CommonRect face_rectangle;

    private FaceLandmark landmark;

    private FaceAttributes attributes;

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    public CommonRect getFace_rectangle() {
        return face_rectangle;
    }

    public void setFace_rectangle(CommonRect face_rectangle) {
        this.face_rectangle = face_rectangle;
    }

    public FaceLandmark getLandmark() {
        return landmark;
    }

    public void setLandmark(FaceLandmark landmark) {
        this.landmark = landmark;
    }

    public FaceAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(FaceAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Face face = (Face) o;

        if (face_token != null ? !face_token.equals(face.face_token) : face.face_token != null)
            return false;
        if (face_rectangle != null ? !face_rectangle.equals(face.face_rectangle) : face.face_rectangle != null)
            return false;
        if (landmark != null ? !landmark.equals(face.landmark) : face.landmark != null)
            return false;
        return attributes != null ? attributes.equals(face.attributes) : face.attributes == null;
    }

    @Override
    public int hashCode() {
        int result = face_token != null ? face_token.hashCode() : 0;
        result = 31 * result + (face_rectangle != null ? face_rectangle.hashCode() : 0);
        result = 31 * result + (landmark != null ? landmark.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "\"face_token\":\'" + face_token + "\'" +
                ", \"face_rectangle\":" + face_rectangle +
                ", \"landmark\":" + landmark +
                ", \"attributes\":" + attributes +
                '}';
    }
}
