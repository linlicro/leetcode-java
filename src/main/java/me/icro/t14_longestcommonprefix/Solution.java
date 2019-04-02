package me.icro.t14_longestcommonprefix;

/**
 * 描述:
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * @author Lin
 * @since 2019-04-01 10:59 PM
 */
public class Solution { // Vertical scanning
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) return "";

        for (int f_index = 0; f_index < strs[0].length(); f_index ++) {
            char c = strs[0].charAt(f_index);
            for (int i = 1; i < strs.length; i++) {
                if (f_index >= strs[i].length() || c != strs[i].charAt(f_index))
                    return strs[0].substring(0, f_index);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(new Solution().longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
        System.out.println(new Solution().longestCommonPrefix(new String[] {"dog", ""}));
        System.out.println(new Solution().longestCommonPrefix(new String[] {"aa", "a"}));
    }
}
