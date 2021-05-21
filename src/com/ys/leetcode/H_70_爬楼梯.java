package com.ys.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HuaDong
 * @date 2021/5/19 23:52
 */
public class H_70_爬楼梯 {

    /**
     * F(n) = F(n-1) + F(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int temp1 = 1, temp2 = 2;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = temp1;
            temp1 = temp2;
            temp2 = temp + temp1;
        }
        return temp2;
    }

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * F(n) = F(n-1) + F(n-2)
     *
     * 暴力递归
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (map.get(n) != null) {
            return map.get(n);
        }

        int result = climbStairs(n - 1) + climbStairs(n - 2);

        map.put(n, result);

        return result;
    }
}
