package me.icro.lcof.o39majorityelement;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/12/28
 **/
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}
