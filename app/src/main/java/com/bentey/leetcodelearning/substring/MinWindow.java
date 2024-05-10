package com.bentey.leetcodelearning.substring;

import java.util.HashMap;

/**
 * 最小覆盖子串
 * yinyu
 * 2024/5/10
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
public class MinWindow {

    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int match = 0;

        String result = "";
        int count = Integer.MAX_VALUE;

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            if (needs.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (needs.get(rightChar).compareTo(window.get(rightChar)) == 0) {
                    match++;
                }
            }

            right++;

            while (needs.size() == match) {

                if (right - left < count) {
                    count = right - left;
                    result = s.substring(left, right);
                }

                char leftChar = s.charAt(left);

                if (needs.containsKey(leftChar)) {
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                    if (window.get(leftChar) < needs.get(leftChar)) {
                        match--;
                    }
                }

                left++;
            }
        }

        return result;

    }
}
