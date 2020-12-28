package me.icro.lcof.o38permutation;

import java.util.*;

/**
 * @author lin
 * @version v 0.1 2020/12/28
 **/
public class Solution {
    Set<String> res = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    char[] chs;
    char[] curChs;
    int len = 0;

    public String[] permutation(String s) {
        chs = s.toCharArray();
        len = chs.length;
        curChs = new char[len];
        dfs(0);
        return res.toArray(new String[0]);
    }

    private void dfs(int level) {
        if (level == len) {
            res.add(String.valueOf(curChs));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (visited.contains(i) || set.contains(ch)) {
                continue;
            }
            curChs[level] = ch;
            visited.add(i);
            set.add(ch);
            dfs(level + 1);
            visited.remove(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().permutation("abc")));
        System.out.println(Arrays.toString(new Solution().permutation("aab")));
    }
}
