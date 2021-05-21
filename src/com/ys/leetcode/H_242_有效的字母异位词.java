package com.ys.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HuaDong
 * @date 2021/5/21 21:27
 */
public class H_242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < schars.length; i++) {
            if (smap.get(schars[i]) != null) {
                smap.put(schars[i], smap.get(schars[i]) + 1);
            } else {
                smap.put(schars[i], 1);
            }
        }

        for (int i = 0; i < tchars.length; i++) {
            if (tmap.get(tchars[i]) != null) {
                tmap.put(tchars[i], tmap.get(tchars[i]) + 1);
            } else {
                tmap.put(tchars[i], 1);
            }
        }

        for (int i = 0; i < schars.length; i++) {
            if (tmap.get(schars[i]) == null || !tmap.get(schars[i]).equals(smap.get(schars[i]))) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void demo() {
        isAnagram("anagram", "nagaram");
    }
}
