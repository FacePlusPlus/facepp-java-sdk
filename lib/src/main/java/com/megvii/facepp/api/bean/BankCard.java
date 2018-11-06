package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */

public class BankCard {

    private Bound bound;

    private String number;

    private String bank;

    private List<String> organization;

    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public List<String> getOrganization() {
        return organization;
    }

    public void setOrganization(List<String> organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "{" +
                "\"bound\":" + bound +
                ", \"number\":\'" + number + "\'" +
                ", \"bank\":\'" + bank + "\'" +
                ", \"organization\":" + organization +
                '}';
    }
}
