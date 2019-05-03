package me.icro.problems.t387_firstuniqchar;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *  https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * @author Lin
 * @since 2019-05-03 11:44 AM
 */
public class Solution {
    public int firstUniqChar(String s) {
        if (null == s || 0 == s.length()) return -1;

        Map<Character, Integer> char_count_map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (char_count_map.containsKey(s.charAt(i))) {
                char_count_map.replace(s.charAt(i), char_count_map.get(s.charAt(i)) + 1);
            } else {
                char_count_map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (1 == char_count_map.get(s.charAt(i)))
                return i;
        }

        return -1;
    }
}
