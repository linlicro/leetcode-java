package me.icro.topinterviewquesitons2018.sortsearch.countsmaller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述: https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/270/sort-search/1173/
 *
 * @author Lin
 * @since 2019-08-28 4:43 PM
 */
public class Solution {
    /*超出时间限制 */
    public List<Integer> countSmaller(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int j = i + 1;
            int count = 0;
            while (j < nums.length) {
                if (nums[i] > nums[j]) {
                    count++;
                }
                j++;
            }
            list.add(count);
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(new Solution().countSmaller(new int[]{}));
        System.out.println(new Solution().countSmaller(new int[]{1}));
        System.out.println(new Solution().countSmaller(new int[]{2, 1}));
    }
}
