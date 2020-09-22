package me.icro.problems.t852peakindexinmountainarray;

/**
 * @author lin
 * @version v 0.1 2020/9/22
 **/
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == left && mid == right) {
                return mid;
            }
            if (mid == left || mid == right) {
                return arr[left] > arr[right] ? left : right;
            }
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(new Solution().peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(new Solution().peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }
}
