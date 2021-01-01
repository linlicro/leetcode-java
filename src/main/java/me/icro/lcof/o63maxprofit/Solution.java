package me.icro.lcof.o63maxprofit;

/**
 * @author lin
 * @version v 0.1 2021/1/1
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i - 1]);
            dp1 = Math.max(dp1, -prices[i - 1]);
        }
        return dp0;
    }
}
