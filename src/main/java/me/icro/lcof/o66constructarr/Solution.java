package me.icro.lcof.o66constructarr;

/**
 * @author lin
 * @version v 0.1 2021/1/1
 **/
public class Solution {
    public int[] constructArr(int[] a) {
        if(a.length == 0) {
            return new int[0];
        }
        int len = a.length;
        int[] b = new int[len];
        b[0] = 1;
        for (int i = 1; i < len; i++) {
            b[i] = a[i - 1] * b[i - 1];
        }
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
