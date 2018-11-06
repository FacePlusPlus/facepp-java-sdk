package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/7/3.
 */

public class LicensePlat {

    private Bound bound;

    private int colore;

    private String license_plate_number;

    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }

    public int getColore() {
        return colore;
    }

    public void setColore(int colore) {
        this.colore = colore;
    }

    public String getLicense_plate_number() {
        return license_plate_number;
    }

    public void setLicense_plate_number(String license_plate_number) {
        this.license_plate_number = license_plate_number;
    }

    @Override
    public String toString() {
        return "{" +
                "\"bound\":" + bound +
                ", \"colore\":" + colore +
                ", \"license_plate_number\":\'" + license_plate_number + "\'" +
                '}';
    }
}
