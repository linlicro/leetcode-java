package me.icro.leetcodingchallenge2004.singlenumber;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3283/
 *
 * @author lin
 * @version v 0.1 2020/4/1
 **/
public class Solution {
    public int singleNumber(int[] nums) {
        AtomicInteger singleNumber = new AtomicInteger();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }

        map.forEach((k, v) -> {
            if (1 == v) {
                singleNumber.set(k);
            }
        });
        return singleNumber.get();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[] {2, 2, 1}));
        System.out.println(new Solution().singleNumber(new int[] {4, 1, 2, 1, 2}));
    }
}
