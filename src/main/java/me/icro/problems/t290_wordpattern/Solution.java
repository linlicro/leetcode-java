package me.icro.problems.t290_wordpattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lin
 * @version v 0.1 2020/5/29
 **/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (null == pattern || null == str) {
            return false;
        }
        Map<String, Character> map = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();
        String[] strings = str.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(strings[i]) && !map.get(strings[i]).equals(c)) {
                return false;
            } else if (map2.containsKey(c) && !map2.get(c).equals(strings[i])) {
                return false;
            } else {
                map.put(strings[i], c);
                map2.put(c, strings[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
        System.out.println(new Solution().wordPattern("aaaa", "dog cat cat dog"));
    }
}
