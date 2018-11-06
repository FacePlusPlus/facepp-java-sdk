package com.megvii.facepp.api.bean;

import java.util.List;
import java.util.Map;

/**
 * @author by licheng on 2018/7/3.
 */

public class SearchResponse extends BaseResponse {

    private List<SearchFaceResult> results;

    private Map<String, Float> thresholds;

    private List<Face> faces;

    public List<SearchFaceResult> getResults() {
        return results;
    }

    public void setResults(List<SearchFaceResult> results) {
        this.results = results;
    }

    public Map<String, Float> getThresholds() {
        return thresholds;
    }

    public void setThresholds(Map<String, Float> thresholds) {
        this.thresholds = thresholds;
    }

    public List<Face> getFaces() {
        return faces;
    }

    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }

    @Override
    public String toString() {
        return "{" +
                "\"results\":" + results +
                ", \"thresholds\":" + thresholds +
                ", \"faces\":" + faces +
                '}';
    }
}
