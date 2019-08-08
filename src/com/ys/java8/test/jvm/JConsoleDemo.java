package com.ys.java8.test.jvm;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2019/8/8 18:08
 */
public class JConsoleDemo {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            //稍作延迟，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }

        System.gc();
    }

    @Test
    public void demo() throws InterruptedException {
        fillHeap(1000);
    }

    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                ;
            }

        }, "testBusyThread");

        thread.start();
    }

    /**
     * 线程等待演示
     */
    public static void createLockThread(final Object lock){
        Thread thread = new Thread(() -> {
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "testLockThread");
        thread.start();
    }

    @Test
    public void demo01() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        createBusyThread();
        bufferedReader.readLine();
        Object object = new Object();
        createLockThread(object);
    }

    /**
     * 线程死锁等待演示
     */
    static class SynAddRunalbe implements Runnable{

        int a, b;

        public SynAddRunalbe(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a + b);
                }
            }
        }
    }

    @Test
    public void demo02() {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunalbe(1, 2)).start();
            new Thread(new SynAddRunalbe(2, 1)).start();
        }
    }
}
