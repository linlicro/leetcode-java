package me.icro.problems.t658findclosestelements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/12/15
 **/
public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int xRightIndex = findXsRightIndex(arr, x);
        int left = xRightIndex;
        int right = xRightIndex + 1;
        while (k > res.size()) {
            // 是否越界
            if (left < 0) {
                res.add(arr[right++]);
                continue;
            }
            if (right >= arr.length) {
                res.add(0, arr[left--]);
                continue;
            }
            int diffLeft = Math.abs(arr[left] - x);
            int diffRight = Math.abs(arr[right] - x);
            if (diffLeft < diffRight) {
                res.add(0, arr[left--]);
                continue;
            }
            if (diffLeft > diffRight) {
                res.add(arr[right++]);
                continue;
            }
            res.add(0, arr[left--]);
        }
        return res;
    }

    private int findXsRightIndex(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid]) {
                left = mid + 1;
            } else if (x > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.max(right, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));

        System.out.println(new Solution().findClosestElements(new int[]{1, 2, 3, 4, 4, 4, 5}, 4, 3));

        System.out.println(new Solution().findClosestElements(new int[]{1, 2, 2, 3, 3, 4, 4, 5}, 4, 3));

        System.out.println(new Solution().findClosestElements(new int[]{1, 2, 2, 3, 3, 4, 4, 5}, 4, -1));

        System.out.println(new Solution().findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
    }
}
