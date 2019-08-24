package com.ys.java8.test.jvm;

/**
 * 被动使用类字段三：
 * 常量在编译阶段会存入编译类的常量池中，本质上并没有直接引用到定义常量的类，因此不会初始化定义常量的类的初始化
 *
 * @author HuaDong
 * @date 2019/8/23 15:36
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLO_WORLD = "hello world!";

}
