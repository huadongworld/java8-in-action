package com.ys.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author HuaDong
 * @date 2021/5/21 14:42
 */
public class H_84_柱状图中的最大矩形 {

    /**
     * 暴力美学
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int max = -1;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int left = getLeft(heights, i);
            int right = getRight(heights, i);
            int newHeight = (right - left) * height;
            max = max > newHeight ? max : newHeight;
        }
        return max;
    }

    private int getRight(int[] heights, int i) {
        if (i == heights.length - 1) {
            return i;
        }
        for (int j = i + 1; j < heights.length; j++) {
            if (heights[j] < heights[i]) {
                return j - 1;
            }
        }
        return heights.length - 1;
    }

    private int getLeft(int[] heights, int i) {
        if (i == 0) {
            return -1;
        }
        for (int j = i - 1; j >= 0; j--) {
            if (heights[j] < heights[i]) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 栈
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int top = stack.pop();
                max = Math.max(max, heights[top] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        if (stack.peek() != -1) {
            int topIndex = stack.peek();
            while (stack.peek() != -1) {
                int top = stack.pop();
                max = Math.max(max, heights[top] * (topIndex - stack.peek()));
            }
        }

        return max;
    }

    @Test
    public void demo() {
        largestRectangleArea3(new int[]{2, 1, 5, 6, 2, 3});
    }

}
