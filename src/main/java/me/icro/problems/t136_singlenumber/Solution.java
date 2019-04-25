package me.icro.problems.t136_singlenumber;

import java.util.Arrays;

/**
 * 描述:
 *  https://leetcode.com/problems/single-number/
 *
 * @author Lin
 * @since 2019-04-26 7:40 AM
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
}
