package me.icro.problems.t35searchinsert;

/**
 * @author lin
 * @version v 0.1 2020/9/17
 **/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (0 == nums.length) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : (nums[left] > target ? left : left + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[]{1}, 1));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6, 7}, 5));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6, 7}, 2));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6, 7}, 9));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6, 7}, 0));
    }
}
