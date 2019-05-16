package me.icro.learn.sortandsearch.merge;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/52/
 *
 * @author Lin
 * @since 2019-05-16 8:39 PM
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums1 || null == nums2) return;

        int index1 = 0;
        int index2 = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
                continue;
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

    public static void main(String[] args) {
        new Solution().merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
    }
}
