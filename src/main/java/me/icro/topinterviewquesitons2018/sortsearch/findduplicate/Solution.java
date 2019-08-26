package me.icro.topinterviewquesitons2018.sortsearch.findduplicate;

import java.util.HashMap;

/**
 * 描述: https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/270/sort-search/1172/
 *
 * @author Lin
 * @since 2019-08-26 7:40 PM
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        if (null == nums || 1 >= nums.length)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                return num;
            map.put(num, num);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[] {1,3,4,2,2}));
    }
}
