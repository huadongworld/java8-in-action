package com.ys.java8.test;

import java.time.LocalDate;

/**
 * @author HD
 * @date 2018/4/20 17:02
 */
public enum Quarter {

    /**
     * 第一季度第一天
     */
    FIRST_QUARTER_START(LocalDate.of(LocalDate.now().getYear(), 1, 1)),

    FIRST_QUARTER_END(LocalDate.of(LocalDate.now().getYear(), 3, 31)),

    SECOND_QUARTER_START(LocalDate.of(LocalDate.now().getYear(), 4, 1)),

    SECOND_QUARTER_END(LocalDate.of(LocalDate.now().getYear(), 6, 30)),

    THIRD_QUARTER_START(LocalDate.of(LocalDate.now().getYear(), 7, 1)),

    THIRD_QUARTER_END(LocalDate.of(LocalDate.now().getYear(), 9, 30)),

    FOURTH_QUARTER_START(LocalDate.of(LocalDate.now().getYear(), 10, 1)),

    FOURTH_QUARTER_END(LocalDate.of(LocalDate.now().getYear(), 12, 31));

    private LocalDate desc;

    Quarter(LocalDate desc) {
        this.desc = desc;
    }

    public LocalDate getDesc() {
        return desc;
    }

    public static Quarter valueOf(int ordinal) {
        if (ordinal < 0 || ordinal >= values().length) {
            throw new IndexOutOfBoundsException("Invalid ordinal");
        }
        return values()[ordinal];
    }
}
