package me.icro.problems.t3lengthoflongestsubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lin
 * @version v 0.1 2020/11/16
 **/
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int res, left, right;
        res = left = right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            Character ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution2().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution2().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution2().lengthOfLongestSubstring(""));
        System.out.println(new Solution2().lengthOfLongestSubstring("dvdf"));
        System.out.println(new Solution2().lengthOfLongestSubstring("tmmzuxt"));
    }
}
