package me.icro.topinterviewquesitons2018.beforeyoustart.searchmatrix;

/**
 * 描述: https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/261/before-you-start/1108/
 * <p>
 * 解题思路: 由于每行和每列都是升序，但是行与行之间元素可能存在重叠。
 * 考虑从右上角开始遍历，如果target比它大，则删除当前行，如果target比它小，则删除当前列。
 *
 * @author Lin
 * @since 2019-05-26 1:35 PM
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix) return false;

        int m = matrix.length;
        if (0 == m) return false;
        int n = matrix[0].length;
        int y = 0;
        int x = n - 1;
        while (y < m && x >= 0) {
            if (matrix[y][x] == target) return true;
            if (matrix[y][x] > target)
                x--;
            else
                y++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
        };
        System.out.println(new Solution().searchMatrix(matrix, 5));
        System.out.println(new Solution().searchMatrix(matrix, 20));


        int[][] matrix1 = new int[][]{
                new int[0]
        };
        System.out.println(new Solution().searchMatrix(matrix1, 5));

        int[][] matrix2 = new int[][]{
        };
        System.out.println(new Solution().searchMatrix(matrix2, 5));

    }
}
