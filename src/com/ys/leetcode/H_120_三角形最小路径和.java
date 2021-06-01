package com.ys.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DP方程：
 *
 * dp[i][j] = Math.min(dp[i + 1][j + 1], dp[i + 1][j]) + triangle[i][j];
 *
 * @author HuaDong
 * @date 2021/5/29 17:21
 */
public class H_120_三角形最小路径和 {

    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int tmp = Math.min(triangle.get(i + 1).get(j + 1), triangle.get(i + 1).get(j)) + triangle.get(i).get(j);
                triangle.get(i).set(j, tmp);
            }
        }

        return triangle.get(0).get(0);
    }

    @Test
    public void demo() {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));
        this.minimumTotal(lists);
    }



}
