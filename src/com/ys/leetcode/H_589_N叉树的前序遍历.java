package com.ys.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/5/21 23:04
 */
public class H_589_N叉树的前序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        if (root.children == null || root.children.size() == 0) {
            return Arrays.asList(root.val);
        }

        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        values.add(root.val);
        return values;
    }

    private void inorder(Node root, List<Integer> values) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            inorder(node, values);
            values.add(node.val);
        }
    }
}
