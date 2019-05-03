package me.icro.learn.string.firstuniqchar;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
 *
 * @author Lin
 * @since 2019-05-03 11:32 AM
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

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("leetcode"));
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
    }
}
