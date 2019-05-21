package me.icro.learn.dynamic.maxprofit;

/**
 * 描述: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/55/
 * <p>
 * 解题思路:
 * <p>
 * * 股票的收益意义 在于想要更多利益则值低时买进，值高时卖出。
 * * 根据股票的当天价格,不方便看出股票价格的波动, so 先计算list: list[i] - list[i-1] = 股票的变化
 * * 然后, 使用最大连续子数组和的解法思路, 求最大子数组和
 *
 * @author Lin
 * @since 2019-05-21 9:24 AM
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

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
