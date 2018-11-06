package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class EyegazeItem {

    private float vector_z_component;

    private float vector_x_component;

    private float vector_y_component;

    private float position_y_coordinate;

    public float getVector_z_component() {
        return vector_z_component;
    }

    public void setVector_z_component(float vector_z_component) {
        this.vector_z_component = vector_z_component;
    }

    public float getVector_x_component() {
        return vector_x_component;
    }

    public void setVector_x_component(float vector_x_component) {
        this.vector_x_component = vector_x_component;
    }

    public float getVector_y_component() {
        return vector_y_component;
    }

    public void setVector_y_component(float vector_y_component) {
        this.vector_y_component = vector_y_component;
    }

    public float getPosition_y_coordinate() {
        return position_y_coordinate;
    }

    public void setPosition_y_coordinate(float position_y_coordinate) {
        this.position_y_coordinate = position_y_coordinate;
    }

    @Override
    public String toString() {
        return "{" +
                "\"vector_z_component\":" + vector_z_component +
                ", \"vector_x_component\":" + vector_x_component +
                ", \"vector_y_component\":" + vector_y_component +
                ", \"position_y_coordinate\":" + position_y_coordinate +
                '}';
    }
}
