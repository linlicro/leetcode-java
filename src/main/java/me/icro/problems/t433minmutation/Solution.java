package me.icro.problems.t433minmutation;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lin
 * @version v 0.1 2020/6/9
 **/
public class Solution {
    int count = Integer.MAX_VALUE;
    Set<String> used = new HashSet<>();

    public int minMutation(String start, String end, String[] bank) {
        used.add(start);
        dfs(start, end, bank, 0);
        return Integer.MAX_VALUE == count ? -1 : count;
    }

    private void dfs(String start, String end, String[] bank, int level) {
        // terminator
        if (start.equals(end)) {
            count = Math.min(count, level);
        }
        for (String s : bank) {
            if (used.contains(s)) {
                continue;
            }

            // check 是否是合理的变异
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (start.charAt(i) != s.charAt(i)) {
                    if (++diff > 1) {
                        break;
                    }
                }
            }
            // 下一层
            if (1 == diff) {
                used.add(s);
                dfs(s, end, bank, level + 1);
                used.remove(s);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(new Solution().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "CAACGGTA"}));
    }

    public int minMutation2(String start, String end, String[] bank) {
        // bfs
        return Integer.MAX_VALUE == count ? -1 : count;
    }

}
