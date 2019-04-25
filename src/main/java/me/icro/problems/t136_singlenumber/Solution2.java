package me.icro.problems.t136_singlenumber;

/**
 * 描述:
 *  Bit Manipulation
 *
 * @author Lin
 * @since 2019-04-26 7:44 AM
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        int i = 0;
        for (int num : nums) {
            i ^= num;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        System.out.println(new Solution2().singleNumber(nums));
        int[] nums2 = new int[]{4, 1, 2, 1, 2};
        System.out.println(new Solution2().singleNumber(nums2));
    }
}
