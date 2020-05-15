package me.icro.problems.t283_movezero;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/5/16
 **/
public class Solution {
    public void moveZeroes(int[] nums) {
        // 双指针的遍历
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i] && i != j) {
                nums[j] = nums[i];
                j++;
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
