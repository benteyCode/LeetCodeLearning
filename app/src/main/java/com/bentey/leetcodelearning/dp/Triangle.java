package com.bentey.leetcodelearning.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * yinyu
 * 2024/8/12
 */
public class Triangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        int[][] dp = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            dp[i][0] = 1;
            row.add(dp[i][0]);
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                row.add(dp[i][j]);
            }
            res.add(row);
        }

        return res;

    }
}
