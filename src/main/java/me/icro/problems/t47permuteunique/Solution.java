package me.icro.problems.t47permuteunique;

import java.util.*;

/**
 * @author lin
 * @version v 0.1 2020/6/5
 **/
public class Solution {
    Set<String> usedPaths = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == nums) {
            return res;
        }
        int len = nums.length;
        if (0 == len) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, len, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (usedPaths.contains(path.toString())) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, depth, path, used, res);
            usedPaths.add(path.toString());
            path.pollLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[] {1, 1, 2}));
    }
}
