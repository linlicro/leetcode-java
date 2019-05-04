package me.icro.problems.t242_isanagram;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-04 7:23 AM
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (null == s || null == t) return false;
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int each : counter) {
            if (each != 0)
                return false;
        }
        return true;
    }
}
