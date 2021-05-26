package com.ys.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author HuaDong
 * @date 2021/5/26 19:46
 */
public class H_102_二叉树的层序遍历 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class QueueNode {
        public TreeNode node;
        public int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        while (!queue.isEmpty()) {
            QueueNode node = queue.poll();
            if (node.node.left != null) {
                queue.offer(new QueueNode(node.node.left, node.depth + 1));
            }
            if (node.node.right != null) {
                queue.offer(new QueueNode(node.node.right, node.depth + 1));
            }
            List list = map.get(node.depth);
            if (list == null) {
                list = new ArrayList();
                list.add(node.node.val);
                map.put(node.depth, list);
            } else {
                list.add(node.node.val);
                map.put(node.depth, list);
            }
        }
        int i = 1;
        while (map.get(i) != null) {
            res.add(map.get(i++));
        }

        return res;
    }
}
