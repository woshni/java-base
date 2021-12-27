package com.yinc.demo.leetcode;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {

        String next = new Scanner(System.in).next();
        String[] split = next.split(",");

        int[] ints = new int[split.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.valueOf(split[i]);

        }

        int[] res = maxSlidingWindow(ints, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+",");

        }
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;

        }
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && deque.getFirst()<= i-k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);

            //K次后每次循环放入头元素
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return result;
    }

}

