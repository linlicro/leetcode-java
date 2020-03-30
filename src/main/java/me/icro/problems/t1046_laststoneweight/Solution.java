package me.icro.problems.t1046_laststoneweight;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/3/27
 **/
public class Solution {
    public int lastStoneWeight(int[] stones) {
        int index = stones.length;
        for (int i = 0; i < stones.length - 1; i++) {
            Arrays.sort(stones);
            stones[index - 1] -= stones[index - 2];
            stones[index - 2] = 0;
        }
        return stones[stones.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lastStoneWeight(new int[] { 1, 3, 2 }));
    }
}
