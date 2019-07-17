package com.ys.java8.test.demo;

import org.junit.Test;

import java.util.Date;

/**
 * @author HuaDong
 * @date 2019/7/14 16:03
 */
public class Sub extends Super {
    private final Date date;

    public Sub() {
        date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }

    @Test
    public void test() {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
