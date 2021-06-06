package com.ys.leetcode;

/**
 * DP方程：
 *
 * 求出0到当前每一位最大的步数，当前最大位步数：和前面所有步数做对比，大于则前面位步数+1，小于则不变
 *
 * @author HuaDong
 * @date 2021/6/5 16:30
 */
public class H_300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
