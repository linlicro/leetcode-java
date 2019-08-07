package me.icro.topinterviewquesitons2018.array.maxproduct;

/**
 * 描述: https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/264/array/1126/
 *
 * 思路: 每有一个新的数字加入，最大值要么是当前最大值*新数，要么是当前最小值（负数）*新数（负数），要么是当前值。
 *
 * @author Lin
 * @since 2019-08-07 11:31 AM
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (null == nums || 0 == nums.length)
            return Integer.MIN_VALUE;

        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Solution().maxProduct(new int[]{-2,0,-1}));
    }
}
