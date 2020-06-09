package me.icro.problems.t169_majorityelement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 描述: https://leetcode.com/problems/majority-element/
 *
 * @author Lin
 * @since 2019-05-25 9:36 PM
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

    public int majorityElement2(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> integerLongEntry : map.entrySet()) {
            if (integerLongEntry.getValue() > limit) {
                return integerLongEntry.getKey();
            }
        }
        return -1;
    }

    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
