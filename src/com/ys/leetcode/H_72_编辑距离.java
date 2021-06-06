package com.ys.leetcode;

import org.junit.Test;

/**
 * DP方程：
 *
 * 二维图画一画
 *
 * @author HuaDong
 * @date 2021/6/5 16:02
 */
public class H_72_编辑距离 {
    public int minDistance(String word1, String word2) {

        int m = word1.length(), n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            char tmp = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                if (tmp == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }

    @Test
    public void demo() {
        this.minDistance("horse", "ros");
    }
}
