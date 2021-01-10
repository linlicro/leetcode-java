package me.icro.lintcode.t92backpack;

/**
 * @author lin
 * @version v 0.1 2021/1/10
 **/
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 不选这件物品
                dp[i][j] = dp[i - 1][j];
                if (A[i - 1] <= j) {
                    // 选择这件物品
                    dp[i][j] = Math.max(dp[i - 1][j - A[i - 1]] + A[i - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
