package com.bentey.leetcodelearning.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * yinyu
 * 2024/9/5
 */
public class Day0905 {

    /**
     * 矩阵置零
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] column = new boolean[m];
        boolean[] row = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    column[i] = row[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (column[i] || row[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = m - 1;

        List<Integer> res = new ArrayList<>();

        while (l <= r && t <= b) {

            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            t++;

            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            r--;

            if (t <= b) {
                for (int i = r; i >= l; i--) {
                    res.add(matrix[b][i]);
                }
                b--;
            }

            if (l <= r) {
                for (int i = b; i >= t; i--) {
                    res.add(matrix[i][l]);
                }
                l++;
            }
        }

        return res;
    }
}
