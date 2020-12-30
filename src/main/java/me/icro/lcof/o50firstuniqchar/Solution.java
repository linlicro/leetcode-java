package me.icro.lcof.o50firstuniqchar;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/12/30
 **/
public class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, !map.containsKey(ch));
        }
        for (char ch : s.toCharArray()) {
            if (map.get(ch)) {
                return ch;
            }
        }
        return ' ';
    }
}
