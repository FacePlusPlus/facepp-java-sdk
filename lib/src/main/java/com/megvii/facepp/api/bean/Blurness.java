package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class Blurness {

    private Threshold blurness;

    private Threshold motionblur;

    private Threshold gaussianblur;

    public Threshold getBlurness() {
        return blurness;
    }

    public void setBlurness(Threshold blurness) {
        this.blurness = blurness;
    }

    public Threshold getMotionblur() {
        return motionblur;
    }

    public void setMotionblur(Threshold motionblur) {
        this.motionblur = motionblur;
    }

    public Threshold getGaussianblur() {
        return gaussianblur;
    }

    public void setGaussianblur(Threshold gaussianblur) {
        this.gaussianblur = gaussianblur;
    }

    @Override
    public String toString() {
        return "{" +
                "\"blurness\":" + blurness +
                ", \"motionblur\":" + motionblur +
                ", \"gaussianblur\":" + gaussianblur +
                '}';
    }
}
