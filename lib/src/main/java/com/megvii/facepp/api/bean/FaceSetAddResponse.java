package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class FaceSetAddResponse extends FaceSetCreatResponse {

    private String task_id;

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FaceSetAddResponse that = (FaceSetAddResponse) o;

        return task_id != null ? task_id.equals(that.task_id) : that.task_id == null;
    }

    @Override
    public int hashCode() {
        return task_id != null ? task_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "{" +
                "\"task_id\":\'" + task_id + "\'" +
                '}';
    }
}
