package me.icro.problems.t1482mindays;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/9/28
 **/
public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (m * k)) {
            return -1;
        }
        int left = 0;
        int right = Arrays.stream(bloomDay).max().orElse(-1);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int tmpM = getCount(bloomDay, mid, k);
            if (tmpM >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getCount(int[] bloomDay, int day, int k) {
        int re = 0;
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                re++;
                count = 0;
            }
        }
        return re;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
//        System.out.println(new Solution().minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
//        System.out.println(new Solution().minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
//        System.out.println(new Solution().minDays(new int[]{1000000000, 1000000000}, 1, 1));
//        System.out.println(new Solution().minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
//        [1,2,4,9,3,4,1]
//        2
//        2
        System.out.println(new Solution().minDays(new int[]{1,2,4,9,3,4,1}, 2, 2));
    }

}
