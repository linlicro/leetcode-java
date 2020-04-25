package me.icro.leetcodingchallenge2004.subarraysum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/4/22
 **/
public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new Solution().subarraySum(new int[]{1, 2, 3, 4, 6, 7, 8, 10}, 15));
    }
}
