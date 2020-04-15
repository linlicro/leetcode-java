package me.icro.leetcodingchallenge2004.productexceptself;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/4/15
 **/
public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = L[i] * R[i];
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution2().productExceptSelf(new int[]{0, 0})));
        System.out.println(Arrays.toString(new Solution2().productExceptSelf(new int[]{0, 1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution2().productExceptSelf(new int[]{0, 0, 1})));
    }
}
