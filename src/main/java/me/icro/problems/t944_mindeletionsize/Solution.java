package me.icro.problems.t944_mindeletionsize;

/**
 * @author lin
 * @version v 0.1 2020/3/27
 **/
public class Solution {
    public int minDeletionSize(String[] A) {
        int res = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
