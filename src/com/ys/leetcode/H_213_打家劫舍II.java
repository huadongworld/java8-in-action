package com.ys.leetcode;

import org.junit.Test;

/**
 * DP方程：
 *
 * dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
 *
 * 分别去掉首尾房子算一次最大，再取更大的
 *
 * @author HuaDong
 * @date 2021/5/30 14:38
 */
public class H_213_打家劫舍II {
    public int rob(int[] nums) {

        if (nums.length < 2) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 不偷最后一个房子
        int res1 = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            res1 = Math.max(res1, dp[i]);
        }

        // 不偷第一个房子
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);

        int res2 = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + 1], dp[i - 1]);
            res2 = Math.max(res2, dp[i]);
        }

        return Math.max(res1, res2);
    }

    @Test
    public void demo() {
        this.rob(new int[]{1, 2, 3, 1});
    }
}
