package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class Gender {

    private float male;

    private float female;

    public float getMale() {
        return male;
    }

    public void setMale(float male) {
        this.male = male;
    }

    public float getFemale() {
        return female;
    }

    public void setFemale(float female) {
        this.female = female;
    }

    @Override
    public String toString() {
        return "{" +
                "\"male\":" + male +
                ", \"female\":" + female +
                '}';
    }
}
