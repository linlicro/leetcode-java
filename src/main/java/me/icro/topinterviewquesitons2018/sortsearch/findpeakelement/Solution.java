package me.icro.topinterviewquesitons2018.sortsearch.findpeakelement;

/**
 * 描述: https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/270/sort-search/1171/
 *
 *  时间复杂度 : O(n)O(n)。 我们对长度为 nn 的数组 numsnums 只进行一次遍历。
 *
 * @author Lin
 * @since 2019-08-20 5:18 PM
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (null == nums || 0 == nums.length)
            return -1;

        if (1 == nums.length)
            return 0;

        if (nums[1] < nums[0])
            return 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1]
                    && nums[i] > nums[i + 1])
                return i;
        }

        return nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPeakElement(new int[] {1,2,3,1}));
        System.out.println(new Solution().findPeakElement(new int[] {1,2,1,3,5,6,4}));
        System.out.println(new Solution().findPeakElement(new int[] {1,2}));
        System.out.println(new Solution().findPeakElement(new int[] {1,2,3}));
        System.out.println(new Solution().findPeakElement(new int[] {3,2,1}));
    }
}
