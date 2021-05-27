package com.ys.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author HuaDong
 * @date 2021/5/27 0:05
 */
public class H_55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        boolean[] tmp = new boolean[nums.length];
        Arrays.fill(tmp, false);
        tmp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (!tmp[i]) {
                return false;
            }

            int n = nums[i];
            while (n > 0) {
                if ((n + i) >= nums.length) {
                    return true;
                }
                tmp[n-- + i] = true;
            }
        }

        return true;
    }

    @Test
    public void demo() {
        this.canJump(new int[]{1, 1, 1, 0});
    }
}
