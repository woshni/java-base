package com.yinc.demo.leetcode;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode n1 = head;
        ListNode n2 = head.next;
        while (n1 != n2) {
            if (n2 == null || n2.next == null) {
                return false;
            }
            n2 = n2.next.next;
            n1 = n1.next;

        }
        return true;
    }

    public static void main(String[] args) {
        ListNode next = new ListNode(3, null);
        ListNode listNode = new ListNode(1, new ListNode(2, next));
        next.next = listNode;
        System.out.println(new Solution141().hasCycle(listNode));
    }
}
