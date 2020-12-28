package me.icro.lcof.o40getleastnumbers;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/12/28
 **/
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
}
