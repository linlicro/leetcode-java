package me.icro.problems.t198_rob;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-23 9:59 AM
 */
public class Solution {
    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) return 0;
        if (1 == nums.length) return nums[0];

        int pre_pre_max = nums[0];
        int cur_max = Math.max(pre_pre_max, nums[1]);
        int temp = 0;
        for (int i = 2; i < nums.length; i++) {
            temp = cur_max;
            cur_max = Math.max(cur_max, pre_pre_max + nums[i]);
            pre_pre_max = temp;
        }
        return cur_max;
    }
}
