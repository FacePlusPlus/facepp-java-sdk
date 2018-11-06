package com.megvii.facepp.api.bean;

import java.util.List;

/**
 * @author by licheng on 2018/7/3.
 */
public class BankCardResponse extends BaseResponse {

    private List<BankCard> bank_cards;

    public List<BankCard> getBank_cards() {
        return bank_cards;
    }

    public void setBank_cards(List<BankCard> bank_cards) {
        this.bank_cards = bank_cards;
    }

    @Override
    public String toString() {
        return "{" +
                "\"bank_cards\":" + bank_cards +
                '}';
    }
}
