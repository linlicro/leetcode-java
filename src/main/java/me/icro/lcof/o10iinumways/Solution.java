package me.icro.lcof.o10iinumways;

/**
 * @author lin
 * @version v 0.1 2020/12/19
 **/
public class Solution {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if (dp[i] > 1000000007) {
                dp[i] %= 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(0));
        System.out.println(new Solution().numWays(2));
        System.out.println(new Solution().numWays(7));
        System.out.println(new Solution().numWays(45));
    }
}
