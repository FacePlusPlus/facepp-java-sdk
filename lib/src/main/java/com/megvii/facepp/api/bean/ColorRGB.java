package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class ColorRGB {
    private int r;
    private int g;
    private int b;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "{" +
                "\"r\":" + r +
                ", \"g\":" + g +
                ", \"b\":" + b +
                '}';
    }
}
