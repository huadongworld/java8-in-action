package com.ys.java8.reference;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2020/3/3 23:02
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }
    public static int value = 123;

    public static final String HELLO_WORLD = "hello world!";

    @Test
    public void demo() {
//        1010 1000 1001
//        0000 0000 1111
//        0000 0000 1001

//        0000 1010 1000
//        0000 0000 1111
//        0000 0000 1000

//        0000 0000 1010
//        0000 0000 1111
//        0000 0000 1010
    }

    public void transform(int num) {
        int tem = num & 15;

    }

}
