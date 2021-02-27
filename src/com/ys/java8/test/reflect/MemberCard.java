package com.ys.java8.test.reflect;

import java.math.BigDecimal;

/**
 * Singleton9: Frank Tang <br/>
 * Date: 15/12/15<br/>
 * Time: 下午9:34<br/>
 * Email: lovefree103@gmail.com<br/>
 */
public class MemberCard {

    private Long id;

    /**
     * 会员卡号 No.00000001
     */
    private String cardCode;

    /**
     * 开卡时来自哪一卡品种
     */
    private MemberCardSort memberCardSort;

    private String cardName;

    private Integer validMonth;

    private String contactPhone;

    private BigDecimal totalAmount = BigDecimal.ZERO;

    private BigDecimal amount = BigDecimal.ZERO;

    public MemberCard(Long id, String cardCode, MemberCardSort memberCardSort, String cardName, Integer validMonth, String contactPhone, BigDecimal totalAmount, BigDecimal amount) {
        this.id = id;
        this.cardCode = cardCode;
        this.memberCardSort = memberCardSort;
        this.cardName = cardName;
        this.validMonth = validMonth;
        this.contactPhone = contactPhone;
        this.totalAmount = totalAmount;
        this.amount = amount;
    }

    public BigDecimal getAmount() {

        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public MemberCard() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public MemberCardSort getMemberCardSort() {
        return memberCardSort;
    }

    public void setMemberCardSort(MemberCardSort memberCardSort) {
        this.memberCardSort = memberCardSort;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getValidMonth() {
        return validMonth;
    }

    public void setValidMonth(Integer validMonth) {
        this.validMonth = validMonth;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
