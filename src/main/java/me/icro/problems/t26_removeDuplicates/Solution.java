package me.icro.problems.t26_removeDuplicates;

/**
 * 描述:
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author Lin
 * @since 2019-04-23 6:23 AM
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new Solution().removeDuplicates(nums));
        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Solution().removeDuplicates(nums2));
    }
}
