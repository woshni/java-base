package com.yinc.demo.leetcode;

import java.util.*;

public class threeSum15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4, 0}));
    }

    /**
     * 超时答案：///
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] == 0)) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }

                int a = nums[i];
                int b = nums[j];
                if (b < a) {
                    continue;
                }
                if (-a - b < b) {
                    continue;
                }
                map.put(a, map.get(a) - 1);
                map.put(b, map.get(b) - 1);
                if (map.getOrDefault(-a - b, 0) > 0) {
                    result.add(Arrays.asList(a, b, -a - b));
                }
                map.put(a, map.get(a) + 1);
                map.put(b, map.get(b) + 1);
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                break;
            }
            if ((i > 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    //去重
                    while (start < end && nums[start] == nums[++start]) ;
                    while (start < end && nums[end] == nums[--end]) ;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return lists;
    }
}
