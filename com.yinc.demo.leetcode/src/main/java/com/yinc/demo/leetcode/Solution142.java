package com.yinc.demo.leetcode;

public class Solution142 {

    /**
     * 数学推导公式解法， 当快慢指针相遇时， 快慢指针距离
     * 假设: 入环前长度为a, 环长为b
     * 快指针：fast =>f 慢指针：slow=>s
     * 当 快慢相遇时 此刻双方走的距离是： f: 2s,   or  f: s+nb(n为未知数)   f走过的距离为S走的距离+n个环长b， n随具体链表动态变化，最快1圈追上。
     * 则： f=2s; f=s+nb, 得到： s = nb,   f走的总距离为两倍的nb, s走了一倍的nb。
     * <p>
     * 从头节点开始走，走到入环节点为a+b  为 a+1b; s= nb, 假设 n=1 ,则  (a+b)-(1b) = a ,则s在需要走a步到达入环节点。
     * a未知， 定义为：入环前长度
     * 那么此时 设置一个变量A,赋值为head节点， 与s节点一同挪动， 当两个节点相遇时就为 ====》入环节点！！！！！！！！！
     *
     * @param head
     * @return
     */
    public ListNode hasCycle(ListNode head) {
        //快慢指针，  hashset也可以  返回第一个入环的节点
        ListNode n1 = head;
        ListNode n2 = head;
        while (true) {
            if (n2 == null || n2.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
            if (n1 == n2) {
                break;
            }
        }
        //通过数学推导公式获得
        //找到相交点后，开始推算 相交点距离第一个入环点的位置
        while (head != n1) {
            head = head.next;
            n1 = n1.next;
        }
        return head;
    }


    /**
     * 代码推算法获取
     *
     * @param head
     * @return
     */
    public ListNode hasCycle2(ListNode head) {
        //快慢指针，  hashset也可以  返回第一个入环的节点
        ListNode n1 = head;
        ListNode n2 = head;
        while (true) {
            if (n2 == null || n2.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
            if (n1 == n2) {
                break;
            }
        }
        //此时n1,n2节点已经相遇， 循环跑任意一个节点，计算循环次数多久再次到达本节点，计算环的周长。
        int count = 0;
        while (n1.next != n2) {
            n1 = n1.next;
            count++;
        }

        //得到环的周长，
        //此时 可以换算成计算， 链表的倒数第N个节点， 因为成环，环的周长确定，则环的最后一个节点就是入环点。
        n1 = head;
        n2 = head;
        while (count-- != 0) {
            n2 = n2.next;
        }

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;


    }

    public static void main(String[] args) {
        ListNode next4 = new ListNode(4, null);
        ListNode next3 = new ListNode(3, next4);
        ListNode next2 = new ListNode(2, next3);
        ListNode next1 = new ListNode(1, next2);
        next4.next = next2;

        System.out.println(new Solution142().hasCycle2(next1));
    }
}
