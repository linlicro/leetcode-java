package me.icro.learn.array.singlenumber;

import java.util.Arrays;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 *
 * @author Lin
 * @since 2019-04-26 7:27 AM
 */
public class Solution {
    public int singleNumber(int[] nums) {
        if (null == nums) return -1;
        if (0 == nums.length) return -1;
        if (1 == nums.length) return nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1])
                return nums[i];
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        System.out.println(new Solution().singleNumber(nums));
        int[] nums2 = new int[]{4, 1, 2, 1, 2};
        System.out.println(new Solution().singleNumber(nums2));
    }
}
