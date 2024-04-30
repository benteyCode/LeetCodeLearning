package com.bentey.leetcodelearning.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * yinyu
 * 2024/4/30
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {

    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //[-1,-1,0,1,2,4]
        Arrays.sort(nums);

        Set<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 夹逼
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        //[-1,-1,0,1,2,4]
        Arrays.sort(nums);

        Set<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int head = i + 1;
            int tail = nums.length - 1;

            while (head < tail) {

                if (nums[i] + nums[head] + nums[tail] == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[head], nums[tail]);
                    result.add(list);
                }

                if (nums[i] + nums[head] + nums[tail] < 0) {
                    head++;
                } else if (nums[i] + nums[head] + nums[tail] >= 0) {
                    tail--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * hashmap
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        Set<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int target = -nums[i];

            HashMap<Integer, Integer> container = new HashMap();

            for (int j = i + 1; j < nums.length; j++) {

                int v = target - nums[j];
                if (container.containsKey(v)) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], v);
                    result.add(list);
                } else {
                    container.put(nums[j], j);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
