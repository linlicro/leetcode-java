package me.icro.problems.t154findmin;

/**
 * @author lin
 * @version v 0.1 2020/9/22
 **/
public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == left && mid == right) {
                // 仅有1个元素
                return nums[mid];
            }
            if (mid == left || mid == right) {
                // 2个元素
                return Math.min(nums[left], nums[right]);
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
                // 右边递增
                right = mid;
            } else {
                // 左边递增
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{2, 5, 6, 0, 0, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{2, 5, 6, 0, 0, 1}));
        System.out.println(new Solution().findMin(new int[]{3, 1, 1}));
        System.out.println(new Solution().findMin(new int[]{1, 3, 1, 1}));
    }
}
