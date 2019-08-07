package com.bentey.leetcodelearning.sort;

/**
 * @author : bentey
 * @date : 2019-08-07
 */
public class SortTest {

    private static int[] arr = {18, 5, 6, 2, 4, 77, 22};

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] sort = bubbleSort.sort(arr);
        for (int element : sort) {
            System.out.println(element);
        }
    }
}
