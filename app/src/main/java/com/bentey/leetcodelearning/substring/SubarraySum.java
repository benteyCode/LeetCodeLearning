package com.bentey.leetcodelearning.substring;

import java.util.HashMap;

/**
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * yinyu
 * 2024/5/9
 */
public class SubarraySum {

    /**
     * 暴力法
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * https://leetcode.cn/problems/subarray-sum-equals-k/solutions/562174/de-liao-yi-wen-jiang-qian-zhui-he-an-pai-yhyf/
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> container = new HashMap<>();
        container.put(0, 1);
        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (container.containsKey(sum - k)) {
                count += container.getOrDefault(sum - k, 0);
            }

            container.put(sum, container.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
