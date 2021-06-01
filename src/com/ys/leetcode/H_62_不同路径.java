package com.ys.leetcode;

import org.junit.Test;

/**
 * DP方程：
 *
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 *
 * @author HuaDong
 * @date 2021/5/29 14:15
 */
public class H_62_不同路径 {
    public int uniquePaths(int m, int n) {

        int[][] board = new int[m][n];

        for (int i = 0; i < m; i++) {
            board[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            board[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                board[i][j] = board[i - 1][j] + board[i][j - 1];
            }
        }

        return board[m - 1][n - 1];
    }

    @Test
    public void demo() {
        this.uniquePaths(3, 7);
    }
}
