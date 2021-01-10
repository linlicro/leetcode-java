package me.icro.problems.t45jump;

/**
 * @author lin
 * @version v 0.1 2021/1/10
 **/
public class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
