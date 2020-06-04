package me.icro.problems.t77_combine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lin
 * @version v 0.1 2020/6/4
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1) {
            return result;
        }
        if (k > n) {
            return result;
        }
//        dfs(n, 1, new ArrayList<>(), k);
        find(n, k, 1, new Stack<>());
        return result;
    }

    void dfs(int max, int cur, List<Integer> list, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (cur > max) {
            return;
        }
        // no pick
        dfs(max, cur + 1, list, k);
        // pick
        list.add(cur);
        dfs(max, cur + 1, list, k);

        // remove
        list.remove(list.size() - 1);
    }

    void find(int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            result.add(new ArrayList<>(pre));
            return;
        }
        for (int i = begin; i <= n - (k - pre.size()) + 1; i++) {
            pre.add(i);
            find(n, k, i + 1, pre);
            pre.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
        System.out.println(new Solution().combine(2, 2));
    }
}
