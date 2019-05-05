package me.icro.problems.t8_myatoi;

/**
 * 描述:
 *  https://leetcode.com/problems/string-to-integer-atoi/
 *
 * @author Lin
 * @since 2019-05-05 1:09 AM
 */
public class Solution {
    public int myAtoi(String str) {
        if (null == str) return 0;

        // remove blank string
        str = str.trim();

        if ( 0 == str.length()) return 0;

        int start_index = 0;

        boolean flag = true;
        if ('-' == str.charAt(start_index)) {
            flag = false;
            start_index++;
        } else if ('+' == str.charAt(start_index)) {
            flag = true;
            start_index++;
        }

        double res = 0;
        for (; start_index < str.length(); start_index++) {
            if (str.charAt(start_index) >= '0' && str.charAt(start_index) <= '9') {
                res = res * 10 + (str.charAt(start_index) - '0');
            } else {
                break;
            }
        }

        if (!flag) res = -res;

        if (res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }
}
