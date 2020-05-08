package me.icro.problems.t1403_minSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/5/8
 **/
public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int length = nums.length; length > 0; length--) {
            sum += nums[length - 1];
        }
        int tmp = 0;
        for (int length = nums.length; length > 0; length--) {
            tmp += nums[length - 1];
            res.add(nums[length - 1]);
            if (tmp > sum / 2) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubsequence(new int[]{4, 3, 10, 9, 8}));
        System.out.println(new Solution().minSubsequence(new int[]{4, 4, 7, 6, 7}));
        System.out.println(new Solution().minSubsequence(new int[]{6}));
    }
}
