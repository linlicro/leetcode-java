package me.icro.lcof.o21exchange;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/12/21
 **/
public class Solution {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) == 1) {
                left++;
                continue;
            }
            if ((nums[right] & 1) == 0) {
                right--;
                continue;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().exchange(new int[]{1, 2, 3, 4})));
    }
}
