package me.icro.leetcodingchallenge2004.countelements;

import java.util.HashSet;

/**
 * @author lin
 * @version v 0.1 2020/4/7
 **/
public class Solution {
    public int countElements(int[] arr) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>(arr.length);
        for (int i : arr) {
            set.add(i);
        }
        for (int i : arr) {
            if (set.contains(i + 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countElements(new int[]{1, 2, 3}));
        System.out.println(new Solution().countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}));
        System.out.println(new Solution().countElements(new int[]{1, 3, 2, 3, 5, 0}));
        System.out.println(new Solution().countElements(new int[]{1, 1, 2, 2}));
    }
}
