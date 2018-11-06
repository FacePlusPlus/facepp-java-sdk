package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class DriverLicenseSecond {

    private float confidence;

    private ContentConfidence name;

    private ContentConfidence license_number;

    private ContentConfidence file_number;

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public ContentConfidence getName() {
        return name;
    }

    public void setName(ContentConfidence name) {
        this.name = name;
    }

    public ContentConfidence getLicense_number() {
        return license_number;
    }

    public void setLicense_number(ContentConfidence license_number) {
        this.license_number = license_number;
    }

    public ContentConfidence getFile_number() {
        return file_number;
    }

    public void setFile_number(ContentConfidence file_number) {
        this.file_number = file_number;
    }

    @Override
    public String toString() {
        return "{" +
                "\"confidence\":" + confidence +
                ", \"name\":" + name +
                ", \"license_number\":" + license_number +
                ", \"file_number\":" + file_number +
                '}';
    }
}
