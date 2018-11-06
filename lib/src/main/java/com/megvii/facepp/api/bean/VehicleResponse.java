package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */

public class VehicleResponse extends BaseResponse {

    private List<Vehicle> cards;

    public List<Vehicle> getCards() {
        return cards;
    }

    public void setCards(List<Vehicle> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "{" +
                "\"cards\":" + cards +
                '}';
    }
}
