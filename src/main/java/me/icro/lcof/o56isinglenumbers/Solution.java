package me.icro.lcof.o56isinglenumbers;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/12/31
 **/
public class Solution {
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];

        int diffOrNum = 0;
        for (int value : nums) {
            diffOrNum ^= value;
        }

        int flag = 1;
        while ((diffOrNum & flag) == 0) {
            flag <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & flag) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        res[0] = a;
        res[1] = b;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumbers(new int[]{1, 2, 5, 2})));
    }
}
