package me.icro.problems.t63uniquepathswithobstacles;

/**
 * @author lin
 * @version v 0.1 2020/6/28
 **/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || 0 == obstacleGrid.length) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1 == obstacleGrid[m - 1][n - 1] ? 0 : 1;
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1 == obstacleGrid[m - 1][n - 1 - i] ? 0 : dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1 == obstacleGrid[m - 1 - i][n - 1] ? 0 : dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = 1 == obstacleGrid[m - 1 - i][n - 1 - j] ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                new int[]{1, 0}
        };
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));

        int[][] obstacleGrid2 = new int[][]{
                new int[]{1}
        };
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid2));

        int[][] obstacleGrid3 = new int[][]{
                new int[]{1, 0},
                new int[]{0, 0}
        };
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid3));
    }
}
