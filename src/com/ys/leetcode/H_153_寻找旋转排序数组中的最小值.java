package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/29 10:57
 */
public class H_153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] < numbers[r]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return numbers[r];
    }
}
