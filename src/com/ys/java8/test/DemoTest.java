package com.ys.java8.test;

import com.sun.istack.internal.NotNull;
import com.ys.java8.test.function.Supplier;
import org.junit.Test;

import java.text.DateFormat;
import java.util.*;

/**
 * @author HuaDong
 * @date 2019/9/6 17:44
 */
public class DemoTest {

    @Test
    public void demo() {
        final String version = "1.8";
        foo(new Supplier() {
            @Override
            public String get() {
                System.out.println(Thread.currentThread().getName());
                return version;
            }
        });
    }


    @Test
    public void demo01() {
        Random random = new Random();
        int index = random.nextInt(9) + 1;

        System.out.println(index);
    }

    private void foo(Supplier supplier) {
        System.out.println(supplier.get());
    }

    @Test
    public void demo02() {
        Set<Integer> h1 = new HashSet<>();
        h1.add(1);
        h1.add(2);
        h1.add(3);
        Set<Integer> h2 = new HashSet<>();
        h2.add(2);
        h2.add(3);
        h2.add(4);
        System.out.println(h2.containsAll(h1));
    }

    @Test
    public void demo03() {
        isValid(null);
    }

    public static boolean isValid(@NotNull GraceCode user) {
        return Boolean.TRUE.equals(user.getClass());
    }

    @Test
    public void demo04() {
        List<List<String>> stringList = new ArrayList<>();
        stringList.add(Arrays.asList("1", "1", "1"));
        stringList.add(Arrays.asList("2", "2", "2"));
        stringList.add(Arrays.asList("3", "3", "3"));
        stringList.add(Arrays.asList("4", "4", "4"));

        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < stringList.size(); i++) {
            int finalI = i;
            stringList.stream().forEach(list -> {
                System.out.println(Thread.currentThread().getName());
                String a = list.get(finalI);
                System.out.println(a);
            });
        }
    }

    @Test
    public void demo05() {
        List<Integer> a = new ArrayList<>();
        List<Integer> list = a;
        list.addAll(Arrays.asList(1, 2, 3, 4));
        System.out.println(a.size());
    }

    private void getList(List<String> list) {
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list = list2;
    }

    @Test
    public void demo06() {
        User user = new User();
        System.out.println(user);
        getString(user);
        System.out.println(user);
    }

    private void getString(User user) {
        System.out.println(user);
        user = new User("123");
        System.out.println(user);
    }

    @Test
    public void demo07() {
        User user = new User();
        User user1 = user;
        user1 = new User("123");
        System.out.println(user.getA());
    }

    class User {

        public User() {

        }

        public User(String a) {
            this.a = a;
        }

        private String a;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }

    @Test
    public void demo08() {
        System.out.println("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAwMDAwMDEiLCJleHAiOjE1ODg4NTg1NjgsImlhdCI6MTU4ODg0NDE2OH0.FeVDrEe0Mx6elhO5uXkoJwLTpfX2up-krFcOhLS66Ho"
                .equals("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAwMDAwMDEiLCJleHAiOjE1ODg4NTg1OTQsImlhdCI6MTU4ODg0NDE5NH0.g36UbsRJsTYI6dk2XOJ2U816QC6lK994QTDJvXvwOZU"));

    }

    @Test
    public void demo09() {
        System.out.println((1010 / 1) % 10);
        System.out.println((1010 / 10) % 10);
        System.out.println((1010 / 100) % 10);
        System.out.println((1010 / 1000) % 10);
        System.out.println(8 & 7);
    }

    @Test
    public void demo10() {
        int shi = 15;
        System.out.println((shi & 1));
        System.out.println((shi & 2) >> 1);
        System.out.println((shi & 4) >> 2);
        System.out.println((shi & 8) >> 3);
    }

    @Test
    public void demo11() {
        Calendar calendar = Calendar.getInstance();
        // 从当前时间开始往前一年每天都算一遍
        for (int i = 0; i < 365; i++) {
            System.out.println(DateFormat.getDateInstance().format(calendar.getTime()));
            calendar.add(Calendar.DATE, -1);
        }
    }

    @Test
    public void demo12() {
        List<String> ids = Arrays.asList("1L", "2L", "3L", "4L", "5L", "6L");
        List<String> ids1 = Arrays.asList("7L", "2L", "3L", "4L", "5L", "6L");
        ids.retainAll(ids1);
        System.out.println(ids);
    }

    public void demo13() {
        List<String> strList = new ArrayList<String>();
        List<String> strList2 = new ArrayList<String>();
        for(int i = 0; i < 10; i ++) {
            strList.add("aaa>>" + i);
            strList2.add("aaa>>" + (10 - i));
        }

        //求出交集
        strList2.retainAll(strList);
        System.out.println("交集大小：" + strList2.size());

        for(int i = 0; i < strList2.size(); i++) {
            System.out.println(strList2.get(i));
        }
    }
}
