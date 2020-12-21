package me.icro.lcof.o15hammingweight;

/**
 * @author lin
 * @version v 0.1 2020/12/21
 **/
public class Solution {

    public int hammingWeight(int n) {
        int count = 0;
        while (0 != n) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
    }
}
