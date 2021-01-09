package me.icro.problems.t128longestconsecutive;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lin
 * @version v 0.1 2021/1/9
 **/
public class Solution {

    public int longestConsecutive(int[] nums) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (Integer each : set) {
            int curCount = 1;
            int curNum = each;

            while (set.contains(curNum + 1)) {
                curCount++;
                curNum++;
            }

            count = Math.max(count, curCount);
        }

        return count;
    }
}
