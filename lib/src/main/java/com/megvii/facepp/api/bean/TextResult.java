package com.megvii.facepp.api.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */

public class TextResult {

    private String type;
    private String value;

    private List<Point> position;

    @JSONField(name = "child-objects")
    private List<TextResult> child_objects;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Point> getPosition() {
        return position;
    }

    public void setPosition(List<Point> position) {
        this.position = position;
    }

    public List<TextResult> getChild_objects() {
        return child_objects;
    }

    public void setChild_objects(List<TextResult> child_objects) {
        this.child_objects = child_objects;
    }

    @Override
    public String toString() {
        return "{" +
                "\"type\":\'" + type + "\'" +
                ", \"value\":\'" + value + "\'" +
                ", \"position\":" + position +
                ", \"child_objects\":" + child_objects +
                '}';
    }
}
