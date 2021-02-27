package com.ys.java8.test.utils;

/**
 * @Author: Fu
 * @Date: 2019-10-15 17:59
 */
public enum SignType {

    /**
     * 普通-(年费或终生)
     */
    NORMAL("普通"),

    /**
     * 按单付费
     */
    CHARGE_BY_BILL("按单结算");

    private String desc;

    SignType(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
