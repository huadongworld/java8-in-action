package com.ys.leetcode;

import java.util.Arrays;

/**
 * @author HuaDong
 * @date 2021/5/20 18:45
 */
public class H_88_合并两个有序数组 {

    /**
     * 投机取巧（不推荐）
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < m + n && j < n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    /**
     * 从大到小后面开始插入，因为数组后面都是0，前面插入需要移动元素
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            if (m >= 0) {
                if (nums1[m] > nums2[n]) {
                    nums1[index--] = nums1[m--];
                } else {
                    nums1[index--] = nums2[n--];
                }
            } else {
                nums1[index--] = nums2[n--];
            }
        }
    }
}
