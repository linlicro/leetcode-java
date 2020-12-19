package me.icro.lcof.o03findrepeatnumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lin
 * @version v 0.1 2020/12/19
 **/
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
