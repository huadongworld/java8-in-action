package com.ys.java8.test.gc;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2019/7/31 7:28
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一的意义是占点内存，以便能在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    @Test
    public void demo() {

        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        //假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }
}
