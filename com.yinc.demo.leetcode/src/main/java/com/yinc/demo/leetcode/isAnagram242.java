package com.yinc.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 */
public class isAnagram242 {

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println(isAnagram2("agree", "regeas"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer orDefault = map.getOrDefault(c, 0);
            map.put(c, orDefault + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer integer = map.get(c);
            if (integer == null) {
                return false;
            }
            if (integer == 1) {
                map.remove(c);
            } else {
                map.put(c, integer - 1);
            }
        }
        return map.isEmpty();
    }

    public static boolean isAnagram2(String s, String t) {

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int[] sMap = new int[26];
        int[] tMap = new int[26];
        if(sArray.length!=tArray.length){
            return false;
        }
        for (int i = 0; i < sArray.length; i++) {
            sMap[sArray[i] - 'a'] ++;
            tMap[tArray[i] - 'a'] ++;
        }

        for (int i = 0; i < 26; i++) {
            if (sMap[i] != tMap[i]) {
                return false;
            }
        }
        return true;
    }
}
