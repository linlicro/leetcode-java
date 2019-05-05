package me.icro.learn.string.myatoi;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-04 11:32 PM
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

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("9223372036854775808"));
        System.out.println(new Solution().myAtoi("   -45"));
        System.out.println(new Solution().myAtoi("-91283472332"));
        System.out.println(new Solution().myAtoi("-"));
        System.out.println(new Solution().myAtoi(""));
        System.out.println(new Solution().myAtoi("0-1"));
        System.out.println(new Solution().myAtoi("-1-0"));
        System.out.println(new Solution().myAtoi("-000000000000001"));
        System.out.println(new Solution().myAtoi("  0000000000012345678"));
    }

}
