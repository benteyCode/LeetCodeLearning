package com.bentey.leetcodelearning.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * yinyu
 * 2024/8/28
 */
public class Day0828 {

    //盛水最多的容器
    public int maxArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {

                int current = height[left];
                while (left < right && height[left] <= current) {
                    left++;
                }
            } else {

                int current = height[right];
                while (left < right && height[right] <= current) {
                    right--;
                }
            }
        }

        return maxArea;
    }

    //无重复字符最长子串
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        HashMap<Character, Integer> need = new HashMap<>();

        int left = 0;
        int right = 0;
        int longestSubStringLength = 0;

        while (right < s.length()) {

            char rightChar = s.charAt(right);

            need.put(rightChar, need.getOrDefault(rightChar, 0) + 1);

            right++;

            while (need.get(rightChar) > 1) {

                char leftChar = s.charAt(left);

                need.put(leftChar, need.getOrDefault(leftChar, 0) - 1);

                left++;
            }

            longestSubStringLength = Math.max(longestSubStringLength, right - left);

        }

        return longestSubStringLength;

    }

    //找到字符串中所有字母异位词
    //输入: s = "cbaebabacd", p = "abc"
    //输出: [0,6]
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int match = 0;

        while (right < s.length()) {

            char rightChar = s.charAt(right);

            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

                if (window.get(rightChar) - need.get(rightChar) == 0) {
                    match++;
                }
            }

            right++;

            while (match == need.size()) {

                if (right - left == p.length()) {
                    res.add(left);
                }

                char leftChar = s.charAt(left);

                if (need.containsKey(leftChar)) {
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);

                    if (window.get(leftChar) - need.get(leftChar) < 0) {
                        match--;
                    }
                }

                left++;

            }
        }

        return res;
    }

    //和为 K 的子数组
    //输入：nums = [1,1,1], k = 2
    //输出：2
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> container = new HashMap<>();

        container.put(0, 1);

        int sum = 0;

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (container.containsKey(sum - k)) {
                count += container.get(sum - k);
            }

            sum = sum + nums[i];

            container.put(sum, container.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
