package me.icro.problems.t242_isanagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * https://leetcode.com/problems/valid-anagram/
 *
 * @author Lin
 * @since 2019-05-04 7:19 AM
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (null == s || null == t) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Integer value : map.values()) {
            if (0 != value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }
}
