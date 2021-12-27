package com.yinc.demo.leetcode;

public class ReverseList25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //返回值
        ListNode result = null;

        //结束节点
        ListNode end = null;

        ListNode locadl = head;
        while (true) {
            //区域开始节点
            ListNode startq = null;
            //区域结束节点
            ListNode endq;
            //判断是否可以进行区域转换
            boolean flag = isFlag(locadl, k);
            if (flag) {
                //第一段
                ListNode preN = null;
                ListNode curtN = locadl;
                endq = curtN;
                //区域循环计算
                int count = 0;
                while (curtN != null) {
                    //区域反转
                    ListNode next = curtN.next;
                    curtN.next = preN;
                    preN = curtN;
                    curtN = next;
                    count++;
                    //区域结束,重新开始
                    if (count == k) {
                        startq = preN;
                        endq.next = curtN;
                        locadl = curtN;
                        break;
                    }
                }
                //归总
                if (end == null) {
                    end = endq;
                } else {
                    end.next = startq;
                    end = endq;
                }
                if (result == null) {
                    result = startq;
                }

            } else {
                return result;
            }
        }


    }

    public static boolean isFlag(ListNode head, int k) {
        //区域循环计算
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
            if (count == k) {
                return true;
            }
        }
        return false;
    }


    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }


    public static void main(String[] args) {
        ListNode next5 = new ListNode(4, null);
        ListNode next4 = new ListNode(4, next5);
        ListNode next3 = new ListNode(3, next4);
        ListNode next2 = new ListNode(2, next3);
        ListNode next1 = new ListNode(1, next2);
        System.out.println(new ReverseList25().reverseKGroup(next1, 2));
    }
}


