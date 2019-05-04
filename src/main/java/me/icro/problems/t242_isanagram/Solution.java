package me.icro.problems.t242_isanagram;

import java.util.Arrays;

/**
 * 描述:
 *  https://leetcode.com/problems/valid-anagram/
 *
 * @author Lin
 * @since 2019-05-04 7:19 AM
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (null == s || null == t) return false;
        if (s.length() != t.length()) return false;
        char[] s_char_array = s.toCharArray();
        char[] t_char_array = t.toCharArray();
        Arrays.sort(s_char_array);
        Arrays.sort(t_char_array);
        return Arrays.equals(s_char_array, t_char_array);
    }
}
