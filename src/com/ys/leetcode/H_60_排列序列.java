package com.ys.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HuaDong
 * @date 2021/5/22 21:22
 */
public class H_60_排列序列 {
    public String getPermutation(int n, int k) {

        Deque<Integer> tmp = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        dfs(n, k, visited, tmp);

        return result.toString();
    }

    private StringBuilder result = new StringBuilder();
    private int count = 0;

    private void dfs(int n, int k, boolean[] visited, Deque<Integer> tmp) {

        if (count == k) {
            return;
        }

        // 递归终止条件是：tmp 的长度等于 n
        if (tmp.size() == n) {
            count++;
            if (count == k) {
                while (tmp.size() != 0) {
                    result.append(tmp.pollFirst());
                }
                int i = n;
                while (i-- > 0) {
                    tmp.addLast(0);
                }
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            tmp.addLast(i);
            visited[i] = true;
            dfs(n, k, visited, tmp);
            visited[i] = false;
            tmp.removeLast();
        }
    }
}
