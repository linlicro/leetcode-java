package me.icro.problems.t213;

/**
 * @author lin
 * @version v 0.1 2020/7/1
 **/
public class Solution {
    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (nums.length <= 2) {
            return 1 == nums.length ? nums[0] : Math.max(nums[0], nums[1]);
        }
        return Math.max(subRob(nums, 1, nums.length), subRob(nums, 0, nums.length - 1));
    }

    int subRob(int[] nums, int start, int end) {
        int[][] dp = new int[end - start][2];
        dp[0][0] = 0;
        dp[0][1] = nums[start];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[start + i];
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2, 3, 2}));
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution().rob(new int[]{1, 2}));
        System.out.println(new Solution().rob(new int[]{2}));
    }
}
