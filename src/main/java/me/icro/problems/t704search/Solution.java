package me.icro.problems.t704search;

/**
 * @author lin
 * @version v 0.1 2020/9/18
 **/
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 9, 12}, 9));
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
