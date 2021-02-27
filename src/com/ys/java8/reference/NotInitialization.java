package com.ys.java8.reference;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2020/3/3 23:03
 */
public class NotInitialization {
    @Test
    public void demo() {
        System.out.println(SubClass.value);
    }

    @Test
    public void demo01() {
        System.out.println(SuperClass.HELLO_WORLD);
    }
}
