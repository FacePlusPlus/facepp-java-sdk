package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/9/26.
 */

public class SkeletonResponse extends BaseResponse {

    private List<Skeleton> skeletons;

    public List<Skeleton> getSkeletons() {
        return skeletons;
    }

    public void setSkeletons(List<Skeleton> skeletons) {
        this.skeletons = skeletons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkeletonResponse that = (SkeletonResponse) o;

        return skeletons != null ? skeletons.equals(that.skeletons) : that.skeletons == null;
    }

    @Override
    public int hashCode() {
        return skeletons != null ? skeletons.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "{" +
                "\"skeletons\":" + skeletons +
                '}';
    }
}
