package me.icro.problems.t88_merge;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-16 9:02 PM
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1, 0, m + n);
    }
}
