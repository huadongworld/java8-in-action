package com.ys.leetcode;

/**
 * DP方程：
 *
 * 分别记录最小和最大，如果当前数为负数，则交换最大和最小值
 *
 * @author HuaDong
 * @date 2021/5/29 19:49
 */
public class H_152_乘积最大子数组 {

    public int maxProduct(int[] nums) {

        int maxi = 1, mini = 1, res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 0) {
                int tmp = maxi;
                maxi = mini;
                mini = tmp;
            }

            maxi = Math.max(maxi * nums[i], nums[i]);
            mini = Math.min(mini * nums[i], nums[i]);

            res = Math.max(maxi, res);

        }

        return res;
    }
}
