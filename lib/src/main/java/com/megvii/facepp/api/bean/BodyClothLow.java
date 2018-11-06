package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class BodyClothLow {
    private String lower_body_cloth_color;
    private ColorRGB lower_body_cloth_color_rgb;

    public String getLower_body_cloth_color() {
        return lower_body_cloth_color;
    }

    public void setLower_body_cloth_color(String lower_body_cloth_color) {
        this.lower_body_cloth_color = lower_body_cloth_color;
    }

    public ColorRGB getLower_body_cloth_color_rgb() {
        return lower_body_cloth_color_rgb;
    }

    public void setLower_body_cloth_color_rgb(ColorRGB lower_body_cloth_color_rgb) {
        this.lower_body_cloth_color_rgb = lower_body_cloth_color_rgb;
    }

    @Override
    public String toString() {
        return "{" +
                "\"lower_body_cloth_color\":\'" + lower_body_cloth_color + "\'" +
                ", \"lower_body_cloth_color_rgb\":" + lower_body_cloth_color_rgb +
                '}';
    }
}
