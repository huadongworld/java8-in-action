package com.ys.java8.test.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author HuaDong
 * @date 2019/7/15 22:49
 */
public class Person {
    //属性
    private String name;
    private String id;

    //无参构造函数
    public Person() {
    }

    //有参构造函数
    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    //普通方法
    public String getName() {
        return name;
    }
}
