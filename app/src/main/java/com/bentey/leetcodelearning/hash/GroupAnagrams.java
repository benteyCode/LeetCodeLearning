package com.bentey.leetcodelearning.hash;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * yinyu
 * 2024/4/28
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class GroupAnagrams {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, ArrayList<String>> container = new HashMap<>();

        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            ArrayList<String> list = container.getOrDefault(key, new ArrayList<>());
            list.add(str);
            container.put(key, list);
        }
        return new ArrayList<>(container.values());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, ArrayList<String>> container = new HashMap<>();

        for (String str : strs) {

            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            ArrayList<String> list = container.getOrDefault(key, new ArrayList<>());
            list.add(str);
            container.put(key, list);
        }
        return new ArrayList<>(container.values());
    }
}
