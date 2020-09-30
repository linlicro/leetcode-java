package me.icro.problems.t4findmediansortedarrays;

/**
 * @author lin
 * @version v 0.1 2020/9/24
 **/
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Len = nums1.length, num2Len = nums2.length;
        int len = num1Len + num2Len;
        int left = 0, right = 0;
        int start1 = 0, start2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (start1 < num1Len && (start2 == num2Len || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }
        return (len & 1) == 0 ? (left + right) / 2.0 : right;
    }
}
