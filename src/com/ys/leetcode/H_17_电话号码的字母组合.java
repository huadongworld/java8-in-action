package com.ys.leetcode;

import java.util.*;

/**
 * @author HuaDong
 * @date 2021/5/23 15:58
 */
public class H_17_电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> res = new ArrayList<>();
        char[] digitChars = digits.toCharArray();

        dfs(map, digitChars, 0, new ArrayDeque<>(), res);

        return res;
    }

    private void dfs(Map<Character, List<String>> map, char[] digitChars, int begin, Deque<String> tmp, List<String> res) {

        if (begin == digitChars.length) {
            res.add(String.join("", tmp));
            return;
        }

        List<String> words = map.get(digitChars[begin]);
        for (int i = 0; i < words.size(); i++) {
            tmp.addLast(words.get(i));
            dfs(map, digitChars, begin + 1, tmp, res);
            tmp.removeLast();
        }

    }
}
