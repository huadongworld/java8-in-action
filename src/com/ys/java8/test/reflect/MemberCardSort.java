package com.ys.java8.test.reflect;

/**
 * Singleton9: Frank Tang <br/>
 * Date: 15/12/15<br/>
 * Time: 下午9:49<br/>
 * Email: lovefree103@gmail.com<br/>
 */
public class MemberCardSort{

    private Long cardSortId;

    private String cardName;

    public MemberCardSort(Long cardSortId, String cardName) {
        this.cardSortId = cardSortId;
        this.cardName = cardName;
    }

    public MemberCardSort() {

    }

    public Long getCardSortId() {

        return cardSortId;
    }

    public void setCardSortId(Long cardSortId) {
        this.cardSortId = cardSortId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
