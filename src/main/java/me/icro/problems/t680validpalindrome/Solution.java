package me.icro.problems.t680validpalindrome;

/**
 * @author lin
 * @version v 0.1 2020/9/4
 **/
public class Solution {
    public boolean validPalindrome(String s) {
        if (null == s) {
            return false;
        }
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        return isPalindrome(arr, left, right, 0);
    }

    private boolean isPalindrome(char[] arr, int left, int right, int level) {
        if (left >= right) {
            return true;
        }
        if (arr[left] == arr[right]) {
            return isPalindrome(arr, left + 1, right - 1, level);
        } else {
            if (1 == level) {
                return false;
            }
            return isPalindrome(arr, left + 1, right, level + 1) || isPalindrome(arr, left, right - 1, level + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome(""));
        System.out.println(new Solution().validPalindrome("aba"));
        System.out.println(new Solution().validPalindrome("abca"));
        System.out.println(new Solution().validPalindrome("abfca")); // false
        System.out.println(new Solution().validPalindrome("abc")); // false
        System.out.println(new Solution().validPalindrome("abfdca"));
    }
}
