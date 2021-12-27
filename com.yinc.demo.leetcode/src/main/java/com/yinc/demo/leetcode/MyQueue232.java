package com.yinc.demo.leetcode;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 */
public class MyQueue232 {

    public static void main(String[] args) {
        MyQueue myQueue  = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int peek = myQueue.peek();
        int pop = myQueue.pop();
        System.out.println(peek);
        System.out.println(pop);
        System.out.println(myQueue.empty());
    }

    static class MyQueue {

        private Stack<Integer> push ;
        private Stack<Integer> pop ;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            push = new Stack<>();
            pop = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            push.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if(pop.isEmpty()){
                set();
            }
            return pop.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if(pop.isEmpty()){
                set();
            }
            return pop.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return pop.isEmpty() && push.isEmpty();
        }

        private void  set(){
            while (!push.isEmpty()){
                pop.push(push.pop());
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}


