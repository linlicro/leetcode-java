package me.icro.problems.t153findmin;

/**
 * @author lin
 * @version v 0.1 2020/6/17
 **/
public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == left && mid == right) {
                // 仅有1个元素
                return nums[mid];
            }
            if (mid == left || mid == right) {
                // 2个元素
                return Math.min(nums[left], nums[right]);
            }
            if (nums[mid] <= nums[mid + 1] && nums[mid] <= nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] < nums[right]) {
                // 右边是递增的
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{1,2}));
        System.out.println(new Solution().findMin(new int[]{4}));
    }
}
