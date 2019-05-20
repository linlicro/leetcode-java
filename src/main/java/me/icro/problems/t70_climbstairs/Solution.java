package me.icro.problems.t70_climbstairs;

/**
 * 描述: https://leetcode.com/problems/climbing-stairs/
 *
 * @author Lin
 * @since 2019-05-20 3:10 PM
 */
public class Solution {
    public int climbStairs(int n) {
        if (0 > n) return 0;
        if (2 >= n)
            return n;

        int a = 1;
        int b = 2;
        int temp = a + b;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
