package com.ys.java8.test;

import com.ys.java8.test.reflect.MemberCard;
import com.ys.java8.test.reflect.MemberCardSort;
import com.ys.java8.test.reflect.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Section13 {

    @Test
    public void demo01() {

        String billId = "WX0120150600006";

        String date = billId.substring(4, 10);
        for(int i=0; i< 10; i++) {
            String num;
            int d = (int)(Math.random()*28) + 1;
            if(d/10 > 0)
                num =date + d;
            else
                num =date + "0" + d;
            System.out.println(num);
        }

    }

    @Test
    public void demo02() {
        String cell = "1200.08";
        String cell1 = "12003.0";
        System.out.println(cell.split("\\.0")[0]);
        System.out.println(cell1.split("\\.0")[0]);

        System.out.println(multiply(new BigDecimal(10), new BigDecimal(8)));
        System.out.println(multiply(new BigDecimal(10), new BigDecimal(1)));
        System.out.println(multiply(new BigDecimal(10), new BigDecimal(10)));
        System.out.println(multiply(new BigDecimal(10), new BigDecimal(-1)));
        System.out.println(multiply(new BigDecimal(10), new BigDecimal(11)));

        System.out.println(new BigDecimal(0).multiply(new BigDecimal("10")));
    }

    private BigDecimal multiply(BigDecimal price, BigDecimal discount) {
        if (discount.compareTo(new BigDecimal("1")) > 0 && discount.compareTo(new BigDecimal("10")) < 0) {
            return price.multiply(discount).multiply(new BigDecimal(0.1));
        }
        return price;
    }

    @Test
    public void demo03() {
        System.out.println(new StringBuffer("524"));
    }

    @Test
    public void demo04() throws Exception {

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

    @Test
    public void demo05() {

        MemberCard memberCard = new MemberCard(
                1L,
                "MEBER23472834",
                new MemberCardSort(
                        3L,
                        "大会员"
                ),
                "洗头卡",
                3,
                "15634211184",
                new BigDecimal("1.24"),
                new BigDecimal("0.99")
        );

//        reflect(memberCard);

        find(memberCard);
    }

    private void reflect(MemberCard entity) {

        StringBuilder query = new StringBuilder("{");
        List<Object> params = new ArrayList<>();

        Class clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                if (i < fields.length - 1) {
                    query.append(field.getName())
                            .append(":#,");
                } else {
                    query.append(field.getName())
                            .append(":#}");
                }
                params.add(field.get(entity));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        System.out.println(query + " : " + params);
    }

    private void find(MemberCard entity) {

        List<String> names = new ArrayList<>();
        List<Double> params = new ArrayList<>();

        Class clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(entity);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value != null && BigDecimal.class == value.getClass()) {
                names.add(field.getName());
                params.add(((BigDecimal) value).setScale(2, RoundingMode.HALF_DOWN).doubleValue());
            }
        }

        if (names.size() <= 0) {
            System.out.println("空！！！");
            return;
        }

        StringBuilder sb = new StringBuilder("{$set:{");
        for (int i = 0; i < names.size(); i++) {
            if (i < names.size() - 1) {
                sb.append(names.get(i))
                        .append(":#,");
            } else {
                sb.append(names.get(i))
                        .append(":#}}");
            }
        }

        System.out.println(sb + " : " + params);
    }

    @Test
    public void demo() {
        for (int i = 0; i < 200; i++) {
            if (i < 10) {
                System.out.println("REPORT_00" + i + "(\"\"),");
            } else if (i < 100) {
                System.out.println("REPORT_0" + i + "(\"\"),");
            } else if (i < 1000) {
                System.out.println("REPORT_" + i + "(\"\"),");
            }
        }
    }

}
