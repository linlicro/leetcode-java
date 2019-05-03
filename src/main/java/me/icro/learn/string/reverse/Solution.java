package me.icro.learn.string.reverse;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/
 *
 * @author Lin
 * @since 2019-05-03 11:18 AM
 */
public class Solution {
    public int reverse(int x) {
        if (0 == x) return x;

        int x2 = 0;
        long result = 0;
        if (x < 0) {
            x2 = -x;
        } else {
            x2 = x;
        }

        while (x2 > 0) {
            result = result * 10 + x2 % 10;
            x2 /= 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;

        return x < 0 ? (int) -result : (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));
    }
}
