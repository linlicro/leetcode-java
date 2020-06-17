package me.icro.problems.t74searchmatrix;

/**
 * @author lin
 * @version v 0.1 2020/6/17
 **/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (0 == matrix.length || 0 == matrix[0].length) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int targetX = targetX(matrix, target, m, n);
        int targetY = -1 == targetX ? -1 : targetY(matrix, target, targetX, m, n);
        return -1 != targetX && -1 != targetY;
    }

    private int targetY(int[][] matrix, int target, int x, int m, int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[x][mid] == target) {
                return mid;
            }
            if (matrix[x][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int targetX(int[][] matrix, int target, int m, int n) {
        int left = 0;
        int right = m - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                return mid;
            }
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
