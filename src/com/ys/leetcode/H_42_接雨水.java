package com.ys.leetcode;

import java.util.Stack;

/**
 * @author HuaDong
 * @date 2021/5/21 19:16
 */
public class H_42_接雨水 {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
