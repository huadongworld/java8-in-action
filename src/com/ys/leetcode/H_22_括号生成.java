package com.ys.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/5/22 0:07
 */
public class H_22_括号生成 {
    public List<String> generateParenthesis(int n) {
        build("", n, n);
        return result;
    }

    List<String> result = new ArrayList<>();
    private void build(String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (right > 0) {
            build(str + ")", left, right - 1);
        }
        if (left > 0) {
            build(str + "(", left - 1, right);
        }
    }
}
