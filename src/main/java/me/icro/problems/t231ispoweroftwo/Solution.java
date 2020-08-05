package me.icro.problems.t231ispoweroftwo;

/**
 * @author lin
 * @version v 0.1 2020/8/5
 **/
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
