package com.ys.java8.test.oom;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2019/7/22 23:39
 */
public class JavaVMStackOOM {

    private void doNotStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                doNotStop();
            });
            thread.start();
        }
    }

    @Test
    public void demo() {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
