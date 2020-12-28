package me.icro.lcof.o42maxsubarray;

/**
 * @author lin
 * @version v 0.1 2020/12/28
 **/
public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[index];
            max = Math.max(max, sum);
        }
        return max;
    }
}
