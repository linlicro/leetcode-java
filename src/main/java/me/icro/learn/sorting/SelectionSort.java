package me.icro.learn.sorting;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-08-04 12:51 PM
 */
public class SelectionSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < array.length; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (i != min) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }

        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(new SelectionSort().sort(new int[]{10, 5, 3, 1, 9})));
    }
}
