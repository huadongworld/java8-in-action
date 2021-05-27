package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/27 19:18
 */
public class H_45_跳跃游戏II {
    public int jump(int[] nums) {
        int start, end;
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len;) {
            start = i + 1;
            end = i + nums[i];

            if (end >= len) {
                break;
            } else {
                int max = 0;
                for (int j = start; j <= end; j++) {
                    if (j + nums[j] > max) {
                        i = j;
                        max = j + nums[j];
                    }
                }
            }

            res++;
        }

        return res;
    }


    public int jump2(int[] nums) {
        int res = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;
            end = maxPos + 1;
            res++;
        }
        return res;
    }

}
