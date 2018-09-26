package com.ys.java8.test.SuperManager;

public enum ActiveType {

    /**
     * 非活跃
     */
    NOT,

    /**
     * 准活跃：5天内有使用
     */
    QUASI_ACTIVE,

    /**
     * 活跃：5天内有3天使用
     */
    ACTIVE,

    /**
     * 非常活跃（粉丝）：7天内，有4天使用次数大于等于200次
     */
    VERY_ACTIVE;

    public static String getReal(int index) {
        return index == 0 ? "非活跃" : index == 1 ? "准活跃" : index == 2 ? "活跃" : "粉丝";
    }
}