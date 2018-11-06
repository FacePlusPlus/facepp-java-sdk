package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/9/26.
 */

public class Skeleton {

    private BodyRectangle body_rectangle;

    private Landmark landmark;

    public BodyRectangle getBody_rectangle() {
        return body_rectangle;
    }

    public void setBody_rectangle(BodyRectangle body_rectangle) {
        this.body_rectangle = body_rectangle;
    }

    public Landmark getLandmark() {
        return landmark;
    }

    public void setLandmark(Landmark landmark) {
        this.landmark = landmark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skeleton skeleton = (Skeleton) o;

        if (body_rectangle != null ? !body_rectangle.equals(skeleton.body_rectangle) : skeleton.body_rectangle != null)
            return false;
        return landmark != null ? landmark.equals(skeleton.landmark) : skeleton.landmark == null;
    }

    @Override
    public int hashCode() {
        int result = body_rectangle != null ? body_rectangle.hashCode() : 0;
        result = 31 * result + (landmark != null ? landmark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "\"body_rectangle\":" + body_rectangle +
                ", \"landmark\":" + landmark +
                '}';
    }
}
