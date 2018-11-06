package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/9/26.
 */

public class BodyRectangle {

    private int top; // 矩形框左上角像素点的纵坐标
    private int left; // 矩形框左上角像素点的横坐标
    private int width; // 矩形框的宽度
    private int height; // 矩形框的高度

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BodyRectangle that = (BodyRectangle) o;

        if (top != that.top) return false;
        if (left != that.left) return false;
        if (width != that.width) return false;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        int result = top;
        result = 31 * result + left;
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "\"top\":" + top +
                ", \"left\":" + left +
                ", \"width\":" + width +
                ", \"height\":" + height +
                '}';
    }
}
