package me.icro.learn.design.shuffleanarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * 描述: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/58/
 *
 * @author Lin
 * @since 2019-05-24 8:48 AM
 */
public class Solution {

    private int[] origin_nums;
    Random rnd = new Random();

    public Solution(int[] nums) {
        origin_nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin_nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (null == origin_nums) return null;

        int[] random_nums = new int[origin_nums.length];
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < origin_nums.length; i++) {
            int index = rnd.nextInt(random_nums.length);
            while (hashSet.contains(index)) {
                index = rnd.nextInt(random_nums.length);
            }
            hashSet.add(index);
            random_nums[i] = origin_nums[index];
        }
        return random_nums;
    }


    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        for (int i = 0; i < 100; i++) {
            System.out.println(Arrays.toString(solution.shuffle()));
        }
    }
}
