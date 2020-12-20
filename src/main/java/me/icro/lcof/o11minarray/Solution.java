package me.icro.lcof.o11minarray;

/**
 * @author lin
 * @version v 0.1 2020/12/19
 **/
public class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().minArray(new int[]{2, 2, 2, 0, 1}));

        System.out.println(new Solution().minArray(new int[]{3, 3, 1, 3}));

    }
}
