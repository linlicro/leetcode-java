package me.icro.problems.t438findanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/9/3
 **/
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>(8);
        int total = 0;
        for (char c : p.toCharArray()) {
            total += c - 'a' + 1;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] chs = s.toCharArray();
        for (int i = 0, j = 0; j < chs.length; j++) {
            char cur = chs[j];
            if (map.containsKey(cur)) {
                total -= cur - 'a' + 1;
                map.put(cur, map.get(cur) - 1);
            }
            if (j - i == p.length()) {
                if (map.containsKey(chs[i])) {
                    total += chs[i] - 'a' + 1;
                    map.put(chs[i], map.get(chs[i]) + 1);
                }
                i++;
            }
            if (0 == total) {
                res.add(i);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution().findAnagrams("abab", "ab"));
        System.out.println(new Solution().findAnagrams("abab", ""));
    }
}
