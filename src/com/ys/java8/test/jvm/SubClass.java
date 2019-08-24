package com.ys.java8.test.jvm;

/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 *
 * @author HuaDong
 * @date 2019/8/23 15:41
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
