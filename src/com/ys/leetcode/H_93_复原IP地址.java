package com.ys.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/5/23 11:24
 */
public class H_93_复原IP地址 {
    public List<String> restoreIpAddresses(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();

        dfs(chars, 0, 0, new ArrayDeque<>(), res);

        return res;
    }

    private void dfs(char[] chars, int splitTimes, int begin, ArrayDeque<String> tmp, List<String> res) {

        if (chars.length - begin > (4 - splitTimes) * 3 || chars.length - begin < (4 - splitTimes)) {
            return;
        }

        if (splitTimes == 4) {
            res.add(String.join(".", tmp));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= chars.length) {
                break;
            }

            // 判断单个一段是否合法
            int num = validate(Arrays.copyOfRange(chars, begin, begin + i + 1));

            if (num != -1) {
                tmp.addLast(num + "");
                dfs(chars, splitTimes + 1, begin + i + 1, tmp, res);
                tmp.removeLast();
            }
        }

    }

    private int validate(char[] chars) {
        if (chars.length > 1 && (chars[0] - 48) == 0) {
            return -1;
        }

        if (chars.length == 1) {
            return chars[0] - 48;
        }

        if (chars.length == 2) {
            return (chars[0] - 48) * 10 + (chars[1] - 48);
        }

        if (chars.length == 3) {
            int tmp = (chars[0] - 48) * 100 + (chars[1] - 48) * 10 + (chars[2] - 48);
            if (tmp > 255) {
                return -1;
            }
            return tmp;
        }

        return -1;
    }

    @Test
    public void demo() {
        this.restoreIpAddresses("25525511135");
    }
}
