package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/28 12:34
 */
public class H_4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] combine = new int[len1 + len2];
        int i = 0, j = 0, k = 0;
        while (true) {

            if (j == len2 && i == len1) {
                break;
            } else if (j == len2) {
                while (i < len1) {
                    combine[k++] = nums1[i++];
                }
            } else if (i == len1) {
                while (j < len2) {
                    combine[k++] = nums2[j++];
                }
            } else {
                if (j < len2 && nums1[i] > nums2[j]) {
                    combine[k++] = nums2[j++];
                } else if (i < len1) {
                    combine[k++] = nums1[i++];
                }
            }

        }

        int len3 = combine.length;

        if ((len3 & 1) == 1) {
            return combine[len3 / 2];
        } else {
            int mid = len3 / 2;
            return (combine[mid - 1] + combine[mid]) / 2.0;
        }
    }

    @Test
    public void demo() {
        this.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }

}
