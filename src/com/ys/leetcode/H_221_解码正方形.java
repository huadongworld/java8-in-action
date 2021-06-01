package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/31 21:17
 */
public class H_221_解码正方形 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j] - '0';
                if (tmp == 1) {
                    res = 1;
                }
                dp[i][j] = tmp;
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] != 0) {
                    dp[i][j] += Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }

    @Test
    public void demo() {
        this.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '2', '2'},
                {'1', '0', '0', '1', '0'}});
    }
}
