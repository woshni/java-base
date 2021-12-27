package com.yinc.demo.test;

import static java.lang.Integer.MAX_VALUE;

public class Test {
    public static void main(String[] args) {
        System.out.println(MAX_VALUE-Integer.MIN_VALUE);
        split("我ABC汉DEFV",6);
        String s = new String("xx1");
        String s1 = "xx1";
        System.out.println(s==s1);

    }

    public static void split(String s, int num) {
        int k = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {

            byte[] bytes = (s.charAt(i) + "").getBytes();
            k = k + bytes.length;
            if (k > num) {
                        break;
            }
            temp=temp+s.charAt(i);

        }
        System.out.println(temp);
    }
}
