package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/19 23:16
 */
public class H_11_盛最多水的容器 {

    /**
     * 暴力（超时）
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = -1;
        for (int i = 0; i < height.length -1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (height[i] > height[j] ? height[j] : height[i]) * (j - i));
            }
        }
        return max;
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int max = -1;
        while (l < r) {
            max = Math.max(max, (height[l] > height[r] ? height[r] : height[l]) * (r - l));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
