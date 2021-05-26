package com.ys.leetcode;

import java.util.*;

/**
 * @author HuaDong
 * @date 2021/5/26 21:03
 */
public class H_515_在每个树行中找最大值 {

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

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        while (!queue.isEmpty()) {
            QueueNode node = queue.poll();
            if (node.node.left != null) {
                queue.offer(new QueueNode(node.node.left, node.depth + 1));
            }
            if (node.node.right != null) {
                queue.offer(new QueueNode(node.node.right, node.depth + 1));
            }
            List<Integer> tmp = map.get(node.depth);
            if (tmp == null) {
                tmp = new ArrayList<>();
                tmp.add(node.node.val);
                map.put(node.depth, tmp);
            } else {
                tmp.add(node.node.val);
                map.put(node.depth, tmp);
            }
        }
        List<Integer> res = new ArrayList<>();
        int i = 1;
        while (map.get(i) != null) {
            int max = Integer.MIN_VALUE;
            List<Integer> tmp = map.get(i++);
            for (int j = 0; j < tmp.size(); j++) {
                max = Math.max(max, tmp.get(j));
            }

            res.add(max);
        }

        return res;
    }
}
