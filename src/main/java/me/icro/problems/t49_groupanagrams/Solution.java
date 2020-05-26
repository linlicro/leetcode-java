package me.icro.problems.t49_groupanagrams;

import java.util.*;

/**
 * @author lin
 * @version v 0.1 2020/5/26
 **/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            String key = String.valueOf(chars);
            Arrays.sort(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
