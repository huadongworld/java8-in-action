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

    @Test
    public void demo() throws Exception {

        //获取Class类
        Class clazz = Person.class;
//        Class clazz1 = new Person().getClass();
//        Class clazz2 = Class.forName("com.ys.java8.constant.reflect.Person");

        //得到Person的实例（无参）
        Person person = (Person) clazz.newInstance();
        //得到Person的实例（有参）
        clazz.getConstructors();//获取所有的构造函数
        //传入有参构造函数里面的参数类型，类型使用Class形式传递
        Constructor constructor = clazz.getConstructor(String.class, String.class);
        //通过有参数的构造方法创建Person实例
        Person person1 = (Person) constructor.newInstance("张三", "001");
        //得到name属性
        clazz.getDeclaredFields();//获取所有属性
        Field field = clazz.getDeclaredField("name");
        //设置可操作性私有的属性
        field.setAccessible(true);
        //设置值，参数是：对象实例和设置的值 相当于person.name = "lisi"
        field.set(person, "lisi");
        //获取值，相当于person.name
        System.out.println(field.get(person));
        //操作普通方法
        clazz.getDeclaredMethods();//获取所有普通方法
        //参数：方法名，通过方法设置的值
        Method method = clazz.getDeclaredMethod("setName", String.class);
        //设置可操作性私有的方法
        method.setAccessible(true);
        //执行方法，两个参数：person实例，设置的值
        method.invoke(person, "wangwu");
        System.out.println(person.getName());
    }
}
