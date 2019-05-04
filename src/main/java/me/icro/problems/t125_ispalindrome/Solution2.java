package me.icro.problems.t125_ispalindrome;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-04 8:08 AM
 */
public class Solution2 {
    public boolean isPalindrome(String s) {
        if (null == s) return false;
        s = s.toLowerCase();
        s = s.replaceAll("[^0-9a-z]", "");

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution2().isPalindrome("race a car"));
        System.out.println(new Solution2().isPalindrome("A 1 man, a plan, a canal: Panam1 a"));
        System.out.println(new Solution2().isPalindrome(":;"));
    }
}
