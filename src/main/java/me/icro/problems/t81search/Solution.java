package me.icro.problems.t81search;

/**
 * @author lin
 * @version v 0.1 2020/9/21
 **/
public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, len = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            if (nums[mid] == nums[right]) {
                right--;
                continue;
            }
            if (nums[mid] < nums[right]) {
                // 右边是递增的
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 左边递增的
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(new Solution().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(new Solution().search(new int[]{2, 5, 6, 0, 0, 1}, 0));
        System.out.println(new Solution().search(new int[]{2, 5, 6, 0, 0, 1}, 2));
        System.out.println(new Solution().search(new int[]{2, 5, 6, 0, 0, 1}, 7));
        System.out.println(new Solution().search(new int[]{3, 1, 1}, 3));
        System.out.println(new Solution().search(new int[]{1, 1, 3, 1}, 3));
    }
}
