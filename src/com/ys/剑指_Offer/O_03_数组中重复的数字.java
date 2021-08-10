package com.ys.剑指_Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author HuaDong
 * @date 2021/7/20 21:11
 */
public class O_03_数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        for (int num : nums) {
            if (setNums.contains(num)) {
                return num;
            }
            setNums.add(num);
        }
        return nums[0];
    }
}
