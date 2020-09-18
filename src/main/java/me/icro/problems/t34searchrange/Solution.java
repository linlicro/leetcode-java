package me.icro.problems.t34searchrange;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/9/18
 **/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int indexLeft = search0(nums, target);
        int indexRight = search1(nums, target);
        return new int[]{indexLeft, indexRight};
    }

    private int search0(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int indexLeft = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                indexLeft = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return indexLeft;
    }

    private int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int indexRight = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                indexRight = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return indexRight;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{}, 8)));
    }
}
