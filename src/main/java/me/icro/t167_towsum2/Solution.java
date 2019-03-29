package me.icro.t167_towsum2;

import java.util.Arrays;

/**
 * Created by Lin on 2019/3/5.
 * <p>
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 对撞指针
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left_index = 0, right_index = numbers.length - 1;
        while (left_index < right_index) {
            if (numbers[left_index] + numbers[right_index] == target) {
                return new int[]{
                        left_index + 1, right_index + 1
                };
            } else if (numbers[left_index] + numbers[right_index] < target) {
                left_index++;
            } else {
                right_index--;
            }

        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 25}, 9)));
    }
}
