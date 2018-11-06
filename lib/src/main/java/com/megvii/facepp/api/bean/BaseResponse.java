package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class BaseResponse {

    private int time_used; // 用时

    private String image_id; // 传入的图片在系统中的标识。

    private String request_id; // 请求唯一标识

    private String error_message; // 错误信息

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    @Override
    public String toString() {
        return "{" +
                "\"time_used\":" + time_used +
                ", \"image_id\":\'" + image_id + "\'" +
                ", \"request_id\":\'" + request_id + "\'" +
                ", \"error_message\":\'" + error_message + "\'" +
                '}';
    }
}
