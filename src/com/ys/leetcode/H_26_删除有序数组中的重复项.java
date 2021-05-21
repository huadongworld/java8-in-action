package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/20 16:30
 */
public class H_26_删除有序数组中的重复项 {

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 1;
        int temp = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                temp = nums[i];
                nums[j++] = nums[i];
            } else {
                count++;
            }
        }
        return nums.length - count;
    }
}
