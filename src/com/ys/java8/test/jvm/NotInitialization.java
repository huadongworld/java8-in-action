package com.ys.java8.test.jvm;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2019/8/23 15:38
 */
public class NotInitialization {

    @Test
    public void demo() {
        System.out.println(ConstClass.HELLO_WORLD);
    }

    /**
     * 被动使用类字段演示二：
     * 通过数组定义来引用类，不会触发该类的初始化
     */
    @Test
    public void demo01() {
        SuperClass[] superClasses = new SuperClass[10];
    }

    @Test
    public void demo02() {
        System.out.println(SuperClass.value);
    }
}
