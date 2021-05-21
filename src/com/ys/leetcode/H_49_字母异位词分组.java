package com.ys.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author HuaDong
 * @date 2021/5/21 22:13
 */
public class H_49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] schars = s.toCharArray();
            Arrays.sort(schars);
            String sortS = String.valueOf(schars);
            List<String> stringList = map.get(sortS);
            if (stringList != null) {
                stringList.add(s);
                map.put(sortS, stringList);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortS, list);
            }
        }

        List<List<String>> lists = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }

        return lists;
    }

    @Test
    public void demo() {
        this.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
