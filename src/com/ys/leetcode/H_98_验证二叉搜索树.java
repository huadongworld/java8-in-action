package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/22 13:39
 */
public class H_98_验证二叉搜索树 {

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

    double last = -Double.MAX_VALUE;

    /**
     * 进行中序遍历从左子树开始比较，last每次记录最小值
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftIsNull = isValidBST(root.left);

        if (leftIsNull) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

    /**
     * 方法2
     *
     * 判断当前的三个值即可，是当前值要大于所有左子树的所有值，小于右子树的所有值
     * 非常巧妙的思路是，用上界下界来替代，往左，上界缩小，往右，下界扩大
     *
     * @param node
     * @param min
     * @param max
     * @return
     */
    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
