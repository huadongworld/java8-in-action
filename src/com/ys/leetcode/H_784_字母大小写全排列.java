package com.ys.leetcode;

import java.util.*;

/**
 * @author HuaDong
 * @date 2021/5/23 16:29
 */
public class H_784_字母大小写全排列 {
    public List<String> letterCasePermutation(String s) {

        List<String> res = new ArrayList<>();

        char[] schars = s.toUpperCase().toCharArray();

        dfs(schars, 0, new ArrayDeque<>(), res);

        return res;
    }

    private void dfs(char[] s, int begin, Deque<Character> tmp, List<String> res) {
        if (begin == s.length) {
            StringBuilder sb = new StringBuilder();
            Deque<Character> tmpTmp = new ArrayDeque<>();
            while (tmp.size() > 0) {
                sb.append(tmp.peekFirst());
                tmpTmp.addFirst(tmp.pollFirst());
            }
            res.add(sb.toString());

            while (tmpTmp.size() > 0) {
                tmp.addFirst(tmpTmp.pollFirst());
            }

            return;
        }

        char cur = s[begin];
        if (cur >= 48 && cur <= 57) {
            tmp.addLast(cur);
            dfs(s, begin + 1, tmp, res);
            tmp.removeLast();
        } else {

            for (int i = 0; i < 2; i++) {

                if (i == 0) {
                    tmp.addLast(cur);
                } else {
                    tmp.addLast((char) (cur + 32));
                }
                dfs(s, begin + 1, tmp, res);
                tmp.removeLast();
            }
        }
    }
}
