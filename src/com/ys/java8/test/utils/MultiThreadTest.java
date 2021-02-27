package com.ys.java8.test.utils;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author HuaDong
 * @date 2019/10/20 17:31
 */
public class MultiThreadTest {

    @Test
    public void demo() {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        int i = 100;
        while (true) {
            int finalI = i;
            executorService.execute(()-> {
                System.out.println(Thread.currentThread().getName() + "——正在处理——" + finalI);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Test
    public void demo01() {
        Integer openBillNum = 27;
        Integer openBillTotal = 43;
        System.out.println(openBillNum * 100 / openBillTotal);

        System.out.printf("%1$-10s——————%2$-5s", "法国", "中国");
        System.out.println();
        System.out.printf("%1$-10s——————%2$-5s", "阿斯顿发", "中国");
        System.out.println();
        System.out.printf("%1$-10s——————%2$-5s", "阿斯顿发发斯蒂芬", "中国");
    }
}
