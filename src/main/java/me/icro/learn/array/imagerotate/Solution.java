package me.icro.learn.array.imagerotate;

import java.util.Arrays;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/31/
 * <p>
 * 思路:
 * step1. 先将矩阵按列两两对换（reverse一下列的顺序）
 * step2. 再按照右对角线对称，把元素交换即可。
 *
 * @author Lin
 * @since 2019-04-30 10:39 PM
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

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                new int[] {1,2,3},
                new int[] {4,5,6},
                new int[] {7,8,9},
        };
        new Solution().rotate(matrix);
        for (int i = 0; i< matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println();

        int[][] matrix1 = new int[][] {
                new int[] {5, 1, 9,11},
                new int[] {2, 4, 8,10},
                new int[] {13, 3, 6, 7},
                new int[] {15,14,12,16},
        };
        new Solution().rotate(matrix1);
        for (int i = 0; i< matrix1.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }
    }

}
