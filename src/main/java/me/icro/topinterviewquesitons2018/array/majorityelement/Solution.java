package me.icro.topinterviewquesitons2018.array.majorityelement;

import java.util.HashMap;

/**
 * 描述: https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/264/array/1127/
 *
 * @author Lin
 * @since 2019-08-07 2:34 PM
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (null == nums || 0 == nums.length)
            throw new IllegalArgumentException();

        int result = nums[0];
        int cnt_max = 1;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length / 2);
        map.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int cnt_tmp = map.get(nums[i]);
            if (cnt_tmp > cnt_max) {
                cnt_max = cnt_tmp;
                result = nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().majorityElement(new int[]{3}));
        System.out.println(new Solution().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new Solution().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
