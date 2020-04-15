package me.icro.leetcodingchallenge2004.productexceptself;

import java.util.Arrays;

/**
 * @author lin
 * @version v 0.1 2020/4/15
 **/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int productOfAll = 1;
        int countZero = 0;
        int indexFirstZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                countZero++;
                if (1 == countZero) {
                    indexFirstZero = i;
                }
                continue;
            }
            productOfAll *= nums[i];
        }
        if (1 < countZero) {
            return output;
        }
        if (1 == countZero) {
            output[indexFirstZero] = productOfAll;
            return output;
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = productOfAll / nums[i];
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{0, 0})));
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{0, 1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{0, 0, 1})));
    }
}
