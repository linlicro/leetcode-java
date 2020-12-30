package me.icro.lcof.o47maxvalue;

/**
 * @author lin
 * @version v 0.1 2020/12/30
 **/
public class Solution {
    public int maxValue(int[][] grid) {
        if (0 == grid.length || 0 == grid[0].length) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]) + grid[x - 1][y - 1];
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(new int[][]{
                new int[] {1, 2, 5},
                new int[] {3, 2, 1}
        }));
    }
}
