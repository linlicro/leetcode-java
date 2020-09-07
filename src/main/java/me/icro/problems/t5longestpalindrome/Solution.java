package me.icro.problems.t5longestpalindrome;

/**
 * @author lin
 * @version v 0.1 2020/9/7
 **/
public class Solution {
    public String longestPalindrome(String s) {
        if (null == s) {
            return null;
        }
        if (0 == s.length()) {
            return s;
        }
        int start = 0, length = 1;
        char[] arr = s.toCharArray();
        for (int index = 0; index < arr.length; index++) {
            int i = index, j = index;
            while (i >= 0 && j < arr.length) {
                if (arr[i] != arr[j]) {
                    break;
                }
                i--;
                j++;
            }
            int subLen = j - i - 1;
            if (subLen > length) {
                start = i + 1;
                length = subLen;
            }

            i = index;
            j = index + 1;
            while (i >= 0 && j < arr.length) {
                if (arr[i] != arr[j]) {
                    break;
                }
                i--;
                j++;
            }
            subLen = j - i - 1;
            if (subLen > length) {
                start = i + 1;
                length = subLen;
            }
        }
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome(""));
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}
