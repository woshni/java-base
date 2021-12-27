package com.yinc.demo.leetcode;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 */
public class KthLargest703 {


    class KthLargest {

        /**
         *  构造一个优先队列
         */
        private PriorityQueue<Integer> q;

        /**
         *  数据流中的第 K 大元素
         */
        private int k;

        public KthLargest(int k, int[] nums) {
            q = new PriorityQueue<Integer>(k);
            this.k = k;
            for (int i : nums) {
                add(i);
            }
        }

        public int add(int val) {
            if (q.size() < k) {
                //当前队列数据还不满足K个值
                q.add(val);
            } else if (q.peek() < val) {
                //当前队列数据满足K个值；且第K个值比新加入的值小
                q.poll();
                q.offer(val);
            }
            return q.peek();
        }
    }
}
