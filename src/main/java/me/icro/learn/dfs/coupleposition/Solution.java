package me.icro.learn.dfs.coupleposition;

import java.util.*;

/**
 *
 * n对夫妻，n*2 个位置(一排)，夫妻要做在一起，有多少种方案？
 *
 * @author lin
 * @version v 0.1 2020/12/28
 **/
public class Solution {
    List<String> res = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    int[] positions;
    public int couplePosition(int n) {
        if (1 >= n) {
            return n;
        }
        positions = new int[n * 2];
        dfs(0, n);
        return res.size();
    }

    public int couplePositionWithoutPair(int n) {
        if (1 >= n) {
            return n;
        }
        positions = new int[n * 2];
        dfs2(0, n * 2);
        return res.size();
    }

    private void dfs(int level, int couple) {
        if (level == couple) {
            System.out.println(Arrays.toString(positions));
            res.add(Arrays.toString(positions));
        }
        for (int i = 0; i < couple; i++) {
            if (visited.contains(i)) {
                continue;
            }
            positions[level * 2] = i;
            positions[level * 2 + 1] = i;
            visited.add(i);
            dfs(level + 1, couple);
            visited.remove(i);
        }
    }

    private void dfs2(int level, int person) {
        if (level == person) {
            System.out.println(Arrays.toString(positions));
            res.add(Arrays.toString(positions));
        }
        for (int i = 0; i < person; i++) {
            if (visited.contains(i)) {
                continue;
            }
            positions[level] = i / 2 + 1 ;
            visited.add(i);
            dfs2(level + 1, person);
            visited.remove(i);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().couplePosition(3));
        System.out.println(new Solution().couplePositionWithoutPair(3));
    }
}
