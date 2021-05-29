package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/27 21:11
 */
public class H_33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // l ~ mid 为升序
            if (nums[0] <= nums[mid]) {
                // 升序范围内
                if (nums[0] <= target &&  target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
