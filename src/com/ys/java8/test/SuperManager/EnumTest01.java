package com.ys.java8.test.SuperManager;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EnumTest01 {

    @Test
    public void Demo01() {
        System.out.println(ActiveType.valueOf("NOT"));
        System.out.println("ACTIVE".equals(ActiveType.ACTIVE));
        System.out.println(ActiveType.ACTIVE.compareTo(ActiveType.ACTIVE));
        System.out.println(ActiveType.values());
        System.out.println(Arrays.stream(ActiveType.values()).collect(Collectors.toList()));
    }
}
