package com.ys.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/5/22 17:10
 */
public class H_78_子集 {

    public List<List<Integer>> subsets(int[] nums) {

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
        }
    }
}
