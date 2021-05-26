package com.ys.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/5/25 12:37
 */
public class H_131_分割回文串 {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        dfs(s, 0, new ArrayDeque<String>(), res);

        return res;
    }

    private void dfs(String s, int level, Deque<String> tmp, List<List<String>> res) {

        if (level == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = level + 1; i <= s.length(); i++) {

            String strTmp = s.substring(level, i);

            // 判断是否是回文串
            if (!isHuiWen(strTmp)) {
                continue;
            }
            tmp.addLast(strTmp);
            dfs(s, i, tmp, res);
            tmp.removeLast();
        }
    }

    private boolean isHuiWen(String strTmp) {
        String reverseStr = new StringBuilder(strTmp).reverse().toString();
        return strTmp.equals(reverseStr);
    }

    @Test
    public void demo() {
        this.partition("aaab");
    }
}
