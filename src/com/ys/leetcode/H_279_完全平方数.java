package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/31 19:02
 */
public class H_279_完全平方数 {
    public int numSquares(int n) {

        if (n == 1) {
            return 1;
        }

        int[] squares = new int[102];
        for (int i = 1; i <= 100; i++) {
            squares[i] = i * i;
        }

        int len = n / 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= len; j++) {
                if (i < squares[j]) {
                    break;
                }
                min = Math.min(min, dp[i - squares[j]]);
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            } else {
                dp[i] = min;
            }
        }

        return dp[n];
    }

    @Test
    public void demo() {
        System.out.println(this.numSquares(12));
    }
}
