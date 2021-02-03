package me.icro.problems.t39combinationsum;

import java.util.*;

/**
 * @author lin
 * @version v 0.1 2021/2/3
 **/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        help(list, target, candidates, new LinkedList<>(), 0);
        return list;
    }

    private void help(List<List<Integer>> res, int remainder, int[] candidates, LinkedList<Integer> list, int preCandidate) {
        if (0 == remainder) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int candidate : candidates) {
            if (remainder >= candidate && candidate >= preCandidate) {
                list.addLast(candidate);
                help(res, remainder - candidate, candidates, list, candidate);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res1 = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);;
        for (List<Integer> list : res1) {
            System.out.println(list);
        }
        System.out.println("");
        List<List<Integer>> res2 = new Solution().combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : res2) {
            System.out.println(list);
        }
    }
}
