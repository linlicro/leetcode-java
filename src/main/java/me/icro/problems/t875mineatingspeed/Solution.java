package me.icro.problems.t875mineatingspeed;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/9/27
 **/
public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 0;
//        int right = maxValueInPiles(piles);
        int right = 1_000_000_000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int tmpH = hours(piles, mid);
            if (tmpH > H) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int hours(int[] piles, int tmpK) {
        int h = 0;
        for (int pile : piles) {
            h += (int) Math.ceil((double) pile / tmpK);
        }
        return h;
    }

    private int maxValueInPiles(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(new Solution().minEatingSpeed(new int[]{3, 6, 7, 11, 20}, 8));
        System.out.println(new Solution().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(new Solution().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}
