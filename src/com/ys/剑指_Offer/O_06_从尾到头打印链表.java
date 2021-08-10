package com.ys.剑指_Offer;

/**
 * @author HuaDong
 * @date 2021/8/10 15:19
 */
public class O_06_从尾到头打印链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        int[] a = new int[10001];
        int i = 0;
        while (head != null) {
            a[i++] = head.val;
            head = head.next;
        }

        int len = i;
        int[] b = new int[len];
        while (i-- > 0) {
            b[len - i - 1] = a[i];
        }

        return b;
    }
}
