package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */

public class SceneDetectResponse extends BaseResponse {

    private List<ValueConfidence> scenes;

    private List<ValueConfidence> objects;

    public List<ValueConfidence> getScenes() {
        return scenes;
    }

    public void setScenes(List<ValueConfidence> scenes) {
        this.scenes = scenes;
    }

    public List<ValueConfidence> getObjects() {
        return objects;
    }

    public void setObjects(List<ValueConfidence> objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "{" +
                "\"scenes\":" + scenes +
                ", \"objects\":" + objects +
                '}';
    }
}

