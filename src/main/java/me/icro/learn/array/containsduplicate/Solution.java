package me.icro.learn.array.containsduplicate;

import java.util.Arrays;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 *
 * @author Lin
 * @since 2019-04-26 7:12 AM
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (null == nums
                || 1 >= nums.length) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = null;
        System.out.println(new Solution().containsDuplicate(nums));
        int[] nums1 = new int[] {1,2,3,1};
        System.out.println(new Solution().containsDuplicate(nums1));
        int[] nums2 = new int[] {1,2,3,4};
        System.out.println(new Solution().containsDuplicate(nums2));
    }
}
