package me.icro.topinterviewquesitons2018.beforeyoustart.majorityelement;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: https://leetcode-cn.com/explore/featured/card/top-interview-quesitons-in-2018/261/before-you-start/1107/
 *
 * @author Lin
 * @since 2019-05-24 9:09 AM
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (null == nums || 0 == nums.length) return -1;
        Map<Integer, Integer> num_count_map = new HashMap<>();
        int majority_element_tmp = nums[0];
        int majority_element_tmp_count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (num_count_map.containsKey(nums[i])) {
                num_count_map.replace(nums[i], num_count_map.get(nums[i]) + 1);
                if (majority_element_tmp_count < num_count_map.get(nums[i])) {
                    majority_element_tmp_count = num_count_map.get(nums[i]);
                    majority_element_tmp = nums[i];
                }
            } else {
                num_count_map.put(nums[i], 1);
            }
        }
        return majority_element_tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{1}));
        System.out.println(new Solution().majorityElement(new int[]{3, 3, 4}));
        System.out.println(new Solution().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
