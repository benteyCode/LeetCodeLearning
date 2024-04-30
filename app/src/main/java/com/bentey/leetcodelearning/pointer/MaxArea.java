package com.bentey.leetcodelearning.pointer;

/**
 * yinyu
 * 2024/4/29
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class MaxArea {

    /**
     * 超出时间限制
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {

                int area = Math.min(height[i], height[j]) * (j - i);

                maxArea = Math.max(maxArea, area);

            }
        }

        return maxArea;

    }

    /**
     * 这道题就像相亲一样，越早遇见对的人越好。当我遇到的人都比我自己差的时候，我还是不满足，所以把差的抛弃了，
     * 直到遇到一个比自己更好的，那这个人一定就是我所能遇到最好的了。因为自此之后遇到再好的人，
     * 他所超过我的部分对我来说也没有价值，我自己还是那个短板。自此之后遇到同样的人，也没有和他的时间一样多，而且还可能遇到更差的人。
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {

        int maxArea = 0;

        int i = 0;
        int j = height.length - 1;

        while (i != j) {

            int area = Math.min(height[i], height[j]) * (j - i);

            maxArea = Math.max(maxArea, area);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;

    }
}
