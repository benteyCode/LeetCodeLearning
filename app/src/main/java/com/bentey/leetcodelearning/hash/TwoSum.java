package com.bentey.leetcodelearning.hash;

import java.util.HashMap;

/**
 * yinyu
 * 2024/4/28
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (container.containsKey(diff)) {
                return new int[]{container.get(diff), i};
            }
            container.put(nums[i], i);
        }
        return new int[]{};
    }
}
