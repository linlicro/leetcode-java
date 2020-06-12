package me.icro.problems.t127ladderlength;

import java.util.*;

/**
 * @author lin
 * @version v 0.1 2020/6/12
 **/
public class Solution {

    int res = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 超出时间限制
        if (null == wordList || 0 == wordList.size()) {
            return res;
        }
        Set<String> used = new HashSet<>();
        dfs(beginWord, endWord, wordList, used, 0);
        return Integer.MAX_VALUE == res ? 0 : res + 1;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, Set<String> used, int level) {
        if (beginWord.equals(endWord)) {
            res = Math.min(level, res);
            return;
        }
        for (String word : wordList) {
            if (used.contains(word)) {
                continue;
            }
            int diffCharCount = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (beginWord.charAt(i) != chars[i]) {
                    diffCharCount++;
                }
                if (diffCharCount > 1) {
                    break;
                }
            }
            if (1 == diffCharCount) {
                used.add(word);
                dfs(word, endWord, wordList, used, level + 1);
                used.remove(word);
            }
        }
    }

}
