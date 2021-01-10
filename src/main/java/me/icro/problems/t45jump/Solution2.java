package me.icro.problems.t45jump;

/**
 *
 * 动规超时
 *
 * @author lin
 * @version v 0.1 2021/1/10
 **/
public class Solution2 {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[len - 1];
    }
}
