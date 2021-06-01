package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/29 14:28
 */
public class H_63_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }

        boolean flagRight = false;
        boolean flagBelow = false;

        for (int j = n - 1; j >= 0; j--) {
            if (obstacleGrid[m - 1][j] == -1) {
                flagRight = true;
            }
            if (!flagRight) {
                obstacleGrid[m - 1][j] = 1;
            } else {
                obstacleGrid[m - 1][j] = -1;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == -1) {
                flagBelow = true;
            }
            if (!flagBelow) {
                obstacleGrid[i][n - 1] = 1;
            } else {
                obstacleGrid[i][n - 1] = -1;
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] != -1) {
                    int right = 0, below = 0;
                    if (obstacleGrid[i][j + 1] != -1) {
                        right = obstacleGrid[i][j + 1];
                    }
                    if (obstacleGrid[i + 1][j] != -1) {
                        below = obstacleGrid[i + 1][j];
                    }
                    obstacleGrid[i][j] = right + below;
                }
            }
        }

        return obstacleGrid[0][0];
    }

    @Test
    public void demo() {
        this.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }


    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // 定义 dp 数组并初始化第 1 行和第 1 列。
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 0) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] != 0) {
                break;
            }
            dp[0][j] = 1;
        }

        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
