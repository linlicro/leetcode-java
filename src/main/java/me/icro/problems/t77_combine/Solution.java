package me.icro.problems.t77_combine;

import java.util.ArrayList;
import java.util.List;

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
        dfs(n, 1, new ArrayList<>(), k);
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

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
        System.out.println(new Solution().combine(2, 2));
    }
}
