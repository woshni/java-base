package com.yinc.demo.leetcode;

public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        ListNode curt = head;
        ListNode pre = null;
        while (curt != null) {
            ListNode next = curt.next;
            curt.next = pre;
            pre = curt;
            curt = next;
        }
        return pre;

    }
}


class ListNode {
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
