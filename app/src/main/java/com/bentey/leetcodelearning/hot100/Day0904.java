package com.bentey.leetcodelearning.hot100;

import java.util.Arrays;
import java.util.HashSet;

/**
 * yinyu
 * 2024/9/2
 */
public class Day0904 {

    //除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;

        int[] preArray = new int[len];

        int[] res = new int[len];

        int product = 1;

        for (int i = 0; i < len; i++) {
            preArray[i] = product;
            product *= nums[i];
        }

        product = 1;

        for (int i = len - 1; i >= 0; i--) {
            res[i] = preArray[i] * product;
            product *= nums[i];
        }

        return res;
    }

    //缺失的第一个正数
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int temp = 1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num <= 0) {
                continue;
            }

            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }

            if (num == temp) {
                temp++;
            } else {
                return temp;
            }
        }

        return temp;
    }

    public int firstMissingPositive1(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return len + 1;
    }

    public int firstMissingPositive2(int[] nums) {

        int len = nums.length;

        HashSet<Integer> container = new HashSet<>();

        for (int num : nums) {
            container.add(num);
        }

        for (int i = 1; i <= len; i++) {
            if (!container.contains(i)) {
                return i;
            }
        }

        return len + 1;
    }

}
