package com.ys.leetcode;

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

}
