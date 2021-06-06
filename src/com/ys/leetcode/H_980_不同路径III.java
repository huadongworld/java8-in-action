package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/6/5 16:50
 */
public class H_980_不同路径III {

    int res = 0;

    public int uniquePathsIII(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int start1 = 0, start2 = 0, stepCount = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start1 = i;
                    start2 = j;
                    continue;
                }
                if (grid[i][j] == 0) {
                    stepCount++;
                }
            }
        }

        dfs(grid, start1, start2, stepCount);

        return res;
    }

    private void dfs(int[][] grid, int i, int j, int stepCount) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
            return;
        }

        if (grid[i][j] == 2) {
            if (stepCount == 0) {
                res++;
            }
            return;
        }

        grid[i][j] = -1;

        dfs(grid, i + 1, j, stepCount - 1);
        dfs(grid, i, j + 1, stepCount - 1);
        dfs(grid, i - 1, j, stepCount - 1);
        dfs(grid, i, j - 1, stepCount - 1);

        grid[i][j] = 0;
    }

    @Test
    public void demo() {
        this.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}});
    }
}
