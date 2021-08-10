package com.ys.剑指_Offer;

import java.util.Stack;

/**
 * @author HuaDong
 * @date 2021/7/22 21:00
 */
public class O_09_用两个栈实现队列 {

    public O_09_用两个栈实现队列() {

    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tmp = new Stack<>();

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        while (!stack.empty()) {
            tmp.push(stack.pop());
        }
        if (tmp.empty()) {
            return -1;
        }
        int result = tmp.pop();
        while (!tmp.empty()) {
            stack.push(tmp.pop());
        }
        return result;
    }
}
