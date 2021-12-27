package com.yinc.demo.concurrent.chm;

import java.util.concurrent.ConcurrentHashMap;

public class CHM {
    public static void main(String[] args) {
        System.out.println("1 << 15 : "+(1 << 15));
        System.out.println("max  : "+Integer.MAX_VALUE);
        System.out.println(27 | (1 << 15));
        System.out.println((1 << 30) >>> 1);
        ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<>();

        for (int i = 0; i < 20; i++) {
            hashMap.put(""+i,""+i);
        }
    }

}
