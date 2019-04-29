package me.icro.learn.array.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-04-29 11:12 AM
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
}
