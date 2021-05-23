package com.ys.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/5/22 20:48
 */
public class H_39_组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        dfs(candidates, target, 0, 0, new ArrayDeque<>(), res);

        return res;
    }

    private void dfs(int[] candidates, int target, int index, int total, ArrayDeque<Integer> tmp, List<List<Integer>> res) {

        if (total == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        if (total > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            tmp.addLast(candidates[i]);
            total += candidates[i];
            dfs(candidates, target, i, total, tmp, res);
            tmp.removeLast();
            total -= candidates[i];
        }
    }
}
