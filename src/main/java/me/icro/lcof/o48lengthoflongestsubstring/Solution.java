package me.icro.lcof.o48lengthoflongestsubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lin
 * @version v 0.1 2021/1/28
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        int maxLen = 1;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            while (set.contains(ch)) {
                set.remove(chs[left++]);
            }
            right++;
            maxLen = Math.max(maxLen, right - left);
            set.add(ch);
        }

        return maxLen;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring(" "));
        System.out.println(new Solution().lengthOfLongestSubstring("ab"));
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }
}
