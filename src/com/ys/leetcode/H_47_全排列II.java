package com.ys.leetcode;

import java.util.*;

/**
 * @author HuaDong
 * @date 2021/5/22 19:47
 */
public class H_47_全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];

        dfs(nums, visited, new ArrayDeque<>(), res);

        return res;
    }

    private void dfs(int[] nums, boolean[] visited, ArrayDeque<Integer> tmp, List<List<Integer>> res) {

        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            tmp.addLast(nums[i]);
            dfs(nums, visited, tmp, res);
            visited[i] = false;
            tmp.removeLast();

            // 前面已排序，相同数字跳过
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrace(listAll, list, nums, visited);
        return listAll;
    }
    private void backTrace(List<List<Integer>> listAll, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            listAll.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                backTrace(listAll, list, nums, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }
}
