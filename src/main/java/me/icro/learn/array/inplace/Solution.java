package me.icro.learn.array.inplace;

/**
 * 描述:
 * 从排序数组中删除重复项
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 * 解题思路: [原地算法](https://en.wikipedia.org/wiki/In-place_algorithm)
 *
 * problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author Lin
 * @since 2019-04-22 11:53 AM
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
