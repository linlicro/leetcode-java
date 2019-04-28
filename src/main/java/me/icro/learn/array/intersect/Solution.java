package me.icro.learn.array.intersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 *
 * @author Lin
 * @since 2019-04-26 4:01 PM
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2) return new int[]{};

        if (nums1.length > nums2.length) {
            int temp_nums[] = nums1;
            nums1 = nums2;
            nums2 = temp_nums;
        }

        int[] intersection = new int[nums1.length];

        // Now num1 is smaller
        Arrays.sort(nums1);

        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            int num1_index = binarySearch(nums1, 0, nums1.length - 1 - index, nums2[i]);
            if (num1_index != -1) {
                intersection[index] = nums2[i];
                System.arraycopy(nums1, num1_index + 1, nums1, num1_index, nums1.length - num1_index - 1);
                index++;

                if (index == nums1.length) break;
            }
        }

        if (0 == index) return new int[] {};
        int[] result = new int[index];
        System.arraycopy(intersection, 0, result, 0, index);

        return result;
    }

    int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] num1 = new int[]{1, 2, 2, 1};
        //int[] num2 = new int[]{2, 2};
        //System.out.println(Arrays.toString(new Solution().intersect(num1, num2)));

        int[] num1_1 = new int[]{4, 9, 5};
        int[] num2_1 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new Solution().intersect(num1_1, num2_1)));
    }
}
