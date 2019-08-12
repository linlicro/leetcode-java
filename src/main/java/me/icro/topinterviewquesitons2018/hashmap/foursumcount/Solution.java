package me.icro.topinterviewquesitons2018.hashmap.foursumcount;

import java.util.HashMap;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-08-12 7:10 PM
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int i1 : B) {
                map.put(i + i1, map.getOrDefault(i + i1, 0) + 1);
            }
        }

        int res = 0;
        for (int i : C) {
            for (int i1 : D) {
                res += map.getOrDefault((-i - i1), 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new me.icro.topinterviewquesitons2018.foursumcount.Solution().fourSumCount(new int[] {1, 2},
                new int[] {-2, -1},
                new int[] {-1, 2},
                new int[] {0, 2}));
    }
}
