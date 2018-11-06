package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */

public class OcrIdCardResponse extends BaseResponse {

    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "{" +
                "\"cards\":" + cards +
                '}';
    }
}
