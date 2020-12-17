package me.icro.problems.t122_maxProfit;

/**
 * @author lin
 * @version v 0.1 2020/12/17
 **/
public class SolutionDp {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dpI0 = 0;
        int dpI1 = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dpI0 = Math.max(dpI0, dpI1 + prices[i - 1]);
            dpI1 = Math.max(dpI1, dpI0 - prices[i - 1]);
        }
        return dpI0;
    }
}
