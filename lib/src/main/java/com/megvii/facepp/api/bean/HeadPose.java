package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class HeadPose {

    private float yaw_angle;

    private float pitch_angle;

    private float roll_angle;

    public float getYaw_angle() {
        return yaw_angle;
    }

    public void setYaw_angle(float yaw_angle) {
        this.yaw_angle = yaw_angle;
    }

    public float getPitch_angle() {
        return pitch_angle;
    }

    public void setPitch_angle(float pitch_angle) {
        this.pitch_angle = pitch_angle;
    }

    public float getRoll_angle() {
        return roll_angle;
    }

    public void setRoll_angle(float roll_angle) {
        this.roll_angle = roll_angle;
    }

    @Override
    public String toString() {
        return "{" +
                "\"yaw_angle\":" + yaw_angle +
                ", \"pitch_angle\":" + pitch_angle +
                ", \"roll_angle\":" + roll_angle +
                '}';
    }
}
