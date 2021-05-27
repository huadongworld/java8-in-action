package com.ys.leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author HuaDong
 * @date 2021/5/26 21:34
 */
public class H_860_柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                if (map.get(5) != null && map.get(5) != 0) {
                    map.put(5, map.get(5) + 1);
                } else {
                    map.put(5, 1);
                }
            } else if (bills[i] == 10) {
                if (map.get(5) == null || map.get(5) == 0) {
                    return false;
                } else {
                    map.put(5, map.get(5) - 1);
                    if (map.get(10) != null && map.get(10) != 0) {
                        map.put(10, map.get(10) + 1);
                    } else {
                        map.put(10, 1);
                    }
                }
            } else if (bills[i] == 20) {
                if (map.get(10) != null && map.get(10) != 0) {
                    if (map.get(5) == null || map.get(5) == 0) {
                        return false;
                    }
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                } else {
                    if (map.get(5) == null || map.get(5) < 3) {
                        return false;
                    }
                    map.put(5, map.get(5) - 3);
                }
            }
        }

        return true;
    }

    @Test
    public void demo() {
        this.lemonadeChange(new int[]{5, 5, 10, 10, 20});
    }
}
