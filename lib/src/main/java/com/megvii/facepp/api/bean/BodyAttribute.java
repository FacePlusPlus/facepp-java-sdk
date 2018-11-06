package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class BodyAttribute {

    private Gender gender;

    private BodyClothUp upper_body_cloth;

    private BodyClothLow lower_body_cloth;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BodyClothUp getUpper_body_cloth() {
        return upper_body_cloth;
    }

    public void setUpper_body_cloth(BodyClothUp upper_body_cloth) {
        this.upper_body_cloth = upper_body_cloth;
    }

    public BodyClothLow getLower_body_cloth() {
        return lower_body_cloth;
    }

    public void setLower_body_cloth(BodyClothLow lower_body_cloth) {
        this.lower_body_cloth = lower_body_cloth;
    }

    @Override
    public String toString() {
        return "{" +
                "\"gender\":" + gender +
                ", \"upper_body_cloth\":" + upper_body_cloth +
                ", \"lower_body_cloth\":" + lower_body_cloth +
                '}';
    }
}
