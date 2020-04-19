package me.icro.leetcodingchallenge2004.search;

/**
 * @author lin
 * @version v 0.1 2020/4/19
 **/
public class Solution {
    public int search(int[] nums, int target) {
        int min = 0, max = nums.length - 1, mid = 0;
        while(min <= max){
            mid = (min + max) / 2;
            if(nums[mid] == target){
                return mid;
            }
            // 如果左半部分是有序的
            if(nums[min] <= nums[mid]){
                if(nums[min] <= target && target < nums[mid]){
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
                // 如果右半部份是有序的
            } else {
                if(nums[mid] < target && target <= nums[max]){
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
        }
        // 不满足min <= max条件时，返回-1
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(new Solution().search(new int[]{5, 1, 2, 3, 4}, 1));
    }
}
