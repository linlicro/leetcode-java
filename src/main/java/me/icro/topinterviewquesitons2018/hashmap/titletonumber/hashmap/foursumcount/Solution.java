package me.icro.topinterviewquesitons2018.hashmap.titletonumber.hashmap.foursumcount;

import java.util.HashMap;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/268/hash-map/1163/
 *
 * @author Lin
 * @since 2019-07-29 1:24 PM
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
        System.out.println(new Solution().fourSumCount(new int[] {1, 2},
                new int[] {-2, -1},
                new int[] {-1, 2},
                new int[] {0, 2}));
    }
}
