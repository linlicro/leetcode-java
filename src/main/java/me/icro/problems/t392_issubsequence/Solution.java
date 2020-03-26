package me.icro.problems.t392_issubsequence;

/**
 * @author lin
 * @version v 0.1 2020/3/26
 **/
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (null == s || 0 == s.length()) {
            return true;
        }
        if (null == t || s.length() > t.length()) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.length() - j > t.length() - i) {
                return false;
            }
            if (j == s.length()) {
                return true;
            }
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }
        return j == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence(null, ""));
        System.out.println(new Solution().isSubsequence("a", null));
        System.out.println(new Solution().isSubsequence("a", ""));
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("axc", "ahbgdc"));
    }
}
