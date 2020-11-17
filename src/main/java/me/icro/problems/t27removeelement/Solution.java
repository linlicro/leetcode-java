package me.icro.problems.t27removeelement;

/**
 * @author lin
 * @version v 0.1 2020/11/17
 **/
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (val == nums[i]) {
                nums[i] = nums[--len];
                i--;
            }
        }
        return len;
    }
}
