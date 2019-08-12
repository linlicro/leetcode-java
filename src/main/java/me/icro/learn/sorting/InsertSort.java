package me.icro.learn.sorting;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-08-10 3:19 PM
 */
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && tmp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(new InsertSort().sort(new int[]{10, 5, 3, 1, 9})));
    }
}
