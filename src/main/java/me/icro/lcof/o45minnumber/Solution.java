package me.icro.lcof.o45minnumber;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/12/29
 **/
public class Solution {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strings) {
            res.append(s);
        }
        return res.toString();
    }
}
