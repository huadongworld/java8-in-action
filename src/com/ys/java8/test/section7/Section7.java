package com.ys.java8.test.section7;

import org.junit.Test;

import java.util.function.Function;

public class Section7 {

    public ParallelStreams parallelStreams = new ParallelStreams();

    public long measureSumPerf(Function<Long, Long> fun, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = fun.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result:" + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

    @Test
    public void Demo01() {

        System.out.println(measureSumPerf(parallelStreams::sequentialSum, 10_000_000) + "msecs");
        System.out.println(measureSumPerf(ParallelStreams::iteratorSum, 10_000_000) + "msecs");
        System.out.println(measureSumPerf(ParallelStreams::rangeSum, 10_000_000) + "msecs");
        System.out.println(measureSumPerf(ParallelStreams::parallelRangeSum, 10_000_000) + "msecs");
    }
}
