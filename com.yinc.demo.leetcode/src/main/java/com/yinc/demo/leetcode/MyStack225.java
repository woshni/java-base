package com.yinc.demo.leetcode;

import java.util.*;

/**
 * 225. 用队列实现栈
 */
public class MyStack225 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2

        System.out.println(  myStack.top()); // 返回 2);
        System.out.println(myStack.pop()); // 返回 2
        System.out.println( myStack.empty()); // 返回 False

    }

   static class MyStack {

        private Queue<Integer> queueIn;

        private Queue<Integer> queueOut;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queueIn =new LinkedList<>();
            queueOut =new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            // 每次Push 时，保证输入的queue为空。
            //每次push一次触发一次迁移；
            /**
             * 例如：   push(1)        in =[]    out = [1]
             *         push(2)        in =[]    out = [2,1]
             *         push(3)        in =[]    out = [3,2,1]
             */

            queueIn.offer(x);
            while (!queueOut.isEmpty()){
                queueIn.offer(queueOut.poll());
            }
            Queue<Integer> temp = this.queueIn;
            queueIn = queueOut;
            queueOut = temp;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queueOut.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {

           return queueOut.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
        return queueIn.isEmpty() && queueOut.isEmpty();
        }
    }
}
