package me.icro.problems.t121_maxprofit;

/**
 * @author lin
 * @version v 0.1 2020/7/4
 **/
public class Solution2 {
    public int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }

        int max = 0;
        int theLowPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int curProfit = theLowPrice > prices[i] ? 0 : prices[i] - theLowPrice;
            theLowPrice = Math.min(theLowPrice, prices[i]);
            max = Math.max(max, curProfit);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
