package com.ys.剑指_Offer;

import java.util.HashMap;

/**
 * @author HuaDong
 * @date 2021/7/22 20:26
 */
public class O_07_重建二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        // root 值要在前序遍历上找
        // left right 表示 root 分割中序遍历数组前的最左索引和最右索引
        return recur(0, 0, inorder.length - 1, preorder);
    }

    TreeNode recur(int root, int left, int right, int[] preorder) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int i = dic.get(preorder[root]);
        // root + 1：表示左子树根节点所在索引位置，left：中序遍历数组上左边界索引，left：中序遍历数组上右边界索引
        node.left = recur(root + 1, left, i - 1, preorder);
        // root + i - left + 1：表示右子树根节点所在索引位置，left：中序遍历数组上左边界索引，left：中序遍历数组上右边界索引
        node.right = recur(root + i - left + 1, i + 1, right, preorder);
        return node;
    }
}
