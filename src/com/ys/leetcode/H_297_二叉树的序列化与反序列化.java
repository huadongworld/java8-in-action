package com.ys.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/5/22 15:10
 */
public class H_297_二叉树的序列化与反序列化 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root)  {
        StringBuilder res = traverse(root, new StringBuilder());
        return res.toString();
    }

    /**
     * 层序遍历/先序遍历/前序遍历
     *
     * @param root
     * @param str
     * @return
     */
    public StringBuilder traverse(TreeNode root, StringBuilder str){
        if(null == root){
            str.append("null,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        str = traverse(root.left, str);
        str = traverse(root.right, str);
        return str;
    }

    public TreeNode deserialize(String data) {
        String[] strWord = data.split(",");
        List<String> listWord = new LinkedList<>(Arrays.asList(strWord));
        return deTraverse(listWord);
    }

    public TreeNode deTraverse(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode res = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        res.left = deTraverse(list);
        res.right = deTraverse(list);

        return res;
    }
}
