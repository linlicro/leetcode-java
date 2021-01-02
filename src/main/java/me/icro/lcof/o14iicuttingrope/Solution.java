package me.icro.lcof.o14iicuttingrope;

/**
 * @author lin
 * @version v 0.1 2021/1/2
 **/
public class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        int p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a--) {
            rem = (rem * x) % p;
        }
        if (0 == b) {
            return (int) (rem * 3 % p);
        }
        if (1 == b) {
            return (int) (rem * 4 % p);
        }
        return (int) (rem * 6 % p);
    }
}
