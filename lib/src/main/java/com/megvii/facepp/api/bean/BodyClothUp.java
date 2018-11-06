package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class BodyClothUp {

    private String upper_body_cloth_color;
    private ColorRGB upper_body_cloth_color_rgb;

    public String getUpper_body_cloth_color() {
        return upper_body_cloth_color;
    }

    public void setUpper_body_cloth_color(String upper_body_cloth_color) {
        this.upper_body_cloth_color = upper_body_cloth_color;
    }

    public ColorRGB getUpper_body_cloth_color_rgb() {
        return upper_body_cloth_color_rgb;
    }

    public void setUpper_body_cloth_color_rgb(ColorRGB upper_body_cloth_color_rgb) {
        this.upper_body_cloth_color_rgb = upper_body_cloth_color_rgb;
    }

    @Override
    public String toString() {
        return "{" +
                "\"upper_body_cloth_color\":\'" + upper_body_cloth_color + "\'" +
                ", \"upper_body_cloth_color_rgb\":" + upper_body_cloth_color_rgb +
                '}';
    }
}
