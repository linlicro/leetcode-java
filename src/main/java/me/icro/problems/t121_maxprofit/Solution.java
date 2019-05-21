package me.icro.problems.t121_maxprofit;

/**
 * 描述: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Lin
 * @since 2019-05-21 10:07 AM
 */
public class Solution {
    public int maxProfit(int[] prices) {

        if (null == prices || prices.length < 2) return 0;

        int[] diffs = new int[prices.length];
        diffs[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            diffs[i] = prices[i] - prices[i - 1];
        }

        int temp = 0;
        int max = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (temp + diffs[i] > 0) {
                temp += diffs[i];
            } else {
                temp = 0;
            }
            max = Math.max(temp, max);
        }

        return max;
    }
}
