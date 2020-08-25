package me.icro.problems.t746mincostclimbingstairs;

/**
 *
 * 1. 先付出最小总花费dp[i-1]到达第i级台阶（即第i-1级台阶的阶梯顶部），踏上第i级台阶需要再花费cost[i]，再迈一步到达第i级台阶的阶梯顶部，最小总花费为dp[i-1] + cost[i])；
 * 2. 先付出最小总花费dp[i-2]到达第i-1级台阶（即第i-2级台阶的阶梯顶部），踏上第i-1级台阶需要再花费cost[i-1]，再迈两步跨过第i级台阶直接到达第i级台阶的阶梯顶部，最小总花费为dp[i-2] + cost[i-1])
 *
 * @author lin
 * @version v 0.1 2020/8/25
 **/
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 1], dp[i - 1] + cost[i]);
        }
        return dp[cost.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCostClimbingStairs(new int[] { 10, 15, 30 }));
    }
}
