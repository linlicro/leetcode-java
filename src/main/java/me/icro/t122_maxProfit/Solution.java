package me.icro.t122_maxProfit;

/**
 * 描述:
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author Lin
 * @since 2019-04-23 6:40 AM
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length)
            return 0;
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+ 1] - prices[i] > 0) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}
