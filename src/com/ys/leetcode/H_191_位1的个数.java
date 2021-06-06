package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/6/5 0:19
 */
public class H_191_位1的个数 {
    public int hammingWeight(int n) {
        int count = 0;
        int i = 32;
        while (i-- > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
