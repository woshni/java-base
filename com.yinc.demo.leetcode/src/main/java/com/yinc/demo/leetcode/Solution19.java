package com.yinc.demo.leetcode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode listNode = new ListNode(1, head);
        ListNode start = listNode;
        ListNode end = listNode;

        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }

        end.next = end.next.next;

        return listNode.next;

    }

    public static void main(String[] args) {
        ListNode next5 = new ListNode(5, null);
        ListNode next4 = new ListNode(4, next5);
        ListNode next3 = new ListNode(3, next4);
        ListNode next2 = new ListNode(2, next3);
        ListNode next1 = new ListNode(1, next2);

        System.out.println(new Solution19().removeNthFromEnd(next1, 2));
    }
}
