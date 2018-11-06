package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class Emotion {

    private float sadness;

    private float neutral;

    private float disgust;

    private float anger;

    private float surprise;

    private float fear;

    private float happiness;

    public float getSadness() {
        return sadness;
    }

    public void setSadness(float sadness) {
        this.sadness = sadness;
    }

    public float getNeutral() {
        return neutral;
    }

    public void setNeutral(float neutral) {
        this.neutral = neutral;
    }

    public float getDisgust() {
        return disgust;
    }

    public void setDisgust(float disgust) {
        this.disgust = disgust;
    }

    public float getAnger() {
        return anger;
    }

    public void setAnger(float anger) {
        this.anger = anger;
    }

    public float getSurprise() {
        return surprise;
    }

    public void setSurprise(float surprise) {
        this.surprise = surprise;
    }

    public float getFear() {
        return fear;
    }

    public void setFear(float fear) {
        this.fear = fear;
    }

    public float getHappiness() {
        return happiness;
    }

    public void setHappiness(float happiness) {
        this.happiness = happiness;
    }

    @Override
    public String toString() {
        return "{" +
                "\"sadness\":" + sadness +
                ", \"neutral\":" + neutral +
                ", \"disgust\":" + disgust +
                ", \"anger\":" + anger +
                ", \"surprise\":" + surprise +
                ", \"fear\":" + fear +
                ", \"happiness\":" + happiness +
                '}';
    }
}
