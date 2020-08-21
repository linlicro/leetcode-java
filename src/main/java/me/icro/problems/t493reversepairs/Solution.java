package me.icro.problems.t493reversepairs;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/8/21
 **/
public class Solution {
    int[] temp;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int cnt = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        merge(nums, left, mid, right);
        return cnt;
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int tempIndex = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[tempIndex++] = arr[i++];
            } else {
                temp[tempIndex++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[tempIndex++] = arr[i++];
        }
        while (j <= right) {
            temp[tempIndex++] = arr[j++];
        }
        tempIndex = 0;
        while (left <= right) {
            arr[left++] = temp[tempIndex++];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reversePairs(new int[]{1, 3, 2, 3, 1}));
    }
}
