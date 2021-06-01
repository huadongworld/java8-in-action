package com.ys.leetcode;

import org.junit.Test;

/**
 * DP方程：
 *
 * dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
 *
 * @author HuaDong
 * @date 2021/5/29 21:16
 */
public class H_198_打家劫舍 {
    public int rob(int[] nums) {

        if (nums.length < 2) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int res = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int rob2(int[] nums) {

        if (nums.length < 2) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i][1]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i][0]);
            res = Math.max(dp[i][0], dp[i][1]);
        }

        return res;
    }

    @Test
    public void demo() {
        this.rob2(new int[]{2, 1, 1, 2});
    }

}
