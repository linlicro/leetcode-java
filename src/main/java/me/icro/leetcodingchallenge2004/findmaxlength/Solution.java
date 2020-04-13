package me.icro.leetcodingchallenge2004.findmaxlength;

import java.util.HashMap;

/**
 * @author lin
 * @version v 0.1 2020/4/13
 **/
public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (hm.containsKey(sum)) {
                res = Math.max(res, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[]{0}));
        System.out.println(new Solution().findMaxLength(new int[]{0, 1}));
        System.out.println(new Solution().findMaxLength(new int[]{0, 1, 0, 1, 0, 1}));
        System.out.println(new Solution().findMaxLength(new int[]{0, 0, 1}));
        System.out.println(new Solution().findMaxLength(new int[]{0, 0, 0, 1, 1, 1, 0}));
        System.out.println(new Solution().findMaxLength(new int[]{0, 1, 0, 0, 1, 0, 1, 0, 1}));
//        [0,0,1,0,0,0,1,1]
        System.out.println(new Solution().findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }
}
