package me.icro.problems.t1122relativesortarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/8/20
 **/
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> marks = new HashMap<>(arr2.length);
        for (int i : arr2) {
            marks.put(i, 0);
        }
        for (int i = 0; i < arr1.length; i++) {
            if (marks.containsKey(arr1[i])) {
                marks.put(arr1[i], marks.getOrDefault(arr1[i], 0) + 1);
                arr1[i] = 0;
            }
        }
        Arrays.sort(arr1);
        int index = 0;
        for (int value : arr2) {
            for (int j = 0; j < marks.get(value); j++) {
                arr1[index] = value;
                index++;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));

        System.out.println(Arrays.toString(new Solution().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{})));

        System.out.println(Arrays.toString(new Solution().relativeSortArray(new int[]{}, new int[]{})));
    }
}
