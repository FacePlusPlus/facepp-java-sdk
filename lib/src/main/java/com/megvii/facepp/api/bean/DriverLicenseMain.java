package com.megvii.facepp.api.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author by licheng on 2018/7/3.
 */

public class DriverLicenseMain {

    private float confidence;

    private ContentConfidence name;
    private ContentConfidence address;
    private ContentConfidence birthday;
    private ContentConfidence gender;
    private ContentConfidence license_number;

    @JSONField(name = "class")
    private ContentConfidence clazz;
    private ContentConfidence nationality;

    private ContentConfidence issued_by;
    private ContentConfidence issue_date;
    private ContentConfidence valid_from;
    private ContentConfidence valid_for;
    private ContentConfidence valid_date;

    private ContentConfidence version;

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

    public ContentConfidence getAddress() {
        return address;
    }

    public void setAddress(ContentConfidence address) {
        this.address = address;
    }

    public ContentConfidence getBirthday() {
        return birthday;
    }

    public void setBirthday(ContentConfidence birthday) {
        this.birthday = birthday;
    }

    public ContentConfidence getGender() {
        return gender;
    }

    public void setGender(ContentConfidence gender) {
        this.gender = gender;
    }

    public ContentConfidence getLicense_number() {
        return license_number;
    }

    public void setLicense_number(ContentConfidence license_number) {
        this.license_number = license_number;
    }

    public ContentConfidence getClazz() {
        return clazz;
    }

    public void setClazz(ContentConfidence clazz) {
        this.clazz = clazz;
    }

    public ContentConfidence getNationality() {
        return nationality;
    }

    public void setNationality(ContentConfidence nationality) {
        this.nationality = nationality;
    }

    public ContentConfidence getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(ContentConfidence issued_by) {
        this.issued_by = issued_by;
    }

    public ContentConfidence getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(ContentConfidence issue_date) {
        this.issue_date = issue_date;
    }

    public ContentConfidence getValid_from() {
        return valid_from;
    }

    public void setValid_from(ContentConfidence valid_from) {
        this.valid_from = valid_from;
    }

    public ContentConfidence getValid_for() {
        return valid_for;
    }

    public void setValid_for(ContentConfidence valid_for) {
        this.valid_for = valid_for;
    }

    public ContentConfidence getValid_date() {
        return valid_date;
    }

    public void setValid_date(ContentConfidence valid_date) {
        this.valid_date = valid_date;
    }

    public ContentConfidence getVersion() {
        return version;
    }

    public void setVersion(ContentConfidence version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "{" +
                "\"confidence\":" + confidence +
                ", \"name\":" + name +
                ", \"address\":" + address +
                ", \"birthday\":" + birthday +
                ", \"gender\":" + gender +
                ", \"license_number\":" + license_number +
                ", \"clazz\":" + clazz +
                ", \"nationality\":" + nationality +
                ", \"issued_by\":" + issued_by +
                ", \"issue_date\":" + issue_date +
                ", \"valid_from\":" + valid_from +
                ", \"valid_for\":" + valid_for +
                ", \"valid_date\":" + valid_date +
                ", \"version\":" + version +
                '}';
    }
}
