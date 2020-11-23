package me.icro.problems.t209minsubarraylen;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/11/23
 **/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int len = Integer.MAX_VALUE;
        int left = 0, right = 1, tmpS = nums[0];
        while (right < nums.length) {
            if (tmpS < s) {
                tmpS += nums[right];
                right++;
            }

            while (s <= tmpS) {
                len = Math.min(len, right - left);
                tmpS -= nums[left];
                left++;
            }
        }
        return Integer.MAX_VALUE == len ? 0 : len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Solution().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
