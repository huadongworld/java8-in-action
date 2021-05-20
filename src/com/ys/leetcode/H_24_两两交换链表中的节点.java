package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/20 14:05
 */
public class H_24_两两交换链表中的节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode post = head.next;
        ListNode nextTemp = head.next.next;
        while (nextTemp != null) {
            nextTemp = head.next.next;
            post = head.next;
            post.next = head;
            head.next = nextTemp;
        }
        return post;
    }
}
