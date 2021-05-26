package com.ys.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HuaDong
 * @date 2021/5/26 19:28
 */
public class H_169_多数元素 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int n = nums.length / 2;

        int res = 0;
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() > n) {
                res = (int) entry.getKey();
            }
        }
        return res;
    }

    public int majorityElemen2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
