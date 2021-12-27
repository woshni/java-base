package com.yinc.demo.leetcode;

public class Solution50 {
    public static void main(String[] args) {
        System.out.println((-3)/2);
        System.out.println(myPow(100000,
                -2147483648));
    }

    public static double myPow(double x, long n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            return 1/myPow(x,-n);
        }
        if(n%2!=0){
            return x*myPow(x,n-1);
        }
        return myPow(x*x,n/2);
    }
}
