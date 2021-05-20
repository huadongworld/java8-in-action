package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/19 23:04
 */
public class H_283_移动零 {

    /**
     * 方法1
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 方法2
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int originJ = nums[j];
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                nums[i] = originJ;
            }
        }
    }
}
