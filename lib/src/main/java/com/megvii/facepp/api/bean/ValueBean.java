package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class ValueBean {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "\"value\":\'" + value + "\'" +
                '}';
    }
}
