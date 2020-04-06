package me.icro.leetcodingchallenge2004.maxprofit;

/**
 * @author lin
 * @version v 0.1 2020/4/5
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (1 >= prices.length) {
            return max;
        }
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (0 < diff) {
                max += diff;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
