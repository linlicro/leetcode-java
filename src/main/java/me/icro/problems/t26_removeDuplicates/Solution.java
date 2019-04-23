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
        if (null == nums || 0 == nums.length)
            return 0;

        int lastInt = nums[nums.length - 1];
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == lastInt) {
                i++;
                break;
            }
            if (nums[i] == nums[i + 1]) {
                int numMoved = nums.length - i - 1;
                System.arraycopy(nums, i + 1, nums, i, numMoved);
                continue;
            }
            i++;
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new Solution().removeDuplicates(nums));
        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Solution().removeDuplicates(nums2));
    }
}
