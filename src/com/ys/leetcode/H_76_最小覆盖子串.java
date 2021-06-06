package com.ys.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HuaDong
 * @date 2021/6/6 13:40
 */
public class H_76_最小覆盖子串 {
    public String minWindow(String s, String t) {

        int len = s.length();

        if (len < t.length()) {
            return "";
        }

        Map<Character, Integer> oriMap = new HashMap<>();
        Map<Character, Integer> tmpMap = new HashMap<>();

        // 原始串
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = oriMap.get(c);
            if (count != null) {
                count++;
                oriMap.put(c, count);
            } else {
                oriMap.put(c, 1);
            }
        }

        int l = 0, res = Integer.MAX_VALUE, resR = 0, resL = 0;

        for (int r = 0; r < len; r++) {

            char c = s.charAt(r);
            Integer count = tmpMap.get(c);
            if (count != null) {
                count++;
                tmpMap.put(c, count);
            } else {
                tmpMap.put(c, 1);
            }

            while (judge(tmpMap, oriMap)) {
                if ((r - l + 1) < res) {
                    resL = l;
                    resR = r;
                    res = r - l + 1;
                }
                char cc = s.charAt(l);
                tmpMap.put(cc, tmpMap.get(cc) - 1);
                l++;
            }
        }

        if (res == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(resL, resR + 1);
    }

    private boolean judge(Map<Character, Integer> oriMap, Map<Character, Integer> tmpMap) {
        for (Map.Entry<Character, Integer> tmp : tmpMap.entrySet()) {
            if (oriMap.get(tmp.getKey()) == null || oriMap.get(tmp.getKey()) < (tmp.getValue())) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void demo() {
        this.minWindow("ADOBECODEBANC", "ABC");
    }
}
