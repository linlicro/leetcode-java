package me.icro.problems.t217_containsduplicate;

import java.util.Arrays;

/**
 * 描述:
 *  https://leetcode.com/problems/contains-duplicate/
 *
 * @author Lin
 * @since 2019-04-26 7:24 AM
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
}
