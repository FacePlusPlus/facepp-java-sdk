package com.megvii.facepp.api.bean;

import java.util.Arrays;

/**
 * @author by licheng on 2018/7/3.
 */

public class FaceSetCreatResponse extends BaseResponse {
    private String faceset_token;

    private String outer_id;

    private int face_added;

    private int face_count;

    private FailureDetail[] failure_detail;

    public String getFaceset_token() {
        return faceset_token;
    }

    public void setFaceset_token(String faceset_token) {
        this.faceset_token = faceset_token;
    }

    public String getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(String outer_id) {
        this.outer_id = outer_id;
    }

    public int getFace_added() {
        return face_added;
    }

    public void setFace_added(int face_added) {
        this.face_added = face_added;
    }

    public int getFace_count() {
        return face_count;
    }

    public void setFace_count(int face_count) {
        this.face_count = face_count;
    }

    public FailureDetail[] getFailure_detail() {
        return failure_detail;
    }

    public void setFailure_detail(FailureDetail[] failure_detail) {
        this.failure_detail = failure_detail;
    }

    @Override
    public String toString() {
        return "{" +
                "\"faceset_token\":\'" + faceset_token + "\'" +
                ", \"outer_id\":\'" + outer_id + "\'" +
                ", \"face_added\":" + face_added +
                ", \"face_count\":" + face_count +
                ", \"failure_detail\":" + Arrays.toString(failure_detail) +
                '}';
    }

    private static class FailureDetail {
        private String face_token;
        private String reason;

        public String getFace_token() {
            return face_token;
        }

        public void setFace_token(String face_token) {
            this.face_token = face_token;
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
                    "\"face_token\":\'" + face_token + "\'" +
                    ", \"reason\":\'" + reason + "\'" +
                    '}';
        }
    }
}
