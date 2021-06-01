package com.ys.leetcode;

import org.junit.Test;

/**
 * DP方程：
 *
 * dp[i] = Math.max(dp[i - 1], 0) + nums[i];
 *
 * @author HuaDong
 * @date 2021/5/29 19:33
 */
public class H_53_最大子序和 {
    public int maxSubArray(int[] nums) {

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], 0) + nums[i];
            res = Math.max(res, nums[i]);
        }

        return res;
    }

    @Test
    public void demo() {
        this.maxSubArray(new int[]{-1, -2});
    }
}
