package me.icro.t9_palindrome_number;

/**
 * 描述:
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 *
 * @author Lin
 * @since 2019-04-02 4:02 PM
 */
public class Solution {
    public boolean isPalindrome(int x) { // convert the number into string, and check if the string is a palindrome
        if (x < 0) return false;
        if (x < 10) return true;
        String numString = String.valueOf(x);
        for (int i = 0; i < numString.length() / 2; i++) {
            if (numString.charAt(numString.length() - i - 1) != numString.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}
