package me.icro.learn.dynamic.climbstairs;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/54/
 * <p>
 * 解题思路:
 * <p>
 * 1. 走到第十个楼梯的走法 = 走到第八个楼梯 + 走到第九个楼梯
 * f(10) = f(9) + f(8)
 * ...
 * when n = 1, f(1) = 1
 * n = 2, f(2) = 2
 * <p>
 * 时间复杂度为O(2^n)
 * <p>
 * 2. 改进: 备忘录算法 ==> 空间复杂度为O(n),时间复杂度也为O(n)
 * <p>
 * 3. 动态规划方法
 * 变量a保存倒数第二子状态的数据,变量b保存倒数第一的子状态的数据
 * res = a + b
 *
 * @author Lin
 * @since 2019-05-20 9:45 AM
 */
public class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return climbStairs_inner(n, cache);
    }

    int climbStairs_inner(int n, Map<Integer, Integer> cache) {
        if (2 >= n)
            return n;

        if (cache.containsKey(n))
            return cache.get(n);

        int value = climbStairs_inner(n - 1, cache) + climbStairs_inner(n - 2, cache);
        cache.put(n, value);
        return value;
    }

    public int climbStairs1(int n) {

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
