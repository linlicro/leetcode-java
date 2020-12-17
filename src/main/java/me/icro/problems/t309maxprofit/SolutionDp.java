package me.icro.problems.t309maxprofit;

/**
 * @author lin
 * @version v 0.1 2020/12/17
 **/
public class SolutionDp {
    public int maxProfit(int[] prices) {
        if (1 >= prices.length) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
        }
        return dp[n][0];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dpI0 = 0;
        int dpI1 = Integer.MIN_VALUE;
        int dpPre0 = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = dpI0;
            dpI0 = Math.max(dpI0, dpI1 + prices[i - 1]);
            dpI1 = Math.max(dpI1, dpPre0 - prices[i - 1]);
            dpPre0 = tmp;
        }
        return dpI0;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionDp().maxProfit2(new int[]{2}));
        System.out.println(new SolutionDp().maxProfit2(new int[]{1, 2, 3, 0, 2}));
    }
}
