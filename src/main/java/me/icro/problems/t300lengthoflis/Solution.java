package me.icro.problems.t300lengthoflis;

/**
 * @author lin
 * @version v 0.1 2020/8/26
 **/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (0 == nums.length) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    tmp = Math.max(dp[j], tmp);
                }
            }
            dp[i] = tmp + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new Solution().lengthOfLIS(new int[]{10}));
        System.out.println(new Solution().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
//        [1,3,6,7,9,4,10,5,6]
    }
}
