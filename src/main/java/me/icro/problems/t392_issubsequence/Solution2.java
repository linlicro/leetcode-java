package me.icro.problems.t392_issubsequence;

/**
 * 双指针 解法
 * @author lin
 * @version v 0.1 2020/3/26
 **/
public class Solution2 {
    public boolean isSubsequence(String s, String t) {
        if (0 == s.length()) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isSubsequence("a", ""));
        System.out.println(new Solution2().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Solution2().isSubsequence("axc", "ahbgdc"));
    }
}
