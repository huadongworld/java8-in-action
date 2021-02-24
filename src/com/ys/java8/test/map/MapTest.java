package com.ys.java8.test.map;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author HuaDong
 * @since 2021/1/26 9:52
 */
public class MapTest {

    @Test
    public void demo() {
        List<Distance> distanceList = new ArrayList<>();
        distanceList.add(new Distance(1L, BigDecimal.ZERO));
        distanceList.add(new Distance(1L, BigDecimal.ONE));
        distanceList.add(new Distance(1L, BigDecimal.ONE));
        distanceList.add(new Distance(2L, BigDecimal.TEN));
        distanceList.add(new Distance(3L, BigDecimal.TEN));

        Map<Long, BigDecimal> storeDistance = distanceList
                .stream().collect(Collectors.toMap(item -> item.getId(), item -> item.getDistance(), (p1, p2) -> p2));

        System.out.println(Thread.currentThread().getName());
        distanceList.stream().forEach(d -> {
            System.out.println(Thread.currentThread().getName());
        });

        System.out.println(storeDistance);
    }
}
