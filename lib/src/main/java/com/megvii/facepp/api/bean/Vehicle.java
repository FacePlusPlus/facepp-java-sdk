package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class Vehicle {

    private int type;

    private String plate_no;

    private String vehicle_type;

    private String owner;

    private String address;

    private String use_character;

    private String model;

    private String vin;

    private String engine_no;

    private String register_date;

    private String issue_date;

    private String side;

    private String issued_by;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPlate_no() {
        return plate_no;
    }

    public void setPlate_no(String plate_no) {
        this.plate_no = plate_no;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUse_character() {
        return use_character;
    }

    public void setUse_character(String use_character) {
        this.use_character = use_character;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getEngine_no() {
        return engine_no;
    }

    public void setEngine_no(String engine_no) {
        this.engine_no = engine_no;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
    }

    @Override
    public String toString() {
        return "{" +
                "\"type\":" + type +
                ", \"plate_no\":\'" + plate_no + "\'" +
                ", \"vehicle_type\":\'" + vehicle_type + "\'" +
                ", \"owner\":\'" + owner + "\'" +
                ", \"address\":\'" + address + "\'" +
                ", \"use_character\":\'" + use_character + "\'" +
                ", \"model\":\'" + model + "\'" +
                ", \"vin\":\'" + vin + "\'" +
                ", \"engine_no\":\'" + engine_no + "\'" +
                ", \"register_date\":\'" + register_date + "\'" +
                ", \"issue_date\":\'" + issue_date + "\'" +
                ", \"side\":\'" + side + "\'" +
                ", \"issued_by\":\'" + issued_by + "\'" +
                '}';
    }
}
