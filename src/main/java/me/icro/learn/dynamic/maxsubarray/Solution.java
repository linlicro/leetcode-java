package me.icro.learn.dynamic.maxsubarray;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/56/
 * <p>
 * 解题思路: 求和，然后判断和是否小于0，因为只要前面的和小于0，
 * 那么后面的数加上前面的和就一定比自身小，所以又重新求和，并和之前的最大子序和比较，取最大值。
 *
 * @author Lin
 * @since 2019-05-22 9:29 AM
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

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
