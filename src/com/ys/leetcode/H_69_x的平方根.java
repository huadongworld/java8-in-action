package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/27 20:00
 */
public class H_69_x的平方根 {
    public int mySqrt(int x) {
        long start = 0, end = x;
        int res = -1;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * mid <= x) {
                res = (int) mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;
    }
}
