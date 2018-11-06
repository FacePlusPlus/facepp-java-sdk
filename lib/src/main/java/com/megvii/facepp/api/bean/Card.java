package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class Card {
    private int type;

    private String address;

    private String birthday;

    private String gender;

    private String id_card_number;

    private String name;

    private String race;

    private String side;

    private String front;

    private String back;

    private String issued_by;

    private String valid_date;

    private String legality;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
    }

    public String getValid_date() {
        return valid_date;
    }

    public void setValid_date(String valid_date) {
        this.valid_date = valid_date;
    }

    public String getLegality() {
        return legality;
    }

    public void setLegality(String legality) {
        this.legality = legality;
    }

    @Override
    public String toString() {
        return "{" +
                "\"type\":" + type +
                ", \"address\":\'" + address + "\'" +
                ", \"birthday\":\'" + birthday + "\'" +
                ", \"gender\":\'" + gender + "\'" +
                ", \"id_card_number\":\'" + id_card_number + "\'" +
                ", \"name\":\'" + name + "\'" +
                ", \"race\":\'" + race + "\'" +
                ", \"side\":\'" + side + "\'" +
                ", \"front\":\'" + front + "\'" +
                ", \"back\":\'" + back + "\'" +
                ", \"issued_by\":\'" + issued_by + "\'" +
                ", \"valid_date\":\'" + valid_date + "\'" +
                ", \"legality\":\'" + legality + "\'" +
                '}';
    }
}
