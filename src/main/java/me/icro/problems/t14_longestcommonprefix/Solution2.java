package me.icro.problems.t14_longestcommonprefix;

/**
 * 描述:
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * @author Lin
 * @since 2019-04-01 11:49 PM
 */
public class Solution2 { // Horizontal scanning
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) return "";
        String prefix = strs[0];
        for (int i=1;i<strs.length;i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) return "";
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(new Solution2().longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
        System.out.println(new Solution2().longestCommonPrefix(new String[] {"dog", ""}));
        System.out.println(new Solution2().longestCommonPrefix(new String[] {"aa", "a"}));
    }
}
