package com.ys.leetcode;

import java.util.*;

/**
 * @author HuaDong
 * @date 2021/5/22 17:10
 */
public class H_90_子集II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, 0, new ArrayDeque<>(), res);

        return res;
    }

    private void dfs(int[] nums, int index, Deque<Integer> tmp, List<List<Integer>> res) {

        res.add(new ArrayList<>(tmp));

        for (int i = index; i < nums.length; i++) {
            tmp.addLast(nums[i]);
            dfs(nums, i + 1, tmp, res);
            tmp.removeLast();

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
