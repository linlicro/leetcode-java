package me.icro.problems.t191hammingweight;

/**
 * @author lin
 * @version v 0.1 2020/8/5
 **/
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
    }
}
