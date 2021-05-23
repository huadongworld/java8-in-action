package com.ys.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/5/22 19:15
 */
public class H_46_全排列 {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(nums, visited, new ArrayDeque<>(), res);
        return res;

    }

    private void dfs(int[] nums, int[] visited, Deque<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.addLast(nums[i]);
            dfs(nums, visited, tmp, res);
            visited[i] = 0;
            tmp.removeLast();
        }
    }
}
