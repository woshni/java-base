package com.yinc.demo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class IsValid20 {

    public static void main(String[] args) {
        System.out.println(isValid("[]"));
    }


    public static boolean isValid(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Character value = map.getOrDefault(c, null);
            if (value != null) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!value.equals(stack.pop())) {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }

    /**
     * 解法 1 ---  栈
     *
     * @param s
     * @return
     */
    public static boolean isvalid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            Character start = s.charAt(i);
            Character end = map.get(start);
            if (end == null) {
                stack.push(start);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!end.equals(pop)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 解法 2 ---
     *
     * @param s
     * @return
     */
    public static boolean isvalid2(String s) {
        int length;
        do {
            length = s.length();
            s = s.replace("{}", "").replace("()", "").replace("[]", "");
        } while (length != s.length());
        return s.length() == 0;
    }
}
