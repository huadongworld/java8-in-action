package com.ys.java8.test.oom;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2019/7/29 21:39
 */
public class RuntimeConstantPoolOOM {

    @Test
    public void demo() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
