package me.icro.problems.t338countbits;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/8/7
 **/
public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = countBit(i);
        }
        return result;
    }

    private int countBit(int x) {
        int count = 0;
        while (x != 0) {
            count++;
            x &= x - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(5)));
    }
}
