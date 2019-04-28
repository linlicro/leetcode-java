package me.icro.problems.t350_intersect;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 描述:
 *  first sort the two arrays, then we can use two points.
 *
 * @author Lin
 * @since 2019-04-28 11:23 AM
 */
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2) return new int[]{};

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        while (i < list.size()) {
            result[i] = list.get(i);
            i++;
        }
        return result;
    }
}
