package me.icro.learn.array.maxProfit;

/**
 * 描述:
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 *
 * @author Lin
 * @since 2019-04-23 6:26 AM
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

    public static void main(String[] args) {
        int[] nullPrice = null;
        System.out.println(new Solution().maxProfit(nullPrice));

        int[] prices1 = new int[] {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices1));

        int[] prices2 = new int[] {1,2,3,4,5};
        System.out.println(new Solution().maxProfit(prices2));

        int[] prices3 = new int[] {7,6,4,3,1};
        System.out.println(new Solution().maxProfit(prices3));
    }
}
