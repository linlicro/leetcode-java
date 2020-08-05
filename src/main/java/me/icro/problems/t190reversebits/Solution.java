package me.icro.problems.t190reversebits;

/**
 * @author lin
 * @version v 0.1 2020/8/5
 **/
public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + (n & 1);
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
    }
}
