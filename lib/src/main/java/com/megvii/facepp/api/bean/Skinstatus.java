package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class Skinstatus {

    private float dark_circle;

    private float stain;

    private float acne;

    private float health;

    public float getDark_circle() {
        return dark_circle;
    }

    public void setDark_circle(float dark_circle) {
        this.dark_circle = dark_circle;
    }

    public float getStain() {
        return stain;
    }

    public void setStain(float stain) {
        this.stain = stain;
    }

    public float getAcne() {
        return acne;
    }

    public void setAcne(float acne) {
        this.acne = acne;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "{" +
                "\"dark_circle\":" + dark_circle +
                ", \"stain\":" + stain +
                ", \"acne\":" + acne +
                ", \"health\":" + health +
                '}';
    }
}
