package me.icro.learn.card.hashtable.practicalapplicationhashset;

import java.util.*;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/hash-table/204/practical-application-hash-set/807/
 *
 * @author Lin
 * @since 2019-12-05 4:02 PM
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        //if (null == nums1 || null == nums2
        //        || 0 == nums1.length
        //        || 0 == nums2.length) {
        //    return new int[]{};
        //}
        //
        //Set<Integer> intersection = new HashSet<>();
        //Set<Integer> set = new HashSet<>();
        //
        //for (int i = 0; i < nums1.length; i++) {
        //    set.add(nums1[i]);
        //}
        //
        //for (int i = 0; i < nums2.length; i++) {
        //    if (set.contains(nums2[i])) {
        //        intersection.add(nums2[i]);
        //    }
        //}
        //
        //return intersection.stream().mapToInt(i -> i).toArray();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(nums1[i]);
        }
        for (int i : nums2) {
            set2.add(nums2[i]);
        }

        set1.retainAll(set2);

        return set1.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
