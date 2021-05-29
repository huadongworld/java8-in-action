package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/29 10:57
 */
public class H_153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r];
    }
}
