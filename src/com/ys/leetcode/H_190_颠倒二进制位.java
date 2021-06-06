package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/6/5 0:50
 */
public class H_190_颠倒二进制位 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
