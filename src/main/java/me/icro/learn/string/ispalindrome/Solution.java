package me.icro.learn.string.ispalindrome;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/36/
 *
 * @author Lin
 * @since 2019-05-04 7:29 AM
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (null == s) return false;

        s = s.toLowerCase();
        int left_index = 0;
        int right_index = s.length() - 1;
        while (left_index < right_index) {
            while (!(s.charAt(left_index) - 'a' >= 0 && s.charAt(left_index) - 'z' <= 0)
                    && !(s.charAt(left_index) - 'A' >= 0 && s.charAt(left_index) - 'Z' <= 0)
                    && !(s.charAt(left_index) - '0' >= 0 && s.charAt(left_index) - '9' <= 0)
                    && left_index < right_index) {
                left_index++;
            }
            while (!(s.charAt(right_index) - 'a' >= 0 && s.charAt(right_index) - 'z' <= 0)
                    && !(s.charAt(right_index) - 'A' >= 0 && s.charAt(right_index) - 'Z' <= 0)
                    && !(s.charAt(right_index) - '0' >= 0 && s.charAt(right_index) - '9' <= 0)
                    && right_index > left_index) {
                right_index--;
            }
            if (left_index >= right_index) break;
            if (s.charAt(left_index) != s.charAt(right_index))
                return false;
            left_index++;
            right_index--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
        System.out.println(new Solution().isPalindrome("A 1 man, a plan, a canal: Panam1 a"));
        System.out.println(new Solution().isPalindrome(":;"));
    }
}
