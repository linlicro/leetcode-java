package me.icro.topinterviewquesitons2018.string.wordbreak;

import java.util.*;

/**
 * 描述:
 * <p>
 * 思路: DP
 *
 * @author Lin
 * @since 2019-07-31 11:16 AM
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] pos = new int[s.length() + 1];
        Arrays.fill(pos, -1);
        pos[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (1 == pos[j] && wordDict.contains(s.substring(j, i))) {
                    pos[i] = 1;
                    break;
                }
            }
        }

        return pos[s.length()] != -1;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(new Solution().wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
        System.out.println(new Solution().wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
        System.out.println(new Solution().wordBreak("ccbb", new ArrayList<>(Arrays.asList("bc", "cb"))));
        System.out.println(new Solution().wordBreak("ccaccc", new ArrayList<>(Arrays.asList("cc", "ac"))));

        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))));
        System.out.println(new Solution().wordBreak("aaaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aaa"))));
    }
}
