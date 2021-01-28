package me.icro.problems.t787findcheapestprice;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2021/1/29
 **/
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // dp[i][k]表示经过k个中转站后到达站i的最低费用
        int[][] dp = new int[n][K + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i <= K + 1; i++) {
            dp[src][i] = 0;
        }
        for (int k = 1; k <= K + 1; k++) {
            for (int[] flight : flights) {
                int start = flight[0];
                int end = flight[1];
                int price = flight[2];
                if (Integer.MAX_VALUE != dp[start][k - 1]) {
                    dp[end][k] = Math.min(dp[end][k], dp[start][k - 1] + price);
                }
            }
        }

        return dp[dst][K + 1] == Integer.MAX_VALUE ? -1 : dp[dst][K + 1];
    }
}
