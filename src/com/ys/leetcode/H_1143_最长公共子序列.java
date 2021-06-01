package com.ys.leetcode;

/**
 * DP方程：
 *
 * 二维数组：
 *
 * if a[i] == b[j]
 *     dp[i][j] = dp[i-1][j-1] + 1;
 * else
 *     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
 *
 * @author HuaDong
 * @date 2021/5/29 15:50
 */
public class H_1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Char = text1.toCharArray();
        char[] text2Char = text2.toCharArray();

        int m = text1.length(), n = text2.length();

        int[][] board = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char tmp1 = text1Char[i - 1];
            for (int j = 1; j <= n; j++) {
                char tmp2 = text2Char[j - 1];
                if (tmp1 == tmp2) {
                    board[i][j] = board[i - 1][j - 1] + 1;
                } else {
                    board[i][j] = Math.max(board[i - 1][j], board[i][j - 1]);
                }
            }
        }

        return board[m][n];
    }
}
