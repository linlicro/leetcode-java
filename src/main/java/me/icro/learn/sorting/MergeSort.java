package me.icro.learn.sorting;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/8/21
 **/
public class MergeSort {

    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private void sort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        sort(arr, left, mid, temp);
        sort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
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
        System.out.println(Arrays.toString(temp));
//        tempIndex = 0;
//        while (left <= right) {
//            arr[left++] = temp[tempIndex++];
//        }
        Arrays.sort(arr, left,  (right - left) + 1);
    }

    public static void main(String[] args) {
        new MergeSort().sort(new int[] {8, 4, 5, 7, 1, 3, 6, 2});
    }
}
