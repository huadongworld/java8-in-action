package com.ys.leetcode;

/**
 * DP方程：
 *
 * 左下角的面积 = （左 - 1）下角 + 左（下 - 1）角 - （左 - 1）（下 - 1）角 + 左下角那一小块的面积。
 *
 * @author HuaDong
 * @date 2021/6/5 19:31
 */
public class H_363_矩形区域不超过K的最大数值和 {

    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for (int i1 = 1; i1 <= rows; i1++) {
            for (int j1 = 1; j1 <= cols; j1++) {
                int[][] dp = new int[rows + 1][cols + 1];
                for (int i2 = i1; i2 <= rows; i2++) {
                    for (int j2 = j1; j2 <= cols; j2++) {
                        dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                        if (dp[i2][j2] <= k && dp[i2][j2] > max) {
                            max = dp[i2][j2];
                            // 稍微剪个枝
                            if (max == k) {
                                return k;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}
