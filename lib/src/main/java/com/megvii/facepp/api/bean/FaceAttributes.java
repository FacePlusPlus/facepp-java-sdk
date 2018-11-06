package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/6/29.
 */

public class FaceAttributes {

    private ValueBean gender;
    private ValueBean age;
    private Smile smile;
    private HeadPose headpose;
    private Threshold facequality;

    private Blurness blur;
    private EyeStatus eyestatus;
    private Emotion emotion;
    private ValueBean glass;
    private ValueBean ethnicity;
    private Beauty beauty;
    private MouthStatus mouthstatus;
    private Eyegaze eyegaze;
    private Skinstatus skinstatus;

    public ValueBean getGender() {
        return gender;
    }

    public void setGender(ValueBean gender) {
        this.gender = gender;
    }

    public ValueBean getAge() {
        return age;
    }

    public void setAge(ValueBean age) {
        this.age = age;
    }

    public Smile getSmile() {
        return smile;
    }

    public void setSmile(Smile smile) {
        this.smile = smile;
    }

    public HeadPose getHeadpose() {
        return headpose;
    }

    public void setHeadpose(HeadPose headpose) {
        this.headpose = headpose;
    }

    public Threshold getFacequality() {
        return facequality;
    }

    public void setFacequality(Threshold facequality) {
        this.facequality = facequality;
    }

    public Blurness getBlur() {
        return blur;
    }

    public void setBlur(Blurness blur) {
        this.blur = blur;
    }

    public EyeStatus getEyestatus() {
        return eyestatus;
    }

    public void setEyestatus(EyeStatus eyestatus) {
        this.eyestatus = eyestatus;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public ValueBean getGlass() {
        return glass;
    }

    public void setGlass(ValueBean glass) {
        this.glass = glass;
    }

    public ValueBean getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(ValueBean ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Beauty getBeauty() {
        return beauty;
    }

    public void setBeauty(Beauty beauty) {
        this.beauty = beauty;
    }

    public MouthStatus getMouthstatus() {
        return mouthstatus;
    }

    public void setMouthstatus(MouthStatus mouthstatus) {
        this.mouthstatus = mouthstatus;
    }

    public Eyegaze getEyegaze() {
        return eyegaze;
    }

    public void setEyegaze(Eyegaze eyegaze) {
        this.eyegaze = eyegaze;
    }

    public Skinstatus getSkinstatus() {
        return skinstatus;
    }

    public void setSkinstatus(Skinstatus skinstatus) {
        this.skinstatus = skinstatus;
    }

    @Override
    public String toString() {
        return "{" +
                "\"gender\":" + gender +
                ", \"age\":" + age +
                ", \"smile\":" + smile +
                ", \"headpose\":" + headpose +
                ", \"facequality\":" + facequality +
                ", \"blur\":" + blur +
                ", \"eyestatus\":" + eyestatus +
                ", \"emotion\":" + emotion +
                ", \"glass\":" + glass +
                ", \"ethnicity\":" + ethnicity +
                ", \"beauty\":" + beauty +
                ", \"mouthstatus\":" + mouthstatus +
                ", \"eyegaze\":" + eyegaze +
                ", \"skinstatus\":" + skinstatus +
                '}';
    }
}
