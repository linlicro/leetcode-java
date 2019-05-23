package me.icro.learn.dynamic.rob;

/**
 * 描述: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/57/
 * <p>
 * 考察点: 当前节点处最大值curMax = Math.max(curMax, curPrePreMax + cur)。
 * <p>
 * 如果数组长度为1，那么直接返回数组唯一项。
 * 如果数组长度为2，那么返回“第1项”和“第2项”的较大者。
 * 如果数组长度为3，那么返回“数组长度为1的结果+第3项”与“数组长度为2的结果”的较大者。
 * 如果数组长度为4，那么返回“数组长度为2的结果+第4项”与“数组长度为3的结果”的较大者。
 *
 * @author Lin
 * @since 2019-05-23 9:31 AM
 */
public class Solution {
    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) return 0;
        if (1 == nums.length) return nums[0];

        int pre_pre_max = nums[0];
        int cur_max = Math.max(pre_pre_max, nums[1]);
        int temp = 0;
        for (int i = 2; i < nums.length; i++) {
            temp = cur_max;
            cur_max = Math.max(cur_max, pre_pre_max + nums[i]);
            pre_pre_max = temp;
        }
        return cur_max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new Solution().rob(new int[]{2, 1, 1, 2}));
    }
}
