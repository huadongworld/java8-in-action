package com.ys.java8.test.section4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class section4 {

    @Test
    public void Demo01() {

        List<String> title = Arrays.asList("Java8", "In", "Action");

        //流只能被消费一次
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
//        s.forEach(System.out::println);//stream has already been operated upon or closed
    }
}
