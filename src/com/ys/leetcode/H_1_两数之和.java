package com.ys.leetcode;

import java.util.Arrays;

/**
 * @author HuaDong
 * @date 2021/5/19 22:02
 */
public class H_1_两数之和 {

    /**
     * 暴力求解
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] doublePointerTwoSum(int[] nums, int target) {

        int[] result = new int[]{-1, -1};

        if (nums.length == 2) {
            return new int[]{0, 1};
        }

        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyNums);
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            if (copyNums[l] + copyNums[r] < target) {
                l++;
                continue;
            }
            if (copyNums[l] + copyNums[r] > target) {
                r--;
                continue;
            }
            if (copyNums[l] + copyNums[r] == target) {
                break;
            }
        }
        int ll = 0, rr = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == copyNums[l] && result[0] == -1) {
                result[0] = i;
                continue;
            }
            if (nums[i] == copyNums[r] && result[1] == -1) {
                result[1] = i;
            }
        }
        return result;
    }
}
