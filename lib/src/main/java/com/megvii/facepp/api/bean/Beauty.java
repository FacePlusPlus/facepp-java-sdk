package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class Beauty {

    private float female_score;

    private float male_score;

    public float getFemale_score() {
        return female_score;
    }

    public void setFemale_score(float female_score) {
        this.female_score = female_score;
    }

    public float getMale_score() {
        return male_score;
    }

    public void setMale_score(float male_score) {
        this.male_score = male_score;
    }

    @Override
    public String toString() {
        return "{" +
                "\"female_score\":" + female_score +
                ", \"male_score\":" + male_score +
                '}';
    }
}
