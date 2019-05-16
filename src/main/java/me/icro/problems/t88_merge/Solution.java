package me.icro.problems.t88_merge;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-16 9:02 PM
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums1 || null == nums2) return;

        int index1 = 0;
        int index2 = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                // num1 右移1位
                System.arraycopy(nums1, index1, nums1, index1 + 1, (m - index1));
                nums1[index1] = nums2[index2];
                index1++;
                index2++;
                m++;
            }
        }

        if (index2 < n) {
            while (index2 < n) {
                nums1[index1] = nums2[index2];
                index1++;
                index2++;
            }
        }
    }
}
