package me.icro.problems.t322coinchange;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2021/1/10
 **/
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return amount + 1 == dp[amount] ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{2}, 3));
    }
}
