package me.icro.t7_reverseInteger;

/**
 * Created by Lin on 2019/3/6.
 * <p>
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 */
public class Solution {

    public int reverse(int x) {

        if (x == 0) return 0;

        int zx = 0;
        long result = 0;
        if (x < 0) {
            zx = x * -1;
        } else {
            zx = x;
        }

        while (zx % 10 > 0 || zx > 0) {
            result = result * 10 + zx % 10;
            zx /= 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;

        return x < 0 ? (int) -result : (int) result;
    }

    public int reverse2(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) return 0;

        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        int result = 0;
        while (x > 0) {
            if (result > (Integer.MAX_VALUE / 10)
                    || (result == Integer.MAX_VALUE / 10 && x % 10 > 7))
                return 0;

            result = result * 10 + x % 10;
            x /= 10;
        }
        return sign * result;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse2(123));
        System.out.println(new Solution().reverse2(-123));
        System.out.println(new Solution().reverse2(1534236469));
    }

}
