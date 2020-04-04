package me.icro.leetcodingchallenge2004.movezeroes;

/**
 * @author lin
 * @version v 0.1 2020/4/4
 **/
public class Solution {
    public void moveZeroes(int[] nums) {
        int count_zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                count_zero++;
                continue;
            }
            if (count_zero > 0) {
                nums[i - count_zero] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
