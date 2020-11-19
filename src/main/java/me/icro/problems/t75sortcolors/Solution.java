package me.icro.problems.t75sortcolors;

/**
 * @author lin
 * @version v 0.1 2020/11/19
 **/
public class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = 0;

        // s1. pick red
        while (right < nums.length) {
            if (0 == nums[right]) {
                nums[right] = nums[left];
                nums[left] = 0;
                left++;
            }
            right++;
        }

        // s2. pick white
        right = left;
        while (right < nums.length) {
            if (1 == nums[right]) {
                nums[right] = nums[left];
                nums[left] = 1;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        new Solution().sortColors(new int[]{0, 1});
        new Solution().sortColors(new int[]{1, 2, 1});
    }
}
