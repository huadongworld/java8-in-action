package com.ys.leetcode;

import java.util.*;

/**
 * @author HuaDong
 * @date 2021/5/21 23:04
 */
public class H_590_N叉树的后序遍历 {
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

    public List<List<Integer>> postorder(Node root) {
        preOrder(root, 1);
        return lists;
    }

    private List<List<Integer>> lists = new ArrayList<>();

    private void preOrder(Node root, int level) {
        if (root == null) {
            return;
        }
        if (lists.size() < level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        for (Node child : root.children) {
            preOrder(child, level + 1);
        }
    }
}
