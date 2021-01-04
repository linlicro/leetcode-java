package me.icro.lcof.o56iisinglenumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2021/1/4
 **/
public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 +  1);
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) >= 2) {
                map.remove(num);
                continue;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer num : map.keySet()) {
            return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[] {1, 1, 6, 1}));
    }
}
