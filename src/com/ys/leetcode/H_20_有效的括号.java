package com.ys.leetcode;

import java.util.Stack;

/**
 * @author HuaDong
 * @date 2021/5/21 13:52
 */
public class H_20_有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(')');
            } else if (chars[i] == '[') {
                stack.push(']');
            } else if (chars[i] == '{') {
                stack.push('}');
            } else if (stack.empty() || stack.pop() != chars[i]) {
                return false;
            }
        }
        return stack.empty();
    }
}
