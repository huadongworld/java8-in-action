package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/31 20:02
 */
public class H_64_最小路径和 {
    public int minPathSum(int[][] grid) {

        // 初始化
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j >= 1) {
                    grid[0][j] += grid[0][j - 1];
                }

                if (j == 0 && i >= 1) {
                    grid[i][0] += grid[i - 1][0];
                }
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    @Test
    public void demo() {
        this.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }
}
