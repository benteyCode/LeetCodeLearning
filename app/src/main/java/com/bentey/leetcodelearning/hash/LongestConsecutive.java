package com.bentey.leetcodelearning.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * yinyu
 * 2024/4/28
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {

        Set<Integer> container = new HashSet<>();

        for (int num : nums) {
            container.add(num);
        }

        int longestStreak = 0;

        for (int num : container) {

            if (!container.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (container.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
