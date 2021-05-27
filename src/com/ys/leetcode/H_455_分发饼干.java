package com.ys.leetcode;

import java.util.Arrays;

/**
 * @author HuaDong
 * @date 2021/5/26 23:17
 */
public class H_455_分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = res; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    s[j] = 0;
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
