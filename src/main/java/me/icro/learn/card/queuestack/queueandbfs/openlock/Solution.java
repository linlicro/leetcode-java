package me.icro.learn.card.queuestack.queueandbfs.openlock;

import java.util.*;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/873/
 *
 * @author Lin
 * @since 2019-10-02 9:51 AM
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        if (null == target)
            return 0;

        String root_string = "0000";
        int step = 0;
        LinkedList<List<String>> root = new LinkedList<>();
        Set<String> used = new HashSet<>(9999);
        if (null != deadends) {
            used.addAll(Arrays.asList(deadends));
        }
        root.addFirst(Collections.singletonList(root_string));
        while (!root.isEmpty()) {
            List<String> curs = root.pollFirst();
            List<String> next_roots = new ArrayList<>();
            for (String cur : curs) {
                if (used.contains(cur)) {
                    continue;
                }
                if (target.equals(cur)) {
                    return step;
                }
                used.add(cur);

                for (int i = 0; i < cur.length(); i++) {
                    char[] next_plus_chars = cur.toCharArray();
                    next_plus_chars[i] = plus_char(next_plus_chars[i]);
                    next_roots.add(String.valueOf(next_plus_chars));

                    char[] next_minus_chars = cur.toCharArray();
                    next_minus_chars[i] = minus_char(next_minus_chars[i]);
                    next_roots.add(String.valueOf(next_minus_chars));
                }
            }
            if (0 < next_roots.size()) {
                root.addFirst(next_roots);
            }
            step++;
        }
        return -1;
    }

    private char plus_char(char ch) {
        char next_char = (char) (ch + 1);
        if (':' == next_char)
            return '0';
        return next_char;
    }

    private char minus_char(char ch) {
        char next_char = (char) (ch - 1);
        if ('/' == next_char)
            return '9';
        return next_char;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));

        //System.out.println(new Solution().openLock(new String[]{"8888"}, "0009"));

        System.out.println(new Solution().openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));

        System.out.println(new Solution().openLock(new String[]{"0000"}, "8888"));
    }
}
