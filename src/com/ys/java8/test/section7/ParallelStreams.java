package com.ys.java8.test.section7;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {

    public Long sequentialSum(Long aLong) {
        int aLength = aLong.intValue();
        Long l = 0L;
        for(int i=0; i<aLength; i++) {
            l += i;
        }
        return l;
    }

    public static Long iteratorSum(Long aLong) {
        return Stream.iterate(0L, n -> n + 1)
                .limit(aLong)
                .reduce(0L, Long::sum);
    }

    public static Long rangeSum(Long aLong) {
        return LongStream.rangeClosed(1, aLong)
                .reduce(0L, Long::sum);
    }

    public static Long parallelRangeSum(Long aLong) {
        return LongStream.rangeClosed(1, aLong)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
