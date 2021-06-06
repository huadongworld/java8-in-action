package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/6/5 0:30
 */
public class H_231_1的幂 {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}
