package com.ys.java8.test.utils;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

/**
 * @author HuaDong
 * @date 2019/10/21 10:33
 */
public class ThreadStartup {

    /**
     * 保存所有公司信息
     */
    private Queue<Long> companyQueue = new LinkedList<>();

    /**
     * 请求总数
     */
    private int companyTotal;

    /**
     * 同时并发执行的线程数
     */
    private final static int THREAD_TOTAL = 100;

    public synchronized Long getCompany() {
        return companyQueue.poll();
    }

    /**
     * 所有公司信息在容器启动的时候就查询出来
     */
    public void init() {

        List<Long> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add((long) i);
        }

        companyTotal = list.size();
        companyQueue = new LinkedList<>(list);
    }

    public void startThread() {

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_TOTAL);

        final Semaphore semaphore = new Semaphore(THREAD_TOTAL);
        final CountDownLatch countDownLatch = new CountDownLatch(companyTotal);

        Long company = getCompany();
        while (company != null) {
            Long finalCompany = company;
            System.out.println(Thread.currentThread().getName() + "——" + finalCompany);
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "——" + finalCompany);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
            company = getCompany();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    private Boolean flag;

    @Test
    public void demo() {
        if (SignType.CHARGE_BY_BILL.equals(null) || true || flag) {
            System.out.println("true" + flag);
        } else {
            System.out.println("false" + flag);
        }
    }

    @Test
    public void demo01() {
        Set<String> cloudGoodsIds = new HashSet<>();
        cloudGoodsIds.add("fffd5ff156e24f50993419cd600ffbc1");
        cloudGoodsIds.add("fffd5ff156e24f50993419cd600ffbc2");
        cloudGoodsIds.add("fffd5ff156e24f50993419cd600ffbc3");

        System.out.println(cloudGoodsIds.stream().map(id -> "'" + id + "'").collect(Collectors.toSet()));;
    }

    class CompanyAmount {

        public CompanyAmount(String companyName, BigDecimal amount) {
            this.companyName = companyName;
            this.amount = amount;
        }

        public CompanyAmount() {

        }

        private String companyName;
        private BigDecimal amount;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
    }

    @Test
    public void demo02() {

        List<CompanyAmount> list = new ArrayList<>();
        list.add(new CompanyAmount("1", new BigDecimal(99)));
        list.add(new CompanyAmount("2", new BigDecimal(1)));
        list.add(new CompanyAmount("3", new BigDecimal(2)));
        list.add(new CompanyAmount("3", new BigDecimal(2)));
        list.add(new CompanyAmount("3", new BigDecimal(2)));
        list.add(new CompanyAmount("4", new BigDecimal(3)));
        list.add(new CompanyAmount("-1", new BigDecimal(-1)));

        System.out.println(list.stream()
                .sorted(Comparator.comparing(CompanyAmount::getAmount).reversed())
                .limit(5)
                .map(CompanyAmount::getCompanyName)
                .reduce("", (a, b) -> a + b + "|"));

    }

    @Test
    public void demo03() {
        List<Object> result = new ArrayList<>();
        result.add(null);
        result.add(null);
        System.out.println(result.size());
    }

    @Test
    public void demo04() {
        if (false && check()) {
            return;
        }
    }

    private boolean check() {
        System.out.println("123");
        return true;
    }
}
