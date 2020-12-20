package me.icro.lcof.o14icuttingrope;

/**
 * @author lin
 * @version v 0.1 2020/12/20
 **/
public class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }
}
