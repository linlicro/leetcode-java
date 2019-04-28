package me.icro.problems.t66_plusone;

/**
 * 描述:
 *  https://leetcode.com/problems/plus-one/
 *
 * @author Lin
 * @since 2019-04-29 7:31 AM
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
}
