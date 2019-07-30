package com.ys.java8.test.oom;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2019/7/22 7:47
 */
public class HeapOOM {

    static class OOMObject {
    }

    @Test
    public void test() {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
