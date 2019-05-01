package me.icro.problems.t48_rotate;

/**
 * 描述:
 *  https://leetcode.com/problems/rotate-image/
 *
 * @author Lin
 * @since 2019-05-01 1:26 PM
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (null == matrix || 1 >= matrix.length) return;

        int n = matrix.length;
        // step 1
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }

        // step 2
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
    }

    public void reverse(int[] line) {
        int begin = 0, end = line.length - 1;
        while (begin < end) {
            int temp = line[begin];
            line[begin++] = line[end];
            line[end--] = temp;
        }
    }
}
