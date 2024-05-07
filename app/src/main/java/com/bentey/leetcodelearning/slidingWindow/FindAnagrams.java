package com.bentey.leetcodelearning.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * yinyu
 * 2024/5/7
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s == null || p == null) {
            return result;
        }

        int left = 0;
        int right = p.length() - 1;

        while (right < s.length()) {
            String substring = s.substring(left, right + 1);
            char[] array = substring.toCharArray();
            char[] array1 = p.toCharArray();
            Arrays.sort(array);
            Arrays.sort(array1);

            if (areArraysEqual(array, array1)) {
                result.add(left);
            }
            left++;
            right++;

        }

        return result;

    }

    public static boolean areArraysEqual(char[] arr1, char[] arr2) {
        // Step 1: Check if lengths are equal
        if (arr1.length != arr2.length) {
            return false;
        }

        // Step 2: Compare elements
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false; // If any element is not equal, return false
            }
        }

        return true; // If all elements are equal, return true
    }

    public List<Integer> findAnagrams1(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s == null || p == null) {
            return result;
        }

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

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
                if (need.get(rightChar).compareTo(window.get(rightChar)) == 0) {
                    match++;
                }
            }

            right++;

            while (match == need.size()) {

                if (right - left == p.length()) {
                    result.add(left);
                }


                char leftChar = s.charAt(left);

                if (need.containsKey(leftChar)) {
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                    if (window.get(leftChar) < need.get(leftChar)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return result;
    }
}
