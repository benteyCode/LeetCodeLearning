package com.bentey.leetcodelearning.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * yinyu
 * 2024/8/29
 */
public class Day0829 {

    //滑动窗口的最大值
    //双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i - deque.getFirst() == k) {
                deque.removeFirst();
            }

            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }

        return res;
    }

    //优先队列
    public int[] maxSlidingWindow1(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < nums.length; i++) {

            priorityQueue.add(new int[]{nums[i], i});

            while (priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }

            if (i - k + 1 >= 0) {
                res[i - k + 1] = priorityQueue.peek()[0];
            }

        }

        return res;
    }

    //最小覆盖子串
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int match = 0;
        int leastLen = Integer.MAX_VALUE;
        String res = "";

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

                if (window.get(rightChar) - need.get(rightChar) == 0) {
                    match++;
                }
            }

            right++;

            while (match == need.size()) {

                if (right - left < leastLen) {
                    leastLen = right - left;
                    res = s.substring(left, right);
                }

                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                    if (window.get(leftChar) - need.get(leftChar) < 0) {
                        match--;
                    }
                }
                left++;
            }
        }

        return res;
    }

    //最大子数组的和
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = nums[0];

        int sum = 0;

        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }

    //合并区间
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            int left = intervals[i][0];
            int right = intervals[i][1];

            if (i == 0 || left > result.get(result.size() - 1)[1]) {
                result.add(intervals[i]);
            } else {
                int[] last = result.get(result.size() - 1);
                if (right > last[1]) {
                    last[1] = right;
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    //轮转数组
    public void rotate(int[] nums, int k) {

    }
}
