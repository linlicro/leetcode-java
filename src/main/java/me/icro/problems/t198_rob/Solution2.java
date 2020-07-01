package me.icro.problems.t198_rob;

/**
 * @author lin
 * @version v 0.1 2020/7/1
 **/
public class Solution2 {
    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().rob(new int[]{2, 1, 1, 2}));
    }
}
