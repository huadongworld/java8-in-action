package com.ys.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HuaDong
 * @date 2021/5/22 15:01
 */
public class H_111_二叉树的最小深度 {

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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calDepth(root, 1);
        return depth;
    }

    private void calDepth(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level >= depth) {
            return;
        }

        if (root.left == null && root.right == null) {
            depth = Math.min(depth, level);
            return;
        }

        calDepth(root.right, level + 1);
        calDepth(root.left, level + 1);
    }

    private int depth = Integer.MAX_VALUE;


    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }


}
