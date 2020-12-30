package me.icro.lcof.o49nthuglynumber;

/**
 * @author lin
 * @version v 0.1 2020/12/30
 **/
public class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n1 = dp[a] * 2;
            int n2 = dp[b] * 3;
            int n3 = dp[c] * 5;
            dp[i] = Math.min(n1, Math.min(n2, n3));
            if (n1 == dp[i]) {
                a++;
            }
            if (n2 == dp[i]) {
                b++;
            }
            if (n3 == dp[i]) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
