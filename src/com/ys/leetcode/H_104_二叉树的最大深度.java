package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/22 14:48
 */
public class H_104_二叉树的最大深度 {
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

        if (root.left == null && root.right == null) {
            depth = Math.max(depth, level);
            return;
        }

        calDepth(root.right, level + 1);
        calDepth(root.left, level + 1);
    }

    private int depth = 0;

    @Test
    public void demo() {
        this.maxDepth(new TreeNode(0));
    }
}
