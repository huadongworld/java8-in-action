package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/20 14:56
 */
public class H_142_环形链表II {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 快慢指针
     * <p>
     * 有意思有意思
     *
     * @param head
     * @return
     */
    public ListNode hasCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // 想想为什么？可以知道的是，从头一步一步开始走的指针一定会和相遇点开始一步一步走的指针在环上相遇（这个仔细想想），
        // 而相遇点一定是环起始点，这个可以做假设，因为都是一步一步走的，如果开始没相遇的话，永远也遇不上了
        if (hasCycle) {
            ListNode copy = head;
            while (slow != copy) {
                copy = copy.next;
                slow = slow.next;
            }
            return slow;
        }

        return null;
    }
}
