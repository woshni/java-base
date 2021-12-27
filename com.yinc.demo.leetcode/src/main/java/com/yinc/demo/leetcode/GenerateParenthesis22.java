package com.yinc.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {

    public static void main(String[] args) {
        GenerateParenthesis22 gen = new GenerateParenthesis22();
        System.out.println(gen.generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen("", result, n, n);
        return result;
    }

    public void gen(String sublist, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sublist);
            return;
        }
        if (left > 0) {
            gen(sublist + "(", result, left - 1, right);
        }
        if (right > 0) {
            gen(sublist + ")", result, left, right - 1);
        }
    }
}
