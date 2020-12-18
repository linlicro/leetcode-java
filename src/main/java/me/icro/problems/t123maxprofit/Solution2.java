package me.icro.problems.t123maxprofit;

/**
 * @author lin
 * @version v 0.1 2020/12/17
 **/
public class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxK = 2;
        int[][][] dp = new int[n + 1][maxK + 1][2];
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][2][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][2][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= maxK; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][2][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));

        System.out.println(new Solution2().maxProfit(new int[]{1, 2, 3, 4, 5}));

        System.out.println(new Solution2().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
