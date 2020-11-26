package me.icro.problems.t524findlongestword;

import java.util.Arrays;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/11/26
 **/
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String each : d) {
            int left = 0, right = 0;
            while (left < s.length() && right < each.length()) {
                if (s.charAt(left) == each.charAt(right)) {
                    left++;
                    right++;
                } else {
                    left++;
                }

                if (right == each.length()) {
                    if (each.length() > res.length()) {
                        res = each;
                    } else if (each.length() == res.length()) {
                        res = each.compareTo(res) > 0 ? res : each;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        System.out.println(new Solution().findLongestWord("bab", Arrays.asList("ba", "ab", "a", "b")));
    }
}
