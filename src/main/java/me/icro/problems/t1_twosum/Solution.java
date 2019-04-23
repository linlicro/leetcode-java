package me.icro.problems.t1_twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lin on 2019/3/4.
 * <p>
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 11, 7, 25}, 9)));
    }

}
