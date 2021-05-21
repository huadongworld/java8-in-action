package com.ys.leetcode;

import java.util.Stack;

/**
 * @author HuaDong
 * @date 2021/5/21 14:32
 */
public class H_155_最小栈 {
    class MinStack {

        private Stack<Integer> stack;

        public MinStack() {
            stack = new Stack<Integer>();
        }

        public void push(int val) {
            if (stack.empty()) {
                stack.push(val);
                stack.push(val);
            } else {
                int temp = stack.peek();
                stack.push(val);
                if (temp < val) {
                    stack.push(temp);
                } else {
                    stack.push(val);
                }
            }
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            return stack.get(stack.size() - 2);
        }

        public int getMin() {
            return stack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
