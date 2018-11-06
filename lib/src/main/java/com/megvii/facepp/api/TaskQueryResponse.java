package com.megvii.facepp.api;

import com.megvii.facepp.api.bean.BaseResponse;
import com.megvii.facepp.api.bean.FailureDetail;

/**
 * @author by licheng on 2018/9/26.
 */

public class TaskQueryResponse extends BaseResponse {

    private String task_id;

    private int status;  //	1: 表示当前异步任务已经完成 -1: 表示当前异步任务失败 0：表示当前异步任务未完成

    private String faceset_token; // FaceSet 的标识

    private String outer_id; //	用户自定义的 FaceSet 标识，如果未定义则返回值为空

    private int face_added; // Int 成功加入 FaceSet 的 face_token 数量（如果当前任务类型为添加人脸，返回此字段）

    private int face_removed; // Int 成功从FaceSet中移除的face_token数量（如果当前任务类型为删除人脸，返回此字段）

    private int face_count; //	Int	操作结束后 FaceSet 中的 face_token 总数量

    private FailureDetail failure_detail;//	Array

    private String task_failure_detail; // 异步任务失败的原因。可能的值为：INVALID_FACESET_TOKEN INVALID_FACESET_OUTER_ID INTERNAL_ERROR

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

    public int getFace_removed() {
        return face_removed;
    }

    public void setFace_removed(int face_removed) {
        this.face_removed = face_removed;
    }

    public int getFace_count() {
        return face_count;
    }

    public void setFace_count(int face_count) {
        this.face_count = face_count;
    }

    public FailureDetail getFailure_detail() {
        return failure_detail;
    }

    public void setFailure_detail(FailureDetail failure_detail) {
        this.failure_detail = failure_detail;
    }

    public String getTask_failure_detail() {
        return task_failure_detail;
    }

    public void setTask_failure_detail(String task_failure_detail) {
        this.task_failure_detail = task_failure_detail;
    }

    @Override
    public String toString() {
        return "{" +
                "\"task_id\":\'" + task_id + "\'" +
                ", \"status\":" + status +
                ", \"faceset_token\":\'" + faceset_token + "\'" +
                ", \"outer_id\":\'" + outer_id + "\'" +
                ", \"face_added\":" + face_added +
                ", \"face_removed\":" + face_removed +
                ", \"face_count\":" + face_count +
                ", \"failure_detail\":" + failure_detail +
                ", \"task_failure_detail\":\'" + task_failure_detail + "\'" +
                '}';
    }
}
