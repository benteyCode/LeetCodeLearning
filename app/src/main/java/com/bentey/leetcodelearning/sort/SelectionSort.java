package com.bentey.leetcodelearning.sort;

import java.util.Arrays;

/**
 * @author : bentey
 * @date : 2019-08-08
 * @desc : 选择排序
 */
public class SelectionSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 总共需要经过N-1轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮经过N-i次比较
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
        return arr;
    }
}
