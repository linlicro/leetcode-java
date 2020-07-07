package me.icro.problems.t64minpathsum;

/**
 * @author lin
 * @version v 0.1 2020/7/7
 **/
public class Solution {
    public int minPathSum(int[][] grid) {
        if (null == grid || 0 == grid.length) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cur = grid[i - 1][j - 1];
                if (1 == i) {
                    dp[i][j] = dp[i][j - 1] + cur;
                } else if (1 == j) {
                    dp[i][j] = dp[i - 1][j] + cur;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + cur;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grip = new int[][] {
                new int[] {1, 3, 1},
                new int[] {1, 5, 1},
                new int[] {4, 2, 1},
        };
        System.out.println(new Solution().minPathSum(grip));
    }
}
