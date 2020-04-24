package me.icro.leetcodingchallenge2004.rangebitwiseand;

/**
 * @author lin
 * @version v 0.1 2020/4/23
 **/
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= (n - 1);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(5, 7));
    }
}
