package me.icro.lcof.o60dicesprobability;

/**
 * @author lin
 * @version v 0.1 2021/1/1
 **/
public class Solution {
    public double[] dicesProbability(int n) {
        double[] ans = new double[5 * n + 1];
        int dp[][] = new int[n + 1][6 * n + 1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int s = i; s <= 6 * i; s++) {
                for (int j = 1; j <= 6; j++) {
                    if (s - j < i - 1) {
                        break;
                    }
                    dp[i][s] += dp[i - 1][s - j];
                }
            }
        }

        double total = Math.pow(6, n);
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / total;
        }

        return ans;
    }
}
