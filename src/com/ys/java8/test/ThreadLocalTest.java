package com.ys.java8.test;

import com.ys.java8.test.utils.DateUtil;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HuaDong
 * @date 2019/7/9 13:50
 */
public class ThreadLocalTest {

    /**
     * 创建只有一个线程的线程池
     */
    private static ExecutorService executor = Executors.newFixedThreadPool(1);

    /**
     * 测试用的ThreadLocal
     */
    private static ThreadLocal<String> TEST_THREAD_LOCAL = new ThreadLocal<>();

    @Test
    public void test() {

        //循环三次，模拟三个不同用户的请求
        for (int i = 1; i <= 3; i++) {
            int finalI = i;
            executor.execute(() -> {

                System.out.println("模拟【第" + finalI + "个】用户请求");

                //先get()一遍本地线程中的信息
                System.out.println("线程【" + Thread.currentThread().getName() + "】的ThreadLocal保存的信息：" + TEST_THREAD_LOCAL.get());

                //重新set()用户信息
                TEST_THREAD_LOCAL.set("用户" + finalI + "的信息");

                //再get()一次用户信息
                System.out.println("线程【" + Thread.currentThread().getName() + "】的ThreadLocal保存的信息：" + TEST_THREAD_LOCAL.get() + "\n");

                //当前线程结束，移除本地线程中保存的信息
                TEST_THREAD_LOCAL.remove();
            });
        }

        //记得关闭线程池
        executor.shutdown();
    }

    @Test
    public void demo() {
        System.out.println(DateUtil.getTimeStamp(new Date()));
    }
}
