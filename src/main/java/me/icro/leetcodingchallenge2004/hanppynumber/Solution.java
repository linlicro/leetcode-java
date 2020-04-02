package me.icro.leetcodingchallenge2004.hanppynumber;

/**
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3284/
 *
 * @author lin
 * @version v 0.1 2020/4/2
 **/
public class Solution {
    public boolean isHappy(int n) {
        if (10 > n) {
            return 1 == n || 7 == n;
        }
        int sum = 0;
        while (0 != n) {
            int theFirstDigit = n % 10;
            n /= 10;
            sum += theFirstDigit * theFirstDigit;
        }
        return isHappy(sum);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
        System.out.println(new Solution().isHappy(2));
        System.out.println(new Solution().isHappy(0));
        System.out.println(new Solution().isHappy(7));
        System.out.println(new Solution().isHappy(Integer.MAX_VALUE));
    }
}
