package com.megvii.facepp.api.bean;


/**
 * @author by licheng on 2018/7/3.
 */

public class Bound {

    private Point right_top; // 银行卡右上角的像素点坐标
    private Point left_top;  // 银行卡左上角的像素点坐标
    private Point right_bottom;  // 银行卡右下角的像素点坐标
    private Point left_bottom;  // 银行卡左下角的像素点坐标

    public Point getRight_top() {
        return right_top;
    }

    public void setRight_top(Point right_top) {
        this.right_top = right_top;
    }

    public Point getLeft_top() {
        return left_top;
    }

    public void setLeft_top(Point left_top) {
        this.left_top = left_top;
    }

    public Point getRight_bottom() {
        return right_bottom;
    }

    public void setRight_bottom(Point right_bottom) {
        this.right_bottom = right_bottom;
    }

    public Point getLeft_bottom() {
        return left_bottom;
    }

    public void setLeft_bottom(Point left_bottom) {
        this.left_bottom = left_bottom;
    }

    @Override
    public String toString() {
        return "{" +
                "\"right_top\":" + right_top +
                ", \"left_top\":" + left_top +
                ", \"right_bottom\":" + right_bottom +
                ", \"left_bottom\":" + left_bottom +
                '}';
    }
}
