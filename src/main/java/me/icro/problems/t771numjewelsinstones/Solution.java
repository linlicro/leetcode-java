package me.icro.problems.t771numjewelsinstones;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/9/1
 **/
public class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        if (null == J || null == S) {
            return count;
        }
        Map<Character, Integer> jMap = new HashMap<>(J.length());
        for (char c : J.toCharArray()) {
            jMap.put(c, 0);
        }
        for (char c : S.toCharArray()) {
            if (jMap.containsKey(c)) {
                jMap.put(c, jMap.get(c) + 1);
            }
        }
        for (char c : J.toCharArray()) {
            count += jMap.get(c);
        }
        return count;
    }
}
