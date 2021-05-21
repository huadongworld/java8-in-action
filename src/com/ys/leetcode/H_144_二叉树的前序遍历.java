package com.ys.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/5/21 23:02
 */
public class H_144_二叉树的前序遍历 {

    public List<Integer> preorderTraversal(H_94_二叉树的中序遍历.TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inorder(root, res);
    return res;
}

    public void inorder(H_94_二叉树的中序遍历.TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        inorder(root.left, res);
        inorder(root.right, res);
    }
}
