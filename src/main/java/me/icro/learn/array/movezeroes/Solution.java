package me.icro.learn.array.movezeroes;

import java.util.Arrays;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/
 *
 * @author Lin
 * @since 2019-04-29 10:06 AM
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (null == nums || 0 == nums.length) return;

        int zero_nums = 0;
        for (int i = 0; i < nums.length - zero_nums; ) {
            if (0 == nums[i]) {
                // move zero from i to length-1
                System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
                if (0 == zero_nums)
                    nums[nums.length - 1] = 0;
                zero_nums++;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 0, 1};
        new Solution().moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[]{0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = new int[]{0, 0, 0, 0, 1, 2, 0, 0};
        new Solution().moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = new int[]{0, 0, 0, 0, 0, 12};
        new Solution().moveZeroes(nums4);
        System.out.println(Arrays.toString(nums4));

    }
}
