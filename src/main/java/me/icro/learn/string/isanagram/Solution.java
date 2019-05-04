package me.icro.learn.string.isanagram;

import java.util.Arrays;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/35/
 *
 * @author Lin
 * @since 2019-05-04 7:14 AM
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (null == s || null == t) return false;
        if (s.length() != t.length()) return false;
        char[] s_char_array = s.toCharArray();
        char[] t_char_array = t.toCharArray();
        Arrays.sort(s_char_array);
        Arrays.sort(t_char_array);
        for (int i = 0; i < t_char_array.length; i++) {
            if (s_char_array[i] != t_char_array[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new Solution().isAnagram(s, t));

        String s1 = "rat";
        String t1 = "cat";
        System.out.println(new Solution().isAnagram(s1, t1));
    }
}
