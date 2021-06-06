package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/6/5 1:00
 */
public class H_338_比特位计数 {

    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = getOne(i);
        }
        return res;
    }

    private int getOne(int n) {
        int i = 32;
        int count = 0;
        while (i-- > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
