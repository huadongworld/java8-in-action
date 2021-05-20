package com.ys.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/5/20 10:33
 */
public class H_15_三数之和 {

    /**
     * 暴力美学
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length <= 2) {
            return lists;
        }
        // 排序便于去重
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int flag = 0;
                        for (List<Integer> list : lists) {
                            if (nums[i] == list.get(0) && nums[j] == list.get(1)) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0) {
                            lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
        }
        return lists;
    }

    /**
     * 双指针法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length <= 2) {
            return lists;
        }
        // 排序
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {

            if (nums[k] > 0) {
                return lists;
            }

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] > -nums[k]) {
                    j--;
                } else if (nums[i] + nums[j] < -nums[k]) {
                    i++;
                } else {
                    int flag = 0;
                    for (List<Integer> list : lists) {
                        if (list.get(0) == nums[k] && list.get(1) == nums[i]) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        lists.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    }
                    i++;
                    j--;
                }
            }
        }
        return lists;
    }
}
