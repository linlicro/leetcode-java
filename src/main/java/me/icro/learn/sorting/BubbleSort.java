package me.icro.learn.sorting;

import java.util.Arrays;

/**
 * 描述: 冒泡排序
 *
 * @author Lin
 * @since 2019-08-03 1:51 PM
 */
public class BubbleSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }

        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(new BubbleSort().sort(new int[]{3, 5, 1, 10, 8})));
    }
}
