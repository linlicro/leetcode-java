package me.icro.lcof.o64sumnums;

/**
 * @author lin
 * @version v 0.1 2021/1/1
 **/
public class Solution {
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
