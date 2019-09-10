package com.ys.java8.test.jvm;

import org.junit.Test;

import java.util.Map;

/**
 * @author HuaDong
 * @date 2019/9/1 22:47
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    @Test
    public void demo() {

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(
                    () -> {
                        for (int j = 0; j < 10000; j++) {
                            increase();
                        }
                    }
            );
            threads[i].start();
        }

        //等待所有累加线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(race);
    }

    volatile boolean shutdownRequested;

    public void shutdown() {
        shutdownRequested = true;
    }

    public void doWork() {
        while (!shutdownRequested) {
            // do stuff
        }
    }
}
