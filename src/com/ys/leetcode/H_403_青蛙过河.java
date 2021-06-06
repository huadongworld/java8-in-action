package com.ys.leetcode;

/**
 * DP方程：
 *
 * dp[i][speed]：表示当前位置i用speed速度能否跳跃
 *
 * dp[i][speed] = dp[j][speed - 1] || dp[j][speed] || dp[j][speed + 1];
 *
 * @author HuaDong
 * @date 2021/6/5 20:10
 */
public class H_403_青蛙过河 {
    public boolean canCross(int[] stones) {
        int cows = stones.length;
        boolean[][] dp = new boolean[cows][cows];
        dp[0][0] = true;

        // i 表示即将跳跃过去的石头
        for (int i = 1; i < stones.length; i++) {
            // j 表示起跳的石头
            for (int j = 0; j < i; j++) {

                // 速度
                int speed = stones[i] - stones[j];
                if (speed <= 0 || speed > j + 1) {
                    continue;
                }

                dp[i][speed] = dp[j][speed - 1] || dp[j][speed] || dp[j][speed + 1];

                if (dp[cows - 1][speed]) {
                    return true;
                }
            }
        }

        return false;
    }
}
