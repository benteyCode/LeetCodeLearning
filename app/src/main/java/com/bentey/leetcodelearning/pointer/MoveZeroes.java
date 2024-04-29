package com.bentey.leetcodelearning.pointer;

/**
 * yinyu
 * 2024/4/29
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * [0,1,0,3,12]
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        if (nums == null) {
            return;
        }

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
