package me.icro.problems.t189_rotate;

/**
 * 描述:
 *  https://leetcode.com/problems/rotate-array/
 *
 * @author Lin
 * @since 2019-04-24 7:09 AM
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if (null == nums || 0 == nums.length) return;
        if (k <= 0) return;
        k %= nums.length;
        for (int i = 0; i < k && i < nums.length - 1; i++) {
            int numMoved = nums.length - 1;
            int lastOne = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, numMoved);
            nums[0] = lastOne;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);
        System.out.println(nums);
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums2, 10);
        int[] nums3 = new int[]{1};
        new Solution().rotate(nums3, 10);
    }
}
