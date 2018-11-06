package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class FaceSet {

    private String faceset_token;

    private String outer_id;

    private String display_name;

    private String tags;

    private String user_data;

    public String getFaceset_token() {
        return faceset_token;
    }

    public void setFaceset_token(String faceset_token) {
        this.faceset_token = faceset_token;
    }

    public String getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(String outer_id) {
        this.outer_id = outer_id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUser_data() {
        return user_data;
    }

    public void setUser_data(String user_data) {
        this.user_data = user_data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"faceset_token\":\'" + faceset_token + "\'" +
                ", \"outer_id\":\'" + outer_id + "\'" +
                ", \"display_name\":\'" + display_name + "\'" +
                ", \"tags\":\'" + tags + "\'" +
                ", \"user_data\":\'" + user_data + "\'" +
                '}';
    }
}
