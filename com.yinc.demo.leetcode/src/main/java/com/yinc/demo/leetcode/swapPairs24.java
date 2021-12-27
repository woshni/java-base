package com.yinc.demo.leetcode;

public class swapPairs24 {
    public ListNode swapPairs1(ListNode head) {
        ListNode result = head.next;
        ListNode pre = new ListNode(1000,head);
        while (pre.next != null && pre.next.next!=null) {
            ListNode n1 = pre.next;
            ListNode n2 = n1.next;
            ListNode n3 = n2.next;
            n2.next = n1;
            n1.next = n3;
            pre.next=n2;
            pre = n1;
        }
        return result;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head1 = head;
        ListNode head2 = head.next;
        ListNode next3 = head2.next;
        head2.next = head1;
        head1.next=swapPairs2(next3);
        return head2;
    }
}