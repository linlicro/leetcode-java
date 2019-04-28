package me.icro.learn.array.plusone;

import java.util.Arrays;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 *
 * @author Lin
 * @since 2019-04-29 7:18 AM
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (null == digits || 0 == digits.length) return digits;

        int i, ten = 0;
        for (i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            ten = digits[i] / 10;
            if (ten > 0) {
                digits[i] -= 10;
            } else {
                break;
            }
        }

        if (i == -1 && ten == 1) {
            int[] newdigits = new int[digits.length + 1];
            newdigits[0] = 1;
            System.arraycopy(digits, 0, newdigits, 1, digits.length);
            return newdigits;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(new Solution().plusOne(digits)));
        int[] digits1 = new int[]{4, 3, 2, 1};
        System.out.println(Arrays.toString(new Solution().plusOne(digits1)));
        int[] digits2 = new int[]{0};
        System.out.println(Arrays.toString(new Solution().plusOne(digits2)));
        int[] digits3 = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(new Solution().plusOne(digits3)));
    }
}
