package me.icro.problems.t33search;

/**
 * @author lin
 * @version v 0.1 2020/6/17
 **/
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
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
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(new Solution().search(new int[]{}, 3));
    }
}
