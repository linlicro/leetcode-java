package me.icro.problems.t53_maxprofit;

/**
 * 描述: https://leetcode.com/problems/maximum-subarray/
 *
 * @author Lin
 * @since 2019-05-22 9:49 AM
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length <= 0) return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if (sum < 0) sum = 0;
            sum += nums[index];
            max = Math.max(max, sum);
        }
        return max;
    }
}
