package me.icro.problems.t172trailingzeroes;

/**
 * 问题转化为：n! 最多可以分解出多少个因子 5？
 *
 * @author lin
 * @version v 0.1 2020/10/29
 **/
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
