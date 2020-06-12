package me.icro.problems.t127ladderlength;

import java.util.*;

/**
 * bfs
 * @author lin
 * @version v 0.1 2020/6/12
 **/
public class Solution2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        if (null == wordList || 0 == wordList.size()) {
            return res;
        }
        Set<String> used = new HashSet<>();
        Deque<List<String>> deque = new LinkedList<>();
        // 第一层数据 - 开始单词
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        deque.addFirst(list);
        used.add(beginWord);
        // bfs
        while (!deque.isEmpty()) {
            res++;
            // 邻居-单词
            List<String> curLevelStrings = deque.pollFirst();
            List<String> nexts = new ArrayList<>();
            for (String cur : curLevelStrings) {
                // 找到最近路径
                if (cur.equals(endWord)) {
                    return res;
                }
                for (String word : wordList) {
                    int diffCharCount = 0;
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        if (cur.charAt(i) != chars[i]) {
                            diffCharCount++;
                        }
                        if (diffCharCount > 1) {
                            break;
                        }
                    }
                    if (1 == diffCharCount && !used.contains(word)) {
                        nexts.add(word);
                        used.add(word);
                    }
                }
            }
            if (0 != nexts.size()) {
                deque.addFirst(nexts);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(new Solution2().ladderLength("hit", "cog", wordList));
    }
}
