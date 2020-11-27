package me.icro.problems.t713numsubarrayproductlessthank;

/**
 * @author lin
 * @version v 0.1 2020/11/27
 **/
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (0 == k) {
            return 0;
        }
        int left = 0, right = 0;
        int count = 0;
        int product = 1;
        while (right < nums.length) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            count += right++ - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
