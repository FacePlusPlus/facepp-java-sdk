package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class HumanSegmentResponse extends BaseResponse {

    private String result; // 灰度图

    private String body_image; // 抠出的人像图片

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBody_image() {
        return body_image;
    }

    public void setBody_image(String body_image) {
        this.body_image = body_image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HumanSegmentResponse that = (HumanSegmentResponse) o;

        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        return body_image != null ? body_image.equals(that.body_image) : that.body_image == null;
    }

    @Override
    public int hashCode() {
        int result1 = result != null ? result.hashCode() : 0;
        result1 = 31 * result1 + (body_image != null ? body_image.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "{" +
                "\"result\":\'" + result + "\'" +
                ", \"body_image\":\'" + body_image + "\'" +
                '}';
    }
}
