package me.icro.lcof.o17printnumbers;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/12/21
 **/
public class Solution {
    public int[] printNumbers(int n) {
        int[] res = new int[count(n)];
        // 循环 位
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    private int count(int n) {
        int count = 0;
        while (n > 0) {
            count = count * 10 + 9;
            n--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().printNumbers(1)));
        System.out.println(Arrays.toString(new Solution().printNumbers(2)));
    }
}
