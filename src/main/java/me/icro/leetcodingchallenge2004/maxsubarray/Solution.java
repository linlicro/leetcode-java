package me.icro.leetcodingchallenge2004.maxsubarray;

/**
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3285/
 *
 * @author lin
 * @version v 0.1 2020/4/3
 **/
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int maxSumTemp = nums[i];
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                maxSumTemp += nums[i1];
                maxSum = Math.max(maxSum, maxSumTemp);
                if (nums[i1] > maxSum) {
                    maxSum = nums[i1];
                    maxSumTemp = nums[i1];
                }
            }
        }
        return maxSum;
    }

    public int maxSubArrayGreedy(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray(new int[]{8, -19, 5, -4, 20}));

        System.out.println(new Solution().maxSubArrayGreedy(new int[]{8, -19, 5, -4, 20}));
    }
}
