package me.icro.problems.t1300findbestvalue;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/9/26
 **/
public class Solution {
    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = findMaxValue(arr);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = sum(arr, mid);
            if (sum < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int sumOnLeftLeft = sum(arr, left - 1);
        int sumOnLeft = sum(arr, left);
        return (target - sumOnLeftLeft) <= (sumOnLeft - target) ? left - 1 : left;
    }

    private int sum(int[] arr, int mid) {
        int sum = 0;
        for (int each : arr) {
            sum += Math.min(each, mid);
        }
        return sum;
    }

    private int findMaxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int each : arr) {
            max = Math.max(each, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(new Solution().findBestValue(new int[]{2, 3, 5}, 10));
        System.out.println(new Solution().findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }
}
