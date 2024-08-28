package com.bentey.leetcodelearning.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * yinyu
 * 2024/8/27
 */
public class Day0827 {

    //两数之和
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        HashMap<Integer, Integer> container = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (container.containsKey(target - nums[i])) {
                return new int[]{i, container.get(target - nums[i])};
            } else {
                container.put(nums[i], i);
            }
        }

        return new int[0];
    }

    //字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> container = new HashMap<>();

        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if (container.containsKey(key)) {
                List<String> strings = container.get(key);
                strings.add(str);
                container.put(key, strings);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                container.put(key, strings);
            }
        }

        return new ArrayList<>(container.values());
    }

    //最长连续序列
    public int longestConsecutive(int[] nums) {

        Set<Integer> container = new HashSet<>();

        for (int num : nums) {
            container.add(num);
        }

        int longestConsecutive = 0;

        for (int num : container) {

            if (!container.contains(num - 1)) {

                int currentNum = num;
                int currentConsecutive = 1;

                while (container.contains(currentNum + 1)) {
                    currentNum++;
                    currentConsecutive++;
                }

                longestConsecutive = Math.max(longestConsecutive, currentConsecutive);
            }
        }
        return longestConsecutive;
    }

    //移动零
    public void moveZeroes(int[] nums) {

        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
    }

    //三数之和
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> container = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    container.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                }
            }
        }

        return new ArrayList<>(container);
    }
}
