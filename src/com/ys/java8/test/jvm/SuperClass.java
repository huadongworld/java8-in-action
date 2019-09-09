package com.ys.java8.test.jvm;

/**
 * @author HuaDong
 * @date 2019/8/23 15:39
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}
