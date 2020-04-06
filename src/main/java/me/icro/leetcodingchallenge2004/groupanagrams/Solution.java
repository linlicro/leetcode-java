package me.icro.leetcodingchallenge2004.groupanagrams;

import java.util.*;

/**
 * 思路: 当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
 *
 * @author lin
 * @version v 0.1 2020/4/6
 **/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"", ""}));
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
