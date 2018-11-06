package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */

public class LicensePlatResponse extends BaseResponse {

    private List<LicensePlat> results;

    public List<LicensePlat> getResults() {
        return results;
    }

    public void setResults(List<LicensePlat> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "{" +
                "\"results\":" + results +
                '}';
    }
}
